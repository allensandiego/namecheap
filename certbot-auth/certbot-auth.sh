#!/bin/bash

# Get your Api User and Api Key from env file
. certbot-auth.env

# Execute certbot-auth.jar with the following parameters:
# 1. ApiUser
# 2. ApiKey
# 3. Domain/Subdomain - Passed by cerbot
# 4. TXT value - Passed by certbot

CREATE_DOMAIN="_acme-challenge.$CERTBOT_DOMAIN"

$jdkdir/bin/java -jar certbot-auth.jar "$API_USER" "$API_KEY" "$CERTBOT_DOMAIN" "$CERTBOT_VALIDATION"

retry=1

while [ "$CERTBOT_VALIDATION" != "$TXT" ]; do
  sleep 15
  TXT=$(dig -t txt "$CREATE_DOMAIN" +short | tr -d '"')
  if [ $retry -ge 8 ]; then
    echo "Failed to retrieve certbort certificates. Max retries reached."
    exit 1
  fi
  ((retry++))
done


