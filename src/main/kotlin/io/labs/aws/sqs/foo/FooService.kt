package io.labs.aws.sqs.foo

import io.labs.aws.sqs.message.HelloMessage
import org.slf4j.LoggerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.stereotype.Component

/**
 * @author tam.nguyen
 */
@Component
class FooService(val jmsTemplate: JmsTemplate) {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(FooService::class.java)
    }

    fun send(msg: HelloMessage) {
        jmsTemplate.convertAndSend("helloTopic", msg)
        LOGGER.info("Just send an hello message")
    }
}