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
package org.op4j.operators.impl.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.Op;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ArrayOfMapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0ArrayOfMapOperator<K,V>  {

    
    public Level0ArrayOfMapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0ArrayOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Add<Map<K, V>>(newElements)));
    }


    public Level0ArrayOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Insert<Map<K, V>>(position, newElements)));
    }


    public Level0ArrayOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.AddAll<Map<K, V>>(collection)));
    }


    public Level0ArrayOfMapOperator<K, V> distinct() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Distinct<Map<K, V>>()));
    }


    public Level1ArrayOfMapElementsOperator<K, V> forEach() {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().iterate());
    }


    public Level0ArrayOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveIndexes<Map<K, V>>(indices)));
    }


    public Level0ArrayOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveEquals<Map<K, V>>(values)));
    }


    public Level0ArrayOfMapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveMatching<Map<K, V>>(eval)));
    }

    public Level0ArrayOfMapOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<Map<K, V>>(eval)));
    }

    public Level0ArrayOfMapOperator<K, V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<Map<K, V>>(eval)));
    }

    public Level0ArrayOfMapOperator<K, V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<Map<K, V>>(eval)));
    }


    public Level0ArrayOfMapOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Map<K, V>>(eval)));
    }


    public Level0ArrayOfMapOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Map<K, V>>(eval)));
    }


    public Level0ArrayOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<Map<K, V>>(indices)));
    }



    public Level0ArrayOfMapOperator<K, V> removeNulls() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.RemoveNulls<Map<K, V>>()));
    }

    

    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapOperator<K, V> sort() {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.Sort()));
    }

    public Level0ArrayOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ArrayOfMapOperatorImpl<K, V>(getTarget().execute(new ArrayFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
	public Map<K, V>[] get() {
        return (Map<K, V>[]) getTarget().get();
    }


    public Level0GenericUniqOperator<Map<K, V>[]> generic() {
        return new Level0GenericUniqOperatorImpl<Map<K, V>[]>(getTarget());
    }

    
    
    
    
    
    
    
    
    
    
    
	public <X> Level0GenericUniqOperator<X> convert(final IConverter<X, ? super Map<K,V>[]> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
	}


    public <X> Level0GenericUniqOperator<X> eval(final IEvaluator<X, ? super Map<K,V>[]> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final IFunction<X, ? super Map<K,V>[]> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
	}

    


    public <X,Y> Level0ArrayOfMapOperator<X,Y> asArrayOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
        return generic().asArrayOfMapOf(keyType, valueType);
    }


    public Level0ArrayOfMapOperator<?,?> asArrayOfMapOfUnknown() {
        return asArrayOfMapOf(Types.OBJECT, Types.OBJECT);
    }


	public Level0ListOfMapOperator<K, V> toListOfMap() {
		return Op.onListOfMap(Op.onArray(get()).toList().get());
	}


	public <K1> Level0MapOfMapOperator<K1, K, V> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
		return Op.onMapOfMap(Op.onArray(get()).toMap(keyEval).get());
	}


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
		return Op.onMapOfMap(Op.onArray(get()).toMap(mapBuild).get());
	}


	public Level0SetOfMapOperator<K, V> toSetOfMap() {
		return Op.onSetOfMap(Op.onArray(get()).toSet().get());
	}
    
    
}
