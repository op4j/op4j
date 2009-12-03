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
package org.op4j.operators.impl.mapofset;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperator;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel3MapOfSetEntriesValueElementsOperator;
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
public class Level2MapOfSetEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfSetEntriesValueOperator<K,V> {

    
    public Level2MapOfSetEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> endOn() {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachSelected(final ISelector<V> selector) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel2MapOfSetEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapOfSetEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel2MapOfSetEntriesValueOperator<K, ?> raw() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget());
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeIndexes(final int... indices) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveIndexes<V>(indices)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeEquals(final V... values) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveEquals<V>(values)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveMatching<V>(eval)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeSelected(final ISelector<V> selector) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveIndexesNot<V>(indices)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNulls<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel2MapOfSetEntriesValueOperator<K, V> sort() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(of, getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ToList.FromCollection<V>()));
    }


    public ILevel2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperator<K, V, V>(getTarget().execute(new ToMap.FromSetByAlternateElements<V>()));
    }

    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V>(getTarget().execute(new ToMap.FromSetByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V2>(getTarget().execute(new ToMap.FromSetByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Map<K, Set<V>> get() {
        return endOn().endFor().get();
    }


    
    
    
    
    
    
    
	public <X> ILevel2MapEntriesValueOperator<K,X> call(final IMethodCaller<X, ? super Set<V>> call) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(call));
	}


    public ILevel2MapEntriesValueOperator<K,?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel2MapEntriesValueOperator<K,X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel2MapEntriesValueOperator<K,Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level2MapEntriesValueOperator<K,Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }

    

	public <X> ILevel2MapEntriesValueOperator<K,X> convert(final IConverter<X, ? super Set<V>> converter) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(converter));
	}


    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEvaluator<X, ? super Set<V>> eval) {
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


	public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super Set<V>> function) {
        return new Level2MapEntriesValueOperator<K,X>(getTarget().execute(function));
	}

    
    
    
    
}
