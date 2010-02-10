package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> {


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfListEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfListEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().endIterate(null));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfListEntriesSelectedValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,List<V>> get() {
        return endFor().get();
    }



}
