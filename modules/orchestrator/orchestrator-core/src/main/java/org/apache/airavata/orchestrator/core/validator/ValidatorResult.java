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
package org.apache.airavata.orchestrator.core.validator;

public class ValidatorResult {
    private boolean isSuccessful;

    private String validationMessage;


    public ValidatorResult(boolean successful) {
        isSuccessful = successful;
    }

    public ValidatorResult(boolean successful, String validationMessage) {
        isSuccessful = successful;
        this.validationMessage = validationMessage;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getValidationMessage() {

        return validationMessage;
    }

    public void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }
}