Shell commands
===========

## Brew shells

- list the brew packages: `brew list`
- [reinstall a package with homebrew](http://superuser.com/questions/324980/how-do-you-re-install-a-package-with-homebrew-mac)
- Check all available options for ffmpeg with: `brew options ffmpeg`
- Check if your Homebrew installation is up to date and working with `brew doctor`

## Common Aws shells

- check available disk space on aws: `df -h`



[How To scp, ssh and rsync without prompting for password
](https://blogs.oracle.com/jkini/entry/how_to_scp_scp_and)



## Examples:

** file replacement **

```
files=`find .  -name "local.properties.default"`
for ff in $files; do
    dd=`dirname $ff`
    echo $ff    $dd;
    cat $ff | sed "s/android\.sdk\.dir=CHANGE ME/android\.sdk\.dir=\/Users\/haojian\/Development\/adt-bundle-mac-x86_64-20130717\/sdk/g"  > $dd/local.properties
done
```

## Keep task running even disconnect SSH

nohup command



## Background running

```
ctrl + z //stop
bg //running in background
fg //running in foreground
ps //print running process
```

```
ctrl + z //stop
bg //running in background
disown -h [job-spec] where [job-spec] is the job number (like %1 for the first running job; find about your number with the jobs command) so that the job isn't killed when the terminal closes.
ps //print running process
```


```
history | tail
```



## Network

**cURL**
- Get with JSON: `curl -i -H "Accept: application/json" -H "Content-Type: application/json" http://hostname/resource
`
- Get with XML: `curl -H "Accept: application/xml" -H "Content-Type: application/xml" -X GET http://hostname/resource
`
- Data post: `curl --data "param1=value1&param2=value2" http://hostname/resource
`
- File post: `curl --form "fileupload=@filename.txt" http://hostname/resource
`
- Logging: `curl -d "username=admin&password=admin&submit=Login" --dump-header headers http://localhost/Login
curl -L -b headers http://localhost/`


**SSL/HTTPS**

```
openssl s_client -showcerts -connect mobilelogs.labs.yahoo.com:443
```