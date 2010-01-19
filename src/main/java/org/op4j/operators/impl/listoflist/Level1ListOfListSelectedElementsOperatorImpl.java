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
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1ListOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfListSelectedElementsOperator<T> {


    public Level1ListOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> forEach() {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1ListOfListSelectedElementsOperator<T> distinct() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllIndexes(final int... indices) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfListSelectedElementsOperator<T> removeAllNull() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfListSelectedElementsOperator<T> replaceBy(final List<T> replacement) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().replaceBy(replacement));
    }


    public Level1ListOfListSelectedElementsOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.LIST));
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


    public Level1ListOfListSelectedElementsOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfListSelectedElementsOperator<T> sort() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1ListOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfListSelectedElementsOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.LIST));
    }


    public List<List<T>> get() {
        return endFor().get();
    }



}
