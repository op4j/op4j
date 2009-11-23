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

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.executables.Eval;
import org.op4j.executables.IEval;
import org.op4j.executables.IMapBuild;
import org.op4j.executables.ISelect;
import org.op4j.executables.functions.builtin.MapFunc;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.ILevel1MapOfArrayEntriesOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.target.Target;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0MapOfArrayOperator<K,V> extends Operator
        implements ILevel0MapOfArrayOperator<K,V> {
    
    private final Type<? super V> arrayOf; 

    
    public Level0MapOfArrayOperator(final Type<? super V> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel0MapOfArrayOperator<K, V> extract(K key) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> extractAll(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> extractAll(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> extractAll(
            ISelect<Entry<K, V[]>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> extractAllBut(K... keys) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> extractAllBut(String expression,
            Object... optionalExpParams) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> extractAllBut(
            ISelect<Entry<K, V[]>> selector) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0SetOperator<K> extractKeys() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0ListOfArrayOperator<V> extractValues() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntry() {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate());
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntryWithKeys(final K... keys) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterateForMapKeys(keys));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntry(final String expression, final Object... optionalExpParams) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate(expression, optionalExpParams));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntry(final ISelect<Entry<K, V[]>> selector) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel1MapOfArrayEntriesOperator<K, V> forEachEntryWithKeysNot(final K... keys) {
        return new Level1MapOfArrayEntriesOperator<K, V>(this.arrayOf, getTarget().iterateNot(keys));
    }








    public <X, Y> ILevel0MapOfArrayOperator<X, Y> of(final Type<X> ofX, final Type<Y> ofY) {
        // TODO Auto-generated method stub
        return null;
    }


    public <X, Y> ILevel0MapOfArrayOperator<X, Y> of(Class<X> ofXClass,
            Class<Y> ofYClass) {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> put(final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.Put<K,V[]>(newKey, newValue)));
    }


    public ILevel0MapOfArrayOperator<K, V> insert(final int position, final K newKey, final V[] newValue) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.Insert<K,V[]>(position, newKey, newValue)));
    }


    public ILevel0MapOfArrayOperator<K, V> putAll(final Map<K, V[]> map) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.PutAll<K,V[]>(map)));
    }

    
    public ILevel0MapOfArrayOperator<K, V> insertAll(final int position, final Map<K, V[]> map) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.InsertAll<K,V[]>(position, map)));
    }


    public ILevel0MapOfArrayOperator<?, ?> raw() {
        // TODO Auto-generated method stub
        return null;
    }


    public ILevel0MapOfArrayOperator<K, V> removeKeys(final K... keys) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.RemoveKeys<K,V[]>(keys)));
    }


    public ILevel0MapOfArrayOperator<K, V> removeMatching(final String expression, final Object... optionalExpParams) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.RemoveMatching<K,V[]>(Eval.booleanExp(expression, optionalExpParams))));
    }


    public ILevel0MapOfArrayOperator<K, V> removeSelected(final ISelect<Entry<K, V[]>> selector) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.RemoveSelected<K,V[]>(selector)));
    }


    public ILevel0MapOfArrayOperator<K, V> removeAllExceptKeys(final K... keys) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.RemoveAllExceptKeys<K,V[]>(keys)));
    }






    @SuppressWarnings("unchecked")
    public ILevel0MapOfArrayOperator<K, V> sort() {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.SortByKey()));
    }


    public ILevel0MapOfArrayOperator<K, V> sort(final Comparator<? super Entry<K, V[]>> comparator) {
        return new Level0MapOfArrayOperator<K, V>(this.arrayOf, getTarget().execute(new MapFunc.SortEntries<K, V[]>(comparator)));
    }


    public ILevel0MapOfListOperator<K, V> toMapOfList() {
        return forEachEntry().onValue().toList().endOn().endFor();
    }


    public <K2> ILevel0MapOfMapOperator<K, K2, V> toMapOfMap(final IEval<K2, ? super V> keyEval) {
        return forEachEntry().onValue().toMap(keyEval).endOn().endFor();
    }


    public <K2, V2> ILevel0MapOfMapOperator<K, K2, V2> toMapOfMap(final IMapBuild<K2, V2, ? super V> mapBuild) {
        return forEachEntry().onValue().toMap(mapBuild).endOn().endFor();
    }


    public ILevel0MapOfSetOperator<K, V> toMapOfSet() {
        return forEachEntry().onValue().toSet().endOn().endFor();
    }


    @SuppressWarnings("unchecked")
    public Map<K, V[]> get() {
        return (Map<K,V[]>) getTarget().get();
    }


    public ILevel0GenericUniqOperator<Map<K, V[]>> generic() {
        // TODO Auto-generated method stub
        return null;
    }

}
