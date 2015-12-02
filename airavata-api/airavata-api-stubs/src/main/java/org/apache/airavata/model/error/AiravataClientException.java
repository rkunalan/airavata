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
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.airavata.model.error;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
/**
 * This exception is thrown by Airavata Services when a call fails as a result of
 * a problem that a client may be able to resolve.  For example, if the user
 * attempts to execute an application on a resource gateway does not have access to.
 * 
 * This exception would not be used for internal system errors that do not
 * reflect user actions, but rather reflect a problem within the service that
 * the client cannot resolve.
 * 
 * airavataErrorType:  The message type indicating the error that occurred.
 *   must be one of the values of AiravataErrorType.
 * 
 * parameter:  If the error applied to a particular input parameter, this will
 *   indicate which parameter.
 */
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2015-12-2")
public class AiravataClientException extends TException implements org.apache.thrift.TBase<AiravataClientException, AiravataClientException._Fields>, java.io.Serializable, Cloneable, Comparable<AiravataClientException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AiravataClientException");

  private static final org.apache.thrift.protocol.TField AIRAVATA_ERROR_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("airavataErrorType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField PARAMETER_FIELD_DESC = new org.apache.thrift.protocol.TField("parameter", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new AiravataClientExceptionStandardSchemeFactory());
    schemes.put(TupleScheme.class, new AiravataClientExceptionTupleSchemeFactory());
  }

  /**
   * 
   * @see AiravataErrorType
   */
  public AiravataErrorType airavataErrorType; // required
  public String parameter; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see AiravataErrorType
     */
    AIRAVATA_ERROR_TYPE((short)1, "airavataErrorType"),
    PARAMETER((short)2, "parameter");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // AIRAVATA_ERROR_TYPE
          return AIRAVATA_ERROR_TYPE;
        case 2: // PARAMETER
          return PARAMETER;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.PARAMETER};
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.AIRAVATA_ERROR_TYPE, new org.apache.thrift.meta_data.FieldMetaData("airavataErrorType", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, AiravataErrorType.class)));
    tmpMap.put(_Fields.PARAMETER, new org.apache.thrift.meta_data.FieldMetaData("parameter", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AiravataClientException.class, metaDataMap);
  }

  public AiravataClientException() {
  }

  public AiravataClientException(
    AiravataErrorType airavataErrorType)
  {
    this();
    this.airavataErrorType = airavataErrorType;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AiravataClientException(AiravataClientException other) {
    if (other.isSetAiravataErrorType()) {
      this.airavataErrorType = other.airavataErrorType;
    }
    if (other.isSetParameter()) {
      this.parameter = other.parameter;
    }
  }

  public AiravataClientException deepCopy() {
    return new AiravataClientException(this);
  }

  @Override
  public void clear() {
    this.airavataErrorType = null;
    this.parameter = null;
  }

  /**
   * 
   * @see AiravataErrorType
   */
  public AiravataErrorType getAiravataErrorType() {
    return this.airavataErrorType;
  }

  /**
   * 
   * @see AiravataErrorType
   */
  public AiravataClientException setAiravataErrorType(AiravataErrorType airavataErrorType) {
    this.airavataErrorType = airavataErrorType;
    return this;
  }

  public void unsetAiravataErrorType() {
    this.airavataErrorType = null;
  }

  /** Returns true if field airavataErrorType is set (has been assigned a value) and false otherwise */
  public boolean isSetAiravataErrorType() {
    return this.airavataErrorType != null;
  }

  public void setAiravataErrorTypeIsSet(boolean value) {
    if (!value) {
      this.airavataErrorType = null;
    }
  }

  public String getParameter() {
    return this.parameter;
  }

  public AiravataClientException setParameter(String parameter) {
    this.parameter = parameter;
    return this;
  }

  public void unsetParameter() {
    this.parameter = null;
  }

  /** Returns true if field parameter is set (has been assigned a value) and false otherwise */
  public boolean isSetParameter() {
    return this.parameter != null;
  }

  public void setParameterIsSet(boolean value) {
    if (!value) {
      this.parameter = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case AIRAVATA_ERROR_TYPE:
      if (value == null) {
        unsetAiravataErrorType();
      } else {
        setAiravataErrorType((AiravataErrorType)value);
      }
      break;

    case PARAMETER:
      if (value == null) {
        unsetParameter();
      } else {
        setParameter((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case AIRAVATA_ERROR_TYPE:
      return getAiravataErrorType();

    case PARAMETER:
      return getParameter();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case AIRAVATA_ERROR_TYPE:
      return isSetAiravataErrorType();
    case PARAMETER:
      return isSetParameter();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof AiravataClientException)
      return this.equals((AiravataClientException)that);
    return false;
  }

  public boolean equals(AiravataClientException that) {
    if (that == null)
      return false;

    boolean this_present_airavataErrorType = true && this.isSetAiravataErrorType();
    boolean that_present_airavataErrorType = true && that.isSetAiravataErrorType();
    if (this_present_airavataErrorType || that_present_airavataErrorType) {
      if (!(this_present_airavataErrorType && that_present_airavataErrorType))
        return false;
      if (!this.airavataErrorType.equals(that.airavataErrorType))
        return false;
    }

    boolean this_present_parameter = true && this.isSetParameter();
    boolean that_present_parameter = true && that.isSetParameter();
    if (this_present_parameter || that_present_parameter) {
      if (!(this_present_parameter && that_present_parameter))
        return false;
      if (!this.parameter.equals(that.parameter))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_airavataErrorType = true && (isSetAiravataErrorType());
    list.add(present_airavataErrorType);
    if (present_airavataErrorType)
      list.add(airavataErrorType.getValue());

    boolean present_parameter = true && (isSetParameter());
    list.add(present_parameter);
    if (present_parameter)
      list.add(parameter);

    return list.hashCode();
  }

  @Override
  public int compareTo(AiravataClientException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetAiravataErrorType()).compareTo(other.isSetAiravataErrorType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAiravataErrorType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.airavataErrorType, other.airavataErrorType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetParameter()).compareTo(other.isSetParameter());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetParameter()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.parameter, other.parameter);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("AiravataClientException(");
    boolean first = true;

    sb.append("airavataErrorType:");
    if (this.airavataErrorType == null) {
      sb.append("null");
    } else {
      sb.append(this.airavataErrorType);
    }
    first = false;
    if (isSetParameter()) {
      if (!first) sb.append(", ");
      sb.append("parameter:");
      if (this.parameter == null) {
        sb.append("null");
      } else {
        sb.append(this.parameter);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (airavataErrorType == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'airavataErrorType' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AiravataClientExceptionStandardSchemeFactory implements SchemeFactory {
    public AiravataClientExceptionStandardScheme getScheme() {
      return new AiravataClientExceptionStandardScheme();
    }
  }

  private static class AiravataClientExceptionStandardScheme extends StandardScheme<AiravataClientException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AiravataClientException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // AIRAVATA_ERROR_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.airavataErrorType = org.apache.airavata.model.error.AiravataErrorType.findByValue(iprot.readI32());
              struct.setAiravataErrorTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PARAMETER
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.parameter = iprot.readString();
              struct.setParameterIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, AiravataClientException struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.airavataErrorType != null) {
        oprot.writeFieldBegin(AIRAVATA_ERROR_TYPE_FIELD_DESC);
        oprot.writeI32(struct.airavataErrorType.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.parameter != null) {
        if (struct.isSetParameter()) {
          oprot.writeFieldBegin(PARAMETER_FIELD_DESC);
          oprot.writeString(struct.parameter);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AiravataClientExceptionTupleSchemeFactory implements SchemeFactory {
    public AiravataClientExceptionTupleScheme getScheme() {
      return new AiravataClientExceptionTupleScheme();
    }
  }

  private static class AiravataClientExceptionTupleScheme extends TupleScheme<AiravataClientException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AiravataClientException struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.airavataErrorType.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetParameter()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetParameter()) {
        oprot.writeString(struct.parameter);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AiravataClientException struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.airavataErrorType = org.apache.airavata.model.error.AiravataErrorType.findByValue(iprot.readI32());
      struct.setAiravataErrorTypeIsSet(true);
      BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.parameter = iprot.readString();
        struct.setParameterIsSet(true);
      }
    }
  }

}
