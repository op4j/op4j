package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsSelectedOperator<T> {


    public Level1SetOfArraySelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2SetOfArraySelectedElementsSelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2SetOfArraySelectedElementsSelectedElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> distinct() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeEquals(final T... values) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> removeNulls() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level1SetOfArraySelectedElementsOperator<T> endIf() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> add(final T... newElements) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
