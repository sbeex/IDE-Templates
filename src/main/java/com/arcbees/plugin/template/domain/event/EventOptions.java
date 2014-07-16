package com.arcbees.plugin.template.domain.event;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EventOptions {
    private String tmpPath;
    private String name;
    private String packageName;
    
    private List<EventParameter> inputParameters;
    
    private HashSet<String> imports;

    public EventOptions() {
    	this.imports = new HashSet<String>();
    	this.inputParameters = new ArrayList<EventParameter>();
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



	public List<EventParameter> getInputParameters() {
		return inputParameters;
	}

	public void setInputParameters(List<EventParameter> inputParameters) {
		this.inputParameters = inputParameters;
	}

	public HashSet<String> getImports() {
		return imports;
	}

	public void setImports(HashSet<String> imports) {
		this.imports = imports;
	}
}
