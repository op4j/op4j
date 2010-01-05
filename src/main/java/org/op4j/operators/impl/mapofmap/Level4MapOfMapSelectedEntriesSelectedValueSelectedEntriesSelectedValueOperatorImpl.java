package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNull() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNull() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> endOn() {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}