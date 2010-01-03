package org.op4j.operators.impl.set;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.set.Level1SetElementsOperator;
import org.op4j.operators.intf.set.Level1SetElementsSelectedOperator;
import org.op4j.target.Target;


public class Level1SetElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetElementsSelectedOperator<T> {


    public Level1SetElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1SetElementsOperator<T> endIf() {
        return null;
    }


    public Level1SetElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level1SetElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<T> get() {
        return null;
    }



}
