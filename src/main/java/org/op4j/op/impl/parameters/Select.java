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
package org.op4j.op.impl.parameters;

import java.util.List;

import org.op4j.op.intf.parameters.ISelect;
import org.op4j.op.util.OgnlExpressionUtil;
import org.op4j.op.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Select<T> implements ISelect<T> {

    
    private final String ognlExpression;
    private final List<Object> parameters;

    
    
    public static Select<Object> exp(final String ognlExpression, final Object... parameters) {
        return new Select<Object>(ognlExpression, VarArgsUtil.asOptionalObjectList(parameters));
    }
    
    
    public Select(final String ognlExpression, final List<Object> parameters) {
        super();
        this.ognlExpression = ognlExpression;
        this.parameters = parameters;
    }
    
    
    public boolean eval(final T target) {
        
        final Boolean result =
            OgnlExpressionUtil.evalOgnlExpression(Of.BOOLEAN, this.ognlExpression, target, this.parameters);
        
        if (result != null) {
            return result.booleanValue();
        }
        
        return false;
    }

    
    
}
