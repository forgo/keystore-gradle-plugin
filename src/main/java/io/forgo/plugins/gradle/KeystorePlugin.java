package io.forgo.plugins.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class KeystorePlugin implements Plugin<Project> {
    public void apply(Project project) {
        KeystoreExtension extension = project.getExtensions().create(KeystoreExtension.EXTENSION_NAME, KeystoreExtension.class, project);
        addSSLKeyTask(project, extension);
        addSSLCertTask(project, extension);
        addPKCS12Task(project, extension);
        addKeystoreTask(project, extension);
    }

    private void addSSLKeyTask(Project project, KeystoreExtension extension) {
        SSLKeyTask task = project.getTasks().create("sslKey", SSLKeyTask.class);
        // assign configs brought in from build.gradle
        task.setKeyFile(extension.getKeyFile());
        task.setKeyPassword(extension.getKeyPassword());
    }

    private void addSSLCertTask(Project project, KeystoreExtension extension) {
        SSLCertTask task = project.getTasks().create("sslCert", SSLCertTask.class);
        // assign configs brought in from build.gradle
        task.setKeyFile(extension.getKeyFile());
        task.setKeyPassword(extension.getKeyPassword());
        task.setCertFile(extension.getCertFile());
        task.dependsOn(project.getTasks().getByName("sslKey"));
    }

    private void addPKCS12Task(Project project, KeystoreExtension extension) {
        PKCS12Task task = project.getTasks().create("pkcs12", PKCS12Task.class);
        // assign configs brought in from build.gradle
        task.setKeyFile(extension.getKeyFile());
        task.setKeyPassword(extension.getKeyPassword());
        task.setCertFile(extension.getCertFile());
        task.setPkcs12File(extension.getPkcs12File());
        task.setPkcs12Password(extension.getPkcs12Password());
        task.setKeystoreAlias(extension.getKeystoreAlias());
        task.dependsOn(project.getTasks().getByName("sslCert"));
    }

    private void addKeystoreTask(Project project, KeystoreExtension extension) {
        KeystoreTask task = project.getTasks().create("jks", KeystoreTask.class);
        // assign configs brought in from build.gradle
        task.setKeyFile(extension.getKeyFile());
        task.setCertFile(extension.getCertFile());
        task.setPkcs12File(extension.getPkcs12File());
        task.setPkcs12Password(extension.getPkcs12Password());
        task.setKeystoreFile(extension.getKeystoreFile());
        task.setKeystorePassword(extension.getKeystorePassword());
        task.dependsOn(project.getTasks().getByName("pkcs12"));
    }

}