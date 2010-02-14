package org.op4j.operators.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListSelectedElementsSelectedOperator<T> {


    public Level1ListSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperator<T> endIf() {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level1ListSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<T> get() {
        return endIf().get();
    }



}
