#!/usr/bin/env bash

name=$1
force=0
[ "$2" == "-f" ] && force=1

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
