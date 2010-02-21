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
package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.structures.FArray;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
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
public final class Level2MapOfArrayEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfArrayEntriesValueOperator<K,V> {

    private final Type<V> type; 

    
    public Level2MapOfArrayEntriesValueOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V> add(final V newElement) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.Add<V>(newElement)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> addAll(final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.Add<V>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V> insert(final int position, final V newElement) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.Insert<V>(position, newElement)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.AddAll<V>(collection)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.Distinct<V>()));
    }


    public Level1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(this.type, getTarget().endOn());
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, V>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNullOrFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNotNullAndFalse(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNullOrTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNotNullAndTrue(final IFunction<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllIndexesNot<V>(indexes)));
    }



    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNull() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.RemoveAllNull<V>()));
    }

    
    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V> sort() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.Sort()));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(new FArray.SortByComparator<V>(comparator)));
    }




    public Level2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToList.FromArray<V>()));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToSet.FromArray<V>()));
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level2MapOfArrayEntriesValueOperator<K, X> asArrayOf(final Type<X> newType) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X>(newType, getTarget().cast(CastType.ARRAY, newType));
    }


    public Level2MapOfArrayEntriesValueOperator<K, ?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifTrue(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifFalse(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IFunction<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


	public Level2MapOfArrayEntriesValueOperator<K, V> execIfNotNullAsArray(final IFunction<? extends V[], ? super V[]> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


	public Level2MapOfArrayEntriesValueOperator<K, V> execAsArray(final IFunction<? extends V[], ? super V[]> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    


    public <X> Level2MapOfArrayEntriesValueOperator<K, X> execAsArrayOf(final Type<X> valueType, final IFunction<X[], ? super V[]> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X>(valueType, getTarget().execute(function, Normalisation.ARRAY(valueType.getRawClass())));
    }


    


    public <X> Level2MapEntriesValueOperator<K, X> exec(final IFunction<X, ? super V[]> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> replaceWith(final V[] replacement) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> replaceIfNullWith(final V[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }



    
    public <X> Level2MapOfArrayEntriesValueOperator<K,X> map(final Type<X> newType, final IFunction<X, ? super V> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X>(newType, getTarget().map(Structure.ARRAY, function, newType.getRawClass()));
    }


    public Level2MapOfArrayEntriesValueOperator<K,V> map(final IFunction<? extends V, ? super V> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,V>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }
    

    
    


    public Level2MapOfArrayEntriesValueOperator<K,V> mapIfNotNull(final IFunction<? extends V, ? super V> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,V>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }

    
    
    
    
}
