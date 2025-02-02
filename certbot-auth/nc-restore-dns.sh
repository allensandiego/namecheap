#!/bin/bash

. certbot-auth.env

$jdkdir/bin/java -jar $appdir/certbort-auth.jar com.asandiego.nc.Restore "$API_USER" "$API_KEY" "$CERTBOT_DOMAIN" "$1"