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
package org.op4j.op.intf.qualities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import org.op4j.op.commands.ICall;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ICallableOperator<T> {
    
    public <X> ICallableOperator<X> call(final ICall<X,? super T> call);

    public ICallableOperator<Byte> callByte(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Short> callShort(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Long> callLong(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Float> callFloat(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Double> callDouble(final String methodName, final Object... optionalParameters);
    public ICallableOperator<BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ICallableOperator<BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ICallableOperator<Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ICallableOperator<String> callString(final String methodName, final Object... optionalParameters);

    
}
