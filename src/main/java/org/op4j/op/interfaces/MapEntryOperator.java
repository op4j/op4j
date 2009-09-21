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
package org.op4j.op.interfaces;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Map;

import org.op4j.type.Type;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface MapEntryOperator<K,V> 
        extends Operator<Map.Entry<K,V>>, ShapeableAsGenericOperator<Map.Entry<K,V>> {

    
    public MapEntryOperator<?,?> raw();
    
    public MapEntryOperator<K,?> toOnValue(
            final Type resultType, final Object... parameters);
    public MapEntryOperator<K,?> toOnValue(
            final String resultTypeName, final Object... parameters);
    public <X> MapEntryOperator<K,X> toOnValue(
            final Class<X> resultClass, final Object... parameters);
    
    public MapEntryOperator<K,Byte> toByteOnValue(final Object... parameters);
    public MapEntryOperator<K,Short> toShortOnValue(final Object... parameters);
    public MapEntryOperator<K,Integer> toIntegerOnValue(final Object... parameters);
    public MapEntryOperator<K,Long> toLongOnValue(final Object... parameters);
    public MapEntryOperator<K,Float> toFloatOnValue(final Object... parameters);
    public MapEntryOperator<K,Double> toDoubleOnValue(final Object... parameters);
    public MapEntryOperator<K,BigInteger> toBigIntegerOnValue(final Object... parameters);
    public MapEntryOperator<K,BigDecimal> toBigDecimalOnValue(final Object... parameters);
    public MapEntryOperator<K,Boolean> toBooleanOnValue(final Object... parameters);
    public MapEntryOperator<K,Calendar> toCalendarOnValue(final Object... parameters);
    public MapEntryOperator<K,String> toStrOnValue(final Object... parameters);
    

    public <X,Y> MapEntryOperator<X,Y> asMapEntry(final Class<X> keyClass, final Class<Y> valueClass);
    
    public MapEntryOperator<K,V> castMapEntry(final String keyTypeName, final String valueTypeName);
    public MapEntryOperator<K,V> castMapEntry(final Type keyType, final Type valueType);
    
    public MapEntryOperator<K,?> evalOnValue(
            final String expression, final Object... optionalExpParams);
    public <X> MapEntryOperator<K,X> evalOnValue(
            final Class<X> resultClass, final String expression, final Object... optionalExpParams);
    public MapEntryOperator<K,?> evalOnValue(
            final Evaluator<V,Object> evaluator);
    public <X> MapEntryOperator<K,X> evalOnValue(
            final Class<X> resultClass, final Evaluator<V,X> evaluator);

    
    public MapEntryOperator<K,?> execUniqOnValue(
            final String operationName, final Object... parameters);
    public <X> MapEntryOperator<K,X> execUniqOnValue(
            final Class<X> resultClass, final String operationName, final Object... parameters);

    
    public MapEntryOperator<K,?> callOnValue(final String methodName, final Object... arguments);
    public <X> MapEntryOperator<K,X> callOnValue(final Class<X> returnClass, final String methodName, final Object... arguments);
    
    
    public GenericUniqTargetOperator<Map.Entry<K,V>> generic();

    
}
