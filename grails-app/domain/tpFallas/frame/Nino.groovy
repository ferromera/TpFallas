package tpFallas.frame

class Nino extends Persona {

    static constraints = {
    }
	
	String toString(){
		return "Niño:, Nombre: ${nombre} ${apellido} Edad: ${edad}, Id:${id}"
	}
}
