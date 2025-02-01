#!/bin/bash

set -e

appname=certbot-auth
appdir=/opt/$appname

if [ ! -d $appdir ]; then
  mkdir -m 755 $appdir
fi

cd $appdir

curl -sSL https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/21.0.3+9/openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz | tar xz
curl -sSL https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh -output certbot-auth.sh
curl -sSL https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar -output certbot-auth.jar

chmod 755 -R openjdk-jre-21
chmod 755 certbot-auth.sh
chmod 755 certbot-auth.jar



