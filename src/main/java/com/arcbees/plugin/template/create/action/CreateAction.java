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

package com.arcbees.plugin.template.create.action;

import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import com.arcbees.plugin.template.domain.action.ActionOptions;
import com.arcbees.plugin.template.domain.action.CreatedAction;
import com.arcbees.plugin.template.domain.action.RenderedTemplate;
import com.arcbees.plugin.template.utils.VelocityUtils;
import com.arcbees.plugin.velocity.VelocityEngineCustom;

public class CreateAction {
    public final static Logger logger = Logger.getLogger(CreateAction.class.getName());
            
    public static CreatedAction run(ActionOptions actionOptions, boolean remote) throws Exception {
        CreateAction createAction = new CreateAction(actionOptions, remote);
        createAction.run();
        return createAction.getCreatedAction();
    }

    private static final String BASE_REMOTE = "https://raw.github.com/ArcBees/IDE-Templates/1.0.0/src/main/resources/com/arcbees/plugin/template/action/";
    private final static String BASE_LOCAL = "./src/main/resources/com/arcbees/plugin/template/action/";

    private final ActionOptions actionOptions;

    private VelocityEngineCustom velocityEngine;
    private CreatedAction createdAction;
    private boolean remote;

    private CreateAction(ActionOptions actionOptions, boolean remote) {
        this.actionOptions = actionOptions;
        this.remote = remote;
    }

    private void run() throws Exception {
        createdAction = new CreatedAction();

        remote = false;	// TODO remove that
        
        if (remote) {
            setupVelocityRemote();
        } else {
            setupVelocityLocal();
        }

        process();
    }

    private void setupVelocityLocal() {
        velocityEngine = new VelocityEngineCustom();
                
        velocityEngine.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, BASE_LOCAL);
        try {
        	velocityEngine.reset();
            velocityEngine.init();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Velocity Init Error Local", e);
            e.printStackTrace();
        }
    }

    private void setupVelocityRemote() throws Exception {
    	try {
            velocityEngine = VelocityUtils.createRemoveVelocityEngine(BASE_REMOTE);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Velocity Init Error", e);
            e.printStackTrace();
            throw e;
        }
    }

    private CreatedAction getCreatedAction() {
        return createdAction;
    }

    private VelocityContext getBaseVelocityContext() {
        VelocityContext context = new VelocityContext();

        // base
        context.put("package", actionOptions.getPackageName());
        context.put("name", actionOptions.getName());

        // extra options
        context.put("isSecuredAction", actionOptions.isSecured());

        return context;
    }

    private void process() throws ResourceNotFoundException, ParseErrorException, Exception {
        processAction();
    }

    private void processAction() throws ResourceNotFoundException, ParseErrorException, Exception {
        String fileName = "__name__Action.java.vm";
        RenderedTemplate rendered = processTemplate(fileName);
        
    }

    private RenderedTemplate processTemplate(String fileName) throws ResourceNotFoundException, ParseErrorException, Exception {
        Template template = velocityEngine.getTemplate(fileName);
        VelocityContext context = getBaseVelocityContext();
        StringWriter writer = new StringWriter();
        template.merge(context, writer);
        RenderedTemplate rendered = new RenderedTemplate(renderFileName(fileName), writer.toString());
        return rendered;
    }

    private String renderFileName(String fileName) {
        String name = actionOptions.getName();
        name = name.replace(".vm", "");
        return fileName.replace("__name__", name);
    }
}
