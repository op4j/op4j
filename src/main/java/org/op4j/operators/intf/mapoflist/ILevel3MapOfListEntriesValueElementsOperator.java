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
import org.op4j.executables.ICall;
import org.op4j.executables.IEval;
import org.op4j.executables.functions.IFunc;
import org.op4j.operators.qualities.ICallableOperator;
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
                ITypeParameterizableXOperator<V> {
    
    public ILevel2MapOfListEntriesValueOperator<K,V> endFor();
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> call(final ICall<X,? super V> call);

    public ILevel3MapOfListEntriesValueElementsOperator<K,Byte> callForByte(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Short> callForShort(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Integer> callForInteger(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Long> callForLong(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Float> callForFloat(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Double> callForDouble(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Boolean> callForBoolean(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Calendar> callForCalendar(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,String> callForString(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Character> callForCharacter(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Number> callForNumber(final String methodName, final Object... optionalParameters);
    public ILevel3MapOfListEntriesValueElementsOperator<K,Date> callForDate(final String methodName, final Object... optionalParameters);

    
    
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
    
    public <X> ILevel3MapOfListEntriesValueElementsOperator<K,X> of(final Type<X> of);
    
        
    public ILevel3MapOfListEntriesValueElementsOperator<K,?> raw();
    
                                            
}
