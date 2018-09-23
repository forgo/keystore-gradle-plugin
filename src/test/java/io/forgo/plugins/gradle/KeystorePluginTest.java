package io.forgo.plugins.gradle;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class KeystorePluginTest {

    @Test
    public void keystorePluginAddsSSLKeyTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("io.forgo.keystoreplugin");
        assertTrue(project.getTasks().getByName("sslKey") instanceof SSLKeyTask);
    }

    @Test
    public void keystorePluginAddsSSLCertTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("io.forgo.keystoreplugin");
        assertTrue(project.getTasks().getByName("sslCert") instanceof SSLCertTask);
    }

    @Test
    public void keystorePluginAddsPKCS12TaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("io.forgo.keystoreplugin");
        assertTrue(project.getTasks().getByName("pkcs12") instanceof PKCS12Task);
    }

    @Test
    public void keystorePluginAddsKeystoreTaskToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("io.forgo.keystoreplugin");
        assertTrue(project.getTasks().getByName("keystore") instanceof KeystoreTask);
    }
}
