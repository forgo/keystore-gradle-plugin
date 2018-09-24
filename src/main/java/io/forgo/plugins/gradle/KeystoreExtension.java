package io.forgo.plugins.gradle;

import org.gradle.api.Project;
import org.gradle.api.provider.PropertyState;

import java.io.File;

public class KeystoreExtension {

    static final String EXTENSION_NAME = "keystore";

//    private static final PropertyState<String> DEFAULT_KEY_FILE = new PropertyState<String>("debug.key");
    private static final String DEFAULT_KEY_PASSWORD = "password";
    private static final String DEFAULT_CERT_FILE = "debug.crt";
    private static final String DEFAULT_PKCS12_FILE = "debug.pkcs12";
    private static final String DEFAULT_PKCS12_PASSWORD = "password";
    private static final String DEFAULT_JKS_FILE = "debug.jks";
    private static final String DEFAULT_JKS_PASSWORD = "password";
    private static final String DEFAULT_ALIAS = "debug";

    public PropertyState<File> getKeyFile() {
        return keyFile;
    }

    final PropertyState<File> keyFile;
    String keyPassword;
    String certFile;
    String pkcs12File;
    String pkcs12Password;
    String jksFile;
    String jksPassword;
    String alias;

    public KeystoreExtension(Project project) {
        this.keyFile = project.property(File.class);
    }

//    public PropertyState<String> getKeyFile() {
//        return keyFile;
//    }
//    public PropertyState<String> getKeyFile() {
//        return this.keyFile == null
//                ?
//                : this.keyFile;
//    }

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

//    public void setKeyFile(final String keyFile) {
//        this.keyFile = keyFile == null
//                ? DEFAULT_KEY_FILE
//                : keyFile;
//    }
//
//    public void setKeyPassword(final String keyPassword) {
//        this.keyPassword = keyPassword == null
//                ? DEFAULT_KEY_PASSWORD
//                : keyPassword;
//    }
//
//    public void setCertFile(final String certFile) {
//        this.certFile = certFile == null
//                ? DEFAULT_CERT_FILE
//                : certFile;
//    }
//
//    public void setPkcs12File(final String pkcs12File) {
//        this.pkcs12File = pkcs12File == null
//                ? DEFAULT_PKCS12_FILE
//                : pkcs12File;
//    }
//
//    public void setPkcs12Password(final String pkcs12Password) {
//        this.pkcs12Password = pkcs12Password == null
//                ? DEFAULT_PKCS12_PASSWORD
//                : pkcs12Password;
//    }
//
//    public void setJksFile(final String jksFile) {
//        this.jksFile = jksFile == null
//                ? DEFAULT_JKS_FILE
//                : jksFile;
//    }
//
//    public void setJksPassword(final String jksPassword) {
//        this.jksPassword = jksPassword == null
//                ? DEFAULT_JKS_PASSWORD
//                : jksPassword;
//    }
//
//    public void setAlias(final String alias) {
//        this.alias = alias == null
//                ? DEFAULT_ALIAS
//                : alias;
//    }
}
