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
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperatorImpl;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level0ListOfMapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0ListOfMapOperator<K,V>  {

    
    public Level0ListOfMapOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapOperator<K, V> add(final Map<K, V> newElement) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Add<Map<K, V>>(NormalisationUtils.normaliseMap(newElement))));
    }

    public Level0ListOfMapOperator<K, V> addAll(final Map<K, V>... newElements) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Add<Map<K, V>>(NormalisationUtils.normaliseMaps(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapOperator<K, V> insert(final int position, final Map<K, V> newElement) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Insert<Map<K, V>>(position, NormalisationUtils.normaliseMap(newElement))));
    }

    public Level0ListOfMapOperator<K, V> insertAll(final int position, final Map<K, V>... newElements) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Insert<Map<K, V>>(position, NormalisationUtils.normaliseMaps(newElements))));
    }


    public Level0ListOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.AddAll<Map<K, V>>(NormalisationUtils.normaliseMaps(collection))));
    }


    public Level0ListOfMapOperator<K, V> distinct() {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.Distinct<Map<K, V>>()));
    }


    public Level1ListOfMapElementsOperator<K, V> forEach() {
        return new Level1ListOfMapElementsOperatorImpl<K, V>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOfMapOperator<K, V> removeAllIndexes(final int... indexes) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Map<K, V>>(indexes)));
    }


    public Level0ListOfMapOperator<K, V> removeAllEqual(final Map<K, V>... values) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllEqual<Map<K, V>>(values)));
    }


    public Level0ListOfMapOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllTrue<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllFalse<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Map<K, V>>(indexes)));
    }


    public Level0ListOfMapOperator<K, V> removeAllNull() {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ListFuncs.RemoveAllNull<Map<K, V>>()));
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
	    return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ToArray.FromCollection<Map<K,V>>((Type<Map<K,V>>)(Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)));
    }


	public <K1> Level0MapOfMapOperator<K1, K, V> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
        return new Level0MapOfMapOperatorImpl<K1, K, V>(getTarget().execute(new ToMap.FromListByKeyEval<K1,Map<K,V>>(keyEval)));
    }


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V2>(getTarget().execute(new ToMap.FromListByMapBuilder<K1,Map<K2,V2>,Map<K,V>>(mapBuild)));
    }


	public Level0SetOfMapOperator<K, V> toSetOfMap() {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new ToSet.FromCollection<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y> convertAsListOfMap(final IConverter<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> converter) {
        return new Level0ListOfMapOperatorImpl<X, Y>(getTarget().execute(converter, Normalisation.LIST_OF_MAP));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y> evalAsListOfMap(final IEvaluator<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapOperatorImpl<X, Y>(getTarget().execute(eval, Normalisation.LIST_OF_MAP));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y> execAsListOfMap(final IFunction<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> function) {
        return new Level0ListOfMapOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.LIST_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super List<Map<K, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<Map<K, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super List<Map<K, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0ListOfMapOperator<K, V> replaceWith(final List<Map<K, V>> replacement) {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().replaceWith(replacement, Normalisation.LIST_OF_MAP));
    }


    public Level0ListOfMapOperator<K, V> replaceIfNullWith(final List<Map<K, V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
    
    
}
