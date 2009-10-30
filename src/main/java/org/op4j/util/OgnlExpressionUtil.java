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

package org.op4j.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.collections.map.LRUMap;
import org.op4j.IOf;
import org.op4j.executables.functions.conversion.ConversionException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class OgnlExpressionUtil {

    
    @SuppressWarnings("unchecked")
    private static final Map<String,Object> parsedExpressionsByExpression =
        Collections.synchronizedMap(new LRUMap(100));
    
    
    public static final String TARGET_VARIABLE_NAME = "target";
    public static final String PARAM_VARIABLE_NAME = "param";


    
    
    private OgnlExpressionUtil() {
        super();
    }
    
    


    
    
    @SuppressWarnings("unchecked")
    public static <X> X evalOgnlExpression(
            final IOf<X> resultOf, final String ognlExpression, final Object targetObject, final Object parametersObject) {
        
        Object parsedExpression = parsedExpressionsByExpression.get(ognlExpression);
        
        Class<?> resultClass = resultOf.getComponentClass();
        
        if (parsedExpression == null) {
            try {
                parsedExpression = Ognl.parseExpression(ognlExpression);
            } catch (OgnlException e) {
                throw new ConversionException(e);
            }
            parsedExpressionsByExpression.put(ognlExpression,parsedExpression);
        }
        
        try {
            final Map<String,Object> ctx = new HashMap<String,Object>();
            ctx.put(TARGET_VARIABLE_NAME, targetObject);
            ctx.put(PARAM_VARIABLE_NAME, parametersObject);
            final Object result = Ognl.getValue(parsedExpression, ctx, targetObject);
            if (result != null && resultClass != null && !Object.class.equals(resultClass)) {
                if (!(resultClass.isAssignableFrom(result.getClass()))) {
                    throw new IllegalStateException("Result of expression \"" + ognlExpression + "\" is not " +
                            "assignable from class " + resultClass.getName());
                }
            }
            return (X) result;
        } catch (OgnlException e) {
            throw new ConversionException(e);
        }
        
    }
    
    
    
    
}
