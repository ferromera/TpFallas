package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class EntrevistaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [entrevistaInstanceList: Entrevista.list(params), entrevistaInstanceTotal: Entrevista.count()]
    }

    def create() {
        [entrevistaInstance: new Entrevista(params)]
    }

    def save() {
        def entrevistaInstance = new Entrevista(params)
        if (!entrevistaInstance.save(flush: true)) {
            render(view: "create", model: [entrevistaInstance: entrevistaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), entrevistaInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def entrevistaInstance = Entrevista.get(id)
        if (!entrevistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), id])
            redirect(action: "list")
            return
        }

        [entrevistaInstance: entrevistaInstance]
    }

    def edit(Long id) {
        def entrevistaInstance = Entrevista.get(id)
        if (!entrevistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), id])
            redirect(action: "list")
            return
        }

        [entrevistaInstance: entrevistaInstance]
    }

    def update(Long id, Long version) {
        def entrevistaInstance = Entrevista.get(id)
        if (!entrevistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (entrevistaInstance.version > version) {
                entrevistaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'entrevista.label', default: 'Entrevista')] as Object[],
                          "Another user has updated this Entrevista while you were editing")
                render(view: "edit", model: [entrevistaInstance: entrevistaInstance])
                return
            }
        }

        entrevistaInstance.properties = params

        if (!entrevistaInstance.save(flush: true)) {
            render(view: "edit", model: [entrevistaInstance: entrevistaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), entrevistaInstance.id])
        redirect(action: "show", id: entrevistaInstance.id)
    }

    def delete(Long id) {
        def entrevistaInstance = Entrevista.get(id)
        if (!entrevistaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), id])
            redirect(action: "list")
            return
        }

        try {
            entrevistaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'entrevista.label', default: 'Entrevista'), id])
            redirect(action: "show", id: id)
        }
    }
}
