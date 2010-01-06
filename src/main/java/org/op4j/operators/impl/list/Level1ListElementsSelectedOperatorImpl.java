package org.op4j.operators.impl.list;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level1ListElementsOperator;
import org.op4j.operators.intf.list.Level1ListElementsSelectedOperator;
import org.op4j.target.Target;


public class Level1ListElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListElementsSelectedOperator<T> {


    public Level1ListElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ListElementsOperator<T> endIf() {
        return new Level1ListElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ListElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level1ListElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T> get() {
        return endIf().get();
    }



}
