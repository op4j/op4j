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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> {


    public Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> forEach(final Type<V> elementType) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(elementType, getTarget().iterate(Structure.ARRAY));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> convertAsArray(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.ARRAY));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> evalAsArray(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.ARRAY));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> execAsArray(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.ARRAY));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> add(final V newElement) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElement)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> replaceWith(final V[] replacement) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
