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
import java.util.Map;

import org.op4j.IOf;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.qualities.ICallableOperator;
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
                ICallableOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
        		IConvertibleOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel3MapOfMapEntriesValueEntriesOperator<K1,K2,V> endOn();
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> call(final ICall<X,? super V> call);

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> conv(final IConv<X,? super V> conv);
    
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Byte> convToByte(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Short> convToShort(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Integer> convToInteger(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Long> convToLong(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Float> convToFloat(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Double> convToDouble(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigInteger> convToBigInteger(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Boolean> convToBoolean(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Calendar> convToCalendar(final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,String> convToString(final Object... parameters);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> eval(final IEval<X,? super V> eval);

    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> exec(final IFunc<X,? super V> exec);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> of(final IOf<X> of);
    
    public <X> ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,X> of(final Class<X> classOf);
    
    public ILevel4MapOfMapEntriesValueEntriesValueOperator<K1,K2,?> raw();
    
                                            
}
