#
# Autogenerated by Thrift Compiler (0.9.3)
#
# DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
#
#  options string: py
#

from thrift.Thrift import TType, TMessageType, TException, TApplicationException

from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol, TProtocol
try:
  from thrift.protocol import fastbinary
except:
  fastbinary = None


class CredentialOwnerType:
  GATEWAY = 0
  USER = 1

  _VALUES_TO_NAMES = {
    0: "GATEWAY",
    1: "USER",
  }

  _NAMES_TO_VALUES = {
    "GATEWAY": 0,
    "USER": 1,
  }

class SummaryType:
  """
  Data Types supported in Airavata. The primitive data types

  """
  SSH = 0
  PASSWD = 1
  CERT = 2

  _VALUES_TO_NAMES = {
    0: "SSH",
    1: "PASSWD",
    2: "CERT",
  }

  _NAMES_TO_VALUES = {
    "SSH": 0,
    "PASSWD": 1,
    "CERT": 2,
  }


class SSHCredential:
  """
  Attributes:
   - gatewayId
   - username
   - passphrase
   - publicKey
   - privateKey
   - persistedTime
   - token
   - description
   - credentialOwnerType
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'gatewayId', None, None, ), # 1
    (2, TType.STRING, 'username', None, None, ), # 2
    (3, TType.STRING, 'passphrase', None, None, ), # 3
    (4, TType.STRING, 'publicKey', None, None, ), # 4
    (5, TType.STRING, 'privateKey', None, None, ), # 5
    (6, TType.I64, 'persistedTime', None, None, ), # 6
    (7, TType.STRING, 'token', None, None, ), # 7
    (8, TType.STRING, 'description', None, None, ), # 8
    (9, TType.I32, 'credentialOwnerType', None,     0, ), # 9
  )

  def __init__(self, gatewayId=None, username=None, passphrase=None, publicKey=None, privateKey=None, persistedTime=None, token=None, description=None, credentialOwnerType=thrift_spec[9][4],):
    self.gatewayId = gatewayId
    self.username = username
    self.passphrase = passphrase
    self.publicKey = publicKey
    self.privateKey = privateKey
    self.persistedTime = persistedTime
    self.token = token
    self.description = description
    self.credentialOwnerType = credentialOwnerType

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.username = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.passphrase = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.publicKey = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.STRING:
          self.privateKey = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.I64:
          self.persistedTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.STRING:
          self.token = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 8:
        if ftype == TType.STRING:
          self.description = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 9:
        if ftype == TType.I32:
          self.credentialOwnerType = iprot.readI32()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('SSHCredential')
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 1)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.username is not None:
      oprot.writeFieldBegin('username', TType.STRING, 2)
      oprot.writeString(self.username)
      oprot.writeFieldEnd()
    if self.passphrase is not None:
      oprot.writeFieldBegin('passphrase', TType.STRING, 3)
      oprot.writeString(self.passphrase)
      oprot.writeFieldEnd()
    if self.publicKey is not None:
      oprot.writeFieldBegin('publicKey', TType.STRING, 4)
      oprot.writeString(self.publicKey)
      oprot.writeFieldEnd()
    if self.privateKey is not None:
      oprot.writeFieldBegin('privateKey', TType.STRING, 5)
      oprot.writeString(self.privateKey)
      oprot.writeFieldEnd()
    if self.persistedTime is not None:
      oprot.writeFieldBegin('persistedTime', TType.I64, 6)
      oprot.writeI64(self.persistedTime)
      oprot.writeFieldEnd()
    if self.token is not None:
      oprot.writeFieldBegin('token', TType.STRING, 7)
      oprot.writeString(self.token)
      oprot.writeFieldEnd()
    if self.description is not None:
      oprot.writeFieldBegin('description', TType.STRING, 8)
      oprot.writeString(self.description)
      oprot.writeFieldEnd()
    if self.credentialOwnerType is not None:
      oprot.writeFieldBegin('credentialOwnerType', TType.I32, 9)
      oprot.writeI32(self.credentialOwnerType)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    if self.username is None:
      raise TProtocol.TProtocolException(message='Required field username is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.username)
    value = (value * 31) ^ hash(self.passphrase)
    value = (value * 31) ^ hash(self.publicKey)
    value = (value * 31) ^ hash(self.privateKey)
    value = (value * 31) ^ hash(self.persistedTime)
    value = (value * 31) ^ hash(self.token)
    value = (value * 31) ^ hash(self.description)
    value = (value * 31) ^ hash(self.credentialOwnerType)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class CredentialSummary:
  """
  Attributes:
   - type
   - gatewayId
   - username
   - publicKey
   - persistedTime
   - token
   - description
  """

  thrift_spec = (
    None, # 0
    (1, TType.I32, 'type', None, None, ), # 1
    (2, TType.STRING, 'gatewayId', None, None, ), # 2
    (3, TType.STRING, 'username', None, None, ), # 3
    (4, TType.STRING, 'publicKey', None, None, ), # 4
    (5, TType.I64, 'persistedTime', None, None, ), # 5
    (6, TType.STRING, 'token', None, None, ), # 6
    (7, TType.STRING, 'description', None, None, ), # 7
  )

  def __init__(self, type=None, gatewayId=None, username=None, publicKey=None, persistedTime=None, token=None, description=None,):
    self.type = type
    self.gatewayId = gatewayId
    self.username = username
    self.publicKey = publicKey
    self.persistedTime = persistedTime
    self.token = token
    self.description = description

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.I32:
          self.type = iprot.readI32()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.username = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.publicKey = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.I64:
          self.persistedTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.STRING:
          self.token = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.STRING:
          self.description = iprot.readString()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('CredentialSummary')
    if self.type is not None:
      oprot.writeFieldBegin('type', TType.I32, 1)
      oprot.writeI32(self.type)
      oprot.writeFieldEnd()
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 2)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.username is not None:
      oprot.writeFieldBegin('username', TType.STRING, 3)
      oprot.writeString(self.username)
      oprot.writeFieldEnd()
    if self.publicKey is not None:
      oprot.writeFieldBegin('publicKey', TType.STRING, 4)
      oprot.writeString(self.publicKey)
      oprot.writeFieldEnd()
    if self.persistedTime is not None:
      oprot.writeFieldBegin('persistedTime', TType.I64, 5)
      oprot.writeI64(self.persistedTime)
      oprot.writeFieldEnd()
    if self.token is not None:
      oprot.writeFieldBegin('token', TType.STRING, 6)
      oprot.writeString(self.token)
      oprot.writeFieldEnd()
    if self.description is not None:
      oprot.writeFieldBegin('description', TType.STRING, 7)
      oprot.writeString(self.description)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.type is None:
      raise TProtocol.TProtocolException(message='Required field type is unset!')
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    if self.username is None:
      raise TProtocol.TProtocolException(message='Required field username is unset!')
    if self.token is None:
      raise TProtocol.TProtocolException(message='Required field token is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.type)
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.username)
    value = (value * 31) ^ hash(self.publicKey)
    value = (value * 31) ^ hash(self.persistedTime)
    value = (value * 31) ^ hash(self.token)
    value = (value * 31) ^ hash(self.description)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class CommunityUser:
  """
  Attributes:
   - gatewayName
   - username
   - userEmail
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'gatewayName', None, None, ), # 1
    (2, TType.STRING, 'username', None, None, ), # 2
    (3, TType.STRING, 'userEmail', None, None, ), # 3
  )

  def __init__(self, gatewayName=None, username=None, userEmail=None,):
    self.gatewayName = gatewayName
    self.username = username
    self.userEmail = userEmail

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.gatewayName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.username = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.userEmail = iprot.readString()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('CommunityUser')
    if self.gatewayName is not None:
      oprot.writeFieldBegin('gatewayName', TType.STRING, 1)
      oprot.writeString(self.gatewayName)
      oprot.writeFieldEnd()
    if self.username is not None:
      oprot.writeFieldBegin('username', TType.STRING, 2)
      oprot.writeString(self.username)
      oprot.writeFieldEnd()
    if self.userEmail is not None:
      oprot.writeFieldBegin('userEmail', TType.STRING, 3)
      oprot.writeString(self.userEmail)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.gatewayName is None:
      raise TProtocol.TProtocolException(message='Required field gatewayName is unset!')
    if self.username is None:
      raise TProtocol.TProtocolException(message='Required field username is unset!')
    if self.userEmail is None:
      raise TProtocol.TProtocolException(message='Required field userEmail is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.gatewayName)
    value = (value * 31) ^ hash(self.username)
    value = (value * 31) ^ hash(self.userEmail)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class CertificateCredential:
  """
  Attributes:
   - communityUser
   - x509Cert
   - notAfter
   - privateKey
   - lifeTime
   - notBefore
   - persistedTime
   - token
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRUCT, 'communityUser', (CommunityUser, CommunityUser.thrift_spec), None, ), # 1
    (2, TType.STRING, 'x509Cert', None, None, ), # 2
    (3, TType.STRING, 'notAfter', None, None, ), # 3
    (4, TType.STRING, 'privateKey', None, None, ), # 4
    (5, TType.I64, 'lifeTime', None, None, ), # 5
    (6, TType.STRING, 'notBefore', None, None, ), # 6
    (7, TType.I64, 'persistedTime', None, None, ), # 7
    (8, TType.STRING, 'token', None, None, ), # 8
  )

  def __init__(self, communityUser=None, x509Cert=None, notAfter=None, privateKey=None, lifeTime=None, notBefore=None, persistedTime=None, token=None,):
    self.communityUser = communityUser
    self.x509Cert = x509Cert
    self.notAfter = notAfter
    self.privateKey = privateKey
    self.lifeTime = lifeTime
    self.notBefore = notBefore
    self.persistedTime = persistedTime
    self.token = token

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRUCT:
          self.communityUser = CommunityUser()
          self.communityUser.read(iprot)
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.x509Cert = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.notAfter = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.privateKey = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.I64:
          self.lifeTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.STRING:
          self.notBefore = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.I64:
          self.persistedTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 8:
        if ftype == TType.STRING:
          self.token = iprot.readString()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('CertificateCredential')
    if self.communityUser is not None:
      oprot.writeFieldBegin('communityUser', TType.STRUCT, 1)
      self.communityUser.write(oprot)
      oprot.writeFieldEnd()
    if self.x509Cert is not None:
      oprot.writeFieldBegin('x509Cert', TType.STRING, 2)
      oprot.writeString(self.x509Cert)
      oprot.writeFieldEnd()
    if self.notAfter is not None:
      oprot.writeFieldBegin('notAfter', TType.STRING, 3)
      oprot.writeString(self.notAfter)
      oprot.writeFieldEnd()
    if self.privateKey is not None:
      oprot.writeFieldBegin('privateKey', TType.STRING, 4)
      oprot.writeString(self.privateKey)
      oprot.writeFieldEnd()
    if self.lifeTime is not None:
      oprot.writeFieldBegin('lifeTime', TType.I64, 5)
      oprot.writeI64(self.lifeTime)
      oprot.writeFieldEnd()
    if self.notBefore is not None:
      oprot.writeFieldBegin('notBefore', TType.STRING, 6)
      oprot.writeString(self.notBefore)
      oprot.writeFieldEnd()
    if self.persistedTime is not None:
      oprot.writeFieldBegin('persistedTime', TType.I64, 7)
      oprot.writeI64(self.persistedTime)
      oprot.writeFieldEnd()
    if self.token is not None:
      oprot.writeFieldBegin('token', TType.STRING, 8)
      oprot.writeString(self.token)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.communityUser is None:
      raise TProtocol.TProtocolException(message='Required field communityUser is unset!')
    if self.x509Cert is None:
      raise TProtocol.TProtocolException(message='Required field x509Cert is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.communityUser)
    value = (value * 31) ^ hash(self.x509Cert)
    value = (value * 31) ^ hash(self.notAfter)
    value = (value * 31) ^ hash(self.privateKey)
    value = (value * 31) ^ hash(self.lifeTime)
    value = (value * 31) ^ hash(self.notBefore)
    value = (value * 31) ^ hash(self.persistedTime)
    value = (value * 31) ^ hash(self.token)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)

class PasswordCredential:
  """
  Attributes:
   - gatewayId
   - portalUserName
   - loginUserName
   - password
   - description
   - persistedTime
   - token
  """

  thrift_spec = (
    None, # 0
    (1, TType.STRING, 'gatewayId', None, None, ), # 1
    (2, TType.STRING, 'portalUserName', None, None, ), # 2
    (3, TType.STRING, 'loginUserName', None, None, ), # 3
    (4, TType.STRING, 'password', None, None, ), # 4
    (5, TType.STRING, 'description', None, None, ), # 5
    (6, TType.I64, 'persistedTime', None, None, ), # 6
    (7, TType.STRING, 'token', None, None, ), # 7
  )

  def __init__(self, gatewayId=None, portalUserName=None, loginUserName=None, password=None, description=None, persistedTime=None, token=None,):
    self.gatewayId = gatewayId
    self.portalUserName = portalUserName
    self.loginUserName = loginUserName
    self.password = password
    self.description = description
    self.persistedTime = persistedTime
    self.token = token

  def read(self, iprot):
    if iprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and isinstance(iprot.trans, TTransport.CReadableTransport) and self.thrift_spec is not None and fastbinary is not None:
      fastbinary.decode_binary(self, iprot.trans, (self.__class__, self.thrift_spec))
      return
    iprot.readStructBegin()
    while True:
      (fname, ftype, fid) = iprot.readFieldBegin()
      if ftype == TType.STOP:
        break
      if fid == 1:
        if ftype == TType.STRING:
          self.gatewayId = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 2:
        if ftype == TType.STRING:
          self.portalUserName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 3:
        if ftype == TType.STRING:
          self.loginUserName = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 4:
        if ftype == TType.STRING:
          self.password = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 5:
        if ftype == TType.STRING:
          self.description = iprot.readString()
        else:
          iprot.skip(ftype)
      elif fid == 6:
        if ftype == TType.I64:
          self.persistedTime = iprot.readI64()
        else:
          iprot.skip(ftype)
      elif fid == 7:
        if ftype == TType.STRING:
          self.token = iprot.readString()
        else:
          iprot.skip(ftype)
      else:
        iprot.skip(ftype)
      iprot.readFieldEnd()
    iprot.readStructEnd()

  def write(self, oprot):
    if oprot.__class__ == TBinaryProtocol.TBinaryProtocolAccelerated and self.thrift_spec is not None and fastbinary is not None:
      oprot.trans.write(fastbinary.encode_binary(self, (self.__class__, self.thrift_spec)))
      return
    oprot.writeStructBegin('PasswordCredential')
    if self.gatewayId is not None:
      oprot.writeFieldBegin('gatewayId', TType.STRING, 1)
      oprot.writeString(self.gatewayId)
      oprot.writeFieldEnd()
    if self.portalUserName is not None:
      oprot.writeFieldBegin('portalUserName', TType.STRING, 2)
      oprot.writeString(self.portalUserName)
      oprot.writeFieldEnd()
    if self.loginUserName is not None:
      oprot.writeFieldBegin('loginUserName', TType.STRING, 3)
      oprot.writeString(self.loginUserName)
      oprot.writeFieldEnd()
    if self.password is not None:
      oprot.writeFieldBegin('password', TType.STRING, 4)
      oprot.writeString(self.password)
      oprot.writeFieldEnd()
    if self.description is not None:
      oprot.writeFieldBegin('description', TType.STRING, 5)
      oprot.writeString(self.description)
      oprot.writeFieldEnd()
    if self.persistedTime is not None:
      oprot.writeFieldBegin('persistedTime', TType.I64, 6)
      oprot.writeI64(self.persistedTime)
      oprot.writeFieldEnd()
    if self.token is not None:
      oprot.writeFieldBegin('token', TType.STRING, 7)
      oprot.writeString(self.token)
      oprot.writeFieldEnd()
    oprot.writeFieldStop()
    oprot.writeStructEnd()

  def validate(self):
    if self.gatewayId is None:
      raise TProtocol.TProtocolException(message='Required field gatewayId is unset!')
    if self.portalUserName is None:
      raise TProtocol.TProtocolException(message='Required field portalUserName is unset!')
    if self.loginUserName is None:
      raise TProtocol.TProtocolException(message='Required field loginUserName is unset!')
    if self.password is None:
      raise TProtocol.TProtocolException(message='Required field password is unset!')
    return


  def __hash__(self):
    value = 17
    value = (value * 31) ^ hash(self.gatewayId)
    value = (value * 31) ^ hash(self.portalUserName)
    value = (value * 31) ^ hash(self.loginUserName)
    value = (value * 31) ^ hash(self.password)
    value = (value * 31) ^ hash(self.description)
    value = (value * 31) ^ hash(self.persistedTime)
    value = (value * 31) ^ hash(self.token)
    return value

  def __repr__(self):
    L = ['%s=%r' % (key, value)
      for key, value in self.__dict__.iteritems()]
    return '%s(%s)' % (self.__class__.__name__, ', '.join(L))

  def __eq__(self, other):
    return isinstance(other, self.__class__) and self.__dict__ == other.__dict__

  def __ne__(self, other):
    return not (self == other)