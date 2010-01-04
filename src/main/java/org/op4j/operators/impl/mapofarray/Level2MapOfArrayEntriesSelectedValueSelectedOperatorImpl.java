package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArrayEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
