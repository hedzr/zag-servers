#!/bin/bash

TGT_DIR=$(dirname $0)/../ci/zipkin
#echo $TGT_DIR
#exit 0

[ -d $TGT_DIR ] || mkdir -p $TGT_DIR
[ -f $TGT_DIR/zipkin.jar ] || {
    pushd $TGT_DIR >/dev/null
    curl -sSL https://zipkin.io/quickstart.sh | bash -s
    popd >/dev/null
}

[ -f $TGT_DIR/zipkin.jar ] && {
    OPTIONS=' --logging.level.zipkin=DEBUG --logging.level.zipkin2=DEBUG'
    nohup java -jar $TGT_DIR/zipkin.jar $OPTIONS >/tmp/zipkin-server.nohup.out 2>&1 &
    open http://localhost:9411/
}
