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
package org.op4j.operators.qualities;

import org.javaruntype.type.Type;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface ICastableOperator {
    
    public <X> ILevel0ArrayOperator<X> castAsArray(final Type<X> of);
    public <X> ILevel0ListOperator<X> castAsList(final Type<X> of);
    public <K,V> ILevel0MapOperator<K,V> castAsMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0SetOperator<X> castAsSet(final Type<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(final Type<X> of);
    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(final Type<X> of);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> castAsArrayOfMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(final Type<X> of);
    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(final Type<X> of);
    public <X> ILevel0ListOfListOperator<X> castAsListOfList(final Type<X> of);
    public <K,V> ILevel0ListOfMapOperator<K,V> castAsListOfMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(final Type<X> of);
    public <K,V> ILevel0MapOfArrayOperator<K,V> castAsMapOfArray(final Type<K> keyOf, final Type<V> valueOf);
    public <K,V> ILevel0MapOfListOperator<K,V> castAsMapOfList(final Type<K> keyOf, final Type<V> valueOf);
    public <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> castAsMapOfMap(final Type<K1> key1Of, final Type<K2> key2Of, final Type<V> valueOf);
    public <K,V> ILevel0MapOfSetOperator<K,V> castAsMapOfSet(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(final Type<X> of);
    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(final Type<X> of);
    public <K,V> ILevel0SetOfMapOperator<K,V> castAsSetOfMap(final Type<K> keyOf, final Type<V> valueOf);
    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(final Type<X> of);

    
}
