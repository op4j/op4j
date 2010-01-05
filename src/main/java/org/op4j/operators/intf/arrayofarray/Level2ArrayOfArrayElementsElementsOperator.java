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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ConvertibleOperator;
import org.op4j.operators.qualities.EvaluableOperator;
import org.op4j.operators.qualities.ExecutableOperator;
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
public interface Level2ArrayOfArrayElementsElementsOperator<T>
        extends UniqOperator<T[][]>,
                NavigatingCollectionOperator<T>,
                ConvertibleOperator<T>,
        		EvaluableOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                CastableToTypeOperator<T> {



    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNull();
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNull();
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval);

    
    public Level1ArrayOfArrayElementsOperator<T> endFor();
    
    public <X> Level2ArrayOfArrayElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level2ArrayOfArrayElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level2ArrayOfArrayElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level2ArrayOfArrayElementsElementsOperator<X> asType(final Type<X> type);
    public Level2ArrayOfArrayElementsElementsOperator<?> asUnknown();
        
    }