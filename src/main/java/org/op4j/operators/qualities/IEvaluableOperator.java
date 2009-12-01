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

import org.op4j.functions.evaluators.IEvaluator;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IEvaluableOperator<T> {
    
    public <X> IEvaluableOperator<X> eval(final IEvaluator<X,? super T> eval);
    
    public IEvaluableOperator<Byte> evalForByte(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Character> evalForCharacter(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Short> evalForShort(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Integer> evalForInteger(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Number> evalForNumber(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Long> evalForLong(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Float> evalForFloat(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Double> evalForDouble(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<BigInteger> evalForBigInteger(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<BigDecimal> evalForBigDecimal(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Boolean> evalForBoolean(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Date> evalForDate(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<Calendar> evalForCalendar(final String evalExpression, final Object... optionalArguments);
    public IEvaluableOperator<String> evalForString(final String evalExpression, final Object... optionalArguments);
    
}
