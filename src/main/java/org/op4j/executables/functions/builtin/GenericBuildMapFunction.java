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

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
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
public final class GenericBuildMapFunction extends FunctionImplementation<Map<?,?>, Object> {

	public static final String NAME = BuiltinNaming.getBuiltinFunctionName(Types.OBJECT, BuiltinNaming.OPERATION_NAME_BUILD_MAP);

    
    private static final FunctionArgumentScheme GEN_UNIQ_EVAL_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map containing the target object, evaluating keys from the specified evaluator.",
            Types.OBJECT,
            IEval.class.getName() + " eval, 'UNIQ_BUILD'");
    
    private static final FunctionArgumentScheme GEN_UNIQ_MAPBUILD_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map containing the target object, evaluating both keys and values from the specified evaluator.",
            Types.OBJECT,
            IMapBuild.class.getName() + " eval, 'UNIQ_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_EVAL_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map containing all the target objects, evaluating keys from the specified evaluator.",
            Types.LIST_OF_UNKNOWN,
            IEval.class.getName() + " eval, 'MULTI_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_MAPBUILD_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map containing all the target objects, evaluating both keys and values from the specified evaluator..",
            Types.LIST_OF_UNKNOWN,
            IMapBuild.class.getName() + " eval, 'MULTI_BUILD'");
    
    private static final FunctionArgumentScheme GEN_MULTI_BUILD = 
        FunctionArgumentScheme.from(
            "It builds a map containing all the target objects, considering the even elements as keys and the even elements as values (starting with 0).",
            Types.LIST_OF_UNKNOWN,
            "'MULTI_BUILD'");
    

    
    
    
    public GenericBuildMapFunction() {
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
	protected Type<Map<?,?>> registerResultType() {
		return Types.MAP_OF_UNKNOWN_UNKNOWN;
	}

	
	@Override
	protected Type<Object> registerTargetType() {
		return Types.OBJECT;
	}
	
	

    @SuppressWarnings("unchecked")
	@Override
    public Map<?,?> execute(final FunctionArguments arguments) throws Exception {
        
        if (GEN_UNIQ_EVAL_BUILD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final IEval<Object,Object> eval = (IEval<Object,Object>) arguments.getParameter(0);
            final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
            newMap.put(eval.execute(target), target);
            return newMap;
        }
        
        if (GEN_UNIQ_MAPBUILD_BUILD.matches(arguments)) {
            final Object target = arguments.getTarget();
            final IMapBuild<Object,Object,Object> mapBuild = (IMapBuild<Object,Object,Object>) arguments.getParameter(0);
            final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
            newMap.put(mapBuild.getKey(target), mapBuild.getValue(target));
            return newMap;
        }
        
        if (GEN_MULTI_EVAL_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final IEval<Object,Object> eval = (IEval<Object,Object>) arguments.getParameter(0);
            final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
            for (final Object targetObj : target) {
            	newMap.put(eval.execute(targetObj), targetObj);
            }
            return newMap;
        }
        
        if (GEN_MULTI_MAPBUILD_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            final IMapBuild<Object,Object,Object> mapBuild = (IMapBuild<Object,Object,Object>) arguments.getParameter(0);
            final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
            for (final Object targetObj : target) {
            	newMap.put(mapBuild.getKey(targetObj), mapBuild.getValue(targetObj));
            }
            return newMap;
        }
        
        if (GEN_MULTI_BUILD.matches(arguments)) {
            if (arguments.isTargetNull()) {
                throw new NullPointerException("Cannot execute operation on null target");
            }
            final List<?> target = (List<?>) arguments.getTarget();
            if (target.size() % 2 != 0) {
            	throw new FunctionExecutionException("Cannot create a map from objects: the number of objects must be even.");
            }
            final Map<Object,Object> newMap = new LinkedHashMap<Object,Object>();
            for (int i = 0, n = target.size() - 1; i < n; i+=2) {
            	newMap.put(target.get(i), target.get(i + 1));
            }
            return newMap;
        }
        
        return null;
         
    }
	
	
	
}
