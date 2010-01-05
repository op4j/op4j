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
package org.op4j.operators.impl.listofmap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.list.Level1ListElementsOperatorImpl;
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperatorImpl;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsSelectedOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfMapElementsOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level1ListOfMapElementsOperator<K,V>  {

    
    public Level1ListOfMapElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOfMapOperator<K, V> endFor() {
        return new Level0ListOfMapOperatorImpl<K,V>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level1ListOfSetElementsOperator<K> extractKeys() {
        return new Level1ListOfSetElementsOperatorImpl<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level1ListOfListElementsOperator<V> extractValues() {
        return new Level1ListOfListElementsOperatorImpl<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level2ListOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K, V>(getTarget().iterate());
    }








    public Level1ListOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level1ListOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level1ListOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level1ListOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level1ListOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public Level1ListOfMapElementsOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }

    public Level1ListOfMapElementsOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K, V>(eval)));
    }


    public Level1ListOfMapElementsOperator<K, V> removeKeysNot(final K... keys) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }






    @SuppressWarnings("unchecked")
    public Level1ListOfMapElementsOperator<K, V> sort() {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public List<Map<K, V>> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
	public <X> Level1ListElementsOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level1ListElementsOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level1ListElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level1ListElementsOperatorImpl<X>(getTarget().execute(function));
	}
    
    

    public <X,Y> Level1ListOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return endFor().generic().asListOfMapOf(keyType, valueType).forEach();
    }


    public Level1ListOfMapElementsOperator<?,?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNotNull() {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNull() {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }
    
    
    
}