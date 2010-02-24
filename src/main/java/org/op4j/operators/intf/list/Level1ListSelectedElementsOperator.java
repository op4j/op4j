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
package org.op4j.operators.intf.list;

import java.util.List;

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
public interface Level1ListSelectedElementsOperator<T,I>
        extends UniqOperator<List<T>>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T>,
                ExecutableSelectedOperator<T>,
                ReplaceableOperator<T> {



    public Level1ListSelectedElementsSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifNull();
    public Level1ListSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level1ListSelectedElementsSelectedOperator<T,I> ifNotNull();
    public Level1ListSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);


		    
    public Level0ListSelectedOperator<T,I> endFor();
    
    public Level1ListSelectedElementsOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function);

    public Level1ListSelectedElementsOperator<T,I> replaceWith(final T replacement);

    public Level1ListSelectedElementsOperator<T,I> exec(final IFunction<? extends T, ? super T> function);
	
    
}
