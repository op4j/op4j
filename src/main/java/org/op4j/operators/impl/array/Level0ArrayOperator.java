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
package org.op4j.operators.impl.array;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;
import org.op4j.util.VarArgsUtil;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public class Level0ArrayOperator<T> extends Operator implements
        ILevel0ArrayOperator<T> {

    
    private final Type<? super T> arrayOf; 
    
    
    public Level0ArrayOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }

    
    public ILevel0ArrayOperator<T> add(final T... newElements) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public ILevel0ArrayOperator<T> insert(final int position, final T... newElements) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0ArrayOperator<T> addAll(final Collection<T> collection) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }

    public ILevel0ArrayOperator<T> distinct() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }

    public ILevel1ArrayElementsOperator<T> forEach() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }

    public ILevel1ArrayElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }

    public ILevel1ArrayElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ArrayElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel1ArrayElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }

    public ILevel1ArrayElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }





    public ILevel1ArrayElementsOperator<T> forEachNotNull() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }

    public ILevel1ArrayElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }



    public ILevel1ArrayElementsOperator<T> forEachNull() {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }

    public ILevel1ArrayElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public <X> ILevel0ArrayOperator<X> of(final Type<X> of) {
        return new Level0ArrayOperator<X>(of, getTarget());
    }

    public ILevel0ArrayOperator<?> raw() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget());
    }

    public ILevel0ArrayOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel0ArrayOperator<T> removeEquals(final T... values) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public ILevel0ArrayOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ArrayOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel0ArrayOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0ArrayOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0ArrayOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel0ArrayOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public ILevel0ArrayOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }

    public ILevel0ArrayOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ArrayOperator<T> removeNulls() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel0ArrayOperator<T> sort() {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel0ArrayOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ArrayOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }

    public ILevel0ListOperator<T> toList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public ILevel0MapOperator<T, T> toMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> ILevel0MapOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }

    public <K, V> ILevel0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }

    public ILevel0SetOperator<T> toSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }

    @SuppressWarnings("unchecked")
	public T[] get() {
        return (T[]) getTarget().get();
    }

    public ILevel0GenericUniqOperator<T[]> generic() {
        return new Level0GenericUniqOperator<T[]>(getTarget());
    }


    
    
    
	public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X, ? super T[]> call) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(call));
	}


    public ILevel0GenericUniqOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel0GenericUniqOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }

    

	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super T[]> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super T[]> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public ILevel0GenericUniqOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel0GenericUniqOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}


}
