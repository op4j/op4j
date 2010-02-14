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

package org.op4j.functions.evaluators;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.collections.map.LRUMap;
import org.javaruntype.type.Type;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.ExecCtx;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
class OgnlExpressionUtil {

    
    @SuppressWarnings("unchecked")
    private static final Map<String,Object> parsedExpressionsByExpression =
        Collections.synchronizedMap(new LRUMap(100));
    
    
    public static final String TARGET_VARIABLE_NAME = "target";
    public static final String PARAM_VARIABLE_NAME = "param";
    public static final String CURRENT_INDEX_VARIABLE_NAME = "index";
    public static final String INDEXES_VARIABLE_NAME = "indexes";
    public static final String ITERATION_LEVEL_VARIABLE_NAME = "iterationLevel";


    
    
    private OgnlExpressionUtil() {
        super();
    }
    
    


    
    
    @SuppressWarnings("unchecked")
    public static <X> X evalOgnlExpression(
            final Type<X> resultType, final String ognlExpression, final Object targetObject, final Object parametersObject, 
            final ExecCtx execCtx) {
        
        Object parsedExpression = parsedExpressionsByExpression.get(ognlExpression);
        
        final Class<? super X> resultClass = resultType.getRawClass();
        
        if (parsedExpression == null) {
            try {
                parsedExpression = Ognl.parseExpression(ognlExpression);
            } catch (OgnlException e) {
                throw new ExecutionException(e);
            }
            parsedExpressionsByExpression.put(ognlExpression,parsedExpression);
        }
        
        try {
            final Map<String,Object> ctx = new HashMap<String,Object>();
            ctx.put(TARGET_VARIABLE_NAME, targetObject);
            ctx.put(PARAM_VARIABLE_NAME, parametersObject);
            ctx.put(CURRENT_INDEX_VARIABLE_NAME, execCtx.getCurrentIndex());
            ctx.put(INDEXES_VARIABLE_NAME, new Integer[] {execCtx.getLevel0Index(), execCtx.getLevel1Index(), execCtx.getLevel2Index(), execCtx.getLevel3Index(), execCtx.getLevel4Index()});
            ctx.put(ITERATION_LEVEL_VARIABLE_NAME, execCtx.getIterationLevel());
            final Object result = Ognl.getValue(parsedExpression, ctx, targetObject);
            if (result != null && resultClass != null && !Object.class.equals(resultClass)) {
                if (!(resultClass.isAssignableFrom(result.getClass()))) {
                    throw new IllegalStateException("Result of expression \"" + ognlExpression + "\" is not " +
                            "assignable from class " + resultClass.getName());
                }
            }
            return (X) result;
        } catch (OgnlException e) {
            throw new ExecutionException(e);
        }
        
    }
    
    
    
    
}
