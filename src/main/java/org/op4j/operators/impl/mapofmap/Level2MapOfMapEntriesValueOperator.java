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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperator;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel3MapOfMapEntriesValueEntriesOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfMapEntriesValueOperator<K1,K2,V> extends Operator
        implements ILevel2MapOfMapEntriesValueOperator<K1,K2,V> {

    
    public Level2MapOfMapEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> endOn() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel2MapOfSetEntriesValueOperator<K1, K2> extractKeys() {
        return new Level2MapOfSetEntriesValueOperator<K1, K2>(getTarget().execute(new MapFuncs.ExtractKeys<K2, V>()));
    }


    public ILevel2MapOfListEntriesValueOperator<K1, V> extractValues() {
        return new Level2MapOfListEntriesValueOperator<K1, V>(getTarget().execute(new MapFuncs.ExtractValues<K2, V>()));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterate());
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryWithKeys(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterate(eval));
    }


    public ILevel3MapOfMapEntriesValueEntriesOperator<K1, K2, V> forEachEntryWithKeysNot(final K2... keys) {
        return new Level3MapOfMapEntriesValueEntriesOperator<K1, K2, V>(getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel2MapOfMapEntriesValueOperator<K1, X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level2MapOfMapEntriesValueOperator<K1, X, Y>(getTarget());
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.Put<K2, V>(newKey, newValue)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.Insert<K2, V>(position, newKey, newValue)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> putAll(final Map<K2, V> map) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.PutAll<K2, V>(map)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> insertAll(final int position, final Map<K2, V> map) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.InsertAll<K2, V>(position, map)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, ?, ?> raw() {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget());
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeKeys(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeys<K2, V>(keys)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveMatching<K2, V>(eval)));
    }

    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K2, V>> eval) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K2, V>(eval)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> removeKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K2, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> sort() {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public ILevel2MapOfMapEntriesValueOperator<K1, K2, V> sort(final Comparator<? super Entry<K2, V>> comparator) {
        return new Level2MapOfMapEntriesValueOperator<K1, K2, V>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    

    
    
    
	public <X> ILevel2MapEntriesValueOperator<K1,X> convert(final IConverter<X, ? super Map<K2,V>> converter) {
        return new Level2MapEntriesValueOperator<K1,X>(getTarget().execute(converter));
	}


    public <X> ILevel2MapEntriesValueOperator<K1,X> eval(final IEvaluator<X, ? super Map<K2,V>> eval) {
        return new Level2MapEntriesValueOperator<K1,X>(getTarget().execute(eval));
    }


    public <X> ILevel2MapEntriesValueOperator<K1,X> exec(final IFunction<X, ? super Map<K2,V>> function) {
        return new Level2MapEntriesValueOperator<K1,X>(getTarget().execute(function));
	}

    
    
    public <X,Y> ILevel2MapOfMapEntriesValueOperator<K1, X, Y> asMap(final Type<X> keyOf, final Type<Y> valueOf) {
        Validate.notNull(keyOf, "A type representing the keys must be specified");
        Validate.notNull(valueOf, "A type representing the values must be specified");
        return new Level2MapOfMapEntriesValueOperator<K1,X,Y>(getTarget());
    }


    public ILevel2MapOfMapEntriesValueOperator<K1, ?, ?> asMapOfUnknown() {
        return asMap(Types.OBJECT, Types.OBJECT);
    }

    
    
}
