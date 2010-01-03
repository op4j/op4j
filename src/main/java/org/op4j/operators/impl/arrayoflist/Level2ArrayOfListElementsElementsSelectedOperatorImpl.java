package org.op4j.operators.impl.arrayoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfListElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListElementsElementsSelectedOperator<T> {


    public Level2ArrayOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfListElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<T>[] get() {
        return null;
    }



}
