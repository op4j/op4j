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
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final int[] indexes) {
        
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
                
            case ARRAY_OF_ARRAY:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsArrayOfArray(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfArray((Object[][])result, this.types[0].getRawClass());
                break;
                
            case ARRAY_OF_LIST:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsArrayOfList(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfList((List<Object>[])result);
                break;
                
            case ARRAY_OF_MAP:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsArrayOfMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseArrayOfMap((Map<Object,Object>[])result);
                break;
                
            case ARRAY_OF_SET:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsArrayOfSet(this.types[0], result);
                result = NormalisationUtils.normaliseArrayOfSet((Set<Object>[])result);
                break;
                
            case LIST_OF_ARRAY:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsListOfArray(this.types[0], result);
                result = NormalisationUtils.normaliseListOfArray((List<Object[]>)result, this.types[0].getRawClass());
                break;
                
            case LIST_OF_LIST:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsListOfList(this.types[0], result);
                result = NormalisationUtils.normaliseListOfList((List<List<Object>>)result);
                break;
                
            case LIST_OF_MAP:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsListOfMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseListOfMap((List<Map<Object,Object>>)result);
                break;
                
            case LIST_OF_SET:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsListOfSet(this.types[0], result);
                result = NormalisationUtils.normaliseListOfSet((List<Set<Object>>)result);
                break;
                
            case MAP_OF_ARRAY:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsMapOfArray(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfArray((Map<Object,Object[]>)result, this.types[0].getRawClass());
                break;
                
            case MAP_OF_LIST:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsMapOfList(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfList((Map<Object,List<Object>>)result);
                break;
                
            case MAP_OF_MAP:
                Validate.notNull(this.types[0], "Specified first-level map key type cannot be null");
                Validate.notNull(this.types[0], "Specified second-level map key type cannot be null");
                Validate.notNull(this.types[1], "Specified second-level map value type cannot be null");
                NormalisationUtils.checkIsMapOfMap(this.types[0], this.types[1], this.types[2], result);
                result = NormalisationUtils.normaliseMapOfMap((Map<Object,Map<Object,Object>>)result);
                break;
                
            case MAP_OF_SET:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsMapOfSet(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseMapOfSet((Map<Object,Set<Object>>)result);
                break;
                
            case SET_OF_ARRAY:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsSetOfArray(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfArray((Set<Object[]>)result, this.types[0].getRawClass());
                break;
                
            case SET_OF_LIST:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsSetOfList(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfList((Set<List<Object>>)result);
                break;
                
            case SET_OF_MAP:
                Validate.notNull(this.types[0], "Specified key type cannot be null");
                Validate.notNull(this.types[1], "Specified value type cannot be null");
                NormalisationUtils.checkIsSetOfMap(this.types[0], this.types[1], result);
                result = NormalisationUtils.normaliseSetOfMap((Set<Map<Object,Object>>)result);
                break;
                
            case SET_OF_SET:
                Validate.notNull(this.types[0], "Specified type cannot be null");
                NormalisationUtils.checkIsSetOfSet(this.types[0], result);
                result = NormalisationUtils.normaliseSetOfSet((Set<Set<Object>>)result);
                break;
                
        }

        return result;
        
    }
    
}
