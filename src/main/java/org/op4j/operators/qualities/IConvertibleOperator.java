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

import org.op4j.executables.IConv;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IConvertibleOperator<T> {

    public <X> IConvertibleOperator<X> conv(final IConv<X,? super T> conv);
    
    public IConvertibleOperator<Byte> convToByte(final Object... parameters);
    public IConvertibleOperator<Short> convToShort(final Object... parameters);
    public IConvertibleOperator<Integer> convToInteger(final Object... parameters);
    public IConvertibleOperator<Long> convToLong(final Object... parameters);
    public IConvertibleOperator<Float> convToFloat(final Object... parameters);
    public IConvertibleOperator<Double> convToDouble(final Object... parameters);
    public IConvertibleOperator<BigInteger> convToBigInteger(final Object... parameters);
    public IConvertibleOperator<BigDecimal> convToBigDecimal(final Object... parameters);
    public IConvertibleOperator<Boolean> convToBoolean(final Object... parameters);
    public IConvertibleOperator<Calendar> convToCalendar(final Object... parameters);
    public IConvertibleOperator<String> convToString(final Object... parameters);
    
}
