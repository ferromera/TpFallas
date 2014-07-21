package tpFallas.frame

class Relacion {
	
	enum Participante{
		PADRE,
		MADRE,
		NINO,
		NUEVA_PAREJA
	}
	 
	Participante desde
	Integer valor
	Participante hacia
	
	String toString(){
		return "Desde: ${desde}, Hacia: ${hacia}, Nivel: ${valor}"
	}
	
	static constraints = {
		 
	}

}
