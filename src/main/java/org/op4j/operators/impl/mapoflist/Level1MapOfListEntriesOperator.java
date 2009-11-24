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
package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1MapOfListEntriesOperator<K,V> extends Operator
        implements ILevel1MapOfListEntriesOperator<K,V> {

    
    public Level1MapOfListEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel0MapOfListOperator<K, V> endFor() {
        return new Level0MapOfListOperator<K, V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y> ILevel1MapOfListEntriesOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel1MapOfListEntriesOperator<X, Y> of(Class<X> ofXClass, Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesKeyOperator<K, V> onKey() {
        return new Level2MapOfListEntriesKeyOperator<K, V>(getTarget().iterate(0));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> onValue() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().iterate(1));
    }


    public ILevel1MapOfListEntriesOperator<?, ?> raw() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget());
    }


    public Map<K, List<V>> get() {
        return endFor().get();
    }

}
