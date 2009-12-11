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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.set.Level1SetElementsOperator;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel2SetOfMapElementsEntriesOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfMapElementsOperator<K,V> extends Operator
        implements ILevel1SetOfMapElementsOperator<K,V>  {

    
    public Level1SetOfMapElementsOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOfMapOperator<K, V> endFor() {
        return new Level0SetOfMapOperator<K, V>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel1SetOfSetElementsOperator<K> extractKeys() {
        return new Level1SetOfSetElementsOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel1SetOfListElementsOperator<V> extractValues() {
        return new Level1SetOfListElementsOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterateMapKeys(keys));
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterateMatching(eval));
    }


    public ILevel2SetOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2SetOfMapElementsEntriesOperator<K, V>(getTarget().iterateMapKeysNot(keys));
    }








    public ILevel1SetOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }

    public ILevel1SetOfMapElementsOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K, V>(eval)));
    }


    public ILevel1SetOfMapElementsOperator<K, V> removeKeysNot(final K... keys) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }








    @SuppressWarnings("unchecked")
    public ILevel1SetOfMapElementsOperator<K, V> sort() {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel1SetOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Set<Map<K, V>> get() {
        return endFor().get();
    }

    
    
    
    
    
	public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level1SetElementsOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level1SetElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level1SetElementsOperator<X>(getTarget().execute(function));
	}

    

    public <X,Y> ILevel1SetOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return endFor().generic().asSetOfMapOf(keyType, valueType).forEach();
    }


    public ILevel1SetOfMapElementsOperator<?,?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    
    
}
