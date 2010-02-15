package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1SetOfSetElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetElementsSelectedOperator<T> {


    public Level1SetOfSetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1SetOfSetElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNull() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfSetElementsOperator<T> endIf() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetOfSetElementsSelectedOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level1SetOfSetElementsSelectedOperator<T> execAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsSelectedOperator<T> add(final T newElement) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsSelectedOperator<T> sort() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().map(Structure.SET, function, null));
    }


    public Level1SetOfSetElementsSelectedOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
