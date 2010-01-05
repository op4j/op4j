package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesSelectedOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2MapOfArraySelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1MapOfArraySelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level1MapOfArraySelectedEntriesSelectedOperatorImpl<K,V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level2MapOfArraySelectedEntriesSelectedKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArraySelectedEntriesSelectedKeyOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
