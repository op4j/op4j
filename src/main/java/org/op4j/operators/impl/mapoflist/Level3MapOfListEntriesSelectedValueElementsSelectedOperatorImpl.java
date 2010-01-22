package org.op4j.operators.impl.mapoflist;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapoflist.Level3MapOfListEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V,I> {


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level3MapOfListEntriesSelectedValueElementsOperator<K,V,I> endIf() {
        return new Level3MapOfListEntriesSelectedValueElementsOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3MapOfListEntriesSelectedValueElementsSelectedOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfListEntriesSelectedValueElementsSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,List<V>> get() {
        return endIf().get();
    }


    public Operation<Map<K,List<V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
