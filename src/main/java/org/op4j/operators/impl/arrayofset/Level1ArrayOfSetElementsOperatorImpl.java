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
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.array.Level1ArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayofarray.Level1ArrayOfArrayElementsOperatorImpl;
import org.op4j.operators.impl.arrayoflist.Level1ArrayOfListElementsOperatorImpl;
import org.op4j.operators.impl.arrayofmap.Level1ArrayOfMapElementsOperatorImpl;
import org.op4j.operators.intf.array.Level1ArrayElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArrayElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListElementsOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapElementsOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class Level1ArrayOfSetElementsOperatorImpl<T> extends AbstractOperatorImpl
        implements Level1ArrayOfSetElementsOperator<T>  {

    
    public Level1ArrayOfSetElementsOperatorImpl(final Target target) {
        super(target);
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T> add(final T newElement) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }

    public Level1ArrayOfSetElementsOperator<T> addAll(final T... newElements) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T> insert(final int position, final T newElement) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }

    public Level1ArrayOfSetElementsOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ArrayOfSetElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level0ArrayOfSetOperator<T> endFor() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().endIterate(Set.class));
    }


    public Level2ArrayOfSetElementsElementsOperator<T> forEach() {
        return new Level2ArrayOfSetElementsElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T> removeAllFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T> removeAllNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }

    public Level1ArrayOfSetElementsOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ArrayOfSetElementsOperator<T> removeAllNull() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }

    


    @SuppressWarnings("unchecked")
    public Level1ArrayOfSetElementsOperator<T> sort() {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ArrayOfSetElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ArrayOfArrayElementsOperator<T> toArrayOf(final Type<T> type) {
        return new Level1ArrayOfArrayElementsOperatorImpl<T>(type, getTarget().execute(new ToArray.FromCollection<T>(type)));
    }


    public Level1ArrayOfListElementsOperator<T> toList() {
        return new Level1ArrayOfListElementsOperatorImpl<T>(getTarget().execute(new ToList.FromCollection<T>()));
    }


    public Level1ArrayOfMapElementsOperator<T, T> toMap() {
        return new Level1ArrayOfMapElementsOperatorImpl<T, T>(getTarget().execute(new ToMap.FromSetByAlternateElements<T>()));
    }

    
    public <K> Level1ArrayOfMapElementsOperator<K, T> toMap(final IFunction<K, ? super T> keyEval) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, T>(getTarget().execute(new ToMap.FromSetByKeyEval<K, T>(keyEval)));
    }


    public <K, V> Level1ArrayOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1ArrayOfMapElementsOperatorImpl<K, V>(getTarget().execute(new ToMap.FromSetByMapBuilder<K, V, T>(mapBuild)));
    }


    public Set<T>[] get() {
        return endFor().get();
    }

    
    
    
    
    
    
    
    
	public <X> Level1ArrayOfSetElementsOperator<X> asSetOf(final Type<X> type) {
        return endFor().generic().asArrayOfSetOf(type).forEach();
    }


    public Level1ArrayOfSetElementsOperator<?> asSetOfUnknown() {
        return asSetOf(Types.OBJECT);
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super Set<T>> eval) {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public <X> Level1ArrayOfSetElementsOperator<X> execIfNotNullAsSet(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level1ArrayOfSetElementsOperatorImpl<X>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public <X> Level1ArrayOfSetElementsOperator<X> execAsSet(final IFunction<? extends Set<X>, ? super Set<T>> function) {
        return new Level1ArrayOfSetElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.SET));
    }


    public <X> Level1ArrayElementsOperator<X> execIfNotNull(final Type<X> resultType, final IFunction<X, ? super Set<T>> function) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public <X> Level1ArrayElementsOperator<X> exec(final Type<X> resultType, final IFunction<X, ? super Set<T>> function) {
        return new Level1ArrayElementsOperatorImpl<X>(resultType, getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ArrayOfSetElementsOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1ArrayOfSetElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Level1ArrayOfSetElementsOperator<T> replaceIfNullWith(final Set<T> replacement) {
        return ifNull().replaceWith(replacement).endIf();
    }




    public <X> Level1ArrayOfSetElementsOperator<X> map(final IFunction<X, ? super T> function) {
        return new Level1ArrayOfSetElementsOperatorImpl<X>(getTarget().map(Structure.SET, function, null));
    }

    
    
    

}
