package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I> extends AbstractOperatorImpl implements Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> {


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesOperator<K1,K2,V,I> endIf() {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesOperatorImpl<K1,K2,V,I>(getTarget().endSelect());
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedKeyOperator<K1,K2,V,I> onKey() {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedKeyOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperator<K1,K2,V,I> onValue() {
        return new Level4MapOfMapSelectedEntriesSelectedValueEntriesSelectedValueOperatorImpl<K1,K2,V,I>(getTarget().iterate().selectIndex(1));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperator<K1,K2,V,I> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapSelectedEntriesSelectedValueEntriesSelectedOperatorImpl<K1,K2,V,I>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }


    public Operation<Map<K1,Map<K2,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
