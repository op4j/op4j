package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import junit.framework.TestCase;

import org.apache.commons.collections.SetUtils;
import org.op4j.Op;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.executables.ISelect;
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableMapOperatorTest extends TestCase {

	Iter0IterableMapOperator<Integer, Calendar> integerCalendarOperator;
	Iter0IterableMapOperator<Integer, String> integerStringOperator;
	final List<Integer> keys = new ArrayList<Integer>();
	final List<Calendar> calendarValues = new ArrayList<Calendar>();
	final List<String> stringValues = new ArrayList<String>();
	Map<Integer, Calendar> integerCalendarMap = new HashMap<Integer, Calendar>();
	Map<Integer, String> integerStringMap = new HashMap<Integer, String>();
	
	protected void setUp() throws Exception {
		super.setUp();
		
		Operations.addOperationImplementation(DummyOperationOnOneOrTwoTargets.class);
				
		this.keys.add(Integer.valueOf(10));
		this.keys.add(Integer.valueOf(20));
		this.keys.add(Integer.valueOf(30));
		this.keys.add(Integer.valueOf(5));
		
		String pattern = "yyyyMMdd-HH:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Calendar calendar200810101400 = Calendar.getInstance();
		calendar200810101400.setTime(sdf.parse("20081010-14:00"));
		Calendar calendar200811101300 = Calendar.getInstance();
		calendar200811101300.setTime(sdf.parse("20081110-13:00"));
		Calendar calendar200611100000 = Calendar.getInstance();
		calendar200611100000.setTime(sdf.parse("20061110-00:00"));
		
		this.calendarValues.add(calendar200810101400);
		this.calendarValues.add(calendar200811101300);
		this.calendarValues.add(calendar200611100000);
		this.calendarValues.add(calendar200810101400);
				
		this.stringValues.add("first");
		this.stringValues.add("second");
		this.stringValues.add("first");
		
		this.integerCalendarMap.put(this.keys.get(0), this.calendarValues.get(0));
		this.integerCalendarMap.put(this.keys.get(1), this.calendarValues.get(1));
		this.integerCalendarMap.put(this.keys.get(2), this.calendarValues.get(2));
		this.integerCalendarMap.put(this.keys.get(3), this.calendarValues.get(3));
		
		this.integerStringMap.put(this.keys.get(0), this.stringValues.get(0));
		this.integerStringMap.put(this.keys.get(1), this.stringValues.get(1));
		this.integerStringMap.put(this.keys.get(2), this.stringValues.get(0));
		
		this.integerStringOperator = Op.onMap(Integer.class, String.class, this.integerStringMap);
		this.integerCalendarOperator = Op.onMap(Integer.class, Calendar.class, this.integerCalendarMap);
			
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testEachValueExecStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.integerCalendarOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
				.get().get(this.keys.get(0)).toString());
		
		assertEquals(null,
				this.integerCalendarOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorValueType());		
	}

	public final void testEachValueExecClassOfXStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.integerCalendarOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(this.keys.get(1)).toString());
		
		assertEquals(Types.STRING,
				this.integerCalendarOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorValueType());
		
		try {
			assertEquals("Dummy operation result: 1",
					this.integerCalendarOperator.eachValueExec(Long.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME));
			fail("this.integerCalendarOperator.exec(Long.class, ToJson.OPERATION_NAME) should have failed as the result is not a Long but a String");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}

	@SuppressWarnings("unchecked")
	public final void testSortKeys() {		
		Set<Integer> aux = new HashSet<Integer>(this.keys);		
		aux = SetUtils.orderedSet(aux);
		
		assertEquals(aux, 
				this.integerCalendarOperator.sortKeys().get().keySet());
	}

	public final void testSortKeysComparatorOfQsuperK() {
		List<Integer> aux = new ArrayList<Integer>(this.keys);		
		
		Comparator<Integer> theComparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1 == null) {
					return 1;
				}
				if (o2 == null) {
					return -1;
				}
				return o2.compareTo(o1);
			}			
		};
		
		Collections.sort(aux, theComparator);
		
		assertEquals(aux.size(), this.integerCalendarOperator.sortKeys(theComparator).get().keySet().size());
		int index = 0;
		for (Map.Entry<Integer, Calendar> entry : this.integerCalendarOperator.sortKeys(theComparator).get().entrySet()) {
			assertTrue(entry.getKey().compareTo(aux.get(index)) == 0);
			index++;
		}
	}

	@SuppressWarnings("unchecked")
	public final void testSortValues() {
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarValues);		
		Collections.sort(aux);
		
		assertEquals(aux.size(), this.integerCalendarOperator.sortValues().get().values().size());
		int index = 0;
		for (Map.Entry<Integer, Calendar> entry : this.integerCalendarOperator.sortValues().get().entrySet()) {
			assertTrue(entry.getValue().compareTo(aux.get(index)) == 0);
			index++;
		}		
	}

	public final void testSortValuesComparatorOfQsuperV() {
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarValues);		
		
		Comparator<Calendar> theComparator = new Comparator<Calendar>() {
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
		
		Collections.sort(aux, theComparator);
		
		assertEquals(aux.size(), this.integerCalendarOperator.sortValues(theComparator).get().keySet().size());
		int index = 0;
		for (Map.Entry<Integer, Calendar> entry : this.integerCalendarOperator.sortValues(theComparator).get().entrySet()) {
			assertTrue(entry.getValue().compareTo(aux.get(index)) == 0);
			index++;
		}
	}

	public final void testEachValue() {
		List<Integer> list = new ArrayList<Integer>();
		for (Calendar calendar : this.calendarValues) {
			list.add(Integer.valueOf(calendar.get(Calendar.YEAR)));
		}
		assertTrue(list.containsAll( 
				this.integerCalendarOperator.eachValue()
				.eval("#target.get(#param[0])", Calendar.YEAR)
				.uneachList(Integer.class).getTargetObjects().get(0)));
		assertTrue(this.integerCalendarOperator.eachValue()
				.eval("#target.get(#param[0])", Calendar.YEAR)
				.uneachList(Integer.class).getTargetObjects().get(0)
				.containsAll(list));
		assertEquals(list.size(), this.integerCalendarOperator.eachValue()
				.eval("#target.get(#param[0])", Calendar.YEAR)
				.uneachList(Integer.class).getTargetObjects().get(0).size());
	}

	public final void testEachKey() {
		List<String> list = new ArrayList<String>();
		for (Integer integer : this.keys) {
			list.add(integer.toString());
		}
		assertTrue(list.containsAll( 
				this.integerCalendarOperator.eachKey()
				.eval("toString()")
				.uneachList(String.class).getTargetObjects().get(0)));
		assertTrue(this.integerCalendarOperator.eachKey()
				.eval("toString()")
				.uneachList(String.class).getTargetObjects().get(0)
				.containsAll(list));
		assertEquals(list.size(), this.integerCalendarOperator.eachKey()
				.eval("toString()")
				.uneachList(String.class).getTargetObjects().get(0).size());
	}

	public final void testEachEntry() {
		List<Integer> result = new ArrayList<Integer>();
		for (String string : this.stringValues) {
			result.add(Integer.valueOf(string.length()));
		}
		
		assertEquals(result.size(),
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargetObjects().get(0).values().size());
		assertTrue(result.containsAll(
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargetObjects().get(0).values()));
		assertTrue(this.integerStringOperator.eachEntry().evalOnValue("length()")
				.uneachMap().getTargetObjects().get(0).values()
				.containsAll(result));
	}

	public final void testAsListMap() {
		assertTrue(Types.forName("Map<Integer, List<String>>")
				.isAssignableFrom(
						this.integerStringOperator
						.asListMap(Integer.class, String.class)
						.getTargets().get(0).getIntendedType()));		
	}

	public final void testAsMap() {
		assertTrue(Types.MAP.isAssignableFrom(
				this.integerStringOperator
				.asMap(Integer.class, String.class)
				.getTargets().get(0).getIntendedType()));
		assertTrue(Types.forName("Map<Integer, String>").isAssignableFrom(
				this.integerStringOperator
				.asMap(Integer.class, String.class)
				.getTargets().get(0).getIntendedType()));
		assertFalse(Types.forName("Map<Integer, String>").isAssignableFrom(
				this.integerStringOperator
				.asMap(Object.class, Object.class)
				.getTargets().get(0).getIntendedType()));				
	}

	public final void testGeneric() {
		assertEquals(this.integerCalendarMap, 
				this.integerCalendarOperator.generic().getTargetObjects().get(0));
	}

	public final void testFilterEachEntryStringObjectArray() {
		assertTrue(this.integerCalendarOperator
				.eachFilterEntry("getValue().before(#param[0])", Calendar.getInstance())
				.get().isEmpty());
	}

	public final void testFilterEachEntryFilterOfEntryOfKV() {
		
		ISelect<Map.Entry<Integer, Calendar>> theFilter = new ISelect<Map.Entry<Integer, Calendar>>() {
			public boolean eval(
					SelectorContext<Entry<Integer, Calendar>> ctx) {
				return Arrays.asList(Iter0IterableMapOperatorTest.this.keys.get(0), Iter0IterableMapOperatorTest.this.keys.get(2)).contains(
						ctx.getTarget(0).getKey());
			}			
		};
		
		this.integerCalendarOperator.eachFilterEntry(theFilter);		
	}

	public final void testKeySet() {
		assertTrue(this.keys.containsAll(
				this.integerCalendarOperator.keySet().getTargetObjects().get(0)));
		assertTrue(this.integerCalendarOperator.keySet().getTargetObjects().get(0).containsAll(
				this.keys));
		assertEquals(this.keys.size(),
				this.integerCalendarOperator.keySet().getTargetObjects().get(0).size());
	}

	public final void testValues() {
		assertEquals(this.calendarValues.size(), this.integerCalendarOperator
				.values().getTargetObjects().get(0).size());
		assertTrue(this.calendarValues.containsAll(
				this.integerCalendarOperator.values().getTargetObjects().get(0)));
		assertTrue(this.integerCalendarOperator.values().getTargetObjects().get(0)
				.containsAll(this.calendarValues));
	}

	public final void testGet() {
		assertEquals(this.integerCalendarMap, this.integerCalendarOperator.get());
	}

	public final void testGetClassOfXClassOfY() {
		this.integerStringOperator.get(Integer.class, String.class);
		assertEquals(this.integerStringMap,
				this.integerStringOperator.get(Integer.class, String.class));
		
		// as cast is not being done (map is not being iterated) this get methods can be executed
		this.integerStringOperator.get(Long.class, Long.class);	
		assertEquals(this.integerStringMap,
				this.integerStringOperator.get(Long.class, Long.class));
	}

	public final void testSize() {
		assertEquals(1, 
				this.integerCalendarOperator.size());
	}

	public final void testRaw() {
		assertEquals(TypeSchemes.forName("Map<Integer, Calendar>"), 
				this.integerCalendarOperator.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<?, ?>"), 
				this.integerCalendarOperator.raw().getTargetTypeScheme());
	}

	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Map<?, ?>"), Op.onMap(null).getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Calendar>"), 
				this.integerCalendarOperator.getTargetTypeScheme());	
	}

	public final void testGetTargetObjects() {
		List<Map<Integer, String>> targetObjects = Op.onAll(
				Integer.valueOf(10), "a", 
				Integer.valueOf(20), "b",
				Integer.valueOf(30), "c").buildMap(Integer.class, String.class)
				.getTargetObjects();
		assertEquals(3, targetObjects.get(0).size());
		assertTrue("a".compareTo(targetObjects
				.get(0)
				.get(Integer.valueOf(10))) == 0);		
	}

	public final void testCallEachValueStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(20), cal2,
				Integer.valueOf(30), cal3).buildMap(Integer.class, Calendar.class)
				.eachValueCall("get", Calendar.MILLISECOND);
		assertEquals(3, result.get().size());
		assertEquals(Integer.valueOf(cal1.get(Calendar.MILLISECOND)), result.get().get(Integer.valueOf(10)));	
		assertEquals(TypeSchemes.forName("Map<Integer, ?>"), result.getTargetTypeScheme());
	}

	public final void testCallEachValueClassOfXStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		Iter0IterableMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal1,
				Integer.valueOf(20), cal2).buildMap(Integer.class, Calendar.class)
				.eachValueCall(Integer.class, "get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertEquals(cal1.get(Calendar.MILLISECOND), result.get().get(Integer.valueOf(10)));
		assertEquals(TypeSchemes.forName("Map<Integer, Integer>"), result.getTargetTypeScheme());
	}
	
	public final void testAsSetMap() {
		assertTrue(Types.forName("Map<Integer, Set<String>>")
				.isAssignableFrom(
						this.integerStringOperator
						.asSetMap(Integer.class, String.class)
						.getTargets().get(0).getIntendedType()));		
	}

}
