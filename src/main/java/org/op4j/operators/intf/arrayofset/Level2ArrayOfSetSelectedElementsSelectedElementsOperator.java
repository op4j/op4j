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
package org.op4j.operators.intf.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
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
public interface Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T>
        extends UniqOperator<Set<T>[]>,
        		ExecutableSelectedOperator<T>,
                ReplaceableOperator<T>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T> {



    public Level1ArrayOfSetSelectedElementsSelectedOperator<T> endFor();


    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNull();
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull();
    public Level2ArrayOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter);
    
    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval);

    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> replaceWith(final T replacement);

    public Level2ArrayOfSetSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T, ? super T> function);

    
}
