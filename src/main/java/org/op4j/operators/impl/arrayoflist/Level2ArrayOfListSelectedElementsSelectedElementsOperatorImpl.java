package org.op4j.operators.impl.arrayoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> {


    public Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T>[] get() {
        return null;
    }



}
