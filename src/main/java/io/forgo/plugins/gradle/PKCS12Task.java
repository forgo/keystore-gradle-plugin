package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class PKCS12Task extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds a PKCS12 keystore file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "Keystore Gradle Plugin";
    }

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
    private String keystoreAlias;

    @TaskAction
    void generatePKCS12() {
//        File filePkcs12File = getProject().file(pkcs12File);
//        if(filePkcs12File.exists()) {
//            filePkcs12File.delete();
//        }
        getProject().exec(execSpec -> {
            execSpec.setIgnoreExitValue(true);
            execSpec.workingDir(".");
            execSpec.setExecutable("openssl");
            List<String> args = Arrays.asList(
                    "pkcs12",
                    "-inkey", keyFile,
                    "-in", certFile,
                    "-export",
                    "-out", pkcs12File,
                    "-passin", "pass:"+keyPassword,
                    "-password", "pass:"+pkcs12Password,
                    "-name", keystoreAlias
            );
            execSpec.setArgs(args);
        });
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

    public String getKeystoreAlias() {
        return keystoreAlias;
    }

    public void setKeystoreAlias(String keystoreAlias) {
        this.keystoreAlias = keystoreAlias;
    }
}