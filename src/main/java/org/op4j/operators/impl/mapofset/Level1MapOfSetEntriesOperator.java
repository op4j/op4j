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
package org.op4j.op.impl.operators.mapofset;

import java.util.Map;
import java.util.Set;

import org.op4j.op.impl.operators.Operator;
import org.op4j.op.intf.operators.mapofset.ILevel0MapOfSetOperator;
import org.op4j.op.intf.operators.mapofset.ILevel1MapOfSetEntriesOperator;
import org.op4j.op.intf.operators.mapofset.ILevel2MapOfSetEntriesKeyOperator;
import org.op4j.op.intf.operators.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfSetEntriesOperator<K,V> extends Operator
        implements ILevel1MapOfSetEntriesOperator<K,V> {

    
    public Level1MapOfSetEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOfSetOperator<K, V> endFor() {
        return new Level0MapOfSetOperator<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y> ILevel1MapOfSetEntriesOperator<X, Y> of(IOf<X> ofX, IOf<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1MapOfSetEntriesOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfSetEntriesKeyOperator<K, V>(getTarget().iterate(0));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().iterate(1));
    }


    public ILevel1MapOfSetEntriesOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, Set<V>> get() {
        return endFor().get();
    }

}
