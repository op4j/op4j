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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableArrayElementsOperator;
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
public interface Level2ListOfArrayElementsElementsOperator<T>
        extends UniqOperator<List<T[]>>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ExecutableArrayElementsOperator<T>,
                CastableToTypeOperator<T> {



    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNull();
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNotNull();
    public Level2ListOfArrayElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level1ListOfArrayElementsOperator<T> endFor();
    
    public Level2ListOfArrayElementsElementsOperator<T> replaceWith(final T replacement);
    public Level2ListOfArrayElementsElementsOperator<T> replaceIfNullWith(final T replacement);


    public Level2ListOfArrayElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter);
    public Level2ListOfArrayElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval);
    public Level2ListOfArrayElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function);
    public <X> Level2ListOfArrayElementsElementsOperator<X> convert(final Type<X> type, final IConverter<X,? super T> converter);
    public <X> Level2ListOfArrayElementsElementsOperator<X> eval(final Type<X> type, final IEvaluator<X,? super T> eval);
    public <X> Level2ListOfArrayElementsElementsOperator<X> exec(final Type<X> type, final IFunction<X,? super T> function);
    
    public <X> Level2ListOfArrayElementsElementsOperator<X> asType(final Type<X> type);
    public Level2ListOfArrayElementsElementsOperator<?> asUnknown();
        
    }
