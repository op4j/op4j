package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> {


    public Level2MapOfMapEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndex(final int... indexes) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indexes));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNull() {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indexes) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indexes));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNull() {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> endOn() {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().endOn());
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> exec(final IFunction<? extends K1,? super K1> function) {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> replaceWith(final K1 replacement) {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V> convert(final IConverter<? extends K1,? super K1> converter) {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }



}
