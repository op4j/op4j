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
package org.op4j.operators.impl.mapofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.SetFunc;
import org.op4j.executables.functions.conversion.ToArray;
import org.op4j.executables.functions.conversion.ToList;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel3MapOfSetEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfSetEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfSetEntriesValueOperator<K,V> {

    
    public Level2MapOfSetEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.Add<V>(newElements)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.AddAll<V>(collection)));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> endOn() {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extract(V value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAll(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAll(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAll(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAllBut(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAllBut(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> extractAllBut(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEach(final int... positions) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(positions));
    }


    


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEach(final ISelect<V> selector) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNot(positions));
    }


    








    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel2MapOfSetEntriesValueOperator<K, X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfSetEntriesValueOperator<K, X> of(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removePositions(final int... positions) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemovePositions<V>(positions)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeValues(final V... values) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemoveValues<V>(values)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemoveMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeSelected(final ISelect<V> selector) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeAllExceptPositions(final int... positions) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemoveAllExceptPositions<V>(positions)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemoveNotNullsMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.RemoveNulls<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel2MapOfSetEntriesValueOperator<K, V> sort() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.Sort()));
    }


    @SuppressWarnings("unchecked")
    public ILevel2MapOfSetEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFunc.Sort(comparator)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(of, getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ToList.FromCollection<V>()));
    }


    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEval<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V>(getTarget().execute(new ToMap.FromSetByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuild<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V2>(getTarget().execute(new ToMap.FromSetByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public Map<K, Set<V>> get() {
        return endOn().endFor().get();
    }

}
