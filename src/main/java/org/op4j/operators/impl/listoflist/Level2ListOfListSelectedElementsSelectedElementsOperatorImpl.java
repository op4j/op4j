package org.op4j.operators.impl.listoflist;

import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfListSelectedElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfListSelectedElementsSelectedElementsOperator<T,I> {


    public Level2ListOfListSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ListOfListSelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfListSelectedElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListOfListSelectedElementsSelectedOperator<T,I> endFor() {
        return new Level1ListOfListSelectedElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2ListOfListSelectedElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfListSelectedElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfListSelectedElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfListSelectedElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<List<T>> get() {
        return endFor().get();
    }


    public Operation<List<List<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
