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
package org.op4j.operators.impl.arrayofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
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
public class Level0ArrayOfMapOperator<K,V> extends Operator
        implements ILevel0ArrayOfMapOperator<K,V>  {

    
    public Level0ArrayOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.Add<Map<K, V>>(newElements)));
    }


    public ILevel0ArrayOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.Insert<Map<K, V>>(position, newElements)));
    }


    public ILevel0ArrayOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.AddAll<Map<K, V>>(collection)));
    }


    public ILevel0ArrayOfMapOperator<K, V> distinct() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.Distinct<Map<K, V>>()));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEach() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(indices));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachSelected(final ISelector<Map<K, V>> selector) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNull() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X, Y> ILevel0ArrayOfMapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0ArrayOfMapOperator<X, Y>(getTarget());
    }


    public ILevel0ArrayOfMapOperator<?, ?> raw() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget());
    }


    public ILevel0ArrayOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveIndexes<Map<K, V>>(indices)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveEquals<Map<K, V>>(values)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveMatching<Map<K, V>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveMatching<Map<K, V>>(eval)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Map<K, V>>(eval)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Map<K, V>>(eval)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeSelected(final ISelector<Map<K, V>> selector) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveSelected<Map<K, V>>(selector)));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<Map<K, V>>(indices)));
    }



    public ILevel0ArrayOfMapOperator<K, V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Map<K, V>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Map<K, V>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0ArrayOfMapOperator<K, V> removeNulls() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.RemoveNulls<Map<K, V>>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<K, V> sort() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel0ArrayOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().execute(new ArrayFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
	public Map<K, V>[] get() {
        return (Map<K, V>[]) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V>[]> generic() {
        return new Level0GenericUniqOperator<Map<K, V>[]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X, ? super Map<K,V>[]> call) {
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

    

	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K,V>[]> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K,V>[]> eval) {
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


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>[]> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
    
}
