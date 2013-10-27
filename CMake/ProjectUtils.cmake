macro(check_root_module)
    if(${CMAKE_PROJECT_NAME} STREQUAL ${PROJECT_NAME})
        message(FATAL_ERROR "Call CMake from the root directory")
    endif(${CMAKE_PROJECT_NAME} STREQUAL ${PROJECT_NAME})
endmacro()

macro(add_project_module moduleName)
    add_subdirectory(${moduleName})
    set_property(TARGET ${moduleName} PROPERTY FOLDER ${PROJECT_NAME})
endmacro()

macro(add_project_dependency dependencyName)
    list(APPEND "_${PROJECT_NAME}_INCLUDES" "${${dependencyName}_INCLUDES}")
    list(APPEND "_${PROJECT_NAME}_DEPENDENCIES" "${${dependencyName}_DEPENDENCIES}")
endmacro()

macro(add_project_sources sourceDirectory)
    list(APPEND "_${PROJECT_NAME}_INCLUDES" "${CMAKE_CURRENT_SOURCE_DIR}/${sourceDirectory}")
    list(APPEND "_${PROJECT_NAME}_DEPENDENCIES" "${PROJECT_NAME}")
    include_directories(${_${PROJECT_NAME}_INCLUDES})
    add_project_sources_internal(${sourceDirectory} "")
    set("${PROJECT_NAME}_INCLUDES" "${_${PROJECT_NAME}_INCLUDES}" CACHE INTERNAL "${PROJECT_NAME} includes")
    set("${PROJECT_NAME}_DEPENDENCIES" "${_${PROJECT_NAME}_DEPENDENCIES}" CACHE INTERNAL "${PROJECT_NAME} dependencies")
endmacro()

macro(add_project_sources_internal sourceDirectory folderName)
    file(GLOB "CURRENT_HEADERS" "${sourceDirectory}${folderName}/*.h")
    string(REPLACE "/" "\\\\" "DIR_SOURCE_GROUP" "Headers${folderName}")
    source_group(${DIR_SOURCE_GROUP} FILES ${CURRENT_HEADERS})
    list(APPEND "${PROJECT_NAME}_HEADERS" ${CURRENT_HEADERS})
    aux_source_directory("${sourceDirectory}${folderName}" "CURRENT_SOURCES")
    string(REPLACE "/" "\\\\" "DIR_SOURCE_GROUP" "Source${folderName}")
    source_group(${DIR_SOURCE_GROUP} FILES ${CURRENT_SOURCES})
    list(APPEND "${PROJECT_NAME}_SOURCES" ${CURRENT_SOURCES})

    file(GLOB "CURRENT_FILES" RELATIVE "${CMAKE_CURRENT_SOURCE_DIR}/${sourceDirectory}" "${sourceDirectory}/${folderName}/*")
    foreach("CURRENT_FILE" ${CURRENT_FILES})
        if(IS_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/${sourceDirectory}${CURRENT_FILE}")
            add_project_sources_internal(${sourceDirectory} ${CURRENT_FILE})
        endif(IS_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/${sourceDirectory}${CURRENT_FILE}")
    endforeach()
endmacro()