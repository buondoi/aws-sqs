package io.labs.aws.sqs.config

import com.amazon.sqs.javamessaging.ProviderConfiguration
import com.amazon.sqs.javamessaging.SQSConnectionFactory
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sqs.AmazonSQSClientBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.annotation.EnableJms
import org.springframework.jms.config.DefaultJmsListenerContainerFactory
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.support.converter.MappingJackson2MessageConverter
import org.springframework.jms.support.converter.MessageConverter
import org.springframework.jms.support.converter.MessageType
import org.springframework.jms.support.destination.DynamicDestinationResolver
import javax.jms.ConnectionFactory
import javax.jms.Session


/**
 * @author tam.nguyen
 */
@Configuration
@EnableJms
class JmsConfiguration(val sqsConfig: SqsConfig) {

    @Bean
    fun defaultJmsListenerContainerFactory(): DefaultJmsListenerContainerFactory {
        val factory = DefaultJmsListenerContainerFactory()
        factory.setConnectionFactory(connectionFactory())
        factory.setSessionAcknowledgeMode(Session.CLIENT_ACKNOWLEDGE)
        factory.setDestinationResolver(DynamicDestinationResolver())
        factory.setConcurrency("2-5")
        return factory
    }

    @Bean
    fun connectionFactory(): ConnectionFactory {
        val builder = AmazonSQSClientBuilder.standard()
        builder.credentials = DefaultAWSCredentialsProviderChain()
        builder.setEndpointConfiguration(AwsClientBuilder.EndpointConfiguration(sqsConfig.endpoint, sqsConfig.region))
        return SQSConnectionFactory(ProviderConfiguration(), builder)
    }

    @Bean
    fun jmsTemplate(): JmsTemplate {
        val template = JmsTemplate(connectionFactory())
        template.messageConverter = messageConverter()
        return template
    }

    @Bean
    fun messageConverter(): MessageConverter {
        val converter = MappingJackson2MessageConverter()
        converter.setTargetType(MessageType.TEXT)
        converter.setTypeIdPropertyName("_type")
        return converter
    }
}