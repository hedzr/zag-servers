#!/usr/bin/env bash

version='1.0-SNAPSHOT'

# -DskipTests，不执行测试用例，但编译测试用例类生成相应的class文件至target/test-classes下。
# -Dmaven.test.skip=true，不执行测试用例，也不编译测试用例类。

mvn package -Dmaven.test.skip=true && \
for name in main-eureka-server main-config-server \
    main-api-gateway main-hystrix-dashboard \
    main-spring-boot-admin
do
  scp $name/target/$name-$version.jar xt0reg00:~/
  # scp $name/target/$name-$version.jar xt0reg01:~/
done

ssh xt0reg00 'scp ~/*.jar xt0reg01:~/;
for name in main-eureka-server main-config-server \
    main-api-gateway main-hystrix-dashboard \
    main-spring-boot-admin; do \
    sudo systemctl stop $name@$USER.service; sudo systemctl restart $name@obsez.service; \
done
'
