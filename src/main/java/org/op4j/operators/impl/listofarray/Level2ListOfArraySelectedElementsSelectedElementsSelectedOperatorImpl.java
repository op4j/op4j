package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> {


    private final Type<T> type;


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
