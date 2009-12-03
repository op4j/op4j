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
package org.op4j.operators.intf.mapofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingMapEntryOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,V>
		extends IUniqOperator<Map<K1,Map<K2,V>>>,
				INavigatingMapEntryOperator,
                IConvertibleOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> endOn();
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> convert(final IConverter<X,? super V> converter);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> eval(final IEvaluator<X,? super V> eval);

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,?> evalForObject(final String ognlExpression, final Object... optionalExpParams);
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Byte> evalForByte(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Short> evalForShort(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Integer> evalForInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Long> evalForLong(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Float> evalForFloat(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Double> evalForDouble(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigInteger> evalForBigInteger(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Boolean> evalForBoolean(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Calendar> evalForCalendar(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,String> evalForString(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Character> evalForCharacter(final String ognlExpression, final Object... optionalExpParams);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Date> evalForDate(final String ognlExpression, final Object... optionalExpParams);


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> exec(final IFunction<X, ? super V> function);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> of(final Type<X> of);
    
        
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,?> raw();
    
                                            
}
