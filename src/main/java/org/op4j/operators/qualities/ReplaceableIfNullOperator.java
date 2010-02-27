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
package org.op4j.operators.qualities;

/**
 * <p>
 * This interface contains methods for replacing targets if they are null.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ReplaceableIfNullOperator<T>  {

    
    /**
     * <p>
     * Replaces the current target object with the specified replacement if 
     * the current target is null.
     * </p>
     * 
     * @param replacement the object which will replace the current target object if target is null.
     * @return an operator containing the original target object if it was not null, or the new one if null.
     */
    public ReplaceableIfNullOperator<T> replaceIfNullWith(final T replacement);
    
    
}
