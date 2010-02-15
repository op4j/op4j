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
public interface Level2ArrayOfArrayElementsElementsOperator<T>
        extends UniqOperator<T[][]>,
                NavigatingCollectionOperator<T>,
        		ExecutableArrayElementsOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNull();
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNull();
    public Level2ArrayOfArrayElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    public Level1ArrayOfArrayElementsOperator<T> endFor();
    
    public Level2ArrayOfArrayElementsElementsOperator<T> replaceWith(final T replacement);
    public Level2ArrayOfArrayElementsElementsOperator<T> replaceIfNullWith(final T replacement);


    public Level2ArrayOfArrayElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function);
    public Level2ArrayOfArrayElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function);
    public <X> Level2ArrayOfArrayElementsElementsOperator<X> execIfNotNull(final Type<X> type, final IFunction<X,? super T> function);
    public <X> Level2ArrayOfArrayElementsElementsOperator<X> exec(final Type<X> type, final IFunction<X,? super T> function);
    
    public <X> Level2ArrayOfArrayElementsElementsOperator<X> asType(final Type<X> type);
    public Level2ArrayOfArrayElementsElementsOperator<?> asUnknown();
        
    }
