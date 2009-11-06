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
package org.op4j.operators.intf.mapoflist;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.Of;
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.executables.functions.conversion.IConv;
import org.op4j.operators.qualities.ICallableOperator;
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
public interface ILevel3MapOfListEntriesValueElementsOperator<K,V>
		extends IUniqOperator<Map<K,List<V>>>,
		        INavigatingCollectionOperator<V>,
                ICallableOperator<V>,
        		IEvaluableOperator<V>,
        		IExecutableOperator<V>,
        		IConvertibleOperator<V>,
                ITypeParameterizableXOperator<V> {
    
    public ILevel2MapOfListEntriesValueOperator<K,V> endFor();
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> call(final ICall<X,? super V> call);

    public ILevel3MapOfListEntriesValueElementsOperator<K,Byte> callByte(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Short> callShort(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Integer> callInteger(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Long> callLong(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Float> callFloat(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Double> callDouble(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigInteger> callBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigDecimal> callBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Boolean> callBoolean(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Calendar> callCalendar(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,String> callString(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Character> callCharacter(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Number> callNumber(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Date> callDate(final String methodName, final Object... optionalParameters);

    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> conv(final IConv<X> conv);
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> convTo(final Type<X> resultType, final Object... parameters);
    
    public ILevel3MapOfListEntriesValueElementsOperator<K,Byte> convToByte(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Short> convToShort(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Integer> convToInteger(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Long> convToLong(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Float> convToFloat(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Double> convToDouble(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigInteger> convToBigInteger(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigDecimal> convToBigDecimal(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Boolean> convToBoolean(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Calendar> convToCalendar(final Object... parameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,String> convToString(final Object... parameters);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> eval(final IEval<X,? super V> eval);

    public ILevel3MapOfListEntriesValueElementsOperator<K,Byte> evalByte(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Short> evalShort(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Integer> evalInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Long> evalLong(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Float> evalFloat(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Double> evalDouble(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigInteger> evalBigInteger(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigDecimal> evalBigDecimal(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Boolean> evalBoolean(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Calendar> evalCalendar(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,String> evalString(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Character> evalCharacter(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Number> evalNumber(final String evalExpression, final Object... optionalArguments);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Date> evalDate(final String evalExpression, final Object... optionalArguments);


    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> exec(final IFunc<X,? super V> exec);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> of(final Of<X> of);
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> of(final Class<X> classOf);
    
    public ILevel3MapOfListEntriesValueElementsOperator<K,?> raw();
    
                                            
}
