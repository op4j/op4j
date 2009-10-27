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

import org.op4j.IOf;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
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
    
    public ILevel0ArrayOfArrayOperator<?> castAsArrayOfArray();
    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(final IOf<X> of);
    public <X> ILevel0ArrayOfArrayOperator<X> castAsArrayOfArray(final Class<X> of);
    
    public ILevel0ArrayOfListOperator<?> castAsArrayOfList();
    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(final IOf<X> of);
    public <X> ILevel0ArrayOfListOperator<X> castAsArrayOfList(final Class<X> of);
    
    public ILevel0ArrayOfMapOperator<?,?> castAsArrayOfMap();
    public <K,V> ILevel0ArrayOfMapOperator<K,V> castAsArrayOfMap(final IOf<K> keyOf, final IOf<V> valueOf);
    public <K,V> ILevel0ArrayOfMapOperator<K,V> castAsArrayOfMap(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0ArrayOfSetOperator<?> castAsArrayOfSet();
    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(final IOf<X> of);
    public <X> ILevel0ArrayOfSetOperator<X> castAsArrayOfSet(final Class<X> of);
    
    public ILevel0ListOfArrayOperator<?> castAsListOfArray();
    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(final IOf<X> of);
    public <X> ILevel0ListOfArrayOperator<X> castAsListOfArray(final Class<X> of);
    
    public ILevel0ListOfListOperator<?> castAsListOfList();
    public <X> ILevel0ListOfListOperator<X> castAsListOfList(final IOf<X> of);
    public <X> ILevel0ListOfListOperator<X> castAsListOfList(final Class<X> of);
    
    public ILevel0ListOfMapOperator<?,?> castAsListOfMap();
    public <K,V> ILevel0ListOfMapOperator<K,V> castAsListOfMap(final IOf<K> keyOf, final IOf<V> valueOf);
    public <K,V> ILevel0ListOfMapOperator<K,V> castAsListOfMap(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0ListOfSetOperator<?> castAsListOfSet();
    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(final IOf<X> of);
    public <X> ILevel0ListOfSetOperator<X> castAsListOfSet(final Class<X> of);
    
    public ILevel0MapOfArrayOperator<?,?> castAsMapOfArray();
    public <K,V> ILevel0MapOfArrayOperator<K,V> castAsMapOfArray(final IOf<K> keyOf, final IOf<V> valueOf);
    public <K,V> ILevel0MapOfArrayOperator<K,V> castAsMapOfArray(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0MapOfListOperator<?,?> casstAsMapOfList();
    public <K,V> ILevel0MapOfListOperator<K,V> castAsMapOfList(final IOf<K> keyOf, final IOf<V> valueOf);
    public <K,V> ILevel0MapOfListOperator<K,V> castAsMapOfList(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0MapOfMapOperator<?,?,?> castAsMapOfMap();
    public <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> castAsMapOfMap(final IOf<K1> key1Of, final IOf<K2> key2Of, final IOf<V> valueOf);
    public <K1,K2,V> ILevel0MapOfMapOperator<K1,K2,V> castAsMapOfMap(final Class<K1> key1Of, final Class<K2> key2Of, final Class<V> valueOf);
    
    public ILevel0MapOfSetOperator<?,?> castAsMapOfSet();
    public <K,V> ILevel0MapOfSetOperator<K,V> castAsMapOfSet(final IOf<K> keyOf, final IOf<V> valueOf);
    public <K,V> ILevel0MapOfSetOperator<K,V> castAsMapOfSet(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0SetOfArrayOperator<?> castAsSetOfArray();
    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(final IOf<X> of);
    public <X> ILevel0SetOfArrayOperator<X> castAsSetOfArray(final Class<X> of);
    
    public ILevel0SetOfListOperator<?> castAsSetOfList();
    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(final IOf<X> of);
    public <X> ILevel0SetOfListOperator<X> castAsSetOfList(final Class<X> of);
    
    public ILevel0SetOfMapOperator<?,?> castAsSetOfMap();
    public <K,V> ILevel0SetOfMapOperator<K,V> castAsSetOfMap(final IOf<K> keyOf, final IOf<V> valueOf);
    public <K,V> ILevel0SetOfMapOperator<K,V> castAsSetOfMap(final Class<K> keyOf, final Class<V> valueOf);
    
    public ILevel0SetOfSetOperator<?> castAsSetOfSet();
    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(final IOf<X> of);
    public <X> ILevel0SetOfSetOperator<X> castAsSetOfSet(final Class<X> of);

    
}
