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
package org.op4j.op.intf.operators.map;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;

import org.op4j.op.commands.ICall;
import org.op4j.op.commands.IEval;
import org.op4j.op.commands.IExec;
import org.op4j.op.intf.parameters.IConv;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.intf.qualities.ICallableOperator;
import org.op4j.op.intf.qualities.IConvertibleOperator;
import org.op4j.op.intf.qualities.IEvaluableOperator;
import org.op4j.op.intf.qualities.IExecutableOperator;
import org.op4j.op.intf.qualities.INavigatingMapEntryOperator;
import org.op4j.op.intf.qualities.ITypeParameterizableXOperator;
import org.op4j.op.intf.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2MapEntriesValueOperator<K,V>
		extends IUniqOperator<Map<K,V>>,
				INavigatingMapEntryOperator,
                ICallableOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
        		IConvertibleOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel1MapEntriesOperator<K,V> endOn();
    
    public <X> ILevel2MapEntriesValueOperator<K,X> call(final ICall<X,? super V> call);

    public ILevel2MapEntriesValueOperator<K,Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel2MapEntriesValueOperator<K,X> conv(final IConv<X,? super V> conv);
    
    public ILevel2MapEntriesValueOperator<K,Byte> convToByte(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Short> convToShort(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Integer> convToInteger(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Long> convToLong(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Float> convToFloat(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Double> convToDouble(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,BigInteger> convToBigInteger(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Boolean> convToBoolean(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Calendar> convToCalendar(final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,String> convToString(final Object... parameters);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEval<X,? super V> eval);

    public ILevel2MapEntriesValueOperator<K,Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel2MapEntriesValueOperator<K,String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IExec<X,? super V> exec);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> of(final IOf<X> of);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> of(final Class<X> classOf);
    
    public ILevel2MapEntriesValueOperator<K,?> raw();
    
    
}
