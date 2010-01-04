package org.op4j.operators.impl.list;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level1ListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListSelectedElementsOperator<T> {


    public Level1ListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1ListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level1ListSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level0ListSelectedOperator<T> endFor() {
        return null;
    }


    public Level1ListSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level1ListSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<T> get() {
        return null;
    }



}
