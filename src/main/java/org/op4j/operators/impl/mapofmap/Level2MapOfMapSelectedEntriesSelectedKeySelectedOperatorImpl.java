package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> {


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V> endIf() {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> exec(final IFunction<? extends K1,? super K1> function) {
        return null;
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> convert(final IConverter<? extends K1,? super K1> converter) {
        return null;
    }


    public Map<K1,Map<K2,V>> get() {
        return null;
    }



}
