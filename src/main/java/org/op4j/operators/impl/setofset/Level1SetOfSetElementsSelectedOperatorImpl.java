package org.op4j.operators.impl.setofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level1SetOfSetElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfSetElementsSelectedOperator<T> {


    public Level1SetOfSetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T> forEach() {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> removeAllNull() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1SetOfSetElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.SET));
    }


    public Level1SetOfSetElementsOperator<T> endIf() {
        return new Level1SetOfSetElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetOfSetElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfSetElementsSelectedOperator<T> sort() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1SetOfSetElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfSetElementsSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.SET));
    }


    public Set<Set<T>> get() {
        return endIf().get();
    }



}
