package tpFallas.frame

class ViolenciaFamiliar {
	
	public enum TipoViolencia{
		FISICA,
		PSICOLOGICA,
		AMBAS
	}
	
	 TipoViolencia tipoViolencia
	 Persona autor
	 Persona destinatario
	
    static constraints = {
    }
	
	String toString(){
		return "Tipo de Violencia: ${tipoViolencia},Autor ${autor}, Id:${id}"
	}
}
