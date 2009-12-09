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
package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.list.Level1ListElementsOperator;
import org.op4j.operators.impl.listoflist.Level1ListOfListElementsOperator;
import org.op4j.operators.impl.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.impl.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.list.ILevel1ListElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listofarray.ILevel1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.ILevel2ListOfArrayElementsElementsOperator;
import org.op4j.operators.intf.listoflist.ILevel1ListOfListElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofset.ILevel1ListOfSetElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1ListOfArrayElementsOperator<T> extends Operator
        implements ILevel1ListOfArrayElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level1ListOfArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1ListOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public ILevel1ListOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1ListOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public ILevel1ListOfArrayElementsOperator<T> distinct() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public ILevel0ListOfArrayOperator<T> endFor() {
        return new Level0ListOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.LIST, null));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEach() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }

    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(eval));
    }

    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOrNot(eval));
    }

    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAndNot(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2ListOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2ListOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel1ListOfArrayElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }

    public ILevel1ListOfArrayElementsOperator<T> removeNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }

    public ILevel1ListOfArrayElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }

    public ILevel1ListOfArrayElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1ListOfArrayElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public ILevel1ListOfArrayElementsOperator<T> removeNulls() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel1ListOfArrayElementsOperator<T> sort() {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel1ListOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public ILevel1ListOfListElementsOperator<T> toList() {
        return new Level1ListOfListElementsOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public ILevel1ListOfMapElementsOperator<T, T> toMap() {
        return new Level1ListOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }

    public <K> ILevel1ListOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1ListOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1ListOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1ListOfSetElementsOperator<T> toSet() {
        return new Level1ListOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public List<T[]> get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> ILevel1ListElementsOperator<X> convert(final IConverter<X, ? super T[]> converter) {
        return new Level1ListElementsOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel1ListElementsOperator<X> eval(final IEvaluator<X, ? super T[]> eval) {
        return new Level1ListElementsOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel1ListElementsOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level1ListElementsOperator<X>(getTarget().execute(function));
	}

    

    public <X> ILevel1ListOfArrayElementsOperator<X> asArray(final Type<X> of) {
    	return endFor().generic().asListOfArray(of).forEach();
    }


    public ILevel1ListOfArrayElementsOperator<?> asArrayOfUnknown() {
        return asArray(Types.OBJECT);
    }
    
    

}
