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
package org.op4j.op.intf.qualities;

import org.op4j.op.commands.IEval;
import org.op4j.op.intf.operators.array.ILevel0ArrayOperator;
import org.op4j.op.intf.operators.list.ILevel0ListOperator;
import org.op4j.op.intf.operators.map.ILevel0MapOperator;
import org.op4j.op.intf.operators.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.op.intf.operators.mapoflist.ILevel0MapOfListOperator;
import org.op4j.op.intf.operators.mapofset.ILevel0MapOfSetOperator;
import org.op4j.op.intf.operators.set.ILevel0SetOperator;
import org.op4j.op.intf.parameters.IMapBuild;
import org.op4j.op.intf.parameters.IOf;



/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public interface IBuilderOperator<T> {
    
    
    public ILevel0ListOperator<T> buildList();
    
    
    public ILevel0SetOperator<T> buildSet();
    
    
    public <X> ILevel0ArrayOperator<X> buildArray(final IOf<X> of);
    public <X> ILevel0ArrayOperator<X> buildArray(final Class<X> classOf);
    
    
    public <K> ILevel0MapOperator<K,T> buildMap(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOperator<K,V> buildMap(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfListOperator<K,T> buildMapOfList(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfListOperator<K,V> buildMapOfList(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K> ILevel0MapOfSetOperator<K,T> buildMapOfSet(final IEval<K,? super T> keyEval);
    public <K,V> ILevel0MapOfSetOperator<K,V> buildMapOfSet(final IMapBuild<K,V,? super T> mapBuild);
    
    
    public <K,X> ILevel0MapOfArrayOperator<K,X> buildMapOfArray(final IEval<K,? super T> keyEval, final IOf<X> valueArrayOf);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final IMapBuild<K,V,? super T> mapBuild, final IOf<V> valueArrayOf);
    public <K,X> ILevel0MapOfArrayOperator<K,X> buildMapOfArray(final IEval<K,? super T> keyEval, final Class<X> valueArrayOfClass);
    public <K,V> ILevel0MapOfArrayOperator<K,V> buildMapOfArray(final IMapBuild<K,V,? super T> mapBuild, final Class<V> valueArrayOfClass);
    
}
