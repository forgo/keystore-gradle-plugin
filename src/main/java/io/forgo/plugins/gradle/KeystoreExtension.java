package io.forgo.plugins.gradle;

import org.gradle.api.Project;

public class KeystoreExtension {

    private final String keyFile;
    private final String keyPassword;
    private final String certFile;
    private final String pkcs12File;
    private final String pkcs12Password;
    private final String keystoreFile;
    private final String keystorePassword;
    private final String keystoreAlias;

    public KeystoreExtension(Project project) {
        // set default values here
        this.keyFile = "debug.key";
        this.keyPassword = "password";
        this.certFile = "debug.crt";
        this.pkcs12File = "debug.pkcs12";
        this.pkcs12Password = "password";
        this.keystoreFile = "keystore.jks";
        this.keystorePassword = "password";
        this.keystoreAlias = "jetty";
    }

    public String getKeyFile() {
        return keyFile;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public String getCertFile() {
        return certFile;
    }

    public String getPkcs12File() {
        return pkcs12File;
    }

    public String getPkcs12Password() {
        return pkcs12Password;
    }

    public String getKeystoreFile() {
        return keystoreFile;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public String getKeystoreAlias() {
        return keystoreAlias;
    }
}
