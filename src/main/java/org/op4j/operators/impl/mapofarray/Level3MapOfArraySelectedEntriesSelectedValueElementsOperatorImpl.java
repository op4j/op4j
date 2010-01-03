package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNull() {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNull() {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean,? super V> eval) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level2MapOfArraySelectedEntriesSelectedValueOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,V[]> get() {
        return null;
    }



}
