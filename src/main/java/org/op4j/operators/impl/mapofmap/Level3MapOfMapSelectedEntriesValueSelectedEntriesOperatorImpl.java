package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V,I> {


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2MapOfMapSelectedEntriesValueSelectedOperator<K1,K2,V,I> endFor() {
        return new Level2MapOfMapSelectedEntriesValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperator<K1,K2,V,I> onKey() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesValueOperator<K1,K2,V,I> onValue() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V,I> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
