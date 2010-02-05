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
	private final int level;
	
	
	
	public ExecutionTargetId(final ExecutionTargetId parent, final int index) {
		
		if (parent != null) {
			this.components.addAll(parent.getComponents());
	        this.components.add(Integer.valueOf(index));
		} else {
			/* ID for first level is always 0 */
			Validate.isTrue(index == 0, "Index for first level must be 0");
	        this.components.add(Integer.valueOf(index));
		}
		
		
		this.level = this.components.size();
		
	}
	
	
	public List<Integer> getComponents() {
		return this.components;
	}
	
	
	public int getLevel() {
		return this.level;
	}
	
	
}
