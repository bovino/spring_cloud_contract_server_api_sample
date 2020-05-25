package user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return a list of users"
    request {
        method 'GET'
        url '/user'
        headers {
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body("""[{"id":1,"name":"name 1","login":"login 1" },{"id":2,"name":"name 2","login":"login 2" }]""")
        headers {
            contentType(applicationJson())
        }
    }
}