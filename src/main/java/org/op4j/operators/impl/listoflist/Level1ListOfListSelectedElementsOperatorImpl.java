package org.op4j.operators.impl.listoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level0ListOfListSelectedOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level1ListOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListSelectedElementsOperator<T> {


    public Level1ListOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> forEach() {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfListSelectedElementsOperator<T> distinct() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeNulls() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level1ListOfListSelectedElementsOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ListOfListSelectedOperator<T> endFor() {
        return new Level0ListOfListSelectedOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level1ListOfListSelectedElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1ListOfListSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfListSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListSelectedElementsOperator<T> sort() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListSelectedElementsOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ListOfListSelectedElementsOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<List<T>> get() {
        return endFor().get();
    }



}
