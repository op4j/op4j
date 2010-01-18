package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetSelectedElementsSelectedElementsOperator<T> {


    public Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ListOfSetSelectedElementsSelectedElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListOfSetSelectedElementsSelectedOperator<T> endFor() {
        return new Level1ListOfSetSelectedElementsSelectedOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetSelectedElementsSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }



}
