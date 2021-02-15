package inspire



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CaseSectionController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CaseSection.list(params), model:[caseSectionInstanceCount: CaseSection.count()]
    }

    def show(CaseSection caseSectionInstance) {
        respond caseSectionInstance
    }

    def create() {
        respond new CaseSection(params)
    }

    @Transactional
    def save(CaseSection caseSectionInstance) {
        if (caseSectionInstance == null) {
            notFound()
            return
        }

        if (caseSectionInstance.hasErrors()) {
            respond caseSectionInstance.errors, view:'create'
            return
        }

        caseSectionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'caseSection.label', default: 'CaseSection'), caseSectionInstance.id])
                redirect caseSectionInstance
            }
            '*' { respond caseSectionInstance, [status: CREATED] }
        }
    }

    def edit(CaseSection caseSectionInstance) {
        respond caseSectionInstance
    }

    @Transactional
    def update(CaseSection caseSectionInstance) {
        if (caseSectionInstance == null) {
            notFound()
            return
        }

        if (caseSectionInstance.hasErrors()) {
            respond caseSectionInstance.errors, view:'edit'
            return
        }

        caseSectionInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CaseSection.label', default: 'CaseSection'), caseSectionInstance.id])
                redirect caseSectionInstance
            }
            '*'{ respond caseSectionInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CaseSection caseSectionInstance) {

        if (caseSectionInstance == null) {
            notFound()
            return
        }

        caseSectionInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CaseSection.label', default: 'CaseSection'), caseSectionInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'caseSection.label', default: 'CaseSection'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
