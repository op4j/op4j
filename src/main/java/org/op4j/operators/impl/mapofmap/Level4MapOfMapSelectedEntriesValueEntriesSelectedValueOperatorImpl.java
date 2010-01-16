package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNull() {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNull() {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level3MapOfMapSelectedEntriesValueEntriesSelectedOperator<K1,K2,V> endOn() {
        return new Level3MapOfMapSelectedEntriesValueEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapSelectedEntriesValueEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }



}
