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

import org.op4j.functions.IFunction;
/**
 * <p>
 * This interface contains methods for selecting targets.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface SelectableOperator<T>  {
    

    /**
     * <p>
     * Selects only those targets which index in the current level of iteration matches any of
     * the specified indexes. After this method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param indexes the indexes of the target objects which will be selected.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifIndex(final int... indexes);
    
    
    /**
     * <p>
     * Selects only those targets for which the specified evaluator returns true. After this 
     * method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param eval the evaluator to be used for selecting targets.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval);
    

    /**
     * <p>
     * Selects only those targets for which the specified evaluator returns false. After this 
     * method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param eval the evaluator to be used for selecting targets.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval);
    

    /**
     * <p>
     * Selects only those targets which are null or for which the specified evaluator returns false. After this 
     * method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param eval the evaluator to be used for selecting targets.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval);
    
    
    /**
     * <p>
     * Selects only those targets which are not null and for which the specified evaluator returns false. After this 
     * method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param eval the evaluator to be used for selecting targets.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval);
    

    /**
     * <p>
     * Selects only those targets which are null. After this method, all the subsequently 
     * executed operations will only be executed on the target objects selected here, until 
     * an "endIf()" method is called. 
     * </p>
     * 
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifNull();
    
    
    /**
     * <p>
     * Selects only those targets which are null or for which the specified evaluator returns true. After this 
     * method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param eval the evaluator to be used for selecting targets.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval);
    
    
    /**
     * <p>
     * Selects only those targets which index in the current level of iteration does not match any of
     * the specified indexes. After this method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param indexes the indexes of the target objects which will be selected.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifIndexNot(final int... indexes);
    
    
    /**
     * <p>
     * Selects only those targets which are not null. After this method, all the subsequently 
     * executed operations will only be executed on the target objects selected here, until an
     * "endIf()" method is called. 
     * </p>
     * 
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifNotNull();
    
    
    /**
     * <p>
     * Selects only those targets which are not null and for which the specified evaluator returns true. After this 
     * method, all the subsequently executed operations will only be executed
     * on the target objects selected here, until an "endIf()" method is called. 
     * </p>
     * 
     * @param eval the evaluator to be used for selecting targets.
     * @return an operator which will execute all subsequent operations only on the selected target objects. 
     */
    public SelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval);
    
}
