package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class ViviendaController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [viviendaInstanceList: Vivienda.list(params), viviendaInstanceTotal: Vivienda.count()]
    }

    def create() {
        [viviendaInstance: new Vivienda(params)]
    }

    def save() {
        def viviendaInstance = new Vivienda(params)
        if (!viviendaInstance.save(flush: true)) {
            render(view: "create", model: [viviendaInstance: viviendaInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), viviendaInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def viviendaInstance = Vivienda.get(id)
        if (!viviendaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), id])
            redirect(action: "list")
            return
        }

        [viviendaInstance: viviendaInstance]
    }

    def edit(Long id) {
        def viviendaInstance = Vivienda.get(id)
        if (!viviendaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), id])
            redirect(action: "list")
            return
        }

        [viviendaInstance: viviendaInstance]
    }

    def update(Long id, Long version) {
        def viviendaInstance = Vivienda.get(id)
        if (!viviendaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (viviendaInstance.version > version) {
                viviendaInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'vivienda.label', default: 'Vivienda')] as Object[],
                          "Another user has updated this Vivienda while you were editing")
                render(view: "edit", model: [viviendaInstance: viviendaInstance])
                return
            }
        }

        viviendaInstance.properties = params

        if (!viviendaInstance.save(flush: true)) {
            render(view: "edit", model: [viviendaInstance: viviendaInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), viviendaInstance.id])
        redirect(action: "show", id: viviendaInstance.id)
    }

    def delete(Long id) {
        def viviendaInstance = Vivienda.get(id)
        if (!viviendaInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), id])
            redirect(action: "list")
            return
        }

        try {
            viviendaInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'vivienda.label', default: 'Vivienda'), id])
            redirect(action: "show", id: id)
        }
    }
}
