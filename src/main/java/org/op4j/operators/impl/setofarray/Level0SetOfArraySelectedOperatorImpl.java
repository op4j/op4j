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
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public class Level0SetOfArraySelectedOperatorImpl<T> extends AbstractOperatorImpl implements Level0SetOfArraySelectedOperator<T> {


    private final Type<T> type;


    public Level0SetOfArraySelectedOperatorImpl(final Type<T> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level1SetOfArraySelectedElementsOperator<T> forEach() {
        return new Level1SetOfArraySelectedElementsOperatorImpl<T>(this.type, getTarget().iterate(Structure.SET));
    }


    public Level0SetOfArraySelectedOperator<T> insertAll(final int position, final T[]... newElements) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllIndexes(final int... indexes) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllIndexes<T[]>(indexes)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllEqual(final T[]... values) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllEqual<T[]>(values)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllTrue<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllFalse<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNullOrFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNullOrTrue(final IEvaluator<Boolean,? super T[]> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<T[]>(eval)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllIndexesNot(final int... indexes) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllIndexesNot<T[]>(indexes)));
    }


    public Level0SetOfArraySelectedOperator<T> removeAllNull() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.RemoveAllNull<T[]>()));
    }


    public Level0SetOfArrayOperator<T> endIf() {
        return new Level0SetOfArrayOperatorImpl<T>(this.type, getTarget().endSelect());
    }


    public Level0SetOfArraySelectedOperator<T> convertAsSetOfArray(final IConverter<? extends Set<? extends T[]>,? super Set<T[]>> converter) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(converter, Normalisation.SET_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0SetOfArraySelectedOperator<T> evalAsSetOfArray(final IEvaluator<? extends Set<? extends T[]>,? super Set<T[]>> eval) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(eval, Normalisation.SET_OF_ARRAY(this.type.getRawClass())));
    }


    public Level0SetOfArraySelectedOperator<T> execAsSetOfArray(final IFunction<? extends Set<? extends T[]>,? super Set<T[]>> function) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(function, Normalisation.SET_OF_ARRAY(this.type.getRawClass())));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArraySelectedOperator<T> add(final T[] newElement) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.Add<T[]>(NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }


    public Level0SetOfArraySelectedOperator<T> addAll(final T[]... newElements) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.Add<T[]>(NormalisationUtils.normaliseArrays(newElements, this.type.getRawClass()))));
    }


    public Level0SetOfArraySelectedOperator<T> addAll(final Collection<T[]> collection) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.AddAll<T[]>(NormalisationUtils.normaliseArrays(collection, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArraySelectedOperator<T> insert(final int position, final T[] newElement) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.Insert<T[]>(position, NormalisationUtils.normaliseArray(newElement, this.type.getRawClass()))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfArraySelectedOperator<T> sort() {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfArraySelectedOperator<T> sort(final Comparator<? super T[]> comparator) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().execute(new SetFuncs.SortByComparator<T[]>(comparator)));
    }


    public Level0SetOfArraySelectedOperator<T> replaceWith(final Set<T[]> replacement) {
        return new Level0SetOfArraySelectedOperatorImpl<T>(this.type, getTarget().replaceWith(replacement, Normalisation.SET_OF_ARRAY(this.type.getRawClass())));
    }


    public Set<T[]> get() {
        return endIf().get();
    }



}
