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
package org.op4j.operators.impl.mapofarray;

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
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.ILevel1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
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
public class Level0MapOfArrayOperator<K,V> extends Operator
        implements ILevel0MapOfArrayOperator<K,V> {
    
    private final Type<? super V> arrayOf; 

    
    public Level0MapOfArrayOperator(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0SetOperator<K> extractKeys() {
        return new Level0SetOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel0ListOfArrayOperator<V> extractValues() {
        return new Level0ListOfArrayOperator<V>(this.arrayOf, getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntryMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntrySelected(final ISelector<Entry<K, V[]>> selector) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOfArrayOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0MapOfArrayOperator<X, Y>(ofY, getTarget());
    }


    public ILevel0MapOfArrayOperator<K, V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.Put<K,V[]>(newKey, newValue)));
    }


    public ILevel0MapOfArrayOperator<K, V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.Insert<K,V[]>(position, newKey, newValue)));
    }


    public ILevel0MapOfArrayOperator<K, V> putAll(final Map<K, V[]> map) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.PutAll<K,V[]>(map)));
    }

    
    public ILevel0MapOfArrayOperator<K, V> insertAll(final int position, final Map<K, V[]> map) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.InsertAll<K,V[]>(position, map)));
    }


    public ILevel0MapOfArrayOperator<?, ?> raw() {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget());
    }


    public ILevel0MapOfArrayOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.RemoveKeys<K,V[]>(keys)));
    }


    public ILevel0MapOfArrayOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.RemoveMatching<K,V[]>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0MapOfArrayOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V[]>> eval) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.RemoveMatching<K,V[]>(eval)));
    }


    public ILevel0MapOfArrayOperator<K, V> removeSelected(final ISelector<Entry<K, V[]>> selector) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.RemoveSelected<K,V[]>(selector)));
    }


    public ILevel0MapOfArrayOperator<K, V> removeKeysNot(final K... keys) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.RemoveKeysNot<K,V[]>(keys)));
    }






    @SuppressWarnings("unchecked")
    public ILevel0MapOfArrayOperator<K, V> sort() {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel0MapOfArrayOperator<K, V> sort(final Comparator<? super Entry<K, V[]>> comparator) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFuncs.SortEntries<K, V[]>(comparator)));
    }


    public ILevel0MapOfListOperator<K, V> toMapOfList() {
        return forEachEntry().onValue().toList().endOn().endFor();
    }


    public <K2> ILevel0MapOfMapOperator<K, K2, V> toMapOfMap(final IEvaluator<K2, ? super V> keyEval) {
        return forEachEntry().onValue().toMap(keyEval).endOn().endFor();
    }


    public <K2, V2> ILevel0MapOfMapOperator<K, K2, V2> toMapOfMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return forEachEntry().onValue().toMap(mapBuild).endOn().endFor();
    }


    public ILevel0MapOfSetOperator<K, V> toMapOfSet() {
        return forEachEntry().onValue().toSet().endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, V[]> get() {
        return (Map<K,V[]>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V[]>> generic() {
        return new Level0GenericUniqOperator<Map<K, V[]>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K,V[]>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K,V[]>> eval) {
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


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V[]>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}
    
    
    
    
}
