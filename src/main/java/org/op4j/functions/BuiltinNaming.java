/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */

package org.op4j.functions;

import org.javaruntype.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class BuiltinNaming {

	
	static final String OPERATION_NAME_DISTINCT = "distinct"; 
	static final String OPERATION_NAME_SORT = "sort"; 
    static final String OPERATION_NAME_MODIFY = "modify"; 
    static final String OPERATION_NAME_BUILD_ARRAY = "buildArray"; 
    static final String OPERATION_NAME_BUILD_LIST = "buildList"; 
    static final String OPERATION_NAME_BUILD_SET = "buildSet"; 
    static final String OPERATION_NAME_BUILD_MAP = "buildMap"; 
    static final String OPERATION_NAME_BUILD_MAP_OF_ARRAY = "buildMapOfArray"; 
    static final String OPERATION_NAME_BUILD_MAP_OF_LIST = "buildMapOfList"; 
    static final String OPERATION_NAME_BUILD_MAP_OF_SET = "buildMapOfSet"; 
    
    private static final String BUILTIN_FUNCTION_NAME_PREFIX = "op4j:builtin:";

    
    static String getBuiltinFunctionName(final Type<?> targetType, final String operationName) {
        return BUILTIN_FUNCTION_NAME_PREFIX + targetType.getName() + ":" + operationName;
    }
    
    
    private BuiltinNaming() {
        super();
    }
    
}
