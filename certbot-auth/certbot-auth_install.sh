#!/bin/bash

set -e

appname=certbot-auth
appdir=/opt/$appname

if [ ! -d $appdir ]; then
  mkdir -m 755 $appdir
fi

cd $appdir

apt install wget

wget -O openjdk-jre-21.tar.gz https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/21.0.3+9/openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh
wget https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar

tar -xv openjdk-jre-21.tar.gz

chmod 755 -R openjdk-jre-21
chmod 755 certbot-auth.sh
chmod 755 certbot-auth.jar



