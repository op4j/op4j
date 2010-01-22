package org.op4j.operators.impl.mapofmap;

import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> {


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> eval(final IEvaluator<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> eval) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(eval, Normalization.MAPENTRY));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesOperator<K1,K2,V> endIf() {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesOperatorImpl<K1,K2,V>(getTarget().endSelect());
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperator<K1,K2,V> onKey() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedKeyOperatorImpl<K1,K2,V>(getTarget().iterate().selectIndex(0));
    }


    public Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedValueOperator<K1,K2,V> onValue() {
        return new Level4MapOfMapEntriesSelectedValueSelectedEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().iterate().selectIndex(1));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> exec(final IFunction<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> function) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalization.MAPENTRY));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> replaceWith(final Entry<K2,V> replacement) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperator<K1,K2,V> convert(final IConverter<? extends Entry<? extends K2,? extends V>,? super Entry<K2,V>> converter) {
        return new Level3MapOfMapEntriesSelectedValueSelectedEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().execute(converter, Normalization.MAPENTRY));
    }


    public Map<K1,Map<K2,V>> get() {
        return endIf().get();
    }



}
