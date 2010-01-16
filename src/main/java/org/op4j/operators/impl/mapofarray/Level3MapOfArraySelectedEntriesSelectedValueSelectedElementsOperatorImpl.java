package org.op4j.operators.impl.mapofarray;

import java.util.Map;

import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> {


    private final Type<? extends V> type;


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indices));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(eval, Normalization.NONE));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().endIterate(Structure.ARRAY, this.type.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalization.NONE));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(converter, Normalization.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
