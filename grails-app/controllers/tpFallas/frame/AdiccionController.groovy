package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class AdiccionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [adiccionInstanceList: Adiccion.list(params), adiccionInstanceTotal: Adiccion.count()]
    }

    def create() {
        [adiccionInstance: new Adiccion(params)]
    }

    def save() {
        def adiccionInstance = new Adiccion(params)
        if (!adiccionInstance.save(flush: true)) {
            render(view: "create", model: [adiccionInstance: adiccionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), adiccionInstance.id])
        
		if (params.persona=="padre"){
			
			redirect(controller: "padre", action: "create")
			return
		}
		
		if (params.persona=="madre"){
			
			redirect(controller: "madre", action: "create")
			return
		}
		if (params.persona=="nino"){
			
			redirect(controller: "nino", action: "create")
			return
		}
		
		if (params.persona=="nuevaPareja"){
			
			redirect(controller: "nuevaPareja", action: "create")
			return
		}
    }

    def show(Long id) {
        def adiccionInstance = Adiccion.get(id)
        if (!adiccionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), id])
            redirect(action: "list")
            return
        }

        [adiccionInstance: adiccionInstance]
    }

    def edit(Long id) {
        def adiccionInstance = Adiccion.get(id)
        if (!adiccionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), id])
            redirect(action: "list")
            return
        }

        [adiccionInstance: adiccionInstance]
    }

    def update(Long id, Long version) {
        def adiccionInstance = Adiccion.get(id)
        if (!adiccionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (adiccionInstance.version > version) {
                adiccionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'adiccion.label', default: 'Adiccion')] as Object[],
                          "Another user has updated this Adiccion while you were editing")
                render(view: "edit", model: [adiccionInstance: adiccionInstance])
                return
            }
        }

        adiccionInstance.properties = params

        if (!adiccionInstance.save(flush: true)) {
            render(view: "edit", model: [adiccionInstance: adiccionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), adiccionInstance.id])
        if (params.persona=="padre"){
			
			redirect(controller: "padre", action: "create")
			return
		}
		
		if (params.persona=="madre"){
			
			redirect(controller: "madre", action: "create")
			return
		}
		if (params.persona=="nino"){
			
			redirect(controller: "nino", action: "create")
			return
		}
		
		if (params.persona=="nuevaPareja"){
			
			redirect(controller: "nuevaPareja", action: "create")
			return
		}
    }

    def delete(Long id) {
        def adiccionInstance = Adiccion.get(id)
        if (!adiccionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), id])
            redirect(action: "list")
            return
        }

        try {
            adiccionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'adiccion.label', default: 'Adiccion'), id])
            redirect(action: "show", id: id)
        }
    }
}
