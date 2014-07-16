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

import com.arcbees.plugin.template.domain.action.RenderedTemplate;

public class CreatedActionHandler {

    private RenderedTemplate actionHandler;

    public CreatedActionHandler() {
    }

    public RenderedTemplate getActionHandler() {
        return actionHandler;
    }
    
    public void setActionHandler(RenderedTemplate actionHandler) {
    	this.actionHandler = actionHandler;
    }


    @Override
    public String toString() {
        String s = "{ CreatedActionHandler ";
        s += "action=" + actionHandler + " ";
        s += " }";
        return s;
    }
}
