package tpFallas.frame

class Padre extends Persona{

	 Integer horaSalida
	 Integer horaLlegada
	 boolean discursoContradictorio = false
	 boolean cumpleCuotaAlimentaria = true
	
	
	 
    static constraints = {
    }
	
	String toString(){
		return "Padre, Nombre: ${nombre} ${apellido} Edad: ${edad}, Id:${id}"
	}
}
