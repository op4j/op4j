package org.op4j.operators.impl.setofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfArraySelectedOperator<T> {


    private final Type<? super T> arrayOf;


    public Level0SetOfArraySelectedOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1SetOfArraySelectedElementsOperator<T> forEach() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().iterate());
    }


    public Level0SetOfArraySelectedOperator<T> removeIndexes(final int... indices) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveIndexes<T[]>(indices)));
    }


    public Level0SetOfArraySelectedOperator<T> removeEquals(final T[]... values) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveEquals<T[]>(values)));
    }


    public Level0SetOfArraySelectedOperator<T> removeMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveMatching<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNotMatching<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNullOrNotMatching<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNotNullNotMatching<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNotNullMatching<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNullOrMatching<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeIndexesNot(final int... indices) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveIndexesNot<T[]>(indices)));
    }


    public Level0SetOfArraySelectedOperator<T> removeNulls() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.RemoveNulls<T[]>()));
    }


    public Level0SetOfArraySelectedOperator<T> eval(final IEvaluator<? extends Set<T[]>,? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level0SetOfArrayOperator<T> endIf() {
        return new Level0SetOfArrayOperatorImpl<T>(this.arrayOf, getTarget().endSelect());
    }


    public Level0SetOfArraySelectedOperator<T> add(final T[]... newElements) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.Add<T[]>(newElements)));
    }


    public Level0SetOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.AddAll<T[]>(collection)));
    }


    public Level0SetOfArraySelectedOperator<T> insert(final int position, final T[]... newElements) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.Insert<T[]>(position, newElements)));
    }


    public Level0SetOfArraySelectedOperator<T> exec(final IFunction<? extends Set<T[]>,? super Set<T[]>> function) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArraySelectedOperator<T> sort() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(new SetFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0SetOfArraySelectedOperator<T> convert(final IConverter<? extends Set<T[]>,? super Set<T[]>> converter) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
