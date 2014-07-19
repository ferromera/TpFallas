package tpFallas.frame

class NuevaPareja extends Persona{

	private boolean viveConElPadre=true
	
    static constraints = {
    }
	
	String toString(){
		return "NuevaPareja, Nombre: ${nombre} ${apellido} Edad: ${edad}, Id:${id}"
	}
}
