package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

public class ResetOutputDirTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Resets output directory for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "Keystore Gradle Plugin";
    }

    private String outputDir;

    @TaskAction
    void resetOutputDir() throws IOException {

        // create output dir if it doesn't exist
        File dir = getProject().mkdir(this.outputDir);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        // otherwise blow away contents within output dir
        else {
            Files.walk(dir.toPath())
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }
}
