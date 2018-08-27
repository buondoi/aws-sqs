package io.labs.aws.sqs

import io.labs.aws.sqs.bar.BarService
import io.labs.aws.sqs.foo.FooService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class AppTests {

    @Autowired
    lateinit var fooService: FooService

    @Autowired
    lateinit var barService: BarService

    @Test
    fun contextLoads() {

    }
}
