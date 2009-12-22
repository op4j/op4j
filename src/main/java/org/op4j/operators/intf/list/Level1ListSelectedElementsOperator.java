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
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ConvertibleSelectedOperator;
import org.op4j.operators.qualities.EvaluableSelectedOperator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ListSelectedElementsOperator<T>
        extends UniqOperator<List<T>>,
                NavigatingCollectionOperator<T>,
                ConvertibleSelectedOperator<T>,
                SelectableOperator<T>,
                EvaluableSelectedOperator<T>,
                ExecutableSelectedOperator<T> {



    public Level1ListSelectedElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level1ListSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T> ifNull();
    public Level1ListSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level1ListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level1ListSelectedElementsSelectedOperator<T> ifNotNull();
    public Level1ListSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval);


		    
    public Level0ListSelectedOperator<T> endFor();
    
    public Level1ListSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter);
    
    public Level1ListSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval);

    public Level1ListSelectedElementsOperator<T> exec(final IFunction<? extends T, ? super T> function);
	
    
}
