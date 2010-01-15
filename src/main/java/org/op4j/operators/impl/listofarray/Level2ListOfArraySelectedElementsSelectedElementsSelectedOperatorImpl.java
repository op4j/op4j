package org.op4j.operators.impl.listofarray;

import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> {


    private final Type<? extends T> type;


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> endIf() {
        return new Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(function));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().execute(converter));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
