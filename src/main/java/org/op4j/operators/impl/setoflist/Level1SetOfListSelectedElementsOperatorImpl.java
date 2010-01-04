package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListSelectedElementsOperator<T> {


    public Level1SetOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> eval(final IEvaluator<? extends List<T>,? super List<T>> eval) {
        return null;
    }


    public Level0SetOfListSelectedOperator<T> endFor() {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> exec(final IFunction<? extends List<T>,? super List<T>> function) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> sort() {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> convert(final IConverter<? extends List<T>,? super List<T>> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}
