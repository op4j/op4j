package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArraySelectedElementsSelectedElementsOperator<T> {


    private final Type<? extends T> type;


    public Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indices));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2ListOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> endFor() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public List<T[]> get() {
        return endFor().get();
    }



}
