package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArraySelectedElementsElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> endIf() {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
