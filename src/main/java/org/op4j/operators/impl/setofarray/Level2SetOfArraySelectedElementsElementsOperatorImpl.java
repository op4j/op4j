package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2SetOfArraySelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsElementsOperator<T> {


    private final Type<T> type;


    public Level2SetOfArraySelectedElementsElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetOfArraySelectedElementsOperator<T> endFor() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfArraySelectedElementsElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T[]> get() {
        return endFor().get();
    }



}
