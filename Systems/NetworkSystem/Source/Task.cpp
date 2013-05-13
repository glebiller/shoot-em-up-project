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
    static_cast<NetworkScene*>(GetSystemScene())->resetObjectQueues();
    static_cast<NetworkSystem*>(GetSystemScene()->GetSystem())->getNetworkService()->receive();
    m_pSystemScene->Update(DeltaTime);
}