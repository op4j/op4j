package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V,I> {


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V,I> endFor() {
        return new Level2MapOfMapSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesKeyOperator<K1,K2,V,I> onKey() {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperator<K1,K2,V,I> onValue() {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V,I> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
