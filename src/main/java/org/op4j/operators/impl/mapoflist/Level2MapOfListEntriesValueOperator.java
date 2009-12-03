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
package org.op4j.operators.impl.mapoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperator;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
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
public class Level2MapOfListEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfListEntriesValueOperator<K,V> {

    
    public Level2MapOfListEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }

    public ILevel2MapOfListEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfListEntriesValueOperator<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public ILevel1MapOfListEntriesOperator<K, V> endOn() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachSelected(final ISelector<V> selector) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel2MapOfListEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapOfListEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel2MapOfListEntriesValueOperator<K, ?> raw() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget());
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeIndexes(final int... indices) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveIndexes<V>(indices)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeEquals(final V... values) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveEquals<V>(values)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveMatching<V>(eval)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeSelected(final ISelector<V> selector) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveIndexesNot<V>(indices)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNulls<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel2MapOfListEntriesValueOperator<K, V> sort() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(of, getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperator<K, V, V>(getTarget().execute(new ToMap.FromListByAlternateElements<V>()));
    }


    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V>(getTarget().execute(new ToMap.FromListByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V2>(getTarget().execute(new ToMap.FromListByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new ToSet.FromCollection<V>()));
    }


    public Map<K, List<V>> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
	public <X> ILevel2MapEntriesValueOperator<K,X> convert(final IConverter<X, ? super List<V>> converter) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(converter));
	}


    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEvaluator<X, ? super List<V>> eval) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(eval));
    }


    public ILevel2MapEntriesValueOperator<K,BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel2MapEntriesValueOperator<K,X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel2MapEntriesValueOperator<K,String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level2MapEntriesValueOperator<K,Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }


	public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super List<V>> function) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(function));
	}

    
    
    
}
