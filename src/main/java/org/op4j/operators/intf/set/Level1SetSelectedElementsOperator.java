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
public interface Level1SetSelectedElementsOperator<T>
        extends UniqOperator<Set<T>>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T>,
                ExecutableSelectedOperator<T>,
                ReplaceableOperator<T> {



    public Level1SetSelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1SetSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<T> ifNull();
    public Level1SetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level1SetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1SetSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1SetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);


		    
    public Level0SetSelectedOperator<T> endFor();
    
    public Level1SetSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter);
    
    public Level1SetSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval);

    public Level1SetSelectedElementsOperator<T> replaceBy(final T replacement);

    public Level1SetSelectedElementsOperator<T> exec(final IFunction<? extends T, ? super T> function);
	
    
}
