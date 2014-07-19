package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class RelacionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [relacionInstanceList: Relacion.list(params), relacionInstanceTotal: Relacion.count()]
    }

    def create() {
        [relacionInstance: new Relacion(params)]
    }

    def save() {
        def relacionInstance = new Relacion(params)
        if (!relacionInstance.save(flush: true)) {
            render(view: "create", model: [relacionInstance: relacionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'relacion.label', default: 'Relacion'), relacionInstance.id])
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
        def relacionInstance = Relacion.get(id)
        if (!relacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relacion.label', default: 'Relacion'), id])
            redirect(action: "list")
            return
        }

        [relacionInstance: relacionInstance]
    }

    def edit(Long id) {
        def relacionInstance = Relacion.get(id)
        if (!relacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relacion.label', default: 'Relacion'), id])
            redirect(action: "list")
            return
        }

        [relacionInstance: relacionInstance]
    }

    def update(Long id, Long version) {
        def relacionInstance = Relacion.get(id)
        if (!relacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relacion.label', default: 'Relacion'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (relacionInstance.version > version) {
                relacionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'relacion.label', default: 'Relacion')] as Object[],
                          "Another user has updated this Relacion while you were editing")
                render(view: "edit", model: [relacionInstance: relacionInstance])
                return
            }
        }

        relacionInstance.properties = params

        if (!relacionInstance.save(flush: true)) {
            render(view: "edit", model: [relacionInstance: relacionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'relacion.label', default: 'Relacion'), relacionInstance.id])
               
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
        def relacionInstance = Relacion.get(id)
        if (!relacionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'relacion.label', default: 'Relacion'), id])
            redirect(action: "list")
            return
        }

        try {
            relacionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'relacion.label', default: 'Relacion'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'relacion.label', default: 'Relacion'), id])
            redirect(action: "show", id: id)
        }
    }
}
