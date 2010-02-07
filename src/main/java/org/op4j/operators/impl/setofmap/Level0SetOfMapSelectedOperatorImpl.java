package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.SetFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;
import org.op4j.target.Target.Structure;
import org.op4j.util.NormalisationUtils;


public class Level0SetOfMapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0SetOfMapSelectedOperator<K,V> {


    public Level0SetOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> forEach() {
        return new Level1SetOfMapSelectedElementsOperatorImpl<K,V>(getTarget().iterate(Structure.SET));
    }


    public Level0SetOfMapSelectedOperator<K,V> insertAll(final int position, final Map<K,V>... map) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllIndexes(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexes<Map<K,V>>(indices)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllEqual(final Map<K,V>... values) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllEqual<Map<K,V>>(values)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllTrue<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllFalse<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllNullOrFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrFalse<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllNotNullAndFalse(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndFalse<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllNotNullAndTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNotNullAndTrue<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllNullOrTrue(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNullOrTrue<Map<K,V>>(eval)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllIndexesNot(final int... indices) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllIndexesNot<Map<K,V>>(indices)));
    }


    public Level0SetOfMapSelectedOperator<K,V> removeAllNull() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.RemoveAllNull<Map<K,V>>()));
    }


    public Level0SetOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends Set<? extends Map<? extends K,? extends V>>,? super Set<Map<K,V>>> eval) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(eval, Normalisation.SET_OF_MAP));
    }


    public Level0SetOfMapOperator<K,V> endIf() {
        return new Level0SetOfMapOperatorImpl<K,V>(getTarget().endSelect());
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V> add(final Map<K,V> newElement) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<Map<K,V>>(NormalisationUtils.normaliseMap(newElement))));
    }


    public Level0SetOfMapSelectedOperator<K,V> addAll(final Map<K,V>... newElements) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Add<Map<K,V>>(NormalisationUtils.normaliseMaps(newElements))));
    }


    public Level0SetOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.AddAll<Map<K,V>>(NormalisationUtils.normaliseMaps(collection))));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V> newElement) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Insert<Map<K,V>>(position, NormalisationUtils.normaliseMap(newElement))));
    }


    public Level0SetOfMapSelectedOperator<K,V> exec(final IFunction<? extends Set<? extends Map<? extends K,? extends V>>,? super Set<Map<K,V>>> function) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.SET_OF_MAP));
    }


    @SuppressWarnings("unchecked")
    public Level0SetOfMapSelectedOperator<K,V> sort() {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.Sort()));
    }


    public Level0SetOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(new SetFuncs.SortByComparator<Map<K,V>>(comparator)));
    }


    public Level0SetOfMapSelectedOperator<K,V> replaceWith(final Set<Map<K,V>> replacement) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement));
    }


    public Level0SetOfMapSelectedOperator<K,V> convert(final IConverter<? extends Set<? extends Map<? extends K,? extends V>>,? super Set<Map<K,V>>> converter) {
        return new Level0SetOfMapSelectedOperatorImpl<K,V>(getTarget().execute(converter, Normalisation.SET_OF_MAP));
    }


    public Set<Map<K,V>> get() {
        return endIf().get();
    }



}
