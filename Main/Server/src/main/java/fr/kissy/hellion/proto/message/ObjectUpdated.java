// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Proto/Message/ObjectUpdated.proto

package fr.kissy.hellion.proto.message;

public final class ObjectUpdated {
  private ObjectUpdated() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ObjectUpdatedProtoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // repeated .ObjectProto objects = 1;
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    java.util.List<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto> 
        getObjectsList();
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    fr.kissy.hellion.proto.common.ObjectDto.ObjectProto getObjects(int index);
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    int getObjectsCount();
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    java.util.List<? extends fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder> 
        getObjectsOrBuilderList();
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder getObjectsOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code ObjectUpdatedProto}
   */
  public static final class ObjectUpdatedProto extends
      com.google.protobuf.GeneratedMessage
      implements ObjectUpdatedProtoOrBuilder {
    // Use ObjectUpdatedProto.newBuilder() to construct.
    private ObjectUpdatedProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private ObjectUpdatedProto(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final ObjectUpdatedProto defaultInstance;
    public static ObjectUpdatedProto getDefaultInstance() {
      return defaultInstance;
    }

    public ObjectUpdatedProto getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private ObjectUpdatedProto(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                objects_ = new java.util.ArrayList<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto>();
                mutable_bitField0_ |= 0x00000001;
              }
              objects_.add(input.readMessage(fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.PARSER, extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          objects_ = java.util.Collections.unmodifiableList(objects_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return fr.kissy.hellion.proto.message.ObjectUpdated.internal_static_ObjectUpdatedProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return fr.kissy.hellion.proto.message.ObjectUpdated.internal_static_ObjectUpdatedProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.class, fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.Builder.class);
    }

    public static com.google.protobuf.Parser<ObjectUpdatedProto> PARSER =
        new com.google.protobuf.AbstractParser<ObjectUpdatedProto>() {
      public ObjectUpdatedProto parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ObjectUpdatedProto(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<ObjectUpdatedProto> getParserForType() {
      return PARSER;
    }

    // repeated .ObjectProto objects = 1;
    public static final int OBJECTS_FIELD_NUMBER = 1;
    private java.util.List<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto> objects_;
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    public java.util.List<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto> getObjectsList() {
      return objects_;
    }
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    public java.util.List<? extends fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder> 
        getObjectsOrBuilderList() {
      return objects_;
    }
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    public int getObjectsCount() {
      return objects_.size();
    }
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    public fr.kissy.hellion.proto.common.ObjectDto.ObjectProto getObjects(int index) {
      return objects_.get(index);
    }
    /**
     * <code>repeated .ObjectProto objects = 1;</code>
     */
    public fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder getObjectsOrBuilder(
        int index) {
      return objects_.get(index);
    }

    private void initFields() {
      objects_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      for (int i = 0; i < getObjectsCount(); i++) {
        if (!getObjects(i).isInitialized()) {
          memoizedIsInitialized = 0;
          return false;
        }
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < objects_.size(); i++) {
        output.writeMessage(1, objects_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < objects_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, objects_.get(i));
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ObjectUpdatedProto}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProtoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return fr.kissy.hellion.proto.message.ObjectUpdated.internal_static_ObjectUpdatedProto_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return fr.kissy.hellion.proto.message.ObjectUpdated.internal_static_ObjectUpdatedProto_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.class, fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.Builder.class);
      }

      // Construct using fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
          getObjectsFieldBuilder();
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        if (objectsBuilder_ == null) {
          objects_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          objectsBuilder_.clear();
        }
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return fr.kissy.hellion.proto.message.ObjectUpdated.internal_static_ObjectUpdatedProto_descriptor;
      }

      public fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto getDefaultInstanceForType() {
        return fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.getDefaultInstance();
      }

      public fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto build() {
        fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto buildPartial() {
        fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto result = new fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto(this);
        int from_bitField0_ = bitField0_;
        if (objectsBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            objects_ = java.util.Collections.unmodifiableList(objects_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.objects_ = objects_;
        } else {
          result.objects_ = objectsBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto) {
          return mergeFrom((fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto other) {
        if (other == fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto.getDefaultInstance()) return this;
        if (objectsBuilder_ == null) {
          if (!other.objects_.isEmpty()) {
            if (objects_.isEmpty()) {
              objects_ = other.objects_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureObjectsIsMutable();
              objects_.addAll(other.objects_);
            }
            onChanged();
          }
        } else {
          if (!other.objects_.isEmpty()) {
            if (objectsBuilder_.isEmpty()) {
              objectsBuilder_.dispose();
              objectsBuilder_ = null;
              objects_ = other.objects_;
              bitField0_ = (bitField0_ & ~0x00000001);
              objectsBuilder_ = 
                com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                   getObjectsFieldBuilder() : null;
            } else {
              objectsBuilder_.addAllMessages(other.objects_);
            }
          }
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        for (int i = 0; i < getObjectsCount(); i++) {
          if (!getObjects(i).isInitialized()) {
            
            return false;
          }
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (fr.kissy.hellion.proto.message.ObjectUpdated.ObjectUpdatedProto) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // repeated .ObjectProto objects = 1;
      private java.util.List<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto> objects_ =
        java.util.Collections.emptyList();
      private void ensureObjectsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          objects_ = new java.util.ArrayList<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto>(objects_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilder<
          fr.kissy.hellion.proto.common.ObjectDto.ObjectProto, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder, fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder> objectsBuilder_;

      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public java.util.List<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto> getObjectsList() {
        if (objectsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(objects_);
        } else {
          return objectsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public int getObjectsCount() {
        if (objectsBuilder_ == null) {
          return objects_.size();
        } else {
          return objectsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public fr.kissy.hellion.proto.common.ObjectDto.ObjectProto getObjects(int index) {
        if (objectsBuilder_ == null) {
          return objects_.get(index);
        } else {
          return objectsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder setObjects(
          int index, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto value) {
        if (objectsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureObjectsIsMutable();
          objects_.set(index, value);
          onChanged();
        } else {
          objectsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder setObjects(
          int index, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder builderForValue) {
        if (objectsBuilder_ == null) {
          ensureObjectsIsMutable();
          objects_.set(index, builderForValue.build());
          onChanged();
        } else {
          objectsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder addObjects(fr.kissy.hellion.proto.common.ObjectDto.ObjectProto value) {
        if (objectsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureObjectsIsMutable();
          objects_.add(value);
          onChanged();
        } else {
          objectsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder addObjects(
          int index, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto value) {
        if (objectsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureObjectsIsMutable();
          objects_.add(index, value);
          onChanged();
        } else {
          objectsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder addObjects(
          fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder builderForValue) {
        if (objectsBuilder_ == null) {
          ensureObjectsIsMutable();
          objects_.add(builderForValue.build());
          onChanged();
        } else {
          objectsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder addObjects(
          int index, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder builderForValue) {
        if (objectsBuilder_ == null) {
          ensureObjectsIsMutable();
          objects_.add(index, builderForValue.build());
          onChanged();
        } else {
          objectsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder addAllObjects(
          java.lang.Iterable<? extends fr.kissy.hellion.proto.common.ObjectDto.ObjectProto> values) {
        if (objectsBuilder_ == null) {
          ensureObjectsIsMutable();
          super.addAll(values, objects_);
          onChanged();
        } else {
          objectsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder clearObjects() {
        if (objectsBuilder_ == null) {
          objects_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          objectsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public Builder removeObjects(int index) {
        if (objectsBuilder_ == null) {
          ensureObjectsIsMutable();
          objects_.remove(index);
          onChanged();
        } else {
          objectsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder getObjectsBuilder(
          int index) {
        return getObjectsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder getObjectsOrBuilder(
          int index) {
        if (objectsBuilder_ == null) {
          return objects_.get(index);  } else {
          return objectsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public java.util.List<? extends fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder> 
           getObjectsOrBuilderList() {
        if (objectsBuilder_ != null) {
          return objectsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(objects_);
        }
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder addObjectsBuilder() {
        return getObjectsFieldBuilder().addBuilder(
            fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.getDefaultInstance());
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder addObjectsBuilder(
          int index) {
        return getObjectsFieldBuilder().addBuilder(
            index, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.getDefaultInstance());
      }
      /**
       * <code>repeated .ObjectProto objects = 1;</code>
       */
      public java.util.List<fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder> 
           getObjectsBuilderList() {
        return getObjectsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilder<
          fr.kissy.hellion.proto.common.ObjectDto.ObjectProto, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder, fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder> 
          getObjectsFieldBuilder() {
        if (objectsBuilder_ == null) {
          objectsBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
              fr.kissy.hellion.proto.common.ObjectDto.ObjectProto, fr.kissy.hellion.proto.common.ObjectDto.ObjectProto.Builder, fr.kissy.hellion.proto.common.ObjectDto.ObjectProtoOrBuilder>(
                  objects_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          objects_ = null;
        }
        return objectsBuilder_;
      }

      // @@protoc_insertion_point(builder_scope:ObjectUpdatedProto)
    }

    static {
      defaultInstance = new ObjectUpdatedProto(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:ObjectUpdatedProto)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_ObjectUpdatedProto_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_ObjectUpdatedProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!Proto/Message/ObjectUpdated.proto\032\031Pro" +
      "to/Common/Object.proto\032\033Proto/Common/Pro" +
      "perty.proto\"3\n\022ObjectUpdatedProto\022\035\n\007obj" +
      "ects\030\001 \003(\0132\014.ObjectProtoB2\n\036fr.kissy.hel" +
      "lion.proto.messageB\rObjectUpdated\210\001\000"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_ObjectUpdatedProto_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_ObjectUpdatedProto_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_ObjectUpdatedProto_descriptor,
              new java.lang.String[] { "Objects", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          fr.kissy.hellion.proto.common.ObjectDto.getDescriptor(),
          fr.kissy.hellion.proto.common.PropertyDto.getDescriptor(),
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
