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
package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

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
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
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
public class Level0SetOfMapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0SetOfMapOperator<K,V>  {

    
    public Level0SetOfMapOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V> add(final Map<K, V> newElement) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Add<Map<K, V>>(NormalisationUtils.normaliseMap(newElement))));
    }

    public Level0SetOfMapOperator<K, V> addAll(final Map<K, V>... newElements) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Add<Map<K, V>>(NormalisationUtils.normaliseMaps(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V> insert(final int position, final Map<K, V> newElement) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Insert<Map<K, V>>(position, NormalisationUtils.normaliseMap(newElement))));
    }

    public Level0SetOfMapOperator<K, V> insertAll(final int position, final Map<K, V>... newElements) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Insert<Map<K, V>>(position, NormalisationUtils.normaliseMaps(newElements))));
    }


    public Level0SetOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.AddAll<Map<K, V>>(NormalisationUtils.normaliseMaps(collection))));
    }


    public Level1SetOfMapElementsOperator<K, V> forEach() {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfMapOperator<K, V> removeAllIndexes(final int... indexes) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Map<K, V>>(indexes)));
    }


    public Level0SetOfMapOperator<K, V> removeAllEqual(final Map<K, V>... values) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllEqual<Map<K, V>>(values)));
    }


    public Level0SetOfMapOperator<K, V> removeAllTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllTrue<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V> removeAllFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllFalse<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Map<K, V>>(indexes)));
    }


    public Level0SetOfMapOperator<K, V> removeAllNull() {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveAllNull<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V> sort() {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Set<Map<K, V>> get() {
        return (Set<Map<K,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<Map<K, V>>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<Map<K, V>>>(getTarget());
    }

    
    
    
    
    
    
    
	public <X,Y> Level0SetOfMapOperator<X,Y> asSetOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return generic().asSetOfMapOf(keyType, valueType);
    }


    public Level0SetOfMapOperator<?,?> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    

	@SuppressWarnings("unchecked")
	public Level0ArrayOfMapOperator<K, V> toArrayOfMap() {
	    return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ToArray.FromCollection<Map<K,V>>((Type<Map<K,V>>)(Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)));
    }


	public Level0ListOfMapOperator<K, V> toListOfMap() {
        return new Level0ListOfMapOperatorImpl<K, V>(getTarget().execute(new ToList.FromCollection<Map<K,V>>()));
    }


	public <K1> Level0MapOfMapOperator<K1, K, V> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
        return new Level0MapOfMapOperatorImpl<K1, K, V>(getTarget().execute(new ToMap.FromSetByKeyEval<K1, Map<K,V>>(keyEval)));
    }


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V2>(getTarget().execute(new ToMap.FromSetByMapBuilder<K1, Map<K2,V2>, Map<K,V>>(mapBuild)));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifIndex(final int... indexes) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndex(indexes));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifIndexNot(final int... indexes) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indexes));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y> convertAsSetOfMap(final IConverter<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> converter) {
        return new Level0SetOfMapOperatorImpl<X, Y>(getTarget().execute(converter, Normalisation.SET_OF_MAP));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y> evalAsSetOfMap(final IEvaluator<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapOperatorImpl<X, Y>(getTarget().execute(eval, Normalisation.SET_OF_MAP));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y> execAsSetOfMap(final IFunction<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> function) {
        return new Level0SetOfMapOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.SET_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<Map<K, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<Map<K, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Map<K, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level0SetOfMapOperator<K, V> replaceWith(final Set<Map<K, V>> replacement) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfMapOperator<K, V> replaceIfNullWith(final Set<Map<K, V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    
    
    
}
