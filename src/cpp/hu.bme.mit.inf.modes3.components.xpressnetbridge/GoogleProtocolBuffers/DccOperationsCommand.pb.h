// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: DccOperationsCommand.proto

#ifndef PROTOBUF_DccOperationsCommand_2eproto__INCLUDED
#define PROTOBUF_DccOperationsCommand_2eproto__INCLUDED

#include <string>

#include <google/protobuf/stubs/common.h>

#if GOOGLE_PROTOBUF_VERSION < 3001000
#error This file was generated by a newer version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please update
#error your headers.
#endif
#if 3001000 < GOOGLE_PROTOBUF_MIN_PROTOC_VERSION
#error This file was generated by an older version of protoc which is
#error incompatible with your Protocol Buffer headers.  Please
#error regenerate this file with a newer version of protoc.
#endif

#include <google/protobuf/arena.h>
#include <google/protobuf/arenastring.h>
#include <google/protobuf/generated_message_util.h>
#include <google/protobuf/metadata.h>
#include <google/protobuf/message.h>
#include <google/protobuf/repeated_field.h>
#include <google/protobuf/extension_set.h>
#include <google/protobuf/unknown_field_set.h>
#include "Enums.pb.h"
// @@protoc_insertion_point(includes)

namespace modes3 {
namespace protobuf {

// Internal implementation detail -- do not call these.
void protobuf_AddDesc_DccOperationsCommand_2eproto();
void protobuf_InitDefaults_DccOperationsCommand_2eproto();
void protobuf_AssignDesc_DccOperationsCommand_2eproto();
void protobuf_ShutdownFile_DccOperationsCommand_2eproto();

class DccOperationsCommand;

// ===================================================================

class DccOperationsCommand : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:modes3.protobuf.DccOperationsCommand) */ {
 public:
  DccOperationsCommand();
  virtual ~DccOperationsCommand();

  DccOperationsCommand(const DccOperationsCommand& from);

  inline DccOperationsCommand& operator=(const DccOperationsCommand& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const DccOperationsCommand& default_instance();

  static const DccOperationsCommand* internal_default_instance();

  void Swap(DccOperationsCommand* other);

  // implements Message ----------------------------------------------

  inline DccOperationsCommand* New() const { return New(NULL); }

  DccOperationsCommand* New(::google::protobuf::Arena* arena) const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const DccOperationsCommand& from);
  void MergeFrom(const DccOperationsCommand& from);
  void Clear();
  bool IsInitialized() const;

  size_t ByteSizeLong() const;
  bool MergePartialFromCodedStream(
      ::google::protobuf::io::CodedInputStream* input);
  void SerializeWithCachedSizes(
      ::google::protobuf::io::CodedOutputStream* output) const;
  ::google::protobuf::uint8* InternalSerializeWithCachedSizesToArray(
      bool deterministic, ::google::protobuf::uint8* output) const;
  ::google::protobuf::uint8* SerializeWithCachedSizesToArray(::google::protobuf::uint8* output) const {
    return InternalSerializeWithCachedSizesToArray(false, output);
  }
  int GetCachedSize() const { return _cached_size_; }
  private:
  void SharedCtor();
  void SharedDtor();
  void SetCachedSize(int size) const;
  void InternalSwap(DccOperationsCommand* other);
  void UnsafeMergeFrom(const DccOperationsCommand& from);
  private:
  inline ::google::protobuf::Arena* GetArenaNoVirtual() const {
    return _internal_metadata_.arena();
  }
  inline void* MaybeArenaPtr() const {
    return _internal_metadata_.raw_arena_ptr();
  }
  public:

  ::google::protobuf::Metadata GetMetadata() const;

  // nested types ----------------------------------------------------

  // accessors -------------------------------------------------------

  // optional .modes3.protobuf.DccOperations dccOperations = 1;
  void clear_dccoperations();
  static const int kDccOperationsFieldNumber = 1;
  ::modes3::protobuf::DccOperations dccoperations() const;
  void set_dccoperations(::modes3::protobuf::DccOperations value);

  // @@protoc_insertion_point(class_scope:modes3.protobuf.DccOperationsCommand)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  int dccoperations_;
  mutable int _cached_size_;
  friend void  protobuf_InitDefaults_DccOperationsCommand_2eproto_impl();
  friend void  protobuf_AddDesc_DccOperationsCommand_2eproto_impl();
  friend void protobuf_AssignDesc_DccOperationsCommand_2eproto();
  friend void protobuf_ShutdownFile_DccOperationsCommand_2eproto();

  void InitAsDefaultInstance();
};
extern ::google::protobuf::internal::ExplicitlyConstructed<DccOperationsCommand> DccOperationsCommand_default_instance_;

// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// DccOperationsCommand

// optional .modes3.protobuf.DccOperations dccOperations = 1;
inline void DccOperationsCommand::clear_dccoperations() {
  dccoperations_ = 0;
}
inline ::modes3::protobuf::DccOperations DccOperationsCommand::dccoperations() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.DccOperationsCommand.dccOperations)
  return static_cast< ::modes3::protobuf::DccOperations >(dccoperations_);
}
inline void DccOperationsCommand::set_dccoperations(::modes3::protobuf::DccOperations value) {
  
  dccoperations_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.DccOperationsCommand.dccOperations)
}

inline const DccOperationsCommand* DccOperationsCommand::internal_default_instance() {
  return &DccOperationsCommand_default_instance_.get();
}
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)

}  // namespace protobuf
}  // namespace modes3

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_DccOperationsCommand_2eproto__INCLUDED
