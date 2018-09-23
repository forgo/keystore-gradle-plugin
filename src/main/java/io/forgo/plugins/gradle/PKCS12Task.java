package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.util.Arrays;
import java.util.List;

public class PKCS12Task extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds a PKCS12 keystore file for the Keystore Gradle Plugin";
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

    @Input
    String pkcs12File;

    @Input
    String pkcs12Password;

    @Input
    String keystoreAlias;

    @TaskAction
    void generatePKCS12() {
        getProject().file(pkcs12File).delete();
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
}