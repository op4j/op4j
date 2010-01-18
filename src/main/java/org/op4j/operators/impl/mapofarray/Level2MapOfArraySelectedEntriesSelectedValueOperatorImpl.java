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
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> {


    public Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> forEach(final Type<V> elementType) {
        return new Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V>(elementType, getTarget().iterate());
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> distinct() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<V>(indices)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllEqual(final V... values) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<V>(values)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<V>(indices)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> removeAllNull() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveAllNull<V>()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> add(final V... newElements) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> sort() {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesSelectedValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Map<K,V[]> get() {
        return endOn().get();
    }



}
