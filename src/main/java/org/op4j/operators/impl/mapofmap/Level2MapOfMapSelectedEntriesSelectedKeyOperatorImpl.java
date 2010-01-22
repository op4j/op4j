package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V,I> {


    public Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNull() {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNull());
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNotNull() {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfMapSelectedEntriesSelectedKeySelectedOperator<K1,K2,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V,I> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return new Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> endOn() {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V,I> exec(final IFunction<? extends K1,? super K1> function) {
        return new Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V,I> replaceWith(final K1 replacement) {
        return new Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V,I> convert(final IConverter<? extends K1,? super K1> converter) {
        return new Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
