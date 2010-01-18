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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
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
public class Level2MapOfArrayEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfArrayEntriesValueOperator<K,V> {

    
    public Level2MapOfArrayEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K, V> forEach(final Type<V> elementType) {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, V>(elementType, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }



    public Level2MapOfArrayEntriesValueOperator<K, V> removeAllNull() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }

    
    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V> sort() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }




    public Level2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToList.FromArray<V>()));
    }


    public Level2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, V, V>(getTarget().execute(new ToMap.FromArrayByAlternateElements<V>()));
    }


    public <K2> Level2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V>(getTarget().execute(new ToMap.FromArrayByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> Level2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V2>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToSet.FromArray<V>()));
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level2MapOfArrayEntriesValueOperator<K, X> asArrayOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfArrayOfValue(type, get());
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X>(getTarget());
    }


    public Level2MapOfArrayEntriesValueOperator<K, ?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNotNull() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNull() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level2MapOfArrayEntriesValueOperator<K, X> convert(final IConverter<X[], ? super V[]> converter) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level2MapOfArrayEntriesValueOperator<K, X> eval(final IEvaluator<X[], ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level2MapOfArrayEntriesValueOperator<K, X> exec(final IFunction<X[], ? super V[]> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level2MapEntriesValueOperator<K, X> convert(final Type<X> resultType, final IConverter<? extends X, ? super V[]> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super V[]> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X> exec(final Type<X> resultType, final IFunction<? extends X, ? super V[]> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X>(getTarget().execute(function, Normalization.NONE));
    }

    
    
    
    
}
