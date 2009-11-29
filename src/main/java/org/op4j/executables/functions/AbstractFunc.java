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

package org.op4j.executables.functions;

import org.op4j.exceptions.NullTargetException;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public abstract class AbstractFunc<R, T> implements IFunc<R, T> {

    private boolean nullTargetAllowed= true;
    
    
    public AbstractFunc() {
        super();
    }

    
    protected boolean isNullTargetAllowed() {
        return this.nullTargetAllowed;
    }


    protected void setNullTargetAllowed(final boolean nullTargetAllowed) {
        this.nullTargetAllowed = nullTargetAllowed;
    }



    public final R execute(final T object) throws Exception {
        if (!this.nullTargetAllowed && object == null) {
            throw new NullTargetException();
        }
        return doExecute(object);
    }


    public abstract R doExecute(final T object) throws Exception;
    
    
    
}