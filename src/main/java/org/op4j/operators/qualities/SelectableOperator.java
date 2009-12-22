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
public interface SelectableOperator<T>  {
    
    public SelectedOperator<T> ifIndex(final int... indices);
    public SelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval);
    public SelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public SelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public SelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public SelectedOperator<T> ifNull();
    public SelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public SelectedOperator<T> ifIndexNot(final int... indices);
    public SelectedOperator<T> ifNotNull();
    public SelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval);
    
}
