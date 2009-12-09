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
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfMapOperator<K1,K2,V> extends Operator
        implements ILevel0MapOfMapOperator<K1,K2,V> {

    
    public Level0MapOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOperator<K1> extractKeys() {
        return new Level0SetOperator<K1>(getTarget().execute(new MapFuncs.ExtractKeys<K1, Map<K2, V>>()));
    }


    public ILevel0ListOfMapOperator<K2, V> extractValues() {
        return new Level0ListOfMapOperator<K2, V>(getTarget().execute(new MapFuncs.ExtractValues<K1, Map<K2, V>>()));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntry() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate());
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeys(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2, V>>> eval) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterate(eval));
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> forEachEntryWithKeysNot(final K1... keys) {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().iterateNot(keys));
    }








    public ILevel0MapOfMapOperator<K1, K2, V> put(final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.Put<K1, Map<K2,V>>(newKey, newValue)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> insert(final int position, final K1 newKey, final Map<K2,V> newValue) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.Insert<K1, Map<K2,V>>(position, newKey, newValue)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> putAll(final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.PutAll<K1, Map<K2,V>>(map)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> insertAll(final int position, final Map<K1, Map<K2,V>> map) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.InsertAll<K1, Map<K2,V>>(position, map)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeKeys(final K1... keys) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeys<K1, Map<K2,V>>(keys)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveMatching<K1, Map<K2,V>>(eval)));
    }

    public ILevel0MapOfMapOperator<K1, K2, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K1, Map<K2,V>>> eval) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K1, Map<K2,V>>(eval)));
    }


    public ILevel0MapOfMapOperator<K1, K2, V> removeKeysNot(final K1... keys) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K1, Map<K2,V>>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel0MapOfMapOperator<K1, K2, V> sort() {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    @SuppressWarnings("unchecked")
    public ILevel0MapOfMapOperator<K1, K2, V> sort(final Comparator<? super Entry<K1, Map<K2, V>>> comparator) {
        return new Level0MapOfMapOperator<K1, K2, V>(getTarget().execute(new MapFuncs.SortEntries(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Map<K1, Map<K2, V>> get() {
        return (Map<K1,Map<K2,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K1, Map<K2, V>>> generic() {
        return new Level0GenericUniqOperator<Map<K1, Map<K2, V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K1,Map<K2,V>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K1,Map<K2,V>>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K1,Map<K2,V>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}
    
    
    


    public <X1,X2,Y> ILevel0MapOfMapOperator<X1,X2,Y> asMapOfMap(final Type<X1> key1Of, final Type<X2> key2Of, final Type<Y> valueOf) {
        Validate.notNull(key1Of, "A type representing the keys for the first-level map must be specified");
        Validate.notNull(key2Of, "A type representing the keys for the second-level map must be specified");
        Validate.notNull(valueOf, "A type representing the values for the second-level map must be specified");
        return new Level0MapOfMapOperator<X1,X2,Y>(getTarget());
    }


    public ILevel0MapOfMapOperator<?,?,?> asMapOfMapOfUnknown() {
        return asMapOfMap(Types.OBJECT, Types.OBJECT, Types.OBJECT);
    }

    

    
}
