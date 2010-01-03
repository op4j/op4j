package org.op4j.operators.impl.setofmap;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.intf.setofmap.Level0SetOfMapSelectedOperator;
import org.op4j.operators.intf.setofmap.Level1SetOfMapSelectedElementsOperator;
import org.op4j.target.Target;


public class Level0SetOfMapSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0SetOfMapSelectedOperator<K,V> {


    public Level0SetOfMapSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level1SetOfMapSelectedElementsOperator<K,V> forEach() {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> distinct() {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeIndexes(final int... indices) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeEquals(final Map<K,V>... values) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNullOrNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNotNullNotMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNotNullMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNullOrMatching(final IEvaluator<Boolean,? super Map<K,V>> eval) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeIndexesNot(final int... indices) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> removeNulls() {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> eval(final IEvaluator<? extends Set<Map<K,V>>,? super Set<Map<K,V>>> eval) {
        return null;
    }


    public Level0SetOfMapOperator<K,V> endIf() {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> add(final Map<K,V>... newElements) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> addAll(final Collection<Map<K,V>> collection) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> insert(final int position, final Map<K,V>... newElements) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> exec(final IFunction<? extends Set<Map<K,V>>,? super Set<Map<K,V>>> function) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> sort() {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> sort(final Comparator<? super Map<K,V>> comparator) {
        return null;
    }


    public Level0SetOfMapSelectedOperator<K,V> convert(final IConverter<? extends Set<Map<K,V>>,? super Set<Map<K,V>>> converter) {
        return null;
    }


    public Set<Map<K,V>> get() {
        return null;
    }



}
