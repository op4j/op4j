package org.op4j.operators.impl.list;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level0ListSelectedOperator;
import org.op4j.operators.intf.list.Level1ListSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;


public class Level0ListSelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0ListSelectedOperator<T> {


    public Level0ListSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListSelectedElementsOperator<T> forEach() {
        return new Level1ListSelectedElementsOperatorImpl<T>(getTarget().iterate(Structure.LIST));
    }


    public Level0ListSelectedOperator<T> distinct() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level0ListSelectedOperator<T> insertAll(final int position, final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level0ListSelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexes<T>(indexes)));
    }


    public Level0ListSelectedOperator<T> removeAllEqual(final T... values) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllEqual<T>(values)));
    }


    public Level0ListSelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndFalse<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNotNullAndTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNullOrTrue<T>(eval)));
    }


    public Level0ListSelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllIndexesNot<T>(indexes)));
    }


    public Level0ListSelectedOperator<T> removeAllNull() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveAllNull<T>()));
    }


    public Level0ListSelectedOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(eval, Normalisation.LIST));
    }


    public Level0ListOperator<T> endIf() {
        return new Level0ListOperatorImpl<T>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> add(final T newElement) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElement)));
    }


    public Level0ListSelectedOperator<T> addAll(final T... newElements) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level0ListSelectedOperator<T> addAll(final Collection<T> collection) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> insert(final int position, final T newElement) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElement)));
    }


    public Level0ListSelectedOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(function, Normalisation.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level0ListSelectedOperator<T> sort() {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level0ListSelectedOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level0ListSelectedOperator<T> replaceWith(final List<T> replacement) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().replaceWith(replacement));
    }


    public Level0ListSelectedOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level0ListSelectedOperatorImpl<T>(getTarget().execute(converter, Normalisation.LIST));
    }


    public List<T> get() {
        return endIf().get();
    }



}
