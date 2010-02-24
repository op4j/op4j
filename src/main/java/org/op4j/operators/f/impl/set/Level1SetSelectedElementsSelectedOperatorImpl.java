package org.op4j.operators.f.impl.set;

import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.operators.f.impl.AbstractOperatorImpl;
import org.op4j.operators.op.intf.set.Level1SetSelectedElementsOperator;
import org.op4j.operators.op.intf.set.Level1SetSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level1SetSelectedElementsSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level1SetSelectedElementsSelectedOperator<T,I> {


    public Level1SetSelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetSelectedElementsOperator<T,I> endIf() {
        return new Level1SetSelectedElementsOperatorImpl<T,I>(getTarget().endSelect());
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level1SetSelectedElementsSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level1SetSelectedElementsSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Set<T> get() {
        return endIf().get();
    }



}
