# AWS SQS
Study project on sending and receiving message via AWS SQS

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
aws --endpoint-url=http://localhost:4576 sqs create-queue --queue-name helloTopic
```

## Reference
* [SQS Basic Architecture](https://github.com/awsdocs/amazon-sqs-developer-guide/blob/master/doc_source/sqs-basic-architecture.md)

# Local testing

* Send message
```bash
curl -X POST http://localhost:9090/foo -d '{"message":"Hello world"}' -H "Content-Type: application/json"
```

