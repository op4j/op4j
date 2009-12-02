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
package org.op4j.operators.impl.generic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.Validate;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.op4j.exceptions.TargetCastException;
import org.op4j.functions.IFunction;
import org.op4j.functions.ListFuncs;
import org.op4j.functions.converters.IConverter;
import org.op4j.functions.converters.ToArray;
import org.op4j.functions.converters.ToList;
import org.op4j.functions.converters.ToMap;
import org.op4j.functions.converters.ToMapOfArray;
import org.op4j.functions.converters.ToMapOfList;
import org.op4j.functions.converters.ToMapOfSet;
import org.op4j.functions.converters.ToSet;
import org.op4j.functions.evaluators.Eval;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.methodcallers.Call;
import org.op4j.functions.methodcallers.IMethodCaller;
import org.op4j.mapbuild.IMapBuilder;
import org.op4j.operators.impl.Operator;
import org.op4j.operators.impl.array.Level0ArrayOperator;
import org.op4j.operators.impl.arrayofarray.Level0ArrayOfArrayOperator;
import org.op4j.operators.impl.arrayoflist.Level0ArrayOfListOperator;
import org.op4j.operators.impl.arrayofmap.Level0ArrayOfMapOperator;
import org.op4j.operators.impl.arrayofset.Level0ArrayOfSetOperator;
import org.op4j.operators.impl.list.Level0ListOperator;
import org.op4j.operators.impl.listofarray.Level0ListOfArrayOperator;
import org.op4j.operators.impl.listoflist.Level0ListOfListOperator;
import org.op4j.operators.impl.listofmap.Level0ListOfMapOperator;
import org.op4j.operators.impl.listofset.Level0ListOfSetOperator;
import org.op4j.operators.impl.map.Level0MapOperator;
import org.op4j.operators.impl.mapofarray.Level0MapOfArrayOperator;
import org.op4j.operators.impl.mapoflist.Level0MapOfListOperator;
import org.op4j.operators.impl.mapofmap.Level0MapOfMapOperator;
import org.op4j.operators.impl.mapofset.Level0MapOfSetOperator;
import org.op4j.operators.impl.set.Level0SetOperator;
import org.op4j.operators.impl.setofarray.Level0SetOfArrayOperator;
import org.op4j.operators.impl.setoflist.Level0SetOfListOperator;
import org.op4j.operators.impl.setofmap.Level0SetOfMapOperator;
import org.op4j.operators.impl.setofset.Level0SetOfSetOperator;
import org.op4j.operators.intf.array.ILevel0ArrayOperator;
import org.op4j.operators.intf.arrayofarray.ILevel0ArrayOfArrayOperator;
import org.op4j.operators.intf.arrayoflist.ILevel0ArrayOfListOperator;
import org.op4j.operators.intf.arrayofmap.ILevel0ArrayOfMapOperator;
import org.op4j.operators.intf.arrayofset.ILevel0ArrayOfSetOperator;
import org.op4j.operators.intf.generic.ILevel0GenericMultiOperator;
import org.op4j.operators.intf.generic.ILevel0GenericUniqOperator;
import org.op4j.operators.intf.list.ILevel0ListOperator;
import org.op4j.operators.intf.listofarray.ILevel0ListOfArrayOperator;
import org.op4j.operators.intf.listoflist.ILevel0ListOfListOperator;
import org.op4j.operators.intf.listofmap.ILevel0ListOfMapOperator;
import org.op4j.operators.intf.listofset.ILevel0ListOfSetOperator;
import org.op4j.operators.intf.map.ILevel0MapOperator;
import org.op4j.operators.intf.mapofarray.ILevel0MapOfArrayOperator;
import org.op4j.operators.intf.mapoflist.ILevel0MapOfListOperator;
import org.op4j.operators.intf.mapofmap.ILevel0MapOfMapOperator;
import org.op4j.operators.intf.mapofset.ILevel0MapOfSetOperator;
import org.op4j.operators.intf.set.ILevel0SetOperator;
import org.op4j.operators.intf.setofarray.ILevel0SetOfArrayOperator;
import org.op4j.operators.intf.setoflist.ILevel0SetOfListOperator;
import org.op4j.operators.intf.setofmap.ILevel0SetOfMapOperator;
import org.op4j.operators.intf.setofset.ILevel0SetOfSetOperator;
import org.op4j.target.Target;




/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class Level0GenericUniqOperator<T> extends Operator
        implements ILevel0GenericUniqOperator<T>  {

    
    public Level0GenericUniqOperator(final Target target) {
        super(target);
    }


    public ILevel0GenericMultiOperator<T> add(final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Add<T>(newElements)));
    }

    public ILevel0GenericMultiOperator<T> insert(final int position, final T... newElements) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.Insert<T>(position, newElements)));
    }


    public ILevel0GenericMultiOperator<T> addAll(final Collection<T> collection) {
        return new Level0GenericMultiOperator<T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ListFuncs.AddAll<T>(collection)));
    }


    public ILevel0ArrayOperator<T> buildArray(final Type<T> arrayOf) {
        return new Level0ArrayOperator<T>(arrayOf, getTarget().execute(new ToArray.FromObject<T>(arrayOf)));
    }


    public ILevel0ListOperator<T> buildList() {
        return new Level0ListOperator<T>(getTarget().execute(new ToList.FromObject<T>()));
    }


    public <K> ILevel0MapOperator<K, T> buildMap(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOperator<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOperator<K, V> buildMap(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOperator<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMap.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> ILevel0MapOfArrayOperator<K, T> buildMapOfArray(final Type<T> valueArrayOf, final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfArrayOperator<K, T>(valueArrayOf, getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByKeyEval<K, T>(valueArrayOf, keyEval)));
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> buildMapOfArray(final Type<V> valueArrayOf, final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfArrayOperator<K, V>(valueArrayOf, getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfArray.FromListByMapBuilder<K, V, T>(valueArrayOf, mapBuild)));
    }


    public <K> ILevel0MapOfListOperator<K, T> buildMapOfList(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfListOperator<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfListOperator<K, V> buildMapOfList(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfListOperator<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfList.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public <K> ILevel0MapOfSetOperator<K, T> buildMapOfSet(final IEvaluator<K, ? super T> keyEval) {
        return new Level0MapOfSetOperator<K, T>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByKeyEval<K, T>(keyEval)));
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> buildMapOfSet(final IMapBuilder<K, V, ? super T> mapBuild) {
        return new Level0MapOfSetOperator<K, V>(getTarget().execute(new ToList.FromObject<T>()).execute(new ToMapOfSet.FromListByMapBuilder<K, V, T>(mapBuild)));
    }


    public ILevel0SetOperator<T> buildSet() {
        return new Level0SetOperator<T>(getTarget().execute(new ToSet.FromObject<T>()));
    }


    public <X> ILevel0GenericUniqOperator<X> convert(final IConverter<X, ? super T> converter) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(converter));
    }



    public <X> ILevel0GenericUniqOperator<X> call(final IMethodCaller<X, ? super T> call) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(call));
    }

    public ILevel0GenericUniqOperator<?> callForObject(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Object>(getTarget().execute(Call.forObject(methodName, optionalParameters)));
    }

    public <X> ILevel0GenericUniqOperator<X> callForObjectOfType(final Type<X> resultType, final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Call.forObjectOfType(resultType, methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Byte> callForByte(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Call.forByte(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Short> callForShort(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Call.forShort(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Integer> callForInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Call.forInteger(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Long> callForLong(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Call.forLong(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Float> callForFloat(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Call.forFloat(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Double> callForDouble(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Call.forDouble(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigInteger> callForBigInteger(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Call.forBigInteger(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<BigDecimal> callForBigDecimal(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Call.forBigDecimal(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Boolean> callForBoolean(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Call.forBoolean(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Calendar> callForCalendar(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Call.forCalendar(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<String> callForString(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Call.forString(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Character> callForCharacter(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Call.forCharacter(methodName, optionalParameters)));
    }

    public ILevel0GenericUniqOperator<Date> callForDate(final String methodName, final Object... optionalParameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Call.forDate(methodName, optionalParameters)));
    }




    public <X> ILevel0ArrayOperator<X> asArray(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Types.arrayOf(of).getRawClass();
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "Array");
    		}
    	}
        return new Level0ArrayOperator<X>(of, getTarget());
    }


    public <X> ILevel0ListOperator<X> asList(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = List.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "List");
    		}
    	}
        return new Level0ListOperator<X>(getTarget());
    }


    public <K,V> ILevel0MapOperator<K,V> asMap(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Map.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "Map");
    		}
    	}
        return new Level0MapOperator<K,V>(getTarget());
    }


    public <X> ILevel0SetOperator<X> asSet(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Set.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "Set");
    		}
    	}
        return new Level0SetOperator<X>(getTarget());
    }


    public <X> ILevel0ArrayOfArrayOperator<X> asArrayOfArray(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Types.arrayOf(Types.arrayOf(of)).getRawClass();
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ArrayOfArray");
    		}
    	}
        return new Level0ArrayOfArrayOperator<X>(of, getTarget());
    }


    public <X> ILevel0ArrayOfListOperator<X> asArrayOfList(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = List[].class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ArrayOfList");
         }
        }
        return new Level0ArrayOfListOperator<X>(getTarget());
    }


    public <K, V> ILevel0ArrayOfMapOperator<K, V> asArrayOfMap(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Map[].class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ArrayOfMap");
    		}
    	}
        return new Level0ArrayOfMapOperator<K,V>(getTarget());
    }


    public <X> ILevel0ArrayOfSetOperator<X> asArrayOfSet(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Set[].class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ArrayOfSet");
         }
        }
        return new Level0ArrayOfSetOperator<X>(getTarget());
    }


    public <X> ILevel0ListOfArrayOperator<X> asListOfArray(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = List.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ListOfArray");
         }
        }
        return new Level0ListOfArrayOperator<X>(of, getTarget());
    }


    public <X> ILevel0ListOfListOperator<X> asListOfList(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = List.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ListOfList");
         }
        }
        return new Level0ListOfListOperator<X>(getTarget());
    }


    public <K, V> ILevel0ListOfMapOperator<K, V> asListOfMap(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = List.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ListOfMap");
    		}
    	}
        return new Level0ListOfMapOperator<K,V>(getTarget());
    }


    public <X> ILevel0ListOfSetOperator<X> asListOfSet(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = List.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "ListOfSet");
         }
        }
        return new Level0ListOfSetOperator<X>(getTarget());
    }


    public <K, V> ILevel0MapOfArrayOperator<K, V> asMapOfArray(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Map.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "MapOfArray");
    		}
    	}
        return new Level0MapOfArrayOperator<K,V>(valueOf, getTarget());
    }


    public <K, V> ILevel0MapOfListOperator<K, V> asMapOfList(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Map.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "MapOfList");
    		}
    	}
        return new Level0MapOfListOperator<K,V>(getTarget());
    }


    public <K1, K2, V> ILevel0MapOfMapOperator<K1, K2, V> asMapOfMap(final Type<K1> key1Of, final Type<K2> key2Of, final Type<V> valueOf) {
    	Validate.notNull(key1Of, "A type representing the keys of the first-level map must be specified");
    	Validate.notNull(key2Of, "A type representing the keys of the second-level maps must be specified");
    	Validate.notNull(valueOf, "A type representing the values of the second-level maps must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Map.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "MapOfMap");
    		}
    	}
        return new Level0MapOfMapOperator<K1,K2,V>(getTarget());
    }


    public <K, V> ILevel0MapOfSetOperator<K, V> asMapOfSet(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Map.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "MapOfSet");
    		}
    	}
        return new Level0MapOfSetOperator<K,V>(getTarget());
    }


    public <X> ILevel0SetOfArrayOperator<X> asSetOfArray(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Set.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "SetOfArray");
         }
        }
        return new Level0SetOfArrayOperator<X>(of, getTarget());
    }


    public <X> ILevel0SetOfListOperator<X> asSetOfList(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Set.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "SetOfList");
         }
        }
        return new Level0SetOfListOperator<X>(getTarget());
    }


    public <K, V> ILevel0SetOfMapOperator<K, V> asSetOfMap(final Type<K> keyOf, final Type<V> valueOf) {
    	Validate.notNull(keyOf, "A type representing the keys must be specified");
    	Validate.notNull(valueOf, "A type representing the values must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Set.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "SetOfMap");
    		}
    	}
        return new Level0SetOfMapOperator<K,V>(getTarget());
    }


    public <X> ILevel0SetOfSetOperator<X> asSetOfSet(final Type<X> of) {
    	Validate.notNull(of, "A type representing the elements must be specified");
    	final T targetObject = get();
        if (targetObject != null) {
        	final Class<?> newTargetClass = Set.class;
        	if (!newTargetClass.isAssignableFrom(targetObject.getClass())) {
        		throw new TargetCastException(targetObject.getClass(), "SetOfSet");
         }
        }
        return new Level0SetOfSetOperator<X>(getTarget());
    }


    public <X> ILevel0GenericUniqOperator<X> eval(final IEvaluator<X, ? super T> eval) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(eval));
    }


    public ILevel0GenericUniqOperator<BigDecimal> evalForBigDecimal(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigDecimal>(getTarget().execute(Eval.forBigDecimal(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<BigInteger> evalForBigInteger(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<BigInteger>(getTarget().execute(Eval.forBigInteger(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Boolean> evalForBoolean(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Boolean>(getTarget().execute(Eval.forBoolean(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<?> evalForObject(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Object>(getTarget().execute(Eval.forObject(ognlExpression, parameters)));
    }

    public <X> ILevel0GenericUniqOperator<X> evalForObjectOfType(final Type<X> resultType, final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(Eval.forObjectOfType(resultType, ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Byte> evalForByte(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Byte>(getTarget().execute(Eval.forByte(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Calendar> evalForCalendar(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Calendar>(getTarget().execute(Eval.forCalendar(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Double> evalForDouble(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Double>(getTarget().execute(Eval.forDouble(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Float> evalForFloat(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Float>(getTarget().execute(Eval.forFloat(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Integer> evalForInteger(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Integer>(getTarget().execute(Eval.forInteger(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Long> evalForLong(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Long>(getTarget().execute(Eval.forLong(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<Short> evalForShort(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Short>(getTarget().execute(Eval.forShort(ognlExpression, parameters)));
    }


    public ILevel0GenericUniqOperator<String> evalForString(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<String>(getTarget().execute(Eval.forString(ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Character> evalForCharacter(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Character>(getTarget().execute(Eval.forCharacter(ognlExpression, parameters)));
    }

    public ILevel0GenericUniqOperator<Date> evalForDate(final String ognlExpression, final Object... parameters) {
        return new Level0GenericUniqOperator<Date>(getTarget().execute(Eval.forDate(ognlExpression, parameters)));
    }




    public <X> ILevel0GenericUniqOperator<X> exec(final IFunction<X, ? super T> function) {
        return new Level0GenericUniqOperator<X>(getTarget().execute(function));
    }


    public <X> ILevel0GenericUniqOperator<X> of(final Type<X> of) {
        return new Level0GenericUniqOperator<X>(getTarget());
    }


    public ILevel0GenericUniqOperator<?> raw() {
        return new Level0GenericUniqOperator<T>(getTarget());
    }







    @SuppressWarnings("unchecked")
    public T get() {
        return (T) getTarget().get();
    }

}
