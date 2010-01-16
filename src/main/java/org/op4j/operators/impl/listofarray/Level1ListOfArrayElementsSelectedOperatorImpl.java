package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArrayElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArrayElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfArrayElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArrayElementsSelectedOperator<T> {


    public Level1ListOfArrayElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfArrayElementsSelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ListOfArrayElementsSelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> distinct() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> removeNulls() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1ListOfArrayElementsOperator<T> endIf() {
        return new Level1ListOfArrayElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1ListOfArrayElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArrayElementsSelectedOperator<T> sort() {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ListOfArrayElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArrayElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
