package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesValueOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesValueOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> forEach() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> distinct() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> endOn() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> sort() {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
