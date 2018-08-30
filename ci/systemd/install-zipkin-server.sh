#!/usr/bin/env bash

name=$1
force=0
[ "$2" == "-f" ] && force=1

install-systemd () {
  [ -f $name/target/$name-1.0-SNAPSHOT.jar ] && {
    [ $force -eq 1 ] && sudo rm -f /etc/default/$name
    sudo cp -f ci/systemd/default /etc/default/$name
    [ $force -eq 1 ] && sudo rm -f /etc/systemd/system/$name.service
    sudo cp -f ci/systemd/main.service /etc/systemd/system/$name.service
    sudo sed -i "s/main-eureka-server/$name/g" /etc/systemd/system/$name.service
    sudo systemctl daemon-reload
    sudo mkdir /var/{lib,run,log}/$name
    sudo chown -R suwei: /var/{lib,run,log}/$name
    echo "install $name ok"
  }
}

get-zipkin () {

    TGT_DIR=$(dirname $0)/../../ci/zipkin
    #echo $TGT_DIR
    #exit 0

    [ -d $TGT_DIR ] || mkdir -p $TGT_DIR
    [ -f $TGT_DIR/zipkin.jar ] || {
        pushd $TGT_DIR >/dev/null
        curl -sSL https://zipkin.io/quickstart.sh | bash -s
        popd >/dev/null
    }

    #[ -f $TGT_DIR/zipkin.jar ] && {
    #    OPTIONS=' --logging.level.zipkin=DEBUG --logging.level.zipkin2=DEBUG'
    #    nohup java -jar $TGT_DIR/zipkin.jar $OPTIONS >/tmp/zipkin-server.nohup.out 2>&1 &
    #    open http://localhost:9411/
    #}

}

cp-service-file(){
    sudo cat >/etc/default/zipkin-server<<EOF

JAVA_OPTS=""
OPTIONS="--logging.level.zipkin=DEBUG --logging.level.zipkin2=DEBUG"

EOF
    sudo cat >/etc/systemd/system/zipkin-server.service<<EOF
[Install]
WantedBy=multi-user.target

[Unit]
Description=zipkin-server
# Documentation=man:sshd(8) man:sshd_config(5)
After=network.target
# Wants=syslog.service
#ConditionPathExists=/usr/local/bin/zipkin-server

[Service]
Type=idle
User=suwei
Group=suwei
LimitNOFILE=65535

KillMode=process
Restart=on-failure
RestartSec=23s
# RestartLimitIntervalSec=60

EnvironmentFile=/etc/default/zipkin-server
WorkingDirectory=/var/lib/zipkin-server
#          start: --addr, --port,
#           todo: --pid
# global options: --config
#ExecStart=/usr/local/bin/zipkin-server \$GLOBAL_OPTIONS server start \$OPTIONS
ExecStart=/usr/bin/java -Dsun.misc.URLClassPath.disableJarChecking=true -jar /data/codes/zag-sw-servers/ci/zipkin/zipkin.jar \$OPTIONS
#           stop: -1/--hup, -9/--kill,
ExecStop=kill \$MAINPID
Restart=always

# # make sure log directory exists and owned by syslog
# PermissionsStartOnly=true
#ExecStartPre=-mkdir /var/run/zipkin-server
#ExecStartPre=-mkdir /var/lib/zipkin-server
#ExecStartPre=-mkdir /var/logzipkin-server
#ExecStartPre=-/bin/chown -R suwei:suwei /var/run/zipkin-server /var/lib/zipkin-server
#ExecStartPre=-/bin/chown -R syslog:adm /var/logzipkin-server

# 使能coredump
# ExecStartPre=ulimit -c unlimited

StandardOutput=syslog
StandardError=syslog
SyslogIdentifier=zipkin-server

# After modified, run: systemctl daemon-reload
EOF
}

get-zipkin
cp-service-file

name=zipkin-server
    sudo systemctl daemon-reload
    sudo mkdir /var/{lib,run,log}/$name
    sudo chown -R suwei: /var/{lib,run,log}/$name
    echo "install $name ok"
