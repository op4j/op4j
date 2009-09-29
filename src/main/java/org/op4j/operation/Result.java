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
package org.op4j.operation;

import org.apache.commons.lang.Validate;
import org.op4j.type.Type;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Result {

    private static final long serialVersionUID = -7047131254509263235L;

    private final Type type;
    private final Object resultObject;

    
    
    Result(final Type type, final Object resultObject) {
        
        super();
        Validate.notNull(type, "Cannot create Result with null type");
        this.type = type;
        this.resultObject = resultObject;
        
    }



    public Type getType() {
        return this.type;
    }

    public Object getResultObject() {
        return this.resultObject;
    }
    
}
