package org.op4j.operators.impl.mapofmap;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import org.op4j.functions.IFunction;
import org.op4j.functions.MapFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.mapofmap.Level1MapOfMapEntriesSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueOperator;
import org.op4j.operators.intf.mapofmap.Level2MapOfMapEntriesSelectedValueSelectedOperator;
import org.op4j.operators.intf.mapofmap.Level3MapOfMapEntriesSelectedValueEntriesOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;


public class Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V> extends AbstractOperatorImpl implements Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> {


    public Level2MapOfMapEntriesSelectedValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndex(final int... indices) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndex(indices));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullNotMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNull() {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNull());
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNullOrMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNullOrMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifIndexNot(final int... indices) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectIndexNot(indices));
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNull() {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNull());
    }


    public Level2MapOfMapEntriesSelectedValueSelectedOperator<K1,K2,V> ifNotNullMatching(final IEvaluator<Boolean, ? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueSelectedOperatorImpl<K1,K2,V>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveMatching<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeNotMatching(final IEvaluator<Boolean,? super Entry<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveNotMatching<K2,V>(eval)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> eval(final IEvaluator<? extends Map<K2,V>,? super Map<K2,V>> eval) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(eval));
    }


    public Level3MapOfMapEntriesSelectedValueEntriesOperator<K1,K2,V> forEachEntry() {
        return new Level3MapOfMapEntriesSelectedValueEntriesOperatorImpl<K1,K2,V>(getTarget().iterate());
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> insertAll(final int position, final Map<K2,V> map) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.InsertAll<K2,V>(position, map)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeKeys(final K2... keys) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveKeys<K2,V>(keys)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> removeKeysNot(final K2... keys) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.RemoveKeysNot<K2,V>(keys)));
    }


    public Level1MapOfMapEntriesSelectedOperator<K1,K2,V> endOn() {
        return new Level1MapOfMapEntriesSelectedOperatorImpl<K1,K2,V>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> put(final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Put<K2,V>(newKey, newValue)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> putAll(final Map<K2,V> map) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.PutAll<K2,V>(map)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> insert(final int position, final K2 newKey, final V newValue) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.Insert<K2,V>(position, newKey, newValue)));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> exec(final IFunction<? extends Map<K2,V>,? super Map<K2,V>> function) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(function));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> sort(final Comparator<? super Entry<K2,V>> comparator) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortEntries<K2,V>(comparator)));
    }


    @SuppressWarnings("unchecked")
    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> sort() {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(new MapFuncs.SortByKey()));
    }


    public Level2MapOfMapEntriesSelectedValueOperator<K1,K2,V> convert(final IConverter<? extends Map<K2,V>,? super Map<K2,V>> converter) {
        return new Level2MapOfMapEntriesSelectedValueOperatorImpl<K1,K2,V>(getTarget().execute(converter));
    }


    public Map<K1,Map<K2,V>> get() {
        return endOn().get();
    }



}
