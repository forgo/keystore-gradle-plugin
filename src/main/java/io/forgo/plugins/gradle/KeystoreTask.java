package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class KeystoreTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds a JKS keystore file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "Keystore Gradle Plugin";
    }

    private String keyFile;
    private String certFile;
    private String pkcs12File;
    private String pkcs12Password;
    private String keystoreFile;
    private String keystorePassword;

    @TaskAction
    void generateJKS() {
        File fileKeystoreFile = getProject().file(keystoreFile);
        if(fileKeystoreFile.exists()) {
            fileKeystoreFile.delete();
        }
        getProject().exec(execSpec -> {
            execSpec.setIgnoreExitValue(true);
            execSpec.workingDir(".");
            execSpec.setExecutable("keytool");
            List<String> args = Arrays.asList(
                    "-importkeystore",
                    "-srcstoretype", "PKCS12",
                    "-srckeystore", pkcs12File,
                    "-srcstorepass", pkcs12Password,
                    "-destkeystore", keystoreFile,
                    "-storepass", keystorePassword
            );
            execSpec.setArgs(args);
        });

        File fileKeyFile = getProject().file(keyFile);
        if(fileKeyFile.exists()) {
            fileKeyFile.delete();
        }

        File fileCertFile = getProject().file(certFile);
        if(fileCertFile.exists()) {
            fileCertFile.delete();
        }

        File filePkcs12File = getProject().file(pkcs12File);
        if(filePkcs12File.exists()) {
            filePkcs12File.delete();
        }
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public void setCertFile(String certFile) {
        this.certFile = certFile;
    }

    public void setPkcs12File(String pkcs12File) {
        this.pkcs12File = pkcs12File;
    }

    public void setPkcs12Password(String pkcs12Password) {
        this.pkcs12Password = pkcs12Password;
    }

    public void setKeystoreFile(String keystoreFile) {
        this.keystoreFile = keystoreFile;
    }

    public void setKeystorePassword(String keystorePassword) {
        this.keystorePassword = keystorePassword;
    }
}