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

import org.apache.commons.lang.Validate;
import org.op4j.operation.Target;


/**
 * 
 * <p>
 * This is the central and basic factory class for {@link ObjectScheme} objects. Every
 * <tt>ObjectScheme</tt> object should be exclusively obtained by means of this 
 * class's methods.
 * </p>
 * <p>
 * <b>This class should never be used directly.</b> 
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ObjectSchemes {

    
    /**
     * <p>
     * Creates ObjectScheme from {@link Target} objects.
     * </p>
     * 
     * @param targets the targets
     * @return the ObjectScheme
     */
    public static ObjectScheme forTargets(final Target<?>[] targets) {
        Validate.notNull(targets, "Targets array cannot be null");
        return ObjectSchemeUtil.forTargets(targets);
    }

    
    /**
     * <p>
     * Creates ObjectScheme from {@link Target} objects.
     * </p>
     * 
     * @param parameters the parameters
     * @return the ObjectScheme
     */
    public static ObjectScheme forParameters(final Object[] parameters) {
        Validate.notNull(parameters, "Parameters array cannot be null");
        return ObjectSchemeUtil.forParameters(parameters);
    }
    
    private ObjectSchemes() {
        super();
    }
    
}
