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
package org.op4j.operators.op.intf.array;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableArrayElementsOperator;
import org.op4j.operators.qualities.NavigatingCollectionOperator;
import org.op4j.operators.qualities.ReplaceableIfNullOperator;
import org.op4j.operators.qualities.ReplaceableOperator;
import org.op4j.operators.qualities.SelectableOperator;
import org.op4j.operators.qualities.UniqOpOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface Level1ArrayElementsOperator<T,I>
        extends UniqOpOperator<T[]>,
                NavigatingCollectionOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                ExecutableArrayElementsOperator<T>,
                CastableToTypeOperator<T> {



    public Level1ArrayElementsSelectedOperator<T,I> ifIndex(final int... indexes);
    public Level1ArrayElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifNull();
    public Level1ArrayElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level1ArrayElementsSelectedOperator<T,I> ifIndexNot(final int... indexes);
    public Level1ArrayElementsSelectedOperator<T,I> ifNotNull();
    public Level1ArrayElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);


		    
    public Level0ArrayOperator<T,I> endFor();
    
    public Level1ArrayElementsOperator<T,I> replaceWith(final T replacement);
    public Level1ArrayElementsOperator<T,I> replaceIfNullWith(final T replacement);


    public Level1ArrayElementsOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function);
    public Level1ArrayElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function);
    public <X> Level1ArrayElementsOperator<X,I> exec(final Type<X> type, final IFunction<X,? super T> function);
    
    
    public <X> Level1ArrayElementsOperator<X,I> asType(final Type<X> type);
    public Level1ArrayElementsOperator<?,I> asUnknown();
	
    
}
