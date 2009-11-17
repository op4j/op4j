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
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
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
public class GenericFunc<X,T> implements IFunc<X,T>  {
    
    private final Function<X,T> function;
    private final List<? extends Object> parameters;

    
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,T> uniqAdd(final T... newElements) {
        return new GenericFunc<List<T>,T>((Function<List<T>,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "UNIQ_ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiAdd(final T... newElements) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), "MULTI_ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,T> uniqInsert(final int position, final T... newElements) {
        return new GenericFunc<List<T>,T>((Function<List<T>,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), Integer.valueOf(position), "UNIQ_ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiInsert(final int position, final T... newElements) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(newElements), Integer.valueOf(position), "MULTI_ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,T> uniqAddAll(final Collection<T> collection) {
        return new GenericFunc<List<T>,T>((Function<List<T>,T>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {new ArrayList<Object>(collection), "UNIQ_ADD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiAddAll(final Collection<T> collection) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {new ArrayList<Object>(collection), "MULTI_ADD"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemovePositions(final int... positions) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "MULTI_REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemoveValues(final T... values) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredObjectList(values), "MULTI_REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemoveMatching(final String expression, final Object... optionalExpParams) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "MULTI_REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemoveSelected(final ISelect<T> selector) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {selector, "MULTI_REMOVE"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemoveAllExceptPositions(final int... positions) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {VarArgsUtil.asRequiredIntegerArray(positions), "MULTI_REMOVE_NOT"})); 
    }


    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemoveNulls() {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {"MULTI_REMOVE_NULL"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiRemoveNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericModifyFunction.NAME), Arrays.asList(new Object[] {expression, VarArgsUtil.asOptionalObjectList(optionalExpParams), "MULTI_REMOVE_NOT_NULL_AND"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<Set<T>,T> uniqBuildSet() {
        return new GenericFunc<Set<T>,T>((Function<Set<T>,T>) Functions.getFunctionByName(GenericBuildSetFunction.NAME), Arrays.asList(new Object[] {"UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<Set<T>,List<T>> multiBuildSet() {
        return new GenericFunc<Set<T>,List<T>>((Function<Set<T>,List<T>>) Functions.getFunctionByName(GenericBuildSetFunction.NAME), Arrays.asList(new Object[] {"MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,T> uniqBuildList() {
        return new GenericFunc<List<T>,T>((Function<List<T>,T>) Functions.getFunctionByName(GenericBuildListFunction.NAME), Arrays.asList(new Object[] {"UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<List<T>,List<T>> multiBuildList() {
        return new GenericFunc<List<T>,List<T>>((Function<List<T>,List<T>>) Functions.getFunctionByName(GenericBuildListFunction.NAME), Arrays.asList(new Object[] {"MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<T[],T> uniqBuildArray(final Type<T> arrayOfType) {
        return new GenericFunc<T[],T>((Function<T[],T>) Functions.getFunctionByName(GenericBuildArrayFunction.NAME), Arrays.asList(new Object[] {arrayOfType, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<T[],List<T>> multiBuildArray(final Type<T> arrayOfType) {
        return new GenericFunc<T[],List<T>>((Function<T[],List<T>>) Functions.getFunctionByName(GenericBuildArrayFunction.NAME), Arrays.asList(new Object[] {arrayOfType, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,T>,T> uniqBuildMap(final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,T>,T>((Function<Map<K,T>,T>) Functions.getFunctionByName(GenericBuildMapFunction.NAME), Arrays.asList(new Object[] {keyEval, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,T>,List<T>> multiBuildMap(final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,T>,List<T>>((Function<Map<K,T>,List<T>>) Functions.getFunctionByName(GenericBuildMapFunction.NAME), Arrays.asList(new Object[] {keyEval, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,V>,T> uniqBuildMap(final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,V>,T>((Function<Map<K,V>,T>) Functions.getFunctionByName(GenericBuildMapFunction.NAME), Arrays.asList(new Object[] {mapBuild, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,V>,List<T>> multiBuildMap(final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,V>,List<T>>((Function<Map<K,V>,List<T>>) Functions.getFunctionByName(GenericBuildMapFunction.NAME), Arrays.asList(new Object[] {mapBuild, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<Map<T,T>,List<T>> multiBuildMap() {
        return new GenericFunc<Map<T,T>,List<T>>((Function<Map<T,T>,List<T>>) Functions.getFunctionByName(GenericBuildMapFunction.NAME), Arrays.asList(new Object[] {"MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,Set<T>>,T> uniqBuildMapOfSet(final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,Set<T>>,T>((Function<Map<K,Set<T>>,T>) Functions.getFunctionByName(GenericBuildMapOfSetFunction.NAME), Arrays.asList(new Object[] {keyEval, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,Set<T>>,List<T>> multiBuildMapOfSet(final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,Set<T>>,List<T>>((Function<Map<K,Set<T>>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfSetFunction.NAME), Arrays.asList(new Object[] {keyEval, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,Set<V>>,T> uniqBuildMapOfSet(final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,Set<V>>,T>((Function<Map<K,Set<V>>,T>) Functions.getFunctionByName(GenericBuildMapOfSetFunction.NAME), Arrays.asList(new Object[] {mapBuild, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,Set<V>>,List<T>> multiBuildMapOfSet(final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,Set<V>>,List<T>>((Function<Map<K,Set<V>>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfSetFunction.NAME), Arrays.asList(new Object[] {mapBuild, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<Map<T,Set<T>>,List<T>> multiBuildMapOfSet() {
        return new GenericFunc<Map<T,Set<T>>,List<T>>((Function<Map<T,Set<T>>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfSetFunction.NAME), Arrays.asList(new Object[] {"MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,List<T>>,T> uniqBuildMapOfList(final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,List<T>>,T>((Function<Map<K,List<T>>,T>) Functions.getFunctionByName(GenericBuildMapOfListFunction.NAME), Arrays.asList(new Object[] {keyEval, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,List<T>>,List<T>> multiBuildMapOfList(final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,List<T>>,List<T>>((Function<Map<K,List<T>>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfListFunction.NAME), Arrays.asList(new Object[] {keyEval, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,List<V>>,T> uniqBuildMapOfList(final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,List<V>>,T>((Function<Map<K,List<V>>,T>) Functions.getFunctionByName(GenericBuildMapOfListFunction.NAME), Arrays.asList(new Object[] {mapBuild, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,List<V>>,List<T>> multiBuildMapOfList(final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,List<V>>,List<T>>((Function<Map<K,List<V>>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfListFunction.NAME), Arrays.asList(new Object[] {mapBuild, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<Map<T,List<T>>,List<T>> multiBuildMapOfList() {
        return new GenericFunc<Map<T,List<T>>,List<T>>((Function<Map<T,List<T>>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfListFunction.NAME), Arrays.asList(new Object[] {"MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,T[]>,T> uniqBuildMapOfArray(final Type<T> type, final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,T[]>,T>((Function<Map<K,T[]>,T>) Functions.getFunctionByName(GenericBuildMapOfArrayFunction.NAME), Arrays.asList(new Object[] {type, keyEval, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,T> GenericFunc<Map<K,T[]>,List<T>> multiBuildMapOfArray(final Type<T> type, final IEval<K,? super T> keyEval) {
        return new GenericFunc<Map<K,T[]>,List<T>>((Function<Map<K,T[]>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfArrayFunction.NAME), Arrays.asList(new Object[] {type, keyEval, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,V[]>,T> uniqBuildMapOfArray(final Type<V> type, final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,V[]>,T>((Function<Map<K,V[]>,T>) Functions.getFunctionByName(GenericBuildMapOfArrayFunction.NAME), Arrays.asList(new Object[] {type, mapBuild, "UNIQ_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <K,V,T> GenericFunc<Map<K,V[]>,List<T>> multiBuildMapOfArray(final Type<V> type, final IMapBuild<K,V,? super T> mapBuild) {
        return new GenericFunc<Map<K,V[]>,List<T>>((Function<Map<K,V[]>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfArrayFunction.NAME), Arrays.asList(new Object[] {type, mapBuild, "MULTI_BUILD"})); 
    }
    
    
    @SuppressWarnings("unchecked")
    public static <T> GenericFunc<Map<T,T[]>,List<T>> multiBuildMapOfArray(final Type<T> type) {
        return new GenericFunc<Map<T,T[]>,List<T>>((Function<Map<T,T[]>,List<T>>) Functions.getFunctionByName(GenericBuildMapOfArrayFunction.NAME), Arrays.asList(new Object[] {type, "MULTI_BUILD"})); 
    }
    
    
    
    
    
    
    private GenericFunc(final Function<X,T> function, final List<? extends Object> parameters) {
        super();
        this.function = function;
        this.parameters = parameters;
    }



    public Type<? super X> getResultType() {
        return this.function.getResultType();
    }



    public X execute(final T object) {
        return this.function.executeFunction(FunctionArguments.fromObjects(object, this.parameters));
    }

     
        
}
