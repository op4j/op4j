package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super V[]> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super V[]> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V[]> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V[]> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super V[]> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super V[]> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return null;
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return null;
    }


    public Map<K,V[]> get() {
        return null;
    }



}
