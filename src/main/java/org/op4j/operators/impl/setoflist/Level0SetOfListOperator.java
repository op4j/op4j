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
package org.op4j.operators.impl.setoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
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
public class Level0SetOfListOperator<T> extends Operator
        implements ILevel0SetOfListOperator<T>  {

    
    public Level0SetOfListOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfListOperator<T> add(final List<T>... newElements) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.Add<List<T>>(newElements)));
    }


    public ILevel0SetOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, newElements)));
    }


    public ILevel0SetOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.AddAll<List<T>>(collection)));
    }


    public ILevel0SetOperator<T> flatten() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.FlattenSetOfLists<T>()));
    }


    public ILevel1SetOfListElementsOperator<T> forEach() {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetOfListElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1SetOfListElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel1SetOfListElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel1SetOfListElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1SetOfListElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1SetOfListElementsOperator<T> forEachSelected(final ISelector<List<T>> selector) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel1SetOfListElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1SetOfListElementsOperator<T> forEachNotNull() {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetOfListElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel1SetOfListElementsOperator<T> forEachNull() {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetOfListElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfListElementsOperator<T>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel0SetOfListOperator<X> of(final Type<X> of) {
        return new Level0SetOfListOperator<X>(getTarget());
    }


    public ILevel0SetOfListOperator<?> raw() {
        return new Level0SetOfListOperator<T>(getTarget());
    }


    public ILevel0SetOfListOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexes<List<T>>(indices)));
    }


    public ILevel0SetOfListOperator<T> removeEquals(final List<T>... values) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveEquals<List<T>>(values)));
    }


    public ILevel0SetOfListOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveMatching<List<T>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0SetOfListOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveMatching<List<T>>(eval)));
    }


    public ILevel0SetOfListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<List<T>>(eval)));
    }


    public ILevel0SetOfListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<List<T>>(eval)));
    }


    public ILevel0SetOfListOperator<T> removeSelected(final ISelector<List<T>> selector) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveSelected<List<T>>(selector)));
    }


    public ILevel0SetOfListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<List<T>>(indices)));
    }


    public ILevel0SetOfListOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<List<T>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0SetOfListOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<List<T>>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel0SetOfListOperator<T> removeNulls() {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.RemoveNulls<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOfListOperator<T> sort() {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel0SetOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListOperator<T>(getTarget().execute(new SetFuncs.SortByComparator<List<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onSet(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onSet(get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onSet(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return Op.onListOfArray(of, Op.onSet(forEach().toArray(of).get()).toList().get());
    }


    public ILevel0ListOfListOperator<T> toListOfList() {
        return Op.onListOfList(Op.onSet(get()).toList().get());
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(keyEval).get()).toList().get());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onListOfMap(Op.onSet(forEach().toMap(mapBuild).get()).toList().get());
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return Op.onListOfSet(Op.onSet(forEach().toSet().get()).toList().get());
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, forEach().toArray(of).get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(forEach().toSet().get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onSet(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return Op.onListOfMap(Op.onSet(forEach().toMap().get()).toList().get());
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return forEach().toMap().endFor();
    }


    @SuppressWarnings("unchecked")
    public Set<List<T>> get() {
        return (Set<List<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<List<T>>> generic() {
        return new Level0GenericUniqOperator<Set<List<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X, ? super Set<List<T>>> call) {
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

    

	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<List<T>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<List<T>>> eval) {
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


	public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<List<T>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
    
    
}
