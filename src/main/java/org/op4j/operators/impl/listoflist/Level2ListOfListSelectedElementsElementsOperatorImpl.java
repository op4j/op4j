package org.op4j.operators.impl.listoflist;

import java.util.List;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listoflist.Level1ListOfListSelectedElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsOperator;
import org.op4j.operators.intf.listoflist.Level2ListOfListSelectedElementsElementsSelectedOperator;
import org.op4j.target.Target;


public class Level2ListOfListSelectedElementsElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level2ListOfListSelectedElementsElementsOperator<T> {


    public Level2ListOfListSelectedElementsElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifIndex(final int... indices) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNull() {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotNull() {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> eval(final IEvaluator<? extends T,? super T> eval) {
        return null;
    }


    public Level1ListOfListSelectedElementsOperator<T> endFor() {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> exec(final IFunction<? extends T,? super T> function) {
        return null;
    }


    public Level2ListOfListSelectedElementsElementsOperator<T> convert(final IConverter<? extends T,? super T> converter) {
        return null;
    }


    public List<List<T>> get() {
        return null;
    }



}
