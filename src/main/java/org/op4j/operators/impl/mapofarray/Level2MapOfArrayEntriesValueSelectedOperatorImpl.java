package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfArrayEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesValueSelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArrayEntriesValueSelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesValueOperator<K,V> endIf() {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return null;
    }


    public Map<K,V[]> get() {
        return null;
    }



}
