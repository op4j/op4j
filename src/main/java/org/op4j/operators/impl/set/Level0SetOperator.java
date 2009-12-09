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
package org.op4j.operators.impl.set;

import java.util.Collection;
import java.util.Comparator;
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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOperator<T> extends Operator
        implements ILevel0SetOperator<T>  {

    
    public Level0SetOperator(final Target target) {
        super(target);
    }


    public ILevel0SetOperator<T> add(final T... newElements) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public ILevel0SetOperator<T> insert(final int position, final T... newElements) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0SetOperator<T> addAll(final Collection<T> collection) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public ILevel1SetElementsOperator<T> forEach() {
        return new Level1SetElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1SetElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1SetElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterate(eval));
    }

    public ILevel1SetElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNot(eval));
    }

    public ILevel1SetElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNullOrNot(eval));
    }

    public ILevel1SetElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNullAndNot(eval));
    }


    public ILevel1SetElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1SetElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1SetElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1SetElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1SetElementsOperator<T> forEachNotNull() {
        return new Level1SetElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1SetElementsOperator<T> forEachNull() {
        return new Level1SetElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel0SetOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel0SetOperator<T> removeEquals(final T... values) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public ILevel0SetOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }

    public ILevel0SetOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }

    public ILevel0SetOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public ILevel0SetOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public ILevel0SetOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel0SetOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel0SetOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel0SetOperator<T> removeNulls() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0SetOperator<T> sort() {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel0SetOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0SetOperator<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel0ArrayOperator<T> toArray(final Type<T> of) {
        return new Level0ArrayOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel0ListOperator<T> toList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public ILevel0MapOperator<T, T> toMap() {
        return new Level0MapOperator<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }


    public <K> ILevel0MapOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    @SuppressWarnings("unchecked")
    public Set<T> get() {
        return (Set<T>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Set<T>> generic() {
        return new Level0GenericUniqOperator<Set<T>>(getTarget());
    }

    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super Set<T>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Set<T>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super Set<T>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}


    
    
    public <X> ILevel0SetOfArrayOperator<X> asSetOfArray(final Type<X> of) {
        return generic().asSetOfArray(of);
    }


    public ILevel0SetOfArrayOperator<?> asSetOfArrayOfUnknown() {
        return asSetOfArray(Types.OBJECT);
    }


    public <X> ILevel0SetOfListOperator<X> asSetOfList(final Type<X> of) {
        return generic().asSetOfList(of);
    }


    public ILevel0SetOfListOperator<?> asSetOfListOfUnknown() {
        return asSetOfList(Types.OBJECT);
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> asSetOfMap(final Type<K> keyOf, final Type<V> valueOf) {
    	return generic().asSetOfMap(keyOf, valueOf);
    }


    public ILevel0SetOfMapOperator<?, ?> asSetOfMapOfUnknown() {
        return asSetOfMap(Types.OBJECT, Types.OBJECT);
    }


    public <X> ILevel0SetOfSetOperator<X> asSetOfSet(final Type<X> of) {
        return generic().asSetOfSet(of);
    }


    public ILevel0SetOfSetOperator<?> asSetOfSetOfUnknown() {
        return asSetOfSet(Types.OBJECT);
    }


    public <X> ILevel0SetOperator<X> asSet(final Type<X> of) {
        return generic().asSet(of);
    }


    public ILevel0SetOperator<?> asSetOfUnknown() {
        return asSet(Types.OBJECT);
    }

    
    
    
}
