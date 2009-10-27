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

import org.op4j.op.intf.parameters.IOf;
import org.op4j.op.target.Target;
import org.op4j.op.target.Target.Structure;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.map.ILevel1MapEntriesOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesKeyOperator;
import org.op4j.operators.intf.map.ILevel2MapEntriesValueOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapEntriesOperator<K,V> extends Operator
        implements ILevel1MapEntriesOperator<K,V> {

    
    public Level1MapEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOperator<K, V> endFor() {
        return new Level0MapOperator<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y> ILevel1MapEntriesOperator<X, Y> of(IOf<X> ofX, IOf<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1MapEntriesOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapEntriesKeyOperator<K, V> onKey() {
        return new Level2MapEntriesKeyOperator<K, V>(getTarget().iterate(0));
    }


    public ILevel2MapEntriesValueOperator<K, V> onValue() {
        return new Level2MapEntriesValueOperator<K, V>(getTarget().iterate(1));
    }


    public ILevel1MapEntriesOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public Map<K, V> get() {
        return endFor().get();
    }

}
