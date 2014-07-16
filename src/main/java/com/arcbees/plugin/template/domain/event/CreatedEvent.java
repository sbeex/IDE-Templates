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

package com.arcbees.plugin.template.domain.event;

import com.arcbees.plugin.template.domain.event.RenderedTemplate;

public class CreatedEvent {

    private RenderedTemplate event;

    public CreatedEvent() {
    }

    public RenderedTemplate getEvent() {
        return event;
    }
    
    public void setEvent(RenderedTemplate event) {
    	this.event = event;
    }


    @Override
    public String toString() {
        String s = "{ CreatedEvent ";
        s += "event=" + event + " ";
        s += " }";
        return s;
    }
}
