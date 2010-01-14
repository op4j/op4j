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
package org.op4j.operators.intf.array;



import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.ExecutableSelectedOperator;
import org.op4j.operators.qualities.SelectedOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ArraySelectedElementsSelectedOperator<T>
        extends UniqOperator<T[]>,
                SelectedOperator<T>,
                ExecutableSelectedOperator<T> {



    public Level1ArraySelectedElementsOperator<T> endIf();

    
    public Level1ArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter);
    
    public Level1ArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval);

    public Level1ArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T, ? super T> function);
	
    
}
