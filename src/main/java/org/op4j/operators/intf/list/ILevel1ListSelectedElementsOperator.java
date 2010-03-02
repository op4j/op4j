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
package org.op4j.operators.intf.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableElementsOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel1ListSelectedElementsOperator<I,T>
        extends UniqOperator<List<T>>,
                NavigatingCollectionOperator<T>,
                SelectableElementsOperator<T>,
                ExecutableSelectedOperator<T>,
                ReplaceableOperator<T> {



    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifIndex(final int... indexes);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifNull();
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifNotNull();
    public ILevel1ListSelectedElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);


		    
    public ILevel0ListSelectedOperator<I,T> endFor();
    
    public ILevel1ListSelectedElementsOperator<I,T> execIfNotNull(final IFunction<? super T,? extends T> function);

    public ILevel1ListSelectedElementsOperator<I,T> replaceWith(final T replacement);

    public ILevel1ListSelectedElementsOperator<I,T> exec(final IFunction<? super T,? extends T> function);
	
    
}
