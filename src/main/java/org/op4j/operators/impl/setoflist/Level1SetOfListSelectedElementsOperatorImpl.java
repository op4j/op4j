package org.op4j.operators.impl.setoflist;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setoflist.Level0SetOfListSelectedOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsOperator;
import org.op4j.operators.intf.setoflist.Level1SetOfListSelectedElementsSelectedOperator;
import org.op4j.operators.intf.setoflist.Level2SetOfListSelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level1SetOfListSelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfListSelectedElementsOperator<T> {


    public Level1SetOfListSelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfListSelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfListSelectedElementsElementsOperator<T> forEach() {
        return new Level2SetOfListSelectedElementsElementsOperatorImpl<T>(getTarget().iterate());
    }


    public Level1SetOfListSelectedElementsOperator<T> distinct() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Distinct<T>()));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfListSelectedElementsOperator<T> removeNulls() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.RemoveNulls<T>()));
    }


    public Level1SetOfListSelectedElementsOperator<T> eval(final IEvaluator<? extends List<? extends T>,? super List<T>> eval) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(eval, Normalization.LIST));
    }


    public Level0SetOfListSelectedOperator<T> endFor() {
        return new Level0SetOfListSelectedOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetOfListSelectedElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Add<T>(newElements)));
    }


    public Level1SetOfListSelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfListSelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public Level1SetOfListSelectedElementsOperator<T> exec(final IFunction<? extends List<? extends T>,? super List<T>> function) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(function, Normalization.LIST));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfListSelectedElementsOperator<T> sort() {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.Sort()));
    }


    public Level1SetOfListSelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(new ListFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfListSelectedElementsOperator<T> convert(final IConverter<? extends List<? extends T>,? super List<T>> converter) {
        return new Level1SetOfListSelectedElementsOperatorImpl<T>(getTarget().execute(converter, Normalization.LIST));
    }


    public Set<List<T>> get() {
        return endFor().get();
    }



}
