package io.labs.aws.sqs.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

/**
 * @author tam.nguyen
 */
@Configuration
@ConfigurationProperties(prefix = "spring.sqs")
class SqsConfig {

    lateinit var endpoint: String
    lateinit var region: String
}