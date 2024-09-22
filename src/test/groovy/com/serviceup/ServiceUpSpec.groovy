package com.serviceup

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest
class ServiceUpSpec {

    @Autowired
    ApplicationContext context

    def "application context loads"() {
        expect:
        context != null
    }
}
