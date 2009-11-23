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

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.ListFunc;
import org.op4j.executables.functions.conversion.ToMap;
import org.op4j.executables.functions.conversion.ToSet;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2MapOfListEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfListEntriesValueOperator<K,V> {

    
    public Level2MapOfListEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.Add<V>(newElements)));
    }

    public ILevel2MapOfListEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.AddAll<V>(collection)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfListEntriesValueOperator<K,V>(getTarget().execute(new ListFunc.Distinct<V>()));
    }


    public ILevel1MapOfListEntriesOperator<K, V> endOn() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extract(int position) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extract(V value) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAll(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(
            int... positions) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(V... values) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(
            String expression, Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> extractAllBut(
            ISelect<V> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach(final int... positions) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(positions));
    }


    


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach(final ISelect<V> selector) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNot(final int... positions) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNot(positions));
    }


    








    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullAnd(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(expression, optionalExpParams));
    }





    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOr(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(expression, optionalExpParams));
    }





    public <X> ILevel2MapOfListEntriesValueOperator<K, X> of(final Type<X> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X> ILevel2MapOfListEntriesValueOperator<K, X> of(Class<X> classOf) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removePositions(final int... positions) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemovePositions<V>(positions)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeValues(final V... values) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemoveValues<V>(values)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemoveMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeSelected(final ISelect<V> selector) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeAllExceptPositions(final int... positions) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemoveAllExceptPositions<V>(positions)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNotNullsMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemoveNotNullsMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFunc.RemoveNulls<V>()));
    }

    


    public ILevel2MapOfListEntriesValueOperator<K, V> sort() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> sort(
            Comparator<? super V> comparator) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        // TODO Auto-generated method stub
        return null;
    }


    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEval<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V>(getTarget().execute(new ToMap.FromListByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuild<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V2>(getTarget().execute(new ToMap.FromListByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new ToSet.FromCollection<V>()));
    }


    public Map<K, List<V>> get() {
        return endOn().endFor().get();
    }

}
