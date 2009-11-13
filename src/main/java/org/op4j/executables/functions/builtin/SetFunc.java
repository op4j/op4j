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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.ISelect;
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
public class SetFunc<X,T> implements IFunc<X,Set<T>>  {
    
    private final Function<X,Set<T>> function;
    private final List<? extends Object> parameters;

    
    
    
    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> add(final T... newElements) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "ADD"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> insert(final int position, final T... newElements) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), Integer.valueOf(position), "ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> addAll(final Collection<T> collection) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {new ArrayList<Object>(collection), "ADD"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removePositions(final int... positions) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removeValues(final T... values) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(values), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removeSelected(final ISelect<T> selector) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {selector, "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removeAllExceptPositions(final int... positions) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "REMOVE_NOT"})); 
    }



    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removeNulls() {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {"REMOVE_NULL"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> SetFunc<Set<T>,T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new SetFunc<Set<T>,T>((Function<Set<T>, Set<T>>) Functions.getFunctionByName(SetModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE_NOT_NULL_AND"})); 
    }
    
    
    
    
    
    
    private SetFunc(final Function<X,Set<T>> function, final List<? extends Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public Type<X> getResultType() {
        return this.function.getResultType();
    }



    public X execute(final Set<T> object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }

     
        
}
