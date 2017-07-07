// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: game.proto

package com.code.server.grpc.idl;

/**
 * Protobuf type {@code Order}
 */
public  final class Order extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Order)
    OrderOrBuilder {
  // Use Order.newBuilder() to construct.
  private Order(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Order() {
    userId_ = 0L;
    num_ = 0D;
    type_ = 0;
    token_ = "";
    agentId_ = 0;
    id_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Order(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            userId_ = input.readInt64();
            break;
          }
          case 17: {

            num_ = input.readDouble();
            break;
          }
          case 24: {

            type_ = input.readInt32();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            token_ = s;
            break;
          }
          case 40: {

            agentId_ = input.readInt32();
            break;
          }
          case 48: {

            id_ = input.readInt64();
            break;
          }
          case 58: {
            if (!((mutable_bitField0_ & 0x00000040) == 0x00000040)) {
              m_ = com.google.protobuf.MapField.newMapField(
                  MDefaultEntryHolder.defaultEntry);
              mutable_bitField0_ |= 0x00000040;
            }
            com.google.protobuf.MapEntry<java.lang.Integer, java.lang.String>
            m = input.readMessage(
                MDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
            m_.getMutableMap().put(m.getKey(), m.getValue());
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.code.server.grpc.idl.Game.internal_static_Order_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  protected com.google.protobuf.MapField internalGetMapField(
      int number) {
    switch (number) {
      case 7:
        return internalGetM();
      default:
        throw new RuntimeException(
            "Invalid map field number: " + number);
    }
  }
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.code.server.grpc.idl.Game.internal_static_Order_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.code.server.grpc.idl.Order.class, com.code.server.grpc.idl.Order.Builder.class);
  }

  private int bitField0_;
  public static final int USERID_FIELD_NUMBER = 1;
  private long userId_;
  /**
   * <code>optional int64 userId = 1;</code>
   */
  public long getUserId() {
    return userId_;
  }

  public static final int NUM_FIELD_NUMBER = 2;
  private double num_;
  /**
   * <code>optional double num = 2;</code>
   */
  public double getNum() {
    return num_;
  }

  public static final int TYPE_FIELD_NUMBER = 3;
  private int type_;
  /**
   * <code>optional int32 type = 3;</code>
   */
  public int getType() {
    return type_;
  }

  public static final int TOKEN_FIELD_NUMBER = 4;
  private volatile java.lang.Object token_;
  /**
   * <code>optional string token = 4;</code>
   */
  public java.lang.String getToken() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>optional string token = 4;</code>
   */
  public com.google.protobuf.ByteString
      getTokenBytes() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      token_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AGENTID_FIELD_NUMBER = 5;
  private int agentId_;
  /**
   * <code>optional int32 agentId = 5;</code>
   */
  public int getAgentId() {
    return agentId_;
  }

  public static final int ID_FIELD_NUMBER = 6;
  private long id_;
  /**
   * <code>optional int64 id = 6;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int M_FIELD_NUMBER = 7;
  private static final class MDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<
        java.lang.Integer, java.lang.String> defaultEntry =
            com.google.protobuf.MapEntry
            .<java.lang.Integer, java.lang.String>newDefaultInstance(
                com.code.server.grpc.idl.Game.internal_static_Order_MEntry_descriptor, 
                com.google.protobuf.WireFormat.FieldType.INT32,
                0,
                com.google.protobuf.WireFormat.FieldType.STRING,
                "");
  }
  private com.google.protobuf.MapField<
      java.lang.Integer, java.lang.String> m_;
  private com.google.protobuf.MapField<java.lang.Integer, java.lang.String>
  internalGetM() {
    if (m_ == null) {
      return com.google.protobuf.MapField.emptyMapField(
          MDefaultEntryHolder.defaultEntry);
    }
    return m_;
  }

  public int getMCount() {
    return internalGetM().getMap().size();
  }
  /**
   * <code>map&lt;int32, string&gt; m = 7;</code>
   */

  public boolean containsM(
      int key) {
    
    return internalGetM().getMap().containsKey(key);
  }
  /**
   * Use {@link #getMMap()} instead.
   */
  @java.lang.Deprecated
  public java.util.Map<java.lang.Integer, java.lang.String> getM() {
    return getMMap();
  }
  /**
   * <code>map&lt;int32, string&gt; m = 7;</code>
   */

  public java.util.Map<java.lang.Integer, java.lang.String> getMMap() {
    return internalGetM().getMap();
  }
  /**
   * <code>map&lt;int32, string&gt; m = 7;</code>
   */

  public java.lang.String getMOrDefault(
      int key,
      java.lang.String defaultValue) {
    
    java.util.Map<java.lang.Integer, java.lang.String> map =
        internalGetM().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
  /**
   * <code>map&lt;int32, string&gt; m = 7;</code>
   */

  public java.lang.String getMOrThrow(
      int key) {
    
    java.util.Map<java.lang.Integer, java.lang.String> map =
        internalGetM().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (userId_ != 0L) {
      output.writeInt64(1, userId_);
    }
    if (num_ != 0D) {
      output.writeDouble(2, num_);
    }
    if (type_ != 0) {
      output.writeInt32(3, type_);
    }
    if (!getTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, token_);
    }
    if (agentId_ != 0) {
      output.writeInt32(5, agentId_);
    }
    if (id_ != 0L) {
      output.writeInt64(6, id_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.String> entry
         : internalGetM().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.String>
      m = MDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      output.writeMessage(7, m);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (userId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, userId_);
    }
    if (num_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, num_);
    }
    if (type_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, type_);
    }
    if (!getTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, token_);
    }
    if (agentId_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, agentId_);
    }
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(6, id_);
    }
    for (java.util.Map.Entry<java.lang.Integer, java.lang.String> entry
         : internalGetM().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.Integer, java.lang.String>
      m = MDefaultEntryHolder.defaultEntry.newBuilderForType()
          .setKey(entry.getKey())
          .setValue(entry.getValue())
          .build();
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(7, m);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.code.server.grpc.idl.Order)) {
      return super.equals(obj);
    }
    com.code.server.grpc.idl.Order other = (com.code.server.grpc.idl.Order) obj;

    boolean result = true;
    result = result && (getUserId()
        == other.getUserId());
    result = result && (
        java.lang.Double.doubleToLongBits(getNum())
        == java.lang.Double.doubleToLongBits(
            other.getNum()));
    result = result && (getType()
        == other.getType());
    result = result && getToken()
        .equals(other.getToken());
    result = result && (getAgentId()
        == other.getAgentId());
    result = result && (getId()
        == other.getId());
    result = result && internalGetM().equals(
        other.internalGetM());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + USERID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getUserId());
    hash = (37 * hash) + NUM_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getNum()));
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getType();
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (37 * hash) + AGENTID_FIELD_NUMBER;
    hash = (53 * hash) + getAgentId();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    if (!internalGetM().getMap().isEmpty()) {
      hash = (37 * hash) + M_FIELD_NUMBER;
      hash = (53 * hash) + internalGetM().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.code.server.grpc.idl.Order parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.code.server.grpc.idl.Order parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.code.server.grpc.idl.Order parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.code.server.grpc.idl.Order parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.code.server.grpc.idl.Order parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.code.server.grpc.idl.Order parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.code.server.grpc.idl.Order parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.code.server.grpc.idl.Order parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.code.server.grpc.idl.Order parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.code.server.grpc.idl.Order parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.code.server.grpc.idl.Order prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code Order}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Order)
      com.code.server.grpc.idl.OrderOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.code.server.grpc.idl.Game.internal_static_Order_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(
        int number) {
      switch (number) {
        case 7:
          return internalGetM();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(
        int number) {
      switch (number) {
        case 7:
          return internalGetMutableM();
        default:
          throw new RuntimeException(
              "Invalid map field number: " + number);
      }
    }
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.code.server.grpc.idl.Game.internal_static_Order_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.code.server.grpc.idl.Order.class, com.code.server.grpc.idl.Order.Builder.class);
    }

    // Construct using com.code.server.grpc.idl.Order.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      userId_ = 0L;

      num_ = 0D;

      type_ = 0;

      token_ = "";

      agentId_ = 0;

      id_ = 0L;

      internalGetMutableM().clear();
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.code.server.grpc.idl.Game.internal_static_Order_descriptor;
    }

    public com.code.server.grpc.idl.Order getDefaultInstanceForType() {
      return com.code.server.grpc.idl.Order.getDefaultInstance();
    }

    public com.code.server.grpc.idl.Order build() {
      com.code.server.grpc.idl.Order result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.code.server.grpc.idl.Order buildPartial() {
      com.code.server.grpc.idl.Order result = new com.code.server.grpc.idl.Order(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.userId_ = userId_;
      result.num_ = num_;
      result.type_ = type_;
      result.token_ = token_;
      result.agentId_ = agentId_;
      result.id_ = id_;
      result.m_ = internalGetM();
      result.m_.makeImmutable();
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.code.server.grpc.idl.Order) {
        return mergeFrom((com.code.server.grpc.idl.Order)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.code.server.grpc.idl.Order other) {
      if (other == com.code.server.grpc.idl.Order.getDefaultInstance()) return this;
      if (other.getUserId() != 0L) {
        setUserId(other.getUserId());
      }
      if (other.getNum() != 0D) {
        setNum(other.getNum());
      }
      if (other.getType() != 0) {
        setType(other.getType());
      }
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
        onChanged();
      }
      if (other.getAgentId() != 0) {
        setAgentId(other.getAgentId());
      }
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      internalGetMutableM().mergeFrom(
          other.internalGetM());
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.code.server.grpc.idl.Order parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.code.server.grpc.idl.Order) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private long userId_ ;
    /**
     * <code>optional int64 userId = 1;</code>
     */
    public long getUserId() {
      return userId_;
    }
    /**
     * <code>optional int64 userId = 1;</code>
     */
    public Builder setUserId(long value) {
      
      userId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 userId = 1;</code>
     */
    public Builder clearUserId() {
      
      userId_ = 0L;
      onChanged();
      return this;
    }

    private double num_ ;
    /**
     * <code>optional double num = 2;</code>
     */
    public double getNum() {
      return num_;
    }
    /**
     * <code>optional double num = 2;</code>
     */
    public Builder setNum(double value) {
      
      num_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional double num = 2;</code>
     */
    public Builder clearNum() {
      
      num_ = 0D;
      onChanged();
      return this;
    }

    private int type_ ;
    /**
     * <code>optional int32 type = 3;</code>
     */
    public int getType() {
      return type_;
    }
    /**
     * <code>optional int32 type = 3;</code>
     */
    public Builder setType(int value) {
      
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 type = 3;</code>
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object token_ = "";
    /**
     * <code>optional string token = 4;</code>
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string token = 4;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string token = 4;</code>
     */
    public Builder setToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      token_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional string token = 4;</code>
     */
    public Builder clearToken() {
      
      token_ = getDefaultInstance().getToken();
      onChanged();
      return this;
    }
    /**
     * <code>optional string token = 4;</code>
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      token_ = value;
      onChanged();
      return this;
    }

    private int agentId_ ;
    /**
     * <code>optional int32 agentId = 5;</code>
     */
    public int getAgentId() {
      return agentId_;
    }
    /**
     * <code>optional int32 agentId = 5;</code>
     */
    public Builder setAgentId(int value) {
      
      agentId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int32 agentId = 5;</code>
     */
    public Builder clearAgentId() {
      
      agentId_ = 0;
      onChanged();
      return this;
    }

    private long id_ ;
    /**
     * <code>optional int64 id = 6;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <code>optional int64 id = 6;</code>
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>optional int64 id = 6;</code>
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.MapField<
        java.lang.Integer, java.lang.String> m_;
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.String>
    internalGetM() {
      if (m_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            MDefaultEntryHolder.defaultEntry);
      }
      return m_;
    }
    private com.google.protobuf.MapField<java.lang.Integer, java.lang.String>
    internalGetMutableM() {
      onChanged();;
      if (m_ == null) {
        m_ = com.google.protobuf.MapField.newMapField(
            MDefaultEntryHolder.defaultEntry);
      }
      if (!m_.isMutable()) {
        m_ = m_.copy();
      }
      return m_;
    }

    public int getMCount() {
      return internalGetM().getMap().size();
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */

    public boolean containsM(
        int key) {
      
      return internalGetM().getMap().containsKey(key);
    }
    /**
     * Use {@link #getMMap()} instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.String> getM() {
      return getMMap();
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */

    public java.util.Map<java.lang.Integer, java.lang.String> getMMap() {
      return internalGetM().getMap();
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */

    public java.lang.String getMOrDefault(
        int key,
        java.lang.String defaultValue) {
      
      java.util.Map<java.lang.Integer, java.lang.String> map =
          internalGetM().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */

    public java.lang.String getMOrThrow(
        int key) {
      
      java.util.Map<java.lang.Integer, java.lang.String> map =
          internalGetM().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearM() {
      getMutableM().clear();
      return this;
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */

    public Builder removeM(
        int key) {
      
      getMutableM().remove(key);
      return this;
    }
    /**
     * Use alternate mutation accessors instead.
     */
    @java.lang.Deprecated
    public java.util.Map<java.lang.Integer, java.lang.String>
    getMutableM() {
      return internalGetMutableM().getMutableMap();
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */
    public Builder putM(
        int key,
        java.lang.String value) {
      
      if (value == null) { throw new java.lang.NullPointerException(); }
      getMutableM().put(key, value);
      return this;
    }
    /**
     * <code>map&lt;int32, string&gt; m = 7;</code>
     */

    public Builder putAllM(
        java.util.Map<java.lang.Integer, java.lang.String> values) {
      getMutableM().putAll(values);
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:Order)
  }

  // @@protoc_insertion_point(class_scope:Order)
  private static final com.code.server.grpc.idl.Order DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.code.server.grpc.idl.Order();
  }

  public static com.code.server.grpc.idl.Order getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Order>
      PARSER = new com.google.protobuf.AbstractParser<Order>() {
    public Order parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Order(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Order> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Order> getParserForType() {
    return PARSER;
  }

  public com.code.server.grpc.idl.Order getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
