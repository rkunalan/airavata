/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.appcatalog.computeresource;


import java.util.Map;
import java.util.HashMap;
import org.apache.thrift.TEnum;

/**
 * Monitoring modes
 * 
 * POLL_JOB_MANAGER:
 * GFac need to pull job status changes.
 * 
 * XSEDE_AMQP_SUBSCRIBE:
 * Server will publish job status changes to amqp servert.
 * 
 * 
 */
public enum MonitorMode implements org.apache.thrift.TEnum {
  POLL_JOB_MANAGER(0),
  JOB_EMAIL_NOTIFICATION_MONITOR(1),
  XSEDE_AMQP_SUBSCRIBE(2),
  FORK(3),
  LOCAL(4);

  private final int value;

  private MonitorMode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static MonitorMode findByValue(int value) { 
    switch (value) {
      case 0:
        return POLL_JOB_MANAGER;
      case 1:
        return JOB_EMAIL_NOTIFICATION_MONITOR;
      case 2:
        return XSEDE_AMQP_SUBSCRIBE;
      case 3:
        return FORK;
      case 4:
        return LOCAL;
      default:
        return null;
    }
  }
}
