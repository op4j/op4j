package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.Op;
import org.op4j.commands.IMapBuild;
import org.op4j.commands.ISelect;
import org.op4j.exceptions.DuplicateMapKeyException;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.exceptions.NullTargetException;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableArrayOperatorTest extends TestCase {

	private Calendar aCalendar200006221300;
	private String pattern;
	private Integer[] anIntegerArray;
	private Calendar[] aCalendarArray;	
	
	Iter0IterableArrayOperator<Integer> anIntegerOperator;
	Iter0IterableArrayOperator<Calendar> aCalendarOperator;
	Iter0IterableArrayOperator<Object> anObjectOperator;
	
	private Iter0IterableArrayOperator<?> nullOperator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.aCalendar200006221300 = Calendar.getInstance();
		this.aCalendar200006221300.set(Calendar.YEAR, 2000);
		this.aCalendar200006221300.set(Calendar.MONTH, 05);
		this.aCalendar200006221300.set(Calendar.DAY_OF_MONTH, 22);
		this.aCalendar200006221300.set(Calendar.HOUR_OF_DAY, 13);
		this.aCalendar200006221300.set(Calendar.MINUTE, 0);
		this.aCalendar200006221300 = DateUtils.truncate(this.aCalendar200006221300, Calendar.MINUTE);
		
		this.pattern = "yyyyMMdd-HH:mm";
		
		this.anIntegerArray = new Integer[4];
		this.anIntegerArray[0] = Integer.valueOf(10);
		this.anIntegerArray[1] = Integer.valueOf(20);
		this.anIntegerArray[2] = Integer.valueOf(30);
		this.anIntegerArray[3] = Integer.valueOf(40);
		
		this.aCalendarArray = new Calendar[4];
		this.aCalendarArray[0] = this.aCalendar200006221300;
		Calendar aux = Calendar.getInstance();
		aux.setTimeInMillis(this.aCalendar200006221300.getTimeInMillis());
		aux.add(Calendar.DAY_OF_MONTH, 1);
		this.aCalendarArray[1] = aux;
		aux.add(Calendar.DAY_OF_MONTH, 1);
		this.aCalendarArray[2] = aux;
		aux.add(Calendar.DAY_OF_MONTH, 1);
		this.aCalendarArray[3] = aux;
		
		this.anIntegerOperator = Op.onArray(Integer.class, this.anIntegerArray);
		this.aCalendarOperator = Op.onArray(Calendar.class, this.aCalendarArray);	
		this.anObjectOperator = Op.onArray(Object.class, new Object[] {
				Integer.valueOf(10), Calendar.getInstance(),
				Integer.valueOf(20), Calendar.getInstance()});	
		
		this.nullOperator =
			Op.onArray(null);	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testEach() {
		String[] result = this.aCalendarOperator.each().convToString(this.pattern).uneachArray().get();
		SimpleDateFormat sdf = new SimpleDateFormat(this.pattern);
		for (int index = 0; index < this.aCalendarArray.length; index++) {
			assertEquals(sdf.format(this.aCalendarArray[index].getTime()), result[index]);
		}
		assertTrue(Calendar.class.isAssignableFrom(this.aCalendarOperator.each()
				.getTargets().get(0).get().getClass()));
	}

	public final void testGeneric() {	
		assertTrue(Types.forName("Integer[]").isAssignableFrom(
				this.anIntegerOperator.generic().getTargets().get(0).getIntendedType()));
	}

	public final void testDistinct() {
		Integer[] aux = new Integer[] {Integer.valueOf(10),
				Integer.valueOf(20), Integer.valueOf(30),
				Integer.valueOf(20)};
		assertEquals(4, Op.onArray(aux).getTargetObjects().get(0).length);
		assertEquals(3, Op.onArray(aux).distinct().getTargetObjects().get(0).length);
		assertFalse(ArrayUtils.lastIndexOf(Op.onArray(aux).getTargetObjects().get(0), Integer.valueOf(20)) == 
				ArrayUtils.lastIndexOf(Op.onArray(aux).distinct().getTargetObjects().get(0), Integer.valueOf(20)));
	}

	public final void testFlat() {
		List<Calendar> flatten = this.aCalendarOperator.flat().getTargetObjects();
		for (Calendar calendar : flatten) {
			assertEquals(this.aCalendarArray[flatten.indexOf(calendar)],
					calendar);
		}
	}

	public final void testAsArray() {
		Iter0IterableArrayOperator<?> operator = Op.onArray(new Integer[] {Integer.valueOf(10), Integer.valueOf(20)});
		assertTrue(Types.forName("Integer[]").isAssignableFrom(
			operator.asArray(Integer.class).getTargets().get(0).getIntendedType()));
		try {
			Op.onArray(new Object[] {Integer.valueOf(10), Integer.valueOf(20)})
				.asArray(Integer.class);
			fail("asArray(Integer.class) should have failed as the array is not an Integer[] but an Object[]");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	public final void testSort() {
		Integer[] aux = new Integer[] {Integer.valueOf(20), Integer.valueOf(40),
				Integer.valueOf(10), Integer.valueOf(30)};
		Integer[] auxSorted = Op.onArray(Integer.class, aux).sort().get();
		int index = 1;
		for (Integer integer : auxSorted) {
			assertEquals(index * 10, integer.intValue());
			index++;
		}
	}

	public final void testSortComparatorOfQsuperT() {
		Integer[] aux = new Integer[] {Integer.valueOf(20), Integer.valueOf(40),
				Integer.valueOf(10), Integer.valueOf(30)};
		Integer[] auxSorted = Op.onArray(Integer.class, aux).sort(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o1.intValue() - o2.intValue();
			}			
		}).get();
		int index = 1;
		for (Integer integer : auxSorted) {
			assertEquals(index * 10, integer.intValue());
			index++;
		}
	}

	public final void testFilterEachStringObjectArray() {
		assertEquals(2, 
				this.anIntegerOperator
				.eachFilter("#target - #param[0] > 0", Integer.valueOf(20))
				.get().length);
		assertEquals(0, 
				this.aCalendarOperator
				.eachFilter("#target.before(#param[0])", Calendar.getInstance())
				.get().length);		
	}

	public final void testFilterEachFilterOfT() {
		assertEquals(0, this.anIntegerOperator.eachFilter(new ISelect<Integer>() {

			public boolean eval(SelectorContext<Integer> ctx) {
				// do not include the data
				return true;
			}
		}).get().length);
		
		assertEquals(3, this.anIntegerOperator.eachFilter(new ISelect<Integer>() {
			public boolean eval(SelectorContext<Integer> ctx) {
				return ctx.getTarget(0).intValue() >= 40;
			}
		}).get().length);
	}

	public final void testToList() {
		assertTrue(Types.forName("List<?>").isAssignableFrom(
				this.anObjectOperator.toList().getTargets().get(0).getIntendedType()));
				
		assertTrue(List.class.isAssignableFrom(
				Op.onArray(new Object[] {Integer.valueOf(10), "The value is 10",
				Integer.valueOf(20), "The value is 20",
				Integer.valueOf(10), "The value is 10 again"}).toList().get().getClass()));
		
		assertTrue(Types.forName("List<?>").isAssignableFrom(
				this.aCalendarOperator.toList().getTargets().get(0).getIntendedType()));
	}

	public final void testToSet() {
		assertTrue(Types.forName("Set<?>").isAssignableFrom(
				this.anObjectOperator.toSet().getTargets().get(0).getIntendedType()));
					
		assertTrue(Set.class.isAssignableFrom(
				Op.onArray(new Object[] {Integer.valueOf(10), "The value is 10",
				Integer.valueOf(20), "The value is 20",
				Integer.valueOf(10), "The value is 10 again"}).toSet().get().getClass()));
		
		assertTrue(Types.forName("Set<?>").isAssignableFrom(
				this.anIntegerOperator.toSet().getTargets().get(0).getIntendedType()));			
	}

	public final void testGet() {
		assertEquals(this.anIntegerArray, 
				this.anIntegerOperator.get());
		assertEquals(this.aCalendarArray, 
				this.aCalendarOperator.get());
	}

	public final void testGetClassOfX() {
		Iter0IterableArrayOperator<?> operator = Op.onArray(new Calendar[] {
				Calendar.getInstance(), Calendar.getInstance()
		});
		
		operator.get(Calendar.class);
		
		try {
			operator.get(Integer.class);
			fail("get(Integer.class) should have failed as the array is not an Integer[] but a Calendar[]");
		} catch (IllegalArgumentException e) {
			// do nothing
		}	
	}

	public final void testSize() {
		assertEquals(1, this.anIntegerOperator.size());
	}
	
	public final void testRaw() {
		assertEquals(Types.CALENDAR,
				this.aCalendarOperator.getOperatorComponentType());
		assertEquals(null,
				this.aCalendarOperator.raw().getOperatorComponentType());		
	}

	public final void testEachExec() {
		assertEquals(Types.forName("String[]"),
			Op.onArray(Calendar.class, new Calendar[] {Calendar.getInstance(), Calendar.getInstance()})
				.eachExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargetTypeScheme().getType(0));
		assertEquals(null,
				Op.onArray(Calendar.class, new Calendar[] {Calendar.getInstance(), Calendar.getInstance()})
					.eachExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorComponentType());
	}

	public final void testEachExecStringObjectArray() {
		Calendar[] calArray = new Calendar[] {Calendar.getInstance(), Calendar.getInstance()};
		
		String[] expectedResults = new String[] {
				"Dummy operation result: 1", "Dummy operation result: 1"};
		
		assertTrue(Arrays.equals(expectedResults,
				Op.onArray(Calendar.class, calArray)
					.eachExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get()));	
	}

	public final void testEachExecClassOfXStringObjectArray() {
		Calendar[] calArray = new Calendar[] {Calendar.getInstance(), Calendar.getInstance()};
		
		String[] expectedResults = new String[] {"Dummy operation result: 1", "Dummy operation result: 1"};
		
		assertTrue(Arrays.equals(expectedResults, 
				Op.onArray(Calendar.class, calArray)
					.eachExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get()));	
		
		try {
			Op.onArray(Calendar.class, calArray)
						.eachExec(Integer.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get();	
			fail("Call to exec(Integer.class, ToJson.OPERATION_NAME) should have failed");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}

	public final void testCallEachStringObjectArray() {
		assertEquals(Arrays.toString(new String[] {"10", "20", "30", "40"}), 
				Arrays.toString(Op.onArray(Integer.class, new Integer[] {10, 20, 30, 40})
			.eachCall("toString").get()));		
	}

	public final void testCallEachClassOfXStringObjectArray() {
		assertEquals(Arrays.toString(new String[] {"10", "20", "30", "40"}), 
				Arrays.toString(Op.onArray(Integer.class, new Integer[] {10, 20, 30, 40})
			.eachCall(String.class, "toString").get()));
		
		try {
			Op.onArray(Integer.class, null)
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
	
	@SuppressWarnings("boxing")
	public final void testToMapStringObjectArray() {
		
		assertEquals(this.anIntegerArray[0],
				this.anIntegerOperator.toMap("#target * #param[0]", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toMap("#target * #param[0]", Integer.valueOf(100))
			.get().size());
		
		try {
			this.anIntegerOperator.toMap("#param[0]", Calendar.getInstance());
			fail("this.anIntegerOperator.toMap(\"#param[0]\", Calendar.getInstance())"
					+ " should have failed as it would contain repeated keys");
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}
		
		try {
			this.anIntegerOperator.toMap("#param[0]", new Object[] {new String("test")});
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}
	}

	public final void testToMapClassOfKStringObjectArray() {
		assertEquals(this.anIntegerArray[0],
				this.anIntegerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, Integer>"),
				this.anIntegerOperator.toMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Integer>"),
				this.anIntegerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.get().size());
		
		try {
			this.anIntegerOperator.toMap(Calendar.class, "#param[0]", Calendar.getInstance());
			fail("this.anIntegerOperator.toMap(Calendar.class, \"#param[0]\", Calendar.getInstance())"
					+ " should have failed as it would contain repeated keys");
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}
		
		try {
			this.anIntegerOperator.toMap(String.class, "#param[0]", new Object[] {new String("test")});
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}
	}

	public final void testToMapStringStringObjectArray() {
		assertEquals(this.anIntegerArray[0],
				this.anIntegerOperator.toMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, ?>"),
				this.anIntegerOperator.toMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().size());
		
		try {
			this.anIntegerOperator.toMap("#param[0]", "#target", Calendar.getInstance());
			fail("this.anIntegerOperator.toMap(\"#param[0]\", \"#target\", Calendar.getInstance())"
					+ " should have failed as it would contain repeated keys");
		} catch(DuplicateMapKeyException e) {
			// do nothing
		}				
	}

	@SuppressWarnings("unchecked")
	public final void testToMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>").isAssignableFrom(
				this.anIntegerOperator.toMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargets().get(0).getIntendedType()));
			
		try {
			Op.onArray(new Object[] {Integer.valueOf(10),
					Integer.valueOf(20),
					Integer.valueOf(10)}).toMap(Integer.class, Integer.class, "#target" , "#param[0].nextInt()", new RandomUtils());
			fail("toMap() should have failed as map would contain repeated keys and their value is not the same");
		} catch (DuplicateMapKeyException e) {
			// do nothing
		}	
	}

	public final void testToMapClassOfKClassOfVMapBuilderOfKVT() {
		assertEquals(TypeSchemes.forName("Map<Calendar, Integer>"),
				this.aCalendarOperator.toMap(Calendar.class, Integer.class, new IMapBuild<Calendar, Calendar, Integer>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			
		try {
			final Calendar cal = Calendar.getInstance();
			this.aCalendarOperator.toMap(Calendar.class, Integer.class, new IMapBuild<Calendar, Calendar, Integer>() {
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
				this.aCalendarOperator.toMap(new IMapBuild<Calendar, Object, Object>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			
		try {
			final Calendar cal = Calendar.getInstance();
			this.aCalendarOperator.toMap(new IMapBuild<Calendar, Object, Object>() {
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
		assertEquals(Arrays.asList(this.anIntegerArray[0]),
				this.anIntegerOperator.toListMap("#target * #param[0]", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toListMap("#target * #param[0]", Integer.valueOf(100))
			.get().size());		
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.anIntegerOperator.toListMap("#param[0]", cal).get().size());
	}

	public final void testToListMapClassOfKStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, List<Integer>>"),
				this.anIntegerOperator.toListMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, List<Integer>>"),
				this.anIntegerOperator.toListMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.anIntegerOperator.toListMap(Calendar.class, "#param[0]", cal).size());
		assertTrue(Arrays.equals(this.anIntegerArray, this.anIntegerOperator.toListMap(Calendar.class, "#param[0]", cal).get().get(cal).toArray()));
		
	}

	public final void testToListMapStringStringObjectArray() {
		assertEquals(Arrays.asList(this.anIntegerArray[0]),
				this.anIntegerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"),
				this.anIntegerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toListMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().size());
	}

	public final void testToListMapClassOfKClassOfVStringStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"),
				this.anIntegerOperator.toListMap("#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());
			
		assertEquals(TypeSchemes.forName("Map<Integer, List<Long>>"),
				this.anIntegerOperator.toListMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());				
	}

	public final void testToListMapClassOfKClassOfVMapBuilderOfKVT() {
		assertEquals(TypeSchemes.forName("Map<Calendar, List<Integer>>"),
				this.aCalendarOperator.toListMap(Calendar.class, Integer.class, new IMapBuild<Calendar, Calendar, Integer>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
	}

	public final void testToListMapMapBuilderOfObjectObjectT() {
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"),
				this.aCalendarOperator.toListMap(new IMapBuild<Calendar, Object, Object>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			

		final Calendar cal = Calendar.getInstance();
		assertEquals(1, this.aCalendarOperator.toListMap(new IMapBuild<Calendar, Object, Object>() {
			public Calendar getKey(Calendar target) {
				return cal;
			}
			public Integer getValue(Calendar target) {
				return target.get(Calendar.MILLISECOND) + RandomUtils.nextInt();
			}					 
		}).size());			
	}

	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Calendar[]").getName(),
				this.aCalendarOperator.getTargetTypeScheme().getName());		
	}

	public final void testGetTargetObjects() {
		assertEquals(this.aCalendarArray,
				this.aCalendarOperator.getTargetObjects().get(0));
		assertEquals(1,
				this.aCalendarOperator.getTargetObjects().size());
	}
	
	public final void testToSetMapStringObjectArray() {
		assertEquals(new HashSet<Integer>(Arrays.asList(this.anIntegerArray[0])),
				this.anIntegerOperator.toSetMap("#target * #param[0]", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toSetMap("#target * #param[0]", Integer.valueOf(100))
			.get().size());		
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.anIntegerOperator.toSetMap("#param[0]", cal).get().size());
	}

	public final void testToSetMapClassOfKStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, Set<Integer>>"),
				this.anIntegerOperator.toSetMap("#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Integer>>"),
				this.anIntegerOperator.toSetMap(Integer.class, "#target * #param[0]", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		Calendar cal = Calendar.getInstance();
		assertEquals(1, this.anIntegerOperator.toSetMap(Calendar.class, "#param[0]", cal).size());
		assertTrue(Arrays.equals(this.anIntegerArray, this.anIntegerOperator.toSetMap(Calendar.class, "#param[0]", cal).get().get(cal).toArray()));
		
	}

	public final void testToSetMapStringStringObjectArray() {
		assertEquals(new HashSet<Integer>(Arrays.asList(this.anIntegerArray[0])),
				this.anIntegerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().get(this.anIntegerArray[0] * 100));
		
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"),
				this.anIntegerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.getTargetTypeScheme());
		
		assertEquals(this.anIntegerArray.length,
				this.anIntegerOperator.toSetMap("#target * #param[0]", "#target", Integer.valueOf(100))
			.get().size());
	}

	public final void testToSetMapClassOfKClassOfVStringStringObjectArray() {
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"),
				this.anIntegerOperator.toSetMap("#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());
			
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Long>>"),
				this.anIntegerOperator.toSetMap(Integer.class, Long.class, "#target" , "#param[0].getTimeInMillis()", 
						Calendar.getInstance()).getTargetTypeScheme());	
	}

	public final void testToSetMapClassOfKClassOfVMapBuilderOfTKV() {
		assertEquals(TypeSchemes.forName("Map<Calendar, Set<Integer>>"),
				this.aCalendarOperator.toSetMap(Calendar.class, Integer.class, new IMapBuild<Calendar, Calendar, Integer>() {
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
				this.aCalendarOperator.toSetMap(new IMapBuild<Calendar, Object, Object>() {
					public Calendar getKey(Calendar target) {
						return target;
					}
					public Integer getValue(Calendar target) {
						return target.get(Calendar.MILLISECOND);
					}					 
				}).getTargetTypeScheme());
			

		final Calendar cal = Calendar.getInstance();
		assertEquals(1, this.aCalendarOperator.toSetMap(new IMapBuild<Calendar, Object, Object>() {
			public Calendar getKey(Calendar target) {
				return cal;
			}
			public Integer getValue(Calendar target) {
				return target.get(Calendar.MILLISECOND) + RandomUtils.nextInt();
			}					 
		}).size());			
	}

}
