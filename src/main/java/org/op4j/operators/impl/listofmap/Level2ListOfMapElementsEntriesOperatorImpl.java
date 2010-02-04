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
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.impl.listoflist.Level2ListOfListElementsElementsOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapElementsOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level2ListOfMapElementsEntriesOperatorImpl<K,V> extends AbstractOperatorImpl
        implements Level2ListOfMapElementsEntriesOperator<K,V>  {

    
    public Level2ListOfMapElementsEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapElementsOperator<K, V> endFor() {
        return new Level1ListOfMapElementsOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3ListOfMapElementsEntriesKeyOperator<K, V> onKey() {
        return new Level3ListOfMapElementsEntriesKeyOperatorImpl<K, V>(getTarget().onKey());
    }


    public Level3ListOfMapElementsEntriesValueOperator<K, V> onValue() {
        return new Level3ListOfMapElementsEntriesValueOperatorImpl<K, V>(getTarget().onValue());
    }


    public List<Map<K, V>> get() {
        return endFor().endFor().get();
    }

    
    

    
    public Level2ListOfMapElementsEntriesSelectedOperator<K, V> ifIndex(final int... indices) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndex(indices));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V> ifIndexNot(final int... indices) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V> ifKeyEquals(final K... keys) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeys(keys));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V> ifKeyNotEquals(final K... keys) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V>(getTarget().selectMapKeysNot(keys));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V> ifTrue(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V>(getTarget().selectMatching(eval));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K, V> ifFalse(final IEvaluator<Boolean, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K, V>(getTarget().selectNotMatching(eval));
    }


    public <X, Y> Level2ListOfMapElementsEntriesOperator<X, Y> convert(final IConverter<? extends Entry<X, Y>, ? super Entry<K, V>> converter) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<X, Y>(getTarget().execute(converter, Normalisation.MAPENTRY));
    }


    public <X, Y> Level2ListOfMapElementsEntriesOperator<X, Y> eval(final IEvaluator<? extends Entry<X, Y>, ? super Entry<K, V>> eval) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<X, Y>(getTarget().execute(eval, Normalisation.MAPENTRY));
    }


    public <X, Y> Level2ListOfMapElementsEntriesOperator<X, Y> exec(final IFunction<? extends Entry<X, Y>, ? super Entry<K, V>> function) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<X, Y>(getTarget().execute(function, Normalisation.MAPENTRY));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> convert(final Type<X> resultType, final IConverter<? extends X, ? super Entry<K, V>> converter) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(converter, Normalisation.NONE));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> eval(final Type<X> resultType, final IEvaluator<? extends X, ? super Entry<K, V>> eval) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(eval, Normalisation.NONE));
    }


    public <X> Level2ListOfListElementsElementsOperator<X> exec(final Type<X> resultType, final IFunction<? extends X, ? super Entry<K, V>> function) {
        return new Level2ListOfListElementsElementsOperatorImpl<X>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfMapElementsEntriesOperator<K, V> replaceWith(final Entry<K, V> replacement) {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K, V>(getTarget().replaceWith(replacement));
    }


    
    
}
