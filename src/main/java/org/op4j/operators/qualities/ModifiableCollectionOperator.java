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
package org.op4j.operators.qualities;

import java.util.Collection;

import org.op4j.functions.evaluators.IEvaluator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ModifiableCollectionOperator<T,I> {
    
    public ModifiableCollectionOperator<T,I> add(final T newElement);
    public ModifiableCollectionOperator<T,I> addAll(final T... newElements);
    public ModifiableCollectionOperator<T,I> insert(final int position, final T newElement);
    public ModifiableCollectionOperator<T,I> insertAll(final int position, final T... newElements);
    public ModifiableCollectionOperator<T,I> addAll(final Collection<T> collection);
    public ModifiableCollectionOperator<T,I> removeAllIndexes(final int... indices);
    public ModifiableCollectionOperator<T,I> removeAllEqual(final T... values);
    public ModifiableCollectionOperator<T,I> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T,I> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T,I> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T,I> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T,I> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T,I> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T,I> removeAllIndexesNot(final int... indices);
    public ModifiableCollectionOperator<T,I> removeAllNull();
    
}
