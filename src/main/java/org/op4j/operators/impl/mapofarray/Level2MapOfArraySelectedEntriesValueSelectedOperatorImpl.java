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
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsOperator;
import org.op4j.target.Target;


public class Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> forEach(final Type<V> elementType) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(elementType, getTarget().iterate());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeIndexes(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveIndexes<V>(indices)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeEquals(final V... values) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveEquals<V>(values)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<V>(indices)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeNulls() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNulls<V>()));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> add(final V... newElements) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
