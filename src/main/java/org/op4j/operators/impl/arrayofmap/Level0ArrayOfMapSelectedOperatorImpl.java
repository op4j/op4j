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
import org.op4j.target.Target.Normalization;


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
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveIndexes<Map<K,V>>(indices)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeEquals(final Map<K,V>... values) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveEquals<Map<K,V>>(values)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveMatching<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<Map<K,V>>(eval)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<Map<K,V>>(indices)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> removeNulls() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNulls<Map<K,V>>()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends Map<? extends K,? extends V>[],? super Map<K,V>[]> eval) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.ARRAY_OF_MAP));
    }


    public Level0ArrayOfMapOperator<K,V> endIf() {
        return new Level0ArrayOfMapOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level0ArrayOfMapSelectedOperator<K,V> add(final Map<K,V>... newElements) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<Map<K,V>>(newElements)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<Map<K,V>>(collection)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V>... newElements) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<Map<K,V>>(position, newElements)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> exec(final IFunction<? extends Map<? extends K,? extends V>[],? super Map<K,V>[]> function) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.ARRAY_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfMapSelectedOperator<K,V> sort() {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0ArrayOfMapSelectedOperator<K,V> convert(final IConverter<? extends Map<? extends K,? extends V>[],? super Map<K,V>[]> converter) {
        return new Level0ArrayOfMapSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.ARRAY_OF_MAP));
    }


    public Map<K,V>[] get() {
        return endIf().get();
    }



}
