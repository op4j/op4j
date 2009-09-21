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
package org.op4j.objectscheme;

import org.op4j.operation.CastParam;
import org.op4j.operation.Target;
import org.op4j.type.Types;

/*
 * (non-javadoc)
 * 
 * This class contains internal algorithms for ObjectScheme processing and
 * handling.
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ObjectSchemeUtil {


    static ObjectScheme forTargets(final Target<?>[] targets) {

        final ObjectSchemeComponent[] objectSchemeComponents = 
            new ObjectSchemeComponent[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            if (targets[i] == null) {
                objectSchemeComponents[i] = null;
            } else {
                objectSchemeComponents[i] = 
                    new ObjectSchemeComponent(
                            targets[i].getIntendedType(), targets[i].getObject());
            }
        }
        
        return new ObjectScheme(objectSchemeComponents);

    }
    
    
    static ObjectScheme forParameters(final Object[] parameters) {
        
        final ObjectSchemeComponent[] objectSchemeComponents = 
            new ObjectSchemeComponent[parameters.length];
        
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i] == null) {
                objectSchemeComponents[i] = null;
            } else {
                if (parameters[i] instanceof CastParam) {
                    objectSchemeComponents[i] =
                        new ObjectSchemeComponent(
                                ((CastParam)parameters[i]).getType(),((CastParam)parameters[i]).getObject());
                } else {
                    objectSchemeComponents[i] =
                        new ObjectSchemeComponent(
                                Types.getRawTypeForObject(parameters[i]),parameters[i]);
                }
            }
        }
        
        return new ObjectScheme(objectSchemeComponents);

    }

    
    static String createComponentStringRepresentation(
            final ObjectSchemeComponent objectSchemeComponent) {
        return objectSchemeComponent.getType().getName();
    }

    
    static String createStringRepresentation(
            final ObjectSchemeComponent[] objectSchemeComponents) {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(ObjectSchemeNaming.TYPE_SCHEME_NAME_START_SYMBOL);
        for (int i = 0; i < objectSchemeComponents.length; i++) {
            if (i > 0) {
                strBuilder.append(ObjectSchemeNaming.TYPE_SCHEME_NAME_SEPARATOR_SYMBOL);
            }
            if (objectSchemeComponents[i] == null) {
                strBuilder.append(ObjectSchemeNaming.TYPE_SCHEME_NAME_NULL_COMPONENT); 
            } else {
                strBuilder.append(objectSchemeComponents[i].getStringRepresentation()); 
            }
        }
        strBuilder.append(ObjectSchemeNaming.TYPE_SCHEME_NAME_END_SYMBOL);
        return strBuilder.toString();
    }
    
    
    private ObjectSchemeUtil() {
        super();
    }
    
}
