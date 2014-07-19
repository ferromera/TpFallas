package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class PadreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [padreInstanceList: Padre.list(params), padreInstanceTotal: Padre.count()]
    }

    def create() {
        [padreInstance: new Padre(params)]
    }

    def save() {
        def padreInstance = new Padre(params)
        if (!padreInstance.save(flush: true)) {
            render(view: "create", model: [padreInstance: padreInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'padre.label', default: 'Padre'), padreInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def padreInstance = Padre.get(id)
        if (!padreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'padre.label', default: 'Padre'), id])
            redirect(action: "list")
            return
        }

        [padreInstance: padreInstance]
    }

    def edit(Long id) {
        def padreInstance = Padre.get(id)
        if (!padreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'padre.label', default: 'Padre'), id])
            redirect(action: "list")
            return
        }

        [padreInstance: padreInstance]
    }

    def update(Long id, Long version) {
        def padreInstance = Padre.get(id)
        if (!padreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'padre.label', default: 'Padre'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (padreInstance.version > version) {
                padreInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'padre.label', default: 'Padre')] as Object[],
                          "Another user has updated this Padre while you were editing")
                render(view: "edit", model: [padreInstance: padreInstance])
                return
            }
        }

        padreInstance.properties = params

        if (!padreInstance.save(flush: true)) {
            render(view: "edit", model: [padreInstance: padreInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'padre.label', default: 'Padre'), padreInstance.id])
        redirect(action: "show", id: padreInstance.id)
    }

    def delete(Long id) {
        def padreInstance = Padre.get(id)
        if (!padreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'padre.label', default: 'Padre'), id])
            redirect(action: "list")
            return
        }

        try {
            padreInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'padre.label', default: 'Padre'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'padre.label', default: 'Padre'), id])
            redirect(action: "show", id: id)
        }
    }
}
