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
package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

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
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.set.Level1SetElementsOperator;
import org.op4j.operators.impl.setofarray.Level1SetOfArrayElementsOperator;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel2SetOfListElementsElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfListElementsOperator<T> extends Operator
        implements ILevel1SetOfListElementsOperator<T>  {

    
    public Level1SetOfListElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1SetOfListElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public ILevel1SetOfListElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1SetOfListElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel1SetOfListElementsOperator<T> distinct() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public ILevel0SetOfListOperator<T> endFor() {
        return new Level0SetOfListOperator<T>(getTarget().endIterate(Structure.SET, null));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEach() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateIndex(indices));
    }


    


    public ILevel2SetOfListElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateMatching(eval));
    }

    public ILevel2SetOfListElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotMatching(eval));
    }

    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNullOrNotMatching(eval));
    }

    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNullAndNotMatching(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNullAndMatching(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNullOrMatching(eval));
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateIndexNot(indices));
    }


    








    public ILevel2SetOfListElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2SetOfListElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfListElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1SetOfListElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1SetOfListElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1SetOfListElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }

    public ILevel1SetOfListElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }

    public ILevel1SetOfListElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public ILevel1SetOfListElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public ILevel1SetOfListElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1SetOfListElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1SetOfListElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1SetOfListElementsOperator<T> removeNulls() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1SetOfListElementsOperator<T> sort() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel1SetOfListElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1SetOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1SetOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromListByAlternateElements<T>()));
    }


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1SetOfSetElementsOperator<T> toSet() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromCollection<T>()));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }

    
    
    
    
    
	public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X, ? super List<T>> converter) {
        return new Level1SetElementsOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X, ? super List<T>> eval) {
        return new Level1SetElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super List<T>> function) {
        return new Level1SetElementsOperator<X>(getTarget().execute(function));
	}

    

    public <X> ILevel1SetOfListElementsOperator<X> asListOf(final Type<X> type) {
    	return endFor().generic().asSetOfListOf(type).forEach();
    }


    public ILevel1SetOfListElementsOperator<?> asListOfUnknown() {
        return asListOf(Types.OBJECT);
    }
    
    
    
}
