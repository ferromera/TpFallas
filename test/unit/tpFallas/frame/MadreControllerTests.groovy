package tpFallas.frame



import org.junit.*
import grails.test.mixin.*

@TestFor(MadreController)
@Mock(Madre)
class MadreControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/madre/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.madreInstanceList.size() == 0
        assert model.madreInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.madreInstance != null
    }

    void testSave() {
        controller.save()

        assert model.madreInstance != null
        assert view == '/madre/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/madre/show/1'
        assert controller.flash.message != null
        assert Madre.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/madre/list'

        populateValidParams(params)
        def madre = new Madre(params)

        assert madre.save() != null

        params.id = madre.id

        def model = controller.show()

        assert model.madreInstance == madre
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/madre/list'

        populateValidParams(params)
        def madre = new Madre(params)

        assert madre.save() != null

        params.id = madre.id

        def model = controller.edit()

        assert model.madreInstance == madre
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/madre/list'

        response.reset()

        populateValidParams(params)
        def madre = new Madre(params)

        assert madre.save() != null

        // test invalid parameters in update
        params.id = madre.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/madre/edit"
        assert model.madreInstance != null

        madre.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/madre/show/$madre.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        madre.clearErrors()

        populateValidParams(params)
        params.id = madre.id
        params.version = -1
        controller.update()

        assert view == "/madre/edit"
        assert model.madreInstance != null
        assert model.madreInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/madre/list'

        response.reset()

        populateValidParams(params)
        def madre = new Madre(params)

        assert madre.save() != null
        assert Madre.count() == 1

        params.id = madre.id

        controller.delete()

        assert Madre.count() == 0
        assert Madre.get(madre.id) == null
        assert response.redirectedUrl == '/madre/list'
    }
}
