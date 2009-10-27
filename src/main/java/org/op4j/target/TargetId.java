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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class TargetId {

    
    public static final TargetId ROOT = new TargetId(null, 0); 
    
	private final List<Integer> components = new ArrayList<Integer>();
	
	
	
	public static TargetId fromString(final String string) {
		
		Validate.notEmpty(string);
		
		final String[] tokens = StringUtils.split(string,".");

		TargetId id = null;
		for (final String token : tokens) {
			Validate.isTrue(StringUtils.isNumeric(token));
			id = new TargetId(id, Integer.valueOf(token).intValue());
		}
		return id;
		
	}
	
	public static TargetId fromIdList(final List<Integer> idList) {
		
		Validate.notEmpty(idList);

		TargetId id = null;
		for (final Integer currentId : idList) {
			id = new TargetId(id, currentId.intValue());
		}
		return id;
		
	}
	
	
	public TargetId(final TargetId parent, final int index) {
		
		if (parent != null) {
			this.components.addAll(parent.getComponents());
		} else {
			/* ID for first level is always 0 */
			Validate.isTrue(index == 0, "Index for first level must be 0");
		}
		
		this.components.add(Integer.valueOf(index));
		
	}
	
	
	public List<Integer> getComponents() {
		return this.components;
	}
	
	public Integer getIndexComponent() {
	    return this.components.get(this.components.size() - 1);
	}
	
	public List<Integer> getRootComponents() {
	    final List<Integer> root = new ArrayList<Integer>(this.components);
	    root.remove(root.size() - 1);
	    return root;
	}
	
	public List<Integer> getTailComponents() {
		final List<Integer> tail = new ArrayList<Integer>(this.components);
		tail.remove(0);
		return tail;
	}
	
	
	public int getLevel() {
		return this.components.size();
	}
	
	
	
	@Override
	public String toString() {
		return StringUtils.join(this.components, ".");
	}

	

	@Override
	public int hashCode() {
		return this.components.hashCode();
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
		TargetId other = (TargetId) obj;
		return this.components.equals(other.components);
	}
	
	
}
