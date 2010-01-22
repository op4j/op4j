package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V,I> {


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V,I> endFor() {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP, null));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifKeyEquals(final K2... keys) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeys(keys));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V,I> ifKeyNotEquals(final K2... keys) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMapKeysNot(keys));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperator<K1,K2,V,I> onKey() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V,I> onValue() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V,I> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endFor().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
