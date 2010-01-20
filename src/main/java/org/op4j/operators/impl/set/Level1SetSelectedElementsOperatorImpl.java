package org.op4j.operators.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1SetSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetSelectedElementsOperator<T> {


    public Level1SetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1SetSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level0SetSelectedOperator<T> endFor() {
        return new Level0SetSelectedOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalization.NONE));
    }


    public Level1SetSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level1SetSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T> get() {
        return endFor().get();
    }



}
