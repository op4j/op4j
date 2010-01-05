package org.op4j.operators.impl.setofarray;

import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArrayElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2SetOfArrayElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArrayElementsSelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2SetOfArrayElementsSelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2SetOfArrayElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1SetOfArrayElementsSelectedOperator<T> endFor() {
        return new Level1SetOfArrayElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY,  this.arrayOf.getRawClass()));
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2SetOfArrayElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArrayElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}