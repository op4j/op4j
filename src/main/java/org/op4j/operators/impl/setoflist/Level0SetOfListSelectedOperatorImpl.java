package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListOperator;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public final class Level0SetOfListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfListSelectedOperator<T> {


    public Level0SetOfListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsOperator<T> forEach() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfListSelectedOperator<T> insertAll(final int position, final List<T>... newElements) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, NormalisationUtils.normaliseLists(newElements))));
    }


    public Level0SetOfListSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<List<T>>(indexes)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllEqual(final List<T>... values) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<List<T>>(values)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super List<T>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<List<T>>(eval)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<List<T>>(indexes)));
    }


    public Level0SetOfListSelectedOperator<T> removeAllNull() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<List<T>>()));
    }


    public Level0SetOfListOperator<T> endIf() {
        return new Level0SetOfListOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0SetOfListSelectedOperator<T> mapMap(final IFunction<? extends T,? super T> function) {
        return forEach().map(function).endFor();
    }


    public Level0SetOfListSelectedOperator<T> convertAsSetOfList(final IConverter<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> converter) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.SET_OF_LIST));
    }


    public Level0SetOfListSelectedOperator<T> evalAsSetOfList(final IEvaluator<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> eval) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.SET_OF_LIST));
    }


    public Level0SetOfListSelectedOperator<T> execAsSetOfList(final IFunction<? extends Set<? extends List<? extends T>>,? super Set<List<T>>> function) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.SET_OF_LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T> add(final List<T> newElement) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<List<T>>(NormalisationUtils.normaliseList(newElement))));
    }


    public Level0SetOfListSelectedOperator<T> addAll(final Collection<List<T>> collection) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<List<T>>(NormalisationUtils.normaliseLists(collection))));
    }


    public Level0SetOfListSelectedOperator<T> addAll(final List<T>... newElements) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<List<T>>(NormalisationUtils.normaliseLists(newElements))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T> insert(final int position, final List<T> newElement) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<List<T>>(position, NormalisationUtils.normaliseList(newElement))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfListSelectedOperator<T> sort() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfListSelectedOperator<T> sort(final Comparator<? super List<T>> comparator) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<List<T>>(comparator)));
    }


    public Level0SetOfListSelectedOperator<T> replaceWith(final Set<List<T>> replacement) {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET_OF_LIST));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }



}
