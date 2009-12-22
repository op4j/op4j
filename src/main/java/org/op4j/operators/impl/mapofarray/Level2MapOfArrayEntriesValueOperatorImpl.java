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
package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.apache.commons.lang.Validate;
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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.map.Level2MapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperatorImpl;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperatorImpl;
import org.op4j.operators.intf.map.Level2MapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;
import org.op4j.util.TargetUtils;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfArrayEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2MapOfArrayEntriesValueOperator<K,V> {
    
    private final Type<? super V> arrayOf; 

    
    public Level2MapOfArrayEntriesValueOperatorImpl(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperatorImpl<K, V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfArrayEntriesValueElementsOperatorImpl<K, V>(this.arrayOf, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeEquals(final V... values) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<V>(values)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotMatching<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<V>(eval)));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public Level2MapOfArrayEntriesValueOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<V>(indices)));
    }



    public Level2MapOfArrayEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<V>()));
    }

    
    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesValueOperator<K, V> sort() {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level2MapOfArrayEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesValueOperatorImpl<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }




    public Level2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToList.FromArray<V>()));
    }


    public Level2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, V, V>(getTarget().execute(new ToMap.FromArrayByAlternateElements<V>()));
    }


    public <K2> Level2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V>(getTarget().execute(new ToMap.FromArrayByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> Level2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperatorImpl<K, K2, V2>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Level2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperatorImpl<K, V>(getTarget().execute(new ToSet.FromArray<V>()));
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public <X> Level2MapEntriesValueOperator<K,X> convert(final IConverter<X, ? super V[]> converter) {
        return new Level2MapEntriesValueOperatorImpl<K,X>(getTarget().execute(converter));
	}


    public <X> Level2MapEntriesValueOperator<K,X> eval(final IEvaluator<X, ? super V[]> eval) {
        return new Level2MapEntriesValueOperatorImpl<K,X>(getTarget().execute(eval));
    }


    public <X> Level2MapEntriesValueOperator<K,X> exec(final IFunction<X, ? super V[]> function) {
        return new Level2MapEntriesValueOperatorImpl<K,X>(getTarget().execute(function));
	}


    
    
    public <X> Level2MapOfArrayEntriesValueOperator<K, X> asArrayOf(final Type<X> type) {
        Validate.notNull(type, "A type representing the elements must be specified");
        TargetUtils.checkIsMapOfArrayOfValue(type, get());
        return new Level2MapOfArrayEntriesValueOperatorImpl<K,X>(type, getTarget());
    }


    public Level2MapOfArrayEntriesValueOperator<K, ?> asArrayOfUnknown() {
        return asArrayOf(Types.OBJECT);
    }

    
    
    
    
}
