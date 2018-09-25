# keystore-gradle-plugin
Plugin to simplify creation of JKS keystores via a key, cert, and an intermediate PKCS12 keystore.

## Description
This plugin will add the following gradle tasks, the arrows indicate the task dependencies:

`jks` <- `pkcs12` <- `sslCert` <- `sslKey` <- `resetOutputDir`

In other words, if you ran the `sslCert` by itself, it would run `resetOutputDir`, `sslKey`, `sslCert`, in that order.

This hierarchy ensures availability and consistency of products which allowed the final product to be derived.

For example, having the raw public cert (`.crt`) can be a valuable deployment asset in a distributed system in addition to having a secure JKS keystore itself.

Originally designed as a convenience, this plugin simplifies deploying development artifacts which closely resemble a production environment by enabling HTTPS/SSL. Production keys, certs, and keystores should obviously not obviously be used in development; however, this plugin could likely be used as a starting point for production-ready artifacts. This plugin does **not** deal with CSRs (certificate signing requests) to be signed by various certificate authorities.

## Links

- [Gradle Plugin Instructions](https://plugins.gradle.org/plugin/io.forgo.keystoreplugin)
  - official gradle plugin page
- [Java Spark Framework](https://github.com/forgo/sparkjava-demo) 
  - demonstrates plugin's flexibility in running via IDE and generating Docker images

## build.gradle usage
```
plugins {
  id "io.forgo.keystoreplugin" version "1.0"
}

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
