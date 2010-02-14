package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V> {


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level3MapOfListEntriesSelectedValueElementsOperator<K,V> endIf() {
        return new Level3MapOfListEntriesSelectedValueElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
