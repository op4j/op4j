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

import org.op4j.select.ISelector;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IModifiableShrinkableOperator<T> {

    public IModifiableGrowableOperator<T> removeIndexes(final int... indices);
    public IModifiableGrowableOperator<T> removeEquals(final T... values);
    public IModifiableGrowableOperator<T> removeMatching(final String expression, final Object... optionalExpParams);
    public IModifiableGrowableOperator<T> removeSelected(final ISelector<T> filter);
    public IModifiableGrowableOperator<T> removeIndexesNot(final int... indices);
    public IModifiableGrowableOperator<T> removeNulls();
    public IModifiableGrowableOperator<T> removeNotNullMatching(final String expression, final Object... optionalExpParams);
    
    
}
