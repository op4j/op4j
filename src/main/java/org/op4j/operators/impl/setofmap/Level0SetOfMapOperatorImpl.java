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
import org.op4j.Op;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.generic.Level0GenericUniqOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0SetOfMapOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level0SetOfMapOperator<K,V>  {

    
    public Level0SetOfMapOperatorImpl(final Target target) {
        super(target);
    }


    public Level0SetOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Add<Map<K, V>>(newElements)));
    }


    public Level0SetOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Insert<Map<K, V>>(position, newElements)));
    }


    public Level0SetOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.AddAll<Map<K, V>>(collection)));
    }


    public Level1SetOfMapElementsOperator<K, V> forEach() {
        return new Level1SetOfMapElementsOperatorImpl<K, V>(getTarget().iterate());
    }


    public Level0SetOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveIndexes<Map<K, V>>(indices)));
    }


    public Level0SetOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveEquals<Map<K, V>>(values)));
    }


    public Level0SetOfMapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveMatching<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveNotMatching<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<Map<K, V>>(eval)));
    }

    public Level0SetOfMapOperator<K, V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<Map<K, V>>(eval)));
    }


    public Level0SetOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveIndexesNot<Map<K, V>>(indices)));
    }


    public Level0SetOfMapOperator<K, V> removeNulls() {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.RemoveNulls<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level0SetOfMapOperator<K, V> sort() {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0SetOfMapOperatorImpl<K, V>(getTarget().execute(new SetFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Set<Map<K, V>> get() {
        return (Set<Map<K,V>>) getTarget().get();
    }


    public Level0GenericUniqOperator<Set<Map<K, V>>> generic() {
        return new Level0GenericUniqOperatorImpl<Set<Map<K, V>>>(getTarget());
    }

    
    
    
    
    
    
    
	public <X,Y> Level0SetOfMapOperator<X,Y> asSetOfMapOf(final Type<X> keyType, final Type<Y> valueType) {
    	return generic().asSetOfMapOf(keyType, valueType);
    }


    public Level0SetOfMapOperator<?,?> asSetOfMapOfUnknown() {
        return asSetOfMapOf(Types.OBJECT, Types.OBJECT);
    }
    
    

	@SuppressWarnings("unchecked")
	public Level0ArrayOfMapOperator<K, V> toArrayOfMap() {
		return Op.onArrayOfMap((Map<K, V>[]) Op.onSet(get()).asSetOf(Types.MAP_OF_UNKNOWN_UNKNOWN).toArray(Types.MAP_OF_UNKNOWN_UNKNOWN).get());
	}


	public Level0ListOfMapOperator<K, V> toListOfMap() {
		return Op.onListOfMap(Op.onSet(get()).toList().get());
	}


	public <K1> Level0MapOfMapOperator<K1, K, V> toMapOfMap(final IEvaluator<K1, ? super Map<K, V>> keyEval) {
		return Op.onMapOfMap(Op.onSet(get()).toMap(keyEval).get());
	}


	public <K1, K2, V2> Level0MapOfMapOperator<K1, K2, V2> toMapOfMap(final IMapBuilder<K1, Map<K2, V2>, ? super Map<K, V>> mapBuild) {
		return Op.onMapOfMap(Op.onSet(get()).toMap(mapBuild).get());
	}


    public Level0SetOfMapSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifMatching(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotMatching(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNull());
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNull());
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrMatching(eval));
    }


    public Level0SetOfMapSelectedOperator<K, V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K, V>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y> convert(final IConverter<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> converter) {
        return new Level0SetOfMapOperatorImpl<X, Y>(getTarget().execute(converter));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y> eval(final IEvaluator<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> eval) {
        return new Level0SetOfMapOperatorImpl<X, Y>(getTarget().execute(eval));
    }


    public <X, Y> Level0SetOfMapOperator<X, Y> exec(final IFunction<? extends Set<? extends Map<X, Y>>, ? super Set<Map<K, V>>> function) {
        return new Level0SetOfMapOperatorImpl<X, Y>(getTarget().execute(function));
    }


    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Set<Map<K, V>>> converter) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(converter));
    }


    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Set<Map<K, V>>> eval) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(eval));
    }


    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<Map<K, V>>> function) {
        return new Level0GenericUniqOperatorImpl<X>(getTarget().execute(function));
    }
    
    
}
