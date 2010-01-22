package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfSetElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2ListOfSetElementsSelectedElementsOperator<T,I> {


    public Level2ListOfSetElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2ListOfSetElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListOfSetElementsSelectedOperator<T,I> endFor() {
        return new Level1ListOfSetElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2ListOfSetElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }


    public Operation<List<Set<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
