package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.target.Target;


public class Level0ArrayOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ArrayOfArraySelectedOperator<T> {


    public Level0ArrayOfArraySelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> forEach(final Type<T[]> elementType) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level0ArrayOfArraySelectedOperator<T> distinct() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T[]>()));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T[]>(indices)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeEquals(final T[]... values) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T[]>(values)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T[]>(indices)));
    }


    public Level0ArrayOfArraySelectedOperator<T> removeNulls() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T[]>()));
    }


    public Level0ArrayOfArraySelectedOperator<T> eval(final IEvaluator<? extends T[][],? super T[][]> eval) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ArrayOfArrayOperator<T> endIf() {
        return new Level0ArrayOfArrayOperatorImpl<T>(getTarget().endSelect());
    }


    public Level0ArrayOfArraySelectedOperator<T> add(final T[]... newElements) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T[]>(newElements)));
    }


    public Level0ArrayOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T[]>(collection)));
    }


    public Level0ArrayOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T[]>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level0ArrayOfArraySelectedOperator<T> sort() {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level0ArrayOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0ArrayOfArraySelectedOperator<T> exec(final IFunction<? extends T[][],? super T[][]> function) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level0ArrayOfArraySelectedOperator<T> convert(final IConverter<? extends T[][],? super T[][]> converter) {
        return new Level0ArrayOfArraySelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public T[][] get() {
        return endIf().get();
    }



}
