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
import org.op4j.operators.intf.listofarray.Level0ListOfArraySelectedOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsOperator;
import org.op4j.operators.intf.listofarray.Level1ListOfArraySelectedElementsSelectedOperator;
import org.op4j.operators.intf.listofarray.Level2ListOfArraySelectedElementsElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level1ListOfArraySelectedElementsOperatorImpl<T> extends AbstractOperatorImpl implements Level1ListOfArraySelectedElementsOperator<T> {


    public Level1ListOfArraySelectedElementsOperatorImpl(final Target target) {
        super(target);
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndex(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndex(indices));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullNotMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNullOrMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNullOrMatching(eval));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifIndexNot(final int... indices) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectIndexNot(indices));
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNull() {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNull());
    }


    public Level1ListOfArraySelectedElementsSelectedOperator<T> ifNotNullMatching(final IEvaluator<Boolean, ? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsSelectedOperatorImpl<T>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2ListOfArraySelectedElementsElementsOperator<T> forEach(final Type<T> elementType) {
        return new Level2ListOfArraySelectedElementsElementsOperatorImpl<T>(elementType, getTarget().iterate());
    }


    public Level1ListOfArraySelectedElementsOperator<T> distinct() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeEquals(final T... values) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotMatching<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNullOrNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrNotMatching<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNotNullNotMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullNotMatching<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean,? super T> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> removeNulls() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> eval(final IEvaluator<? extends T[],? super T[]> eval) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(eval));
    }


    public Level0ListOfArraySelectedOperator<T> endFor() {
        return new Level0ListOfArraySelectedOperatorImpl<T>(getTarget().endIterate(Structure.LIST, null));
    }


    public Level1ListOfArraySelectedElementsOperator<T> add(final T... newElements) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    @SuppressWarnings("unchecked")
    public Level1ListOfArraySelectedElementsOperator<T> sort() {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.Sort()));
    }


    public Level1ListOfArraySelectedElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }


    public Level1ListOfArraySelectedElementsOperator<T> exec(final IFunction<? extends T[],? super T[]> function) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(function));
    }


    public Level1ListOfArraySelectedElementsOperator<T> convert(final IConverter<? extends T[],? super T[]> converter) {
        return new Level1ListOfArraySelectedElementsOperatorImpl<T>(getTarget().execute(converter));
    }


    public List<T[]> get() {
        return endFor().get();
    }



}
