package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfMapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0SetOfMapSelectedOperator<K,V> {


    public Level0SetOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> forEach() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0SetOfMapSelectedOperator<K,V> removeIndexes(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveIndexes<Map<K,V>>(indices)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeEquals(final Map<K,V>... values) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveEquals<Map<K,V>>(values)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveMatching<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNotMatching<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveIndexesNot<Map<K,V>>(indices)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNulls() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveNulls<Map<K,V>>()));
    }


    public Level0SetOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends Set<Map<K,V>>,? super Set<Map<K,V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0SetOfMapOperator<K,V> endIf() {
        return new Level0SetOfMapOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level0SetOfMapSelectedOperator<K,V> add(final Map<K,V>... newElements) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<Map<K,V>>(newElements)));
    }


    public Level0SetOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<Map<K,V>>(collection)));
    }


    public Level0SetOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V>... newElements) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<Map<K,V>>(position, newElements)));
    }


    public Level0SetOfMapSelectedOperator<K,V> exec(final IFunction<? extends Set<Map<K,V>>,? super Set<Map<K,V>>> function) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V> sort() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0SetOfMapSelectedOperator<K,V> convert(final IConverter<? extends Set<Map<K,V>>,? super Set<Map<K,V>>> converter) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
