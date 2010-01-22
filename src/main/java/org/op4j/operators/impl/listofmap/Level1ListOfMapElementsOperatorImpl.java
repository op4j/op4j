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
import org.op4j.operations.Operation;
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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfMapElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level1ListOfMapElementsOperator<K,V,I>  {

    
    public Level1ListOfMapElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOfMapOperator<K, V,I> endFor() {
        return new Level0ListOfMapOperatorImpl<K,V,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level1ListOfSetElementsOperator<K,I> extractKeys() {
        return new Level1ListOfSetElementsOperatorImpl<K,I>(getTarget().execute(new MapFuncs.ExtractKeys<K, V>()));
    }


    public Level1ListOfListElementsOperator<V,I> extractValues() {
        return new Level1ListOfListElementsOperatorImpl<V,I>(getTarget().execute(new MapFuncs.ExtractValues<K, V>()));
    }


    public Level2ListOfMapElementsEntriesOperator<K, V,I> forEachEntry() {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K, V,I>(getTarget().iterate());
    }








    public Level1ListOfMapElementsOperator<K, V,I> put(final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Put<K, V>(newKey, newValue)));
    }


    public Level1ListOfMapElementsOperator<K, V,I> insert(final int position, final K newKey, final V newValue) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.Insert<K, V>(position, newKey, newValue)));
    }


    public Level1ListOfMapElementsOperator<K, V,I> putAll(final Map<K, V> map) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.PutAll<K, V>(map)));
    }


    public Level1ListOfMapElementsOperator<K, V,I> insertAll(final int position, final Map<K, V> map) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.InsertAll<K, V>(position, map)));
    }


    public Level1ListOfMapElementsOperator<K, V,I> removeAllKeys(final K... keys) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeys<K, V>(keys)));
    }


    public Level1ListOfMapElementsOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllTrue<K, V>(eval)));
    }

    public Level1ListOfMapElementsOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllFalse<K, V>(eval)));
    }


    public Level1ListOfMapElementsOperator<K, V,I> removeAllKeysNot(final K... keys) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.RemoveAllKeysNot<K, V>(keys)));
    }






    @SuppressWarnings("unchecked")
    public Level1ListOfMapElementsOperator<K, V,I> sort() {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level1ListOfMapElementsOperator<K, V,I> sort(final Comparator<? super Entry<K, V>> comparator) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().execute(new MapFuncs.SortEntries<K, V>(comparator)));
    }


    public List<Map<K, V>> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
	public <X,Y> Level1ListOfMapElementsOperator<X,Y,I> asMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return endFor().generic().asListOfMapOf(keyType, valueType).forEach();
    }


    public Level1ListOfMapElementsOperator<?,?,I> asMapOfUnknown() {
        return asMapOf(Types.OBJECT, Types.OBJECT);
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifNotNull() {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifNull() {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfMapElementsSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level1ListOfMapElementsOperator<X, Y,I> convert(final IConverter<? extends Map<X, Y>, ? super Map<K, V>> converter) {
        return new Level1ListOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAP));
    }


    public <X, Y> Level1ListOfMapElementsOperator<X, Y,I> eval(final IEvaluator<? extends Map<X, Y>, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAP));
    }


    public <X, Y> Level1ListOfMapElementsOperator<X, Y,I> exec(final IFunction<? extends Map<X, Y>, ? super Map<K, V>> function) {
        return new Level1ListOfMapElementsOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAP));
    }


    public <X> Level1ListElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, V>> converter) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, V>> eval) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level1ListElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, V>> function) {
        return new Level1ListElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1ListOfMapElementsOperator<K, V,I> replaceWith(final Map<K, V> replacement) {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfMapElementsOperator<K, V,I> replaceIfNullWith(final Map<K, V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<Map<K, V>>, I> createOperation() {
        return endFor().createOperation();
    }
    
    
    
}
