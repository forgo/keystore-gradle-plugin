package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.util.Arrays;
import java.util.List;

public class SSLCertTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds an SSL public cert file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "keystore";
    }

    @Input
    String keyFile;

    @Input
    String keyPassword;

    @Input
    String certFile;

    @TaskAction
    void generateCert() {
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
}