package tpFallas.knowledge

import tpFallas.frame.Entrevista;
import tpFallas.frame.Madre;
import tpFallas.frame.Nino;
import tpFallas.frame.NuevaPareja;
import tpFallas.frame.Padre;
import tpFallas.frame.ViolenciaFamiliar;
import tpFallas.frame.Vivienda;



class KnowledgeBase {
	
	
	
	private static KnowledgeBase instance = new KnowledgeBase();
	
	Padre padre;
	Madre madre;
	Nino nino;
	NuevaPareja nuevaPareja;
	
	Vivienda vivienda;
	List<ViolenciaFamiliar> violencias;
	List<Entrevista> entrevistas;
	
	static hasMany = [violencias:ViolenciaFamiliar,entrevistas:Entrevista]
	
    static constraints = {
		padre()
		madre()
		nino()
		vivienda()
		violencias()
		entrevistas()
		nuevaPareja()
    }
}
