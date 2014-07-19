package tpFallas.frame

class Persona {
	
	
	String nombre
	String apellido
	
	Integer edad
	boolean trabaja=false
	Integer ingresos=0
	Integer discapacidad=0
	List<Relacion> relaciones= new ArrayList<Relacion>()
	List<Adiccion> adicciones = new ArrayList<Adiccion>()
	
	static hasMany = [relaciones:Relacion,adicciones:Adiccion]
	
    static constraints = {
    }
}
