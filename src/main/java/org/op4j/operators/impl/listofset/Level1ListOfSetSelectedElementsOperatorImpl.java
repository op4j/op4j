package org.op4j.operators.impl.listofset;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level0ListOfSetSelectedOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ListOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfSetSelectedElementsOperator<T> {


    public Level1ListOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> forEach() {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllIndexes(final int... indices) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeAllNull() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfSetSelectedElementsOperator<T> replaceBy(final Set<T> replacement) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level1ListOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.SET));
    }


    public Level0ListOfSetSelectedOperator<T> endFor() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level1ListOfSetSelectedElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalization.SET));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetSelectedElementsOperator<T> sort() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.SET));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }



}
