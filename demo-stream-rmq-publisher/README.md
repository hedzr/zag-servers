# Guide

1. 首先在本机启动 rabbitmq 服务器
2. 首次运行前先 `mvn package`

#### install rabbitmq

```bash
brew install rabbitmq
```

然后：

```bash
brew services start rabbitmq
# or run it at foreground:
/usr/local/Cellar/rabbitmq/3.7.5/sbin/rabbitmq-server
# 或者
/usr/local/sbin/rabbitmq-server
```

#### 运行

java -jar 或 mvn springboot:run 均可。

~~默认状态启动之后，可在控制台查阅日志：~~

~~```~~
~~Sending message...~~
~~Received <Hello from RabbitMQ!>~~
~~```~~

~~这是由 `Runner` 负责在 Springboot 启动成功后发出的测试消息。~~


#### 测试用例发出消息

~~在应用启动之后，还可以单独运行测试用例来发出消息~~

#### RESTful API 发出消息

/mq/send/<string>















