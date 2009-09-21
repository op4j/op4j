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
import java.util.List;
import java.util.Map;

import ognl.Ognl;
import ognl.OgnlException;

import org.apache.commons.collections.map.LRUMap;
import org.apache.commons.lang.Validate;
import org.op4j.operations.conversion.exceptions.ConversionException;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class OgnlUtils {
    
    @SuppressWarnings("unchecked")
    private static final Map<String,Object> parsedExpressionsByExpression =
        Collections.synchronizedMap(new LRUMap(100));
    
    public static final String TARGET_VARIABLE_NAME = "target";
    public static final String PARAM_VARIABLE_NAME = "param";
    

    public static <T> Object getValueByOgnlExpression(
            final T targetObject, 
            final String ognlExpression, final List<Object> params) {
        
        Validate.notNull(ognlExpression, "OGNL expression cannot be null");
        
        return unsafeGetValueByOgnlExpression(
                ognlExpression, targetObject, targetObject, params);
        
    }

    
    public static <T> Object getValueByOgnlExpression(
            final List<T> targetObjects, 
            final String ognlExpression, final List<Object> params) {
        
        Validate.notNull(ognlExpression, "OGNL expression cannot be null");
        Validate.notNull(targetObjects, "Target object list cannot be null");
        Validate.isTrue(targetObjects.size() > 0, "Target object list cannot be empty");
        
        return unsafeGetValueByOgnlExpression(
                ognlExpression, targetObjects, targetObjects, params);
        
    }

    
    private static <T> Object unsafeGetValueByOgnlExpression(
            final String ognlExpression,
            final Object expressionRoot, Object targetObject, Object paramsObject) {
        
        Object parsedExpression = parsedExpressionsByExpression.get(ognlExpression);
        
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
            ctx.put(PARAM_VARIABLE_NAME, paramsObject);
            return Ognl.getValue(parsedExpression, ctx, expressionRoot);
        } catch (OgnlException e) {
            throw new ConversionException(e);
        }
        
    }
    

    private OgnlUtils() {
        super();
    }
    
}
