#!/bin/bash

jdk=openlogic-openjdk-jre-21.0.3+9-linux-x64

appname=certbot-auth
appdir=/opt/$appname
jdkdir=$appdir/$jdk

echo
echo "Installation started."

echo
echo "Install wget..."
apt install wget

echo
echo "Installation directory... $appdir"
if [ ! -d $appdir ]; then
  mkdir -m 755 $appdir
fi

cd $appdir

echo "jdk=$jdk" >> certbot-auth.env
echo "appname=$appname" >> certbot-auth.env
echo "appdir=$appdir" >> certbot-auth.env
echo "jdkdir=$jdkdir" >> certbot-auth.env

echo
echo "Download openjdk-jre-21..." 
wget https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/21.0.3+9/openlogic-openjdk-jre-21.0.3+9-linux-x64.tar.gz

echo
echo "Unzip openjdk-jre-21..."
chmod 755 -R $appdir/$jdk.tar.gz
tar xvzf $appdir/$jdk.tar.gz

echo
echo "Download namecheap certbot files..."
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh
wget https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar
wget https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/README.md

chmod 755 $appdir/certbot-auth.sh
chmod 755 $appdir/certbot-auth.jar
chmod 755 $appdir/README.md

echo
echo "Enter your namecheap Api User and Api Key"
read -p "Api User: " API_USER
read -p "Api Key: " API_KEY

echo
echo "API_USER=$API_USER" >> $appdir/certbot-auth.env
echo "API_KEY=$API_KEY" >> $appdir/certbot-auth.env

echo
echo "Installation finished."

cat $appdir/README.md



