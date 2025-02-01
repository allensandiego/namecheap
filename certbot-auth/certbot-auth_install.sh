#!/bin/bash

set -e

apt install wget -y

appname=certbot-auth
appdir=/opt/$appname

if [ ! -d $appdir ]; then
  mkdir -m 755 $appdir
fi

cd $appdir

curl -sSL https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/21.0.3+9/openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz --output openjdk-jre-21.tar.gz | tar -xvzf
curl -sSL https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh -o
curl -sSL https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar -o

chmod 755 openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz
chmod 755 certbot-auth.sh
chmod 755 certbot-auth.jar



