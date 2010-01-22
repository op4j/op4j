package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfListElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfListElementsSelectedElementsOperator<T,I> {


    public Level2SetOfListElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndex(indices));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNull());
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNull());
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetOfListElementsSelectedOperator<T,I> endFor() {
        return new Level1SetOfListElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }


    public Operation<Set<List<T>>,I> createOperation() {
        return endFor().createOperation();
    }



}
