package tpFallas.frame

class Adiccion {
	
	enum TipoSustancia{
		MARIHUANA,
		ALCOHOL,
		COCAINA,
		PACO
	}
	
	enum Adicto{
		PADRE,
		MADRE,
		NINO,
		OTRO
	}
	
	TipoSustancia tipoSustancia
	boolean estaEnTratamiento
	Integer grado
	Adicto adicto
	
	
	String toString(){
		return "${tipoSustancia}, ${adicto}"
	}
    static constraints = {
    }
}
