/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

package org.op4j.target;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.op4j.target.Target.CastType;
import org.op4j.util.NormalisationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetCastOperation implements ExecutionTargetOperation {

    private final CastType targetType;
    private final Type<?>[] types;

    
    
    public ExecutionTargetCastOperation(final CastType targetType, final Type<?>... types) {
        super();
        this.targetType = targetType;
        this.types = types;
    }
    
    
    
    @SuppressWarnings("unchecked")
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final Integer index) {
        
        Object result = target;
        
        switch (this.targetType) {
        
            case OBJECT: 
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIs(this.types[0], result);
                break;
                
            case ARRAY:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsArray(this.types[0], result);
                result = NormalisationUtils.normaliseArray((Object[])result, this.types[0].getRawClass());
                break;
                
            case LIST:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsList(this.types[0], result);
                result = NormalisationUtils.normaliseList((List<Object>)result);
                break;
                
            case MAP:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMap((Map<Object,Object>)result);
                break;
                
            case SET:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsSet(this.types[0], result);
                result = NormalisationUtils.normaliseSet((Set<Object>)result);
                break;
                
        }

        return result;
        
    }
    
}
