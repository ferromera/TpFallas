package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class NuevaParejaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [nuevaParejaInstanceList: NuevaPareja.list(params), nuevaParejaInstanceTotal: NuevaPareja.count()]
    }

    def create() {
        [nuevaParejaInstance: new NuevaPareja(params)]
    }

    def save() {
        def nuevaParejaInstance = new NuevaPareja(params)
        if (!nuevaParejaInstance.save(flush: true)) {
            render(view: "create", model: [nuevaParejaInstance: nuevaParejaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), nuevaParejaInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def nuevaParejaInstance = NuevaPareja.get(id)
        if (!nuevaParejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), id])
            redirect(action: "list")
            return
        }

        [nuevaParejaInstance: nuevaParejaInstance]
    }

    def edit(Long id) {
        def nuevaParejaInstance = NuevaPareja.get(id)
        if (!nuevaParejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), id])
            redirect(action: "list")
            return
        }

        [nuevaParejaInstance: nuevaParejaInstance]
    }

    def update(Long id, Long version) {
        def nuevaParejaInstance = NuevaPareja.get(id)
        if (!nuevaParejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (nuevaParejaInstance.version > version) {
                nuevaParejaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'nuevaPareja.label', default: 'NuevaPareja')] as Object[],
                          "Another user has updated this NuevaPareja while you were editing")
                render(view: "edit", model: [nuevaParejaInstance: nuevaParejaInstance])
                return
            }
        }

        nuevaParejaInstance.properties = params

        if (!nuevaParejaInstance.save(flush: true)) {
            render(view: "edit", model: [nuevaParejaInstance: nuevaParejaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), nuevaParejaInstance.id])
        redirect(action: "show", id: nuevaParejaInstance.id)
    }

    def delete(Long id) {
        def nuevaParejaInstance = NuevaPareja.get(id)
        if (!nuevaParejaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), id])
            redirect(action: "list")
            return
        }

        try {
            nuevaParejaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'nuevaPareja.label', default: 'NuevaPareja'), id])
            redirect(action: "show", id: id)
        }
    }
}
