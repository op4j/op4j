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

import org.apache.commons.lang.Validate;
import org.op4j.functions.IFunction;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class Target {

    public static enum Structure { ARRAY, LIST, SET, MAP, MAP_ENTRY }
    public static enum Normalization { 
        NONE, 
        ARRAY, LIST, SET, MAP, MAPENTRY, 
        ARRAY_OF_ARRAY, ARRAY_OF_LIST, ARRAY_OF_MAP, ARRAY_OF_SET,
        LIST_OF_ARRAY, LIST_OF_LIST, LIST_OF_MAP, LIST_OF_SET,
        MAP_OF_ARRAY, MAP_OF_LIST, MAP_OF_MAP, MAP_OF_SET,
        MAPENTRY_OF_ARRAY, MAPENTRY_OF_LIST, MAPENTRY_OF_MAP, MAPENTRY_OF_SET,
        SET_OF_ARRAY, SET_OF_LIST, SET_OF_MAP, SET_OF_SET }

    
    
    
    protected Target() {
        super();
    }
    
    
    abstract Target doIterate();
    

    abstract Target doSelectIndex(final boolean desiredResult, final List<Integer> positions);
    abstract Target doSelectMapKeys(final boolean desiredResult, final List<Object> objects);
    abstract Target doSelectMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doSelectNull(final boolean desiredResult);
    abstract Target doSelectNullOrMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    abstract Target doSelectNotNullAndMatching(final boolean desiredResult, final IEvaluator<Boolean,Object> eval);
    
    
    public final Target iterate() {
        return doIterate();
    }
    

    abstract Target doEndIterate(final Structure structure, final Class<?> componentClass);

    
    public final Target endIterate(final Structure structure, final Class<?> componentClass) {
        return doEndIterate(structure, componentClass);
    }

    
    abstract Target doEndSelect();

    
    public final Target endSelect() {
        return doEndSelect();
    }
    
    
    public final Target selectIndex(final int... positions) {
    	return doSelectIndex(true, VarArgsUtil.asRequiredIntegerList(positions));
    }
    
    
    public final Target selectIndexNot(final int... positions) {
        return doSelectIndex(false, VarArgsUtil.asRequiredIntegerList(positions));
    }

    
    public final Target selectMapKeys(final Object... keys) {
    	return doSelectMapKeys(true, VarArgsUtil.asRequiredObjectList(keys));
    }

    
    public final Target selectMapKeysNot(final Object... objects) {
        return doSelectMapKeys(false, VarArgsUtil.asRequiredObjectList(objects));
    }
    
    
    @SuppressWarnings("unchecked")
    public final Target selectMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
    	return doSelectMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
    	return doSelectMatching(false, (IEvaluator<Boolean,Object>) eval);
    }

    
    public final Target selectNull() {
        return doSelectNull(true);
    }

    
    public final Target selectNotNull() {
        return doSelectNull(false);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNullOrMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNullOrMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNullOrNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNullOrMatching(false, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNotNullAndMatching(final IEvaluator<Boolean,? extends Object> eval) {
    	Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNotNullAndMatching(true, (IEvaluator<Boolean,Object>) eval);
    }

    
    @SuppressWarnings("unchecked")
    public final Target selectNotNullAndNotMatching(final IEvaluator<Boolean,? extends Object> eval) {
        Validate.notNull(eval, "An evaluator must be specified");
        return doSelectNotNullAndMatching(false, (IEvaluator<Boolean,Object>) eval);
    }
    
    
    
    abstract Target doReplaceWith(final Object replacement);
    

    public final Target replaceWith(final Object replacement) {
        return doReplaceWith(replacement);
    }
    
    
    abstract Target doExecute(final IFunction<?,?> executable, final Normalization normalization);

    
    public final Target execute(final IFunction<?,?> executable) {
        return execute(executable, Normalization.NONE);
    }

    public final Target execute(final IFunction<?,?> executable, final Normalization normalization) {
        return doExecute(executable, normalization);
    }
    
    
    public abstract Object get();
    
    
    
}
