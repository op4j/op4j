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
 * This interface contains methods for converting a multi-target operator into a
 * unique-target operator. This can be done when the multi-target operator only holds one target.
 * </p>
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */

public interface UniqableOperator<T> {

    
    /**
     * <p>
     * Converts the multi-target operator into a unique-target one. This can only be done
     * if the multi-target operator actually only holds one target.
     * </p>
     * 
     * @return a unique-target operator containing the only target object.
     */
    public UniqOperator<T> uniq();

}
