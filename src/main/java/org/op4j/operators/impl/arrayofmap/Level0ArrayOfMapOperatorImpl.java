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

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ArrayOfMapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0ArrayOfMapOperator<K,V>  {

    
    public Level0ArrayOfMapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Add<Map<K, V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ArrayOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Insert<Map<K, V>>(position, NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ArrayOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.AddAll<Map<K, V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    public Level0ArrayOfMapOperator<K, V> distinct() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Distinct<Map<K, V>>()));
    }


    public Level1ArrayOfMapElementsOperator<K, V> forEach() {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().iterate());
    }


    public Level0ArrayOfMapOperator<K, V> removeAllIndexes(final int... indices) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<Map<K, V>>(indices)));
    }


    public Level0ArrayOfMapOperator<K, V> removeAllEqual(final Map<K, V>... values) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<Map<K, V>>(values)));
    }


    public Level0ArrayOfMapOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<Map<K, V>>(eval)));
    }

    public Level0ArrayOfMapOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<Map<K, V>>(eval)));
    }

    public Level0ArrayOfMapOperator<K, V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<Map<K, V>>(eval)));
    }

    public Level0ArrayOfMapOperator<K, V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<Map<K, V>>(eval)));
    }


    public Level0ArrayOfMapOperator<K, V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<Map<K, V>>(eval)));
    }


    public Level0ArrayOfMapOperator<K, V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<Map<K, V>>(eval)));
    }


    public Level0ArrayOfMapOperator<K, V> removeAllIndexesNot(final int... indices) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<Map<K, V>>(indices)));
    }



    public Level0ArrayOfMapOperator<K, V> removeAllNull() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveAllNull<Map<K, V>>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<K, V> sort() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
	public Map<K, V>[] get() {
        return (Map<K, V>[]) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, V>[]> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, V>[]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X,Y> Level0ArrayOfMapOperator<X,Y> asArrayOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asArrayOfMapOf(keyType, valueType);
    }


    public Level0ArrayOfMapOperator<?,?> asArrayOfMapOfUnknown() {
        return asArrayOfMapOf(Types.OBJECT, Types.OBJECT);
    }


	public Level0ListOfMapOperator<K, V> toListOfMap() {
		return Op.onListOfMap(Op.onArray(get()).toList().get());
	}


	public <K1> Level0MapOfMapOperator<K1, K, V> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
		return Op.onMapOfMap(Op.onArray(get()).toMap(keyEval).get());
	}


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
		return Op.onMapOfMap(Op.onArray(get()).toMap(mapBuild).get());
	}


	public Level0SetOfMapOperator<K, V> toSetOfMap() {
		return Op.onSetOfMap(Op.onArray(get()).toSet().get());
	}


    public Level0ArrayOfMapSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifNotNull() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifNull() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ArrayOfMapSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0ArrayOfMapOperator<X, Y> convert(final IConverter<? extends Map<X, Y>[], ? super Map<K, V>[]> converter) {
        return new Level0ArrayOfMapOperatorImpl<X, Y>(getTarget().execute(converter, Normalization.ARRAY_OF_MAP));
    }


    public <X, Y> Level0ArrayOfMapOperator<X, Y> eval(final IEvaluator<? extends Map<X, Y>[], ? super Map<K, V>[]> eval) {
        return new Level0ArrayOfMapOperatorImpl<X, Y>(getTarget().execute(eval, Normalization.ARRAY_OF_MAP));
    }


    public <X, Y> Level0ArrayOfMapOperator<X, Y> exec(final IFunction<? extends Map<X, Y>[], ? super Map<K, V>[]> function) {
        return new Level0ArrayOfMapOperatorImpl<X, Y>(getTarget().execute(function, Normalization.ARRAY_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Map<K, V>[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Map<K, V>[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Map<K, V>[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ArrayOfMapOperator<K, V> replaceBy(final Map<K, V>[] replacement) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().replaceBy(replacement));
    }


    public Level0ArrayOfMapOperator<K, V> replaceIfNullBy(final Map<K, V>[] replacement) {
        return ifNull().replaceBy(replacement).endIf();
    }
    
    
}
