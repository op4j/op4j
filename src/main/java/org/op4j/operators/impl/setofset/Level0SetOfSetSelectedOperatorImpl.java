package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.setofset.Level0SetOfSetSelectedOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0SetOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfSetSelectedOperator<T> {


    public Level0SetOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfSetSelectedElementsOperator<T> forEach() {
        return new Level1SetOfSetSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfSetSelectedOperator<T> insertAll(final int position, final Set<T>... newElements) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSets(newElements))));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Set<T>>(indexes)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllEqual(final Set<T>... values) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Set<T>>(indexes)));
    }


    public Level0SetOfSetSelectedOperator<T> removeAllNull() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<Set<T>>()));
    }


    public Level0SetOfSetOperator<T> endIf() {
        return new Level0SetOfSetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetOfSetSelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function) {
        return forEach().map(function).endFor();
    }


    public Level0SetOfSetSelectedOperator<T> convertAsSetOfSet(final IConverter<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> converter) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.SET_OF_SET));
    }


    public Level0SetOfSetSelectedOperator<T> evalAsSetOfSet(final IEvaluator<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> eval) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.SET_OF_SET));
    }


    public Level0SetOfSetSelectedOperator<T> execAsSetOfSet(final IFunction<? extends Set<? extends Set<? extends T>>,? super Set<Set<T>>> function) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.SET_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T> add(final Set<T> newElement) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalisationUtils.normaliseSet(newElement))));
    }


    public Level0SetOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<Set<T>>(NormalisationUtils.normaliseSets(collection))));
    }


    public Level0SetOfSetSelectedOperator<T> addAll(final Set<T>... newElements) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<Set<T>>(NormalisationUtils.normaliseSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T> insert(final int position, final Set<T> newElement) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSet(newElement))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfSetSelectedOperator<T> sort() {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0SetOfSetSelectedOperator<T> replaceWith(final Set<Set<T>> replacement) {
        return new Level0SetOfSetSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET_OF_SET));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
