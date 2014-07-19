import tpFallas.frame.Adiccion
import tpFallas.frame.Relacion

class BootStrap {

    def init = { servletContext ->
		
		
		def padreAdictoMariguana = new Adiccion(
			tipoSustancia:"MARIHUANA",
			estaEnTratamiento:true,
			grado:5,
			adicto:"PADRE").save()
    	
	
		def padreAdictoAlcohol = new Adiccion(
			tipoSustancia:"ALCOHOL",
			estaEnTratamiento:true,
			grado:7,
			adicto:"PADRE").save()
			
		def madreAdictoAlcohol = new Adiccion(
			tipoSustancia:"ALCOHOL",
			estaEnTratamiento:true,
			grado:10,
			adicto:"MADRE").save()
			
			
		}
	
		def relacionPadreMadreBuena= new Relacion(
			desde:"PADRE",
			hacia:"MADRE",
			valor:10).save()
		
		def relacionPadreMadreMala= new Relacion(
			desde:"PADRE",
			hacia:"MADRE",
			valor:1).save()
		
		def relacionMadrePadreMala= new Relacion(
			desde:"MADRE",
			hacia:"PADRE",
			valor:1).save()
			
		def relacionMadrePadreBuena= new Relacion(
			desde:"MADRE",
			hacia:"PADRE",
			valor:10).save()
		
		def relacionPadreNinoBuena= new Relacion(
			desde:"PADRE",
			hacia:"NINO",
			valor:10).save()
}
