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
package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofset.Level3MapOfSetEntriesValueElementsOperator;
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
public class Level2MapOfSetEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfSetEntriesValueOperator<K,V> {

    
    public Level2MapOfSetEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueOperator<K, V> add(final V newElement) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V> addAll(final V... newElements) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueOperator<K, V> insert(final int position, final V newElement) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public Level1MapOfSetEntriesOperator<K, V> endOn() {
        return new Level1MapOfSetEntriesOperatorImpl<K, V>(getTarget().endOn());
    }


    public Level3MapOfSetEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, V>(getTarget().iterate(Structure.SET));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllEqual(final V... values) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> removeAllNull() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueOperator<K, V> sort() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> toArrayOf(final Type<V> type) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(type, getTarget().execute(new ToArray.FromCollection<V>(type)));
    }


    public Level2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToList.FromCollection<V>()));
    }


    public Level2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, V, V>(getTarget().execute(new ToMap.FromSetByAlternateElements<V>()));
    }

    public <K2> Level2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V>(getTarget().execute(new ToMap.FromSetByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> Level2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V2>(getTarget().execute(new ToMap.FromSetByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Map<K, Set<V>> get() {
        return endOn().endFor().get();
    }


    
    
    
    
    
    
    
	public <X> Level2MapOfSetEntriesValueOperator<K, X> asSetOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        return new Level2MapOfSetEntriesValueOperatorImpl<K,X>(getTarget().cast(CastType.SET, type));
    }


    public Level2MapOfSetEntriesValueOperator<K, ?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K, X> convertAsSet(final IConverter<? extends Set<X>, ? super Set<V>> converter) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalisation.SET));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K, X> evalAsSet(final IEvaluator<? extends Set<X>, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalisation.SET));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K, X> execAsSet(final IFunction<? extends Set<X>, ? super Set<V>> function) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalisation.SET));
    }


    public <X> Level2MapEntriesValueOperator<K, X> convert(final IConverter<X, ? super Set<V>> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> eval(final IEvaluator<X, ? super Set<V>> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> exec(final IFunction<X, ? super Set<V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> replaceIfNullWith(final Set<V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    

    
    
}
