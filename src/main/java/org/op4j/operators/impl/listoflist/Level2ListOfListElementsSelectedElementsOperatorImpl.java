package org.op4j.operators.impl.listoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListElementsSelectedOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListElementsSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfListElementsSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfListElementsSelectedElementsOperator<T> {


    public Level2ListOfListElementsSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ListOfListElementsSelectedOperator<T> endFor() {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfListElementsSelectedElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<List<T>> get() {
        return null;
    }



}
