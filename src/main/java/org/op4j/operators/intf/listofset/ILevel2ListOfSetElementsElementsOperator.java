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
package org.op4j.operators.intf.listofset;

import java.util.List;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.qualities.IConvertibleOperator;
import org.op4j.operators.qualities.IEvaluableOperator;
import org.op4j.operators.qualities.IExecutableOperator;
import org.op4j.operators.qualities.INavigatingCollectionOperator;
import org.op4j.operators.qualities.ITypeParameterizableXOperator;
import org.op4j.operators.qualities.IUniqOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ILevel2ListOfSetElementsElementsOperator<T> 
		extends IUniqOperator<List<Set<T>>>,
                INavigatingCollectionOperator<T>,
                IConvertibleOperator<T>,
        		IEvaluableOperator<T>,
        		IExecutableOperator<T>,
                ITypeParameterizableXOperator<T> {
    
    public ILevel1ListOfSetElementsOperator<T> endFor();
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> convert(final IConverter<X,? super T> converter);
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> eval(final IEvaluator<X,? super T> eval);

    public <X> ILevel2ListOfSetElementsElementsOperator<X> exec(final IFunction<X, ? super T> function);
    
    public <X> ILevel2ListOfSetElementsElementsOperator<X> of(final Type<X> of);
        
    public ILevel2ListOfSetElementsElementsOperator<?> raw();
    
                                    
}
