package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsElementsSelectedOperator<T> {


    public Level2SetOfListSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> endIf() {
        return null;
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}
