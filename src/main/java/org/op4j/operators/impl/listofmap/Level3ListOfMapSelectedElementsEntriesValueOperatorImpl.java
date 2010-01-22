package org.op4j.operators.impl.listofmap;

import java.util.List;
import java.util.Map;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.listofmap.Level2ListOfMapSelectedElementsEntriesOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueOperator;
import org.op4j.operators.intf.listofmap.Level3ListOfMapSelectedElementsEntriesValueSelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3ListOfMapSelectedElementsEntriesValueOperator<K,V,I> {


    public Level3ListOfMapSelectedElementsEntriesValueOperatorImpl(final Target target) {
        super(target);
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifNull() {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifNotNull() {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level3ListOfMapSelectedElementsEntriesValueSelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueSelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V,I> eval(final IEvaluator<? extends V,? super V> eval) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2ListOfMapSelectedElementsEntriesOperator<K,V,I> endOn() {
        return new Level2ListOfMapSelectedElementsEntriesOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V,I> exec(final IFunction<? extends V,? super V> function) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V,I> replaceWith(final V replacement) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3ListOfMapSelectedElementsEntriesValueOperator<K,V,I> convert(final IConverter<? extends V,? super V> converter) {
        return new Level3ListOfMapSelectedElementsEntriesValueOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public List<Map<K,V>> get() {
        return endOn().get();
    }


    public Operation<List<Map<K,V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
