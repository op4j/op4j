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
package org.op4j.operators.impl.op.array;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.FnArray;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperator;
import org.op4j.operators.intf.array.ILevel0ArraySelectedOperator;
import org.op4j.operators.qualities.UniqOpOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level0ArraySelectedOperator<I,T> extends AbstractOperator implements UniqOpOperator<I,T[]>, ILevel0ArraySelectedOperator<I,T> {


    private final Type<T> type;


    public Level0ArraySelectedOperator(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1ArraySelectedElementsOperator<I,T> forEach() {
        return new Level1ArraySelectedElementsOperator<I,T>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArraySelectedOperator<I,T> distinct() {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().distinct()));
    }


    public Level0ArraySelectedOperator<I,T> insertAll(final int position, final T... newElements) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().insert(position, newElements)));
    }


    public Level0ArraySelectedOperator<I,T> removeAllIndexes(final int... indexes) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllIndexes(indexes)));
    }


    public Level0ArraySelectedOperator<I,T> removeAllEqual(final T... values) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllEqual(values)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> removeAllTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> removeAllFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> removeAllNullOrFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNullOrFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> removeAllNotNullAndFalse(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNotNullAndFalse((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> removeAllNotNullAndTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNotNullAndTrue((IFunction)eval)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> removeAllNullOrTrue(final IFunction<? super T,Boolean> eval) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNullOrTrue((IFunction)eval)));
    }


    public Level0ArraySelectedOperator<I,T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllIndexesNot(indexes)));
    }


    public Level0ArraySelectedOperator<I,T> removeAllNull() {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().removeAllNull()));
    }


    public Level0ArraySelectedOperator<I,T> execIfNotNullAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().executeIfNotNull(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperator<I,T> execAsArray(final IFunction<? super T[],? extends T[]> function) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level0ArraySelectedOperator<I,T> mapIfNotNull(final IFunction<? super T,? extends T> function) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().mapIfNotNull(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level0ArrayOperator<I,T> endIf() {
        return new Level0ArrayOperator<I,T>(this.type, getTarget().endSelect());
    }


    public Level0ArraySelectedOperator<I,T> add(final T newElement) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().add(newElement)));
    }


    public Level0ArraySelectedOperator<I,T> addAll(final T... newElements) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().add(newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> addAll(final Collection<T> collection) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().addAll((Collection)collection)));
    }


    public Level0ArraySelectedOperator<I,T> insert(final int position, final T newElement) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().insert(position, newElement)));
    }


    public Level0ArraySelectedOperator<I,T> sort() {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().sort()));
    }


    @SuppressWarnings("unchecked")
    public Level0ArraySelectedOperator<I,T> sort(final Comparator<? super T> comparator) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().execute(FnArray.ofObject().sort((Comparator)comparator)));
    }


    public Level0ArraySelectedOperator<I,T> map(final IFunction<? super T,? extends T> function) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level0ArraySelectedOperator<I,T> replaceWith(final T[] replacement) {
        return new Level0ArraySelectedOperator<I,T>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public T[] get() {
        return endIf().get();
    }



}
