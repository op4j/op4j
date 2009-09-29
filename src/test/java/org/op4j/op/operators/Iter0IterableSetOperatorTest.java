package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang.math.RandomUtils;
import org.op4j.exceptions.DuplicateMapKeyException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.Op;
import org.op4j.op.interfaces.EvalContext;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableSetOperatorTest extends TestCase {


	Iter0IterableSetOperator<Calendar> calendarOperator;
	Iter0IterableSetOperator<Integer> integerOperator;
	Set<Calendar> calendarSet = new HashSet<Calendar>();
	Set<Integer> integerSet = new HashSet<Integer>();
	
	protected void setUp() throws Exception {
		super.setUp();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		Calendar calendar20081010 = Calendar.getInstance();
		calendar20081010.setTime(sdf.parse("20081010"));
		calendar20081010.add(Calendar.MILLISECOND, 10);
		Calendar calendar20080101 = Calendar.getInstance();
		calendar20080101.setTime(sdf.parse("20080101"));
		calendar20080101.add(Calendar.MILLISECOND, 30);		
		Calendar calendar20080301 = Calendar.getInstance();
		calendar20080301.setTime(sdf.parse("20080301"));
		calendar20080301.add(Calendar.MILLISECOND, 40);		
		Calendar calendar20080421 = Calendar.getInstance();
		calendar20080421.setTime(sdf.parse("20080421"));
		calendar20080421.add(Calendar.MILLISECOND, 43);		
		this.calendarSet.add(calendar20081010);
		this.calendarSet.add(calendar20080101);
		this.calendarSet.add(calendar20080301);
		this.calendarSet.add(calendar20080421);
		this.calendarOperator = Op.onSet(Calendar.class, this.calendarSet);
		
		this.integerSet.add(Integer.valueOf(10));
		this.integerSet.add(Integer.valueOf(0));
		this.integerSet.add(Integer.valueOf(20));
		this.integerOperator = Op.onSet(Integer.class, this.integerSet);
	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testEachExecStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.calendarOperator.eachExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().iterator().next());
	}

	public final void testEachExecClassOfXStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.integerOperator.eachExec(String.class, 
						DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().iterator().next());
		
		try {
			assertEquals("Dummy operation result: 1",
					this.calendarOperator.eachExec(Calendar.class, 
							DummyOperationOnOneOrTwoTargets.OPERATION_NAME));
			fail("this.calendarOperator.exec(Calendar.class, ToJson.OPERATION_NAME) should have failed as it does " +
					"not return a Calendar but a String");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}

	@SuppressWarnings("boxing")
	public final void testEach() {
		List<Calendar> updated = new ArrayList<Calendar>();
		for (Calendar calendar : this.calendarSet) {
			Calendar aux = Calendar.getInstance();
			aux.setTime(calendar.getTime());
			aux.add(Calendar.YEAR, 1);		
			updated.add(aux);			
		}
		
		assertEquals(updated, this.calendarOperator
				.each()
				.eval("add(#param[0], #param[1]), #target", Calendar.YEAR, 1).uneachList()
				.getTargetObjects().get(0));
	}

	public final void testGeneric() {
		assertEquals(this.calendarSet,
				this.calendarOperator.generic().getTargetObjects().get(0));
	}

	public final void testFlat() {
		assertEquals(this.calendarSet.size(),
				this.calendarOperator.flat().getTargetObjects().size());
	}

	public final void testAsSet() {
		assertTrue(Types.SET.isAssignableFrom(
				this.calendarOperator
				.getTargets().get(0).getIntendedType()));
		
		assertTrue(Types.forName("Set<Calendar>").isAssignableFrom(
				this.calendarOperator.asSet(Calendar.class)
				.getTargets().get(0).getIntendedType()));
				
		assertFalse(this.calendarOperator.asSet(Calendar.class)
				.getTargets().get(0).getIntendedType()
				.isAssignableFrom(Types.SET));	
	}

	public final void testSort() {
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarSet);
		Collections.sort(aux);
		
		assertEquals(new HashSet<Calendar>(aux),				
				this.calendarOperator.sort()
				.getTargetObjects().get(0));
	}

	public final void testSortComparatorOfQsuperT() {
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarSet);
		Collections.sort(aux);
		Collections.reverse(aux);
		aux.add(null);
		
		this.calendarSet.add(null);
		
		Comparator<Calendar> comparator = new Comparator<Calendar>() {
			public int compare(Calendar o1, Calendar o2) {
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return -1;
				}
				return o2.compareTo(o1);
			}			
		};
		
		assertEquals(new HashSet<Calendar>(aux), this.calendarOperator
				.sort(comparator).get());	
	}

	public final void testFilterEachStringObjectArray() {
		assertEquals(0, this.calendarOperator.eachFilter("#param[0].after(#target)", Calendar.getInstance())
				.getTargetObjects().get(0).size());		
	}

	public final void testFilterEachFilterOfT() {
		Filter<Calendar> theFilter = new Filter<Calendar>() {
			public boolean eval(FilterContext<Calendar> ctx) {
				return false;
			}			
		};		
		assertEquals(this.calendarSet, this.calendarOperator.eachFilter(theFilter)
				.getTargetObjects().get(0));		
	}

	public final void testToList() {
		List<Calendar> list = new ArrayList<Calendar>(this.calendarSet);
		assertEquals(list, this.calendarOperator.toList().getTargetObjects().get(0));
	}

	public final void testToArray() {
		Calendar[] result1 = (Calendar[]) this.calendarOperator.toArray().getTargetObjects().get(0);
		Calendar[] result2 = this.calendarSet.toArray(new Calendar[]{});
		
		assertEquals(result1.length, result2.length);
		for(int index = 0; index < result1.length; index++) {
			assertTrue(result1[index].compareTo(result2[index]) == 0);
		}		
	}

	public final void testGet() {
		assertEquals(this.calendarSet,
				this.calendarOperator.get());
	}

	public final void testGetClassOfX() {
		assertEquals(this.calendarSet,
				this.calendarOperator.get(Calendar.class));
		
		// as cast is not being done (calendar list is not being iterated) this get methods can be executed
		this.calendarOperator.get(Integer.class);	
	}

	public final void testSize() {
		assertEquals(1, 
				this.calendarOperator.size());
	}

	public final void testRaw() {
		assertEquals(TypeSchemes.forName("Set<Calendar>"), 
				this.calendarOperator.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Set<?>"), 
				this.calendarOperator.raw().getTargetTypeScheme());
	}

	public final void testToMapStringObjectArray() {
				
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(Integer.valueOf(10), Integer.valueOf(10));
		map.put(Integer.valueOf(20), Integer.valueOf(20));
		map.put(Integer.valueOf(15), Integer.valueOf(15));
		
		Set<Object> set = new LinkedHashSet<Object>();
		set.add(Integer.valueOf(10));
		set.add(Integer.valueOf(20));
		set.add(Integer.valueOf(15));
		
		assertEquals(map, Op.onSet(set).toMap("#target")
				.getTargetObjects().get(0));			
	}

	public final void testToMapClassOfKStringObjectArray() {
		assertEquals(this.integerSet.iterator().next(),
				this.integerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.get().get(this.integerSet.iterator().next() * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, Integer>"),
				this.integerOperator.toMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Integer>"),
				this.integerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(this.integerSet.size(),
				this.integerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.get().size());
		
		try {
			this.integerOperator.toMap(Calendar.class, "#param[0]", Calendar.getInstance());
			fail("this.integerOperator.toMap(Calendar.class, \"#param[0]\", Calendar.getInstance())"
					+ " should have failed as it would contain repeated keys");
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}				
	}

	public final void testToMapStringStringObjectArray() {
		
		Calendar cal = Calendar.getInstance();
		
		Map<Integer, Calendar> map = new LinkedHashMap<Integer, Calendar>();
		map.put(Integer.valueOf(10), cal);
		map.put(Integer.valueOf(20), cal);
		map.put(Integer.valueOf(15), cal);
		
		Set<Object> set = new LinkedHashSet<Object>();
		set.add(Integer.valueOf(10));
		set.add(Integer.valueOf(20));
		set.add(Integer.valueOf(15));
		
		assertEquals(map, Op.onSet(set).toMap("#target", "#param[0]", cal)
				.getTargetObjects().get(0));	
		
		try {
			Op.onSet(set).toMap("#param[0]", "#param[1].nextDouble()", Calendar.getInstance(), new Random()).get();	
			fail("toMap() should have failed as map would contain repeated keys");
		} catch (DuplicateMapKeyException e) {
			// do nothing
		}		
	}

	public final void testToMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>").isAssignableFrom(
				this.integerOperator.toMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargets().get(0).getIntendedType()));
	}

	public final void testToMapClassOfKClassOfVMapBuilderOfKVT() {
		assertEquals(TypeSchemes.forName("Map<Calendar, Integer>"),
				this.calendarOperator.toMap(Calendar.class, Integer.class, new MapBuilder<Calendar, Calendar, Integer>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			
		try {
			final Calendar cal = Calendar.getInstance();
			this.calendarOperator.toMap(Calendar.class, Integer.class, new MapBuilder<Calendar, Calendar, Integer>() {
				public Calendar getKey(Calendar target) {
					return cal;
				}
				public Integer getValue(Calendar target) {
					return target.get(Calendar.MILLISECOND) + RandomUtils.nextInt();
				}					 
			});
			fail("toMap() should have failed as map would contain repeated keys and their value is not the same");
		} catch (DuplicateMapKeyException e) {
			// do nothing
		}	
	}

	public final void testToMapMapBuilderOfObjectObjectT() {
		assertEquals(TypeSchemes.forName("Map<?, ?>"),
				this.calendarOperator.toMap(new MapBuilder<Calendar, Object, Object>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			
		try {
			final Calendar cal = Calendar.getInstance();
			this.calendarOperator.toMap(new MapBuilder<Calendar, Object, Object>() {
				public Calendar getKey(Calendar target) {
					return cal;
				}
				public Integer getValue(Calendar target) {
					return target.get(Calendar.MILLISECOND) + RandomUtils.nextInt();
				}					 
			});
			fail("toMap() should have failed as map would contain repeated keys and their value is not the same");
		} catch (DuplicateMapKeyException e) {
			// do nothing
		}	
	}

	public final void testToListMapStringObjectArray() {
				
		Map<Integer, List<Integer>> map = new LinkedHashMap<Integer, List<Integer>>();
		map.put(Integer.valueOf(10), Arrays.asList(Integer.valueOf(10)));
		map.put(Integer.valueOf(20), Arrays.asList(Integer.valueOf(20)));
		map.put(Integer.valueOf(15), Arrays.asList(Integer.valueOf(15)));
		
		Set<Object> set = new LinkedHashSet<Object>();
		set.add(Integer.valueOf(10));
		set.add(Integer.valueOf(20));
		set.add(Integer.valueOf(15));
			
		assertTrue(map.values().containsAll(Op.onSet(set).toListMap("#target")
				.getTargetObjects().get(0).values()));
		assertTrue(map.keySet().containsAll(Op.onSet(set).toListMap("#target")
				.getTargetObjects().get(0).keySet()));
		assertEquals(map.size(), Op.onSet(set).toListMap("#target")
				.getTargetObjects().get(0).size());
				
		assertEquals(null, Op.onSet(set).toListMap("#target").getOperatorKeyType());
		assertEquals(null, Op.onSet(set).toListMap("#target").getOperatorValueType());
	}

	public final void testToListMapClassOfKStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, List<Integer>>"),
				this.integerOperator.toListMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, List<Integer>>"),
				this.integerOperator.toListMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.integerOperator.toListMap(Calendar.class, "#param[0]", cal).size());
		assertTrue(new ArrayList<Integer>(this.integerSet).equals(this.integerOperator.toListMap(Calendar.class, "#param[0]", cal).get().get(cal)));
	}

	public final void testToListMapStringStringObjectArray() {
		assertEquals(Arrays.asList(this.integerSet.iterator().next()),
				this.integerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.integerSet.iterator().next() * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"),
				this.integerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(3,
				this.integerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().size());
	}

	public final void testToListMapClassOfKClassOfVStringStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"),
				this.integerOperator.toListMap("#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());
			
		assertEquals(TypeSchemes.forName("Map<Integer, List<Long>>"),
				this.integerOperator.toListMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());	
	}

	public final void testToListMapClassOfKClassOfVMapBuilderOfKVT() {
		assertEquals(TypeSchemes.forName("Map<Calendar, List<Integer>>"),
				this.calendarOperator.toListMap(Calendar.class, Integer.class, new MapBuilder<Calendar, Calendar, Integer>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
	}

	public final void testToListMapMapBuilderOfTObjectObject() {
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"),
				this.calendarOperator.toListMap(new MapBuilder<Calendar, Object, Object>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			

		final Calendar cal = Calendar.getInstance();
		assertEquals(1, this.calendarOperator.toListMap(new MapBuilder<Calendar, Object, Object>() {
			public Calendar getKey(Calendar target) {
				return cal;
			}
			public Integer getValue(Calendar target) {
				return target.get(Calendar.MILLISECOND) + RandomUtils.nextInt();
			}					 
		}).size());	
	}
	
	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Set<Calendar>").getName(),
				this.calendarOperator.getTargetTypeScheme().getName());
	}

	public final void testGetTargetObjects() {
		Set<Integer> values = new HashSet<Integer>();
		values.add(Integer.valueOf(10));
		values.add(Integer.valueOf(10));
		values.add(Integer.valueOf(20));
		
		List<Set<Integer>> targetObjects = Op.onSet(Integer.class, values)				
				.getTargetObjects();
		assertEquals(2, targetObjects.get(0).size());
		assertTrue(values.containsAll(targetObjects
				.get(0)));		
	}

	public final void testCallEachStringObjectArray() {
		assertEquals(new HashSet<String>(Arrays.asList(new String[] {"10", "20", "30", "40"})), 
				Op.onSet(Integer.class, new HashSet<Integer>(Arrays.asList(new Integer[] {10, 20, 30, 40})))
			.eachCall("toString").get());		
	}

	public final void testCallEachClassOfXStringObjectArray() {
		assertEquals(new HashSet<String>(Arrays.asList(new String[] {"10", "20", "30", "40"})), 
				Op.onSet(Integer.class, new HashSet<Integer>(Arrays.asList(new Integer[] {10, 20, 30, 40})))
			.eachCall(String.class, "toString").get());
		
		try {
			Op.onSet(Integer.class, null)
				.eachCall(String.class, "toString");
			fail("Call to Op.onArray(Integer.class, null).eachCall(String.class, \"toString\")" +
					" should have failed as it contains a null target");
		} catch (NullTargetException e) {
			// do nothing
		}
		
		assertEquals(Arrays.toString(new String[] {}), 
				Arrays.toString(Op.onArray(Integer.class, new Integer[] {})
			.eachCall(String.class, "toString").get()));	
	}
	
	public final void testToSetMapStringObjectArray() {
		Map<Integer, Set<Integer>> map = new LinkedHashMap<Integer, Set<Integer>>();
		map.put(Integer.valueOf(10), new HashSet<Integer>(Arrays.asList(Integer.valueOf(10))));
		map.put(Integer.valueOf(20), new HashSet<Integer>(Arrays.asList(Integer.valueOf(20))));
		map.put(Integer.valueOf(15), new HashSet<Integer>(Arrays.asList(Integer.valueOf(15))));
		
		Set<Object> set = new LinkedHashSet<Object>();
		set.add(Integer.valueOf(10));
		set.add(Integer.valueOf(20));
		set.add(Integer.valueOf(15));
			
		assertTrue(map.values().containsAll(Op.onSet(set).toSetMap("#target")
				.getTargetObjects().get(0).values()));
		assertTrue(map.keySet().containsAll(Op.onSet(set).toSetMap("#target")
				.getTargetObjects().get(0).keySet()));
		assertEquals(map.size(), Op.onSet(set).toListMap("#target")
				.getTargetObjects().get(0).size());
				
		assertEquals(null, Op.onSet(set).toSetMap("#target").getOperatorKeyType());
		assertEquals(null, Op.onSet(set).toSetMap("#target").getOperatorValueType());
	}

	public final void testToSetMapClassOfKStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, Set<Integer>>"),
				this.integerOperator.toSetMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Integer>>"),
				this.integerOperator.toSetMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.integerOperator.toSetMap(Calendar.class, "#param[0]", cal).size());
		assertTrue(this.integerSet.equals(this.integerOperator.toSetMap(Calendar.class, "#param[0]", cal).get().get(cal)));
	}

	public final void testToSetMapStringStringObjectArray() {
		assertEquals(new HashSet<Integer>(Arrays.asList(this.integerSet.iterator().next())),
				this.integerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.integerSet.iterator().next() * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"),
				this.integerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(3,
				this.integerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().size());
	}

	public final void testToSetMapClassOfKClassOfVStringStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"),
				this.integerOperator.toSetMap("#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());
			
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Long>>"),
				this.integerOperator.toSetMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());	
	}

	public final void testToSetMapClassOfKClassOfVMapBuilderOfTKV() {
		assertEquals(TypeSchemes.forName("Map<Calendar, Set<Integer>>"),
				this.calendarOperator.toSetMap(Calendar.class, Integer.class, new MapBuilder<Calendar, Calendar, Integer>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
	}

	public final void testToSetMapMapBuilderOfTObjectObject() {
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"),
				this.calendarOperator.toSetMap(new MapBuilder<Calendar, Object, Object>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			

		final Calendar cal = Calendar.getInstance();
		assertEquals(1, this.calendarOperator.toSetMap(new MapBuilder<Calendar, Object, Object>() {
			public Calendar getKey(Calendar target) {
				return cal;
			}
			public Integer getValue(Calendar target) {
				return target.get(Calendar.MILLISECOND) + RandomUtils.nextInt();
			}					 
		}).size());	
	}
	    
	public final void testEachEvalStringObjectArray() {
		Set result = this.calendarOperator.eachEval("get(#param[0])", Calendar.MILLISECOND)
			.get();
		Iterator iterator = result.iterator();
		for (Calendar calendar : this.calendarSet) {
			assertEquals(iterator.next(), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(null, this.calendarOperator.eachEval("get(#param[0])", Calendar.MILLISECOND).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<?>"), this.calendarOperator.eachEval("get(#param[0])", Calendar.MILLISECOND).getTargetTypeScheme());
	}

	public final void testEachEvalClassOfXStringObjectArray() {
		Set result = this.calendarOperator.eachEval(Integer.class, "get(#param[0])", Calendar.MILLISECOND)
			.get();
		Iterator iterator = result.iterator();
		for (Calendar calendar : this.calendarSet) {
			assertEquals(iterator.next(), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(Types.INTEGER, this.calendarOperator.eachEval(Integer.class, "get(#param[0])", Calendar.MILLISECOND).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<Integer>"), this.calendarOperator.eachEval(Integer.class, "get(#param[0])", Calendar.MILLISECOND).getTargetTypeScheme());
	}

	public final void testEachEvalClassOfXEvaluatorOfTX() {
		Evaluator<Calendar, Integer> evaluator = new Evaluator<Calendar, Integer>() {
			public Integer evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).get(Calendar.MILLISECOND);
			}			
		};
		Set result = this.calendarOperator.eachEval(Integer.class, evaluator).get();
		Iterator iterator = result.iterator();
		for (Calendar calendar : this.calendarSet) {
			assertEquals(iterator.next(), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(Types.INTEGER, this.calendarOperator.eachEval(Integer.class, evaluator).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<Integer>"), this.calendarOperator.eachEval(Integer.class, evaluator).getTargetTypeScheme());
	}

	public final void testEachEvalEvaluatorOfTObject() {
		Evaluator<Calendar, Object> evaluator = new Evaluator<Calendar, Object>() {
			public Integer evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).get(Calendar.MILLISECOND);
			}			
		};
		Set result = this.calendarOperator.eachEval(evaluator).get();
		Iterator iterator = result.iterator();
		for (Calendar calendar : this.calendarSet) {
			assertEquals(iterator.next(), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(null, this.calendarOperator.eachEval(evaluator).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<?>"), this.calendarOperator.eachEval(evaluator).getTargetTypeScheme());
	}

	public final void testEachToTypeObjectArray() {
		Set result = this.integerOperator.eachTo(Types.STRING).get();
		Iterator iterator = result.iterator();
		for (Integer originalInteger : this.integerSet) {
			assertEquals(originalInteger.toString(), iterator.next());
		}
		
		assertEquals(TypeSchemes.forName("Set<?>"), this.integerOperator.eachTo(Types.STRING).getTargetTypeScheme());
		assertEquals(null, this.integerOperator.eachTo(Types.STRING).getOperatorComponentType());
	}

	public final void testEachToStringObjectArray() {
		Set result = this.integerOperator.eachTo(Types.STRING.getName()).get();
		Iterator iterator = result.iterator();
		for (Integer originalInteger : this.integerSet) {
			assertEquals(originalInteger.toString(), iterator.next());
		}
		
		assertEquals(TypeSchemes.forName("Set<?>"), this.integerOperator.eachTo(Types.STRING.getName()).getTargetTypeScheme());
		assertEquals(null, this.integerOperator.eachTo(Types.STRING.getName()).getOperatorComponentType());
	}

	public final void testEachToClassOfXObjectArray() {
		Set result = this.integerOperator.eachTo(String.class).get();
		Iterator iterator = result.iterator();
		for (Integer originalInteger : this.integerSet) {
			assertEquals(originalInteger.toString(), iterator.next());
		}
		
		assertEquals(TypeSchemes.forName("Set<String>"), this.integerOperator.eachTo(String.class).getTargetTypeScheme());
		assertEquals(Types.STRING, this.integerOperator.eachTo(String.class).getOperatorComponentType());
	}
	    
}
