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
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericMultiOperator<T> extends Operator
        implements ILevel0GenericMultiOperator<T>  {

    
    public Level0GenericMultiOperator(final Target target) {
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


    public ILevel0MapOperator<T, T> buildMap() {
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


    public <X> ILevel0MapOfArrayOperator<X, X> buildMapOfArray(IOf<X> arrayOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0MapOfArrayOperator<X, X> buildMapOfArray(
            Class<X> arrayOfClass) {
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


    public ILevel0MapOfListOperator<T, T> buildMapOfList() {
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


    public ILevel0MapOfSetOperator<T, T> buildMapOfSet() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<T> buildSet() {
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


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunc<X, ? super T> exec) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(exec));
    }


    public ILevel0GenericUniqOperator<T> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericUniqOperator<T> extract(T value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAll(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAll(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAll(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAllBut(int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAllBut(T... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<T> extractAllBut(ISelect<T> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericMultiOperator<X> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel0GenericMultiOperator<X> of(Class<X> ofClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0GenericMultiOperator<?> raw() {
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


    public ILevel0GenericUniqOperator<T> uniq() {
        // TODO Auto-generated method stub
        return null;
    }


    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

}
