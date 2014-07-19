package tpFallas.frame

import org.springframework.dao.DataIntegrityViolationException

class ViolenciaFamiliarController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [violenciaFamiliarInstanceList: ViolenciaFamiliar.list(params), violenciaFamiliarInstanceTotal: ViolenciaFamiliar.count()]
    }

    def create() {
        [violenciaFamiliarInstance: new ViolenciaFamiliar(params)]
    }

    def save() {
        def violenciaFamiliarInstance = new ViolenciaFamiliar(params)
        if (!violenciaFamiliarInstance.save(flush: true)) {
            render(view: "create", model: [violenciaFamiliarInstance: violenciaFamiliarInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), violenciaFamiliarInstance.id])
        redirect(controller:"knowledgeBase",action: "create")
    }

    def show(Long id) {
        def violenciaFamiliarInstance = ViolenciaFamiliar.get(id)
        if (!violenciaFamiliarInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), id])
            redirect(action: "list")
            return
        }

        [violenciaFamiliarInstance: violenciaFamiliarInstance]
    }

    def edit(Long id) {
        def violenciaFamiliarInstance = ViolenciaFamiliar.get(id)
        if (!violenciaFamiliarInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), id])
            redirect(action: "list")
            return
        }

        [violenciaFamiliarInstance: violenciaFamiliarInstance]
    }

    def update(Long id, Long version) {
        def violenciaFamiliarInstance = ViolenciaFamiliar.get(id)
        if (!violenciaFamiliarInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (violenciaFamiliarInstance.version > version) {
                violenciaFamiliarInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar')] as Object[],
                          "Another user has updated this ViolenciaFamiliar while you were editing")
                render(view: "edit", model: [violenciaFamiliarInstance: violenciaFamiliarInstance])
                return
            }
        }

        violenciaFamiliarInstance.properties = params

        if (!violenciaFamiliarInstance.save(flush: true)) {
            render(view: "edit", model: [violenciaFamiliarInstance: violenciaFamiliarInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), violenciaFamiliarInstance.id])
        redirect(action: "show", id: violenciaFamiliarInstance.id)
    }

    def delete(Long id) {
        def violenciaFamiliarInstance = ViolenciaFamiliar.get(id)
        if (!violenciaFamiliarInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), id])
            redirect(action: "list")
            return
        }

        try {
            violenciaFamiliarInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'violenciaFamiliar.label', default: 'ViolenciaFamiliar'), id])
            redirect(action: "show", id: id)
        }
    }
}
