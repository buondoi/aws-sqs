package io.labs.aws.sqs.bar

import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

/**
 * @author tam.nguyen
 */
@Component
class BarService {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(BarService::class.java)
    }

    @JmsListener(destination = "helloTopic", containerFactory = "defaultJmsListenerContainerFactory")
    fun onHello(jsonMessage: String) {
        LOGGER.info("Just receive this \"$jsonMessage\"")
    }
}