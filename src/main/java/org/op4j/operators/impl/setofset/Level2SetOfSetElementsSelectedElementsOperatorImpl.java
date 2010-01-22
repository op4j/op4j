package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfSetElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfSetElementsSelectedElementsOperator<T,I> {


    public Level2SetOfSetElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetOfSetElementsSelectedOperator<T,I> endFor() {
        return new Level1SetOfSetElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }


    public Operation<Set<Set<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
