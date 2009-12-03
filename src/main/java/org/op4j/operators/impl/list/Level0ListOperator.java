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
package org.op4j.operators.impl.list;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
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
public class Level0ListOperator<T> extends Operator
        implements ILevel0ListOperator<T>  {

    
    public Level0ListOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOperator<T> add(final T... newElements) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public ILevel0ListOperator<T> insert(final int position, final T... newElements) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0ListOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel0ListOperator<T> distinct() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public ILevel1ListElementsOperator<T> forEach() {
        return new Level1ListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ListElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1ListElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ListElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ListElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level1ListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1ListElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ListElementsOperator<T> forEachNotNull() {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ListElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ListElementsOperator<T> forEachNull() {
        return new Level1ListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ListElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ListElementsOperator<T>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0ListOperator<X> of(final Type<X> of) {
        return new Level0ListOperator<X>(getTarget());
    }


    public ILevel0ListOperator<?> raw() {
        return new Level0ListOperator<T>(getTarget());
    }


    public ILevel0ListOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel0ListOperator<T> removeEquals(final T... values) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public ILevel0ListOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ListOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel0ListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0ListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0ListOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel0ListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel0ListOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ListOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ListOperator<T> removeNulls() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOperator<T> sort() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel0ListOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel0ArrayOperator<T> toArray(final Type<T> of) {
        return new Level0ArrayOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel0MapOperator<T, T> toMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    public <K> ILevel0MapOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0SetOperator<T> toSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<T>> generic() {
        return new Level0GenericUniqOperator<List<T>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X, ? super List<T>> call) {
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

    

	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super List<T>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<T>> eval) {
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


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
    

}
