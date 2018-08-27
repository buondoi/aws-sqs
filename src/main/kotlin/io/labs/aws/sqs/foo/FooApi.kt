package io.labs.aws.sqs.foo

import io.labs.aws.sqs.message.HelloMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author tam.nguyen
 */
@RestController
@RequestMapping(path = ["/foo"])
class FooApi(private val fooService: FooService) {

    @PostMapping(consumes = ["application/json"], produces = ["application/json"])
    fun sendMessage(@RequestBody message: FooMessage): FooMessage {
        fooService.send(HelloMessage(msg = message.message))
        return message
    }
}

class FooMessage {

    lateinit var message: String
}