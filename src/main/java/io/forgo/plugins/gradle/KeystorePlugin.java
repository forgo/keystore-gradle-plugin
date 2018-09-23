package io.forgo.plugins.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class KeystorePlugin implements Plugin<Project> {
    public void apply(Project project) {
        project.getExtensions().add("keystore", KeystoreExtension.class);
        addSSLKeyTask(project);
        addSSLCertTask(project);
        addPKCS12Task(project);
        addKeystoreTask(project);
    }

    private KeystoreExtension getKeystoreExtension(Project project) {
        return project.getExtensions().getByType(KeystoreExtension.class);
    }

    private void addSSLKeyTask(Project project) {
        SSLKeyTask task = project.getTasks().create("sslKey", SSLKeyTask.class);
        KeystoreExtension keystoreExtension = getKeystoreExtension(project);
        // assign configs brought in from build.gradle
        task.keyFile = keystoreExtension.keyFile;
        task.keyPassword = keystoreExtension.keyPassword;
    }

    private void addSSLCertTask(Project project) {
        SSLCertTask task = project.getTasks().create("sslCert", SSLCertTask.class);
        KeystoreExtension keystoreExtension = getKeystoreExtension(project);
        // assign configs brought in from build.gradle
        task.keyFile = keystoreExtension.keyFile;
        task.keyPassword = keystoreExtension.keyPassword;
        task.certFile = keystoreExtension.certFile;
        task.dependsOn(project.getTasks().getByName("sslKey"));
    }

    private void addPKCS12Task(Project project) {
        PKCS12Task task = project.getTasks().create("pkcs12", PKCS12Task.class);
        KeystoreExtension keystoreExtension = getKeystoreExtension(project);
        // assign configs brought in from build.gradle
        task.keyFile = keystoreExtension.keyFile;
        task.keyPassword = keystoreExtension.keyPassword;
        task.certFile = keystoreExtension.certFile;
        task.pkcs12File = keystoreExtension.pkcs12File;
        task.pkcs12Password = keystoreExtension.pkcs12Password;
        task.keystoreAlias = keystoreExtension.keystoreAlias;
        task.dependsOn(project.getTasks().getByName("sslCert"));
    }

    private void addKeystoreTask(Project project) {
        KeystoreTask task = project.getTasks().create("jks", KeystoreTask.class);
        KeystoreExtension keystoreExtension = getKeystoreExtension(project);
        // assign configs brought in from build.gradle
        task.keyFile = keystoreExtension.keyFile;
        task.certFile = keystoreExtension.certFile;
        task.pkcs12File = keystoreExtension.pkcs12File;
        task.pkcs12Password = keystoreExtension.pkcs12Password;
        task.keystoreFile = keystoreExtension.keystoreFile;
        task.keystorePassword = keystoreExtension.keystorePassword;
        task.dependsOn(project.getTasks().getByName("pkcs12"));
    }

}