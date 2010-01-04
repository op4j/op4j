package org.op4j.operators.impl.arrayofarray;

import java.util.Collection;
import java.util.Comparator;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.arrayofarray.Level0ArrayOfArraySelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsOperator;
import org.op4j.operators.intf.arrayofarray.Level1ArrayOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.arrayofarray.Level2ArrayOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1ArrayOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ArrayOfArraySelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ArrayOfArraySelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level1ArrayOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ArrayOfArraySelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(eval));
    }


    public Level0ArrayOfArraySelectedOperator<T> endFor() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(function));
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> sort() {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ArrayOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ArrayOfArraySelectedElementsOperatorImpl<T>(this.arrayOf, getTarget().execute(converter));
    }


    public T[][] get() {
        return null;
    }



}
