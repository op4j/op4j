package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(this.arrayOf, getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
