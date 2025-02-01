#!/bin/bash

echo "Installation started."

set -e

appname=certbot-auth
appdir=/opt/$appname
javadir=$appdir/openjdk-jre-21

if [ ! -d $appdir ]; then
  mkdir -m 755 $appdir
fi

echo "Install wget..."
apt install wget

echo "Installation directory... $appdir"
cd $appdir

echo "Download openjdk-jre-21..." 
wget -O openjdk-jre-21.tar.gz https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/21.0.3+9/openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz

echo "Unzip openjdk-jre-21..."
chmod 755 -R $appdir/openjdk-jre-21.tar.gz
tar -xv $appdir/openjdk-jre-21.tar.gz --transform $javadir

echo "Download namecheap certbot files..."
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh
wget https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/README.md

chmod 755 $appdir/certbot-auth.sh
chmod 755 $appdir/certbot-auth.jar
chmod 755 $appdir/README.md

echo "Installation finished."

cat $appdir/README.md



