package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class NinoController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [ninoInstanceList: Nino.list(params), ninoInstanceTotal: Nino.count()]
    }

    def create() {
        [ninoInstance: new Nino(params)]
    }

    def save() {
        def ninoInstance = new Nino(params)
        if (!ninoInstance.save(flush: true)) {
            render(view: "create", model: [ninoInstance: ninoInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'nino.label', default: 'Nino'), ninoInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def ninoInstance = Nino.get(id)
        if (!ninoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nino.label', default: 'Nino'), id])
            redirect(action: "list")
            return
        }

        [ninoInstance: ninoInstance]
    }

    def edit(Long id) {
        def ninoInstance = Nino.get(id)
        if (!ninoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nino.label', default: 'Nino'), id])
            redirect(action: "list")
            return
        }

        [ninoInstance: ninoInstance]
    }

    def update(Long id, Long version) {
        def ninoInstance = Nino.get(id)
        if (!ninoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nino.label', default: 'Nino'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (ninoInstance.version > version) {
                ninoInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'nino.label', default: 'Nino')] as Object[],
                          "Another user has updated this Nino while you were editing")
                render(view: "edit", model: [ninoInstance: ninoInstance])
                return
            }
        }

        ninoInstance.properties = params

        if (!ninoInstance.save(flush: true)) {
            render(view: "edit", model: [ninoInstance: ninoInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'nino.label', default: 'Nino'), ninoInstance.id])
        redirect(action: "show", id: ninoInstance.id)
    }

    def delete(Long id) {
        def ninoInstance = Nino.get(id)
        if (!ninoInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'nino.label', default: 'Nino'), id])
            redirect(action: "list")
            return
        }

        try {
            ninoInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'nino.label', default: 'Nino'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'nino.label', default: 'Nino'), id])
            redirect(action: "show", id: id)
        }
    }
}
