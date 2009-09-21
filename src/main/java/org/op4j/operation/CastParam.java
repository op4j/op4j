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
import org.op4j.type.Types;
import org.op4j.util.CastUtils;


/**
 * <p>
 * Objects of this class are meant to wrap operation parameters in order to
 * add type information which would be required to identify them as parameters
 * of the needed class. 
 * </p>
 * <p>
 * For example, if an operation needs a <tt>List&lt;String&gt;</tt> parameter and
 * we have a List&lt;String&gt; myStrList variable, as the type parameterization information 
 * will be lost in runtime, this parameter will be identified as a <tt>List&lt;?&gt;</tt>,
 * which will not match the required <tt>List&lt;String&gt;</tt>. For avoiding
 * this, we will use <tt>CastParam.to("List<String>", myStrList)</tt> instead.   
 * </p>
 * <p>
 * Objects of this class cannot be instantiated directly. The {@link #to(String, Object)}
 * and {@link #to(Type, Object)} factory methods should be used instead.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class CastParam {

    private final Type type;
    private final Object object;
    
    
    /**
     * <p>
     * Creates a new <tt>CastParam</tt> object adding type information to the
     * specified object. The <i>cast</i> type will be determined by the specified
     * type name.
     * </p>
     * 
     * @param typeName the name of the type to which the object will be cast
     * @param object the target object
     * @return a CastParam object containing both the object and cast information.
     */
    public final static CastParam to(final String typeName, final Object object) {
        Validate.notNull(typeName, "Type name cannot be null");
        return new CastParam(Types.forName(typeName), object);
    }
    
    
    /**
     * <p>
     * Creates a new <tt>CastParam</tt> object adding type information to the
     * specified object.
     * </p>
     * 
     * @param type the type to which the object will be cast
     * @param object the target object
     * @return a CastParam object containing both the object and cast information.
     */
    public final static CastParam to(final Type type, final Object object) {
        Validate.notNull(type, "Type cannot be null");
        return new CastParam(type, object);
    }

    
    private CastParam(final Type type, final Object object) {
        
        super();

        if (object != null) {
            // Will throw an exception if the object is not castable to the type
            CastUtils.unsafeCheckCastable(type, object);
        }
        
        this.type = type;
        this.object = object;
        
    }

    
    /**
     * <p>
     * Returns the type to which the enclosed object is being casted.
     * </p>
     * 
     * @return the type
     */
    public Type getType() {
        return this.type;
    }

    
    /**
     * <p>
     * The object being casted.
     * </p>
     * 
     * @return the object
     */
    public Object getObject() {
        return this.object;
    }
    
}
