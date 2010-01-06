package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfListElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListElementsElementsSelectedOperator<T> {


    public Level2SetOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2SetOfListElementsElementsOperator<T> endIf() {
        return new Level2SetOfListElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<List<T>> get() {
        return endIf().get();
    }



}
