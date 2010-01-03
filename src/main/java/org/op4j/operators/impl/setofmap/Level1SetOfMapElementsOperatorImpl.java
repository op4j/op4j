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
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfMapElementsOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1SetOfMapElementsOperator<K,V>  {

    
    public Level1SetOfMapElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOfMapOperator<K, V> endFor() {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetOfSetElementsOperator<K> extractKeys() {
        return new Level1SetOfSetElementsOperatorImpl<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level1SetOfListElementsOperator<V> extractValues() {
        return new Level1SetOfListElementsOperatorImpl<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level2SetOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2SetOfMapElementsEntriesOperatorImpl<K, V>(getTarget().iterate());
    }








    public Level1SetOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level1SetOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level1SetOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level1SetOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level1SetOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public Level1SetOfMapElementsOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }

    public Level1SetOfMapElementsOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K, V>(eval)));
    }


    public Level1SetOfMapElementsOperator<K, V> removeKeysNot(final K... keys) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }








    @SuppressWarnings("unchecked")
    public Level1SetOfMapElementsOperator<K, V> sort() {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1SetOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Set<Map<K, V>> get() {
        return endFor().get();
    }

    
    
    
    
    
	public <X> Level1SetElementsOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level1SetElementsOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1SetElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level1SetElementsOperatorImpl<X>(getTarget().execute(function));
	}

    

    public <X,Y> Level1SetOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return endFor().generic().asSetOfMapOf(keyType, valueType).forEach();
    }


    public Level1SetOfMapElementsOperator<?,?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNotNull() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNull() {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfMapElementsSelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1SetOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }
    
    
    
}
