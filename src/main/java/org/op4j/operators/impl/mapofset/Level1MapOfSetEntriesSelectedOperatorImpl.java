package org.op4j.operators.impl.mapofset;

import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesOperator;
import org.op4j.operators.intf.mapofset.Level1MapOfSetEntriesSelectedOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofset.Level2MapOfSetEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfSetEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapOfSetEntriesSelectedOperator<K,V,I> {


    public Level1MapOfSetEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> eval) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_SET));
    }


    public Level1MapOfSetEntriesOperator<K,V,I> endIf() {
        return new Level1MapOfSetEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfSetEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapOfSetEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfSetEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapOfSetEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> function) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_SET));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,Set<V>> replacement) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfSetEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends Set<? extends V>>,? super Entry<K,Set<V>>> converter) {
        return new Level1MapOfSetEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_SET));
    }


    public Map<K,Set<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,Set<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
