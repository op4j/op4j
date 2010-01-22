package org.op4j.operators.impl.generic;

import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.generic.Level0GenericMultiOperator;
import org.op4j.operators.intf.generic.Level0GenericMultiSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;


public class Level0GenericMultiSelectedOperatorImpl<T,I> extends AbstractOperatorImpl implements Level0GenericMultiSelectedOperator<T,I> {


    public Level0GenericMultiSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level0GenericMultiSelectedOperator<T,I> eval(final IEvaluator<? extends T,? super T> eval) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().iterate().execute(eval, Normalization.NONE).endIterate(org.op4j.target.Target.Structure.LIST, null));
    }


    public Level0GenericMultiOperator<T,I> endIf() {
        return new Level0GenericMultiOperatorImpl<T,I>(getTarget().endSelect());
    }


    public T[] getAsArray(final Type<T> type) {
        return endIf().buildArray(type).get();
    }


    public List<T> getAsList() {
        return endIf().buildList().get();
    }


    public Level0GenericMultiSelectedOperator<T,I> exec(final IFunction<? extends T,? super T> function) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().iterate().execute(function, Normalization.NONE).endIterate(org.op4j.target.Target.Structure.LIST, null));
    }


    public Level0GenericMultiSelectedOperator<T,I> replaceWith(final T replacement) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().replaceWith(replacement));
    }


    public Level0GenericMultiSelectedOperator<T,I> convert(final IConverter<? extends T,? super T> converter) {
        return new Level0GenericMultiSelectedOperatorImpl<T,I>(getTarget().iterate().execute(converter, Normalization.NONE).endIterate(org.op4j.target.Target.Structure.LIST, null));
    }


    public Operation<T[], I> createArrayOperation(Type<T> type) {
        return endIf().createArrayOperation(type);
    }


    public Operation<List<T>, I> createListOperation() {
        return endIf().createListOperation();
    }


    public int size() {
        return endIf().size();
    }



}
