package tpFallas.knowledge

import tpFallas.frame.Adiccion;
import tpFallas.frame.Entrevista;
import tpFallas.frame.Madre;
import tpFallas.frame.Nino;
import tpFallas.frame.NuevaPareja;
import tpFallas.frame.Padre;
import tpFallas.frame.Relacion;
import tpFallas.frame.ViolenciaFamiliar;
import tpFallas.frame.Vivienda;
import tpFallas.knowledge.KnowledgeBase;

class EvaluadorService {

		KnowledgeBase knowledgeBase;
	
		public EvaluadorService(KnowledgeBase knowledgeBase) {
			this.knowledgeBase = knowledgeBase;
		}
	
		public boolean permitirPadrePasarNocheConHijo() {

			double evaluacionPadre = evaluarPadre();
			double evaluacionNuevaPareja = evaluarNuevaPareja();
			double evaluacionMadre = evaluarMadre();
			double evaluacionVivienda = evaluarVivienda();
			double evaluacionNino = evaluarNino();
			double fragilidadNino = evaluarFragilidadNino();

			if( evaluacionPadre < 0.0)
				evaluacionPadre *= (1 + fragilidadNino * 0.2);
			if( evaluacionVivienda < 0.0)
				evaluacionVivienda *= (1 + fragilidadNino * 0.2);
			if( evaluacionMadre < 0.0)
				evaluacionMadre *= (1 + fragilidadNino * 0.2);
			if( evaluacionNuevaPareja < 0.0)
				evaluacionNuevaPareja *= (1 + fragilidadNino * 0.1);

				
			double evaluacionTotal = 0.3 * evaluacionPadre + 0.1 * evaluacionNuevaPareja - 0.1 * evaluacionMadre + 
					0.2 * evaluacionVivienda + 0.3 * evaluacionNino;

			return evaluacionTotal > 0.0;

		}

		private double evaluarFragilidadNino() {
			Nino nino = knowledgeBase.getNino();
			double evaluacion = 0.0;
			if( nino.getEdad() < 3)
				evaluacion += 1.0;
			evaluacion += nino.getDiscapacidad();
			return evaluacion;
		}

		private double evaluarNino() {

			Nino nino = knowledgeBase.getNino();
			NuevaPareja nuevaPareja = knowledgeBase.getNuevaPareja();
			double evaluacion = 0.0;

			for( Relacion relacion : nino.getRelaciones()){
				if( ( relacion.getHacia()) instanceof Padre )
						evaluacion += 3.0 * relacion.getValor();
				else if ( ( relacion.getHacia()) instanceof NuevaPareja ){
					if( nuevaPareja != null) {
						if( nuevaPareja.getViveConElPadre())
							evaluacion += 2.0 * relacion.getValor();
						else
							evaluacion += 0.5 * relacion.getValor();
					}
				} else if( (relacion.getHacia()) instanceof Madre) {
					if( relacion.getValor() < 0)
						evaluacion -= 2.0 * relacion.getValor();
				}

			}

			return evaluacion;
		}

		private double evaluarVivienda() {
			double evaluacion = 0;
			Vivienda vivienda = knowledgeBase.getVivienda();
			if (vivienda.getHabitacionDelNino())
				evaluacion += 1.0;
			else
				evaluacion -= 1.0;
			switch (vivienda.getComparteCama()) {
			case "CON_ADULTO":
				evaluacion -= 1.0;
				break;
			case "NO":
				evaluacion += 0.5;
				break;
			case "CON_MENOR":
				evaluacion -= 0.5;
				break;
			}

			evaluacion += vivienda.getHabitabilidad() * 0.5;
			evaluacion += vivienda.getRiesgo();
			switch (vivienda.getCuidadoEnAusencia()) {
			case "SIN_AUSENCIA":
				evaluacion += 1.0;
				break;
			case "DE_CONFIANZA":
				break;
			case "DE_NO_CONFIANZA":
				evaluacion = -1.0;
				break;
			case "SIN_CUIDADO":
				evaluacion -= 2.0;
				break;
			}

			return evaluacion;
		}

		private double evaluarMadre() {
			Madre madre = knowledgeBase.getMadre();
			Padre padre = knowledgeBase.getPadre();
			NuevaPareja nuevaPareja = knowledgeBase.getNuevaPareja();

			double evaluacion = 0.0;

			int edad = madre.getEdad();

			if (edad > 75 || edad < 20)
				evaluacion -= 0.5;

			evaluacion -= madre.getDiscapacidad() * madre.getDiscapacidad() * 0.4;

			if (madre.getTrabaja()) {
				if (madre.getIngresos() * 10 < padre.getIngresos())
					evaluacion -= 0.5;
			} else
				evaluacion -= 1.0;

			for (Adiccion adiccion : madre.getAdicciones()) {
				switch (adiccion.getTipoSustancia()) {
				case "ALCOHOL":
					evaluacion -= adiccion.getGrado() * 0.5;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 0.25;
					break;
				case "MARIHUANA":
					evaluacion -= adiccion.getGrado() * 1.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 0.5;
					break;
				case "COCAINA":
					evaluacion -= adiccion.getGrado() * 3.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 1.5;
					break;
				case "PACO":
					evaluacion -= adiccion.getGrado() * 4.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 2.0;
					break;
				}
			}

			for (Relacion relacion : madre.getRelaciones()) {
				if ((relacion.getHacia()) instanceof Nino)
					evaluacion += relacion.getValor();
				if (nuevaPareja!=null && (relacion.getHacia()) instanceof NuevaPareja) {
					if (relacion.getValor() > 0)
						evaluacion += relacion.getValor() * 0.1;
					else
						evaluacion += relacion.getValor() * 0.3;
				}
				if ((relacion.getHacia()) instanceof Padre)
					if (relacion.getValor() == -2)
						evaluacion -= 0.5;
			}

			for (Entrevista entrevista : knowledgeBase.getEntrevistas()) {
				if ((entrevista.getParticipante()) instanceof Madre)
					evaluacion += entrevista.getResultado();
			}

			for (ViolenciaFamiliar violencia : knowledgeBase.getViolencias()) {
				if ((violencia.getAutor() instanceof Madre)) {
					if ((violencia.getDestinatario()) instanceof Nino) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 2.0;
							break;
						case "FISICA":
							evaluacion -= 4.0;
							break;
						case "AMBAS":
							evaluacion -= 6.0;
							break;
						}
					}
					if (nuevaPareja!=null &&(violencia.getDestinatario()) instanceof NuevaPareja) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 1.0;
							break;
						case "FISICA":
							evaluacion -= 2.0;
							break;
						case "AMBAS":
							evaluacion -= 3.0;
							break;
						}
					}
					if ((violencia.getDestinatario()) instanceof Padre) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 1.5;
							break;
						case "FISICA":
							evaluacion -= 3.0;
							break;
						case "AMBAS":
							evaluacion -= 4.5;
							break;
						}
					}
				}
			}
			if (nuevaPareja != null) {
				if (madre.getCondicionNoContacto() && nuevaPareja.getViveConElPadre())
					evaluacion += 5.0;
			}

			return evaluacion;
		}

		private double evaluarNuevaPareja() {
			NuevaPareja nuevaPareja = knowledgeBase.getNuevaPareja();
			if (nuevaPareja == null)
				return 0;
			Madre madre = knowledgeBase.getMadre();
			double evaluacion = 0.0;

			double factorConvivencia = 0.2;
			if (nuevaPareja.getViveConElPadre())
				factorConvivencia = 1.0;

			int edad = nuevaPareja.getEdad();

			if (edad > 75 || edad < 20)
				evaluacion -= 0.5;

			if (nuevaPareja.getTrabaja())
				if (nuevaPareja.getIngresos() * 10 > madre.getIngresos())
					evaluacion += 0.5;

			for (Adiccion adiccion : nuevaPareja.getAdicciones()) {
				switch (adiccion.getTipoSustancia()) {
				case "ALCOHOL":
					evaluacion -= adiccion.getGrado() * 0.5;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 0.25;
					break;
				case "MARIHUANA":
					evaluacion -= adiccion.getGrado() * 1.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 0.5;
					break;
				case "COCAINA":
					evaluacion -= adiccion.getGrado() * 3.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 1.5;
					break;
				case "PACO":
					evaluacion -= adiccion.getGrado() * 4.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 2.0;
					break;
				}
			}

			for (Relacion relacion : nuevaPareja.getRelaciones()) {
				if ((relacion.getHacia()) instanceof Nino)
					evaluacion += relacion.getValor() * 0.5;
				if ((relacion.getHacia()) instanceof Padre) {
					if (relacion.getValor() > 0)
						evaluacion += relacion.getValor() * 0.2;
					else
						evaluacion += relacion.getValor() * 0.5;
				}
				if ((relacion.getHacia()) instanceof Madre)
					if (relacion.getValor() == -2)
						evaluacion -= 0.5;
			}

			for (Entrevista entrevista : knowledgeBase.getEntrevistas()) {
				if ((entrevista.getParticipante()) instanceof NuevaPareja)
					evaluacion += entrevista.getResultado();
			}

			for (ViolenciaFamiliar violencia : knowledgeBase.getViolencias()) {
				if ((violencia.getAutor() instanceof NuevaPareja)) {
					if ((violencia.getDestinatario()) instanceof Nino) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 2.0;
							break;
						case "FISICA":
							evaluacion -= 4.0;
							break;
						case "AMBAS":
							evaluacion -= 6.0;
							break;
						}
					}
					if ((violencia.getDestinatario()) instanceof Padre) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 1.5;
							break;
						case "FISICA":
							evaluacion -= 3.0;
							break;
						case "AMBAS":
							evaluacion -= 4.5;
							break;
						}
					}
					if ((violencia.getDestinatario()) instanceof Madre) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 1.0;
							break;
						case "FISICA":
							evaluacion -= 2.0;
							break;
						case "AMBAS":
							evaluacion -= 3.0;
							break;
						}
					}
				}
			}

			return evaluacion * factorConvivencia;
		}

		private double evaluarPadre() {
			Padre padre = knowledgeBase.getPadre();
			Madre madre = knowledgeBase.getMadre();
			Vivienda vivienda = knowledgeBase.getVivienda();
			double evaluacion = 0.0;

			int edad = padre.getEdad();

			if (edad > 75 || edad < 20)
				evaluacion -= 0.5;

			evaluacion -= padre.getDiscapacidad() * padre.getDiscapacidad() * 0.4;

			if (padre.getTrabaja()) {
				if (padre.getIngresos() * 10 < madre.getIngresos())
					evaluacion -= 0.5;
			} else
				evaluacion -= 1.0;

			if (padre.getCumpleCuotaAlimentaria())
				evaluacion += 0.5;
			else
				evaluacion -= 0.5;

			if (padre.getDiscursoContradictorio())
				evaluacion -= 0.5;

			if (padre.getHoraLlegada() < 2000 && padre.getHoraSalida() > 800)
				evaluacion += 0.5;
			else if (padre.getHoraLlegada() > 2200 || padre.getHoraSalida() < 600) {
				switch (vivienda.getCuidadoEnAusencia()) {
				case "DE_CONFIANZA":
					evaluacion = -0.5;
					break;
				case "DE_NO_CONFIANZA":
					evaluacion = -1.0;
					break;
				case "SIN_CUIDADO":
					evaluacion -= 2.0;
					break;
				default:
					break;
				}
			}

			for (Adiccion adiccion : padre.getAdicciones()) {
				switch (adiccion.getTipoSustancia()) {
				case "ALCOHOL":
					evaluacion -= adiccion.getGrado() * 0.5;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 0.25;
					break;
				case "MARIHUANA":
					evaluacion -= adiccion.getGrado() * 1.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 0.5;
					break;
				case "COCAINA":
					evaluacion -= adiccion.getGrado() * 3.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 1.5;
					break;
				case "PACO":
					evaluacion -= adiccion.getGrado() * 4.0;
					if (adiccion.getEstaEnTratamiento())
						evaluacion += adiccion.getGrado() * 2.0;
					break;
				}
			}

			for (Relacion relacion : padre.getRelaciones()) {
				if ((relacion.getHacia()) instanceof Nino)
					evaluacion += relacion.getValor();
				if (knowledgeBase.getNuevaPareja()!=null && (relacion.getHacia()) instanceof NuevaPareja) {
					if (relacion.getValor() > 0)
						evaluacion += relacion.getValor() * 0.2;
					else
						evaluacion += relacion.getValor() * 0.5;
				}
				if ((relacion.getHacia()) instanceof Madre)
					if (relacion.getValor() == -2)
						evaluacion -= 0.5;
			}

			for (Entrevista entrevista : knowledgeBase.getEntrevistas()) {
				if ((entrevista.getParticipante()) instanceof Padre)
					evaluacion += entrevista.getResultado();
			}

			for (ViolenciaFamiliar violencia : knowledgeBase.getViolencias()) {
				if ((violencia.getAutor() instanceof Padre)) {
					if ((violencia.getDestinatario()) instanceof Nino) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 2.0;
							break;
						case "FISICA":
							evaluacion -= 4.0;
							break;
						case "AMBAS":
							evaluacion -= 6.0;
							break;
						}
					}
					if (knowledgeBase.getNuevaPareja()!=null && (violencia.getDestinatario()) instanceof NuevaPareja) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 1.5;
							break;
						case "FISICA":
							evaluacion -= 3.0;
							break;
						case "AMBAS":
							evaluacion -= 4.5;
							break;
						}
					}
					if ((violencia.getDestinatario()) instanceof Madre) {
						switch (violencia.getTipoViolencia()) {
						case "PSICOLOGICA":
							evaluacion -= 1.0;
							break;
						case "FISICA":
							evaluacion -= 2.0;
							break;
						case "AMBAS":
							evaluacion -= 3.0;
							break;
						}
					}
				}
			}

			return evaluacion;
		}
	
    
}