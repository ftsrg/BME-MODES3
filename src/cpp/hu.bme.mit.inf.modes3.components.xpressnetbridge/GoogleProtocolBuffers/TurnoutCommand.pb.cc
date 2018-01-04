// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TurnoutCommand.proto

#define INTERNAL_SUPPRESS_PROTOBUF_FIELD_DEPRECATION
#include "TurnoutCommand.pb.h"

#include <algorithm>

#include <google/protobuf/stubs/common.h>
#include <google/protobuf/stubs/port.h>
#include <google/protobuf/stubs/once.h>
#include <google/protobuf/io/coded_stream.h>
#include <google/protobuf/wire_format_lite_inl.h>
#include <google/protobuf/descriptor.h>
#include <google/protobuf/generated_message_reflection.h>
#include <google/protobuf/reflection_ops.h>
#include <google/protobuf/wire_format.h>
// @@protoc_insertion_point(includes)

namespace modes3 {
namespace protobuf {
class TurnoutCommandDefaultTypeInternal {
public:
 ::google::protobuf::internal::ExplicitlyConstructed<TurnoutCommand>
     _instance;
} _TurnoutCommand_default_instance_;

namespace protobuf_TurnoutCommand_2eproto {


namespace {

::google::protobuf::Metadata file_level_metadata[1];

}  // namespace

PROTOBUF_CONSTEXPR_VAR ::google::protobuf::internal::ParseTableField
    const TableStruct::entries[] GOOGLE_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  {0, 0, 0, ::google::protobuf::internal::kInvalidMask, 0, 0},
};

PROTOBUF_CONSTEXPR_VAR ::google::protobuf::internal::AuxillaryParseTableField
    const TableStruct::aux[] GOOGLE_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  ::google::protobuf::internal::AuxillaryParseTableField(),
};
PROTOBUF_CONSTEXPR_VAR ::google::protobuf::internal::ParseTable const
    TableStruct::schema[] GOOGLE_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  { NULL, NULL, 0, -1, -1, -1, -1, NULL, false },
};

const ::google::protobuf::uint32 TableStruct::offsets[] GOOGLE_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  ~0u,  // no _has_bits_
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutCommand, _internal_metadata_),
  ~0u,  // no _extensions_
  ~0u,  // no _oneof_case_
  ~0u,  // no _weak_field_map_
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutCommand, turnoutid_),
  GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutCommand, state_),
};
static const ::google::protobuf::internal::MigrationSchema schemas[] GOOGLE_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
  { 0, -1, sizeof(TurnoutCommand)},
};

static ::google::protobuf::Message const * const file_default_instances[] = {
  reinterpret_cast<const ::google::protobuf::Message*>(&_TurnoutCommand_default_instance_),
};

namespace {

void protobuf_AssignDescriptors() {
  AddDescriptors();
  ::google::protobuf::MessageFactory* factory = NULL;
  AssignDescriptors(
      "TurnoutCommand.proto", schemas, file_default_instances, TableStruct::offsets, factory,
      file_level_metadata, NULL, NULL);
}

void protobuf_AssignDescriptorsOnce() {
  static GOOGLE_PROTOBUF_DECLARE_ONCE(once);
  ::google::protobuf::GoogleOnceInit(&once, &protobuf_AssignDescriptors);
}

void protobuf_RegisterTypes(const ::std::string&) GOOGLE_ATTRIBUTE_COLD;
void protobuf_RegisterTypes(const ::std::string&) {
  protobuf_AssignDescriptorsOnce();
  ::google::protobuf::internal::RegisterAllTypes(file_level_metadata, 1);
}

}  // namespace
void TableStruct::InitDefaultsImpl() {
  GOOGLE_PROTOBUF_VERIFY_VERSION;

  ::google::protobuf::internal::InitProtobufDefaults();
  ::modes3::protobuf::protobuf_Enums_2eproto::InitDefaults();
  _TurnoutCommand_default_instance_._instance.DefaultConstruct();
  ::google::protobuf::internal::OnShutdownDestroyMessage(
      &_TurnoutCommand_default_instance_);}

void InitDefaults() {
  static GOOGLE_PROTOBUF_DECLARE_ONCE(once);
  ::google::protobuf::GoogleOnceInit(&once, &TableStruct::InitDefaultsImpl);
}
namespace {
void AddDescriptorsImpl() {
  InitDefaults();
  static const char descriptor[] GOOGLE_ATTRIBUTE_SECTION_VARIABLE(protodesc_cold) = {
      "\n\024TurnoutCommand.proto\022\017modes3.protobuf\032"
      "\013Enums.proto\"V\n\016TurnoutCommand\022\021\n\tturnou"
      "tID\030\001 \001(\r\0221\n\005state\030\002 \001(\0162\".modes3.protob"
      "uf.TurnoutStateValueB2\n.hu.bme.mit.inf.m"
      "odes3.messaging.proto.messagesP\001b\006proto3"
  };
  ::google::protobuf::DescriptorPool::InternalAddGeneratedFile(
      descriptor, 200);
  ::google::protobuf::MessageFactory::InternalRegisterGeneratedFile(
    "TurnoutCommand.proto", &protobuf_RegisterTypes);
  ::modes3::protobuf::protobuf_Enums_2eproto::AddDescriptors();
}
} // anonymous namespace

void AddDescriptors() {
  static GOOGLE_PROTOBUF_DECLARE_ONCE(once);
  ::google::protobuf::GoogleOnceInit(&once, &AddDescriptorsImpl);
}
// Force AddDescriptors() to be called at dynamic initialization time.
struct StaticDescriptorInitializer {
  StaticDescriptorInitializer() {
    AddDescriptors();
  }
} static_descriptor_initializer;

}  // namespace protobuf_TurnoutCommand_2eproto


// ===================================================================

#if !defined(_MSC_VER) || _MSC_VER >= 1900
const int TurnoutCommand::kTurnoutIDFieldNumber;
const int TurnoutCommand::kStateFieldNumber;
#endif  // !defined(_MSC_VER) || _MSC_VER >= 1900

TurnoutCommand::TurnoutCommand()
  : ::google::protobuf::Message(), _internal_metadata_(NULL) {
  if (GOOGLE_PREDICT_TRUE(this != internal_default_instance())) {
    protobuf_TurnoutCommand_2eproto::InitDefaults();
  }
  SharedCtor();
  // @@protoc_insertion_point(constructor:modes3.protobuf.TurnoutCommand)
}
TurnoutCommand::TurnoutCommand(const TurnoutCommand& from)
  : ::google::protobuf::Message(),
      _internal_metadata_(NULL),
      _cached_size_(0) {
  _internal_metadata_.MergeFrom(from._internal_metadata_);
  ::memcpy(&turnoutid_, &from.turnoutid_,
    static_cast<size_t>(reinterpret_cast<char*>(&state_) -
    reinterpret_cast<char*>(&turnoutid_)) + sizeof(state_));
  // @@protoc_insertion_point(copy_constructor:modes3.protobuf.TurnoutCommand)
}

void TurnoutCommand::SharedCtor() {
  ::memset(&turnoutid_, 0, static_cast<size_t>(
      reinterpret_cast<char*>(&state_) -
      reinterpret_cast<char*>(&turnoutid_)) + sizeof(state_));
  _cached_size_ = 0;
}

TurnoutCommand::~TurnoutCommand() {
  // @@protoc_insertion_point(destructor:modes3.protobuf.TurnoutCommand)
  SharedDtor();
}

void TurnoutCommand::SharedDtor() {
}

void TurnoutCommand::SetCachedSize(int size) const {
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
}
const ::google::protobuf::Descriptor* TurnoutCommand::descriptor() {
  protobuf_TurnoutCommand_2eproto::protobuf_AssignDescriptorsOnce();
  return protobuf_TurnoutCommand_2eproto::file_level_metadata[kIndexInFileMessages].descriptor;
}

const TurnoutCommand& TurnoutCommand::default_instance() {
  protobuf_TurnoutCommand_2eproto::InitDefaults();
  return *internal_default_instance();
}

TurnoutCommand* TurnoutCommand::New(::google::protobuf::Arena* arena) const {
  TurnoutCommand* n = new TurnoutCommand;
  if (arena != NULL) {
    arena->Own(n);
  }
  return n;
}

void TurnoutCommand::Clear() {
// @@protoc_insertion_point(message_clear_start:modes3.protobuf.TurnoutCommand)
  ::google::protobuf::uint32 cached_has_bits = 0;
  // Prevent compiler warnings about cached_has_bits being unused
  (void) cached_has_bits;

  ::memset(&turnoutid_, 0, static_cast<size_t>(
      reinterpret_cast<char*>(&state_) -
      reinterpret_cast<char*>(&turnoutid_)) + sizeof(state_));
  _internal_metadata_.Clear();
}

bool TurnoutCommand::MergePartialFromCodedStream(
    ::google::protobuf::io::CodedInputStream* input) {
#define DO_(EXPRESSION) if (!GOOGLE_PREDICT_TRUE(EXPRESSION)) goto failure
  ::google::protobuf::uint32 tag;
  // @@protoc_insertion_point(parse_start:modes3.protobuf.TurnoutCommand)
  for (;;) {
    ::std::pair< ::google::protobuf::uint32, bool> p = input->ReadTagWithCutoffNoLastTag(127u);
    tag = p.first;
    if (!p.second) goto handle_unusual;
    switch (::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
      // uint32 turnoutID = 1;
      case 1: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(8u /* 8 & 0xFF */)) {

          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   ::google::protobuf::uint32, ::google::protobuf::internal::WireFormatLite::TYPE_UINT32>(
                 input, &turnoutid_)));
        } else {
          goto handle_unusual;
        }
        break;
      }

      // .modes3.protobuf.TurnoutStateValue state = 2;
      case 2: {
        if (static_cast< ::google::protobuf::uint8>(tag) ==
            static_cast< ::google::protobuf::uint8>(16u /* 16 & 0xFF */)) {
          int value;
          DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<
                   int, ::google::protobuf::internal::WireFormatLite::TYPE_ENUM>(
                 input, &value)));
          set_state(static_cast< ::modes3::protobuf::TurnoutStateValue >(value));
        } else {
          goto handle_unusual;
        }
        break;
      }

      default: {
      handle_unusual:
        if (tag == 0) {
          goto success;
        }
        DO_(::google::protobuf::internal::WireFormat::SkipField(
              input, tag, _internal_metadata_.mutable_unknown_fields()));
        break;
      }
    }
  }
success:
  // @@protoc_insertion_point(parse_success:modes3.protobuf.TurnoutCommand)
  return true;
failure:
  // @@protoc_insertion_point(parse_failure:modes3.protobuf.TurnoutCommand)
  return false;
#undef DO_
}

void TurnoutCommand::SerializeWithCachedSizes(
    ::google::protobuf::io::CodedOutputStream* output) const {
  // @@protoc_insertion_point(serialize_start:modes3.protobuf.TurnoutCommand)
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  // uint32 turnoutID = 1;
  if (this->turnoutid() != 0) {
    ::google::protobuf::internal::WireFormatLite::WriteUInt32(1, this->turnoutid(), output);
  }

  // .modes3.protobuf.TurnoutStateValue state = 2;
  if (this->state() != 0) {
    ::google::protobuf::internal::WireFormatLite::WriteEnum(
      2, this->state(), output);
  }

  if ((_internal_metadata_.have_unknown_fields() &&  ::google::protobuf::internal::GetProto3PreserveUnknownsDefault())) {
    ::google::protobuf::internal::WireFormat::SerializeUnknownFields(
        (::google::protobuf::internal::GetProto3PreserveUnknownsDefault()   ? _internal_metadata_.unknown_fields()   : _internal_metadata_.default_instance()), output);
  }
  // @@protoc_insertion_point(serialize_end:modes3.protobuf.TurnoutCommand)
}

::google::protobuf::uint8* TurnoutCommand::InternalSerializeWithCachedSizesToArray(
    bool deterministic, ::google::protobuf::uint8* target) const {
  (void)deterministic; // Unused
  // @@protoc_insertion_point(serialize_to_array_start:modes3.protobuf.TurnoutCommand)
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  // uint32 turnoutID = 1;
  if (this->turnoutid() != 0) {
    target = ::google::protobuf::internal::WireFormatLite::WriteUInt32ToArray(1, this->turnoutid(), target);
  }

  // .modes3.protobuf.TurnoutStateValue state = 2;
  if (this->state() != 0) {
    target = ::google::protobuf::internal::WireFormatLite::WriteEnumToArray(
      2, this->state(), target);
  }

  if ((_internal_metadata_.have_unknown_fields() &&  ::google::protobuf::internal::GetProto3PreserveUnknownsDefault())) {
    target = ::google::protobuf::internal::WireFormat::SerializeUnknownFieldsToArray(
        (::google::protobuf::internal::GetProto3PreserveUnknownsDefault()   ? _internal_metadata_.unknown_fields()   : _internal_metadata_.default_instance()), target);
  }
  // @@protoc_insertion_point(serialize_to_array_end:modes3.protobuf.TurnoutCommand)
  return target;
}

size_t TurnoutCommand::ByteSizeLong() const {
// @@protoc_insertion_point(message_byte_size_start:modes3.protobuf.TurnoutCommand)
  size_t total_size = 0;

  if ((_internal_metadata_.have_unknown_fields() &&  ::google::protobuf::internal::GetProto3PreserveUnknownsDefault())) {
    total_size +=
      ::google::protobuf::internal::WireFormat::ComputeUnknownFieldsSize(
        (::google::protobuf::internal::GetProto3PreserveUnknownsDefault()   ? _internal_metadata_.unknown_fields()   : _internal_metadata_.default_instance()));
  }
  // uint32 turnoutID = 1;
  if (this->turnoutid() != 0) {
    total_size += 1 +
      ::google::protobuf::internal::WireFormatLite::UInt32Size(
        this->turnoutid());
  }

  // .modes3.protobuf.TurnoutStateValue state = 2;
  if (this->state() != 0) {
    total_size += 1 +
      ::google::protobuf::internal::WireFormatLite::EnumSize(this->state());
  }

  int cached_size = ::google::protobuf::internal::ToCachedSize(total_size);
  GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
  _cached_size_ = cached_size;
  GOOGLE_SAFE_CONCURRENT_WRITES_END();
  return total_size;
}

void TurnoutCommand::MergeFrom(const ::google::protobuf::Message& from) {
// @@protoc_insertion_point(generalized_merge_from_start:modes3.protobuf.TurnoutCommand)
  GOOGLE_DCHECK_NE(&from, this);
  const TurnoutCommand* source =
      ::google::protobuf::internal::DynamicCastToGenerated<const TurnoutCommand>(
          &from);
  if (source == NULL) {
  // @@protoc_insertion_point(generalized_merge_from_cast_fail:modes3.protobuf.TurnoutCommand)
    ::google::protobuf::internal::ReflectionOps::Merge(from, this);
  } else {
  // @@protoc_insertion_point(generalized_merge_from_cast_success:modes3.protobuf.TurnoutCommand)
    MergeFrom(*source);
  }
}

void TurnoutCommand::MergeFrom(const TurnoutCommand& from) {
// @@protoc_insertion_point(class_specific_merge_from_start:modes3.protobuf.TurnoutCommand)
  GOOGLE_DCHECK_NE(&from, this);
  _internal_metadata_.MergeFrom(from._internal_metadata_);
  ::google::protobuf::uint32 cached_has_bits = 0;
  (void) cached_has_bits;

  if (from.turnoutid() != 0) {
    set_turnoutid(from.turnoutid());
  }
  if (from.state() != 0) {
    set_state(from.state());
  }
}

void TurnoutCommand::CopyFrom(const ::google::protobuf::Message& from) {
// @@protoc_insertion_point(generalized_copy_from_start:modes3.protobuf.TurnoutCommand)
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

void TurnoutCommand::CopyFrom(const TurnoutCommand& from) {
// @@protoc_insertion_point(class_specific_copy_from_start:modes3.protobuf.TurnoutCommand)
  if (&from == this) return;
  Clear();
  MergeFrom(from);
}

bool TurnoutCommand::IsInitialized() const {
  return true;
}

void TurnoutCommand::Swap(TurnoutCommand* other) {
  if (other == this) return;
  InternalSwap(other);
}
void TurnoutCommand::InternalSwap(TurnoutCommand* other) {
  using std::swap;
  swap(turnoutid_, other->turnoutid_);
  swap(state_, other->state_);
  _internal_metadata_.Swap(&other->_internal_metadata_);
  swap(_cached_size_, other->_cached_size_);
}

::google::protobuf::Metadata TurnoutCommand::GetMetadata() const {
  protobuf_TurnoutCommand_2eproto::protobuf_AssignDescriptorsOnce();
  return protobuf_TurnoutCommand_2eproto::file_level_metadata[kIndexInFileMessages];
}

#if PROTOBUF_INLINE_NOT_IN_HEADERS
// TurnoutCommand

// uint32 turnoutID = 1;
void TurnoutCommand::clear_turnoutid() {
  turnoutid_ = 0u;
}
::google::protobuf::uint32 TurnoutCommand::turnoutid() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.TurnoutCommand.turnoutID)
  return turnoutid_;
}
void TurnoutCommand::set_turnoutid(::google::protobuf::uint32 value) {
  
  turnoutid_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.TurnoutCommand.turnoutID)
}

// .modes3.protobuf.TurnoutStateValue state = 2;
void TurnoutCommand::clear_state() {
  state_ = 0;
}
::modes3::protobuf::TurnoutStateValue TurnoutCommand::state() const {
  // @@protoc_insertion_point(field_get:modes3.protobuf.TurnoutCommand.state)
  return static_cast< ::modes3::protobuf::TurnoutStateValue >(state_);
}
void TurnoutCommand::set_state(::modes3::protobuf::TurnoutStateValue value) {
  
  state_ = value;
  // @@protoc_insertion_point(field_set:modes3.protobuf.TurnoutCommand.state)
}

#endif  // PROTOBUF_INLINE_NOT_IN_HEADERS

// @@protoc_insertion_point(namespace_scope)

}  // namespace protobuf
}  // namespace modes3

// @@protoc_insertion_point(global_scope)
