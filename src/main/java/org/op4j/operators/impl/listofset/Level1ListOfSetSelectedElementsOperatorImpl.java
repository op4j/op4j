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
import org.op4j.target.Target.Structure;


public class Level1ListOfSetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfSetSelectedElementsOperator<T> {


    public Level1ListOfSetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> forEach() {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> eval(final IEvaluator<? extends Set<T>,? super Set<T>> eval) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ListOfSetSelectedOperator<T> endFor() {
        return new Level0ListOfSetSelectedOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level1ListOfSetSelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfSetSelectedElementsOperator<T> exec(final IFunction<? extends Set<T>,? super Set<T>> function) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetSelectedElementsOperator<T> sort() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfSetSelectedElementsOperator<T> convert(final IConverter<? extends Set<T>,? super Set<T>> converter) {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<Set<T>> get() {
        return null;
    }



}
