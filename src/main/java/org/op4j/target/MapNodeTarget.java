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
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class MapNodeTarget extends NodeTarget{
    
	private final Map<?,?> object;

	
	public MapNodeTarget(final TargetId id, final Map<?,?> object) {
		super(id);
		this.object = object;
	}

	


    @Override
    public Object getObject() {
        return this.object;
    }
	

	
    
    
    @Override
    public Collection<?> getIterationElements() {
        return this.object.entrySet();
    }
    


    /*
     * This is rewriten so that, for maps, iterating by objects means using keys
     */
    @Override
    Target doIterateMapKeys(final boolean desiredResult, final List<Object> objects) {
        
        final List<Target> newElements = new ArrayList<Target>();
        final List<TargetId> newSelectedElementIds = new ArrayList<TargetId>();
        
        int i = 0;
        for (final Map.Entry<?,?> element : this.object.entrySet()) {
            final TargetId elementId = new TargetId(getId(), i);
            newElements.add(NodeTarget.forObject(elementId, element));
            if (objects.contains(element.getKey()) == desiredResult) {
                newSelectedElementIds.add(elementId);
            }
            i++;
        }

        return new StructureTarget(getId(),newSelectedElementIds,newElements, getId().getLevel());
        
    }
    


    @Override
    public String toString() {
        return "MapNodeTarget [id=" + getId() + ", object=" + this.object + "]";
    }

    
}
