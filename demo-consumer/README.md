# demo-consumer and demo-provider

```yaml

obsez:
  # 微服务在这里宣告自己对其他服务的依赖
  # 首要用途是避免硬编码公共设施或核心服务的名称(service-id)，请通过此处的映射提取设施的服务ID。
  # 不必试图提取本表来建构依赖关系，调用链依赖关系可以在zipkin server中直接读出真实的链条。
  depends:
    registrar: main-eureka-server
    gateway: main-api-gateway
    gatewayLocal: main-api-gateway
    config: main-config-server
    badmin: main-spring-boot-admin
    zipkin: main-zipkin-server
    hystrix: main-hystrix-dashboard
    demo-provider: service-demo-provider
  #
  # 灰度发布所需要的负载均衡
  #
  lb:
# 暂不支持
#    ms-*:
#      current: vw
#      weighted: [30,30,40]  #适用于 weighted rr/random
#      ip-hash:
#      uri-hash:
#      url: # 未实现
#        "/**"
#      hdr: jwt
#      cookie: jwt
#      hdrcookie: jwt
#      vw:
#        1.0-SNAPSHOT: 100
#        3.0-SNAPSHOT: 0
#        1.0.RELEASE: 0
    ms-access:
      1.0-SNAPSHOT: 100
      3.0-SNAPSHOT: 0
      1.0.RELEASE: 0
      #暂不支持 ~: 0
    ms-user:
      1.0-SNAPSHOT: 100
      ~: 0
    ms-account:
      1.0-SNAPSHOT: 100
      #~: 0
    service-demo-provider:
      1.0-SNAPSHOT: 90
      1.0.1-SNAPSHOT: 10
      #~: 10
  zaglb:
    lbPrefer: vw              # 算法选择：vw/random/poll -> 灰度发布专用/标准的random/标准的RoundRobin
  useLocalGateway: false      # 是否启用内网网关, EndpointBuilder据此增加 apigw 前缀到 requestUri

# 负载均衡算法指定
service-demo-provider:
  ribbon:
    #NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule
    NFLoadBalancerRuleClassName: com.obsez.zag.common.lb.ZagRule
main-api-gateway:
  ribbon:
    #NFLoadBalancerRuleClassName: com.netflix.loadbalancer.WeightedResponseTimeRule
    NFLoadBalancerRuleClassName: com.obsez.zag.common.lb.ZagRule
```

不启用内网网关的情况下，服务间直接调用，借助注册中心提供的端点信息。

此时，可以启动若干个 demo-provider 实例，然后通过bash发出批量调用来确认灰度发布权重按照版本号的不同正确分流：

```bash


java -jar main-eureka-server-1.0-SNAPSHOT.jar  # :8761
java -jar main-config-server-1.0-SNAPSHOT.jar  # :8888

java -jar demo-consumer-1.0-SNAPSHOT.jar       # :8765

java -jar demo-provider-1.0-SNAPSHOT.jar       # :8764
java -jar demo-provider-1.0-SNAPSHOT.jar --server.port=8763 --version.number=1.0.1-SNAPSHOT
java -jar demo-provider-1.0-SNAPSHOT.jar --server.port=8762 --version.number=1.0.1-SNAPSHOT

for ((i=0; i<1000; i++)); do curl http://localhost:8765/ribbon/server-info; done

```

按照默认配置（see `obsez` chapter in `application.yml`）, 1.0 和 1.0.1 的分流比例应该在 9:1。
