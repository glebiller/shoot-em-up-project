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

#include "Scene.h"
#include "Object.h"

#define POGREROOTNODE (reinterpret_cast<GraphicScene*>(m_pSystemScene)->getRootNode())

/**
 * @inheritDoc
 */
GraphicObject::GraphicObject(ISystemScene* pSystemScene, IEntity* entity) 
    : ISystemObject(pSystemScene, entity) {
    
}

/**
 * @inheritDoc
 */
GraphicObject::~GraphicObject(void) {
    if (m_bInitialized) {
        POGREROOTNODE->removeChild(m_pNode);
    }
}

/**
 * @inheritDoc
 */
Error GraphicObject::initialize(void) {
    ASSERT(!m_bInitialized);

    m_pNode = POGREROOTNODE->createChildSceneNode(m_entity->getName() + "_SceneNode");
    ASSERT(m_pNode != NULL);

    return Errors::Success;
}
