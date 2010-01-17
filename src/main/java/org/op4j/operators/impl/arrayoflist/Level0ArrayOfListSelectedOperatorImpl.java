package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.util.NormalizationUtils;


public class Level0ArrayOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfListSelectedOperator<T> {


    public Level0ArrayOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListSelectedElementsOperator<T> forEach() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level0ArrayOfListSelectedOperator<T> distinct() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<List<T>>()));
    }


    public Level0ArrayOfListSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<List<T>>(indices)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeEquals(final List<T>... values) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<List<T>>(values)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<List<T>>(eval)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<List<T>>(indices)));
    }


    public Level0ArrayOfListSelectedOperator<T> removeNulls() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<List<T>>()));
    }


    public Level0ArrayOfListSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>[],? super List<T>[]> eval) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.ARRAY_OF_LIST));
    }


    public Level0ArrayOfListOperator<T> endIf() {
        return new Level0ArrayOfListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ArrayOfListSelectedOperator<T> add(final List<T>... newElements) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<List<T>>(NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ArrayOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<List<T>>(NormalizationUtils.normalizeLists(collection))));
    }


    public Level0ArrayOfListSelectedOperator<T> insert(final int position, final List<T>... newElements) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<List<T>>(position, NormalizationUtils.normalizeLists(newElements))));
    }


    public Level0ArrayOfListSelectedOperator<T> exec(final IFunction<? extends List<? extends T>[],? super List<T>[]> function) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.ARRAY_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfListSelectedOperator<T> sort() {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0ArrayOfListSelectedOperator<T> convert(final IConverter<? extends List<? extends T>[],? super List<T>[]> converter) {
        return new Level0ArrayOfListSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.ARRAY_OF_LIST));
    }


    public List<T>[] get() {
        return endIf().get();
    }



}
