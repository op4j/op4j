package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> {


    public Level2ListOfListSelectedElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T,I> endIf() {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<List<T>> get() {
        return endIf().get();
    }


    public Operation<List<List<T>>,I> createOperation() {
        return endIf().createOperation();
    }



}
