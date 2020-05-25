package user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a user when correct ID is entered"
    request {
        method 'GET'
        url '/user/10'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""{"id":10,"name":"name test 10","login":"login test 10" }""")
        headers {
            contentType(applicationJson())
        }
    }
}