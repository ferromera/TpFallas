package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(PadreController)
@Mock(Padre)
class PadreControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/padre/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.padreInstanceList.size() == 0
        assert model.padreInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.padreInstance != null
    }

    void testSave() {
        controller.save()

        assert model.padreInstance != null
        assert view == '/padre/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/padre/show/1'
        assert controller.flash.message != null
        assert Padre.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/padre/list'

        populateValidParams(params)
        def padre = new Padre(params)

        assert padre.save() != null

        params.id = padre.id

        def model = controller.show()

        assert model.padreInstance == padre
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/padre/list'

        populateValidParams(params)
        def padre = new Padre(params)

        assert padre.save() != null

        params.id = padre.id

        def model = controller.edit()

        assert model.padreInstance == padre
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/padre/list'

        response.reset()

        populateValidParams(params)
        def padre = new Padre(params)

        assert padre.save() != null

        // test invalid parameters in update
        params.id = padre.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/padre/edit"
        assert model.padreInstance != null

        padre.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/padre/show/$padre.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        padre.clearErrors()

        populateValidParams(params)
        params.id = padre.id
        params.version = -1
        controller.update()

        assert view == "/padre/edit"
        assert model.padreInstance != null
        assert model.padreInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/padre/list'

        response.reset()

        populateValidParams(params)
        def padre = new Padre(params)

        assert padre.save() != null
        assert Padre.count() == 1

        params.id = padre.id

        controller.delete()

        assert Padre.count() == 0
        assert Padre.get(padre.id) == null
        assert response.redirectedUrl == '/padre/list'
    }
}
