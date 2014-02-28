/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
*/

package org.apache.airavata.orchestrator.client;

import org.apache.airavata.client.AiravataAPIFactory;
import org.apache.airavata.client.api.AiravataAPI;
import org.apache.airavata.client.api.exception.AiravataAPIInvocationException;
import org.apache.airavata.common.exception.ApplicationSettingsException;
import org.apache.airavata.common.utils.ServerSettings;
import org.apache.airavata.model.util.ExperimentModelUtil;
import org.apache.airavata.model.workspace.experiment.ComputationalResourceScheduling;
import org.apache.airavata.model.workspace.experiment.DataObjectType;
import org.apache.airavata.model.workspace.experiment.Experiment;
import org.apache.airavata.orchestrator.core.DocumentCreator;
import org.apache.airavata.orchestrator.cpi.OrchestratorService;
import org.apache.airavata.persistance.registry.jpa.impl.RegistryFactory;
import org.apache.airavata.registry.cpi.ChildDataType;
import org.apache.airavata.registry.cpi.ParentDataType;
import org.apache.airavata.registry.cpi.Registry;
import org.apache.airavata.schemas.gfac.DataType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class OrchestratorClientFactoryTest {
    private DocumentCreator documentCreator;
    private OrchestratorService.Client orchestratorClient;
    private Registry registry;

    @Before
    public void setUp(){
        OrchestratorClientFactory orchestratorClientFactory = new OrchestratorClientFactory();
        orchestratorClient = orchestratorClientFactory.createOrchestratorClient("localhost", 8940);
        registry = RegistryFactory.getDefaultRegistry();
        documentCreator = new DocumentCreator(getAiravataAPI());
        documentCreator.createLocalHostDocs();
        documentCreator.createGramDocs();
        documentCreator.createGSISSHDocs();
    }

    private AiravataAPI getAiravataAPI() {
        AiravataAPI airavataAPI = null;
        if (airavataAPI == null) {
            try {
                String systemUserName = ServerSettings.getSystemUser();
                String gateway = ServerSettings.getSystemUserGateway();
                airavataAPI = AiravataAPIFactory.getAPI(gateway, systemUserName);
            } catch (ApplicationSettingsException e) {
                e.printStackTrace();
            } catch (AiravataAPIInvocationException e) {
                e.printStackTrace();
            }
        }
        return airavataAPI;
    }

    private void storeDescriptors(){

    }

    private void storeExperimentDetail(){
        try{
            List<DataObjectType> exInputs = new ArrayList<DataObjectType>();
            DataObjectType input = new DataObjectType();
            input.setKey("echo_input");
            input.setType(DataType.STRING.toString());
            input.setValue("helloWorld");
            exInputs.add(input);
            Experiment simpleExperiment = ExperimentModelUtil.createSimpleExperiment("project1", "admin", "echoExperiment", "EchoLocal", "EchoLocal", exInputs);
            ComputationalResourceScheduling scheduling = ExperimentModelUtil.createComputationResourceScheduling("trestles.sdsc.edu", 1, 1, 1, "development", 0, 0, 1, "sds128");
            String expId = (String)registry.add(ParentDataType.EXPERIMENT, simpleExperiment);
            registry.add(ChildDataType.COMPUTATIONAL_RESOURCE_SCHEDULING, scheduling, expId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}