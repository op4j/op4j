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
import org.op4j.operators.intf.mapofarray.Level1MapOfArrayEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArrayEntriesSelectedValueOperator<K,V> {


    public Level2MapOfArrayEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfArrayEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesSelectedValueElementsOperator<K,V> forEach(final Type<V> elementType) {
        return new Level3MapOfArrayEntriesSelectedValueElementsOperatorImpl<K,V>(elementType, getTarget().iterate());
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> distinct() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1MapOfArrayEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfArrayEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArrayEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArrayEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Map<K,V[]> get() {
        return endOn().get();
    }



}
