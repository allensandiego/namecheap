#!/bin/bash

# Get your API key from https://ap.www.namecheap.com/settings/tools
API_USER="your namecheap username"
API_KEY="your namecheap api-key"
EMAIL="your.email@example.com"

# Execute certbot-auth.jar with the following parameters:
# 1. ApiUser
# 2. ApiKey
# 3. Domain/Subdomain - Passed by cerbot
# 4. TXT value - Passed by certbot
java -jar certbot-auth.jar "$API_USER" "$API_KEY" "$CERTBOT_DOMAIN" "$CERTBOT_VALIDATION" 

TXT=$(dig -t txt "$CERTBOT_DOMAIN" +short | tr -d '"')

retry=1

while (( "$CERTBOT_VALIDATION" != "$TXT" )); do
  sleep 15
  if [ $retry -ge 5 ]; then
    echo "Failed to retrieve certbort certificates. Max retries reached."
    exit 1
  fi
  ((retry++))
done


