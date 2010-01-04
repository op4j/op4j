package org.op4j.operators.impl.listofarray;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;


public class Level1ListOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArraySelectedElementsOperator<T> {


    private final Type<? super T> arrayOf;


    public Level1ListOfArraySelectedElementsOperatorImpl(final Type<? super T> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> forEach() {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> distinct() {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeIndexes(final int... indices) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeEquals(final T... values) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNulls() {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return null;
    }


    public Level0ListOfArraySelectedOperator<T> endFor() {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> add(final T... newElements) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> sort() {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return null;
    }


    public Level1ListOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return null;
    }


    public List<T[]> get() {
        return null;
    }



}
