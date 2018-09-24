package io.forgo.plugins.gradle;

public class KeystoreExtension {
    String keyFile;
    String keyPassword;
    String certFile;
    String pkcs12File;
    String pkcs12Password;
    String keystoreFile;
    String keystorePassword;
    String keystoreAlias;
    
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
