package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(AdiccionController)
@Mock(Adiccion)
class AdiccionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/adiccion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.adiccionInstanceList.size() == 0
        assert model.adiccionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.adiccionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.adiccionInstance != null
        assert view == '/adiccion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/adiccion/show/1'
        assert controller.flash.message != null
        assert Adiccion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/adiccion/list'

        populateValidParams(params)
        def adiccion = new Adiccion(params)

        assert adiccion.save() != null

        params.id = adiccion.id

        def model = controller.show()

        assert model.adiccionInstance == adiccion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/adiccion/list'

        populateValidParams(params)
        def adiccion = new Adiccion(params)

        assert adiccion.save() != null

        params.id = adiccion.id

        def model = controller.edit()

        assert model.adiccionInstance == adiccion
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/adiccion/list'

        response.reset()

        populateValidParams(params)
        def adiccion = new Adiccion(params)

        assert adiccion.save() != null

        // test invalid parameters in update
        params.id = adiccion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/adiccion/edit"
        assert model.adiccionInstance != null

        adiccion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/adiccion/show/$adiccion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        adiccion.clearErrors()

        populateValidParams(params)
        params.id = adiccion.id
        params.version = -1
        controller.update()

        assert view == "/adiccion/edit"
        assert model.adiccionInstance != null
        assert model.adiccionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/adiccion/list'

        response.reset()

        populateValidParams(params)
        def adiccion = new Adiccion(params)

        assert adiccion.save() != null
        assert Adiccion.count() == 1

        params.id = adiccion.id

        controller.delete()

        assert Adiccion.count() == 0
        assert Adiccion.get(adiccion.id) == null
        assert response.redirectedUrl == '/adiccion/list'
    }
}
