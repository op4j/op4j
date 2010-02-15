package org.op4j.operators.impl.arrayofarray;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfArraySelectedElementsElementsOperator<T> {


    private final Type<T> type;


    public Level2ArrayOfArraySelectedElementsElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2ArrayOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ArrayOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> endFor() {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ArrayOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public T[][] get() {
        return endFor().get();
    }



}
