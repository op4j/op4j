package org.op4j.operators.impl.setofmap;

import java.util.Map;
import java.util.Set;

import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.operations.Operation;
import org.op4j.operators.impl.AbstractOperatorImpl;
import org.op4j.operators.intf.setofmap.Level2SetOfMapElementsSelectedEntriesOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeyOperator;
import org.op4j.operators.intf.setofmap.Level3SetOfMapElementsSelectedEntriesKeySelectedOperator;
import org.op4j.target.Target;
import org.op4j.target.Target.Normalization;
import org.op4j.target.Target.Structure;


public class Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V,I> extends AbstractOperatorImpl implements Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V,I> {


    public Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl(final Target target) {
        super(target);
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifIndex(final int... indices) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndex(indices));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifNullOrFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrNotMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifNotNullAndFalse(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndNotMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifNull() {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNull());
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifNullOrTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNullOrMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifIndexNot(final int... indices) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectIndexNot(indices));
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifNotNull() {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNull());
    }


    public Level3SetOfMapElementsSelectedEntriesKeySelectedOperator<K,V,I> ifNotNullAndTrue(final IEvaluator<Boolean, ? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeySelectedOperatorImpl<K,V,I>(getTarget().selectNotNullAndMatching(eval));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V,I> eval(final IEvaluator<? extends K,? super K> eval) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().execute(eval, Normalization.NONE));
    }


    public Level2SetOfMapElementsSelectedEntriesOperator<K,V,I> endOn() {
        return new Level2SetOfMapElementsSelectedEntriesOperatorImpl<K,V,I>(getTarget().endIterate(Structure.MAP_ENTRY, null));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V,I> exec(final IFunction<? extends K,? super K> function) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().execute(function, Normalization.NONE));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V,I> replaceWith(final K replacement) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().replaceWith(replacement));
    }


    public Level3SetOfMapElementsSelectedEntriesKeyOperator<K,V,I> convert(final IConverter<? extends K,? super K> converter) {
        return new Level3SetOfMapElementsSelectedEntriesKeyOperatorImpl<K,V,I>(getTarget().execute(converter, Normalization.NONE));
    }


    public Set<Map<K,V>> get() {
        return endOn().get();
    }


    public Operation<Set<Map<K,V>>,I> createOperation() {
        return endOn().createOperation();
    }



}
