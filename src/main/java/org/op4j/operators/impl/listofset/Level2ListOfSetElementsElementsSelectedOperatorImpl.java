package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfSetElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetElementsElementsSelectedOperator<T> {


    public Level2ListOfSetElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfSetElementsElementsOperator<T> endIf() {
        return new Level2ListOfSetElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2ListOfSetElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.NONE));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }



}
