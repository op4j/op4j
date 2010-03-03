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

import org.javaruntype.type.Types;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.IFunction;
import org.op4j.target.Target.Normalisation;
import org.op4j.util.NormalisationUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetExecuteOperation implements ExecutionTargetOperation {

    private final IFunction<Object,Object> executable;
    private final Normalisation normalisation;

    
    
    @SuppressWarnings("unchecked")
    public ExecutionTargetExecuteOperation(final IFunction<?,?> executable, final Normalisation normalisation) {
        super();
        this.executable = (IFunction<Object,Object>) executable;
        this.normalisation = normalisation;
    }
    
    
    
    @SuppressWarnings("unchecked")
    public Object execute(final Object target, final ExecutionTargetOperation[][] operations, final Integer index) {

        try {
            Object result = this.executable.execute(target, new ExecCtxImpl(index));
            switch (this.normalisation.getNormalisationType()) {
                case TYPE_ARRAY:
                    NormalisationUtils.checkIsArray(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseArray((Object[])result, this.normalisation.getArrayComponentClass());
                    break;
                case TYPE_LIST:
                    NormalisationUtils.checkIsList(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseList((List<Object>)result);
                    break;
                case TYPE_MAP:
                    NormalisationUtils.checkIsMap(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMap((Map<Object, Object>)result);
                    break;
                case TYPE_MAPENTRY:
                    NormalisationUtils.checkIsMapEntry(Types.OBJECT, Types.OBJECT, result);
                    result = NormalisationUtils.normaliseMapEntry((Map.Entry<Object, Object>)result);
                    break;
                case TYPE_SET:
                    NormalisationUtils.checkIsSet(Types.OBJECT, result);
                    result = NormalisationUtils.normaliseSet((Set<Object>)result);
                    break;
                case TYPE_NONE:
            }
            return result;
        } catch (ExecutionException e) {
            throw e;
        } catch (Throwable t) {
            throw new ExecutionException(t);
        }
        
    }
    
}
