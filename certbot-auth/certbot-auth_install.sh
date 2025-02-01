#!/bin/bash

set -e

appname=certbot-auth
appdir=/opt/$appname

mkdir -m 755 $appdir

cd $appdir

curl -s https://github.com/allensandiego/namecheap/raw/refs/heads/main/certbot-auth/certbot-auth.jar
curl -s https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth.sh


