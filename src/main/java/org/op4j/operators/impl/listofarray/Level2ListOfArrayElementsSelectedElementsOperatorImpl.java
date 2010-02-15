package org.op4j.operators.impl.listofarray;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfArrayElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfArrayElementsSelectedElementsOperator<T> {


    private final Type<T> type;


    public Level2ListOfArrayElementsSelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2ListOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> endFor() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfArrayElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T[]> get() {
        return endFor().get();
    }



}
