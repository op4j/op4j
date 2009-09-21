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
package org.op4j.typedef;

import org.apache.commons.lang.Validate;

/**
 * <p>
 * This is the central and basic factory class for {@link TypeDef} objects. Every
 * <tt>TypeDef</tt> object should be exclusively obtained by means of this class's methods.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class TypeDefs {


    /**
     * <p>
     * Retrieves the <tt>TypeDef</tt> object corresponding with the given class.
     * </p>
     * 
     * @param typeClass the class which TypeDef must be obtained.
     * @return the TypeDef
     */
    public static TypeDef forClass(final Class<?> typeClass) {
        
        Validate.notNull(typeClass, "Class cannot be null");
        Validate.isTrue(!typeClass.isArray(), "Cannot obtain TypeDef from array class");
        
        final TypeDefRegistry typeDefRegistry = TypeDefRegistry.getInstance();
        return typeDefRegistry.forClass(typeClass);
        
    }
    
    
    private TypeDefs() {
        super();
    }
    
}
