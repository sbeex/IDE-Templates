/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.arcbees.plugin.template.domain.action;



public class ActionParameter {
    private String type;
    private String name;
    private String funcName;
    
    private String importPath;
    
    public ActionParameter() {
    	
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
    	this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
        this.funcName = name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    
    public String getShortType() {
        return type.substring(type.lastIndexOf("."));
    }

	public String getImportPath() {
		return importPath;
	}

	public void setImportPath(String importPath) {
		this.importPath = importPath;
	}
	
	public String getFuncName() {
		return this.funcName;
	}
    
    
}
