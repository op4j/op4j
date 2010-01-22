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
package org.op4j.operators.impl.setofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.set.Level1SetElementsOperatorImpl;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperatorImpl;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsSelectedOperator;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsEntriesOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
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
public class Level1SetOfMapElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level1SetOfMapElementsOperator<K,V,I>  {

    
    public Level1SetOfMapElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOfMapOperator<K, V,I> endFor() {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetOfSetElementsOperator<K,I> extractKeys() {
        return new Level1SetOfSetElementsOperatorImpl<K,I>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level1SetOfListElementsOperator<V,I> extractValues() {
        return new Level1SetOfListElementsOperatorImpl<V,I>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level2SetOfMapElementsEntriesOperator<K, V,I> forEachEntry() {
        return new Level2SetOfMapElementsEntriesOperatorImpl<K, V,I>(getTarget().iterate());
    }








    public Level1SetOfMapElementsOperator<K, V,I> put(final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level1SetOfMapElementsOperator<K, V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level1SetOfMapElementsOperator<K, V,I> putAll(final Map<K, V> map) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level1SetOfMapElementsOperator<K, V,I> insertAll(final int position, final Map<K, V> map) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level1SetOfMapElementsOperator<K, V,I> removeAllKeys(final K... keys) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, V>(keys)));
    }


    public Level1SetOfMapElementsOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, V>(eval)));
    }

    public Level1SetOfMapElementsOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, V>(eval)));
    }


    public Level1SetOfMapElementsOperator<K, V,I> removeAllKeysNot(final K... keys) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, V>(keys)));
    }








    @SuppressWarnings("unchecked")
    public Level1SetOfMapElementsOperator<K, V,I> sort() {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapElementsOperator<K, V,I> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Set<Map<K, V>> get() {
        return endFor().get();
    }

    
    
    
    
    
	public <X,Y> Level1SetOfMapElementsOperator<X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return endFor().generic().asSetOfMapOf(keyType, valueType).forEach();
    }


    public Level1SetOfMapElementsOperator<?,?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifNotNull() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifNull() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level1SetOfMapElementsOperator<X, Y,I> convert(final IConverter<? extends Map<X, Y>, ? super Map<K, V>> converter) {
        return new Level1SetOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public <X, Y> Level1SetOfMapElementsOperator<X, Y,I> eval(final IEvaluator<? extends Map<X, Y>, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public <X, Y> Level1SetOfMapElementsOperator<X, Y,I> exec(final IFunction<? extends Map<X, Y>, ? super Map<K, V>> function) {
        return new Level1SetOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAP));
    }


    public <X> Level1SetElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, V>> converter) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, V>> eval) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1SetElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, V>> function) {
        return new Level1SetElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetOfMapElementsOperator<K, V,I> replaceWith(final Map<K, V> replacement) {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetOfMapElementsOperator<K, V,I> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<Map<K, V>>, I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
}
