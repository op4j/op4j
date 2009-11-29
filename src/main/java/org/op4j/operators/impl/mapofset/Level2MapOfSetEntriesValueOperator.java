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
import org.op4j.executables.functions.SetFuncs;
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
import org.op4j.util.VarArgsUtil;


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
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.Add<V>(newElements)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.AddAll<V>(collection)));
    }


    public ILevel1MapOfSetEntriesOperator<K, V> endOn() {
        return new Level1MapOfSetEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachMatching(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachMatching(final IEval<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNullMatching(final IEval<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNullOrMatching(final IEval<Boolean, ? super V> eval) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachSelected(final ISelect<V> selector) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfSetEntriesValueElementsOperator<K, V> forEachNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level3MapOfSetEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(Eval.booleanExp(expression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel2MapOfSetEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapOfSetEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel2MapOfSetEntriesValueOperator<K, ?> raw() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget());
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeIndexes(final int... indices) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveIndexes<V>(indices)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeEquals(final V... values) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveEquals<V>(values)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeMatching(final IEval<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveMatching<V>(eval)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNullOrMatching(final IEval<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNotNullMatching(final IEval<Boolean, ? super V> eval) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeSelected(final ISelect<V> selector) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveIndexesNot<V>(indices)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNotNullMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNullOrMatching(final String expression, final Object... optionalExpParams) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<V>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.RemoveNulls<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel2MapOfSetEntriesValueOperator<K, V> sort() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new SetFuncs.SortByComparator<V>(comparator)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(of, getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ToList.FromCollection<V>()));
    }


    public ILevel2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperator<K, V, V>(getTarget().execute(new ToMap.FromSetByAlternateElements<V>()));
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
