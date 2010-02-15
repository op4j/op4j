package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfListSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfListSelectedElementsElementsOperator<T> {


    public Level2ListOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indexes));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indexes));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IFunction<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1ListOfListSelectedElementsOperator<T> endFor() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T>(getTarget().endIterate(null));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<List<T>> get() {
        return endFor().get();
    }



}
