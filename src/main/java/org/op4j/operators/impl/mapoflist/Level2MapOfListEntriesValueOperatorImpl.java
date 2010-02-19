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
package org.op4j.operators.impl.mapoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FList;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.CastType;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level2MapOfListEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfListEntriesValueOperator<K,V> {

    
    public Level2MapOfListEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesValueOperator<K, V> add(final V newElement) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.Add<V>(newElement)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> addAll(final V... newElements) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.Add<V>(newElements)));
    }

    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesValueOperator<K, V> insert(final int position, final V newElement) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.Insert<V>(position, newElement)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.Insert<V>(position, newElements)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.AddAll<V>(collection)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfListEntriesValueOperatorImpl<K,V>(getTarget().execute(new FList.Distinct<V>()));
    }


    public Level1MapOfListEntriesOperator<K, V> endOn() {
        return new Level1MapOfListEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public Level3MapOfListEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, V>(getTarget().iterate(Structure.LIST));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllEqual(final V... values) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> removeAllFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> removeAllNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllNull() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.RemoveAllNull<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesValueOperator<K, V> sort() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.Sort()));
    }


    public Level2MapOfListEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new FList.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> toArrayOf(final Type<V> type) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(type, getTarget().execute(new ToArray.FromCollection<V>(type)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToSet.FromCollection<V>()));
    }


    public Map<K, List<V>> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
	public <X> Level2MapOfListEntriesValueOperator<K, X> asListOf(final Type<X> type) {
        return new Level2MapOfListEntriesValueOperatorImpl<K,X>(getTarget().cast(CastType.LIST, type));
    }


    public Level2MapOfListEntriesValueOperator<K, ?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifTrue(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifFalse(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IFunction<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> execIfNotNullAsList(final IFunction<? extends List<X>, ? super List<V>> function) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> execAsList(final IFunction<? extends List<X>, ? super List<V>> function) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalisation.LIST));
    }


    public <X> Level2MapEntriesValueOperator<K, X> execIfNotNull(final IFunction<X, ? super List<V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> exec(final IFunction<X, ? super List<V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfListEntriesValueOperator<K, V> replaceWith(final List<V> replacement) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public Level2MapOfListEntriesValueOperator<K, V> replaceIfNullWith(final List<V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> map(final IFunction<X, ? super V> function) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().map(Structure.LIST, function, null));
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> mapIfNotNull(final IFunction<X, ? super V> function) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }


    


    
}
