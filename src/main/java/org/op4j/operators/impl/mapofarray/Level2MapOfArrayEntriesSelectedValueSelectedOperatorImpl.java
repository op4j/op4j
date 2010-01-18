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
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> {


    public Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level3MapOfArrayEntriesSelectedValueSelectedElementsOperator<K,V> forEach(final Type<V> elementType) {
        return new Level3MapOfArrayEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(elementType, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> add(final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
