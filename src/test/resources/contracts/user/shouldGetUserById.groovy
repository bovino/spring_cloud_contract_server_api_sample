package user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a user when correct ID is entered"
    request {
        method 'GET'
        url '/user/1'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""{"id":1,"name":"name 1","login":"login 1" }""")
        headers {
            contentType(applicationJson())
        }
    }
}