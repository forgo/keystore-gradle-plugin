package io.forgo.plugins.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class KeystorePlugin implements Plugin<Project> {

    static final String PLUGIN_ID = "io.forgo.keystoreplugin";

    static final String TASK_RESET_OUTPUT_DIR = "resetOutputDir";
    static final String TASK_SSL_KEY = "sslKey";
    static final String TASK_SSL_CERT = "sslCert";
    static final String TASK_PKCS12 = "pkcs12";
    static final String TASK_JKS = "jks";

    public void apply(Project project) {
        KeystoreExtension extension = project.getExtensions().create(KeystoreExtension.EXTENSION_NAME, KeystoreExtension.class, project);
        addResetOutputDirTask(project, extension);
        addSSLKeyTask(project, extension);
        addSSLCertTask(project, extension);
        addPKCS12Task(project, extension);
        addJKSTask(project, extension);
    }

    private void addResetOutputDirTask(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_RESET_OUTPUT_DIR, ResetOutputDirTask.class, task -> {
           project.afterEvaluate(p -> {
               task.setOutputDir(extension.getOutputDir());
           });
        });
    }

    private void addSSLKeyTask(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_SSL_KEY, SSLKeyTask.class, task -> {
            project.afterEvaluate(p -> {
                task.setOutputDir(extension.getOutputDir());
                task.setKeyFile(extension.getKeyFile());
                task.setKeyPassword(extension.getKeyPassword());
            });
            task.dependsOn(project.getTasks().getByName(TASK_RESET_OUTPUT_DIR));
        });
    }

    private void addSSLCertTask(Project project, KeystoreExtension extension) {
        project.getTasks().create(TASK_SSL_CERT, SSLCertTask.class, task -> {
            project.afterEvaluate(p -> {
                task.setOutputDir(extension.getOutputDir());
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
                task.setOutputDir(extension.getOutputDir());
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
                task.setOutputDir(extension.getOutputDir());
                task.setPkcs12File(extension.getPkcs12File());
                task.setPkcs12Password(extension.getPkcs12Password());
                task.setJksFile(extension.getJksFile());
                task.setJksPassword(extension.getJksPassword());
            });
            task.dependsOn(project.getTasks().getByName(TASK_PKCS12));
        });
    }

}