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

package org.apache.airavata.testsuite.multitenantedairavata.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrameworkUtils {
    private static PropertyReader propertyReader;

    private static FrameworkUtils ourInstance = new FrameworkUtils();

    public static FrameworkUtils getInstance() {
        return ourInstance;
    }

    public FrameworkUtils() {
        propertyReader = new PropertyReader();
    }

    public List<String> getGatewayListToAvoid (){
        String listOfGateways = propertyReader.readProperty(TestFrameworkConstants.FrameworkPropertiesConstants.GATEWAYS_TOSKIP, PropertyFileType.TEST_FRAMEWORK);
        String[] gateways = listOfGateways.split(",");
        return Arrays.asList(gateways);
    }

    public String getTestUserName (){
        return propertyReader.readProperty(TestFrameworkConstants.FrameworkPropertiesConstants.TEST_USER, PropertyFileType.TEST_FRAMEWORK);
    }

    public String getTesProjectName (){
        return propertyReader.readProperty(TestFrameworkConstants.FrameworkPropertiesConstants.TEST_PROJECT, PropertyFileType.TEST_FRAMEWORK);
    }
}