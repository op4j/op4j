package org.op4j.operators.impl.setofarray;

import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public class Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsSelectedElementsOperator<T> {


    private final Type<T> type;


    public Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indexes) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndex(indexes));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNull());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indexes) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNull());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> endFor() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.type, getTarget().endIterate(this.type.getRawClass()));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> replaceWith(final T replacement) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().replaceWith(replacement));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public Set<T[]> get() {
        return endFor().get();
    }



}
