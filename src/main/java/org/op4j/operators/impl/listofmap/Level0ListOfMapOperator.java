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

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.generic.Level0GenericUniqOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0ListOfMapOperator<K,V> extends Operator
        implements ILevel0ListOfMapOperator<K,V>  {

    
    public Level0ListOfMapOperator(final Target target) {
        super(target);
    }


    public ILevel0ListOfMapOperator<K, V> add(final Map<K, V>... newElements) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.Add<Map<K, V>>(newElements)));
    }


    public ILevel0ListOfMapOperator<K, V> insert(final int position, final Map<K, V>... newElements) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.Insert<Map<K, V>>(position, newElements)));
    }


    public ILevel0ListOfMapOperator<K, V> addAll(final Collection<Map<K, V>> collection) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.AddAll<Map<K, V>>(collection)));
    }


    public ILevel0ListOfMapOperator<K, V> distinct() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.Distinct<Map<K, V>>()));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEach() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel1ListOfMapElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterate(eval));
    }

    public ILevel1ListOfMapElementsOperator<K, V> forEachNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNot(eval));
    }

    public ILevel1ListOfMapElementsOperator<K, V> forEachNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNullOrNot(eval));
    }

    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNullAndNot(eval));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel1ListOfMapElementsOperator<K, V> forEachNotNull() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel1ListOfMapElementsOperator<K, V> forEachNull() {
        return new Level1ListOfMapElementsOperator<K, V>(getTarget().iterateNull());
    }


    public <X, Y> ILevel0ListOfMapOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        return new Level0ListOfMapOperator<X, Y>(getTarget());
    }


    public ILevel0ListOfMapOperator<?, ?> raw() {
        return new Level0ListOfMapOperator<K, V>(getTarget());
    }


    public ILevel0ListOfMapOperator<K, V> removeIndexes(final int... indices) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveIndexes<Map<K, V>>(indices)));
    }


    public ILevel0ListOfMapOperator<K, V> removeEquals(final Map<K, V>... values) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveEquals<Map<K, V>>(values)));
    }


    public ILevel0ListOfMapOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveMatching<Map<K, V>>(eval)));
    }

    public ILevel0ListOfMapOperator<K, V> removeNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotMatching<Map<K, V>>(eval)));
    }

    public ILevel0ListOfMapOperator<K, V> removeNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<Map<K, V>>(eval)));
    }

    public ILevel0ListOfMapOperator<K, V> removeNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<Map<K, V>>(eval)));
    }


    public ILevel0ListOfMapOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<Map<K, V>>(eval)));
    }


    public ILevel0ListOfMapOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super Map<K, V>> eval) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<Map<K, V>>(eval)));
    }


    public ILevel0ListOfMapOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveIndexesNot<Map<K, V>>(indices)));
    }


    public ILevel0ListOfMapOperator<K, V> removeNulls() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNulls<Map<K, V>>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel0ListOfMapOperator<K, V> sort() {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel0ListOfMapOperator<K, V> sort(final Comparator<? super Map<K, V>> comparator) {
        return new Level0ListOfMapOperator<K, V>(getTarget().execute(new ListFuncs.SortByComparator<Map<K, V>>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public List<Map<K, V>> get() {
        return (List<Map<K,V>>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<List<Map<K, V>>> generic() {
        return new Level0GenericUniqOperator<List<Map<K, V>>>(getTarget());
    }

    
    
    
    
    
    
    
    
	public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super List<Map<K,V>>> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super List<Map<K,V>>> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super List<Map<K,V>>> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
	}

    
    
    
    

    public <X,Y> ILevel0ListOfMapOperator<X,Y> asListOfMap(final Type<X> keyOf, final Type<Y> valueOf) {
        Validate.notNull(keyOf, "A type representing the keys must be specified");
        Validate.notNull(valueOf, "A type representing the values must be specified");
        return new Level0ListOfMapOperator<X,Y>(getTarget());
    }


    public ILevel0ListOfMapOperator<?,?> asListOfMapOfUnknown() {
        return asListOfMap(Types.OBJECT, Types.OBJECT);
    }
    
    
    
    
    
    
    
    
}
