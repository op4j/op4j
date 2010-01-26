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

package org.op4j.target;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ExecutionTargetId {

    
    public static final ExecutionTargetId ROOT = new ExecutionTargetId(null, 0); 
    
	private final List<Integer> components = new ArrayList<Integer>();
	private final String stringRepresentation;
	private final int level;
	private final int hashCode;
	
	
	
	public ExecutionTargetId(final ExecutionTargetId parent, final int index) {
		
		if (parent != null) {
	        this.stringRepresentation = parent.getStringRepresentation() + "." + String.valueOf(index);
			this.components.addAll(parent.getComponents());
	        this.components.add(Integer.valueOf(index));
		} else {
			/* ID for first level is always 0 */
			Validate.isTrue(index == 0, "Index for first level must be 0");
            this.stringRepresentation = String.valueOf(index);
	        this.components.add(Integer.valueOf(index));
		}
		
		
		this.level = this.components.size();
		this.hashCode = this.stringRepresentation.hashCode();
		
	}
	
	
	public List<Integer> getComponents() {
		return this.components;
	}
	
	
	public int getLevel() {
		return this.level;
	}
	
	
	
	@Override
	public String toString() {
		return getStringRepresentation();
	}

	

    public String getStringRepresentation() {
        return this.stringRepresentation;
    }


    @Override
	public int hashCode() {
		return this.hashCode;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ExecutionTargetId other = (ExecutionTargetId) obj;
		return this.stringRepresentation.equals(other.stringRepresentation);
	}
	
	
}
