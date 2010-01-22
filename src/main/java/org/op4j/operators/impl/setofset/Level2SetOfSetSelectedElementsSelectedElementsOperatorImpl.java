package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> {


    public Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T,I> endFor() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
