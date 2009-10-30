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
package org.op4j.executables.functions;

import java.util.List;

import org.op4j.IOf;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Func<X,T> implements IFunc<X,T>  {
    
    private final Function<X,T> function;
    private final List<Object> parameters;
    
    
    public static Func(final String functionName, final Object...parameters) {
        
        return new Func(REGISTRY.getFunction(functionName), VarArgsUtil.asOptionalObjectList(parameters); 
    }
    
    
    
    private Func(final Function<X,T> function, final List<Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public IOf<X> getResultOf() {
        return this.function.getResultOf();
    }



    public X execute(T object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }
     
        
}
