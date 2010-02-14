package org.op4j.operators.impl.arrayofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.intf.arrayofset.Level0ArrayOfSetSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0ArrayOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfSetSelectedOperator<T> {


    public Level0ArrayOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfSetSelectedElementsOperator<T> forEach() {
        return new Level1ArrayOfSetSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.ARRAY));
    }


    public Level0ArrayOfSetSelectedOperator<T> distinct() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<Set<T>>()));
    }


    public Level0ArrayOfSetSelectedOperator<T> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSets(newElements))));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<Set<T>>(indexes)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllEqual(final Set<T>... values) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<Set<T>>(indexes)));
    }


    public Level0ArrayOfSetSelectedOperator<T> removeAllNull() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<Set<T>>()));
    }


    public Level0ArrayOfSetOperator<T> endIf() {
        return new Level0ArrayOfSetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ArrayOfSetSelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function) {
        return forEach().map(function).endFor();
    }


    public Level0ArrayOfSetSelectedOperator<T> convertAsArrayOfSet(final IConverter<? extends Set<? extends T>[],? super Set<T>[]> converter) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.ARRAY_OF_SET));
    }


    public Level0ArrayOfSetSelectedOperator<T> evalAsArrayOfSet(final IEvaluator<? extends Set<? extends T>[],? super Set<T>[]> eval) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.ARRAY_OF_SET));
    }


    public Level0ArrayOfSetSelectedOperator<T> execAsArrayOfSet(final IFunction<? extends Set<? extends T>[],? super Set<T>[]> function) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.ARRAY_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T> add(final Set<T> newElement) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(NormalisationUtils.normaliseSet(newElement))));
    }


    public Level0ArrayOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<Set<T>>(NormalisationUtils.normaliseSets(collection))));
    }


    public Level0ArrayOfSetSelectedOperator<T> addAll(final Set<T>... newElements) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<Set<T>>(NormalisationUtils.normaliseSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T> insert(final int position, final Set<T> newElement) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSet(newElement))));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfSetSelectedOperator<T> sort() {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ArrayOfSetSelectedOperator<T> replaceWith(final Set<T>[] replacement) {
        return new Level0ArrayOfSetSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.ARRAY_OF_SET));
    }


    public Set<T>[] get() {
        return endIf().get();
    }



}
