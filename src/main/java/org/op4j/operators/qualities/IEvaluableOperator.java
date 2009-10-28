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

import org.op4j.executables.IEval;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IEvaluableOperator<T> {
    
    public <X> IEvaluableOperator<X> eval(final IEval<X,? super T> eval);
    
    public IEvaluableOperator<Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<String> evalString(final String evalExpression, final Object... optionalArguments);
    
}
