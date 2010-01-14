package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArrayEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> {


    private final Type<V> type;


    public Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl(final Type<V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indices));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArrayEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(eval));
    }


    public Level2MapOfArrayEntriesValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfArrayEntriesValueSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(function));
    }


    public Level3MapOfArrayEntriesValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArrayEntriesValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
