package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfListElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfListElementsSelectedElementsSelectedOperator<T> {


    public Level2ListOfListElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> endIf() {
        return new Level2ListOfListElementsSelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
