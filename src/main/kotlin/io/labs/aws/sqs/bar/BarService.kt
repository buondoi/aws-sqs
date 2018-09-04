package io.labs.aws.sqs.bar

import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component
import javax.jms.Message
import javax.jms.TextMessage

/**
 * @author tam.nguyen
 */
@Component
class BarService {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(BarService::class.java)
    }

    /**
     * Listen on helloQueue. It's FIFO queue.
     */
    @JmsListener(destination = "helloQueue", containerFactory = "defaultJmsListenerContainerFactory")
    fun onMessage(message: Message) {
        if (message is TextMessage) {
            LOGGER.info("Just receive this \"${message.text}\"")
            message.acknowledge()
        }
    }
}