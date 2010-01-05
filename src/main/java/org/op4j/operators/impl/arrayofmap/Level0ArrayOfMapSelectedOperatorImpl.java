package org.op4j.operators.impl.arrayofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofmap.Level0ArrayOfMapSelectedOperator;
import org.op4j.operators.intf.arrayofmap.Level1ArrayOfMapSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArrayOfMapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0ArrayOfMapSelectedOperator<K,V> {


    public Level0ArrayOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfMapSelectedElementsOperator<K,V> forEach() {
        return new Level1ArrayOfMapSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0ArrayOfMapSelectedOperator<K,V> distinct() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<Map<K,V>>()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeEquals(final Map<K,V>... values) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V>[],? super Map<K,V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0ArrayOfMapOperator<K,V> endIf() {
        return new Level0ArrayOfMapOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level0ArrayOfMapSelectedOperator<K,V> add(final Map<K,V>... newElements) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V>... newElements) {
        return null;
    }


    public Level0ArrayOfMapSelectedOperator<K,V> exec(final IFunction<? extends Map<K,V>[],? super Map<K,V>[]> function) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapSelectedOperator<K,V> sort() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> convert(final IConverter<? extends Map<K,V>[],? super Map<K,V>[]> converter) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V>[] get() {
        return null;
    }



}
