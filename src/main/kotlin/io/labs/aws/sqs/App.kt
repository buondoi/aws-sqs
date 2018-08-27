package io.labs.aws.sqs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class App

fun main(args: Array<String>) {
    runApplication<App>().run { }
}
