package io.forgo.plugins.gradle;

import org.gradle.api.Project;

public class KeystoreExtension {

    static final String EXTENSION_NAME = "keystore";

    private static final String DEFAULT_OUTPUT_DIR = ".keystore";
    private static final String DEFAULT_KEY_FILE = "debug.key";
    private static final String DEFAULT_KEY_PASSWORD = "password";
    private static final String DEFAULT_CERT_FILE = "debug.crt";
    private static final String DEFAULT_PKCS12_FILE = "debug.pkcs12";
    private static final String DEFAULT_PKCS12_PASSWORD = "password";
    private static final String DEFAULT_JKS_FILE = "debug.jks";
    private static final String DEFAULT_JKS_PASSWORD = "password";
    private static final String DEFAULT_ALIAS = "debug";

    private String outputDir;
    private String keyFile;
    private String keyPassword;
    private String certFile;
    private String pkcs12File;
    private String pkcs12Password;
    private String jksFile;
    private String jksPassword;
    private String alias;

    public KeystoreExtension(Project project) {
        // set defaults
        this.outputDir = DEFAULT_OUTPUT_DIR;
        this.keyFile = DEFAULT_KEY_FILE;
        this.keyPassword = DEFAULT_KEY_PASSWORD;
        this.certFile = DEFAULT_CERT_FILE;
        this.pkcs12File = DEFAULT_PKCS12_FILE;
        this.pkcs12Password = DEFAULT_PKCS12_PASSWORD;
        this.jksFile = DEFAULT_JKS_FILE;
        this.jksPassword = DEFAULT_JKS_PASSWORD;
        this.alias = DEFAULT_ALIAS;
    }

    static private boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    // getters
    public String getOutputDir() {
        return this.outputDir == null
                ? DEFAULT_OUTPUT_DIR
                : this.outputDir;
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

    // setters
    public void setOutputDir(String outputDir) {
        this.outputDir = isEmpty(outputDir)
            ? DEFAULT_OUTPUT_DIR
            : outputDir;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = isEmpty(keyFile)
            ? DEFAULT_KEY_FILE
            : keyFile;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = isEmpty(keyPassword)
            ? DEFAULT_KEY_PASSWORD
            : keyPassword;
    }

    public void setCertFile(String certFile) {
        this.certFile = isEmpty(certFile)
            ? DEFAULT_CERT_FILE
            : certFile;
    }

    public void setPkcs12File(String pkcs12File) {
        this.pkcs12File = isEmpty(pkcs12File)
            ? DEFAULT_PKCS12_FILE
            : pkcs12File;
    }

    public void setPkcs12Password(String pkcs12Password) {
        this.pkcs12Password = isEmpty(pkcs12Password)
            ? DEFAULT_PKCS12_PASSWORD
            : pkcs12Password;
    }

    public void setJksFile(String jksFile) {
        this.jksFile = isEmpty(jksFile)
            ? DEFAULT_JKS_FILE
            : jksFile;
    }

    public void setJksPassword(String jksPassword) {
        this.jksPassword = isEmpty(alias)
            ? DEFAULT_JKS_PASSWORD
            : jksPassword;
    }

    public void setAlias(String alias) {
        this.alias = isEmpty(alias)
            ? DEFAULT_ALIAS
            : alias;
    }
}
