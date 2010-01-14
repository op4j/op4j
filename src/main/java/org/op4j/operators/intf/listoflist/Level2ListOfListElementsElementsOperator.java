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
package org.op4j.operators.intf.listoflist;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
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
public interface Level2ListOfListElementsElementsOperator<T>
        extends UniqOperator<List<List<T>>>,
                NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                CastableToTypeOperator<T> {



    public Level2ListOfListElementsElementsSelectedOperator<T> ifIndex(final int... indices);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNull();
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifIndexNot(final int... indices);
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotNull();
    public Level2ListOfListElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval);

    
    public Level1ListOfListElementsOperator<T> endFor();
    
    public <X> Level2ListOfListElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> Level2ListOfListElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> Level2ListOfListElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level2ListOfListElementsElementsOperator<X> asType(final Type<X> type);
    public Level2ListOfListElementsElementsOperator<?> asUnknown();
        
    }
