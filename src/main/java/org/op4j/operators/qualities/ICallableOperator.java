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
package org.op4j.operators.qualities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;

import org.op4j.functions.methodcallers.IMethodCaller;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ICallableOperator<T> {
    
    public <X> ICallableOperator<X> call(final IMethodCaller<X,? super T> call);

    public ICallableOperator<Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Short> callForShort(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Long> callForLong(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ICallableOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ICallableOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ICallableOperator<String> callForString(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Date> callForDate(final String methodName, final Object... optionalParameters);

    
}
