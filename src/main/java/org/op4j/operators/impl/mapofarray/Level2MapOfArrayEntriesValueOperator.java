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
package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.mapoflist.Level2MapOfListEntriesValueOperator;
import org.op4j.operators.impl.mapofmap.Level2MapOfMapEntriesValueOperator;
import org.op4j.operators.impl.mapofset.Level2MapOfSetEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapofarray.ILevel2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.ILevel3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapoflist.ILevel2MapOfListEntriesValueOperator;
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
public class Level2MapOfArrayEntriesValueOperator<K,V> extends Operator
        implements ILevel2MapOfArrayEntriesValueOperator<K,V> {
    
    private final Type<? super V> arrayOf; 

    
    public Level2MapOfArrayEntriesValueOperator(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> add(final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> insert(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> distinct() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> endOn() {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEach() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachIndex(final int... indices) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachSelected(final ISelector<V> selector) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachIndexNot(final int... indices) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNotNull() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNull() {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel3MapOfArrayEntriesValueElementsOperator<K, V> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level3MapOfArrayEntriesValueElementsOperator<K, V>(this.arrayOf, getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel2MapOfArrayEntriesValueOperator<K, X> of(final Type<X> of) {
        return new Level2MapOfArrayEntriesValueOperator<K, X>(of, getTarget());
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, ?> raw() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget());
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<V>(indices)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeEquals(final V... values) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<V>(values)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<V>(eval)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeSelected(final ISelector<V> selector) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<V>(selector)));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<V>(indices)));
    }



    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }

    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<V>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel2MapOfArrayEntriesValueOperator<K, V> removeNulls() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<V>()));
    }

    
    @SuppressWarnings("unchecked")
    public ILevel2MapOfArrayEntriesValueOperator<K, V> sort() {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel2MapOfArrayEntriesValueOperator<K, V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesValueOperator<K, V>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }




    public ILevel2MapOfListEntriesValueOperator<K, V> toList() {
        return new Level2MapOfListEntriesValueOperator<K, V>(getTarget().execute(new ToList.FromArray<V>()));
    }


    public ILevel2MapOfMapEntriesValueOperator<K, V, V> toMap() {
        return new Level2MapOfMapEntriesValueOperator<K, V, V>(getTarget().execute(new ToMap.FromArrayByAlternateElements<V>()));
    }


    public <K2> ILevel2MapOfMapEntriesValueOperator<K, K2, V> toMap(final IEvaluator<K2, ? super V> keyEval) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V>(getTarget().execute(new ToMap.FromArrayByKeyEval<K2, V>(keyEval)));
    }


    public <K2, V2> ILevel2MapOfMapEntriesValueOperator<K, K2, V2> toMap(final IMapBuilder<K2, V2, ? super V> mapBuild) {
        return new Level2MapOfMapEntriesValueOperator<K, K2, V2>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K2, V2, V>(mapBuild)));
    }


    public ILevel2MapOfSetEntriesValueOperator<K, V> toSet() {
        return new Level2MapOfSetEntriesValueOperator<K, V>(getTarget().execute(new ToSet.FromArray<V>()));
    }


    public Map<K, V[]> get() {
        return endOn().endFor().get();
    }

}
