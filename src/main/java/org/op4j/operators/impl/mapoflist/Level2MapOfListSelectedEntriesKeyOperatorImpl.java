package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListSelectedEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfListSelectedEntriesKeyOperator<K,V,I> {


    public Level2MapOfListSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifNull() {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifNotNull() {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfListSelectedEntriesKeySelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1MapOfListSelectedEntriesOperator<K,V,I> endOn() {
        return new Level1MapOfListSelectedEntriesOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V,I> replaceWith(final K replacement) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfListSelectedEntriesKeyOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfListSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,List<V>> get() {
        return endOn().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
