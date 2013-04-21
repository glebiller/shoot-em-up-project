// Copyright � 2008-2009 Intel Corporation
// All Rights Reserved
//
// Permission is granted to use, copy, distribute and prepare derivative works of this
// software for any purpose and without fee, provided, that the above copyright notice
// and this statement appear in all copies.  Intel makes no representations about the
// suitability of this software for any purpose.  THIS SOFTWARE IS PROVIDED "AS IS."
// INTEL SPECIFICALLY DISCLAIMS ALL WARRANTIES, EXPRESS OR IMPLIED, AND ALL LIABILITY,
// INCLUDING CONSEQUENTIAL AND OTHER INDIRECT DAMAGES, FOR THE USE OF THIS SOFTWARE,
// INCLUDING LIABILITY FOR INFRINGEMENT OF ANY PROPRIETARY RIGHTS, AND INCLUDING THE
// WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE.  Intel does not
// assume any responsibility for any errors which may appear in this software nor any
// responsibility to update it.

#include <google/protobuf/io/coded_stream.h>

#include "Proto/Server/UpstreamMessage.pb.h"
#include "Proto/Server/DownstreamMessage.pb.h"

#include "BaseTypes.h"
#include "Interface.h"

#include "Task.h"
#include "Scene.h"
#include "Object/Object.h"

/**
 * @inheritDoc
 */
NetworkTask::NetworkTask(ISystemScene* pScene) : ISystemTask(pScene) {

}

/**
 * @inheritDoc
 */
NetworkTask::~NetworkTask(void) {

}

/**
 * @inheritDoc
 */
void NetworkTask::Update(f32 DeltaTime) {
    static_cast<NetworkSystem*>(GetSystemScene()->GetSystem())->getIoService()->poll();

    while (!m_pUpstreamMessageList.empty()) {
        receive(m_pUpstreamMessageList.front());
        m_pUpstreamMessageList.pop_front();
    }

    m_pSystemScene->Update(DeltaTime);

    while (!m_pDownstreamMessageList.empty()) {
        send(m_pDownstreamMessageList.front());
        m_pDownstreamMessageList.pop_front();
    }
}

/**
 * @inheritDoc
 */
void NetworkTask::queueMessage(const DownstreamMessageProto* downstreamMessageProto) {
    m_pDownstreamMessageList.push_back(downstreamMessageProto);
}

/**
 * @inheritDoc
 */
void NetworkTask::send(const DownstreamMessageProto* downstreamMessageProto) {
    boost::asio::ip::tcp::socket* socket = static_cast<NetworkSystem*>(GetSystemScene()->GetSystem())->getSocket();

    int serializedSize = downstreamMessageProto->ByteSize();
    size_t totalOutputSize = google::protobuf::io::CodedOutputStream::VarintSize32(serializedSize) + serializedSize;

    std::vector<char> writeBuffer = std::vector<char>(totalOutputSize);
    google::protobuf::uint8* offset = (google::protobuf::uint8*) &writeBuffer[0];
    offset = google::protobuf::io::CodedOutputStream::WriteVarint32ToArray(serializedSize, offset);
    ASSERT(((char *) offset - (char *) &writeBuffer[0]) == google::protobuf::io::CodedOutputStream::VarintSize32(serializedSize));

    downstreamMessageProto->SerializeToArray((void *)offset, serializedSize);
    boost::asio::write(*socket, boost::asio::buffer(writeBuffer));
    delete downstreamMessageProto;
}

void NetworkTask::receive(const UpstreamMessageProto* upstreamMessageProto) {

}