package com.spring.blog2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:setting.yml")
@ConfigurationProperties(prefix = "ImgConfig")

public class ImgConfig {
    @Value("${saveLocation}")
    private String saveLocation;
    @Value("${maxUploadSizePerFile}")
    private String maxUploadSizePerFile;

    public String getMaxUploadSizePerFile() {
        return maxUploadSizePerFile;
    }

    public void setMaxUploadSizePerFile(String maxUploadSizePerFile) {
        this.maxUploadSizePerFile = maxUploadSizePerFile;
    }

    public String getSaveLocation() {
        if (!saveLocation.endsWith("/"))
            return saveLocation+'/';
        return saveLocation;
    }

    public void setSaveLocation(String saveLocation) {
        this.saveLocation = saveLocation;
    }
}
