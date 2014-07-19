package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class MadreController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [madreInstanceList: Madre.list(params), madreInstanceTotal: Madre.count()]
    }

    def create() {
        [madreInstance: new Madre(params)]
    }

    def save() {
        def madreInstance = new Madre(params)
        if (!madreInstance.save(flush: true)) {
            render(view: "create", model: [madreInstance: madreInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'madre.label', default: 'Madre'), madreInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def madreInstance = Madre.get(id)
        if (!madreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'madre.label', default: 'Madre'), id])
            redirect(action: "list")
            return
        }

        [madreInstance: madreInstance]
    }

    def edit(Long id) {
        def madreInstance = Madre.get(id)
        if (!madreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'madre.label', default: 'Madre'), id])
            redirect(action: "list")
            return
        }

        [madreInstance: madreInstance]
    }

    def update(Long id, Long version) {
        def madreInstance = Madre.get(id)
        if (!madreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'madre.label', default: 'Madre'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (madreInstance.version > version) {
                madreInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'madre.label', default: 'Madre')] as Object[],
                          "Another user has updated this Madre while you were editing")
                render(view: "edit", model: [madreInstance: madreInstance])
                return
            }
        }

        madreInstance.properties = params

        if (!madreInstance.save(flush: true)) {
            render(view: "edit", model: [madreInstance: madreInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'madre.label', default: 'Madre'), madreInstance.id])
        redirect(action: "show", id: madreInstance.id)
    }

    def delete(Long id) {
        def madreInstance = Madre.get(id)
        if (!madreInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'madre.label', default: 'Madre'), id])
            redirect(action: "list")
            return
        }

        try {
            madreInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'madre.label', default: 'Madre'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'madre.label', default: 'Madre'), id])
            redirect(action: "show", id: id)
        }
    }
}
