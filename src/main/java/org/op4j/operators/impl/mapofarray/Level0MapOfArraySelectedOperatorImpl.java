package org.op4j.operators.impl.mapofarray;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.intf.mapofarray.Level0MapOfArraySelectedOperator;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.target.Target;


public class Level0MapOfArraySelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level0MapOfArraySelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level0MapOfArraySelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level0MapOfArraySelectedOperator<K,V> removeMatching(final IEvaluator<Boolean,? super Entry<K,V[]>> eval) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K,V[]>> eval) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> eval(final IEvaluator<? extends Map<K,V[]>,? super Map<K,V[]>> eval) {
        return null;
    }


    public Level0MapOfArrayOperator<K,V> endIf() {
        return null;
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> forEachEntry() {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> insertAll(final int position, final Map<K,V[]> map) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> removeKeys(final K... keys) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> removeKeysNot(final K... keys) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> put(final K newKey, final V[] newValue) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> putAll(final Map<K,V[]> map) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> insert(final int position, final K newKey, final V[] newValue) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> exec(final IFunction<? extends Map<K,V[]>,? super Map<K,V[]>> function) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> sort() {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> sort(final Comparator<? super Entry<K,V[]>> comparator) {
        return null;
    }


    public Level0MapOfArraySelectedOperator<K,V> convert(final IConverter<? extends Map<K,V[]>,? super Map<K,V[]>> converter) {
        return null;
    }


    public Map<K,V[]> get() {
        return null;
    }



}
