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
package org.op4j.operators.intf.listofmap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.op4j.IOf;
import org.op4j.commands.ICall;
import org.op4j.commands.IConv;
import org.op4j.commands.IEval;
import org.op4j.commands.IExec;
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
public interface ILevel3ListOfMapElementsEntriesValueOperator<K,V> 
		extends IUniqOperator<List<Map<K,V>>>,
				INavigatingMapEntryOperator,
                ICallableOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
        		IConvertibleOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel2ListOfMapElementsEntriesOperator<K,V> endOn();
    
    public <X> ILevel3ListOfMapElementsEntriesValueOperator<K,X> call(final ICall<X,? super V> call);

    public ILevel3ListOfMapElementsEntriesValueOperator<K,Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,String> callString(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel3ListOfMapElementsEntriesValueOperator<K,X> conv(final IConv<X,? super V> conv);
    
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Byte> convToByte(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Short> convToShort(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Integer> convToInteger(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Long> convToLong(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Float> convToFloat(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Double> convToDouble(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,BigInteger> convToBigInteger(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Boolean> convToBoolean(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Calendar> convToCalendar(final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,String> convToString(final Object... parameters);
    
    public <X> ILevel3ListOfMapElementsEntriesValueOperator<K,X> eval(final IEval<X,? super V> eval);

    public ILevel3ListOfMapElementsEntriesValueOperator<K,Byte> evalByte(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Short> evalShort(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Integer> evalInteger(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Long> evalLong(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Float> evalFloat(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Double> evalDouble(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,BigInteger> evalBigInteger(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,BigDecimal> evalBigDecimal(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Boolean> evalBoolean(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,Calendar> evalCalendar(final String evalExpression, final Object... parameters);
    public ILevel3ListOfMapElementsEntriesValueOperator<K,String> evalString(final String evalExpression, final Object... parameters);


    public <X> ILevel3ListOfMapElementsEntriesValueOperator<K,X> exec(final IExec<X,? super V> exec);
    
    public <X> ILevel3ListOfMapElementsEntriesValueOperator<K,X> of(final IOf<X> of);
    
    public <X> ILevel3ListOfMapElementsEntriesValueOperator<K,X> of(final Class<X> classOf);
    
    public ILevel3ListOfMapElementsEntriesValueOperator<K,?> raw();
    
                                            
}
