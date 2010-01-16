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
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesValueOperator<K,V> {


    public Level2MapOfArraySelectedEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNull() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueSelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueElementsOperator<K,V> forEach(final Type<V> elementType) {
        return new Level3MapOfArraySelectedEntriesValueElementsOperatorImpl<K,V>(elementType, getTarget().iterate());
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> distinct() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Distinct<V>()));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeIndexes(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveIndexes<V>(indices)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeEquals(final V... values) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveEquals<V>(values)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<V>(eval)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeIndexesNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<V>(indices)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> removeNulls() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.RemoveNulls<V>()));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> eval(final IEvaluator<? extends V[],? super V[]> eval) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(eval, Normalization.ARRAY));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> endOn() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> add(final V... newElements) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Add<V>(newElements)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> addAll(final Collection<V> collection) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.AddAll<V>(collection)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> insert(final int position, final V... newElements) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Insert<V>(position, newElements)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> exec(final IFunction<? extends V[],? super V[]> function) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(function, Normalization.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfArraySelectedEntriesValueOperator<K,V> sort() {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> sort(final Comparator<? super V> comparator) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(new ArrayFuncs.SortByComparator<V>(comparator)));
    }


    public Level2MapOfArraySelectedEntriesValueOperator<K,V> convert(final IConverter<? extends V[],? super V[]> converter) {
        return new Level2MapOfArraySelectedEntriesValueOperatorImpl<K,V>(getTarget().execute(converter, Normalization.ARRAY));
    }


    public Map<K,V[]> get() {
        return endOn().get();
    }



}
