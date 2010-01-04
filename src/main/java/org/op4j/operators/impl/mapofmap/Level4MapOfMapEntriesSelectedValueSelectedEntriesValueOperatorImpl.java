package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNull() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotNull() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> endOn() {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesValueOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
