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
import org.op4j.exceptions.NonEmptyTargetException;
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
import org.op4j.target.OperationChainingTarget;
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
public class Level0SetOfMapOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level0SetOfMapOperator<K,V,I>  {

    
    public Level0SetOfMapOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V,I> add(final Map<K, V> newElement) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Add<Map<K, V>>(NormalizationUtils.normalizeMap(newElement))));
    }

    public Level0SetOfMapOperator<K, V,I> addAll(final Map<K, V>... newElements) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Add<Map<K, V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V,I> insert(final int position, final Map<K, V> newElement) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Insert<Map<K, V>>(position, NormalizationUtils.normalizeMap(newElement))));
    }

    public Level0SetOfMapOperator<K, V,I> insertAll(final int position, final Map<K, V>... newElements) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Insert<Map<K, V>>(position, NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0SetOfMapOperator<K, V,I> addAll(final Collection<Map<K, V>> collection) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.AddAll<Map<K, V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    public Level1SetOfMapElementsOperator<K, V,I> forEach() {
        return new Level1SetOfMapElementsOperatorImpl<K, V,I>(getTarget().iterate());
    }


    public Level0SetOfMapOperator<K, V,I> removeAllIndexes(final int... indices) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Map<K, V>>(indices)));
    }


    public Level0SetOfMapOperator<K, V,I> removeAllEqual(final Map<K, V>... values) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<Map<K, V>>(values)));
    }


    public Level0SetOfMapOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Map<K, V>>(indices)));
    }


    public Level0SetOfMapOperator<K, V,I> removeAllNull() {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.RemoveAllNull<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V,I> sort() {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfMapOperator<K, V,I> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().execute(new SetFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Set<Map<K, V>> get() {
        return (Set<Map<K,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<Map<K, V>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<Set<Map<K, V>>,I>(getTarget());
    }

    
    
    
    
    
    
    
	public <X,Y> Level0SetOfMapOperator<X,Y,I> asSetOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return generic().asSetOfMapOf(keyType, valueType);
    }


    public Level0SetOfMapOperator<?,?,I> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    

	@SuppressWarnings("unchecked")
	public Level0ArrayOfMapOperator<K, V,I> toArrayOfMap() {
	    return new Level0ArrayOfMapOperatorImpl<K, V, I>(getTarget().execute(new ToArray.FromCollection<Map<K,V>>((Type<Map<K,V>>)(Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)));
    }


	public Level0ListOfMapOperator<K, V,I> toListOfMap() {
        return new Level0ListOfMapOperatorImpl<K, V, I>(getTarget().execute(new ToList.FromCollection<Map<K,V>>()));
    }


	public <K1> Level0MapOfMapOperator<K1, K, V,I> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
        return new Level0MapOfMapOperatorImpl<K1, K, V, I>(getTarget().execute(new ToMap.FromSetByKeyEval<K1, Map<K,V>>(keyEval)));
    }


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2,I> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V2, I>(getTarget().execute(new ToMap.FromSetByMapBuilder<K1, Map<K2,V2>, Map<K,V>>(mapBuild)));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifNotNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y,I> convert(final IConverter<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> converter) {
        return new Level0SetOfMapOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.SET_OF_MAP));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y,I> eval(final IEvaluator<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.SET_OF_MAP));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y,I> exec(final IFunction<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> function) {
        return new Level0SetOfMapOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.SET_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<Map<K, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<Map<K, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Map<K, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0SetOfMapOperator<K, V,I> replaceWith(final Set<Map<K, V>> replacement) {
        return new Level0SetOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfMapOperator<K, V,I> replaceIfNullWith(final Set<Map<K, V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<Set<Map<K, V>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<Set<Map<K, V>>, I>(ocTarget);
    }
    
    
}
