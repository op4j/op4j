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
package org.op4j.operators.qualities;

import org.op4j.functions.IFunction;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.util.ValuePair;



/**
 * <p>
 * This interface defines methods for reducing structures.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * @deprecated This class will be removed in version 1.2 
 *
 */
public interface ReducibleOperator<I,T> {
    
    public ILevel0GenericUniqOperator<I,T> reduce(final IFunction<? extends ValuePair<? super T,? super T>, ? extends T> reductor);
    public <X> ILevel0GenericUniqOperator<I,X> reduce(final IFunction<? extends ValuePair<? super X,? super T>,X> reductor, final X initialValue);

    
}
