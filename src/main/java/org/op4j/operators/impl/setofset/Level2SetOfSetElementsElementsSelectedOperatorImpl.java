package org.op4j.operators.impl.setofset;

import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsOperator;
import org.op4j.operators.intf.setofset.Level2SetOfSetElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfSetElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfSetElementsElementsSelectedOperator<T> {


    public Level2SetOfSetElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level2SetOfSetElementsElementsOperator<T> endIf() {
        return new Level2SetOfSetElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2SetOfSetElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfSetElementsElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<Set<T>> get() {
        return null;
    }



}