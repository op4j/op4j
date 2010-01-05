package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2ArrayOfArraySelectedElementsElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> endFor() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY,  this.arrayOf.getRawClass()));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[][] get() {
        return null;
    }



}
