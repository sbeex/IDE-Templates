package com.arcbees.plugin.template.domain.action;

public class ActionOptions {
    private String tmpPath;
    private String name;
    private String packageName;
    private Boolean secured;
    

    public ActionOptions() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getTmpPath() {
        return tmpPath;
    }

    public void setTmpPath(String tmpPath) {
        this.tmpPath = tmpPath;
    }
    
    public Boolean isSecured() {
    	return this.secured;
    }
    
    public void setSecured(Boolean secured) {
    	this.secured = secured;
    }
}
