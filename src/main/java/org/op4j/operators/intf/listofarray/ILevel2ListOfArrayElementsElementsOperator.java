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
package org.op4j.operators.intf.listofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2ListOfArrayElementsElementsOperator<T> 
		extends IUniqOperator<List<T[]>>,
                INavigatingCollectionOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfArrayElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public ILevel2ListOfArrayElementsElementsOperator<?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel2ListOfArrayElementsElementsOperator<Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel2ListOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2ListOfArrayElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ListOfArrayElementsElementsOperator<?> raw();
    
                                    
}
