package inspire



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EmploymentRecordController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EmploymentRecord.list(params), model:[employmentRecordInstanceCount: EmploymentRecord.count()]
    }

    def show(EmploymentRecord employmentRecordInstance) {
        respond employmentRecordInstance
    }

    def create() {
        respond new EmploymentRecord(params)
    }

    @Transactional
    def save(EmploymentRecord employmentRecordInstance) {
        if (employmentRecordInstance == null) {
            notFound()
            return
        }

        if (employmentRecordInstance.hasErrors()) {
            respond employmentRecordInstance.errors, view:'create'
            return
        }

        employmentRecordInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employmentRecord.label', default: 'EmploymentRecord'), employmentRecordInstance.id])
                redirect employmentRecordInstance
            }
            '*' { respond employmentRecordInstance, [status: CREATED] }
        }
    }

    def edit(EmploymentRecord employmentRecordInstance) {
        respond employmentRecordInstance
    }

    @Transactional
    def update(EmploymentRecord employmentRecordInstance) {
        if (employmentRecordInstance == null) {
            notFound()
            return
        }

        if (employmentRecordInstance.hasErrors()) {
            respond employmentRecordInstance.errors, view:'edit'
            return
        }

        employmentRecordInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EmploymentRecord.label', default: 'EmploymentRecord'), employmentRecordInstance.id])
                redirect employmentRecordInstance
            }
            '*'{ respond employmentRecordInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EmploymentRecord employmentRecordInstance) {

        if (employmentRecordInstance == null) {
            notFound()
            return
        }

        employmentRecordInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EmploymentRecord.label', default: 'EmploymentRecord'), employmentRecordInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employmentRecord.label', default: 'EmploymentRecord'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
