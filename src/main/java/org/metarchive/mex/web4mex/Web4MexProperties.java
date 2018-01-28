package org.metarchive.mex.web4mex;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class Web4MexProperties {
	
	String tmpDir;
	
	String uriBase;

	public String getTmpDir() {
		return tmpDir;
	}

	public void setTmpDir(String tmpDir) {
		this.tmpDir = tmpDir;
	}

	public String getUriBase() {
		return uriBase;
	}

	public void setUriBase(String uriBase) {
		this.uriBase = uriBase;
	}

	
}
