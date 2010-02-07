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
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level1ListOfArraySelectedElementsSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArraySelectedElementsSelectedOperator<T> {


    public Level1ListOfArraySelectedElementsSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfArraySelectedElementsSelectedElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ListOfArraySelectedElementsSelectedElementsOperatorImpl<T>(elementType, getTarget().iterate(Structure.ARRAY));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> distinct() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllIndexes(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexes<T>(indices)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllEqual<T>(values)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllIndexesNot(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllIndexesNot<T>(indices)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> removeAllNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveAllNull<T>()));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.ARRAY));
    }


    public Level1ListOfArraySelectedElementsOperator<T> endIf() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsSelectedOperator<T> add(final T newElement) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElement)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> addAll(final T... newElements) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElement)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.ARRAY));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsSelectedOperator<T> sort() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> replaceWith(final T[] replacement) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.ARRAY));
    }


    public List<T[]> get() {
        return endIf().get();
    }



}
