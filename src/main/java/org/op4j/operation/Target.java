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
import org.op4j.util.CastUtils;

/**
 * <p>
 * Base abstract class for target objects. A <tt>Target</tt> contains:
 * </p>
 * <ul>
 *   <li>An object (the target object).</li>
 *   <li>Its intended {@link Type}, which is the type to which
 *       the target object is currently "cast".</li>
 * </ul>
 * <p>
 * <b>This class should never be instantiated directly, nor used directly
 * outside the operation implementation classes</b>.
 * </p>
 * 
 * @author Daniel Fern&aacute;ndez
 *
 * @param <X> The known type of the enclosed target object. This type does not have to match
 *            the intended type of the target, but it must be assignable from the target object's class.
 */
public abstract class Target<X> {

    private final Type intendedType;
    private final X object;
    
    
    /**
     * <p>
     * Creates a new instance.
     * </p>
     * 
     * @param type the intended type for this object
     * @param object the target object
     */
    protected Target(final Type type, final X object) {
        
        super();
        Validate.notNull(type, "Type cannot be null");
        if (object instanceof CastParam) {
            throw new IllegalArgumentException(
                    "Cannot create a target from a " + CastParam.class.getSimpleName() +
                    " object. " + CastParam.class.getSimpleName() +" objects should " +
                    "only be used for operation execution parameters, not targets.");
        }
        if (object != null) {
            // Will throw an exception if the object is not castable to the type
            CastUtils.unsafeCheckCastable(type, object);
        }
        this.intendedType = type;
        this.object = object;
        
    }


    /**
     * <p>
     * Returns the target's intended type.
     * </p>
     * 
     * @return the intended type
     */
    public Type getIntendedType() {
        return this.intendedType;
    }


    /**
     * <p>
     * Returns the target object.
     * </p>
     * 
     * @return the target object
     */
    public X getObject() {
        return this.object;
    }
    
}
