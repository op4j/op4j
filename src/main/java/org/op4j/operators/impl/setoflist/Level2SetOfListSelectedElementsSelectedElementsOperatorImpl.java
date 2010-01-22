package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsSelectedElementsOperator<T,I> {


    public Level2SetOfListSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T,I> endFor() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
