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
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level1ArrayElementsOperator;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfMapElementsOperator<K,V> extends Operator
        implements ILevel1ArrayOfMapElementsOperator<K,V>  {

    
    public Level1ArrayOfMapElementsOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfMapOperator<K, V> endFor() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().endIterate(Structure.ARRAY, Map.class));
    }


    public ILevel1ArrayOfSetElementsOperator<K> extractKeys() {
        return new Level1ArrayOfSetElementsOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel1ArrayOfListElementsOperator<V> extractValues() {
        return new Level1ArrayOfListElementsOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntrySelected(final ISelector<Entry<K, V>> selector) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel1ArrayOfMapElementsOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level1ArrayOfMapElementsOperator<X, Y>(getTarget());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public ILevel1ArrayOfMapElementsOperator<?, ?> raw() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget());
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeSelected(final ISelector<Entry<K, V>> selector) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveSelected<K, V>(selector)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeKeysNot(final K... keys) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfMapElementsOperator<K, V> sort() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Map<K, V>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel1ArrayElementsOperator<X> call(final IMethodCaller<X, ? super Map<K,V>> call) {
        return new Level1ArrayElementsOperator<X>(call.getResultType(), getTarget().execute(call));
	}


    public ILevel1ArrayElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Object>(Types.OBJECT, getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel1ArrayElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<X>(resultType, getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Byte>(Types.BYTE, getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Short>(Types.SHORT, getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Long>(Types.LONG, getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Float>(Types.FLOAT, getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<String>(Types.STRING, getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel1ArrayElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level1ArrayElementsOperator<Date>(Types.DATE, getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }

    

	public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level1ArrayElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
	}


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level1ArrayElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public ILevel1ArrayElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<BigDecimal>(Types.BIG_DECIMAL, getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<BigInteger>(Types.BIG_INTEGER, getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Boolean>(Types.BOOLEAN, getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Object>(Types.OBJECT, getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel1ArrayElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<X>(resultType, getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Byte>(Types.BYTE, getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Calendar>(Types.CALENDAR, getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Double>(Types.DOUBLE, getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Float>(Types.FLOAT, getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Integer>(Types.INTEGER, getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Long>(Types.LONG, getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Short>(Types.SHORT, getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel1ArrayElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<String>(Types.STRING, getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Character>(Types.CHARACTER, getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel1ArrayElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level1ArrayElementsOperator<Date>(Types.DATE, getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }


	public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level1ArrayElementsOperator<X>(function.getResultType(), getTarget().execute(function));
	}

    
    
    
    
}
