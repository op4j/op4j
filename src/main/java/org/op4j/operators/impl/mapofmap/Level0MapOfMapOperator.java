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
package org.op4j.operators.impl.mapofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
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
public class Level0MapOfMapOperator<K1,K2,V> extends Operator
        implements ILevel0MapOfMapOperator<K1,K2,V> {

    
    public Level0MapOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOperator<K1> extractKeys() {
        return new Level0SetOperator<K1>(getTarget().execute(new MapFuncs.ExtractKeys<K1, Map<K2, V>>()));
    }


    public ILevel0ListOfMapOperator<K2, V> extractValues() {
        return new Level0ListOfMapOperator<K2, V>(getTarget().execute(new MapFuncs.ExtractValues<K1, Map<K2, V>>()));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate());
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeys(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(eval));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntrySelected(final ISelector<Entry<K1, Map<K2, V>>> selector) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(selector));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeysNot(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateNot(keys));
    }








    public <X, Y, Z> ILevel0MapOfMapOperator<X, Y, Z> of(final Type<X> ofX, final Type<Y> ofY, final Type<Z> ofZ) {
        return new Level0MapOfMapOperator<X, Y, Z>(getTarget());
    }


    public ILevel0MapOfMapOperator<K1, K2, V> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.Put<K1, Map<K2,V>>(newKey, newValue)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.Insert<K1, Map<K2,V>>(position, newKey, newValue)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> putAll(final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.PutAll<K1, Map<K2,V>>(map)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> insertAll(final int position, final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.InsertAll<K1, Map<K2,V>>(position, map)));
    }


    public ILevel0MapOfMapOperator<?, ?, ?> raw() {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget());
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeKeys(final K1... keys) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeys<K1, Map<K2,V>>(keys)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveMatching<K1, Map<K2,V>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveMatching<K1, Map<K2,V>>(eval)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeSelected(final ISelector<Entry<K1, Map<K2,V>>> selector) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveSelected<K1, Map<K2,V>>(selector)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeKeysNot(final K1... keys) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K1, Map<K2,V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOfMapOperator<K1, K2, V> sort() {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public ILevel0MapOfMapOperator<K1, K2, V> sort(final Comparator<? super Entry<K1, Map<K2, V>>> comparator) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K1, Map<K2, V>> get() {
        return (Map<K1,Map<K2,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K1, Map<K2, V>>> generic() {
        return new Level0GenericUniqOperator<Map<K1, Map<K2, V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K1,Map<K2,V>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K1,Map<K2,V>>> eval) {
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


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K1,Map<K2,V>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}
    
}
