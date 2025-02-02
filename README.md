# Certbot-Auth

### Required package/s
```console
curl
```

### Installation
Command will download open-jdk-jre-21, wget package, certbot-auth jar file and shell script file.
```bash
curl -sSL https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth_install.sh | bash
```

### Post install setup
Before running the script, need to change some values in the certbot-auth.sh file.

```bash
# Get your API key from https://ap.www.namecheap.com/settings/tools
API_USER="your-namecheap-username"
API_KEY="your-namecheap-api-key"
```

### Running certbot 
 Here's a sample on how to use script on certbot
```bash
sudo certbot certonly --manual --manual-auth-hook /opt/certbot-auth/certbot-auth.sh --preferred-challenges dns --non-interactive -d your.domain.com
```

### Disclaimer
A few notes about the script.

- Tested only Debian 12.
- Tested only domains with less than 10 entries.
- Generates response-{datetime}.xml listing all dns host entries in specified domain and request-{datetime}.txt showing the http get url on the install/application directory.

Use at your own risk.

