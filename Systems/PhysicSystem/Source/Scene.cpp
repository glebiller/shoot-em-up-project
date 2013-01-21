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

#include <boost/functional/factory.hpp>

#include "BaseTypes.h"
#include "Interface.h"

#include "Collision.h"
#include "System.h"
#include "Scene.h"
#include "Task.h"
#include "Object/Object.h"

//
// global variables
//
extern ManagerInterfaces    g_Managers;

///////////////////////////////////////////////////////////////////////////////
// HavokPhysicsScene - Default constructor
PhysicScene::PhysicScene(ISystem* pSystem): ISystemScene(pSystem) {
    m_TaskFactory = boost::factory<PhysicTask*>();
}

///////////////////////////////////////////////////////////////////////////////
// ~HavokPhysicsScene - Default destructor
PhysicScene::~PhysicScene(void) {
    
}

///////////////////////////////////////////////////////////////////////////////
// Initialize - Initializes this Scene with the given properties
Error PhysicScene::initialize(void) {
    ASSERT(!m_bInitialized);

    return Errors::Success;
}

/**
 * @inheritDoc
 */
void PhysicScene::Update(f32 DeltaTime) {
    ObjectsList Objects = m_pObjects;

    //
    // Cycle through all of our objects and apply the changes.
    // Also post our change notifications to the CCM.
    //
    for (ObjectsList::iterator it = Objects.begin(); it != Objects.end(); it++) {
        PhysicObject* pObject = static_cast<PhysicObject*>(*it);
        pObject->Update(DeltaTime);
    }
}
