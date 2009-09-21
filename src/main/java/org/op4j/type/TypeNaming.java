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
package org.op4j.type;

/* 
 * (non-javadoc)
 * 
 * Constant names.
 * 
 * @since 1.0
 * 
 * @author dfernandez
 *
 */
final class TypeNaming {

    static final String TYPE_PACKAGE_LANG = "java.lang.";
    static final String TYPE_PACKAGE_UTIL = "java.util.";
    static final String TYPE_PACKAGE_IO = "java.io.";

    static final String TYPE_NAME_PARAMETERS_START = "<";
    static final String TYPE_NAME_PARAMETERS_END = ">";
    static final String TYPE_NAME_PARAMETERS_SEPARATOR = ",";
    static final String TYPE_NAME_ARRAY = "[]";
    
    
    private TypeNaming() {
        super();
    }
    
}
