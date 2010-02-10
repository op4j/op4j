package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ListOfSetElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetElementsSelectedElementsOperator<T> {


    public Level2ListOfSetElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1ListOfSetElementsSelectedOperator<T> endFor() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }



}
