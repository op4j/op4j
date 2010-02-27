/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableArrayElementsOperator;
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
public interface Level1ArrayElementsOperator<I,T>
        extends UniqOperator<T[]>,
                NavigatingCollectionOperator<T>,
                SelectableElementsOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ExecutableArrayElementsOperator<T>,
                CastableToTypeOperator<T> {



    public Level1ArrayElementsSelectedOperator<I,T> ifIndex(final int... indexes);
    public Level1ArrayElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public Level1ArrayElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public Level1ArrayElementsSelectedOperator<I,T> ifNullOrFalse(final IFunction<? super T,Boolean> eval);
    public Level1ArrayElementsSelectedOperator<I,T> ifNotNullAndFalse(final IFunction<? super T,Boolean> eval);
    public Level1ArrayElementsSelectedOperator<I,T> ifNull();
    public Level1ArrayElementsSelectedOperator<I,T> ifNullOrTrue(final IFunction<? super T,Boolean> eval);
    public Level1ArrayElementsSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public Level1ArrayElementsSelectedOperator<I,T> ifNotNull();
    public Level1ArrayElementsSelectedOperator<I,T> ifNotNullAndTrue(final IFunction<? super T,Boolean> eval);


		    
    public Level0ArrayOperator<I,T> endFor();
    
    public Level1ArrayElementsOperator<I,T> replaceWith(final T replacement);
    public Level1ArrayElementsOperator<I,T> replaceIfNullWith(final T replacement);


    public Level1ArrayElementsOperator<I,T> execIfNotNull(final IFunction<? super T,? extends T> function);
    public Level1ArrayElementsOperator<I,T> exec(final IFunction<? super T,? extends T> function);
    public <X> Level1ArrayElementsOperator<I,X> exec(final Type<X> type, final IFunction<? super T,X> function);
    
    
    public <X> Level1ArrayElementsOperator<I,X> asType(final Type<X> type);
	
    
}
