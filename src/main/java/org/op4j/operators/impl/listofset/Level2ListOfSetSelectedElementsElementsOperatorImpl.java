package org.op4j.operators.impl.listofset;

import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofset.Level1ListOfSetSelectedElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsOperator;
import org.op4j.operators.intf.listofset.Level2ListOfSetSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level2ListOfSetSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfSetSelectedElementsElementsOperator<T> {


    public Level2ListOfSetSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullAndFalse(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifNull() {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifNullOrTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level2ListOfSetSelectedElementsElementsSelectedOperator<T> ifNotNullAndTrue(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level1ListOfSetSelectedElementsOperator<T> endFor() {
        return new Level1ListOfSetSelectedElementsOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().execute(function, Normalization.NONE));
    }


    public Level2ListOfSetSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return new Level2ListOfSetSelectedElementsElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Set<T>> get() {
        return endFor().get();
    }



}
