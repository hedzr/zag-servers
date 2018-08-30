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



## LICENSE

MIT

```
Copyright 2015-2018 Hedzr Yeh

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
