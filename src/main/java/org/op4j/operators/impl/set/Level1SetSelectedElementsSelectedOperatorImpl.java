package org.op4j.operators.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetSelectedElementsSelectedOperator<T> {


    public Level1SetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperator<T> endIf() {
        return new Level1SetSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
