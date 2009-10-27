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

import org.op4j.op.intf.parameters.ISelect;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IExtractableOperator<T> {
    
    public IOperator extract(final int position);
    public IOperator extract(final T value);
    public IOperator extractAll(final int... positions);
    public IOperator extractAll(final T... values);
    public IOperator extractAll(final String expression, final Object... optionalExpParams);
    public IOperator extractAll(final ISelect<T> selector);
    public IOperator extractAllBut(final int... positions);
    public IOperator extractAllBut(final T... values);
    public IOperator extractAllBut(final String expression, final Object... optionalExpParams);
    public IOperator extractAllBut(final ISelect<T> selector);
    
}
