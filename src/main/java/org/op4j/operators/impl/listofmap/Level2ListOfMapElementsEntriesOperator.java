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
package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.Of;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.listofmap.ILevel1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.ILevel2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.ILevel3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.ILevel3ListOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfMapElementsEntriesOperator<K,V> extends Operator
        implements ILevel2ListOfMapElementsEntriesOperator<K,V>  {

    
    public Level2ListOfMapElementsEntriesOperator(final Target target) {
        super(target);
    }


    public ILevel1ListOfMapElementsOperator<K, V> endFor() {
        return new Level1ListOfMapElementsOperator<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public <X, Y> ILevel2ListOfMapElementsEntriesOperator<X, Y> of(Of<X> ofX,
            Of<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel2ListOfMapElementsEntriesOperator<X, Y> of(
            Class<X> ofXClass, Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3ListOfMapElementsEntriesKeyOperator<K, V> onKey() {
        return new Level3ListOfMapElementsEntriesKeyOperator<K, V>(getTarget().iterate(0));
    }


    public ILevel3ListOfMapElementsEntriesValueOperator<K, V> onValue() {
        return new Level3ListOfMapElementsEntriesValueOperator<K, V>(getTarget().iterate(1));
    }


    public ILevel2ListOfMapElementsEntriesOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public List<Map<K, V>> get() {
        return endFor().endFor().get();
    }

}
