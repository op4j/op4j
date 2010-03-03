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
package org.op4j.operators.intf.generic;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.MultiOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectedElementsOperator;
/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel0GenericMultiSelectedOperator<I,T>
        extends MultiOperator<T>,
         		ExecutableSelectedOperator<T>,
                ReplaceableOperator<T>,
                SelectedElementsOperator<T> {



    public ILevel0GenericMultiOperator<I,T> endIf();


    public ILevel0GenericMultiSelectedOperator<I,T> replaceWith(final T replacement);
    
    public ILevel0GenericMultiSelectedOperator<I,T> execIfNotNull(final IFunction<? super T,? extends T> function);

    public ILevel0GenericMultiSelectedOperator<I,T> exec(final IFunction<? super T,? extends T> function);
    
    

}