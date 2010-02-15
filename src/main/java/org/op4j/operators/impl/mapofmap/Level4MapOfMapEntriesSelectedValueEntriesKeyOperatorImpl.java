package org.op4j.operators.impl.mapofmap;

import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueEntriesOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueEntriesKeyOperator;
import org.op4j.operators.intf.mapofmap.Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level4MapOfMapEntriesSelectedValueEntriesKeyOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V> {


    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifIndex(final int... indexes) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indexes));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifTrue(final IFunction<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifFalse(final IFunction<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifNullOrFalse(final IFunction<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifNotNullAndFalse(final IFunction<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifNull() {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifNullOrTrue(final IFunction<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifIndexNot(final int... indexes) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indexes));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifNotNull() {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperator<K1,K2,V> ifNotNullAndTrue(final IFunction<Boolean, ? super K2> eval) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeySelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V> execIfNotNull(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeyOperatorImpl<K1,K2,V>(getTarget().executeIfNotNull(function, Normalisation.NONE));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> endOn() {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V>(getTarget().endOn());
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V> exec(final IFunction<? extends K2,? super K2> function) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeyOperatorImpl<K1,K2,V>(getTarget().execute(function, Normalisation.NONE));
    }


    public Level4MapOfMapEntriesSelectedValueEntriesKeyOperator<K1,K2,V> replaceWith(final K2 replacement) {
        return new Level4MapOfMapEntriesSelectedValueEntriesKeyOperatorImpl<K1,K2,V>(getTarget().replaceWith(replacement, Normalisation.NONE));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }



}
