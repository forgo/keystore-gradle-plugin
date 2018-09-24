# keystore-gradle-plugin
Plugin to simplify creation of JKS keystores via a key, cert, and an intermediate PKCS12 keystore.

[Gradle Plugin Instructions](https://plugins.gradle.org/plugin/io.forgo.keystoreplugin)


## How to verify keystore information
```
keytool -list -v -keystore keystore.jks
Enter keystore password: <this is the password you used to create the jks keystore>
```
