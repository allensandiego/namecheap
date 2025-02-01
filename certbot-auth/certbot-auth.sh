#!/bin/bash

# Get your API key from https://ap.www.namecheap.com/settings/tools
API_USER="your-namecheap-username"
API_KEY="your-namecheap-api-key"

# Execute certbot-auth.jar with the following parameters:
# 1. ApiUser
# 2. ApiKey
# 3. Domain/Subdomain - Passed by cerbot
# 4. TXT value - Passed by certbot

CREATE_DOMAIN="_acme-challenge.$CERTBOT_DOMAIN"

/opt/certbot-auth/openlogic-openjdk-jre-21.0.3+9-linux-x64/bin/java -jar certbot-auth.jar "$API_USER" "$API_KEY" "$CERTBOT_DOMAIN" "$CERTBOT_VALIDATION"

retry=1

TXT=$(dig -t txt "$CREATE_DOMAIN" +short | tr -d '"')

while [ "$CERTBOT_VALIDATION" != "$TXT" ]; do
  TXT=$(dig -t txt "$CREATE_DOMAIN" +short | tr -d '"')
  sleep 30
  if [ $retry -ge 4 ]; then
    echo "Failed to retrieve certbort certificates. Max retries reached."
    exit 1
  fi
  ((retry++))
done


