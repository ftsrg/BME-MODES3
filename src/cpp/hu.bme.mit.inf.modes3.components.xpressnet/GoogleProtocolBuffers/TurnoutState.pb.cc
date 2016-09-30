// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TurnoutState.proto

#define INTERNAL_SUPPRESS_PROTOBUF_FIELD_DEPRECATION
#include "TurnoutState.pb.h"

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

namespace modes3
{
namespace protobuf
{

    namespace
    {

        const ::google::protobuf::Descriptor* TurnoutState_descriptor_ = NULL;
        const ::google::protobuf::internal::GeneratedMessageReflection* TurnoutState_reflection_ = NULL;

    } // namespace

    void protobuf_AssignDesc_TurnoutState_2eproto()
    {
        protobuf_AddDesc_TurnoutState_2eproto();
        const ::google::protobuf::FileDescriptor* file =
            ::google::protobuf::DescriptorPool::generated_pool()->FindFileByName("TurnoutState.proto");
        GOOGLE_CHECK(file != NULL);
        TurnoutState_descriptor_ = file->message_type(0);
        static const int TurnoutState_offsets_[2] = {
            GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutState, turnoutid_),
            GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutState, state_),
        };
        TurnoutState_reflection_ =
            ::google::protobuf::internal::GeneratedMessageReflection::NewGeneratedMessageReflection(
                TurnoutState_descriptor_, TurnoutState::default_instance_, TurnoutState_offsets_, -1, -1, -1,
                sizeof(TurnoutState), GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutState, _internal_metadata_),
                GOOGLE_PROTOBUF_GENERATED_MESSAGE_FIELD_OFFSET(TurnoutState, _is_default_instance_));
    }

    namespace
    {

        GOOGLE_PROTOBUF_DECLARE_ONCE(protobuf_AssignDescriptors_once_);
        inline void protobuf_AssignDescriptorsOnce()
        {
            ::google::protobuf::GoogleOnceInit(
                &protobuf_AssignDescriptors_once_, &protobuf_AssignDesc_TurnoutState_2eproto);
        }

        void protobuf_RegisterTypes(const ::std::string&)
        {
            protobuf_AssignDescriptorsOnce();
            ::google::protobuf::MessageFactory::InternalRegisterGeneratedMessage(
                TurnoutState_descriptor_, &TurnoutState::default_instance());
        }

    } // namespace

    void protobuf_ShutdownFile_TurnoutState_2eproto()
    {
        delete TurnoutState::default_instance_;
        delete TurnoutState_reflection_;
    }

    void protobuf_AddDesc_TurnoutState_2eproto()
    {
        static bool already_here = false;
        if(already_here)
            return;
        already_here = true;
        GOOGLE_PROTOBUF_VERIFY_VERSION;

        ::modes3::protobuf::protobuf_AddDesc_Enums_2eproto();
        ::google::protobuf::DescriptorPool::InternalAddGeneratedFile(
            "\n\022TurnoutState.proto\022\017modes3.protobuf\032\013E"
            "nums.proto\"T\n\014TurnoutState\022\021\n\tturnoutID\030"
            "\001 \001(\r\0221\n\005state\030\002 \001(\0162\".modes3.protobuf.T"
            "urnoutStateValueB0\n,hu.bme.mit.inf.modes"
            "3.messaging.mms.messagesP\001b\006proto3",
            194);
        ::google::protobuf::MessageFactory::InternalRegisterGeneratedFile(
            "TurnoutState.proto", &protobuf_RegisterTypes);
        TurnoutState::default_instance_ = new TurnoutState();
        TurnoutState::default_instance_->InitAsDefaultInstance();
        ::google::protobuf::internal::OnShutdown(&protobuf_ShutdownFile_TurnoutState_2eproto);
    }

    // Force AddDescriptors() to be called at static initialization time.
    struct StaticDescriptorInitializer_TurnoutState_2eproto {
        StaticDescriptorInitializer_TurnoutState_2eproto()
        {
            protobuf_AddDesc_TurnoutState_2eproto();
        }
    } static_descriptor_initializer_TurnoutState_2eproto_;

    namespace
    {

        static void MergeFromFail(int line) GOOGLE_ATTRIBUTE_COLD;
        static void MergeFromFail(int line)
        {
            GOOGLE_CHECK(false) << __FILE__ << ":" << line;
        }

    } // namespace

// ===================================================================

#if !defined(_MSC_VER) || _MSC_VER >= 1900
    const int TurnoutState::kTurnoutIDFieldNumber;
    const int TurnoutState::kStateFieldNumber;
#endif // !defined(_MSC_VER) || _MSC_VER >= 1900

    TurnoutState::TurnoutState()
        : ::google::protobuf::Message()
        , _internal_metadata_(NULL)
    {
        SharedCtor();
        // @@protoc_insertion_point(constructor:modes3.protobuf.TurnoutState)
    }

    void TurnoutState::InitAsDefaultInstance()
    {
        _is_default_instance_ = true;
    }

    TurnoutState::TurnoutState(const TurnoutState& from)
        : ::google::protobuf::Message()
        , _internal_metadata_(NULL)
    {
        SharedCtor();
        MergeFrom(from);
        // @@protoc_insertion_point(copy_constructor:modes3.protobuf.TurnoutState)
    }

    void TurnoutState::SharedCtor()
    {
        _is_default_instance_ = false;
        _cached_size_ = 0;
        turnoutid_ = 0u;
        state_ = 0;
    }

    TurnoutState::~TurnoutState()
    {
        // @@protoc_insertion_point(destructor:modes3.protobuf.TurnoutState)
        SharedDtor();
    }

    void TurnoutState::SharedDtor()
    {
        if(this != default_instance_) {
        }
    }

    void TurnoutState::SetCachedSize(int size) const
    {
        GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
        _cached_size_ = size;
        GOOGLE_SAFE_CONCURRENT_WRITES_END();
    }
    const ::google::protobuf::Descriptor* TurnoutState::descriptor()
    {
        protobuf_AssignDescriptorsOnce();
        return TurnoutState_descriptor_;
    }

    const TurnoutState& TurnoutState::default_instance()
    {
        if(default_instance_ == NULL)
            protobuf_AddDesc_TurnoutState_2eproto();
        return *default_instance_;
    }

    TurnoutState* TurnoutState::default_instance_ = NULL;

    TurnoutState* TurnoutState::New(::google::protobuf::Arena* arena) const
    {
        TurnoutState* n = new TurnoutState;
        if(arena != NULL) {
            arena->Own(n);
        }
        return n;
    }

    void TurnoutState::Clear()
    {
// @@protoc_insertion_point(message_clear_start:modes3.protobuf.TurnoutState)
#if defined(__clang__)
#define ZR_HELPER_(f)                                                                                               \
    _Pragma("clang diagnostic push") _Pragma("clang diagnostic ignored \"-Winvalid-offsetof\"") __builtin_offsetof( \
        TurnoutState, f) _Pragma("clang diagnostic pop")
#else
#define ZR_HELPER_(f) reinterpret_cast<char*>(&reinterpret_cast<TurnoutState*>(16)->f)
#endif

#define ZR_(first, last)                                                          \
    do {                                                                          \
        ::memset(&first, 0, ZR_HELPER_(last) - ZR_HELPER_(first) + sizeof(last)); \
    } while(0)

        ZR_(turnoutid_, state_);

#undef ZR_HELPER_
#undef ZR_
    }

    bool TurnoutState::MergePartialFromCodedStream(::google::protobuf::io::CodedInputStream* input)
    {
#define DO_(EXPRESSION)                  \
    if(!GOOGLE_PREDICT_TRUE(EXPRESSION)) \
    goto failure
        ::google::protobuf::uint32 tag;
        // @@protoc_insertion_point(parse_start:modes3.protobuf.TurnoutState)
        for(;;) {
            ::std::pair< ::google::protobuf::uint32, bool> p = input->ReadTagWithCutoff(127);
            tag = p.first;
            if(!p.second)
                goto handle_unusual;
            switch(::google::protobuf::internal::WireFormatLite::GetTagFieldNumber(tag)) {
            // optional uint32 turnoutID = 1;
            case 1: {
                if(tag == 8) {
                    DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive< ::google::protobuf::uint32,
                        ::google::protobuf::internal::WireFormatLite::TYPE_UINT32>(input, &turnoutid_)));

                } else {
                    goto handle_unusual;
                }
                if(input->ExpectTag(16))
                    goto parse_state;
                break;
            }

            // optional .modes3.protobuf.TurnoutStateValue state = 2;
            case 2: {
                if(tag == 16) {
                parse_state:
                    int value;
                    DO_((::google::protobuf::internal::WireFormatLite::ReadPrimitive<int,
                        ::google::protobuf::internal::WireFormatLite::TYPE_ENUM>(input, &value)));
                    set_state(static_cast< ::modes3::protobuf::TurnoutStateValue>(value));
                } else {
                    goto handle_unusual;
                }
                if(input->ExpectAtEnd())
                    goto success;
                break;
            }

            default: {
            handle_unusual:
                if(tag == 0 ||
                    ::google::protobuf::internal::WireFormatLite::GetTagWireType(tag) ==
                        ::google::protobuf::internal::WireFormatLite::WIRETYPE_END_GROUP) {
                    goto success;
                }
                DO_(::google::protobuf::internal::WireFormatLite::SkipField(input, tag));
                break;
            }
            }
        }
    success:
        // @@protoc_insertion_point(parse_success:modes3.protobuf.TurnoutState)
        return true;
    failure:
        // @@protoc_insertion_point(parse_failure:modes3.protobuf.TurnoutState)
        return false;
#undef DO_
    }

    void TurnoutState::SerializeWithCachedSizes(::google::protobuf::io::CodedOutputStream* output) const
    {
        // @@protoc_insertion_point(serialize_start:modes3.protobuf.TurnoutState)
        // optional uint32 turnoutID = 1;
        if(this->turnoutid() != 0) {
            ::google::protobuf::internal::WireFormatLite::WriteUInt32(1, this->turnoutid(), output);
        }

        // optional .modes3.protobuf.TurnoutStateValue state = 2;
        if(this->state() != 0) {
            ::google::protobuf::internal::WireFormatLite::WriteEnum(2, this->state(), output);
        }

        // @@protoc_insertion_point(serialize_end:modes3.protobuf.TurnoutState)
    }

    ::google::protobuf::uint8* TurnoutState::InternalSerializeWithCachedSizesToArray(bool deterministic,
        ::google::protobuf::uint8* target) const
    {
        // @@protoc_insertion_point(serialize_to_array_start:modes3.protobuf.TurnoutState)
        // optional uint32 turnoutID = 1;
        if(this->turnoutid() != 0) {
            target = ::google::protobuf::internal::WireFormatLite::WriteUInt32ToArray(1, this->turnoutid(), target);
        }

        // optional .modes3.protobuf.TurnoutStateValue state = 2;
        if(this->state() != 0) {
            target = ::google::protobuf::internal::WireFormatLite::WriteEnumToArray(2, this->state(), target);
        }

        // @@protoc_insertion_point(serialize_to_array_end:modes3.protobuf.TurnoutState)
        return target;
    }

    int TurnoutState::ByteSize() const
    {
        // @@protoc_insertion_point(message_byte_size_start:modes3.protobuf.TurnoutState)
        int total_size = 0;

        // optional uint32 turnoutID = 1;
        if(this->turnoutid() != 0) {
            total_size += 1 + ::google::protobuf::internal::WireFormatLite::UInt32Size(this->turnoutid());
        }

        // optional .modes3.protobuf.TurnoutStateValue state = 2;
        if(this->state() != 0) {
            total_size += 1 + ::google::protobuf::internal::WireFormatLite::EnumSize(this->state());
        }

        GOOGLE_SAFE_CONCURRENT_WRITES_BEGIN();
        _cached_size_ = total_size;
        GOOGLE_SAFE_CONCURRENT_WRITES_END();
        return total_size;
    }

    void TurnoutState::MergeFrom(const ::google::protobuf::Message& from)
    {
        // @@protoc_insertion_point(generalized_merge_from_start:modes3.protobuf.TurnoutState)
        if(GOOGLE_PREDICT_FALSE(&from == this))
            MergeFromFail(__LINE__);
        const TurnoutState* source = ::google::protobuf::internal::DynamicCastToGenerated<const TurnoutState>(&from);
        if(source == NULL) {
            // @@protoc_insertion_point(generalized_merge_from_cast_fail:modes3.protobuf.TurnoutState)
            ::google::protobuf::internal::ReflectionOps::Merge(from, this);
        } else {
            // @@protoc_insertion_point(generalized_merge_from_cast_success:modes3.protobuf.TurnoutState)
            MergeFrom(*source);
        }
    }

    void TurnoutState::MergeFrom(const TurnoutState& from)
    {
        // @@protoc_insertion_point(class_specific_merge_from_start:modes3.protobuf.TurnoutState)
        if(GOOGLE_PREDICT_FALSE(&from == this))
            MergeFromFail(__LINE__);
        if(from.turnoutid() != 0) {
            set_turnoutid(from.turnoutid());
        }
        if(from.state() != 0) {
            set_state(from.state());
        }
    }

    void TurnoutState::CopyFrom(const ::google::protobuf::Message& from)
    {
        // @@protoc_insertion_point(generalized_copy_from_start:modes3.protobuf.TurnoutState)
        if(&from == this)
            return;
        Clear();
        MergeFrom(from);
    }

    void TurnoutState::CopyFrom(const TurnoutState& from)
    {
        // @@protoc_insertion_point(class_specific_copy_from_start:modes3.protobuf.TurnoutState)
        if(&from == this)
            return;
        Clear();
        MergeFrom(from);
    }

    bool TurnoutState::IsInitialized() const
    {

        return true;
    }

    void TurnoutState::Swap(TurnoutState* other)
    {
        if(other == this)
            return;
        InternalSwap(other);
    }
    void TurnoutState::InternalSwap(TurnoutState* other)
    {
        std::swap(turnoutid_, other->turnoutid_);
        std::swap(state_, other->state_);
        _internal_metadata_.Swap(&other->_internal_metadata_);
        std::swap(_cached_size_, other->_cached_size_);
    }

    ::google::protobuf::Metadata TurnoutState::GetMetadata() const
    {
        protobuf_AssignDescriptorsOnce();
        ::google::protobuf::Metadata metadata;
        metadata.descriptor = TurnoutState_descriptor_;
        metadata.reflection = TurnoutState_reflection_;
        return metadata;
    }

#if PROTOBUF_INLINE_NOT_IN_HEADERS
    // TurnoutState

    // optional uint32 turnoutID = 1;
    void TurnoutState::clear_turnoutid()
    {
        turnoutid_ = 0u;
    }
    ::google::protobuf::uint32 TurnoutState::turnoutid() const
    {
        // @@protoc_insertion_point(field_get:modes3.protobuf.TurnoutState.turnoutID)
        return turnoutid_;
    }
    void TurnoutState::set_turnoutid(::google::protobuf::uint32 value)
    {

        turnoutid_ = value;
        // @@protoc_insertion_point(field_set:modes3.protobuf.TurnoutState.turnoutID)
    }

    // optional .modes3.protobuf.TurnoutStateValue state = 2;
    void TurnoutState::clear_state()
    {
        state_ = 0;
    }
    ::modes3::protobuf::TurnoutStateValue TurnoutState::state() const
    {
        // @@protoc_insertion_point(field_get:modes3.protobuf.TurnoutState.state)
        return static_cast< ::modes3::protobuf::TurnoutStateValue>(state_);
    }
    void TurnoutState::set_state(::modes3::protobuf::TurnoutStateValue value)
    {

        state_ = value;
        // @@protoc_insertion_point(field_set:modes3.protobuf.TurnoutState.state)
    }

#endif // PROTOBUF_INLINE_NOT_IN_HEADERS

    // @@protoc_insertion_point(namespace_scope)

} // namespace protobuf
} // namespace modes3

// @@protoc_insertion_point(global_scope)
