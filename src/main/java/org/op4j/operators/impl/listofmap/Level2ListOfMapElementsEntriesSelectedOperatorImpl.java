package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.op4j.functions.IFunction;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level2ListOfMapElementsEntriesSelectedOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedKeyOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapElementsEntriesSelectedValueOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalisation;


public final class Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V> extends AbstractOperatorImpl implements Level2ListOfMapElementsEntriesSelectedOperator<K,V> {


    public Level2ListOfMapElementsEntriesSelectedOperatorImpl(final Target target) {
        super(target);
    }


    public Level2ListOfMapElementsEntriesOperator<K,V> endIf() {
        return new Level2ListOfMapElementsEntriesOperatorImpl<K,V>(getTarget().endSelect());
    }


    public Level3ListOfMapElementsEntriesSelectedKeyOperator<K,V> onKey() {
        return new Level3ListOfMapElementsEntriesSelectedKeyOperatorImpl<K,V>(getTarget().onKey());
    }


    public Level3ListOfMapElementsEntriesSelectedValueOperator<K,V> onValue() {
        return new Level3ListOfMapElementsEntriesSelectedValueOperatorImpl<K,V>(getTarget().onValue());
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> execAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().execute(function, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> execIfNotNullAsMapEntry(final IFunction<? extends Entry<? extends K,? extends V>,? super Entry<K,V>> function) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().executeIfNotNull(function, Normalisation.MAP_ENTRY));
    }


    public Level2ListOfMapElementsEntriesSelectedOperator<K,V> replaceWith(final Entry<K,V> replacement) {
        return new Level2ListOfMapElementsEntriesSelectedOperatorImpl<K,V>(getTarget().replaceWith(replacement, Normalisation.MAP_ENTRY));
    }


    public List<Map<K,V>> get() {
        return endIf().get();
    }



}
