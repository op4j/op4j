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
package org.op4j.operators.intf.map;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.qualities.ICallableOperator;
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
public interface ILevel2MapEntriesValueOperator<K,V>
		extends IUniqOperator<Map<K,V>>,
				INavigatingMapEntryOperator,
                ICallableOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel1MapEntriesOperator<K,V> endOn();
    
    public <X> ILevel2MapEntriesValueOperator<K,X> call(final ICall<X,? super V> call);

    public ILevel2MapEntriesValueOperator<K,Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel2MapEntriesValueOperator<K,Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
    public <X> ILevel2MapEntriesValueOperator<K,X> eval(final IEval<X,? super V> eval);

    public ILevel2MapEntriesValueOperator<K,Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel2MapEntriesValueOperator<K,Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel2MapEntriesValueOperator<K,X> exec(final IFunc<X,? super V> exec);
    
    public <X> ILevel2MapEntriesValueOperator<K,X> of(final Type<X> of);
    
        
    public ILevel2MapEntriesValueOperator<K,?> raw();
    
    
}
