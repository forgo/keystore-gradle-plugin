package io.forgo.plugins.gradle;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class JKSTask extends DefaultTask {

    @Override
    public String getDescription() {
        return "Builds a JKS keystore file for the Keystore Gradle Plugin";
    }

    @Override
    public String getGroup() {
        return "Keystore Gradle Plugin";
    }

    private String outputDir;
    private String keyFile;
    private String certFile;
    private String pkcs12File;
    private String pkcs12Password;
    private String jksFile;
    private String jksPassword;

    @TaskAction
    void generateJKS() {

        // create output dir if it doesn't exist
        File dir = getProject().mkdir(this.outputDir);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        // delete jks file if it exists in the output dir
        String pathJksFile = this.outputDir + File.separatorChar + this.jksFile;
        File file = getProject().file(pathJksFile);
        if(file.exists()) {
            file.delete();
        }

        String pathPkcs12File = this.outputDir + File.separatorChar + this.pkcs12File;

        getProject().exec(execSpec -> {
            execSpec.setIgnoreExitValue(true);
            execSpec.workingDir(".");
            execSpec.setExecutable("keytool");
            List<String> args = Arrays.asList(
                    "-importkeystore",
                    "-srcstoretype", "PKCS12",
                    "-srckeystore", pathPkcs12File,
                    "-srcstorepass", this.pkcs12Password,
                    "-destkeystore", pathJksFile,
                    "-storepass", this.jksPassword
            );
            execSpec.setArgs(args);
        });

//        String pathKeyFile = this.outputDir + File.separatorChar + this.keyFile;
//        File fileKeyFile = getProject().file(pathKeyFile);
//        if(fileKeyFile.exists()) {
//            fileKeyFile.delete();
//        }
//
//        String pathCertFile = this.outputDir + File.separatorChar + this.certFile;
//        File fileCertFile = getProject().file(pathCertFile);
//        if(fileCertFile.exists()) {
//            fileCertFile.delete();
//        }
//
//        File filePkcs12File = getProject().file(pathPkcs12File);
//        if(filePkcs12File.exists()) {
//            filePkcs12File.delete();
//        }
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
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

    public void setJksFile(String jksFile) {
        this.jksFile = jksFile;
    }

    public void setJksPassword(String jksPassword) {
        this.jksPassword = jksPassword;
    }
}