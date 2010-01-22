package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V,I> {


    public Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends K1,? super K1> eval) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V,I> endIf() {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V,I> exec(final IFunction<? extends K1,? super K1> function) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V,I> replaceWith(final K1 replacement) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfMapEntriesSelectedKeySelectedOperator<K1,K2,V,I> convert(final IConverter<? extends K1,? super K1> converter) {
        return new Level2MapOfMapEntriesSelectedKeySelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
