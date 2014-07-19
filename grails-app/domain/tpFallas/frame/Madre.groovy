package tpFallas.frame

class Madre extends Persona{

	 boolean condicionNoContacto = false
	 
	 String toString(){
		 return "Madre:, Nombre: ${nombre} ${apellido} Edad: ${edad}, Id:${id}"
	 }
	 
    static constraints = {
    }
}
