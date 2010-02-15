package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public final class Level1ListOfSetElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfSetElementsSelectedOperator<T> {


    public Level1ListOfSetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> forEach() {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.SET));
    }


    public Level1ListOfSetElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllNullOrFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllNotNullAndFalse(final IFunction<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllNotNullAndTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllNullOrTrue(final IFunction<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeAllNull() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfSetElementsOperator<T> endIf() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfSetElementsSelectedOperator<T> execIfNotNullAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.SET));
    }


    public Level1ListOfSetElementsSelectedOperator<T> execAsSet(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElement)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElement)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetElementsSelectedOperator<T> sort() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> map(final IFunction<? extends T,? super T> function) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().map(Structure.SET, function, null));
    }


    public Level1ListOfSetElementsSelectedOperator<T> replaceWith(final Set<T> replacement) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.SET));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }



}
