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
import org.op4j.operations.Operation;
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
public class Level2MapOfSetEntriesValueOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level2MapOfSetEntriesValueOperator<K,V,I> {

    
    public Level2MapOfSetEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueOperator<K, V,I> add(final V newElement) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Add<V>(newElement)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V,I> addAll(final V... newElements) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueOperator<K, V,I> insert(final int position, final V newElement) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Insert<V>(position, newElement)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public Level1MapOfSetEntriesOperator<K, V,I> endOn() {
        return new Level1MapOfSetEntriesOperatorImpl<K, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3MapOfSetEntriesValueElementsOperator<K, V,I> forEach() {
        return new Level3MapOfSetEntriesValueElementsOperatorImpl<K, V,I>(getTarget().iterate());
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllEqual(final V... values) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> removeAllNull() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNull<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level2MapOfSetEntriesValueOperator<K, V,I> sort() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public Level2MapOfListEntriesValueOperator<K, V,I> toList() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromCollection<V>()));
    }


    public Level2MapOfMapEntriesValueOperator<K, V, V,I> toMap() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, V, V,I>(getTarget().execute(new ToMap.FromSetByAlternateElements<V>()));
    }

    public <K2> Level2MapOfMapEntriesValueOperator<K, K2, V,I> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V,I>(getTarget().execute(new ToMap.FromSetByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> Level2MapOfMapEntriesValueOperator<K, K2, V2,I> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V2,I>(getTarget().execute(new ToMap.FromSetByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Map<K, Set<V>> get() {
        return endOn().endFor().get();
    }


    
    
    
    
    
    
    
	public <X> Level2MapOfSetEntriesValueOperator<K, X,I> asSetOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfSetOfValue(type, get());
        return new Level2MapOfSetEntriesValueOperatorImpl<K,X,I>(getTarget());
    }


    public Level2MapOfSetEntriesValueOperator<K, ?,I> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifNotNull() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifNull() {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfSetEntriesValueSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K, X,I> convert(final IConverter<? extends Set<X>, ? super Set<V>> converter) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.SET));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K, X,I> eval(final IEvaluator<? extends Set<X>, ? super Set<V>> eval) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.SET));
    }


    public <X> Level2MapOfSetEntriesValueOperator<K, X,I> exec(final IFunction<? extends Set<X>, ? super Set<V>> function) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.SET));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<V>> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<V>> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<V>> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> replaceWith(final Set<V> replacement) {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> replaceIfNullWith(final Set<V> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, Set<V>>, I> createOperation() {
        return endOn().createOperation();
    }

    
    
}
