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
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> {


    public Level2MapOfArrayEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNotNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V,I> forEach(final Type<V> elementType) {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V,I>(elementType, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> distinct() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> insertAll(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> removeAllNull() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V,I> endOn() {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> add(final V newElement) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Add<V>(newElement)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> addAll(final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> insert(final int position, final V newElement) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElement)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> sort() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> replaceWith(final V[] replacement) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V,I> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Map<K,V[]> get() {
        return endOn().get();
    }


    public Operation<Map<K,V[]>,I> createOperation() {
        return endOn().createOperation();
    }



}
