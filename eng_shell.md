Git commands
===========


## Examples:

```
files=`find .  -name "local.properties.default"`
for ff in $files; do
    dd=`dirname $ff`
    echo $ff    $dd;
    cat $ff | sed "s/android\.sdk\.dir=CHANGE ME/android\.sdk\.dir=\/Users\/haojian\/Development\/adt-bundle-mac-x86_64-20130717\/sdk/g"  > $dd/local.properties
done
```
