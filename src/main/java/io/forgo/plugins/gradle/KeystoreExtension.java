package io.forgo.plugins.gradle;

import org.gradle.api.Project;
import org.gradle.api.Task;

public class KeystoreExtension {

    static final String EXTENSION_NAME = "keystore";

    private Project project;
    private Task task;

    private String keyFile;
    private String keyPassword;
    private String certFile;
    private String pkcs12File;
    private String pkcs12Password;
    private String keystoreFile;
    private String keystorePassword;
    private String keystoreAlias;

    public KeystoreExtension(Project project) {
        this.project = project;

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

    protected KeystoreExtension(Task task) {
        this.task = task;
    }

    private KeystoreExtension getTaskExtension() {
        return (KeystoreExtension)this.task
                .getProject().getExtensions().getByName(EXTENSION_NAME);
    }

    public String getKeyFile() {
        if(task != null && this.keyFile == null) {
            this.keyFile = getTaskExtension().getKeyFile();
        }
        return keyFile;
    }

    public String getKeyPassword() {
        if(task != null && this.keyPassword == null) {
            this.keyPassword = getTaskExtension().getKeyFile();
        }
        return keyPassword;
    }

    public String getCertFile() {
        if(task != null && this.certFile == null) {
            this.certFile = getTaskExtension().getKeyFile();
        }
        return certFile;
    }

    public String getPkcs12File() {
        if(task != null && this.pkcs12File == null) {
            this.pkcs12File = getTaskExtension().getKeyFile();
        }
        return pkcs12File;
    }

    public String getPkcs12Password() {
        if(task != null && this.pkcs12Password == null) {
            this.pkcs12Password = getTaskExtension().getKeyFile();
        }
        return pkcs12Password;
    }

    public String getKeystoreFile() {
        if(task != null && this.keystoreFile == null) {
            this.keystoreFile = getTaskExtension().getKeyFile();
        }
        return keystoreFile;
    }

    public String getKeystorePassword() {
        if(task != null && this.keystorePassword == null) {
            this.keystorePassword = getTaskExtension().getKeyFile();
        }
        return keystorePassword;
    }

    public String getKeystoreAlias() {
        if(task != null && this.keystoreAlias == null) {
            this.keystoreAlias = getTaskExtension().getKeyFile();
        }
        return keystoreAlias;
    }

    public void setKeyFile(final String keyFile) {
        this.keyFile = keyFile;
    }

    public void setKeyPassword(final String keyPassword) {
        this.keyPassword = keyPassword;
    }

    public void setCertFile(final String certFile) {
        this.certFile = certFile;
    }

    public void setPkcs12File(final String pkcs12File) {
        this.pkcs12File = pkcs12File;
    }

    public void setPkcs12Password(final String pkcs12Password) {
        this.pkcs12Password = pkcs12Password;
    }

    public void setKeystoreFile(final String keystoreFile) {
        this.keystoreFile = keystoreFile;
    }

    public void setKeystorePassword(final String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }

    public void setKeystoreAlias(final String keystoreAlias) {
        this.keystoreAlias = keystoreAlias;
    }
}
