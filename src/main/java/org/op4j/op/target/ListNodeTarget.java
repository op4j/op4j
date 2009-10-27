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

package org.op4j.op.target;

import java.util.Collection;
import java.util.List;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class ListNodeTarget extends NodeTarget{
    
	private final List<?> object;

	
	public ListNodeTarget(final TargetId id, final List<?> object) {
		super(id);
		this.object = object;
	}



    @Override
    public Object getObject() {
        return this.object;
    }

	
    
    @Override
    public Collection<?> getIterationElements() {
        return this.object;
    }
    


    @Override
    public String toString() {
        return "ListNodeTarget [id=" + getId() + ", object=" + this.object + "]";
    }

    
}
