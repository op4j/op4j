package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapOfArraySelectedEntriesSelectedOperator<K,V,I> {


    public Level1MapOfArraySelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> eval) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V,I> endIf() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> function) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,V[]> replacement) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends V[]>,? super Entry<K,V[]>> converter) {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_ARRAY));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
