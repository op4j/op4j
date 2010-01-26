package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> {


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifTrue(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifFalse(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrFalse(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNull() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNullOrTrue(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNull() {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperator<K1,K2,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> eval(final IEvaluator<? extends K2,? super K2> eval) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> endOn() {
        return new Level3MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().endOn());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> convert(final IConverter<? extends K2,? super K2> converter) {
        return new Level4MapOfMapSelectedEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }



}
