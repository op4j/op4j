package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsEntriesKeySelectedOperator;
import org.op4j.target.Target;


public class Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> {


    public Level3SetOfMapElementsEntriesKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3SetOfMapElementsEntriesKeyOperator<K,V> endIf() {
        return new Level3SetOfMapElementsEntriesKeyOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3SetOfMapElementsEntriesKeySelectedOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapElementsEntriesKeySelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
