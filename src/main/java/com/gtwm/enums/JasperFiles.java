package com.gtwm.enums;

public enum JasperFiles {
	
	SALETABLE("WEB-INF/blk-table.jasper"),SALETVIEW("WEB-INF/aliblkDemo.jasper");
	
	private String classPath;
	
	private JasperFiles(String classPath) {
		this.classPath = classPath;
	}

	public String getClassPath() {
		return classPath;
	}
	
}
