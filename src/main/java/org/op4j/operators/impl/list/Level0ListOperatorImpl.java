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
package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

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
import org.op4j.operators.impl.array.Level0ArrayOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.impl.map.Level0MapOperatorImpl;
import org.op4j.operators.impl.set.Level0SetOperatorImpl;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.Level0ListOfListOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.map.Level0MapOperator;
import org.op4j.operators.intf.set.Level0SetOperator;
import org.op4j.target.OperationChainingTarget;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOperatorImpl<T,I> extends AbstractOperatorImpl
        implements Level0ListOperator<T,I>  {

    
    public Level0ListOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T,I> add(final T newElement) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }

    public Level0ListOperator<T,I> addAll(final T... newElements) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T,I> insert(final int position, final T newElement) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }

    public Level0ListOperator<T,I> insertAll(final int position, final T... newElements) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0ListOperator<T,I> addAll(final Collection<T> collection) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level0ListOperator<T,I> distinct() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListElementsOperator<T,I> forEach() {
        return new Level1ListElementsOperatorImpl<T,I>(getTarget().iterate());
    }


    public Level0ListOperator<T,I> removeAllIndexes(final int... indices) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level0ListOperator<T,I> removeAllEqual(final T... values) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ListOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level0ListOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level0ListOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level0ListOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListOperator<T,I> removeAllIndexesNot(final int... indices) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level0ListOperator<T,I> removeAllNull() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0ListOperator<T,I> sort() {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOperator<T,I> sort(final Comparator<? super T> comparator) {
        return new Level0ListOperatorImpl<T,I>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ArrayOperator<T,I> toArray(final Type<T> of) {
        return new Level0ArrayOperatorImpl<T,I>(getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public Level0MapOperator<T, T,I> toMap() {
        return new Level0MapOperatorImpl<T, T,I>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }

    public <K> Level0MapOperator<K, T,I> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperatorImpl<K, T,I>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level0MapOperator<K, V,I> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperatorImpl<K, V,I>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public Level0SetOperator<T,I> toSet() {
        return new Level0SetOperatorImpl<T,I>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    @SuppressWarnings("unchecked")
    public List<T> get() {
        return (List<T>) getTarget().get();
    }


    public Level0GenericUniqOperator<List<T>,I> generic() {
        return new Level0GenericUniqOperatorImpl<List<T>,I>(getTarget());
    }
    
    
    
    
    
	public <X> Level0ListOperator<X,I> asListOf(final Type<X> type) {
        return generic().asListOf(type);
    }


    public <X> Level0ListOfArrayOperator<X,I> asListOfArrayOf(final Type<X> type) {
        return generic().asListOfArrayOf(type);
    }


    public Level0ListOfArrayOperator<?,I> asListOfArrayOfUnknown() {
        return asListOfArrayOf(Types.OBJECT);
    }


    public <X> Level0ListOfListOperator<X,I> asListOfListOf(final Type<X> type) {
        return generic().asListOfListOf(type);
    }


    public Level0ListOfListOperator<?,I> asListOfListOfUnknown() {
        return asListOfListOf(Types.OBJECT);
    }


    public <K, V> Level0ListOfMapOperator<K, V,I> asListOfMapOf(final Type<K> keyType, final Type<V> valueType) {
        return generic().asListOfMapOf(keyType, valueType);
    }


    public Level0ListOfMapOperator<?, ?,I> asListOfMapOfUnknown() {
        return asListOfMapOf(Types.OBJECT, Types.OBJECT);
    }


    public <X> Level0ListOfSetOperator<X,I> asListOfSetOf(final Type<X> type) {
        return generic().asListOfSetOf(type);
    }


    public Level0ListOfSetOperator<?,I> asListOfSetOfUnknown() {
        return asListOfSetOf(Types.OBJECT);
    }


    public Level0ListOperator<?,I> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }


    public Level0ListSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level0ListSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level0ListSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level0ListSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level0ListSelectedOperator<T,I> ifNotNull() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level0ListSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0ListSelectedOperator<T,I> ifNull() {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level0ListSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level0ListSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level0ListOperator<X,I> convert(final IConverter<? extends List<X>, ? super List<T>> converter) {
        return new Level0ListOperatorImpl<X,I>(getTarget().execute(converter, Normalization.LIST));
    }


    public <X> Level0ListOperator<X,I> eval(final IEvaluator<? extends List<X>, ? super List<T>> eval) {
        return new Level0ListOperatorImpl<X,I>(getTarget().execute(eval, Normalization.LIST));
    }


    public <X> Level0ListOperator<X,I> exec(final IFunction<? extends List<X>, ? super List<T>> function) {
        return new Level0ListOperatorImpl<X,I>(getTarget().execute(function, Normalization.LIST));
    }


    public <X> Level0GenericUniqOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super List<T>> converter) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super List<T>> eval) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level0GenericUniqOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T>> function) {
        return new Level0GenericUniqOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level0ListOperator<T,I> replaceWith(final List<T> replacement) {
        return new Level0ListOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0ListOperator<T,I> replaceIfNullWith(final List<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }


    public Operation<List<T>, I> createOperation() {
        final Target target = getTarget();
        if (!(target instanceof OperationChainingTarget)) {
            throw new NonEmptyTargetException();
        }
        final OperationChainingTarget ocTarget = (OperationChainingTarget) target;
        if (!ocTarget.isEmpty()) {
            throw new NonEmptyTargetException();
        }
        return new Operation<List<T>, I>(ocTarget);
    }

    
    
    

}
