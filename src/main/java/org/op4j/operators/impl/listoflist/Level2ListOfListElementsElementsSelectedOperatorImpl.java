package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2ListOfListElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfListElementsElementsSelectedOperator<T> {


    public Level2ListOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfListElementsElementsOperator<T> endIf() {
        return new Level2ListOfListElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
