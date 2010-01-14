package org.op4j.operators.impl.listofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.intf.listofmap.Level0ListOfMapSelectedOperator;
import org.op4j.operators.intf.listofmap.Level1ListOfMapSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ListOfMapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0ListOfMapSelectedOperator<K,V> {


    public Level0ListOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfMapSelectedElementsOperator<K,V> forEach() {
        return new Level1ListOfMapSelectedElementsOperatorImpl<K,V>(getTarget().iterate());
    }


    public Level0ListOfMapSelectedOperator<K,V> distinct() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Distinct<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeIndexes(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveIndexes<Map<K,V>>(indices)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeEquals(final Map<K,V>... values) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveEquals<Map<K,V>>(values)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveMatching<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNotMatching<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<Map<K,V>>(eval)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveIndexesNot<Map<K,V>>(indices)));
    }


    public Level0ListOfMapSelectedOperator<K,V> removeNulls() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.RemoveNulls<Map<K,V>>()));
    }


    public Level0ListOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> eval) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level0ListOfMapOperator<K,V> endIf() {
        return new Level0ListOfMapOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level0ListOfMapSelectedOperator<K,V> add(final Map<K,V>... newElements) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Add<Map<K,V>>(newElements)));
    }


    public Level0ListOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.AddAll<Map<K,V>>(collection)));
    }


    public Level0ListOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V>... newElements) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Insert<Map<K,V>>(position, newElements)));
    }


    public Level0ListOfMapSelectedOperator<K,V> exec(final IFunction<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> function) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfMapSelectedOperator<K,V> sort() {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new ListFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0ListOfMapSelectedOperator<K,V> convert(final IConverter<? extends List<? extends Map<? extends K,? extends V>>,? super List<Map<K,V>>> converter) {
        return new Level0ListOfMapSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
