/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.op4j.operators.impl.setofarray;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;

import org.javaruntype.type.Type;
import org.op4j.functions.ArrayFuncs;
import org.op4j.functions.IFunction;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.set.Level1SetElementsOperator;
import org.op4j.operators.impl.setoflist.Level1SetOfListElementsOperator;
import org.op4j.operators.impl.setofmap.Level1SetOfMapElementsOperator;
import org.op4j.operators.impl.setofset.Level1SetOfSetElementsOperator;
import org.op4j.operators.intf.set.ILevel1SetElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setofarray.ILevel1SetOfArrayElementsOperator;
import org.op4j.operators.intf.setofarray.ILevel2SetOfArrayElementsElementsOperator;
import org.op4j.operators.intf.setoflist.ILevel1SetOfListElementsOperator;
import org.op4j.operators.intf.setofmap.ILevel1SetOfMapElementsOperator;
import org.op4j.operators.intf.setofset.ILevel1SetOfSetElementsOperator;
import org.op4j.select.ISelector;
import org.op4j.target.Target;
import org.op4j.target.Target.Structure;
import org.op4j.util.VarArgsUtil;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level1SetOfArrayElementsOperator<T> extends Operator
        implements ILevel1SetOfArrayElementsOperator<T>  {
    
    private final Type<? super T> arrayOf; 

    
    public Level1SetOfArrayElementsOperator(final Type<? super T> of, final Target target) {
        super(target);
        this.arrayOf = of;
    }


    public ILevel1SetOfArrayElementsOperator<T> add(final T... newElements) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Add<T>(newElements)));
    }


    public ILevel1SetOfArrayElementsOperator<T> insert(final int position, final T... newElements) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Insert<T>(position, newElements)));
    }


    public ILevel1SetOfArrayElementsOperator<T> addAll(final Collection<T> collection) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.AddAll<T>(collection)));
    }


    public ILevel1SetOfArrayElementsOperator<T> distinct() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Distinct<T>()));
    }


    public ILevel0SetOfArrayOperator<T> endFor() {
        return new Level0SetOfArrayOperator<T>(this.arrayOf, getTarget().endIterate(Structure.SET, null));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEach() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate());
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachIndex(final int... indices) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(indices));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(eval));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(eval));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(eval));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachSelected(final ISelector<T> selector) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterate(selector));
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachIndexNot(final int... indices) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNot(indices));
    }








    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNull() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNull());
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNotNullAnd(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNull() {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNull());
    }


    public ILevel2SetOfArrayElementsElementsOperator<T> forEachNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level2SetOfArrayElementsElementsOperator<T>(this.arrayOf, getTarget().iterateNullOr(Eval.forBoolean(ognlExpression, VarArgsUtil.asOptionalObjectList(optionalExpParams))));
    }





    public <X> ILevel1SetOfArrayElementsOperator<X> of(final Type<X> of) {
        return new Level1SetOfArrayElementsOperator<X>(of, getTarget());
    }


    public ILevel1SetOfArrayElementsOperator<?> raw() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget());
    }


    public ILevel1SetOfArrayElementsOperator<T> removeIndexes(final int... indices) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexes<T>(indices)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeEquals(final T... values) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveEquals<T>(values)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveMatching<T>(eval)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeNullOrMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(eval)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeNotNullMatching(final IEvaluator<Boolean, ? super T> eval) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(eval)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeSelected(final ISelector<T> selector) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveSelected<T>(selector)));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeIndexesNot(final int... indices) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveIndexesNot<T>(indices)));
    }



    public ILevel1SetOfArrayElementsOperator<T> removeNotNullMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNotNullMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }

    public ILevel1SetOfArrayElementsOperator<T> removeNullOrMatching(final String ognlExpression, final Object... optionalExpParams) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNullOrMatching<T>(Eval.forBoolean(ognlExpression, optionalExpParams))));
    }


    public ILevel1SetOfArrayElementsOperator<T> removeNulls() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.RemoveNulls<T>()));
    }

    

    @SuppressWarnings("unchecked")
    public ILevel1SetOfArrayElementsOperator<T> sort() {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.Sort()));
    }

    public ILevel1SetOfArrayElementsOperator<T> sort(final Comparator<? super T> comparator) {
        return new Level1SetOfArrayElementsOperator<T>(this.arrayOf, getTarget().execute(new ArrayFuncs.SortByComparator<T>(comparator)));
    }



    public ILevel1SetOfListElementsOperator<T> toList() {
        return new Level1SetOfListElementsOperator<T>(getTarget().execute(new ToList.FromArray<T>()));
    }


    public ILevel1SetOfMapElementsOperator<T, T> toMap() {
        return new Level1SetOfMapElementsOperator<T, T>(getTarget().execute(new ToMap.FromArrayByAlternateElements<T>()));
    }


    public <K> ILevel1SetOfMapElementsOperator<K, T> toMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level1SetOfMapElementsOperator<K, T>(getTarget().execute(new ToMap.FromArrayByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel1SetOfMapElementsOperator<K, V> toMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level1SetOfMapElementsOperator<K, V>(getTarget().execute(new ToMap.FromArrayByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel1SetOfSetElementsOperator<T> toSet() {
        return new Level1SetOfSetElementsOperator<T>(getTarget().execute(new ToSet.FromArray<T>()));
    }


    public Set<T[]> get() {
        return endFor().get();
    }

    
    
    
    
	public <X> ILevel1SetElementsOperator<X> convert(final IConverter<X, ? super T[]> converter) {
        return new Level1SetElementsOperator<X>(getTarget().execute(converter));
	}


    public <X> ILevel1SetElementsOperator<X> eval(final IEvaluator<X, ? super T[]> eval) {
        return new Level1SetElementsOperator<X>(getTarget().execute(eval));
    }


    public ILevel1SetElementsOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel1SetElementsOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel1SetElementsOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel1SetElementsOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level1SetElementsOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }


	public <X> ILevel1SetElementsOperator<X> exec(final IFunction<X, ? super T[]> function) {
        return new Level1SetElementsOperator<X>(getTarget().execute(function));
	}

    
    
}
