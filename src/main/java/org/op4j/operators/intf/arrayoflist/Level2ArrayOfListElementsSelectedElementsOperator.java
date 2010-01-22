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
package org.op4j.operators.intf.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;
import org.op4j.operators.qualities.ReplaceableOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level2ArrayOfListElementsSelectedElementsOperator<T,I>
        extends UniqOperator<List<T>[],I>,
        		ExecutableSelectedOperator<T,I>,
                ReplaceableOperator<T,I>,
                NavigatingCollectionOperator<T,I>,
                SelectableOperator<T,I> {



    public Level1ArrayOfListElementsSelectedOperator<T,I> endFor();


    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifNull();
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifNotNull();
    public Level2ArrayOfListElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level2ArrayOfListElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter);
    
    public Level2ArrayOfListElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval);

    public Level2ArrayOfListElementsSelectedElementsOperator<T,I> replaceWith(final T replacement);

    public Level2ArrayOfListElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T, ? super T> function);

    
}
