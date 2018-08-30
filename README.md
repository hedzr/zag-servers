# zag-servers


## Overview

`zag-system` is a prototype of microservice system, surve to certain a food and beverage company.


The Whole `zag-system` includes:

- zag-common
- zag-servers (with demo services)
- biz-serviecs


### Features

- Dark launching
- Service Governance
- Dynamic Load Balancing
- Hash-based Load Balancing
- Failure Detection & Recovery
- Circuit Break
- Scalability
- Clustering
- Logging
- Monitoring
- ...




## Guide

run these service at first:

- main-eureka-server
- main-api-gateway

and run these optionally:

- main-config-server
- main-hystrix-dashboard
- main-spring-boot-admin

the calling chain trace depends on zipkin server, shortcut is:

```bash
./ci/run-zipkin.sh
```

or browse documentation at <https://zipkin.io/>



## Notes

### Turbine

#### Hystrix Dashboard

fill the address into `Hystrix Dashboard`:

```
http://hystric-dashboard:7776/turbine.stream
```

such as:

<http://192.168.0.71:7776/hystrix/monitor?stream=http%3A%2F%2Flocalhost%3A7776%2Fturbine.stream>



