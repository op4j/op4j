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
package org.op4j.operators.intf.setofset;

import java.util.Set;

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
public interface Level2SetOfSetElementsElementsOperator<T,I>
        extends UniqOperator<Set<Set<T>>,I>,
                NavigatingCollectionOperator<T,I>,
        		ExecutableOperator<T,I>,
                SelectableOperator<T,I>,
                ReplaceableOperator<T,I>,
                ReplaceableIfNullOperator<T,I>,
                CastableToTypeOperator<T,I> {



    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifIndex(final int... indices);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNull();
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices);
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNotNull();
    public Level2SetOfSetElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval);

    
    public Level1SetOfSetElementsOperator<T,I> endFor();
    
    public Level2SetOfSetElementsElementsOperator<T,I> replaceWith(final T replacement);
    public Level2SetOfSetElementsElementsOperator<T,I> replaceIfNullWith(final T replacement);


    public <X> Level2SetOfSetElementsElementsOperator<X,I> convert(final IConverter<X,? super T> converter);
    
    public <X> Level2SetOfSetElementsElementsOperator<X,I> eval(final IEvaluator<X,? super T> eval);

    public <X> Level2SetOfSetElementsElementsOperator<X,I> exec(final IFunction<X, ? super T> function);
    
    public <X> Level2SetOfSetElementsElementsOperator<X,I> asType(final Type<X> type);
    public Level2SetOfSetElementsElementsOperator<?,I> asUnknown();
        
    }
