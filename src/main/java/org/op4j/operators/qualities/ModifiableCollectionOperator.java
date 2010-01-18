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
public interface ModifiableCollectionOperator<T> {
    
    public ModifiableCollectionOperator<T> add(final T... newElements);
    public ModifiableCollectionOperator<T> insert(final int position, final T... newElements);
    public ModifiableCollectionOperator<T> addAll(final Collection<T> collection);
    public ModifiableCollectionOperator<T> removeAllIndexes(final int... indices);
    public ModifiableCollectionOperator<T> removeAllEqual(final T... values);
    public ModifiableCollectionOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableCollectionOperator<T> removeAllIndexesNot(final int... indices);
    public ModifiableCollectionOperator<T> removeAllNull();
    
}
