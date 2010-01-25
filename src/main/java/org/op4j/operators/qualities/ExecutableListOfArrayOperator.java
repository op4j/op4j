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
package org.op4j.operators.qualities;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.intf.generic.Level0GenericUniqOperator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableListOfArrayOperator<T> {

    public <X> ExecutableListOfArrayOperator<X> exec(final IFunction<? extends List<X[]>, ? super List<T[]>> function);
    
    public <X> ExecutableListOfArrayOperator<X> eval(final IEvaluator<? extends List<X[]>,? super List<T[]>> eval);
    
    public <X> ExecutableListOfArrayOperator<X> convert(final IConverter<? extends List<X[]>,? super List<T[]>> converter);

    public <X> Level0GenericUniqOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super List<T[]>> function);
    
    public <X> Level0GenericUniqOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X,? super List<T[]>> eval);
    
    public <X> Level0GenericUniqOperator<X> convert(final Type<X> resultType, final IConverter<? extends X,? super List<T[]>> converter);    
    
}
