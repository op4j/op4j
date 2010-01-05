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
import org.op4j.target.Target.Structure;


public class Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsSelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2SetOfArraySelectedElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> endFor() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().endIterate(Structure.ARRAY,  this.arrayOf.getRawClass()));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}
