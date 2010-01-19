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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
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
public interface Level2ArrayOfListElementsElementsOperator<T>
        extends UniqOperator<List<T>[]>,
                NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifNull();
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifNotNull();
    public Level2ArrayOfListElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

		    
    public Level1ArrayOfListElementsOperator<T> endFor();
    
    public Level2ArrayOfListElementsElementsOperator<T> replaceBy(final T replacement);
    public Level2ArrayOfListElementsElementsOperator<T> replaceIfNullBy(final T replacement);


    public <X> Level2ArrayOfListElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level2ArrayOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level2ArrayOfListElementsElementsOperator<X> asType(final Type<X> type);
    public Level2ArrayOfListElementsElementsOperator<?> asUnknown();
        
    }
