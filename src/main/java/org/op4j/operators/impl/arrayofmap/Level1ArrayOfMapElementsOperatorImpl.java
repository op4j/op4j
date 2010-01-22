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
package org.op4j.operators.impl.arrayofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level1ArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperatorImpl;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfMapElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level1ArrayOfMapElementsOperator<K,V,I>  {

    
    public Level1ArrayOfMapElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfMapOperator<K, V,I> endFor() {
        return new Level0ArrayOfMapOperatorImpl<K, V,I>(getTarget().endIterate(Structure.ARRAY, Map.class));
    }


    public Level1ArrayOfSetElementsOperator<K,I> extractKeys() {
        return new Level1ArrayOfSetElementsOperatorImpl<K,I>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level1ArrayOfListElementsOperator<V,I> extractValues() {
        return new Level1ArrayOfListElementsOperatorImpl<V,I>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level2ArrayOfMapElementsEntriesOperator<K, V,I> forEachEntry() {
        return new Level2ArrayOfMapElementsEntriesOperatorImpl<K, V,I>(getTarget().iterate());
    }








    public Level1ArrayOfMapElementsOperator<K, V,I> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> putAll(final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> insertAll(final int position, final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> removeAllKeys(final K... keys) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, V>(keys)));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, V>(eval)));
    }

    public Level1ArrayOfMapElementsOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, V>(eval)));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> removeAllKeysNot(final K... keys) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public Level1ArrayOfMapElementsOperator<K, V,I> sort() {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Map<K, V>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X,Y> Level1ArrayOfMapElementsOperator<X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return endFor().asArrayOfMapOf(keyType, valueType).forEach();
    }


    public Level1ArrayOfMapElementsOperator<?,?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifNotNull() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifNull() {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfMapElementsSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level1ArrayOfMapElementsOperator<X, Y,I> convert(final IConverter<? extends Map<X, Y>, ? super Map<K, V>> converter) {
        return new Level1ArrayOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public <X, Y> Level1ArrayOfMapElementsOperator<X, Y,I> eval(final IEvaluator<? extends Map<X, Y>, ? super Map<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public <X, Y> Level1ArrayOfMapElementsOperator<X, Y,I> exec(final IFunction<? extends Map<X, Y>, ? super Map<K, V>> function) {
        return new Level1ArrayOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAP));
    }


    public <X> Level1ArrayElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, V>> converter) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, V>> eval) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, V>> function) {
        return new Level1ArrayElementsOperatorImpl<X,I>(resultType, getTarget().execute(function, Normalization.NONE));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> replaceWith(final Map<K, V> replacement) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level1ArrayOfMapElementsOperator<K, V,I> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, V>[], I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
    
}
