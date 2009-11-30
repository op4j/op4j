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

import org.op4j.executables.IEval;
import org.op4j.executables.ISelector;






/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface INavigableCollectionOperator<T>  {

    public INavigatingCollectionOperator<T> forEach();
    
    public INavigatingCollectionOperator<T> forEachIndex(final int... indices);
    public INavigatingCollectionOperator<T> forEachMatching(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachMatching(final IEval<Boolean, ? super T> eval);
    public INavigatingCollectionOperator<T> forEachSelected(final ISelector<T> selector);
    public INavigatingCollectionOperator<T> forEachNull();
    public INavigatingCollectionOperator<T> forEachNullOrMatching(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachNullOrMatching(final IEval<Boolean, ? super T> eval);
    public INavigatingCollectionOperator<T> forEachIndexNot(final int... indices);
    public INavigatingCollectionOperator<T> forEachNotNull();
    public INavigatingCollectionOperator<T> forEachNotNullMatching(final String expression, final Object... optionalExpParams);
    public INavigatingCollectionOperator<T> forEachNotNullMatching(final IEval<Boolean, ? super T> eval);
	
}
