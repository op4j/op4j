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

import org.op4j.IOf;
import org.op4j.commands.Call;
import org.op4j.commands.Eval;
import org.op4j.commands.ICall;
import org.op4j.commands.IConv;
import org.op4j.commands.IEval;
import org.op4j.commands.IExec;
import org.op4j.commands.IMapBuild;
import org.op4j.commands.ISelect;
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


    public ILevel0GenericMultiOperator<T> add(T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> add(int position, T newElement) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> addAll(T... newElements) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> addAll(Collection<T> collection) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOperator<X> buildArray(IOf<X> arrayOf) {
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
            IEval<K, ? super T> keyEval, IOf<X> valueArrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(
            IMapBuild<K, V, ? super T> mapBuild, IOf<V> valueArrayOf) {
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
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Call.aByteMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Short> callShort(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Call.aShortMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Integer> callInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Call.aIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Long> callLong(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Call.aLongMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Float> callFloat(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Call.aFloatMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Double> callDouble(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Call.aDoubleMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Call.aBigIntegerMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Call.aBigDecimalMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Call.aBooleanMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Call.aCalendarMethod(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<String> callString(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Call.aStringMethod(methodName, optionalParameters)));
    }




    public ILevel0MapOfListOperator<?, ?> casstAsMapOfList() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfArrayOperator<?> castAsArrayOfArray() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(IOf<X> of) {
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


    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(IOf<X> of) {
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
            IOf<K> keyOf, IOf<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ArrayOfSetOperator<?> castAsArrayOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(IOf<X> of) {
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


    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(IOf<X> of) {
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


    public <X> ILevel0ListOfListOperator<X> castAsListOfList(IOf<X> of) {
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


    public <K, V> ILevel0ListOfMapOperator<K, V> castAsListOfMap(IOf<K> keyOf,
            IOf<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfSetOperator<?> castAsListOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(IOf<X> of) {
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
            IOf<K> keyOf, IOf<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> castAsMapOfArray(
            Class<K> keyOf, Class<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K, V> ILevel0MapOfListOperator<K, V> castAsMapOfList(IOf<K> keyOf,
            IOf<V> valueOf) {
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
            IOf<K1> key1Of, IOf<K2> key2Of, IOf<V> valueOf) {
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


    public <K, V> ILevel0MapOfSetOperator<K, V> castAsMapOfSet(IOf<K> keyOf,
            IOf<V> valueOf) {
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


    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(IOf<X> of) {
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


    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(IOf<X> of) {
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


    public <K, V> ILevel0SetOfMapOperator<K, V> castAsSetOfMap(IOf<K> keyOf,
            IOf<V> valueOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOfSetOperator<?> castAsSetOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(Class<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericUniqOperator<X> conv(IConv<X, ? super T> conv) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<BigDecimal> convToBigDecimal(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<BigInteger> convToBigInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Boolean> convToBoolean(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Byte> convToByte(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Calendar> convToCalendar(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Double> convToDouble(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Float> convToFloat(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Integer> convToInteger(
            Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Long> convToLong(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<Short> convToShort(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<String> convToString(Object... parameters) {
        // TODO Auto-generated method stub
        return null;
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


    public <X> ILevel0GenericUniqOperator<X> exec(final IExec<X, ? super T> exec) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(exec));
    }


    public <X> ILevel0GenericUniqOperator<X> of(IOf<X> of) {
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


    public ILevel0GenericMultiOperator<T> remove(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> remove(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> removeAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public T get() {
        // TODO Auto-generated method stub
        return null;
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