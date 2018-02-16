package it.unito.projector.data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="projector")
public class ProjectorProperties {

    private String frontendUrl;

    public ProjectorProperties(String frontendUrl) {
        this.frontendUrl = frontendUrl;
    }

    private ProjectorProperties(){}

    public String getFrontendUrl() {
        return frontendUrl;
    }

    public void setFrontendUrl(String frontendUrl) {
        this.frontendUrl = frontendUrl;
    }
}
