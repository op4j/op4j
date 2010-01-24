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
import org.op4j.exceptions.NonEmptyTargetException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operations.Operation;
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
public class Level0ListOfMapOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level0ListOfMapOperator<K,V,I>  {

    
    public Level0ListOfMapOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapOperator<K, V,I> add(final Map<K, V> newElement) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.Add<Map<K, V>>(NormalizationUtils.normalizeMap(newElement))));
    }

    public Level0ListOfMapOperator<K, V,I> addAll(final Map<K, V>... newElements) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.Add<Map<K, V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapOperator<K, V,I> insert(final int position, final Map<K, V> newElement) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.Insert<Map<K, V>>(position, NormalizationUtils.normalizeMap(newElement))));
    }

    public Level0ListOfMapOperator<K, V,I> insertAll(final int position, final Map<K, V>... newElements) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.Insert<Map<K, V>>(position, NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0ListOfMapOperator<K, V,I> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.AddAll<Map<K, V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    public Level0ListOfMapOperator<K, V,I> distinct() {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.Distinct<Map<K, V>>()));
    }


    public Level1ListOfMapElementsOperator<K, V,I> forEach() {
        return new Level1ListOfMapElementsOperatorImpl<K, V,I>(getTarget().iterate());
    }


    public Level0ListOfMapOperator<K, V,I> removeAllIndexes(final int... indices) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Map<K, V>>(indices)));
    }


    public Level0ListOfMapOperator<K, V,I> removeAllEqual(final Map<K, V>... values) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<Map<K, V>>(values)));
    }


    public Level0ListOfMapOperator<K, V,I> removeAllTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V,I> removeAllFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Map<K, V>>(eval)));
    }

    public Level0ListOfMapOperator<K, V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Map<K, V>>(eval)));
    }


    public Level0ListOfMapOperator<K, V,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Map<K, V>>(indices)));
    }


    public Level0ListOfMapOperator<K, V,I> removeAllNull() {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.RemoveAllNull<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOfMapOperator<K, V,I> sort() {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfMapOperator<K, V,I> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().execute(new ListFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public List<Map<K, V>> get() {
        return (List<Map<K,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<Map<K, V>>,I> generic() {
        return new Level0GenericUniqOperatorImpl<List<Map<K, V>>,I>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X,Y> Level0ListOfMapOperator<X,Y,I> asListOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return generic().asListOfMapOf(keyType, valueType);
    }


    public Level0ListOfMapOperator<?,?,I> asListOfMapOfUnknown() {
        return asListOfMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    
    
    


	@SuppressWarnings("unchecked")
	public Level0ArrayOfMapOperator<K, V,I> toArrayOfMap() {
	    return new Level0ArrayOfMapOperatorImpl<K, V, I>(getTarget().execute(new ToArray.FromCollection<Map<K,V>>((Type<Map<K,V>>)(Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)));
    }


	public <K1> Level0MapOfMapOperator<K1, K, V,I> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
        return new Level0MapOfMapOperatorImpl<K1, K, V, I>(getTarget().execute(new ToMap.FromListByKeyEval<K1,Map<K,V>>(keyEval)));
    }


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2,I> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
        return new Level0MapOfMapOperatorImpl<K1, K2, V2, I>(getTarget().execute(new ToMap.FromListByMapBuilder<K1,Map<K2,V2>,Map<K,V>>(mapBuild)));
    }


	public Level0SetOfMapOperator<K, V,I> toSetOfMap() {
        return new Level0SetOfMapOperatorImpl<K, V, I>(getTarget().execute(new ToSet.FromCollection<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifNotNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNull());
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifNull() {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNull());
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListOfMapSelectedOperator<K, V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K, V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y,I> convert(final IConverter<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> converter) {
        return new Level0ListOfMapOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.LIST_OF_MAP));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y,I> eval(final IEvaluator<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> eval) {
        return new Level0ListOfMapOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.LIST_OF_MAP));
    }


    public <X, Y> Level0ListOfMapOperator<X, Y,I> exec(final IFunction<? extends List<? extends Map<X, Y>>, ? super List<Map<K, V>>> function) {
        return new Level0ListOfMapOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.LIST_OF_MAP));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<Map<K, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<Map<K, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<Map<K, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ListOfMapOperator<K, V,I> replaceWith(final List<Map<K, V>> replacement) {
        return new Level0ListOfMapOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOfMapOperator<K, V,I> replaceIfNullWith(final List<Map<K, V>> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<Map<K, V>>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<List<Map<K, V>>, I>(ocTarget);
    }
    
    
    
    
}
