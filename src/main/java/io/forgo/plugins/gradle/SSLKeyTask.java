package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

import java.util.Arrays;
import java.util.List;

public class SSLKeyTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds an SSL private key file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "keystore";
    }

    @Input
    String keyFile;

    @Input
    String keyPassword;

    @TaskAction
    void generateKey() {
        getProject().file(keyFile).delete();
        getProject().exec(execSpec -> {
            execSpec.setIgnoreExitValue(true);
            execSpec.workingDir(".");
            execSpec.setExecutable("openssl");
            List<String> args = Arrays.asList(
                    "genrsa",
                    "-des3",
                    "-out", keyFile,
                    "-passout", "pass:"+keyPassword
            );
            execSpec.setArgs(args);
        });
    }
}
