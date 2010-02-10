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
package org.op4j.operators.intf.listofarray;

import java.util.List;

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
public interface Level2ListOfArraySelectedElementsElementsOperator<T>
        extends UniqOperator<List<T[]>>,
        		ExecutableSelectedOperator<T>,
                ReplaceableOperator<T>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T> {



    public Level1ListOfArraySelectedElementsOperator<T> endFor();


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNull();
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull();
    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level2ListOfArraySelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter);
    
    public Level2ListOfArraySelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval);

    public Level2ListOfArraySelectedElementsElementsOperator<T> replaceWith(final T replacement);

    public Level2ListOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T, ? super T> function);

    
}
