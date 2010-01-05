package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArrayEntriesSelectedValueOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> forEach() {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(this.arrayOf, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> distinct() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeEquals(final V... values) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeNulls() {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return null;
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
