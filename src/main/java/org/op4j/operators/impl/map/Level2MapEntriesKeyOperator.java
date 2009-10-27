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
package org.op4j.operators.impl.map;

import java.util.Map;

import org.op4j.IOf;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesKeyOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapEntriesKeyOperator<K,V> extends Operator
        implements ILevel2MapEntriesKeyOperator<K,V> {

    
    public Level2MapEntriesKeyOperator(final Target target) {
        super(target);
    }


    public ILevel1MapEntriesOperator<K, V> endOn() {
        return new Level1MapEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel2MapEntriesKeyOperator<X, V> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapEntriesKeyOperator<X, V> of(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapEntriesKeyOperator<?, V> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, V> get() {
        return endOn().endFor().get();
    }

}
