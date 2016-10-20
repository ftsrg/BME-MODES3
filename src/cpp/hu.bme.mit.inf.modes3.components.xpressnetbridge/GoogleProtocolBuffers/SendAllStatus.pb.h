// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SendAllStatus.proto

#ifndef PROTOBUF_SendAllStatus_2eproto__INCLUDED
#define PROTOBUF_SendAllStatus_2eproto__INCLUDED

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
void protobuf_AddDesc_SendAllStatus_2eproto();
void protobuf_InitDefaults_SendAllStatus_2eproto();
void protobuf_AssignDesc_SendAllStatus_2eproto();
void protobuf_ShutdownFile_SendAllStatus_2eproto();

class SendAllStatus;

// ===================================================================

class SendAllStatus : public ::google::protobuf::Message /* @@protoc_insertion_point(class_definition:modes3.protobuf.SendAllStatus) */ {
 public:
  SendAllStatus();
  virtual ~SendAllStatus();

  SendAllStatus(const SendAllStatus& from);

  inline SendAllStatus& operator=(const SendAllStatus& from) {
    CopyFrom(from);
    return *this;
  }

  static const ::google::protobuf::Descriptor* descriptor();
  static const SendAllStatus& default_instance();

  static const SendAllStatus* internal_default_instance();

  void Swap(SendAllStatus* other);

  // implements Message ----------------------------------------------

  inline SendAllStatus* New() const { return New(NULL); }

  SendAllStatus* New(::google::protobuf::Arena* arena) const;
  void CopyFrom(const ::google::protobuf::Message& from);
  void MergeFrom(const ::google::protobuf::Message& from);
  void CopyFrom(const SendAllStatus& from);
  void MergeFrom(const SendAllStatus& from);
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
  void InternalSwap(SendAllStatus* other);
  void UnsafeMergeFrom(const SendAllStatus& from);
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

  // @@protoc_insertion_point(class_scope:modes3.protobuf.SendAllStatus)
 private:

  ::google::protobuf::internal::InternalMetadataWithArena _internal_metadata_;
  mutable int _cached_size_;
  friend void  protobuf_InitDefaults_SendAllStatus_2eproto_impl();
  friend void  protobuf_AddDesc_SendAllStatus_2eproto_impl();
  friend void protobuf_AssignDesc_SendAllStatus_2eproto();
  friend void protobuf_ShutdownFile_SendAllStatus_2eproto();

  void InitAsDefaultInstance();
};
extern ::google::protobuf::internal::ExplicitlyConstructed<SendAllStatus> SendAllStatus_default_instance_;

// ===================================================================


// ===================================================================

#if !PROTOBUF_INLINE_NOT_IN_HEADERS
// SendAllStatus

inline const SendAllStatus* SendAllStatus::internal_default_instance() {
  return &SendAllStatus_default_instance_.get();
}
#endif  // !PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)

}  // namespace protobuf
}  // namespace modes3

// @@protoc_insertion_point(global_scope)

#endif  // PROTOBUF_SendAllStatus_2eproto__INCLUDED
