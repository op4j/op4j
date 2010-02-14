package org.op4j.operators.impl.setofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetSelectedElementsSelectedElementsOperator<T> {


    public Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1SetOfSetSelectedElementsSelectedOperator<T> endFor() {
        return new Level1SetOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2SetOfSetSelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<Set<T>> get() {
        return endFor().get();
    }



}
