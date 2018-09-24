package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SSLCertTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds an SSL public cert file for the Keystore Gradle Plugin";
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

    @TaskAction
    void generateCert() {
//        File fileCertFile = getProject().file(certFile);
//        if(fileCertFile.exists()) {
//            fileCertFile.delete();
//        }
        getProject().file(certFile).delete();
        getProject().exec(execSpec -> {
            execSpec.setIgnoreExitValue(true);
            execSpec.workingDir(".");
            execSpec.setExecutable("openssl");
            List<String> args = Arrays.asList(
                    "req",
                    "-new",
                    "-x509",
                    "-key", keyFile,
                    "-out", certFile,
                    "-passin", "pass:"+keyPassword,
                    "-subj", "/C=US"
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
}