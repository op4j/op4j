package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V,I> {


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNull() {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNotNull() {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfListSelectedEntriesValueSelectedOperator<K,V,I> endFor() {
        return new Level2MapOfListSelectedEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfListSelectedEntriesValueSelectedElementsOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListSelectedEntriesValueSelectedElementsOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,List<V>> get() {
        return endFor().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endFor().createOperation();
    }



}
