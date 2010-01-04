package org.op4j.operators.impl.arrayoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> {


    public Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> endIf() {
        return new Level2ArrayOfListSelectedElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T>[] get() {
        return null;
    }



}
