package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level0ListOfSetOperator;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0ListOfSetSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListOfSetSelectedOperator<T> {


    public Level0ListOfSetSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsOperator<T> forEach() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListOfSetSelectedOperator<T> distinct() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<Set<T>>()));
    }


    public Level0ListOfSetSelectedOperator<T> insertAll(final int position, final Set<T>... newElements) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSets(newElements))));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<Set<T>>(indexes)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllEqual(final Set<T>... values) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<Set<T>>(values)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super Set<T>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<Set<T>>(eval)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<Set<T>>(indexes)));
    }


    public Level0ListOfSetSelectedOperator<T> removeAllNull() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<Set<T>>()));
    }


    public Level0ListOfSetOperator<T> endIf() {
        return new Level0ListOfSetOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ListOfSetSelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function) {
        return forEach().map(function).endFor();
    }


    public Level0ListOfSetSelectedOperator<T> convertAsListOfSet(final IConverter<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> converter) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST_OF_SET));
    }


    public Level0ListOfSetSelectedOperator<T> evalAsListOfSet(final IEvaluator<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> eval) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST_OF_SET));
    }


    public Level0ListOfSetSelectedOperator<T> execAsListOfSet(final IFunction<? extends List<? extends Set<? extends T>>,? super List<Set<T>>> function) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST_OF_SET));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T> add(final Set<T> newElement) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalisationUtils.normaliseSet(newElement))));
    }


    public Level0ListOfSetSelectedOperator<T> addAll(final Collection<Set<T>> collection) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<Set<T>>(NormalisationUtils.normaliseSets(collection))));
    }


    public Level0ListOfSetSelectedOperator<T> addAll(final Set<T>... newElements) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<Set<T>>(NormalisationUtils.normaliseSets(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T> insert(final int position, final Set<T> newElement) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<Set<T>>(position, NormalisationUtils.normaliseSet(newElement))));
    }


    @SuppressWarnings("unchecked")
    public Level0ListOfSetSelectedOperator<T> sort() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListOfSetSelectedOperator<T> sort(final Comparator<? super Set<T>> comparator) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<Set<T>>(comparator)));
    }


    public Level0ListOfSetSelectedOperator<T> replaceWith(final List<Set<T>> replacement) {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.LIST_OF_SET));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }



}
