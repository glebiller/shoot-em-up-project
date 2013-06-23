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

#pragma once

#include "Proto/Common.pb.h"
#include "Defines.h"
#include "Logger.h"


#if defined( MSC_COMPILER )
#include <intrin.h>
#pragma intrinsic(_BitScanForward)
#endif


class ISystem;
class IPlatformManager;
class IEnvironmentManager;
class IServiceManager;
class ITaskManager;


/**
 * The System namespace contains meta-data about the various sytems,
 * and various enums, datatypes and helper functions for system types.
 */
namespace System {

    /**
     * The Types namespace contains specifics about the system types.
     */
    namespace Types {
        static const u32 All = static_cast<u32>(-1);
        static const u32 MAX = 32;

        /**
         * Get the index of the system with the given type ID.  Useful for looking up indexed properties.
         * This function works on both predefined and custom system type IDs.
         *
         * @param   SystemType  Type - The type ID of a system.
         * @return  u32 - Index of this system.
         */
        __forceinline u32 GetIndex(const Proto::SystemType systemType) {
            u32 Index = All;
#if defined( MSC_COMPILER )
            _BitScanForward((unsigned long*)&Index, systemType);
#elif defined( GCC_COMPILER )
            Index = __builtin_ffs(systemType);
#endif
            return Index;
        };

        /**
         * Gets a type from an index.
         *
         * @param   SystemType  Type of the system.
         * @return  The type.
         */
        __forceinline Proto::SystemType GetType(const u32 index) {
            return (Proto::SystemType) (1 << index);
        }

        typedef u32 BitMask;
    }
}

/**
 * Function type definitions for communicating with the system DLL.
 */
extern "C" {
    /**
     * The list of managers interfaces.
     */
    struct ManagerInterfaces {
        IPlatformManager*       pPlatform;
        IEnvironmentManager*    pEnvironment;
        IServiceManager*        pService;
        ITaskManager*           pTask;
    };

#if defined( MSC_COMPILER )

    /**
     * Function definition for calling into a system library for initializing a system.
     */
    typedef void (__stdcall* InitializeSystemLibFunction)(
        ManagerInterfaces* pManagers
    );

    /**
     * Function definition for calling into a system library for creating a system.
     * 
     * @return   The newly created system.
     */
    typedef ISystem* (__stdcall* CreateSystemFunction)(
        Log::Logger* p_logger
    );

    /**
     * Function definition for calling into a system library for destroying a system.
     * 
     * @param    pSystem The system to destroy.
     */
    typedef void (__stdcall* DestroySystemFunction)(
        ISystem* pSystem
    );

#elif defined( GCC_COMPILER )
    /**
     * Function definition for calling into a system library for initializing a system.
     */
    void __attribute__((__stdcall)) InitializeSystemLibFunction(
        ManagerInterfaces* pManagers
    );

    /**
     * Function definition for calling into a system library for creating a system.
     * 
     * @return   The newly created system.
     */
    ISystem* __attribute__((__stdcall)) CreateSystemFunction(
        Log::Logger* p_logger
    );

    /**
     * Function definition for calling into a system library for destroying a system.
     * 
     * @param    pSystem The system to destroy.
     */
    void __attribute__((__stdcall)) DestroySystemFunction(
        ISystem* pSystem
    );    
#endif

}
