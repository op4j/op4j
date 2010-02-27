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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableElementsOperator;
import org.op4j.operators.qualities.UniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ListElementsOperator<I,T>
        extends UniqOperator<List<T>>,
                NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableElementsOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level1ListElementsSelectedOperator<I,T> ifIndex(final int... indexes);
    public Level1ListElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public Level1ListElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public Level1ListElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level1ListElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level1ListElementsSelectedOperator<I,T> ifNull();
    public Level1ListElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level1ListElementsSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public Level1ListElementsSelectedOperator<I,T> ifNotNull();
    public Level1ListElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);


    
    public Level0ListOperator<I,T> endFor();
    
    public Level1ListElementsOperator<I,T> replaceWith(final T replacement);
    public Level1ListElementsOperator<I,T> replaceIfNullWith(final T replacement);


    public <X> Level1ListElementsOperator<I,X> execIfNotNull(final IFunction<? super T,X> function);

    public <X> Level1ListElementsOperator<I,X> exec(final IFunction<? super T,X> function);
    
    public <X> Level1ListElementsOperator<I,X> asType(final Type<X> type);
    
    
                                    
}
