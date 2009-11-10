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

import org.op4j.executables.ISelect;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IModifiableCollectionOperator<T> {
    
    public IModifiableCollectionOperator<T> add(final T newElement);
    public IModifiableCollectionOperator<T> add(final int position, final T newElement);
    public IModifiableCollectionOperator<T> addAllValues(final T... newElements);
    public IModifiableCollectionOperator<T> addAllValues(final int position, final T... newElements);
    public IModifiableCollectionOperator<T> addAll(final Collection<T> collection);
    public IModifiableCollectionOperator<T> remove(final int position);
    public IModifiableCollectionOperator<T> removeValue(final T value);
    public IModifiableCollectionOperator<T> removeAll(final int... positions);
    public IModifiableCollectionOperator<T> removeAllValues(final T... values);
    public IModifiableCollectionOperator<T> removeAll(final String expression, final Object... optionalExpParams);
    public IModifiableCollectionOperator<T> removeAll(final ISelect<T> selector);
    public IModifiableCollectionOperator<T> removeAllNot(final int... positions);
    public IModifiableCollectionOperator<T> removeAllValuesNot(final T... values);
    public IModifiableCollectionOperator<T> removeAllNull();
    public IModifiableCollectionOperator<T> removeAllNullOr(final String expression, final Object... optionalExpParams);
    public IModifiableCollectionOperator<T> removeAllNotNullAnd(final String expression, final Object... optionalExpParams);
    
}
