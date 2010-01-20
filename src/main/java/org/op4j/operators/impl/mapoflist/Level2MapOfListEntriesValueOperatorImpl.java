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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfListEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfListEntriesValueOperator<K,V> {

    
    public Level2MapOfListEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesValueOperator<K, V> add(final V newElement) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Add<V>(newElement)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> addAll(final V... newElements) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }

    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesValueOperator<K, V> insert(final int position, final V newElement) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElement)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfListEntriesValueOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public Level1MapOfListEntriesOperator<K, V> endOn() {
        return new Level1MapOfListEntriesOperatorImpl<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3MapOfListEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfListEntriesValueElementsOperatorImpl<K, V>(getTarget().iterate());
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllIndexes(final int... indices) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllEqual(final V... values) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfListEntriesValueOperator<K, V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> removeAllNull() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNull<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level2MapOfListEntriesValueOperator<K, V> sort() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level2MapOfListEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public Level2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, V, V>(getTarget().execute(new ToMap.FromListByAlternateElements<V>()));
    }


    public <K2> Level2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V>(getTarget().execute(new ToMap.FromListByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> Level2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V2>(getTarget().execute(new ToMap.FromListByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToSet.FromCollection<V>()));
    }


    public Map<K, List<V>> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
	public <X> Level2MapOfListEntriesValueOperator<K, X> asListOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfListOfValue(type, get());
        return new Level2MapOfListEntriesValueOperatorImpl<K,X>(getTarget());
    }


    public Level2MapOfListEntriesValueOperator<K, ?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> convert(final IConverter<? extends List<X>, ? super List<V>> converter) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalization.LIST));
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> eval(final IEvaluator<? extends List<X>, ? super List<V>> eval) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalization.LIST));
    }


    public <X> Level2MapOfListEntriesValueOperator<K, X> exec(final IFunction<? extends List<X>, ? super List<V>> function) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalization.LIST));
    }


    public <X> Level2MapEntriesValueOperator<K, X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<V>> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<V>> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfListEntriesValueOperator<K, V> replaceWith(final List<V> replacement) {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfListEntriesValueOperator<K, V> replaceIfNullWith(final List<V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
}
