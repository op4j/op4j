package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> {


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> endIf() {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> execIfNotNull(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }



}
