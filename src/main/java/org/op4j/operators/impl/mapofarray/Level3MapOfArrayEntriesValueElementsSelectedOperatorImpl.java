package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArrayEntriesValueElementsSelectedOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return null;
    }


    public Level3MapOfArrayEntriesValueElementsOperator<K,V> endIf() {
        return null;
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return null;
    }


    public Level3MapOfArrayEntriesValueElementsSelectedOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return null;
    }


    public Map<K,V[]> get() {
        return null;
    }



}
