/*  
 * ============================================================================= 
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org) 
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
package org.op4j.operators.impl.fn.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.FnSet;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.qualities.UniqFnOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0SetSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqFnOperator<I,Set<T>>, Level0SetSelectedOperator<I,T> {


    public Level0SetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperatorImpl<I,T> forEach() {
        return new Level1SetSelectedElementsOperatorImpl<I,T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetSelectedOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElements)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexes(indexes)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0SetSelectedOperatorImpl<I,T> removeAllNull() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().removeAllNull()));
    }


    public Level0SetSelectedOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().mapIfNotNull(Structure.SET, function, null));
    }


    public Level0SetOperatorImpl<I,T> endIf() {
        return new Level0SetOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0SetSelectedOperatorImpl<I,T> execIfNotNullAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level0SetSelectedOperatorImpl<I,T> execAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.SET));
    }


    public Level0SetSelectedOperatorImpl<I,T> add(final T newElement) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().add(newElement)));
    }


    public Level0SetSelectedOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().add(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().addAll((Collection)collection)));
    }


    public Level0SetSelectedOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElement)));
    }


    public Level0SetSelectedOperatorImpl<I,T> sort() {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().execute(FnSet.ofObject().sort((Comparator)comparator)));
    }


    public Level0SetSelectedOperatorImpl<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().map(Structure.SET, function, null));
    }


    public Level0SetSelectedOperatorImpl<I,T> replaceWith(final Set<T> replacement) {
        return new Level0SetSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Function<I,Set<T>> get() {
        return endIf().get();
    }



}
