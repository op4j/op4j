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
import java.util.Map.Entry;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.listoflist.Level2ListOfListElementsElementsOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfMapElementsEntriesOperatorImpl<K,V,I> extends AbstractOperatorImpl
        implements Level2ListOfMapElementsEntriesOperator<K,V,I>  {

    
    public Level2ListOfMapElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapElementsOperator<K, V,I> endFor() {
        return new Level1ListOfMapElementsOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V,I> onKey() {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<K, V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level3ListOfMapElementsEntriesValueOperator<K, V,I> onValue() {
        return new Level3ListOfMapElementsEntriesValueOperatorImpl<K, V,I>(getTarget().iterate().selectIndex(1));
    }


    public List<Map<K, V>> get() {
        return endFor().endFor().get();
    }

    
    

    
    public Level2ListOfMapElementsEntriesSelectedOperator<K, V,I> ifIndex(final int... indices) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndex(indices));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V,I> ifIndexNot(final int... indices) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V,I> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V,I> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V,I>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level2ListOfMapElementsEntriesOperator<X, Y,I> convert(final IConverter<? extends Entry<X, Y>, ? super Entry<K, V>> converter) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<X, Y,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public <X, Y> Level2ListOfMapElementsEntriesOperator<X, Y,I> eval(final IEvaluator<? extends Entry<X, Y>, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<X, Y,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public <X, Y> Level2ListOfMapElementsEntriesOperator<X, Y,I> exec(final IFunction<? extends Entry<X, Y>, ? super Entry<K, V>> function) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<X, Y,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public <X> Level2ListOfListElementsElementsOperator<X,I> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K, V>> converter) {
        return new Level2ListOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public <X> Level2ListOfListElementsElementsOperator<X,I> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K, V>> eval) {
        return new Level2ListOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public <X> Level2ListOfListElementsElementsOperator<X,I> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K, V>> function) {
        return new Level2ListOfListElementsElementsOperatorImpl<X,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfMapElementsEntriesOperator<K, V,I> replaceWith(final Entry<K, V> replacement) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K, V,I>(getTarget().replaceWith(replacement));
    }


    public Operation<List<Map<K, V>>, I> createOperation() {
        return endFor().createOperation();
    }
    
}
