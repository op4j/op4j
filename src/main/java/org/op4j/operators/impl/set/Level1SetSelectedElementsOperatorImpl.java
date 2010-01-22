package org.op4j.operators.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1SetSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetSelectedElementsOperator<T,I> {


    public Level1SetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level0SetSelectedOperator<T,I> endFor() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level1SetSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T> get() {
        return endFor().get();
    }


    public Operation<Set<T>,I> createOperation() {
        return endFor().createOperation();
    }



}
