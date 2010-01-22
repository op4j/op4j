package org.op4j.operators.impl.arrayoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfListSelectedElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsElementsOperator<T,I> {


    public Level2ArrayOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ArrayOfListSelectedElementsOperator<T,I> endFor() {
        return new Level1ArrayOfListSelectedElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<T>[] get() {
        return endFor().get();
    }


    public Operation<List<T>[],I> createOperation() {
        return endFor().createOperation();
    }



}
