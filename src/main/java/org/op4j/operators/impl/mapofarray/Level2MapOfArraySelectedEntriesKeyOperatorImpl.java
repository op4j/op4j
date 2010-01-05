package org.op4j.operators.impl.mapofarray;

import java.util.Map;
import org.javaruntype.type.Type;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofarray.Level1MapOfArraySelectedEntriesOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeyOperator;
import org.op4j.operators.intf.mapofarray.Level2MapOfArraySelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2MapOfArraySelectedEntriesKeyOperator<K,V> {


    private final Type<? super V> arrayOf;


    public Level2MapOfArraySelectedEntriesKeyOperatorImpl(final Type<? super V> arrayOf, final Target target) {
        super(target);
        this.arrayOf = arrayOf;
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifIndex(final int... indices) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndex(indices));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNull() {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNull());
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNullOrMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifIndexNot(final int... indices) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectIndexNot(indices));
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNotNull() {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNull());
    }


    public Level2MapOfArraySelectedEntriesKeySelectedOperator<K,V> ifNotNullMatching(final IEvaluator<Boolean, ? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeySelectedOperatorImpl<K,V>(this.arrayOf, getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(this.arrayOf, getTarget().execute(eval));
    }


    public Level1MapOfArraySelectedEntriesOperator<K,V> endOn() {
        return new Level1MapOfArraySelectedEntriesOperatorImpl<K,V>(this.arrayOf, getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(this.arrayOf, getTarget().execute(function));
    }


    public Level2MapOfArraySelectedEntriesKeyOperator<K,V> convert(final IConverter<? extends K,? super K> converter) {
        return new Level2MapOfArraySelectedEntriesKeyOperatorImpl<K,V>(this.arrayOf, getTarget().execute(converter));
    }


    public Map<K,V[]> get() {
        return null;
    }



}
