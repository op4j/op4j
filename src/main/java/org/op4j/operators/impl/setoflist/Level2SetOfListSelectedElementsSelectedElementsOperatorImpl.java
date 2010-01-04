package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsSelectedElementsOperator<T> {


    public Level2SetOfListSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfListSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level2SetOfListSelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2SetOfListSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<List<T>> get() {
        return null;
    }



}
