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
package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
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
public class Level0ListOfListOperator<T> extends Operator
        implements ILevel0ListOfListOperator<T>  {

    
    public Level0ListOfListOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfListOperator<T> add(final List<T>... newElements) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.Add<List<T>>(newElements)));
    }


    public ILevel0ListOfListOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.Insert<List<T>>(position, newElements)));
    }


    public ILevel0ListOfListOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.AddAll<List<T>>(collection)));
    }


    public ILevel0ListOfListOperator<T> distinct() {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.Distinct<List<T>>()));
    }


    public ILevel0ListOperator<T> flatten() {
        return new Level0ListOperator<T>(getTarget().execute(new ListFuncs.FlattenListOfLists<T>()));
    }


    public ILevel1ListOfListElementsOperator<T> forEach() {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate());
    }


    public ILevel1ListOfListElementsOperator<T> forEachIndex(final int... indices) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate(indices));
    }


    


    public ILevel1ListOfListElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterate(eval));
    }

    public ILevel1ListOfListElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNot(eval));
    }

    public ILevel1ListOfListElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNullOrNot(eval));
    }

    public ILevel1ListOfListElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNotNullAndNot(eval));
    }


    public ILevel1ListOfListElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListOfListElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ListOfListElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ListOfListElementsOperator<T> forEachNotNull() {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel1ListOfListElementsOperator<T> forEachNull() {
        return new Level1ListOfListElementsOperator<T>(getTarget().iterateNull());
    }


    public <X> ILevel0ListOfListOperator<X> of(final Type<X> of) {
        return new Level0ListOfListOperator<X>(getTarget());
    }


    public ILevel0ListOfListOperator<?> raw() {
        return new Level0ListOfListOperator<T>(getTarget());
    }


    public ILevel0ListOfListOperator<T> removeIndexes(final int... indices) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<List<T>>(indices)));
    }


    public ILevel0ListOfListOperator<T> removeEquals(final List<T>... values) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<List<T>>(values)));
    }


    public ILevel0ListOfListOperator<T> removeMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<List<T>>(eval)));
    }

    public ILevel0ListOfListOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<List<T>>(eval)));
    }

    public ILevel0ListOfListOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<List<T>>(eval)));
    }

    public ILevel0ListOfListOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<List<T>>(eval)));
    }


    public ILevel0ListOfListOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<List<T>>(eval)));
    }


    public ILevel0ListOfListOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<List<T>>(eval)));
    }


    public ILevel0ListOfListOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<List<T>>(indices)));
    }


    public ILevel0ListOfListOperator<T> removeNulls() {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<List<T>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOfListOperator<T> sort() {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel0ListOfListOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ListOfListOperator<T>(getTarget().execute(new ListFuncs.SortByComparator<List<T>>(comparator)));
    }


    public ILevel0ArrayOfArrayOperator<T> toArrayOfArray(final Type<T> of) {
        return Op.onArrayOfArray(Op.onList(forEach().toArray(of).get()).toArray(Types.arrayOf(of)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfListOperator<T> toArrayOfList() {
        return Op.onArrayOfList(Op.onList(get()).toArray((Type<List<T>>)((Type<?>)Types.LIST_OF_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K> ILevel0ArrayOfMapOperator<K, T> toArrayOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(keyEval).get()).toArray((Type<Map<K, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public <K, V> ILevel0ArrayOfMapOperator<K, V> toArrayOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onArrayOfMap(Op.onList(forEach().toMap(mapBuild).get()).toArray((Type<Map<K, V>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfSetOperator<T> toArrayOfSet() {
        return Op.onArrayOfSet(Op.onList(forEach().toSet().get()).toArray((Type<Set<T>>)((Type<?>)Types.SET_OF_UNKNOWN)).get());
    }


    public ILevel0ListOfArrayOperator<T> toListOfArray(final Type<T> of) {
        return forEach().toArray(of).endFor();
    }


    public <K> ILevel0ListOfMapOperator<K, T> toListOfMap(final IEvaluator<K, ? super T> keyEval) {
        return forEach().toMap(keyEval).endFor();
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> toListOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return forEach().toMap(mapBuild).endFor();
    }


    public ILevel0ListOfSetOperator<T> toListOfSet() {
        return forEach().toSet().endFor();
    }


    public ILevel0SetOfArrayOperator<T> toSetOfArray(final Type<T> of) {
        return Op.onSetOfArray(of, Op.onList(forEach().toArray(of).get()).toSet().get());
    }


    public ILevel0SetOfListOperator<T> toSetOfList() {
        return Op.onSetOfList(Op.onList(get()).toSet().get());
    }


    public <K> ILevel0SetOfMapOperator<K, T> toSetOfMap(final IEvaluator<K, ? super T> keyEval) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(keyEval).get()).toSet().get());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> toSetOfMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return Op.onSetOfMap(Op.onList(forEach().toMap(mapBuild).get()).toSet().get());
    }


    public ILevel0SetOfSetOperator<T> toSetOfSet() {
        return Op.onSetOfSet(Op.onList(forEach().toSet().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public ILevel0ArrayOfMapOperator<T, T> toArrayOfMap() {
        return Op.onArrayOfMap(Op.onList(forEach().toMap().get()).toArray((Type<Map<T, T>>)((Type<?>)Types.MAP_OF_UNKNOWN_UNKNOWN)).get());
    }


    public ILevel0ListOfMapOperator<T, T> toListOfMap() {
        return forEach().toMap().endFor();
    }


    public ILevel0SetOfMapOperator<T, T> toSetOfMap() {
        return Op.onSetOfMap(Op.onList(forEach().toMap().get()).toSet().get());
    }


    @SuppressWarnings("unchecked")
    public List<List<T>> get() {
        return (List<List<T>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<List<T>>> generic() {
        return new Level0GenericUniqOperator<List<List<T>>>(getTarget());
    }

    
    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super List<List<T>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<List<T>>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super List<List<T>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    


    public <X> ILevel0ListOfListOperator<X> asListOfList(final Type<X> of) {
        Validate.notNull(of, "A type representing the elements must be specified");
        return new Level0ListOfListOperator<X>(getTarget());
    }


    public ILevel0ListOfListOperator<?> asListOfListOfUnknown() {
        return asListOfList(Types.OBJECT);
    }
    
    
    
    
}
