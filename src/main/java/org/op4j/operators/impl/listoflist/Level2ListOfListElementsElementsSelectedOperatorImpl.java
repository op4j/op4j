package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfListElementsElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfListElementsElementsSelectedOperator<T> {


    public Level2ListOfListElementsElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> execIfNotNull(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2ListOfListElementsElementsOperator<T> endIf() {
        return new Level2ListOfListElementsElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level2ListOfListElementsElementsSelectedOperator<T> replaceWith(final T replacement) {
        return new Level2ListOfListElementsElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<List<T>> get() {
        return endIf().get();
    }



}
