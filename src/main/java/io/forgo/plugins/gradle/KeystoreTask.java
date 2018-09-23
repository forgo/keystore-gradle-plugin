package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.util.Arrays;
import java.util.List;

public class KeystoreTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds a JKS keystore file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "keystore";
    }

    @Input
    String keyFile;

    @Input
    String certFile;

    @Input
    String pkcs12File;

    @Input
    String pkcs12Password;

    @Input
    String keystoreFile;

    @Input
    String keystorePassword;

    @TaskAction
    void generateJKS() {
        getProject().file(keystoreFile).delete();
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

        getProject().file(keyFile).delete();
        getProject().file(certFile).delete();
        getProject().file(pkcs12File).delete();
    }
}