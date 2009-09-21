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
package org.op4j.util;

import org.op4j.operation.CastParam;
import org.op4j.type.Type;
import org.op4j.type.Types;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class CastUtils {

    
    public static void unsafeCheckCastable(final Type type, final Object object) {

        final Type rawType = Types.getRawTypeForType(type);
        final Type objRawType = Types.getRawTypeForObject(object);

        if (!rawType.isAssignableFrom(objRawType)) {
            // This object can only be typed to the specified type if this type's raw type
            // is assignable from the object's raw type.
            throw new IllegalArgumentException("Cannot cast object of type " +
                    objRawType + " to type " + type);
        }
        
    }


    public static Object[] unsafeExtractPossiblyCastedObjects(final Object[] objects) {
        
        final Object[] extractedObjects = new Object[objects.length];
        
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                extractedObjects[i] = null;
            } else {
                if (objects[i] instanceof CastParam) {
                    extractedObjects[i] = ((CastParam)objects[i]).getObject();
                } else {
                    extractedObjects[i] = objects[i];
                }
            }
        }
        
        return extractedObjects;

    }
    
    
    private CastUtils() {
        super();
    }
    
}
