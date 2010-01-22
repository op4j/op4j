package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T,I> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsSelectedElementsOperator<T,I> {


    private final Type<? extends T> type;


    public Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl(final Type<? extends T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifIndex(final int... indices) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndex(indices));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifNull() {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNull());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifIndexNot(final int... indices) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNull() {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNull());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T,I>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T,I> endFor() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T,I>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T,I> replaceWith(final T replacement) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T,I>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Set<T[]> get() {
        return endFor().get();
    }


    public Operation<Set<T[]>,I> createOperation() {
        return endFor().createOperation();
    }



}
