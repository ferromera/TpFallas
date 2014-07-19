package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(ViviendaController)
@Mock(Vivienda)
class ViviendaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/vivienda/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.viviendaInstanceList.size() == 0
        assert model.viviendaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.viviendaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.viviendaInstance != null
        assert view == '/vivienda/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/vivienda/show/1'
        assert controller.flash.message != null
        assert Vivienda.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/vivienda/list'

        populateValidParams(params)
        def vivienda = new Vivienda(params)

        assert vivienda.save() != null

        params.id = vivienda.id

        def model = controller.show()

        assert model.viviendaInstance == vivienda
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/vivienda/list'

        populateValidParams(params)
        def vivienda = new Vivienda(params)

        assert vivienda.save() != null

        params.id = vivienda.id

        def model = controller.edit()

        assert model.viviendaInstance == vivienda
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/vivienda/list'

        response.reset()

        populateValidParams(params)
        def vivienda = new Vivienda(params)

        assert vivienda.save() != null

        // test invalid parameters in update
        params.id = vivienda.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/vivienda/edit"
        assert model.viviendaInstance != null

        vivienda.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/vivienda/show/$vivienda.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        vivienda.clearErrors()

        populateValidParams(params)
        params.id = vivienda.id
        params.version = -1
        controller.update()

        assert view == "/vivienda/edit"
        assert model.viviendaInstance != null
        assert model.viviendaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/vivienda/list'

        response.reset()

        populateValidParams(params)
        def vivienda = new Vivienda(params)

        assert vivienda.save() != null
        assert Vivienda.count() == 1

        params.id = vivienda.id

        controller.delete()

        assert Vivienda.count() == 0
        assert Vivienda.get(vivienda.id) == null
        assert response.redirectedUrl == '/vivienda/list'
    }
}
