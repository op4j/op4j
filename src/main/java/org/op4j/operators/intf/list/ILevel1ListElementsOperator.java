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
package org.op4j.operators.intf.list;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.qualities.CastableToTypeOperator;
import org.op4j.operators.qualities.ExecutableElementsOperator;
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
public interface ILevel1ListElementsOperator<I,T>
        extends UniqOperator<List<T>>,
                NavigatingCollectionOperator<T>,
        		ExecutableElementsOperator<T>,
                SelectableElementsOperator<T>,
                ReplaceableOperator<T>,
                ReplaceableIfNullOperator<T>,
                CastableToTypeOperator<T> {



    public ILevel1ListElementsSelectedOperator<I,T> ifIndex(final int... indexes);
    public ILevel1ListElementsSelectedOperator<I,T> ifTrue(final IFunction<? super T,Boolean> eval);
    public ILevel1ListElementsSelectedOperator<I,T> ifFalse(final IFunction<? super T,Boolean> eval);
    public ILevel1ListElementsSelectedOperator<I,T> ifNull();
    public ILevel1ListElementsSelectedOperator<I,T> ifIndexNot(final int... indexes);
    public ILevel1ListElementsSelectedOperator<I,T> ifNotNull();


    
    public ILevel0ListOperator<I,T> endFor();
    
    public ILevel1ListElementsOperator<I,T> replaceWith(final T replacement);
    public ILevel1ListElementsOperator<I,T> replaceIfNullWith(final T replacement);


    
    
    public <X> ILevel1ListElementsOperator<I,X> exec(final IFunction<? super T,X> function);
    
    public ILevel1ListElementsOperator<I,T> execIfIndex(final int[] indexes, final IFunction<? super T,? extends T> function);
    public ILevel1ListElementsOperator<I,T> execIfIndexNot(final int[] indexes, final IFunction<? super T,? extends T> function);
    public ILevel1ListElementsOperator<I,T> execIfNotNull(final IFunction<? super T,? extends T> function);
    public ILevel1ListElementsOperator<I,T> execIfNull(final IFunction<? super T,? extends T> function);
    public ILevel1ListElementsOperator<I,T> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);
    public ILevel1ListElementsOperator<I,T> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T,? extends T> function);
    public <X> ILevel1ListElementsOperator<I,X> execIfIndex(final int[] indexes, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel1ListElementsOperator<I,X> execIfIndexNot(final int[] indexes, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel1ListElementsOperator<I,X> execIfNotNull(final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel1ListElementsOperator<I,X> execIfNull(final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel1ListElementsOperator<I,X> execIfTrue(final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    public <X> ILevel1ListElementsOperator<I,X> execIfFalse(final IFunction<? super T, Boolean> eval, final IFunction<? super T,X> function, final IFunction<? super T,X> elseFunction);
    
    
    
    
    public <X> ILevel1ListElementsOperator<I,X> castTo(final Type<X> type);
    
    
                                    
}
