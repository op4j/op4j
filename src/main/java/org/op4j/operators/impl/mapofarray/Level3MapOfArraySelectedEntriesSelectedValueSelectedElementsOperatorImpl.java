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
import org.op4j.target.Target.Normalisation;


public class Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> {


    private final Type<? extends V> type;


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl(final Type<? extends V> type, final Target target) {
        super(target);
        this.type = type;
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndex(indexes));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNullOrMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectIndexNot(indexes));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNull() {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNull());
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperator<K,V> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsSelectedOperatorImpl<K,V>(this.type, getTarget().selectNotNullAndMatching(eval));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(eval, Normalisation.NONE));
    }


    public Level2MapOfArraySelectedEntriesSelectedValueSelectedOperator<K,V> endFor() {
        return new Level2MapOfArraySelectedEntriesSelectedValueSelectedOperatorImpl<K,V>(getTarget().endIterate(this.type.getRawClass()));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> exec(final IFunction<? extends V,? super V> function) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(function, Normalisation.NONE));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> replaceWith(final V replacement) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().replaceWith(replacement));
    }


    public Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperator<K,V> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3MapOfArraySelectedEntriesSelectedValueSelectedElementsOperatorImpl<K,V>(this.type, getTarget().execute(converter, Normalisation.NONE));
    }


    public Map<K,V[]> get() {
        return endFor().get();
    }



}
