package tpFallas.knowledge

import org.springframework.dao.DataIntegrityViolationException


class KnowledgeBaseController {
	
	
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [knowledgeBaseInstanceList: KnowledgeBase.list(params), knowledgeBaseInstanceTotal: KnowledgeBase.count()]
    }

    def create() {
        [knowledgeBaseInstance: new KnowledgeBase(params)]
    }

    def save() {
        def knowledgeBaseInstance = new KnowledgeBase(params)
        if (!knowledgeBaseInstance.save(flush: true)) {
            render(view: "create", model: [knowledgeBaseInstance: knowledgeBaseInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), knowledgeBaseInstance.id])
        redirect(action: "show", id: knowledgeBaseInstance.id)
    }

    def show(Long id) {
        def knowledgeBaseInstance = KnowledgeBase.get(id)
        if (!knowledgeBaseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), id])
            redirect(action: "list")
            return
        }

        [knowledgeBaseInstance: knowledgeBaseInstance]
    }

    def edit(Long id) {
        def knowledgeBaseInstance = KnowledgeBase.get(id)
        if (!knowledgeBaseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), id])
            redirect(action: "list")
            return
        }

        [knowledgeBaseInstance: knowledgeBaseInstance]
    }

    def update(Long id, Long version) {
        def knowledgeBaseInstance = KnowledgeBase.get(id)
        if (!knowledgeBaseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (knowledgeBaseInstance.version > version) {
                knowledgeBaseInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'knowledgeBase.label', default: 'KnowledgeBase')] as Object[],
                          "Another user has updated this KnowledgeBase while you were editing")
                render(view: "edit", model: [knowledgeBaseInstance: knowledgeBaseInstance])
                return
            }
        }

        knowledgeBaseInstance.properties = params

        if (!knowledgeBaseInstance.save(flush: true)) {
            render(view: "edit", model: [knowledgeBaseInstance: knowledgeBaseInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), knowledgeBaseInstance.id])
        redirect(action: "show", id: knowledgeBaseInstance.id)
    }

    def delete(Long id) {
        def knowledgeBaseInstance = KnowledgeBase.get(id)
        if (!knowledgeBaseInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), id])
            redirect(action: "list")
            return
        }

        try {
            knowledgeBaseInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'knowledgeBase.label', default: 'KnowledgeBase'), id])
            redirect(action: "show", id: id)
        }
    }
	
	def evaluar(Long id){
		
		def knowledgeBaseInstance = KnowledgeBase.get(id)
		def evaluador=new EvaluadorService(knowledgeBaseInstance)
		
		if (evaluador.permitirPadrePasarNocheConHijo()){
			
			render ("OK")
			return
		}else{
			render ("NO")
			return
		}
	}
}
