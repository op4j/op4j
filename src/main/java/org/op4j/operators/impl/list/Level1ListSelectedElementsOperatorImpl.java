package org.op4j.operators.impl.list;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1ListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListSelectedElementsOperator<T> {


    public Level1ListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level0ListSelectedOperator<T> endFor() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level1ListSelectedElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1ListSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<T> get() {
        return endFor().get();
    }



}
