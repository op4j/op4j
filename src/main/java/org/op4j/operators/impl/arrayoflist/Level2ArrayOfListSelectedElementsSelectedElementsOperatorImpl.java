package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsSelectedElementsOperator<T,I> {


    public Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ArrayOfListSelectedElementsSelectedOperator<T,I> endFor() {
        return new Level1ArrayOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfListSelectedElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<T>[] get() {
        return endFor().get();
    }


    public Operation<List<T>[],I> createOperation() {
        return endFor().createOperation();
    }



}
