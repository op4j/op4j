package org.op4j.operators.impl.arrayofset;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofset.Level1ArrayOfSetElementsSelectedOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayofset.Level2ArrayOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfSetElementsSelectedElementsOperator<T> {


    public Level2ArrayOfSetElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ArrayOfSetElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1ArrayOfSetElementsSelectedOperator<T> endFor() {
        return new Level1ArrayOfSetElementsSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfSetElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<T>[] get() {
        return endFor().get();
    }



}
