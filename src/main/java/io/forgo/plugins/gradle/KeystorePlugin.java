package io.forgo.plugins.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class KeystorePlugin implements Plugin<Project> {

    private static final String TASK_SSL_KEY = "sslKey";
    private static final String TASK_SSL_CERT = "sslCert";
    private static final String TASK_PKCS12 = "pkcs12";
    private static final String TASK_JKS = "jks";

    public void apply(Project project) {
        KeystoreExtension extension = project.getExtensions().create(KeystoreExtension.EXTENSION_NAME, KeystoreExtension.class, project);
        addSSLKeyTask(project, extension);
        addSSLCertTask(project, extension);
        addPKCS12Task(project, extension);
        addJKSTask(project, extension);
    }

    private void addSSLKeyTask(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_SSL_KEY, SSLKeyTask.class, task -> {
            project.afterEvaluate(p -> {
                task.setKeyFile(extension.getKeyFile());
                task.setKeyPassword(extension.getKeyPassword());
            });
        });
    }

    private void addSSLCertTask(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_SSL_CERT, SSLCertTask.class, task -> {
            project.afterEvaluate(p -> {
                task.setKeyFile(extension.getKeyFile());
                task.setKeyPassword(extension.getKeyPassword());
                task.setCertFile(extension.getCertFile());
            });
            task.dependsOn(project.getTasks().getByName(TASK_SSL_KEY));
        });
    }

    private void addPKCS12Task(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_PKCS12, PKCS12Task.class, task -> {
            project.afterEvaluate(p -> {
                task.setKeyFile(extension.getKeyFile());
                task.setKeyPassword(extension.getKeyPassword());
                task.setCertFile(extension.getCertFile());
                task.setPkcs12File(extension.getPkcs12File());
                task.setPkcs12Password(extension.getPkcs12Password());
                task.setKeystoreAlias(extension.getAlias());
            });
            task.dependsOn(project.getTasks().getByName(TASK_SSL_CERT));
        });
    }

    private void addJKSTask(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_JKS, JKSTask.class, task -> {
            project.afterEvaluate(p -> {
                task.setKeyFile(extension.getKeyFile());
                task.setCertFile(extension.getCertFile());
                task.setPkcs12File(extension.getPkcs12File());
                task.setPkcs12Password(extension.getPkcs12Password());
                task.setKeystoreFile(extension.getJksFile());
                task.setKeystorePassword(extension.getJksPassword());
            });
            task.dependsOn(project.getTasks().getByName(TASK_PKCS12));
        });
    }

}