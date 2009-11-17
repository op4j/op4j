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
package org.op4j.executables.functions.conversion;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.executables.functions.Function;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.Functions;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Conv<X> implements IConv<X>  {
    
    private final Function<X,Object> converter;
    private final List<? extends Object> parameters;

    
    
    @SuppressWarnings("unchecked")
    public static <X> Conv<X> to(final Type<X> resultType, final Object...parameters) {
        return new Conv<X>((Function<X, Object>) Functions.getFunctionByName(ConverterNaming.getConverterName(resultType)), VarArgsUtil.asOptionalObjectList(parameters)); 
    }
    
    
    
    private Conv(final Function<X,Object> converter, final List<? extends Object> parameters) {
        super();
        this.converter = converter;
        this.parameters = parameters;
    }



    public Type<? super X> getResultType() {
        return this.converter.getResultType();
    }



    public X execute(final Object object) {
        return this.converter.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }
     
        
}
