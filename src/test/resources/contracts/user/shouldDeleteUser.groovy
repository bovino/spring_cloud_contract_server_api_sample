package user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return entered user"
    request {
        method 'DELETE'
        url '/user'
        headers {
            contentType(applicationJson())
        }
        body("""[1,2]""")
    }
    response {
        status 200
    }
}