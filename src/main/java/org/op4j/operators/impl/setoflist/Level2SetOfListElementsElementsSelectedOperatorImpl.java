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
        return null;
    }


    public Level2SetOfListElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfListElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}
