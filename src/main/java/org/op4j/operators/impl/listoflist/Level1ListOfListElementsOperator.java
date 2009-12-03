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
package org.op4j.operators.impl.listoflist;

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
import org.op4j.operators.impl.list.Level1ListElementsOperator;
import org.op4j.operators.impl.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
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
public class Level1ListOfListElementsOperator<T> extends Operator
        implements ILevel1ListOfListElementsOperator<T>  {

    
    public Level1ListOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfListElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public ILevel1ListOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1ListOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel1ListOfListElementsOperator<T> distinct() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public ILevel0ListOfListOperator<T> endFor() {
        return new Level0ListOfListOperator<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEach() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel2ListOfListElementsElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(eval));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterate(selector));
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2ListOfListElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel2ListOfListElementsElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ListOfListElementsElementsOperator<T>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1ListOfListElementsOperator<X> of(final Type<X> of) {
        return new Level1ListOfListElementsOperator<X>(getTarget());
    }


    public ILevel1ListOfListElementsOperator<?> raw() {
        return new Level1ListOfListElementsOperator<T>(getTarget());
    }


    public ILevel1ListOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1ListOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1ListOfListElementsOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1ListOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel1ListOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ListOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ListOfListElementsOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel1ListOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1ListOfListElementsOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1ListOfListElementsOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1ListOfListElementsOperator<T> removeNulls() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ListOfListElementsOperator<T> sort() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel1ListOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1ListOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ListOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    
    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


    
    
    
    
    
    
    
	public <X> ILevel1ListElementsOperator<X> call(final IMethodCaller<X, ? super List<T>> call) {
        return new Level1ListElementsOperator<X>(getTarget().execute(call));
	}


    public ILevel1ListElementsOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel1ListElementsOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel1ListElementsOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }

    

	public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super List<T>> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super List<T>> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel1ListElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel1ListElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel1ListElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel1ListElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level1ListElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }


	public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
	}

    
    
}
