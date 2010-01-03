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


public class Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetSelectedElementsElementsSelectedOperator<T> {


    public Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<Set<T>> get() {
        return null;
    }



}
