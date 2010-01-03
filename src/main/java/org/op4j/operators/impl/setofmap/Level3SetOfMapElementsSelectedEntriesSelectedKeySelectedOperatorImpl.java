package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> {


    public Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> endIf() {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return null;
    }


    public Level3SetOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
