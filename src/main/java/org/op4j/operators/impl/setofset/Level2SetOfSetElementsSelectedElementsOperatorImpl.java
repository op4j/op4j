package org.op4j.operators.impl.setofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level1SetOfSetElementsSelectedOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfSetElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetElementsSelectedElementsOperator<T> {


    public Level2SetOfSetElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfSetElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1SetOfSetElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2SetOfSetElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<Set<T>> get() {
        return null;
    }



}
