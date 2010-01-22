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
package org.op4j.operators.intf.arrayofarray;



import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingArrayOperator;
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
public interface Level2ArrayOfArrayElementsSelectedElementsOperator<T,I>
        extends UniqOperator<T[][],I>,
        		ExecutableSelectedOperator<T,I>,
                ReplaceableOperator<T,I>,
                NavigatingArrayOperator<T,I>,
                SelectableOperator<T,I> {



    public Level1ArrayOfArrayElementsSelectedOperator<T,I> endFor();


    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifNull();
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifNotNull();
    public Level2ArrayOfArrayElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level2ArrayOfArrayElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter);
    
    public Level2ArrayOfArrayElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval);

    public Level2ArrayOfArrayElementsSelectedElementsOperator<T,I> replaceWith(final T replacement);

    public Level2ArrayOfArrayElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T, ? super T> function);

    
}
