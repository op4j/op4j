package org.op4j.operators.impl.setoflist;

import java.util.List;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2SetOfListSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2SetOfListSelectedElementsElementsOperator<T> {


    public Level2SetOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2SetOfListSelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfListSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1SetOfListSelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public Set<List<T>> get() {
        return null;
    }



}
