#!/bin/bash

appname=certbot-auth
appdir=/opt/$appname

mkdir -m 755 $appdir

cd $appdir

curl -s https://github.com/allensandiego/namecheap/blob/main/certbot-auth/certbot-auth.jar
curl -s https://github.com/allensandiego/namecheap/blob/main/certbot-auth/certbot-auth.sh


