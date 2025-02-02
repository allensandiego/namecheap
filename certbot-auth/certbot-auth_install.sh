#!/bin/bash

echo "Installation started."

set -e

appname=certbot-auth
appdir=/opt/$appname
jdk=openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz
ncenv=namecheap.env

if [ ! -d $appdir ]; then
  mkdir -m 755 $appdir
fi

echo "Install wget..."
apt install wget

echo "Installation directory... $appdir"
cd $appdir

echo "Download openjdk-jre-21..." 
wget https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/21.0.3+9/openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz

echo "Unzip openjdk-jre-21..."
chmod 755 -R $appdir/$jdk
tar xvzf $appdir/$jdk

echo "Download namecheap certbot files..."
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh
wget https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/README.md

chmod 755 $appdir/certbot-auth.sh
chmod 755 $appdir/certbot-auth.jar
chmod 755 $appdir/README.md

echo "Enter your namecheap Api User and Api Key"
read -p 'Api User: ' API_USER
read -ps 'Api Key: ' API_KEY

if [ -f "$ncenv" ]; then
  rm $ncenv
fi

echo "API_USER=$API_USER" >> $ncenv
echo "API_KEY=$API_KEY" >> $ncenv

echo "Installation finished."

cat $appdir/README.md



