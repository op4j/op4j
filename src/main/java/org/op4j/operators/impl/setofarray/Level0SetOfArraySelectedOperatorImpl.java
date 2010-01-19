package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0SetOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfArraySelectedOperator<T> {


    public Level0SetOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfArraySelectedElementsOperator<T> forEach() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0SetOfArraySelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T[]>(indices)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllEqual(final T[]... values) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T[]>(indices)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNull() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T[]>()));
    }


    public Level0SetOfArraySelectedOperator<T> replaceBy(final Set<T[]> replacement) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level0SetOfArraySelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T[]>,? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.SET_OF_ARRAY));
    }


    public Level0SetOfArrayOperator<T> endIf() {
        return new Level0SetOfArrayOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetOfArraySelectedOperator<T> add(final T[]... newElements) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T[]>(NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0SetOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T[]>(NormalizationUtils.normalizeArrays(collection))));
    }


    public Level0SetOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T[]>(position, NormalizationUtils.normalizeArrays(newElements))));
    }


    public Level0SetOfArraySelectedOperator<T> exec(final IFunction<? extends Set<? extends T[]>,? super Set<T[]>> function) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(function, Normalization.SET_OF_ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArraySelectedOperator<T> sort() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0SetOfArraySelectedOperator<T> convert(final IConverter<? extends Set<? extends T[]>,? super Set<T[]>> converter) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.SET_OF_ARRAY));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
