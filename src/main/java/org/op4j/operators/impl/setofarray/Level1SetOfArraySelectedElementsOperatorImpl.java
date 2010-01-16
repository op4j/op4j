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
import org.op4j.target.Target.Structure;


public class Level1SetOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1SetOfArraySelectedElementsOperator<T> {


    public Level1SetOfArraySelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1SetOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2SetOfArraySelectedElementsElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2SetOfArraySelectedElementsElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1SetOfArraySelectedElementsOperator<T> distinct() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> removeNulls() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0SetOfArraySelectedOperator<T> endFor() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(getTarget().endIterate(Structure.SET, null));
    }


    public Level1SetOfArraySelectedElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1SetOfArraySelectedElementsOperator<T> sort() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1SetOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1SetOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1SetOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public Set<T[]> get() {
        return endFor().get();
    }



}
