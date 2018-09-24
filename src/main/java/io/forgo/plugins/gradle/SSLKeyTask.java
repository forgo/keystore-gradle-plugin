package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SSLKeyTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds an SSL private key file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "Keystore Gradle Plugin";
    }

    private String keyFile;
    private String keyPassword;

    @TaskAction
    void generateKey() {
        File fileKeyFile = getProject().file(this.keyFile);
        if(fileKeyFile.exists()) {
            fileKeyFile.delete();
        }
        getProject().exec(execSpec -> {
            execSpec.setIgnoreExitValue(true);
            execSpec.workingDir(".");
            execSpec.setExecutable("openssl");
            List<String> args = Arrays.asList(
                    "genrsa",
                    "-des3",
                    "-out", this.keyFile,
                    "-passout", "pass:"+this.keyPassword
            );
            execSpec.setArgs(args);
        });
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public void setKeyPassword(String keyPassword) {
        this.keyPassword = keyPassword;
    }
}
