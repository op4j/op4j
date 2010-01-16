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

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ExecutableSetOperator<T> {

    public <X> ExecutableSetOperator<X> exec(final IFunction<? extends Set<X>, ? super Set<T>> function);
    
    public <X> ExecutableSetOperator<X> eval(final IEvaluator<? extends Set<X>,? super Set<T>> eval);
    
    public <X> ExecutableSetOperator<X> convert(final IConverter<? extends Set<X>,? super Set<T>> converter);

    public <X> Operator exec(final Type<X> resultType, final IFunction<? extends X, ? super Set<T>> function);
    
    public <X> Operator eval(final Type<X> resultType, final IEvaluator<? extends X,? super Set<T>> eval);
    
    public <X> Operator convert(final Type<X> resultType, final IConverter<? extends X,? super Set<T>> converter);    
    
}
