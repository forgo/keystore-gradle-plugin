# keystore-gradle-plugin
Plugin to simplify creation of JKS keystores via a key, cert, and an intermediate PKCS12 keystore.

## Description
This plugin will add the following gradle tasks, the arrows indicate the task dependencies:

`jks` <- `pkcs12` <- `sslCert` <- `sslKey` <- `resetOutputDir`

This hierarchy ensures availability and consistency of products which allowed the final product to be derived.

For example, if you ran the `sslCert` task by itself, the following tasks would be run:
1. `resetOutputDir`
2. `sslKey`
3. `sslCert`
 
And the following products would be generated relative to your gradle build directory:
- ${buildDir}/${outputDir = .keystore}/${keyFile = debug.key}
- ${buildDir}/${outputDir = .keystore}/${keyFile = debug.crt}

The `pkcs12` and `jks` keystores would not be available in your output directory, in this case.
 
If desired, the `outputDir` and file names can be overriden with the `keystore { ... }` extension.

See [buid.gradle example](#buildgradle).


## Why would I use this?

Maintaining private keys and public certs (and their derivative artifacts) in a consistent state can be an exercise in frustration and wasted time. This plugin is designed to help eliminate some natural second-guessing help create a consistent development workflow.

For example, having the raw public cert (`.crt`) can be a valuable deployment asset in a distributed system in addition to having a secure `.jks` keystore itself. 

If you are encrypting and version-controlling these artifacts manually, there is a risk of one being updated without the other or discovering that you need to regenerate these artifacts due to credentials changing. Not having a simple or documented workflow for generating these artifacts can lead to multiple stale copies being used in different contexts.

Originally designed as a convenience, this plugin simplifies deploying development artifacts which closely resemble a production environment by enabling HTTPS/SSL.

Production keys, certs, and keystores should obviously not be used in development; however, this plugin could likely be used as a starting point for production-ready artifacts. This plugin does **not** deal with CSRs (certificate signing requests) to be signed by various certificate authorities.

## Links

- [Gradle Plugin Instructions](https://plugins.gradle.org/plugin/io.forgo.keystoreplugin)
  - official gradle plugin page
- [Java Spark Framework](https://github.com/forgo/sparkjava-demo) 
  - demonstrates plugin's flexibility in running via IDE and generating Docker images

## build.gradle
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

## What the tasks do under the hood:

### sslKey
```
openssl genrsa -des3 \
-out ${pathKeyFile} \
-passout pass:${keyPassword}
```

### sslCert
```
openssl req -new -x509 \
-key ${pathKeyFile} \
-out ${pathCertFile} \
-passin pass:${keyPassword} \
-subj /C=US
```

### pkcs12
```
openssl pkcs12 \
-inkey ${pathKeyFile} \
-in ${pathCertFile} \
-export \
-out ${pathPKCS12File} \
-passin pass:${keyPassword} \
-password pass:${pkcs12Password} \
-name ${keystoreAlias}
```

### jks
```
keytool -importkeystore \
-srcstoretype PKCS12 \
-srckeystore ${pathPkcs12File} \
-srcstorepass ${pkcs12Password} \
-destkeystore ${pathJksFile} \
-storepass ${jksPassword}
```

### resetOutputDir
Creates `${outputDir}` if it doesn't exist; otherwise, deletes all regular files within `${outputDir}`.

## How to verify keystore information
```
keytool -list -v -keystore keystore.jks
Enter keystore password: <this is the password you used to create the jks keystore>
```
