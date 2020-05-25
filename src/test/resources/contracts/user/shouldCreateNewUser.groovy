package user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return entered user"
    request {
        method 'POST'
        url '/user'
        headers {
            contentType(applicationJson())
        }
        body("""{"id":1,"name":"new username 1","login":"new login 1" }""")
    }
    response {
        status 200
        body("""{"id":1,"name":"new username 1","login":"new login 1" }""")
        headers {
            contentType(applicationJson())
        }
    }
}