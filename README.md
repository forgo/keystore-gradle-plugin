# keystore-gradle-plugin
Plugin to simplify creation of JKS keystores via a key, cert, and an intermediate PKCS12 keystore.

[Gradle Plugin Instructions](https://plugins.gradle.org/plugin/io.forgo.keystoreplugin)

## build.gradle usage
```
keystore {
    // resetOutputDir task defaults
    outputDir = ".keystore"

    // sslKey task defaults
    keyFile = "debug.key"
    keyPassword = "password"
    
    // sslCert task defaults (depends on: sslKey)
    certFile = "debug.crt"
    
    // pkcs12 task defaults (depends on: sslCert)
    pkcs12File = "debug.pkcs12"
    pkcs12Password = "password"
    
    // jks task defaults (depends on: pkcs12)
    jksFile = "debug.jks"
    jksPassword = "password"
    alias = "debug"
}
```

## How to verify keystore information
```
keytool -list -v -keystore keystore.jks
Enter keystore password: <this is the password you used to create the jks keystore>
```
