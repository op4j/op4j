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
package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.OperationChainingTarget;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfMapOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl
        implements Level0MapOfMapOperator<K1,K2,V,I> {

    
    public Level0MapOfMapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOperator<K1,I> extractKeys() {
        return new Level0SetOperatorImpl<K1,I>(getTarget().execute(new MapFuncs.ExtractKeys<K1, Map<K2, V>>()));
    }


    public Level0ListOfMapOperator<K2, V,I> extractValues() {
        return new Level0ListOfMapOperatorImpl<K2, V,I>(getTarget().execute(new MapFuncs.ExtractValues<K1, Map<K2, V>>()));
    }


    public Level1MapOfMapEntriesOperator<K1, K2, V,I> forEachEntry() {
        return new Level1MapOfMapEntriesOperatorImpl<K1, K2, V,I>(getTarget().iterate());
    }






    public Level0MapOfMapOperator<K1, K2, V,I> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.Put<K1, Map<K2,V>>(newKey, NormalizationUtils.normalizeMap(newValue))));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.Insert<K1, Map<K2,V>>(position, newKey, NormalizationUtils.normalizeMap(newValue))));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> putAll(final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.PutAll<K1, Map<K2,V>>(NormalizationUtils.normalizeMapOfMap(map))));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> insertAll(final int position, final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.InsertAll<K1, Map<K2,V>>(position, NormalizationUtils.normalizeMapOfMap(map))));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> removeAllKeys(final K1... keys) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K1, Map<K2,V>>(keys)));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K1, Map<K2,V>>(eval)));
    }

    public Level0MapOfMapOperator<K1, K2, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K1, Map<K2,V>>(eval)));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> removeAllKeysNot(final K1... keys) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K1, Map<K2,V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level0MapOfMapOperator<K1, K2, V,I> sort() {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public Level0MapOfMapOperator<K1, K2, V,I> sort(final Comparator<? super Entry<K1, Map<K2, V>>> comparator) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K1, Map<K2, V>> get() {
        return (Map<K1,Map<K2,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K1, Map<K2, V>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K1, Map<K2, V>>,I>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X1,X2,Y> Level0MapOfMapOperator<X1,X2,Y,I> asMapOfMapOf(final Type<X1> key1Type, final Type<X2> key2Type, final Type<Y> valueType) {
        return generic().asMapOfMapOf(key1Type, key2Type, valueType);
    }


    public Level0MapOfMapOperator<?,?,?,I> asMapOfMapOfUnknown() {
        return asMapOfMapOf(Types.OBJECT, Types.OBJECT, Types.OBJECT);
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifIndex(final int... indices) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndex(indices));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifIndexNot(final int... indices) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifNotNull() {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNull());
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifNull() {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNull());
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0MapOfMapSelectedOperator<K1, K2, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapSelectedOperatorImpl<K1, K2, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X1, X2, Y> Level0MapOfMapOperator<X1, X2, Y,I> convert(final IConverter<? extends Map<X1, ? extends Map<X2, Y>>, ? super Map<K1, Map<K2, V>>> converter) {
        return new Level0MapOfMapOperatorImpl<X1, X2, Y,I>(getTarget().execute(converter, Normalization.MAP_OF_MAP));
    }


    public <X1, X2, Y> Level0MapOfMapOperator<X1, X2, Y,I> eval(final IEvaluator<? extends Map<X1, ? extends Map<X2, Y>>, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0MapOfMapOperatorImpl<X1, X2, Y,I>(getTarget().execute(eval, Normalization.MAP_OF_MAP));
    }


    public <X1, X2, Y> Level0MapOfMapOperator<X1, X2, Y,I> exec(final IFunction<? extends Map<X1, ? extends Map<X2, Y>>, ? super Map<K1, Map<K2, V>>> function) {
        return new Level0MapOfMapOperatorImpl<X1, X2, Y,I>(getTarget().execute(function, Normalization.MAP_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K1, Map<K2, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K1, Map<K2, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K1, Map<K2, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> replaceWith(final Map<K1, Map<K2, V>> replacement) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V,I>(getTarget().replaceWith(replacement));
    }


    public Level0MapOfMapOperator<K1, K2, V,I> replaceIfNullWith(final Map<K1, Map<K2, V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K1, Map<K2, V>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        return new Operation<Map<K1, Map<K2, V>>, I>((OperationChainingTarget) target);
    }

    

    
}
