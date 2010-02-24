package org.op4j.operators.f.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.set.Level0SetSelectedOperator;
import org.op4j.operators.op.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.op.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetSelectedElementsOperator<T,I> {


    public Level1SetSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifIndex(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indexes));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indexes) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indexes));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0SetSelectedOperator<T,I> endFor() {
        return new Level0SetSelectedOperatorImpl<T,I>(getTarget().endIterate(null));
    }


    public Level1SetSelectedElementsOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endFor().get();
    }



}
