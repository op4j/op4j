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
package org.op4j.operators.impl.op.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.FnList;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ListSelectedOperatorImpl<I,T> extends AbstractOperatorImpl implements UniqOpOperator<I,List<T>>, Level0ListSelectedOperator<I,T> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperatorImpl<I,T> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<I,T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListSelectedOperatorImpl<I,T> distinct() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().distinct()));
    }


    public Level0ListSelectedOperatorImpl<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElements)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0ListSelectedOperatorImpl<I,T> removeAllNull() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().removeAllNull()));
    }


    public Level0ListSelectedOperatorImpl<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().mapIfNotNull(Structure.LIST, function, null));
    }


    public Level0ListOperatorImpl<I,T> endIf() {
        return new Level0ListOperatorImpl<I,T>(getTarget().endSelect());
    }


    public Level0ListSelectedOperatorImpl<I,T> execIfNotNullAsList(final IFunction<? super List<T>,? extends List<? extends T>> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().executeIfNotNull(function, Normalisation.LIST));
    }


    public Level0ListSelectedOperatorImpl<I,T> execAsList(final IFunction<? super List<T>,? extends List<? extends T>> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(function, Normalisation.LIST));
    }


    public Level0ListSelectedOperatorImpl<I,T> add(final T newElement) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().add(newElement)));
    }


    public Level0ListSelectedOperatorImpl<I,T> addAll(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().add(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().addAll((Collection)collection)));
    }


    public Level0ListSelectedOperatorImpl<I,T> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().insert(position, newElement)));
    }


    public Level0ListSelectedOperatorImpl<I,T> sort() {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperatorImpl<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().execute(FnList.ofObject().sort((Comparator)comparator)));
    }


    public Level0ListSelectedOperatorImpl<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().map(Structure.LIST, function, null));
    }


    public Level0ListSelectedOperatorImpl<I,T> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperatorImpl<I,T>(getTarget().replaceWith(replacement, Normalisation.LIST));
    }


    public List<T> get() {
        return endIf().get();
    }



}
