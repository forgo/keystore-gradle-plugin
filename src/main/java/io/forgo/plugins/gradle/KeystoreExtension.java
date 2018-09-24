package io.forgo.plugins.gradle;

import org.gradle.api.Project;
import org.gradle.api.tasks.Input;

public class KeystoreExtension {

    @Input
    private String keyFile;

    @Input
    private String keyPassword;

    @Input
    private String certFile;

    @Input
    private String pkcs12File;

    @Input
    private String pkcs12Password;

    @Input
    private String keystoreFile;

    @Input
    private String keystorePassword;

    @Input
    private String keystoreAlias;

    public KeystoreExtension(Project project) {
        // set default values here
        this.keyFile = "debug.key";
        this.keyPassword = "password";
        this.certFile = "debug.crt";
        this.pkcs12File = "debug.pkcs12";
        this.pkcs12Password = "password";
        this.keystoreFile = "keystore";
        this.keystorePassword = "password";
        this.keystoreFile = "keystore.jks";
        this.keystoreAlias = "jetty";
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public String getKeyPassword() {
        return keyPassword;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public String getCertFile() {
        return certFile;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    public String getPkcs12File() {
        return pkcs12File;
    }

    public void setPkcs12File(String pkcs12File) {
        this.pkcs12File = pkcs12File;
    }

    public String getPkcs12Password() {
        return pkcs12Password;
    }

    public void setPkcs12Password(String pkcs12Password) {
        this.pkcs12Password = pkcs12Password;
    }

    public String getKeystoreFile() {
        return keystoreFile;
    }

    public void setKeystoreFile(String keystoreFile) {
        this.keystoreFile = keystoreFile;
    }

    public String getKeystorePassword() {
        return keystorePassword;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public String getKeystoreAlias() {
        return keystoreAlias;
    }

    public void setKeystoreAlias(String keystoreAlias) {
        this.keystoreAlias = keystoreAlias;
    }
}
