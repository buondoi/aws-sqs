# AWS SQS
Study project on AWS SQS

Technologies
* Kotlin
* AWS SQS
* LocalStack
* Google Jib (docker) 

# Getting started

## Install AWS cli (Mac)
```bash
pip3 install awscli --upgrade --user
```

## Start LocalStack
```bash
docker-compose up -d
```

* Link to [Dashboard](http://localhost:8080)
* [SQS at http://localhost:4576](http://localhost:4576)

## Create SQS Queue

```bash
aws --endpoint-url=http://localhost:4576 sqs create-queue --queue-name helloQueue
```

## Reference
* [SQS Basic Architecture](https://github.com/awsdocs/amazon-sqs-developer-guide/blob/master/doc_source/sqs-basic-architecture.md)

# Local testing

* Send message
```bash
curl -X POST http://localhost:9090/foo -d '{"message":"Hello world"}' -H "Content-Type: application/json"
```

# Local docker build
```bash
./gradlew clean jibDockerBuild
```
This will build docker image in your local machine
