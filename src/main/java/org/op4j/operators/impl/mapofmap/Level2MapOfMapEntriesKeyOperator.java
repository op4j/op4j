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
package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapofmap.ILevel1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesKeyOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfMapEntriesKeyOperator<K1,K2,V> extends Operator
        implements ILevel2MapOfMapEntriesKeyOperator<K1,K2,V> {

    
    public Level2MapOfMapEntriesKeyOperator(final Target target) {
        super(target);
    }


    public ILevel1MapOfMapEntriesOperator<K1, K2, V> endOn() {
        return new Level1MapOfMapEntriesOperator<K1, K2, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public <X> ILevel2MapOfMapEntriesKeyOperator<X, K2, V> of(IOf<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfMapEntriesKeyOperator<X, K2, V> of(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfMapEntriesKeyOperator<?, K2, V> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K1, Map<K2, V>> get() {
        return endOn().endFor().get();
    }

}
