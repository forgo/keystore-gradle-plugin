package io.forgo.plugins.gradle;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class KeystorePluginTest {

    @Test
    public void keystorePluginAddsResetOutputDirTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(KeystorePlugin.PLUGIN_ID);
        assertTrue(project.getTasks().getByName(KeystorePlugin.TASK_RESET_OUTPUT_DIR) instanceof ResetOutputDirTask);
    }

    @Test
    public void keystorePluginAddsSSLKeyTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(KeystorePlugin.PLUGIN_ID);
        assertTrue(project.getTasks().getByName(KeystorePlugin.TASK_SSL_KEY) instanceof SSLKeyTask);
    }

    @Test
    public void keystorePluginAddsSSLCertTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(KeystorePlugin.PLUGIN_ID);
        assertTrue(project.getTasks().getByName(KeystorePlugin.TASK_SSL_CERT) instanceof SSLCertTask);
    }

    @Test
    public void keystorePluginAddsPKCS12TaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(KeystorePlugin.PLUGIN_ID);
        assertTrue(project.getTasks().getByName(KeystorePlugin.TASK_PKCS12) instanceof PKCS12Task);
    }

    @Test
    public void keystorePluginAddsJKSTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(KeystorePlugin.PLUGIN_ID);
        assertTrue(project.getTasks().getByName(KeystorePlugin.TASK_JKS) instanceof JKSTask);
    }
}
