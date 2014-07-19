package tpFallas.frame

class Vivienda {
	
	enum CuidadoEnAusencia{
		SIN_AUSENCIA,
		DE_CONFIANZA,
		DE_NO_CONFIANZA,
		SIN_CUIDADO
	}
	enum ComparteCama{
		NO,
		CON_ADULTO,
		CON_MENOR
	}
	
	String propietario
	boolean habitacionDelNino
	Integer habitabilidad
	Integer riesgo
	CuidadoEnAusencia cuidadoEnAusencia
	ComparteCama comparteCama
	
    static constraints = {
    }
	
	String toString(){
		return "Propietario: ${propietario},  ${habitabilidad}"
	}
}
