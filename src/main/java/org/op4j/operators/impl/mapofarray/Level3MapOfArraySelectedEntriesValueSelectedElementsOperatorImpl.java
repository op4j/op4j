package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesValueSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsOperator;
import org.op4j.operators.intf.mapofarray.Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator;
import org.op4j.target.Target;


public class Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level2MapOfArraySelectedEntriesValueSelectedOperator<K,V> endFor() {
        return null;
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level3MapOfArraySelectedEntriesValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesValueSelectedElementsOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
