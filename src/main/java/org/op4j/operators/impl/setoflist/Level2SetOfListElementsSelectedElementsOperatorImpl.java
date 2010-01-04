package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfListElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListElementsSelectedElementsOperator<T> {


    public Level2SetOfListElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfListElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1SetOfListElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2SetOfListElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2SetOfListElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<List<T>> get() {
        return null;
    }



}
