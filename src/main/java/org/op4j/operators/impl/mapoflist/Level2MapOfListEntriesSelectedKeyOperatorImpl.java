package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfListEntriesSelectedKeyOperator<K,V,I> {


    public Level2MapOfListEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifNull() {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifNotNull() {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfListEntriesSelectedKeySelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V,I> endOn() {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V,I> replaceWith(final K replacement) {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,List<V>> get() {
        return endOn().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
