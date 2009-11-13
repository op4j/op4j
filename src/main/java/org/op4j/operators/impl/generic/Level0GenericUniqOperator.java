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
package org.op4j.operators.impl.generic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Of;
import org.op4j.executables.Call;
import org.op4j.executables.Eval;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.builtin.GenericFunc;
import org.op4j.executables.functions.conversion.Conv;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericUniqOperator<T> extends Operator
        implements ILevel0GenericUniqOperator<T>  {

    
    public Level0GenericUniqOperator(final Target target) {
        super(target);
    }


    public ILevel0GenericMultiOperator<T> deleteBBC(final int position, final T newElement) {
        // TODO Auto-generated method stub
        return null;
    }

    public ILevel0GenericMultiOperator<T> add(final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(GenericFunc.uniqAddAllValues(newElements)));
    }

    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOperator<X> buildArray(Of<X> arrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOperator<X> buildArray(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOperator<T> buildList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel0MapOperator<K, T> buildMap(IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOperator<K, V> buildMap(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, X> ILevel0MapOfArrayOperator<K, X> buildMapOfArray(
            IEval<K, ? super T> keyEval, Of<X> valueArrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(
            IMapBuild<K, V, ? super T> mapBuild, Of<V> valueArrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, X> ILevel0MapOfArrayOperator<K, X> buildMapOfArray(
            IEval<K, ? super T> keyEval, Class<X> valueArrayOfClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(
            IMapBuild<K, V, ? super T> mapBuild, Class<V> valueArrayOfClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel0MapOfListOperator<K, T> buildMapOfList(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfListOperator<K, V> buildMapOfList(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K> ILevel0MapOfSetOperator<K, T> buildMapOfSet(
            IEval<K, ? super T> keyEval) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> buildMapOfSet(
            IMapBuild<K, V, ? super T> mapBuild) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> buildSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericUniqOperator<X> call(final ICall<X, ? super T> call) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(call));
    }

    public ILevel0GenericUniqOperator<Byte> callByte(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Call.byteMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Call.shortMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Call.integerMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Call.longMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Call.floatMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Call.doubleMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Call.bigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Call.bigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Call.booleanMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Call.calendarMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Call.stringMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Character> callCharacter(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Call.characterMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Number> callNumber(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Number>(getTarget().execute(Call.numberMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Date> callDate(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Call.dateMethod(methodName, optionalParameters)));
    }




    public ILevel0MapOfListOperator<?, ?> casstAsMapOfList() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<?> castAsArrayOfArray() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfListOperator<?> castAsArrayOfList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfMapOperator<?, ?> castAsArrayOfMap() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> castAsArrayOfMap(
            Of<K> keyOf, Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<?> castAsArrayOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<?> castAsListOfArray() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfListOperator<?> castAsListOfList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfListOperator<X> castAsListOfList(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfListOperator<X> castAsListOfList(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfMapOperator<?, ?> castAsListOfMap() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> castAsListOfMap(Of<K> keyOf,
            Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfSetOperator<?> castAsListOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<?, ?> castAsMapOfArray() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> castAsMapOfArray(
            Of<K> keyOf, Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> castAsMapOfArray(
            Class<K> keyOf, Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfListOperator<K, V> castAsMapOfList(Of<K> keyOf,
            Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfListOperator<K, V> castAsMapOfList(
            Class<K> keyOf, Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfMapOperator<?, ?, ?> castAsMapOfMap() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K1, K2, V> ILevel0MapOfMapOperator<K1, K2, V> castAsMapOfMap(
            Of<K1> key1Of, Of<K2> key2Of, Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K1, K2, V> ILevel0MapOfMapOperator<K1, K2, V> castAsMapOfMap(
            Class<K1> key1Of, Class<K2> key2Of, Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfSetOperator<?, ?> castAsMapOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> castAsMapOfSet(Of<K> keyOf,
            Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> castAsMapOfSet(Class<K> keyOf,
            Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfArrayOperator<?> castAsSetOfArray() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfListOperator<?> castAsSetOfList() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfMapOperator<?, ?> castAsSetOfMap() {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> castAsSetOfMap(Of<K> keyOf,
            Of<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<?> castAsSetOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericUniqOperator<X> conv(final IConv<X> conv) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(conv));
    }

    public <X> ILevel0GenericUniqOperator<X> convTo(final Type<X> resultType, final Object... parameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Conv.to(resultType, parameters)));
    }

    public ILevel0GenericUniqOperator<BigDecimal> convToBigDecimal(final Object... parameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Conv.to(Types.BIG_DECIMAL, parameters)));
    }


    public ILevel0GenericUniqOperator<BigInteger> convToBigInteger(final Object... parameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Conv.to(Types.BIG_INTEGER, parameters)));
    }


    public ILevel0GenericUniqOperator<Boolean> convToBoolean(final Object... parameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Conv.to(Types.BOOLEAN, parameters)));
    }


    public ILevel0GenericUniqOperator<Byte> convToByte(final Object... parameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Conv.to(Types.BYTE, parameters)));
    }


    public ILevel0GenericUniqOperator<Calendar> convToCalendar(final Object... parameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Conv.to(Types.CALENDAR, parameters)));
    }


    public ILevel0GenericUniqOperator<Double> convToDouble(final Object... parameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Conv.to(Types.DOUBLE, parameters)));
    }


    public ILevel0GenericUniqOperator<Float> convToFloat(final Object... parameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Conv.to(Types.FLOAT, parameters)));
    }


    public ILevel0GenericUniqOperator<Integer> convToInteger(final Object... parameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Conv.to(Types.INTEGER, parameters)));
    }


    public ILevel0GenericUniqOperator<Long> convToLong(final Object... parameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Conv.to(Types.LONG, parameters)));
    }


    public ILevel0GenericUniqOperator<Short> convToShort(final Object... parameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Conv.to(Types.SHORT, parameters)));
    }


    public ILevel0GenericUniqOperator<String> convToString(final Object... parameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Conv.to(Types.STRING, parameters)));
    }

    
    public ILevel0GenericUniqOperator<Character> convToCharacter(final Object... parameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Conv.to(Types.CHARACTER, parameters)));
    }

    
    public ILevel0GenericUniqOperator<Number> convToNumber(final Object... parameters) {
        return new Level0GenericUniqOperator<Number>(getTarget().execute(Conv.to(Types.NUMBER, parameters)));
    }

    
    public ILevel0GenericUniqOperator<Date> convToDate(final Object... parameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Conv.to(Types.DATE, parameters)));
    }


    public <X> ILevel0GenericUniqOperator<X> eval(final IEval<X, ? super T> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public ILevel0GenericUniqOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Eval.bigDecimalExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Eval.bigIntegerExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Boolean> evalBoolean(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Eval.booleanExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Byte> evalByte(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Eval.byteExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Calendar> evalCalendar(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Eval.calendarExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Double> evalDouble(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Eval.doubleExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Float> evalFloat(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Eval.floatExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Integer> evalInteger(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Eval.integerExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Long> evalLong(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Eval.longExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Short> evalShort(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Eval.shortExp(evalExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<String> evalString(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Eval.stringExp(evalExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Character> evalCharacter(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Eval.characterExp(evalExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Number> evalNumber(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Number>(getTarget().execute(Eval.numberExp(evalExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Date> evalDate(final String evalExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Eval.dateExp(evalExpression, parameters)));
    }




    public <X> ILevel0GenericUniqOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel0GenericUniqOperator<X> of(Of<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericUniqOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<?> raw() {
        // TODO Auto-generated method stub
        return null;
    }







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> castAsArrayOfMap(
            Class<K> keyOf, Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> castAsListOfMap(
            Class<K> keyOf, Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> castAsSetOfMap(Class<K> keyOf,
            Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }

}
