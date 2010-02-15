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
public interface Level2SetOfSetElementsElementsOperator<T>
        extends UniqOperator<Set<Set<T>>>,
                NavigatingCollectionOperator<T>,
        		ExecutableOperator<T>,
                SelectableOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public Level2SetOfSetElementsElementsSelectedOperator<T> ifIndex(final int... indexes);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifNull();
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes);
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifNotNull();
    public Level2SetOfSetElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);

    
    public Level1SetOfSetElementsOperator<T> endFor();
    
    public Level2SetOfSetElementsElementsOperator<T> replaceWith(final T replacement);
    public Level2SetOfSetElementsElementsOperator<T> replaceIfNullWith(final T replacement);


    public <X> Level2SetOfSetElementsElementsOperator<X> execIfNotNull(final IFunction<X,? super T> function);

    public <X> Level2SetOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> Level2SetOfSetElementsElementsOperator<X> asType(final Type<X> type);
    public Level2SetOfSetElementsElementsOperator<?> asUnknown();
        
    }
