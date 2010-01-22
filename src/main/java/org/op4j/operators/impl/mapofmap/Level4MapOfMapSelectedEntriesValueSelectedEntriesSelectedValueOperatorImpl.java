package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> {


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifIndex(final int... indices) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndex(indices));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNull() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNull());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifIndexNot(final int... indices) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNotNull() {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNull());
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperator<K1,K2,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueSelectedOperatorImpl<K1,K2,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperator<K1,K2,V,I> endOn() {
        return new Level3MapOfMapSelectedEntriesValueSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> replaceWith(final V replacement) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperator<K1,K2,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level4MapOfMapSelectedEntriesValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
