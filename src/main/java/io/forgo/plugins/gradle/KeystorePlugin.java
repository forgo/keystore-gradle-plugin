package io.forgo.plugins.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class KeystorePlugin implements Plugin<Project> {

    private static final String TASK_SSL_KEY = "sslKey";
    private static final String TASK_SSL_CERT = "sslCert";
    private static final String TASK_PKCS12 = "pkcs12";
    private static final String TASK_JKS = "jks";

    public void apply(Project project) {
        project.getExtensions().add(KeystoreExtension.EXTENSION_NAME, KeystoreExtension.class);
        addSSLKeyTask(project);
        addSSLCertTask(project);
        addPKCS12Task(project);
        addJKSTask(project);
    }

    private void addSSLKeyTask(Project project) {
        project.getTasks().create(TASK_SSL_KEY, SSLKeyTask.class, task ->
            project.afterEvaluate(p -> {
                // assign configs brought in from build.gradle
                KeystoreExtension extension = (KeystoreExtension) p.getExtensions().getByName(KeystoreExtension.EXTENSION_NAME);
                task.setKeyFile(extension.getKeyFile());
                task.setKeyPassword(extension.getKeyPassword());
            })
        );
    }

    private void addSSLCertTask(Project project) {
        project.getTasks().create(TASK_SSL_CERT, SSLCertTask.class, task -> {
            project.afterEvaluate(p -> {
                // assign configs brought in from build.gradle
                KeystoreExtension extension = (KeystoreExtension) p.getExtensions().getByName(KeystoreExtension.EXTENSION_NAME);
                task.setKeyFile(extension.getKeyFile());
                task.setKeyPassword(extension.getKeyPassword());
                task.setCertFile(extension.getCertFile());
            });
            task.dependsOn(project.getTasks().getByName(TASK_SSL_KEY));
        });
    }

    private void addPKCS12Task(Project project) {
        project.getTasks().create(TASK_PKCS12, PKCS12Task.class, task -> {
            project.afterEvaluate(p -> {
                // assign configs brought in from build.gradle
                KeystoreExtension extension = (KeystoreExtension) p.getExtensions().getByName(KeystoreExtension.EXTENSION_NAME);
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

    private void addJKSTask(Project project) {
        project.getTasks().create(TASK_JKS, JKSTask.class, task -> {
            project.afterEvaluate(p -> {
                // assign configs brought in from build.gradle
                KeystoreExtension extension = (KeystoreExtension) p.getExtensions().getByName(KeystoreExtension.EXTENSION_NAME);
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