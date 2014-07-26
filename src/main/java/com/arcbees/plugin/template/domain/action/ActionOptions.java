package com.arcbees.plugin.template.domain.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ActionOptions {
    private String tmpPath;
    private String name;
    private String packageName;
    private String handlerPackageName;
    private String validatorPackageName;
    private Boolean secured;
    
    private List<ActionParameter> inputParameters;
    private List<ActionParameter> outputParameters;
    
    private HashSet<String> imports;

    public ActionOptions() {
    	this.imports = new HashSet<String>();
    	this.inputParameters = new ArrayList<ActionParameter>();
    	this.outputParameters = new ArrayList<ActionParameter>();
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

	public String getHandlerPackageName() {
		return handlerPackageName;
	}

	public void setHandlerPackageName(String handlerPackageName) {
		this.handlerPackageName = handlerPackageName;
	}

	
	
	public List<ActionParameter> getInputParameters() {
		return inputParameters;
	}

	public void setInputParameters(List<ActionParameter> inputParameters) {
		this.inputParameters = inputParameters;
	}

	public List<ActionParameter> getOutputParameters() {
		return outputParameters;
	}

	public void setOutputParameters(List<ActionParameter> outputParameters) {
		this.outputParameters = outputParameters;
	}

	public HashSet<String> getImports() {
		return imports;
	}

	public void setImports(HashSet<String> imports) {
		this.imports = imports;
	}

	public String getValidatorPackageName() {
		return validatorPackageName;
	}

	public void setValidatorPackageName(String validatorPackageName) {
		this.validatorPackageName = validatorPackageName;
	}
}
