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
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
import org.op4j.operators.intf.mapoflist.ILevel3MapOfListEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofmap.ILevel2MapOfMapEntriesValueOperator;
import org.op4j.operators.intf.mapofset.ILevel2MapOfSetEntriesValueOperator;
import org.op4j.select.ISelector;
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
public class Level2MapOfListEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfListEntriesValueOperator<K,V> {

    
    public Level2MapOfListEntriesValueOperator(final Target target) {
        super(target);
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.Add<V>(newElements)));
    }

    public ILevel2MapOfListEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.AddAll<V>(collection)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfListEntriesValueOperator<K,V>(getTarget().execute(new ListFuncs.Distinct<V>()));
    }


    public ILevel1MapOfListEntriesOperator<K, V> endOn() {
        return new Level1MapOfListEntriesOperator<K, V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(indices));
    }


    


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(eval));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachSelected(final ISelector<V> selector) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterate(selector));
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNot(indices));
    }


    








    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNull());
    }


    public ILevel3MapOfListEntriesValueElementsOperator<K, V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfListEntriesValueElementsOperator<K, V>(getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel2MapOfListEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapOfListEntriesValueOperator<K, X>(getTarget());
    }


    public ILevel2MapOfListEntriesValueOperator<K, ?> raw() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget());
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeIndexes(final int... indices) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveIndexes<V>(indices)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeEquals(final V... values) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveEquals<V>(values)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveMatching<V>(eval)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeSelected(final ISelector<V> selector) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveIndexesNot<V>(indices)));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.RemoveNulls<V>()));
    }

    


    @SuppressWarnings("unchecked")
    public ILevel2MapOfListEntriesValueOperator<K, V> sort() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public ILevel2MapOfListEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ListFuncs.SortByComparator<V>(comparator)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> toArray(final Type<V> of) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(of, getTarget().execute(new ToArray.FromCollection<V>(of)));
    }


    public ILevel2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperator<K, V, V>(getTarget().execute(new ToMap.FromListByAlternateElements<V>()));
    }


    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V>(getTarget().execute(new ToMap.FromListByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V2>(getTarget().execute(new ToMap.FromListByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new ToSet.FromCollection<V>()));
    }


    public Map<K, List<V>> get() {
        return endOn().endFor().get();
    }

}
