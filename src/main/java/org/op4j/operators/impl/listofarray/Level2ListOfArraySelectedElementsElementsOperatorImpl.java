package org.op4j.operators.impl.listofarray;

import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfArraySelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArraySelectedElementsElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ListOfArraySelectedElementsElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2ListOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1ListOfArraySelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public List<T[]> get() {
        return null;
    }



}
