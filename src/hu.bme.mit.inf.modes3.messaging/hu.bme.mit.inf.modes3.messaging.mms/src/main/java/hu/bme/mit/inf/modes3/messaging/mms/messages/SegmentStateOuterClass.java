// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SegmentState.proto

package hu.bme.mit.inf.modes3.messaging.mms.messages;

public final class SegmentStateOuterClass {
  private SegmentStateOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SegmentState_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SegmentState_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022SegmentState.proto\"f\n\014SegmentState\022\021\n\t" +
      "segmentID\030\001 \001(\r\022\"\n\005state\030\002 \001(\0162\023.Segment" +
      "State.State\"\037\n\005State\022\010\n\004FREE\020\000\022\014\n\010OCCUPI" +
      "ED\020\001B0\n,hu.bme.mit.inf.modes3.messaging." +
      "mms.messagesP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_SegmentState_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_SegmentState_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SegmentState_descriptor,
        new java.lang.String[] { "SegmentID", "State", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
