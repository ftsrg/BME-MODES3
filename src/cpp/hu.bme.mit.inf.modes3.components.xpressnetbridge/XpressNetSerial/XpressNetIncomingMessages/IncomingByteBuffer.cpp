/**
 * Created by Attila Biró
 * GitHub account: Chorithian
**/
#include "IncomingByteBuffer.h"

IncomingByteBuffer::IncomingByteBuffer()
{
    expectedMessages.emplace_back(new AccessoryDecoderInformationResponse());
    expectedMessages.emplace_back(new TrackPowerStatusMessage());
    expectedMessages.emplace_back(new LocomotiveInformation());
    expectedMessages.emplace_back(new LocomotiveNotAvailable());
    expectedMessages.emplace_back(new LocomotiveControlTaken());
    expectedMessages.emplace_back(new AccessoryDecoderInformationResponse_LNN());
}

void IncomingByteBuffer::addByte(uint8_t byte)
{
    byteBuffer_Mutex.try_lock();
    byteBuffer.push_back(byte);
    ////std::cout << "Added byte " << std::hex << std::setfill ('0') << std::setw(2) << (unsigned int) byte <<
    /// std::endl;

    // For every added byte try to recognize a message.
    // The longest XpressNet message can only be 16 bytes long. If the buffer is longer than that
    // it means it contains unrecognized unnecessary bytes. Delete it.
    if(byteBuffer.size() > maxMessageLength) {
        deleteFromByteBuffer((byteBuffer.size() - maxMessageLength) - 1);
    }
    recognizeMessages();
    byteBuffer_Mutex.unlock();
}

/*
 * Searches for recognizable messages in the buffer.
 * Deletes the successfully processed bytes from the buffer.
 */
void IncomingByteBuffer::recognizeMessages()
{
    /*std::cout << "recognizeMessages() Buffer: ";
    for(auto& byte : byteBuffer) {
        std::cout << std::hex << (unsigned int) byte << " ";
    }
    std::cout << std::endl;*/
    unsigned int lastRecognizedMessagePosition = 0;
    bool rightMessage = true;
    // If the buffer is too small, do nothing.
    if(byteBuffer.size() < 3) {
        // std::cout << "Too short buffer " << byteBuffer.size() <<std::endl;
    }
    // Else ...
    else {
        // ... for every byte in the buffer ...
        for(unsigned int i = 0; i < byteBuffer.size() - 2; i++) {
            // std::cout << "i=" << std::hex << (unsigned int) i << std::endl;
            // ... for every recognizable message check ...
            for(auto& expectedMessage : expectedMessages) {
                // ... if the buffer is long enough for storing this message.
                if(expectedMessage->getMessageLength() > byteBuffer.size() - i) {
                    // If not, then continue cycling through the expected message list.
                    // std::cout << expectedMessage->getMessageLength() << " is too long" << std::endl;
                }
                // If it is, then check the first bytes of each for matching.
                else {
                    rightMessage = true;
                    unsigned int k;
                    for(k = 0; (k < expectedMessage->getFirstBytes().size()) && (rightMessage == true); k++) {
                        if(byteBuffer[i + k] != expectedMessage->getFirstBytes()[k]) {
                            rightMessage = false;
                        }
                    }
                    // Gandalf decides who shall or shall not pass
                    bool gandalf;
                    // Calculate XOR if not special. If the last byte is the XOR result of the bytes before it ...
                    if(expectedMessage->isItSpecial() == false) {
                        uint8_t xorResult = 0;
                        unsigned int m;
                        for(m = 0; m < expectedMessage->getMessageLength() - 1; m++) {
                            xorResult = xorResult ^ byteBuffer[i + m];
                        }
                        gandalf = (xorResult == byteBuffer[i + m]);
                    }
                    // ... or just if it is a special one ...
                    else {
                        gandalf = true;
                    }
                    // ... and if all the first bytes match ...
                    if((rightMessage == true) && (k == expectedMessage->getFirstBytes().size()) && (gandalf == true)) {
                        /*KIÍRÁS std::cout << "Received good header" << std::endl;
                        std::cout << "Length: "<<expectedMessage->getMessageLength()<<" Bytes: ";*/

                        std::vector<uint8_t> messageBuffer;
                        // ... put them into a buffer ...
                        for(unsigned int l = 0; (l < (expectedMessage->getMessageLength())); l++) {
                            messageBuffer.push_back(byteBuffer[i + l]);
                            /*KIÍRÁS std::cout << std::hex << (unsigned int) byteBuffer[i+l] << " ";*/
                        }
                        // ... and pass it to the appropriate method for processing.
                        bool wasItValid = expectedMessage->recognizedMessage(messageBuffer);
                        // If it was a valid message, jump to the byte after this message.
                        if(wasItValid == true) {
                            // std::cout << "Jumping from " << std::hex << (unsigned int) i;
                            i += expectedMessage->getMessageLength() - 1;
                            lastRecognizedMessagePosition = i;
                            // std::cout << " to " << std::hex << (unsigned int) i << std::endl;
                        }
                    }
                }
            }
        }
        // When done recognizing, remove used bytes from the buffer.
        if(lastRecognizedMessagePosition > 0) {
            deleteFromByteBuffer(lastRecognizedMessagePosition + 1);
        }
    }
}

void IncomingByteBuffer::deleteFromByteBuffer(unsigned int i)
{
    byteBuffer.erase(byteBuffer.begin(), byteBuffer.begin() + i);
    // std::cout << "Cleaning buffer to " << std::hex << (unsigned int) i << std::endl;
}
