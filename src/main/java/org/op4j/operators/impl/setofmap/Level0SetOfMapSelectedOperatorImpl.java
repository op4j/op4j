package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0SetOfMapSelectedOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level0SetOfMapSelectedOperator<K,V,I> {


    public Level0SetOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsOperator<K,V,I> forEach() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V,I>(getTarget().iterate());
    }


    public Level0SetOfMapSelectedOperator<K,V,I> insertAll(final int position, final Map<K,V>... map) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllIndexes(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Map<K,V>>(indices)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllEqual(final Map<K,V>... values) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllEqual<Map<K,V>>(values)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllTrue<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllFalse<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllNullOrFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllNullOrTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Map<K,V>>(indices)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> removeAllNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.RemoveAllNull<Map<K,V>>()));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> eval(final IEvaluator<? extends Set<? extends Map<? extends K,? extends V>>,? super Set<Map<K,V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.SET_OF_MAP));
    }


    public Level0SetOfMapOperator<K,V,I> endIf() {
        return new Level0SetOfMapOperatorImpl<K,V,I>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V,I> add(final Map<K,V> newElement) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> addAll(final Map<K,V>... newElements) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Add<Map<K,V>>(NormalizationUtils.normalizeMaps(newElements))));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> addAll(final Collection<Map<K,V>> collection) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.AddAll<Map<K,V>>(NormalizationUtils.normalizeMaps(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V,I> insert(final int position, final Map<K,V> newElement) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Insert<Map<K,V>>(position, NormalizationUtils.normalizeMap(newElement))));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> exec(final IFunction<? extends Set<? extends Map<? extends K,? extends V>>,? super Set<Map<K,V>>> function) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.SET_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V,I> sort() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(new SetFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> replaceWith(final Set<Map<K,V>> replacement) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfMapSelectedOperator<K,V,I> convert(final IConverter<? extends Set<? extends Map<? extends K,? extends V>>,? super Set<Map<K,V>>> converter) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.SET_OF_MAP));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endIf().createOperation();
    }



}
