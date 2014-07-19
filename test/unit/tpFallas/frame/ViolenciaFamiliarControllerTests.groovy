package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(ViolenciaFamiliarController)
@Mock(ViolenciaFamiliar)
class ViolenciaFamiliarControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/violenciaFamiliar/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.violenciaFamiliarInstanceList.size() == 0
        assert model.violenciaFamiliarInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.violenciaFamiliarInstance != null
    }

    void testSave() {
        controller.save()

        assert model.violenciaFamiliarInstance != null
        assert view == '/violenciaFamiliar/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/violenciaFamiliar/show/1'
        assert controller.flash.message != null
        assert ViolenciaFamiliar.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/violenciaFamiliar/list'

        populateValidParams(params)
        def violenciaFamiliar = new ViolenciaFamiliar(params)

        assert violenciaFamiliar.save() != null

        params.id = violenciaFamiliar.id

        def model = controller.show()

        assert model.violenciaFamiliarInstance == violenciaFamiliar
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/violenciaFamiliar/list'

        populateValidParams(params)
        def violenciaFamiliar = new ViolenciaFamiliar(params)

        assert violenciaFamiliar.save() != null

        params.id = violenciaFamiliar.id

        def model = controller.edit()

        assert model.violenciaFamiliarInstance == violenciaFamiliar
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/violenciaFamiliar/list'

        response.reset()

        populateValidParams(params)
        def violenciaFamiliar = new ViolenciaFamiliar(params)

        assert violenciaFamiliar.save() != null

        // test invalid parameters in update
        params.id = violenciaFamiliar.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/violenciaFamiliar/edit"
        assert model.violenciaFamiliarInstance != null

        violenciaFamiliar.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/violenciaFamiliar/show/$violenciaFamiliar.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        violenciaFamiliar.clearErrors()

        populateValidParams(params)
        params.id = violenciaFamiliar.id
        params.version = -1
        controller.update()

        assert view == "/violenciaFamiliar/edit"
        assert model.violenciaFamiliarInstance != null
        assert model.violenciaFamiliarInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/violenciaFamiliar/list'

        response.reset()

        populateValidParams(params)
        def violenciaFamiliar = new ViolenciaFamiliar(params)

        assert violenciaFamiliar.save() != null
        assert ViolenciaFamiliar.count() == 1

        params.id = violenciaFamiliar.id

        controller.delete()

        assert ViolenciaFamiliar.count() == 0
        assert ViolenciaFamiliar.get(violenciaFamiliar.id) == null
        assert response.redirectedUrl == '/violenciaFamiliar/list'
    }
}
