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
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.ListUtils;
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
public class ArrayFuncOLD<X,T> implements IFunc<X,T[]>  {
    
    private final Function<X,T[]> function;
    private final List<? extends Object> parameters;

    
    
	@SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> distinct() {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayDistinctFunction.NAME), ListUtils.EMPTY_LIST); 
    }

	
    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> add(final T... newElements) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "ADD"})); 
    }
    
    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> insert(final int position, final T... newElements) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), Integer.valueOf(position), "ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> addAll(final Collection<T> collection) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {new ArrayList<Object>(collection), "ADD"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removePositions(final int... positions) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removeValues(final T... values) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(values), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removeMatching(final String expression, final Object... optionalExpParams) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removeSelected(final ISelect<T> selector) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {selector, "REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removeAllExceptPositions(final int... positions) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "REMOVE_NOT"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removeNulls() {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {"REMOVE_NULL"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArrayModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "REMOVE_NOT_NULL_AND"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> sort() {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArraySortFunction.NAME), ListUtils.EMPTY_LIST); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> ArrayFuncOLD<T[],T> sort(final Comparator<? super T> comparator) {
        return new ArrayFuncOLD<T[],T>((Function<T[], T[]>) Functions.getFunctionByName(ArraySortFunction.NAME), Arrays.asList(new Object[] {comparator})); 
    }
	
	
	
    
    
    private ArrayFuncOLD(final Function<X,T[]> function, final List<? extends Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public Type<? super X> getResultType() {
        return this.function.getResultType();
    }



    public X execute(final T[] object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }

     
        
}
