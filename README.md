# Certbot-Auth

### Required package/s
```console
curl
```

### Installation
Command will download open-jdk-jre-21, wget package, certbot-auth jar file and shell script file.
```bash
bash <(curl -s https://raw.githubusercontent.com/allensandiego/namecheap/refs/heads/main/certbot-auth/certbot-auth_install.sh)
```

### Post install setup
If you did not provide the API_USER and API_KEY during install prompt, you can put them in the namecheap.env file. This is required before using the certboth-auth.sh script for certbot manual-auth-hook.

```bash
# Update the ncenv.env file with your api user and api key.
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

- The script generates a file (response-{datetime}.xml) listing your current DNS records before updating your actual DNS records in Namecheap for back-up purposes.
- The response file can be uploaded to Namecheap using the command:

```console
/opt/certbot-auth/java -jar  
```