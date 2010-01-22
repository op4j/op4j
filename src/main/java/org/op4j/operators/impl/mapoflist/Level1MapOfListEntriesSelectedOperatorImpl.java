package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesOperator;
import org.op4j.operators.intf.mapoflist.Level1MapOfListEntriesSelectedOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapoflist.Level2MapOfListEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfListEntriesSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level1MapOfListEntriesSelectedOperator<K,V,I> {


    public Level1MapOfListEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfListEntriesSelectedOperator<K,V,I> eval(final IEvaluator<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> eval) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListEntriesOperator<K,V,I> endIf() {
        return new Level1MapOfListEntriesOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level2MapOfListEntriesSelectedKeyOperator<K,V,I> onKey() {
        return new Level2MapOfListEntriesSelectedKeyOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfListEntriesSelectedValueOperator<K,V,I> onValue() {
        return new Level2MapOfListEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V,I> exec(final IFunction<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> function) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_LIST));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V,I> replaceWith(final Entry<K,List<V>> replacement) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfListEntriesSelectedOperator<K,V,I> convert(final IConverter<? extends Entry<? extends K,? extends List<? extends V>>,? super Entry<K,List<V>>> converter) {
        return new Level1MapOfListEntriesSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_LIST));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
