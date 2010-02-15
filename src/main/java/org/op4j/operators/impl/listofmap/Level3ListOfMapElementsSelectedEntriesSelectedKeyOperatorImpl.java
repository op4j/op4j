package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsSelectedEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level3ListOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V> extends AbstractOperatorImpl implements Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> {


    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndex(final int... indexes) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndex(indexes));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndFalse(final IFunction<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNull() {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNull());
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNullOrTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifIndexNot(final int... indexes) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectIndexNot(indexes));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNull() {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNull());
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperator<K,V> ifNotNullAndTrue(final IFunction<Boolean, ? super K> eval) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeySelectedOperatorImpl<K,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> execIfNotNull(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level2ListOfMapElementsSelectedEntriesSelectedOperator<K,V> endOn() {
        return new Level2ListOfMapElementsSelectedEntriesSelectedOperatorImpl<K,V>(getTarget().endOn());
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> exec(final IFunction<? extends K,? super K> function) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level3ListOfMapElementsSelectedEntriesSelectedKeyOperator<K,V> replaceWith(final K replacement) {
        return new Level3ListOfMapElementsSelectedEntriesSelectedKeyOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }



}
