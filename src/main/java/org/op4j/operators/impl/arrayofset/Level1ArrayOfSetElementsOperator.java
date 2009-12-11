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
package org.op4j.operators.impl.arrayofset;

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
import org.op4j.operators.impl.array.Level1ArrayElementsOperator;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.array.ILevel1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.ILevel1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.ILevel1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.ILevel1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.ILevel1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.ILevel2ArrayOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ArrayOfSetElementsOperator<T> extends Operator
        implements ILevel1ArrayOfSetElementsOperator<T>  {

    
    public Level1ArrayOfSetElementsOperator(final Target target) {
        super(target);
    }


    public ILevel1ArrayOfSetElementsOperator<T> add(final T... newElements) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public ILevel0ArrayOfSetOperator<T> endFor() {
        return new Level0ArrayOfSetOperator<T>(getTarget().endIterate(Structure.ARRAY, Set.class));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterate());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateIndex(indices));
    }


    


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateMatching(eval));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNotMatching(eval));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNullOrNotMatching(eval));
    }

    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAndNotMatching(eval));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNotNullAndMatching(eval));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNullOrMatching(eval));
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateIndexNot(indices));
    }


    








    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNotNull() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNotNull());
    }


    public ILevel2ArrayOfSetElementsElementsOperator<T> forEachNull() {
        return new Level2ArrayOfSetElementsElementsOperator<T>(getTarget().iterateNull());
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeEquals(final T... values) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }

    public ILevel1ArrayOfSetElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }

    public ILevel1ArrayOfSetElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public ILevel1ArrayOfSetElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public ILevel1ArrayOfSetElementsOperator<T> removeNulls() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel1ArrayOfSetElementsOperator<T> sort() {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel1ArrayOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetElementsOperator<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1ArrayOfArrayElementsOperator<T> toArray(final Type<T> of) {
        return new Level1ArrayOfArrayElementsOperator<T>(of, getTarget().execute(new ToArray.FromCollection<T>(of)));
    }


    public ILevel1ArrayOfListElementsOperator<T> toList() {
        return new Level1ArrayOfListElementsOperator<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public ILevel1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }

    
    public <K> ILevel1ArrayOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<T>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
	public <X> ILevel1ArrayElementsOperator<X> convert(final IConverter<X, ? super Set<T>> converter) {
        return new Level1ArrayElementsOperator<X>(converter.getResultType(), getTarget().execute(converter));
	}


    public <X> ILevel1ArrayElementsOperator<X> eval(final IEvaluator<X, ? super Set<T>> eval) {
        return new Level1ArrayElementsOperator<X>(eval.getResultType(), getTarget().execute(eval));
    }


    public <X> ILevel1ArrayElementsOperator<X> exec(final IFunction<X, ? super Set<T>> function) {
        return new Level1ArrayElementsOperator<X>(function.getResultType(), getTarget().execute(function));
	}

    
    

    public <X> ILevel1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type) {
        return endFor().generic().asArrayOfSetOf(type).forEach();
    }


    public ILevel1ArrayOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }
    
    
    

}
