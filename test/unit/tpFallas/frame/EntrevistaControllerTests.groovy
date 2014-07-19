package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(EntrevistaController)
@Mock(Entrevista)
class EntrevistaControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/entrevista/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.entrevistaInstanceList.size() == 0
        assert model.entrevistaInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.entrevistaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.entrevistaInstance != null
        assert view == '/entrevista/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/entrevista/show/1'
        assert controller.flash.message != null
        assert Entrevista.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/entrevista/list'

        populateValidParams(params)
        def entrevista = new Entrevista(params)

        assert entrevista.save() != null

        params.id = entrevista.id

        def model = controller.show()

        assert model.entrevistaInstance == entrevista
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/entrevista/list'

        populateValidParams(params)
        def entrevista = new Entrevista(params)

        assert entrevista.save() != null

        params.id = entrevista.id

        def model = controller.edit()

        assert model.entrevistaInstance == entrevista
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/entrevista/list'

        response.reset()

        populateValidParams(params)
        def entrevista = new Entrevista(params)

        assert entrevista.save() != null

        // test invalid parameters in update
        params.id = entrevista.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/entrevista/edit"
        assert model.entrevistaInstance != null

        entrevista.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/entrevista/show/$entrevista.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        entrevista.clearErrors()

        populateValidParams(params)
        params.id = entrevista.id
        params.version = -1
        controller.update()

        assert view == "/entrevista/edit"
        assert model.entrevistaInstance != null
        assert model.entrevistaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/entrevista/list'

        response.reset()

        populateValidParams(params)
        def entrevista = new Entrevista(params)

        assert entrevista.save() != null
        assert Entrevista.count() == 1

        params.id = entrevista.id

        controller.delete()

        assert Entrevista.count() == 0
        assert Entrevista.get(entrevista.id) == null
        assert response.redirectedUrl == '/entrevista/list'
    }
}
