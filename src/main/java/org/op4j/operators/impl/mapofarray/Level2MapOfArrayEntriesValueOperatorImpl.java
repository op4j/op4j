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
import org.op4j.operations.Operation;
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
public class Level2MapOfArrayEntriesValueOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level2MapOfArrayEntriesValueOperator<K,V,I> {

    
    public Level2MapOfArrayEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V,I> add(final V newElement) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.Add<V>(newElement)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V,I> addAll(final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V,I> insert(final int position, final V newElement) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElement)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> distinct() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level1MapOfArrayEntriesOperator<K, V,I> endOn() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K, V,I> forEach(final Type<V> elementType) {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, V,I>(elementType, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }



    public Level2MapOfArrayEntriesValueOperator<K, V,I> removeAllNull() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }

    
    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V,I> sort() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }




    public Level2MapOfListEntriesValueOperator<K, V,I> toList() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ToList.FromArray<V>()));
    }


    public Level2MapOfMapEntriesValueOperator<K, V, V,I> toMap() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, V, V,I>(getTarget().execute(new ToMap.FromArrayByAlternateElements<V>()));
    }


    public <K2> Level2MapOfMapEntriesValueOperator<K, K2, V,I> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V,I>(getTarget().execute(new ToMap.FromArrayByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> Level2MapOfMapEntriesValueOperator<K, K2, V2,I> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V2,I>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V,I> toSet() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V,I>(getTarget().execute(new ToSet.FromArray<V>()));
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level2MapOfArrayEntriesValueOperator<K, X,I> asArrayOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        NormalizationUtils.checkIsMapOfArrayOfValue(type, get());
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X,I>(getTarget());
    }


    public Level2MapOfArrayEntriesValueOperator<K, ?,I> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifNotNull() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifNull() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


	public <X> Level2MapOfArrayEntriesValueOperator<K, X,I> convert(final IConverter<X[], ? super V[]> converter) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


	public <X> Level2MapOfArrayEntriesValueOperator<K, X,I> eval(final IEvaluator<X[], ? super V[]> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


	public <X> Level2MapOfArrayEntriesValueOperator<K, X,I> exec(final IFunction<X[], ? super V[]> function) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super V[]> converter) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super V[]> eval) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2MapEntriesValueOperator<K, X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super V[]> function) {
        return new Level2MapEntriesValueOperatorImpl<K, X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> replaceWith(final V[] replacement) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V,I> replaceIfNullWith(final V[] replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Map<K, V[]>, I> createOperation() {
        return endOn().createOperation();
    }

    
    
    
    
}
