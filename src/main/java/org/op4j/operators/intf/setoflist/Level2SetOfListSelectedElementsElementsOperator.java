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
package org.op4j.operators.intf.setoflist;

import java.util.List;
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
public interface Level2SetOfListSelectedElementsElementsOperator<T>
        extends UniqOperator<Set<List<T>>>,
        		ExecutableSelectedOperator<T>,
                ReplaceableOperator<T>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T> {



    public Level1SetOfListSelectedElementsOperator<T> endFor();


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNull();
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNull();
    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    public Level2SetOfListSelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function);

    public Level2SetOfListSelectedElementsElementsOperator<T> replaceWith(final T replacement);

    public Level2SetOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T, ? super T> function);

    
}
