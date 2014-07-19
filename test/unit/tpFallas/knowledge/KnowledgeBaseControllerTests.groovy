package tpFallas.knowledge



import org.junit.*
import grails.test.mixin.*

@TestFor(KnowledgeBaseController)
@Mock(KnowledgeBase)
class KnowledgeBaseControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/knowledgeBase/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.knowledgeBaseInstanceList.size() == 0
        assert model.knowledgeBaseInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.knowledgeBaseInstance != null
    }

    void testSave() {
        controller.save()

        assert model.knowledgeBaseInstance != null
        assert view == '/knowledgeBase/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/knowledgeBase/show/1'
        assert controller.flash.message != null
        assert KnowledgeBase.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeBase/list'

        populateValidParams(params)
        def knowledgeBase = new KnowledgeBase(params)

        assert knowledgeBase.save() != null

        params.id = knowledgeBase.id

        def model = controller.show()

        assert model.knowledgeBaseInstance == knowledgeBase
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeBase/list'

        populateValidParams(params)
        def knowledgeBase = new KnowledgeBase(params)

        assert knowledgeBase.save() != null

        params.id = knowledgeBase.id

        def model = controller.edit()

        assert model.knowledgeBaseInstance == knowledgeBase
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeBase/list'

        response.reset()

        populateValidParams(params)
        def knowledgeBase = new KnowledgeBase(params)

        assert knowledgeBase.save() != null

        // test invalid parameters in update
        params.id = knowledgeBase.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/knowledgeBase/edit"
        assert model.knowledgeBaseInstance != null

        knowledgeBase.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/knowledgeBase/show/$knowledgeBase.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        knowledgeBase.clearErrors()

        populateValidParams(params)
        params.id = knowledgeBase.id
        params.version = -1
        controller.update()

        assert view == "/knowledgeBase/edit"
        assert model.knowledgeBaseInstance != null
        assert model.knowledgeBaseInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/knowledgeBase/list'

        response.reset()

        populateValidParams(params)
        def knowledgeBase = new KnowledgeBase(params)

        assert knowledgeBase.save() != null
        assert KnowledgeBase.count() == 1

        params.id = knowledgeBase.id

        controller.delete()

        assert KnowledgeBase.count() == 0
        assert KnowledgeBase.get(knowledgeBase.id) == null
        assert response.redirectedUrl == '/knowledgeBase/list'
    }
}
