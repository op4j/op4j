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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level1ArrayElementsOperator;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.impl.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel2ArrayOfMapElementsEntriesOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfMapElementsOperator<K,V> extends Operator
        implements ILevel1ArrayOfMapElementsOperator<K,V>  {

    
    public Level1ArrayOfMapElementsOperator(final Target target) {
        super(target);
    }


    public ILevel0ArrayOfMapOperator<K, V> endFor() {
        return new Level0ArrayOfMapOperator<K, V>(getTarget().endIterate(Structure.ARRAY, Map.class));
    }


    public ILevel1ArrayOfSetElementsOperator<K> extractKeys() {
        return new Level1ArrayOfSetElementsOperator<K>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public ILevel1ArrayOfListElementsOperator<V> extractValues() {
        return new Level1ArrayOfListElementsOperator<V>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntry() {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterate());
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateMapKeys(keys));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateMatching(eval));
    }


    public ILevel2ArrayOfMapElementsEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level2ArrayOfMapElementsEntriesOperator<K, V>(getTarget().iterateMapKeysNot(keys));
    }








    public ILevel1ArrayOfMapElementsOperator<K, V> put(final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> insert(final int position, final K newKey, final V newValue) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> putAll(final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> insertAll(final int position, final Map<K, V> map) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeKeys(final K... keys) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeys<K, V>(keys)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveMatching<K, V>(eval)));
    }

    public ILevel1ArrayOfMapElementsOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K, V>(eval)));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> removeKeysNot(final K... keys) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K, V>(keys)));
    }











    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfMapElementsOperator<K, V> sort() {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public ILevel1ArrayOfMapElementsOperator<K, V> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public Map<K, V>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X, ? super Map<K,V>> converter) {
        return new Level1ArrayElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
	}


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super Map<K,V>> eval) {
        return new Level1ArrayElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super Map<K,V>> function) {
        return new Level1ArrayElementsOperator<X>(function.getResultType(), getTarget().execute(function));
	}

    
    

    public <X,Y> ILevel1ArrayOfMapElementsOperator<X,Y> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return endFor().asArrayOfMapOf(keyType, valueType).forEach();
    }


    public ILevel1ArrayOfMapElementsOperator<?,?> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    
    
    
}
