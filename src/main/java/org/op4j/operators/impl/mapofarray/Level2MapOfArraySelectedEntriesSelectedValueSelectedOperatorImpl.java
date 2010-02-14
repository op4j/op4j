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
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> {


    private final Type<V> type;


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> forEach() {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().iterate(Structure.ARRAY));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> distinct() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexes(final int... indexes) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indexes)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllIndexesNot(final int... indexes) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indexes)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> removeAllNull() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> convertAsArray(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(converter, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> evalAsArray(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(eval, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> execAsArray(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> endIf() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(this.type, getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> add(final V newElement) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.Add<V>(newElement)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final V... newElements) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> insert(final int position, final V newElement) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.Insert<V>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> sort() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> map(final IFunction<? extends V,? super V> function) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().map(Structure.ARRAY, function, this.type.getRawClass()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> replaceWith(final V[] replacement) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement, Normalisation.ARRAY(this.type.getRawClass())));
    }


    public Map<K,V[]> get() {
        return endIf().get();
    }



}
