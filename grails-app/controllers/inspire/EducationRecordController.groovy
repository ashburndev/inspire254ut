package inspire



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EducationRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EducationRecord.list(params), model:[educationRecordInstanceCount: EducationRecord.count()]
    }

    def show(EducationRecord educationRecordInstance) {
        respond educationRecordInstance
    }

    def create() {
        respond new EducationRecord(params)
    }

    @Transactional
    def save(EducationRecord educationRecordInstance) {
        if (educationRecordInstance == null) {
            notFound()
            return
        }

        if (educationRecordInstance.hasErrors()) {
            respond educationRecordInstance.errors, view:'create'
            return
        }

        educationRecordInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'educationRecord.label', default: 'EducationRecord'), educationRecordInstance.id])
                redirect educationRecordInstance
            }
            '*' { respond educationRecordInstance, [status: CREATED] }
        }
    }

    def edit(EducationRecord educationRecordInstance) {
        respond educationRecordInstance
    }

    @Transactional
    def update(EducationRecord educationRecordInstance) {
        if (educationRecordInstance == null) {
            notFound()
            return
        }

        if (educationRecordInstance.hasErrors()) {
            respond educationRecordInstance.errors, view:'edit'
            return
        }

        educationRecordInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EducationRecord.label', default: 'EducationRecord'), educationRecordInstance.id])
                redirect educationRecordInstance
            }
            '*'{ respond educationRecordInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EducationRecord educationRecordInstance) {

        if (educationRecordInstance == null) {
            notFound()
            return
        }

        educationRecordInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EducationRecord.label', default: 'EducationRecord'), educationRecordInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'educationRecord.label', default: 'EducationRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
