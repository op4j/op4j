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

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
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
public class Level0ListOfMapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0ListOfMapOperator<K,V>  {

    
    public Level0ListOfMapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ListOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Add<Map<K, V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ListOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Insert<Map<K, V>>(position, NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ListOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.AddAll<Map<K, V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    public Level0ListOfMapOperator<K, V> distinct() {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Distinct<Map<K, V>>()));
    }


    public Level1ListOfMapElementsOperator<K, V> forEach() {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().iterate());
    }


    public Level0ListOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveIndexes<Map<K, V>>(indices)));
    }


    public Level0ListOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveEquals<Map<K, V>>(values)));
    }


    public Level0ListOfMapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveMatching<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveNotMatching<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveIndexesNot<Map<K, V>>(indices)));
    }


    public Level0ListOfMapOperator<K, V> removeNulls() {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveNulls<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfMapOperator<K, V> sort() {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public List<Map<K, V>> get() {
        return (List<Map<K,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<Map<K, V>>> generic() {
        return new Level0GenericUniqOperatorImpl<List<Map<K, V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X,Y> Level0ListOfMapOperator<X,Y> asListOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return generic().asListOfMapOf(keyType, valueType);
    }


    public Level0ListOfMapOperator<?,?> asListOfMapOfUnknown() {
        return asListOfMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    
    
    


	@SuppressWarnings("unchecked")
	public Level0ArrayOfMapOperator<K, V> toArrayOfMap() {
		return Op.onArrayOfMap((Map<K, V>[]) Op.onList(get()).asListOf(Types.MAP_OF_UNKNOWN_UNKNOWN).toArray(Types.MAP_OF_UNKNOWN_UNKNOWN).get());
	}


	public <K1> Level0MapOfMapOperator<K1, K, V> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
		return Op.onMapOfMap(Op.onList(get()).toMap(keyEval).get());
	}


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
		return Op.onMapOfMap(Op.onList(get()).toMap(mapBuild).get());
	}


	public Level0SetOfMapOperator<K, V> toSetOfMap() {
		return Op.onSetOfMap(Op.onList(get()).toSet().get());
	}


    public Level0ListOfMapSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y> convert(final IConverter<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> converter) {
        return new Level0ListOfMapOperatorImpl<X, Y>(getTarget().execute(converter, Normalization.LIST_OF_MAP));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y> eval(final IEvaluator<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapOperatorImpl<X, Y>(getTarget().execute(eval, Normalization.LIST_OF_MAP));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y> exec(final IFunction<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> function) {
        return new Level0ListOfMapOperatorImpl<X, Y>(getTarget().execute(function, Normalization.LIST_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<Map<K, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<Map<K, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<Map<K, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalization.NONE));
    }
    
    
    
    
}
