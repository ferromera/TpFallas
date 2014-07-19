package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(NinoController)
@Mock(Nino)
class NinoControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/nino/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.ninoInstanceList.size() == 0
        assert model.ninoInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.ninoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.ninoInstance != null
        assert view == '/nino/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/nino/show/1'
        assert controller.flash.message != null
        assert Nino.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/nino/list'

        populateValidParams(params)
        def nino = new Nino(params)

        assert nino.save() != null

        params.id = nino.id

        def model = controller.show()

        assert model.ninoInstance == nino
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/nino/list'

        populateValidParams(params)
        def nino = new Nino(params)

        assert nino.save() != null

        params.id = nino.id

        def model = controller.edit()

        assert model.ninoInstance == nino
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/nino/list'

        response.reset()

        populateValidParams(params)
        def nino = new Nino(params)

        assert nino.save() != null

        // test invalid parameters in update
        params.id = nino.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/nino/edit"
        assert model.ninoInstance != null

        nino.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/nino/show/$nino.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        nino.clearErrors()

        populateValidParams(params)
        params.id = nino.id
        params.version = -1
        controller.update()

        assert view == "/nino/edit"
        assert model.ninoInstance != null
        assert model.ninoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/nino/list'

        response.reset()

        populateValidParams(params)
        def nino = new Nino(params)

        assert nino.save() != null
        assert Nino.count() == 1

        params.id = nino.id

        controller.delete()

        assert Nino.count() == 0
        assert Nino.get(nino.id) == null
        assert response.redirectedUrl == '/nino/list'
    }
}
