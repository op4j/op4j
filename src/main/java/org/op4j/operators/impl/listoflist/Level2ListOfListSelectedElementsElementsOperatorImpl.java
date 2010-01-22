package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfListSelectedElementsElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfListSelectedElementsElementsOperator<T,I> {


    public Level2ListOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifNull() {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListOfListSelectedElementsOperator<T,I> endFor() {
        return new Level1ListOfListSelectedElementsOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfListSelectedElementsElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfListSelectedElementsElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


    public Operation<List<List<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
