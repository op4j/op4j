package org.op4j.operators.impl.arrayoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayoflist.Level1ArrayOfListSelectedElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.arrayoflist.Level2ArrayOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ArrayOfListSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ArrayOfListSelectedElementsElementsOperator<T> {


    public Level2ArrayOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ArrayOfListSelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ArrayOfListSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<T>[] get() {
        return null;
    }



}
