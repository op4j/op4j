package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfListSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsElementsOperator<T> {


    public Level2ArrayOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ArrayOfListSelectedElementsOperator<T> endFor() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<T>[] get() {
        return endFor().get();
    }



}
