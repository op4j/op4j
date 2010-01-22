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
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingArrayOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
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
public interface Level2ArrayOfArrayElementsElementsOperator<T,I>
        extends UniqOperator<T[][],I>,
                NavigatingArrayOperator<T,I>,
        		ExecutableOperator<T,I>,
                SelectableOperator<T,I>,
                ReplaceableOperator<T,I>,
                ReplaceableIfNullOperator<T,I>,
                CastableToTypeOperator<T,I> {



    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNull();
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNotNull();
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level1ArrayOfArrayElementsOperator<T,I> endFor();
    
    public Level2ArrayOfArrayElementsElementsOperator<T,I> replaceWith(final T replacement);
    public Level2ArrayOfArrayElementsElementsOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> convert(final IConverter<X,? super T> converter);
    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> eval(final IEvaluator<X,? super T> eval);
    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> exec(final IFunction<X,? super T> function);
    
    public <X> Level2ArrayOfArrayElementsElementsOperator<X,I> asType(final Type<X> type);
    public Level2ArrayOfArrayElementsElementsOperator<?,I> asUnknown();
        
    }
