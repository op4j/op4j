package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetSelectedElementsElementsSelectedOperator<T> {


    public Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> endIf() {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Set<T>> get() {
        return endIf().get();
    }



}
