package admin

import com.example.application.service.admin.AdminService
import com.example.domain.admin.AdminCollectionsRepository
import org.springframework.test.context.ActiveProfiles
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification


@Transactional
@ActiveProfiles(profiles = "local")
class AdminServiceTest extends Specification{

    AdminCollectionsRepository adminCollectionsRepository = Mock(AdminCollectionsRepository)
    AdminService sut = new AdminService(adminCollectionsRepository)

    def "mongo db test"() {
        given: "admin 객체 생성"

        when: "저장"

        then: "저장 확인"

    }
}
