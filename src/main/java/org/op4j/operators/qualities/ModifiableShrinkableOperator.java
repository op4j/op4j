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

import org.op4j.functions.evaluators.IEvaluator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ModifiableShrinkableOperator<T> {

    public ModifiableGrowableOperator<T> removeAllIndexes(final int... indices);
    public ModifiableGrowableOperator<T> removeAllEqual(final T... values);
    public ModifiableGrowableOperator<T> removeAllTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableGrowableOperator<T> removeAllFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableGrowableOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableGrowableOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableGrowableOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableGrowableOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public ModifiableGrowableOperator<T> removeAllIndexesNot(final int... indices);
    public ModifiableGrowableOperator<T> removeAllNull();
    
}
