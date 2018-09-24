package io.forgo.plugins.gradle;

import org.gradle.api.Project;

public class KeystoreExtension {

    static final String EXTENSION_NAME = "keystore";

    private static final String DEFAULT_KEY_FILE = "debug.key";
    private static final String DEFAULT_KEY_PASSWORD = "password";
    private static final String DEFAULT_CERT_FILE = "debug.crt";
    private static final String DEFAULT_PKCS12_FILE = "debug.pkcs12";
    private static final String DEFAULT_PKCS12_PASSWORD = "password";
    private static final String DEFAULT_JKS_FILE = "debug.jks";
    private static final String DEFAULT_JKS_PASSWORD = "password";
    private static final String DEFAULT_ALIAS = "debug";

    String keyFile;
    String keyPassword;
    String certFile;
    String pkcs12File;
    String pkcs12Password;
    String jksFile;
    String jksPassword;
    String alias;

    public KeystoreExtension(Project project) {

    }

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

    public String getJksFile() {
        return this.jksFile == null
                ? DEFAULT_JKS_FILE
                : this.jksFile;
    }

    public String getJksPassword() {
        return this.jksPassword == null
                ? DEFAULT_JKS_PASSWORD
                : this.jksPassword;
    }

    public String getAlias() {
        return this.alias == null
                ? DEFAULT_ALIAS
                : this.alias;
    }
}
