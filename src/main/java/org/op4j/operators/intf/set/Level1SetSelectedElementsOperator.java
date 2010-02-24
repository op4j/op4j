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
package org.op4j.operators.intf.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1SetSelectedElementsOperator<I,T>
        extends UniqOperator<Set<T>>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T>,
                ExecutableSelectedOperator<T>,
                ReplaceableOperator<T> {



    public Level1SetSelectedElementsSelectedOperator<I,T> ifIndex(final int... indexes);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifNull();
    public Level1SetSelectedElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public Level1SetSelectedElementsSelectedOperator<I,T> ifNotNull();
    public Level1SetSelectedElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);


		    
    public Level0SetSelectedOperator<I,T> endFor();
    
    public Level1SetSelectedElementsOperator<I,T> execIfNotNull(final IFunction<? extends T,? super T> function);

    public Level1SetSelectedElementsOperator<I,T> replaceWith(final T replacement);

    public Level1SetSelectedElementsOperator<I,T> exec(final IFunction<? extends T, ? super T> function);
	
    
}
