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
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsOperator;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfSetElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfSetElementsSelectedOperator<T> {


    public Level1ListOfSetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> forEach() {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> removeNulls() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.RemoveNulls<T>()));
    }


    public Level1ListOfSetElementsSelectedOperator<T> eval(final IEvaluator<? extends Set<? extends T>,? super Set<T>> eval) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ListOfSetElementsOperator<T> endIf() {
        return new Level1ListOfSetElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfSetElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Add<T>(newElements)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfSetElementsSelectedOperator<T> sort() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level1ListOfSetElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(new SetFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfSetElementsSelectedOperator<T> exec(final IFunction<? extends Set<? extends T>,? super Set<T>> function) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ListOfSetElementsSelectedOperator<T> convert(final IConverter<? extends Set<? extends T>,? super Set<T>> converter) {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }



}
