package org.op4j.operators.impl.mapofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> {


    public Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfArrayEntriesSelectedValueSelectedElementsOperator<K,V,I> forEach(final Type<V> elementType) {
        return new Level3MapOfArrayEntriesSelectedValueSelectedElementsOperatorImpl<K,V,I>(elementType, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> distinct() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> removeAllNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> endIf() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> add(final V newElement) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Add<V>(newElement)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> addAll(final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> insert(final int position, final V newElement) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElement)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> sort() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> replaceWith(final V[] replacement) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endIf().createOperation();
    }



}
