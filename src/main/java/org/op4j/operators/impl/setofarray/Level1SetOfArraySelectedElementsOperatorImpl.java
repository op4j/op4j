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
import org.op4j.operators.intf.setofarray.Level0SetOfArraySelectedOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsOperator;
import org.op4j.operators.intf.setofarray.Level1SetOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.setofarray.Level2SetOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1SetOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1SetOfArraySelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level0SetOfArraySelectedOperator<T> endFor() {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1SetOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsOperator<T> sort() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return null;
    }



}
