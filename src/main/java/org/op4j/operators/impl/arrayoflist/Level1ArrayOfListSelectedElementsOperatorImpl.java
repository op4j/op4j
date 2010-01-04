package org.op4j.operators.impl.arrayoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level0ArrayOfListSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfListSelectedElementsOperator<T> {


    public Level1ArrayOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return null;
    }


    public Level0ArrayOfListSelectedOperator<T> endFor() {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> sort() {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return null;
    }


    public List<T>[] get() {
        return null;
    }



}
