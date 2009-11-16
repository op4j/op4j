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

package org.op4j.executables.functions.builtin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.TypeParameters;
import org.javaruntype.type.Types;
import org.op4j.exceptions.FunctionExecutionException;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.functions.FunctionArgumentScheme;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.FunctionImplementation;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class GenericBuildMapOfArrayFunction extends FunctionImplementation<Map<?,Object[]>, Object> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.OBJECT, BuiltinNaming.OPERATION_NAME_BUILD_MAP_OF_ARRAY);

    
    private static final FunctionArgumentScheme GEN_UNIQ_EVAL_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map of array containing the target object, evaluating keys from the specified evaluator.",
            Types.OBJECT,
            Type.class.getName() + " type, " + IEval.class.getName() + " eval, 'UNIQ_BUILD'");
    
    private static final FunctionArgumentScheme GEN_UNIQ_MAPBUILD_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map of array containing the target object, evaluating both keys and values from the specified evaluator.",
            Types.OBJECT,
            Type.class.getName() + " type, " + IMapBuild.class.getName() + " eval, 'UNIQ_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_EVAL_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map of array containing all the target objects, evaluating keys from the specified evaluator.",
            Types.LIST_OF_UNKNOWN,
            Type.class.getName() + " type, " + IEval.class.getName() + " eval, 'MULTI_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_MAPBUILD_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map of array containing all the target objects, evaluating both keys and values from the specified evaluator..",
            Types.LIST_OF_UNKNOWN,
            Type.class.getName() + " type, " + IMapBuild.class.getName() + " eval, 'MULTI_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map of array containing all the target objects, considering the even elements as keys and the even elements as values (starting with 0).",
            Types.LIST_OF_UNKNOWN,
            Type.class.getName() + " type, " + "'MULTI_BUILD'");
    

    
    
    
    public GenericBuildMapOfArrayFunction() {
    	super();
    }
	

    @Override
    protected Set<FunctionArgumentScheme> registerMatchedSchemes() {
        final Set<FunctionArgumentScheme> matched = new LinkedHashSet<FunctionArgumentScheme>();
        matched.add(GEN_UNIQ_EVAL_BUILD);
        matched.add(GEN_UNIQ_MAPBUILD_BUILD);
        matched.add(GEN_MULTI_EVAL_BUILD);
        matched.add(GEN_MULTI_MAPBUILD_BUILD);
        matched.add(GEN_MULTI_BUILD);
        return matched;
    }


    
	@Override
	protected String registerFunctionName() {
		return NAME;
	}
	
	
	@Override
	protected Type<Map<?,Object[]>> registerResultType() {
		return Types.mapOf(TypeParameters.forUnknown(), TypeParameters.forType(Types.arrayOf(Types.OBJECT)));
	}

	
	@Override
	protected Type<Object> registerTargetType() {
		return Types.OBJECT;
	}
	
	

    @SuppressWarnings("unchecked")
	@Override
    public Map<?,Object[]> execute(final FunctionArguments arguments) throws Exception {
        
        if (GEN_UNIQ_EVAL_BUILD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final Type<?> type = (Type<?>) arguments.getParameter(0);
            final IEval<Object,Object> eval = (IEval<Object,Object>) arguments.getParameter(1);
            final Map<Object,Object[]> newMap = new LinkedHashMap<Object,Object[]>();
            final Object[] value = (Object[]) Array.newInstance(type.getRawClass(), 1);
            value[0] = target;
            newMap.put(eval.execute(target), value);
            return newMap;
        }
        
        if (GEN_UNIQ_MAPBUILD_BUILD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final Type<?> type = (Type<?>) arguments.getParameter(0);
            final IMapBuild<Object,Object,Object> mapBuild = (IMapBuild<Object,Object,Object>) arguments.getParameter(1);
            final Map<Object,Object[]> newMap = new LinkedHashMap<Object,Object[]>();
            final Object[] value = (Object[]) Array.newInstance(type.getRawClass(), 1);
            value[0] = target;
            newMap.put(mapBuild.getKey(target), value);
            return newMap;
        }
        
        if (GEN_MULTI_EVAL_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final Type<?> type = (Type<?>) arguments.getParameter(0);
            final IEval<Object,Object> eval = (IEval<Object,Object>) arguments.getParameter(1);
            final Map<Object,List<Object>> tempMap = new LinkedHashMap<Object,List<Object>>();
            for (final Object targetObj : target) {
                final Object key = eval.execute(targetObj);
                List<Object> value = tempMap.get(key);
                if (value == null) {
                    value = new ArrayList<Object>();
                    tempMap.put(key, value);
                }
            	value.add(targetObj);
            }
            final Map<Object,Object[]> newMap = new LinkedHashMap<Object,Object[]>();
            for (final Map.Entry<Object,List<Object>> tempEntry : tempMap.entrySet()) {
                final Object key = tempEntry.getKey();
                final List<Object> value = tempEntry.getValue();
                final Object[] array = (Object[]) Array.newInstance(type.getRawClass(), value.size());
                newMap.put(key, value.toArray(array));
            }
            return newMap;
        }
        
        if (GEN_MULTI_MAPBUILD_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final Type<?> type = (Type<?>) arguments.getParameter(0);
            final IMapBuild<Object,Object,Object> mapBuild = (IMapBuild<Object,Object,Object>) arguments.getParameter(1);
            final Map<Object,List<Object>> tempMap = new LinkedHashMap<Object,List<Object>>();
            for (final Object targetObj : target) {
                final Object key = mapBuild.getKey(targetObj);
                List<Object> value = tempMap.get(key);
                if (value == null) {
                    value = new ArrayList<Object>();
                    tempMap.put(key, value);
                }
                value.add(mapBuild.getValue(targetObj));
            }
            final Map<Object,Object[]> newMap = new LinkedHashMap<Object,Object[]>();
            for (final Map.Entry<Object,List<Object>> tempEntry : tempMap.entrySet()) {
                final Object key = tempEntry.getKey();
                final List<Object> value = tempEntry.getValue();
                final Object[] array = (Object[]) Array.newInstance(type.getRawClass(), value.size());
                newMap.put(key, value.toArray(array));
            }
            return newMap;
        }
        
        if (GEN_MULTI_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final Type<?> type = (Type<?>) arguments.getParameter(0);
            if (target.size() % 2 != 0) {
            	throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<Object,List<Object>> tempMap = new LinkedHashMap<Object,List<Object>>();
            for (int i = 0, n = target.size() - 1; i < n; i+=2) {
                final Object key = target.get(i);
                List<Object> value = tempMap.get(key);
                if (value == null) {
                    value = new ArrayList<Object>();
                    tempMap.put(key, value);
                }
                value.add(target.get(i + 1));
            }
            final Map<Object,Object[]> newMap = new LinkedHashMap<Object,Object[]>();
            for (final Map.Entry<Object,List<Object>> tempEntry : tempMap.entrySet()) {
                final Object key = tempEntry.getKey();
                final List<Object> value = tempEntry.getValue();
                final Object[] array = (Object[]) Array.newInstance(type.getRawClass(), value.size());
                newMap.put(key, value.toArray(array));
            }
            return newMap;
        }
        
        return null;
         
    }
	
	
	
}
