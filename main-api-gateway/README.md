# main-api-gateway

`main-api-gateway` 是一个示意性项目，用于研究目的。

生产环境中部署两套网关，分别用于公网和内网，单独成立项目和单独实现。




## 生产规划中的 API GATEWAY



### 公网接入 `gw-public`

负责 oAuth 2.0, JWT 等认证方案的前置处理。

负责转接公网接入请求：

- wechat 回调
- alipay 回调
- 小程序回调
- 三方接入
- apps接入

负责其他转接事务。




### 内网网关 `gw-internals`

内网网关用于集中所有的微服务的全部 API。

在必要时，可以编写特殊逻辑，以便整合旧的API或者提供向前兼容。


```yaml
obsez:
  useLocalGateway: false      # 是否启用内网网关, EndpointBuilder据此增加 apigw 前缀到 requestUri
```

每个微服务的负载均衡策略配置区中都包含上述的 `useLocalGateway` 定义，该标志会被 配置中心 所覆盖，生产环境将借此机制决定微服务的依赖调用是否经由内网网关中转。


