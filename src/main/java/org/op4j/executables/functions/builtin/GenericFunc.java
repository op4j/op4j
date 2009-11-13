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
package org.op4j.executables.functions.builtin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.executables.functions.Function;
import org.op4j.executables.functions.FunctionArguments;
import org.op4j.executables.functions.Functions;
import org.op4j.executables.functions.IFunc;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class GenericFunc<X,T> implements IFunc<X,T>  {
    
    private final Function<X,T> function;
    private final List<? extends Object> parameters;

    
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<T,T> uniqAdd(final T newElement) {
        return new GenericFunc<T,T>((Function<T,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {Collections.singletonList(newElement), "UNIQ_ADD"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<T,T> uniqAddAllValues(final T... newElements) {
        return new GenericFunc<T,T>((Function<T,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "UNIQ_ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<T,T> multiAdd(final T newElement) {
        return new GenericFunc<T,T>((Function<T,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {Collections.singletonList(newElement), "MULTI_ADD"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<T,T> multiAddAllValkues(final T... newElements) {
        return new GenericFunc<T,T>((Function<T,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "MULTI_ADD"})); 
    }
    
    
    
    
    
    
    
    private GenericFunc(final Function<X,T> function, final List<? extends Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public Type<X> getResultType() {
        return this.function.getResultType();
    }



    public X execute(final T object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }

     
        
}
