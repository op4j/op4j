package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> {


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,List<V>> get() {
        return null;
    }



}
