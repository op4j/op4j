package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableListOperatorTest extends TestCase {

	Iter0IterableListOperator<Calendar> calendarOperator;
	Iter0IterableListOperator<Integer> integerOperator;
	List<Calendar> calendarList = new ArrayList<Calendar>();
	List<Integer> integerList = new ArrayList<Integer>();
	
	 
	protected void setUp() throws Exception {
		super.setUp();
		
		Operations.addOperationImplementation(DummyOperationOnOneOrTwoTargets.class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		Calendar calendar20081010 = Calendar.getInstance();
		calendar20081010.setTime(sdf.parse("20081010"));
		Calendar calendar20080101 = Calendar.getInstance();
		calendar20080101.setTime(sdf.parse("20080101"));
		Calendar calendar20080301 = Calendar.getInstance();
		calendar20080301.setTime(sdf.parse("20080301"));
		Calendar calendar20080421 = Calendar.getInstance();
		calendar20080421.setTime(sdf.parse("20080421"));		
		this.calendarList.add(calendar20081010);
		this.calendarList.add(calendar20080101);
		this.calendarList.add(calendar20080301);
		this.calendarList.add(calendar20080421);
		this.calendarOperator = Op.onList(Calendar.class, this.calendarList);
		
		this.integerList.add(Integer.valueOf(10));
		this.integerList.add(Integer.valueOf(0));
		this.integerList.add(Integer.valueOf(20));
		this.integerList.add(Integer.valueOf(10));
		this.integerOperator = Op.onList(Integer.class, this.integerList);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testEachExecUniqStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.calendarOperator.eachExecUniq(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(0));
	}

	public final void testEachExecUniqClassOfXStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.calendarOperator.eachExecUniq(String.class, 
						DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(1));
		
		try {
			assertEquals("Dummy operation result: 1",
					this.calendarOperator.eachExecUniq(Calendar.class, 
							DummyOperationOnOneOrTwoTargets.OPERATION_NAME));
			fail("this.integerOperator.execUniq(Calendar.class, ToJson.OPERATION_NAME) should have failed as it does " +
					"not return a Calendar but a String");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}

	public final void testEach() {
		List<Calendar> updated = new ArrayList<Calendar>();
		for (Calendar calendar : this.calendarList) {
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
		assertEquals(this.calendarList,
				this.calendarOperator.generic().getTargetObjects().get(0));
	}

	public final void testDistinct() {
		assertEquals(this.calendarList, this.calendarOperator.distinct().get());
		
		Calendar aux = Calendar.getInstance();
		this.calendarList.add(aux);
		this.calendarList.add(aux);
		this.calendarList.add(aux);
		assertEquals(this.calendarList.size() - 2, 
				this.calendarOperator.distinct()
				.getTargetObjects().get(0).size());
	}

	public final void testFlat() {
		assertEquals(this.calendarList.get(1),
				this.calendarOperator.flat().getTargetObjects().get(1));
		assertEquals(this.calendarList.size(),
				this.calendarOperator.flat().getTargetObjects().size());
	}

	public final void testAsList() {		
		assertTrue(Types.LIST.isAssignableFrom(
				this.calendarOperator
				.getTargets().get(0).getIntendedType()));
		
		assertTrue(Types.forName("List<Calendar>").isAssignableFrom(
				this.calendarOperator.asList(Calendar.class)
				.getTargets().get(0).getIntendedType()));
				
		assertFalse(this.calendarOperator.asList(Calendar.class)
				.getTargets().get(0).getIntendedType()
				.isAssignableFrom(Types.LIST));		
	}

	public final void testSort() {
		
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarList);
		Collections.sort(aux);
		
		assertEquals(aux,				
				this.calendarOperator.sort()
				.getTargetObjects().get(0));
	}

	public final void testSortComparatorOfQsuperT() {
		
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarList);
		Collections.sort(aux);
		Collections.reverse(aux);
		aux.add(null);
		
		this.calendarList.add(1, null);
		
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
		
		assertEquals(aux, this.calendarOperator
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
		assertEquals(this.calendarList, this.calendarOperator.eachFilter(theFilter)
				.getTargetObjects().get(0));		
	}

	public final void testToSet() {
		Set<Calendar> set = new HashSet<Calendar>(this.calendarList);
		assertEquals(set, this.calendarOperator.toSet().getTargetObjects().get(0));
	}

	public final void testToArray() {
		Calendar[] result1 = (Calendar[]) this.calendarOperator.toArray().getTargetObjects().get(0);
		Calendar[] result2 = this.calendarList.toArray(new Calendar[]{});
		
		assertEquals(result1.length, result2.length);
		for(int index = 0; index < result1.length; index++) {
			assertTrue(result1[index].compareTo(result2[index]) == 0);
		}		
	}

	public final void testGet() {
		assertEquals(this.calendarList,
				this.calendarOperator.get());
	}

	public final void testGetClassOfX() {
		assertEquals(this.calendarList,
				this.calendarOperator.get(Calendar.class));
		
		// as cast is not being done (calendar list is not being iterated) this get methods can be executed
		this.calendarOperator.get(Integer.class);		
	}

	public final void testSize() {
		assertEquals(1, 
				this.calendarOperator.size());
	}

	public final void testRaw() {
		assertEquals(TypeSchemes.forName("List<Calendar>"), 
				this.calendarOperator.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("List<?>"), 
				this.calendarOperator.raw().getTargetTypeScheme());
	}

	public final void testToMapStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.clear();
		
		List<Calendar> values = new ArrayList<Calendar>();
		values.add(cal1);
		values.add(cal2);
		
		Iter0IterableListOperator<Calendar> operator = Op.onList(Calendar.class, values); 
				
		assertEquals(values.get(0),
				operator.toMap("#target.getTimeInMillis() * #param[0]", Integer.valueOf(100))
			.get().get(values.get(0).getTimeInMillis() * 100));
		assertEquals(values.size(),
				operator.toMap("#target.getTimeInMillis() * #param[0]", Integer.valueOf(100))
			.get().values().size());
		
		try {
			operator.toMap("#param[0]", Calendar.getInstance());
			fail("operator.toMap(\"#param[0]\", Calendar.getInstance())"
					+ " should have failed as it would contain repeated keys");
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}
		
		try {
			operator.toMap("#param[0]", new Object[] {new String("test")});
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}
	}

	public final void testToMapClassOfKStringObjectArray() {
		assertEquals(this.integerList.get(0),
				this.integerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.get().get(this.integerList.get(0) * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, Integer>"),
				this.integerOperator.toMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Integer>"),
				this.integerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(new HashSet<Integer>(this.integerList).size(),
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
		assertEquals(this.integerList.get(0),
				this.integerOperator.toMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.integerList.get(0) * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, ?>"),
				this.integerOperator.toMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(new HashSet<Integer>(this.integerList).size(),
				this.integerOperator.toMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().size());
		
		try {
			this.integerOperator.toMap("#param[0]", "#target", Calendar.getInstance());
			fail("this.integerOperator.toMap(\"#param[0]\", \"#target\", Calendar.getInstance())"
					+ " should have failed as it would contain repeated keys");
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}		
	}

	public final void testToMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>").isAssignableFrom(
				this.integerOperator.toMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargets().get(0).getIntendedType()));
			
		try {
			Op.onList(Arrays.asList(new Object[] {Integer.valueOf(10),
					Integer.valueOf(20),
					Integer.valueOf(10)})).toMap(Integer.class, Integer.class, "#target" , "#param[0].nextInt()", new RandomUtils());
			fail("toMap() should have failed as map would contain repeated keys and their value is not the same");
		} catch (DuplicateMapKeyException e) {
			// do nothing
		}	
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
		assertEquals(Arrays.asList(this.integerList.get(0), this.integerList.get(3)),
				this.integerOperator.toListMap("#target * #param[0]", Integer.valueOf(100))
			.get().get(this.integerList.get(0) * 100));
		assertEquals(3,
				this.integerOperator.toListMap("#target * #param[0]", Integer.valueOf(100))
			.get().size());		
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.integerOperator.toListMap("#param[0]", cal).get().size());
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
		assertTrue(this.integerList.equals(this.integerOperator.toListMap(Calendar.class, "#param[0]", cal).get().get(cal)));
	}

	public final void testToListMapStringStringObjectArray() {
		assertEquals(Arrays.asList(this.integerList.get(0), this.integerList.get(3)),
				this.integerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.integerList.get(0) * 100));
		
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

	public final void testToListMapClassOfKClassOfVMapBuilderOfTKV() {
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
		assertEquals(TypeSchemes.forName("List<Calendar>").getName(),
				this.calendarOperator.getTargetTypeScheme().getName());
	}

	public final void testGetTargetObjects() {
		List<Integer> values = new ArrayList<Integer>();
		values.add(Integer.valueOf(10));
		values.add(Integer.valueOf(10));
		values.add(Integer.valueOf(20));
		
		List<List<Integer>> targetObjects = Op.onList(Integer.class, values)				
				.getTargetObjects();
		assertEquals(3, targetObjects.get(0).size());
		assertTrue(values.containsAll(targetObjects
				.get(0)));		
	}

	public final void testCallEachStringObjectArray() {
		assertEquals(Arrays.asList(new String[] {"10", "20", "30", "40"}), 
				Op.onList(Integer.class, Arrays.asList(new Integer[] {10, 20, 30, 40}))
			.eachCall("toString").get());		
	}

	public final void testCallEachClassOfXStringObjectArray() {
		assertEquals(Arrays.asList(new String[] {"10", "20", "30", "40"}), 
				Op.onList(Integer.class, Arrays.asList(new Integer[] {10, 20, 30, 40}))
			.eachCall(String.class, "toString").get());
		
		try {
			Op.onList(Integer.class, null)
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
		assertEquals(new HashSet<Integer>(Arrays.asList(this.integerList.get(0), this.integerList.get(3))),
				this.integerOperator.toSetMap("#target * #param[0]", Integer.valueOf(100))
			.get().get(this.integerList.get(0) * 100));
		assertEquals(3,
				this.integerOperator.toSetMap("#target * #param[0]", Integer.valueOf(100))
			.get().size());		
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.integerOperator.toSetMap("#param[0]", cal).get().size());
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
		assertTrue(new HashSet<Integer>(this.integerList).equals(this.integerOperator.toSetMap(Calendar.class, "#param[0]", cal).get().get(cal)));
	}

	public final void testToSetMapStringStringObjectArray() {
		assertEquals(new HashSet<Integer>(Arrays.asList(this.integerList.get(0), this.integerList.get(3))),
				this.integerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.integerList.get(0) * 100));
		
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
		List result = this.calendarOperator.eachEval("get(#param[0])", Calendar.MILLISECOND)
			.get();
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals(result.get(index++), calendar.get(Calendar.MILLISECOND));
		}
		
		assertEquals(null, this.calendarOperator.eachEval("get(#param[0])", Calendar.MILLISECOND).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("List<?>"), this.calendarOperator.eachEval("get(#param[0])", Calendar.MILLISECOND).getTargetTypeScheme());
	}

	public final void testEachEvalClassOfXStringObjectArray() {
		List result = this.calendarOperator.eachEval(Integer.class, "get(#param[0])", Calendar.MILLISECOND)
			.get();
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals(result.get(index++), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(Types.INTEGER, this.calendarOperator.eachEval(Integer.class, "get(#param[0])", Calendar.MILLISECOND).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("List<Integer>"), this.calendarOperator.eachEval(Integer.class, "get(#param[0])", Calendar.MILLISECOND).getTargetTypeScheme());
	}

	public final void testEachEvalClassOfXEvaluatorOfTX() {
		Evaluator<Calendar, Integer> evaluator = new Evaluator<Calendar, Integer>() {
			public Integer evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).get(Calendar.MILLISECOND);
			}			
		};
		List result = this.calendarOperator.eachEval(Integer.class, evaluator).get();
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals(result.get(index++), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(Types.INTEGER, this.calendarOperator.eachEval(Integer.class, evaluator).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("List<Integer>"), this.calendarOperator.eachEval(Integer.class, evaluator).getTargetTypeScheme());
	}

	public final void testEachEvalEvaluatorOfTObject() {
		Evaluator<Calendar, Object> evaluator = new Evaluator<Calendar, Object>() {
			public Integer evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).get(Calendar.MILLISECOND);
			}			
		};
		List result = this.calendarOperator.eachEval(evaluator).get();
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals(result.get(index++), calendar.get(Calendar.MILLISECOND));
		}

		assertEquals(null, this.calendarOperator.eachEval(evaluator).getOperatorComponentType());
		assertEquals(TypeSchemes.forName("List<?>"), this.calendarOperator.eachEval(evaluator).getTargetTypeScheme());
	}

	public final void testEachToTypeObjectArray() {
		List result = this.integerOperator.eachTo(Types.STRING).get();
		int index = 0;
		for (Object object : result) {
			assertEquals(object, this.integerList.get(index++).toString());
		}
		
		assertEquals(TypeSchemes.forName("List<?>"), this.integerOperator.eachTo(Types.STRING).getTargetTypeScheme());
		assertEquals(null, this.integerOperator.eachTo(Types.STRING).getOperatorComponentType());
	}

	public final void testEachToStringObjectArray() {
		List result = this.integerOperator.eachTo(Types.STRING.getName()).get();
		int index = 0;
		for (Object object : result) {
			assertEquals(object, this.integerList.get(index++).toString());
		}
		
		assertEquals(TypeSchemes.forName("List<?>"), this.integerOperator.eachTo(Types.STRING.getName()).getTargetTypeScheme());
		assertEquals(null, this.integerOperator.eachTo(Types.STRING.getName()).getOperatorComponentType());
	}

	public final void testEachToClassOfXObjectArray() {
		List result = this.integerOperator.eachTo(String.class).get();
		int index = 0;
		for (Object object : result) {
			assertEquals(object, this.integerList.get(index++).toString());
		}
		
		assertEquals(TypeSchemes.forName("List<String>"), this.integerOperator.eachTo(String.class).getTargetTypeScheme());
		assertEquals(Types.STRING, this.integerOperator.eachTo(String.class).getOperatorComponentType());
	}
    
}
