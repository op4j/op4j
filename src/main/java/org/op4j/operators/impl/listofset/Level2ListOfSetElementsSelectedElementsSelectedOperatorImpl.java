package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetElementsSelectedElementsSelectedOperator<T> {


    public Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T> endIf() {
        return null;
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<Set<T>> get() {
        return null;
    }



}
