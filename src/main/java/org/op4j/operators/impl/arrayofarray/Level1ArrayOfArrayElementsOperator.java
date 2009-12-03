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
package org.op4j.operators.impl.arrayofarray;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
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
import org.op4j.operators.impl.array.Level1ArrayElementsOperator;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel2ArrayOfArrayElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
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
public class Level1ArrayOfArrayElementsOperator<T> extends Operator
        implements ILevel1ArrayOfArrayElementsOperator<T> {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ArrayOfArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1ArrayOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> distinct() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


	public ILevel0ArrayOfArrayOperator<T> endFor() {
    	final Class<?> ofComponentClass = this.arrayOf.getRawClass();
    	final Class<?> ofOfComponentClass = Array.newInstance(ofComponentClass,0).getClass();
        return new Level0ArrayOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY, ofOfComponentClass));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2ArrayOfArrayElementsElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2ArrayOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1ArrayOfArrayElementsOperator<X> of(final Type<X> of) {
        return new Level1ArrayOfArrayElementsOperator<X>(of, getTarget());
    }


    public ILevel1ArrayOfArrayElementsOperator<?> raw() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public ILevel1ArrayOfArrayElementsOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }

    public ILevel1ArrayOfArrayElementsOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> removeNulls() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfArrayElementsOperator<T> sort() {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1ArrayOfListElementsOperator<T> toList() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public ILevel1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> ILevel1ArrayOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> toSet() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public T[][] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel1ArrayElementsOperator<X> call(final IMethodCaller<X, ? super T[]> call) {
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

    

	public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X, ? super T[]> converter) {
        return new Level1ArrayElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
	}


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super T[]> eval) {
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


	public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level1ArrayElementsOperator<X>(function.getResultType(), getTarget().execute(function));
	}

    
    
    
    
    
}
