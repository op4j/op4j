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
package org.op4j.operators.impl.op.set;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.FnSet;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.set.ILevel0SetSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0SetSelectedOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,Set<T>>, ILevel0SetSelectedOperator<I,T> {


    public Level0SetSelectedOperator(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperator<I,T> forEach() {
        return new Level1SetSelectedElementsOperator<I,T>(getTarget().iterate(Structure.SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> sortBy(final IFunction<? super T,?> by) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().sortBy((IFunction)by)));
    }


    public Level0SetSelectedOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElements)));
    }


    public Level0SetSelectedOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexes(indexes)));
    }


    public Level0SetSelectedOperator<I,T> removeAllEqual(final T... values) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    public Level0SetSelectedOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0SetSelectedOperator<I,T> removeAllNull() {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().removeAllNull()));
    }


    public Level0SetOperator<I,T> endIf() {
        return new Level0SetOperator<I,T>(getTarget().endSelect());
    }


    public Level0SetSelectedOperator<I,T> execAsSet(final IFunction<? super Set<T>,? extends Set<? extends T>> function) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(function, Normalisation.SET));
    }


    public Level0SetSelectedOperator<I,T> add(final T newElement) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().add(newElement)));
    }


    public Level0SetSelectedOperator<I,T> addAll(final T... newElements) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().add(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().addAll((Collection)collection)));
    }


    public Level0SetSelectedOperator<I,T> insert(final int position, final T newElement) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().insert(position, newElement)));
    }


    public Level0SetSelectedOperator<I,T> sort() {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0SetSelectedOperator<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0SetSelectedOperator<I,T>(getTarget().execute(FnSet.ofObject().sort((Comparator)comparator)));
    }


    public Level0SetSelectedOperator<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0SetSelectedOperator<I,T>(getTarget().map(Structure.SET, function, null));
    }


    public Level0SetSelectedOperator<I,T> replaceWith(final Set<T> replacement) {
        return new Level0SetSelectedOperator<I,T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
