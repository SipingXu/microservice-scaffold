package org.siping.scaffold.file.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Siping
 * @date 2018/5/9 15:16
 * @description
 */
@ConfigurationProperties(prefix = "custom")
public class MyPropsConstants {

	private String uploadBasePath;

	private String imageViewBasePath;

	public String getUploadBasePath() {
		return uploadBasePath;
	}

	public void setUploadBasePath(String uploadBasePath) {
		this.uploadBasePath = uploadBasePath;
	}

	public String getImageViewBasePath() {
		return imageViewBasePath;
	}

	public void setImageViewBasePath(String imageViewBasePath) {
		this.imageViewBasePath = imageViewBasePath;
	}
}
