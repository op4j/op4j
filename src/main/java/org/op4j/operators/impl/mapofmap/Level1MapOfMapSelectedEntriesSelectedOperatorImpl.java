package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> {


    public Level1MapOfMapSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapSelectedEntriesOperator<K1,K2,V,I> endIf() {
        return new Level1MapOfMapSelectedEntriesOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level2MapOfMapSelectedEntriesSelectedKeyOperator<K1,K2,V,I> onKey() {
        return new Level2MapOfMapSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfMapSelectedEntriesSelectedValueOperator<K1,K2,V,I> onValue() {
        return new Level2MapOfMapSelectedEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> function) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> replaceWith(final Entry<K1,Map<K2,V>> replacement) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfMapSelectedEntriesSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> converter) {
        return new Level1MapOfMapSelectedEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
