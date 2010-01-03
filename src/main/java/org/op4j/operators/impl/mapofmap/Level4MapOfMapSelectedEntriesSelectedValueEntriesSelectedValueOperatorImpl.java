package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;


public class Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNull() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNull() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V> endOn() {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
