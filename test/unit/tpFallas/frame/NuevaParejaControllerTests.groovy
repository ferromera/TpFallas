package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(NuevaParejaController)
@Mock(NuevaPareja)
class NuevaParejaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/nuevaPareja/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.nuevaParejaInstanceList.size() == 0
        assert model.nuevaParejaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.nuevaParejaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.nuevaParejaInstance != null
        assert view == '/nuevaPareja/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/nuevaPareja/show/1'
        assert controller.flash.message != null
        assert NuevaPareja.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/nuevaPareja/list'

        populateValidParams(params)
        def nuevaPareja = new NuevaPareja(params)

        assert nuevaPareja.save() != null

        params.id = nuevaPareja.id

        def model = controller.show()

        assert model.nuevaParejaInstance == nuevaPareja
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/nuevaPareja/list'

        populateValidParams(params)
        def nuevaPareja = new NuevaPareja(params)

        assert nuevaPareja.save() != null

        params.id = nuevaPareja.id

        def model = controller.edit()

        assert model.nuevaParejaInstance == nuevaPareja
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/nuevaPareja/list'

        response.reset()

        populateValidParams(params)
        def nuevaPareja = new NuevaPareja(params)

        assert nuevaPareja.save() != null

        // test invalid parameters in update
        params.id = nuevaPareja.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/nuevaPareja/edit"
        assert model.nuevaParejaInstance != null

        nuevaPareja.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/nuevaPareja/show/$nuevaPareja.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        nuevaPareja.clearErrors()

        populateValidParams(params)
        params.id = nuevaPareja.id
        params.version = -1
        controller.update()

        assert view == "/nuevaPareja/edit"
        assert model.nuevaParejaInstance != null
        assert model.nuevaParejaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/nuevaPareja/list'

        response.reset()

        populateValidParams(params)
        def nuevaPareja = new NuevaPareja(params)

        assert nuevaPareja.save() != null
        assert NuevaPareja.count() == 1

        params.id = nuevaPareja.id

        controller.delete()

        assert NuevaPareja.count() == 0
        assert NuevaPareja.get(nuevaPareja.id) == null
        assert response.redirectedUrl == '/nuevaPareja/list'
    }
}
