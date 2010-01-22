package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> {


    public Level1MapOfMapEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> eval) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapEntriesOperator<K1,K2,V,I> endIf() {
        return new Level1MapOfMapEntriesOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level2MapOfMapEntriesSelectedKeyOperator<K1,K2,V,I> onKey() {
        return new Level2MapOfMapEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V,I> onValue() {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> function) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY_OF_MAP));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> replaceWith(final Entry<K1,Map<K2,V>> replacement) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K1,? extends Map<? extends K2,? extends V>>,? super Entry<K1,Map<K2,V>>> converter) {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY_OF_MAP));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
