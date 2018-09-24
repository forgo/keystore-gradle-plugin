package io.forgo.plugins.gradle;

public class KeystoreExtension {

    static final String EXTENSION_NAME = "keystore";

    private static final String DEFAULT_KEY_FILE = "debug.key";
    private static final String DEFAULT_KEY_PASSWORD = "password";
    private static final String DEFAULT_CERT_FILE = "debug.crt";
    private static final String DEFAULT_PKCS12_FILE = "debug.pkcs12";
    private static final String DEFAULT_PKCS12_PASSWORD = "password";
    private static final String DEFAULT_KEYSTORE_FILE = "debug.jks";
    private static final String DEFAULT_KEYSTORE_PASSWORD = "password";
    private static final String DEFAULT_KEYSTORE_ALIAS = "my_alias";

    String keyFile;
    String keyPassword;
    String certFile;
    String pkcs12File;
    String pkcs12Password;
    String keystoreFile;
    String keystorePassword;
    String keystoreAlias;

    public String getKeyFile() {
        return this.keyFile == null
                ? DEFAULT_KEY_FILE
                : this.keyFile;
    }

    public String getKeyPassword() {
        return this.keyPassword == null
                ? DEFAULT_KEY_PASSWORD
                : this.keyPassword;
    }

    public String getCertFile() {
        return this.certFile == null
                ? DEFAULT_CERT_FILE
                : this.certFile;
    }

    public String getPkcs12File() {
        return this.pkcs12File == null
                ? DEFAULT_PKCS12_FILE
                : this.pkcs12File;
    }

    public String getPkcs12Password() {
        return this.pkcs12Password == null
                ? DEFAULT_PKCS12_PASSWORD
                : this.pkcs12Password;
    }

    public String getKeystoreFile() {
        return this.keystoreFile == null
                ? DEFAULT_KEYSTORE_FILE
                : this.keystoreFile;
    }

    public String getKeystorePassword() {
        return this.keystorePassword == null
                ? DEFAULT_KEYSTORE_PASSWORD
                : this.keystorePassword;
    }

    public String getKeystoreAlias() {
        return this.keystoreAlias == null
                ? DEFAULT_KEYSTORE_ALIAS
                : this.keystoreAlias;
    }

    public void setKeyFile(final String keyFile) {
        this.keyFile = keyFile == null
                ? DEFAULT_KEY_FILE
                : keyFile;
    }

    public void setKeyPassword(final String keyPassword) {
        this.keyPassword = keyPassword == null
                ? DEFAULT_KEY_PASSWORD
                : keyPassword;
    }

    public void setCertFile(final String certFile) {
        this.certFile = certFile == null
                ? DEFAULT_CERT_FILE
                : certFile;
    }

    public void setPkcs12File(final String pkcs12File) {
        this.pkcs12File = pkcs12File == null
                ? DEFAULT_PKCS12_FILE
                : pkcs12File;
    }

    public void setPkcs12Password(final String pkcs12Password) {
        this.pkcs12Password = pkcs12Password == null
                ? DEFAULT_PKCS12_PASSWORD
                : pkcs12Password;
    }

    public void setKeystoreFile(final String keystoreFile) {
        this.keystoreFile = keystoreFile == null
                ? DEFAULT_KEYSTORE_FILE
                : keystoreFile;
    }

    public void setKeystorePassword(final String keystorePassword) {
        this.keystorePassword = keystorePassword == null
                ? DEFAULT_KEYSTORE_PASSWORD
                : keystorePassword;
    }

    public void setKeystoreAlias(final String keystoreAlias) {
        this.keystoreAlias = keystoreAlias == null
                ? DEFAULT_KEYSTORE_ALIAS
                : keystoreAlias;
    }
}
