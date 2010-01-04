package org.op4j.operators.impl.setofarray;

import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfArraySelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfArraySelectedElementsElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level2SetOfArraySelectedElementsElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2SetOfArraySelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArraySelectedElementsElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<T[]> get() {
        return null;
    }



}
