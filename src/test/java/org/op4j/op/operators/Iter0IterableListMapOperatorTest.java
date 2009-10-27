package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.op4j.Op;
import org.op4j.commands.IEval;
import org.op4j.commands.ISelect;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableListMapOperatorTest extends TestCase {

	Iter0IterableListMapOperator<Integer, String> integerStringListOperator;
	List<String> stringValues = new ArrayList<String>();
	List<Integer> keys = new ArrayList<Integer>();
	
	List<Calendar> calendarValues = new ArrayList<Calendar>();
	Iter0IterableListMapOperator<Integer, Calendar> integerCalendarListOperator;
		
	protected void setUp() throws Exception {
		super.setUp();
		
		Operations.addOperationImplementation(DummyOperationOnOneOrTwoTargets.class);
		
		this.keys.add(Integer.valueOf(10));
		this.keys.add(Integer.valueOf(20));
		
		this.stringValues.add("10 - a value");
		this.stringValues.add("10 - another value");
		this.stringValues.add("20 - a value");
		this.integerStringListOperator = Op.onAll(
				Integer.valueOf(10), "10 - a value", 
				Integer.valueOf(10), "10 - another value",
				Integer.valueOf(20), "20 - a value").buildListMap(Integer.class, String.class);
		
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.integerCalendarListOperator = Op.onAll(
				Integer.valueOf(10), this.calendarValues.get(0), 
				Integer.valueOf(10), this.calendarValues.get(1),
				Integer.valueOf(20), this.calendarValues.get(2)).buildListMap(Integer.class, Calendar.class);	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testEachValueExecStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.integerCalendarListOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
				.get().get(this.keys.get(0)).get(0));
		assertEquals(null,
				this.integerCalendarListOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
				.getOperatorValueType());
		
	}

	public final void testEachValueExecClassOfXStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.integerCalendarListOperator.eachValueExec(String.class, 
						DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(this.keys.get(1)).get(0).toString());
		
		try {
			this.integerCalendarListOperator.eachValueExec(Integer.class, 
					DummyOperationOnOneOrTwoTargets.OPERATION_NAME);
			fail("integerStringListOperator.exec(Integer.class, ToJson.OPERATION_NAME) should have failed as it does not return an Integer but a String");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}

	@SuppressWarnings("unchecked")
	public final void testSortKeys() {
		Iter0IterableListMapOperator<Integer, String> operator = Op.onAll(Integer.valueOf(30), "Key is 30",
				Integer.valueOf(40), "Key is 40",
				Integer.valueOf(10), "Key is 10",
				Integer.valueOf(35), "Key is 35").buildListMap(Integer.class, String.class);
		Set<Integer> keysUnsorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(30), Integer.valueOf(40), Integer.valueOf(10),Integer.valueOf(35)));
		Set<Integer> keysSorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(35), Integer.valueOf(40)));
		
		assertEquals(keysUnsorted, operator.get().keySet());
		assertEquals(keysSorted, operator.sortKeys().get().keySet());		
	}

	@SuppressWarnings("unchecked")
	public final void testSortKeysComparatorOfQsuperK() {
		Iter0IterableListMapOperator<String, Integer> operator = Op.onAll(
				"a", Integer.valueOf(1),
				"c", Integer.valueOf(3),
				"d", Integer.valueOf(4),
				"b", Integer.valueOf(2)).buildListMap(String.class, Integer.class);
		
		Comparator<String> comparator = new Comparator<String>() {
			public int compare(String first, String second) {
				if (first == null) {
					return 1;
				}
				if (second == null) {
					return -1;
				}
				return second.compareTo(first);
			}			
		};
		
		Set<String> keysSorted = new LinkedHashSet<String>();
		keysSorted.add("d");
		keysSorted.add("c");
		keysSorted.add("b");
		keysSorted.add("a");
		
		assertEquals(keysSorted, operator.sortKeys(comparator).keySet().get());
	}

	@SuppressWarnings("unchecked")
	public final void testSortValueLists() {
		List<Integer> valuesSorted = Arrays.asList(
				Integer.valueOf(1), Integer.valueOf(2), 
				Integer.valueOf(3), Integer.valueOf(4));
		assertEquals(valuesSorted, 
			Op.onAll("a", Integer.valueOf(2),
					"a", Integer.valueOf(3), 
					"a", Integer.valueOf(4), 
					"b", Integer.valueOf(1),
					"a", Integer.valueOf(1)).buildListMap(String.class, Integer.class).sortValueLists().get().get("a"));
	}

	@SuppressWarnings("unchecked")
	public final void testSortValueListsComparatorOfQsuperV() {
		List<Integer> valuesSorted = Arrays.asList(
				Integer.valueOf(4), Integer.valueOf(3),
				Integer.valueOf(2), Integer.valueOf(1), null, null);
		Comparator<Integer> comparator = new Comparator<Integer>() {
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
		assertEquals(valuesSorted, 
			Op.onAll("a", Integer.valueOf(2),
					"a", Integer.valueOf(3), 
					"a", Integer.valueOf(4), 
					"a", null,
					"b", Integer.valueOf(1),
					"a", null,
					"a", Integer.valueOf(1)).buildListMap(String.class, Integer.class).sortValueLists(comparator).get().get("a"));
	}

	public final void testEachValue() {
		assertEquals(Arrays.asList("10 - a value - modified", "10 - another value - modified", "20 - a value - modified"),
				this.integerStringListOperator.eachValue()
			.eval("#target + #param[0]", " - modified")
			.uneachList(String.class).get());
	}

	public final void testEachKey() {
		assertEquals(Arrays.asList(Integer.valueOf(110), Integer.valueOf(120)),
				this.integerStringListOperator.eachKey()
			.eval("#target + #param[0]", Integer.valueOf(100))
			.uneachList(Integer.class).get());
	}

	public final void testEachEntry() {
		assertEquals(Arrays.asList("The key has the value: 10 - a value", "The key has the value: 10 - another value"),
				this.integerStringListOperator.eachEntry()
			.evalOnValue("#param[0] + #target", "The key has the value: ")
			.uneachListMap().get().get(Integer.valueOf(10)));
	}

	public final void testEachListValue() {
		
		List<String> all = new ArrayList<String>();
		all.add("Dummy operation result: 1");
		all.add("Dummy operation result: 1");
		
		assertEquals(all, 
				this.integerStringListOperator.eachListValue().exec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
			.uneachList().get());		
	}

	public final void testEachListEntry() {
		Map<Integer, Integer> all = new HashMap<Integer, Integer>();
		all.put(Integer.valueOf(10), Integer.valueOf(2));
		all.put(Integer.valueOf(20), Integer.valueOf(1));
				
		assertEquals(all, 
				this.integerStringListOperator.eachListEntry().callOnValue("size")
				.uneachMap().get());		
	}

	public final void testAsListMap() {
		assertEquals(this.integerStringListOperator.get(),
				this.integerStringListOperator.asListMap(Integer.class, String.class)
				.get());
		assertTrue(Types.forName("Map<Integer, List<String>>").isAssignableFrom(
				this.integerStringListOperator.asListMap(Integer.class, String.class)
				.getTargets().get(0).getIntendedType()));
	}

	public final void testGeneric() {
		assertEquals(this.integerStringListOperator
				.get(), this.integerStringListOperator
				.generic().getTargetObjects().get(0));
	}

	public final void testFilterEachEntryStringObjectArray() {
			
		Map<Integer, List<String>> results = new HashMap<Integer, List<String>>();
		results.put(Integer.valueOf(10), Arrays.asList(new String[] {"10 - another value"}));
		
		assertEquals(results, this.integerStringListOperator.eachFilterEntry("getKey().toString().length() + getValue().length() == 14")
			.get());
	}

	public final void testEachFilterEntryFilterOfEntryOfKV() {
		
		Map<Integer, List<String>> results = new HashMap<Integer, List<String>>();
		
		ISelect<Map.Entry<Integer, String>> theFilter = new ISelect<Map.Entry<Integer, String>>() {
			public boolean eval(
					SelectorContext<Map.Entry<Integer, String>> ctx) {
				return true;
			}			
		};
		
		assertEquals(results, this.integerStringListOperator.eachFilterEntry(theFilter).get());	
	}

	@SuppressWarnings("unchecked")
	public final void testDistinct() {
		assertEquals(this.integerStringListOperator.get(),
				this.integerStringListOperator.distinct().get());
		
		Iter0IterableListMapOperator<Integer, String> operator = Op.onAll(Integer.valueOf(10), "a",
				Integer.valueOf(20), "a",
				Integer.valueOf(10), "a",
				Integer.valueOf(10), "b").buildListMap(Integer.class, String.class);
		List<String> distinctValuesforKey10 = Arrays.asList("a", "b");
		List<String> valuesforKey10 = Arrays.asList("a", "a", "b");
		assertEquals(valuesforKey10, 
				operator.get().get(Integer.valueOf(10)));
		assertEquals(distinctValuesforKey10, 
				operator.distinct().get().get(Integer.valueOf(10)));
		
		assertEquals(this.integerStringListOperator.get(),
				this.integerStringListOperator.distinct().get());
	}

	public final void testKeySet() {
		assertTrue(this.keys.containsAll(this.integerStringListOperator.keySet().get()));
		assertEquals(this.keys.size(), this.integerStringListOperator.keySet().get().size());
	}

	public final void testValues() {
		List<String> all = new ArrayList<String>();
		for (List<String> aList : this.integerStringListOperator.values().get()) {
			all.addAll(aList);
		}
		assertTrue(this.stringValues.containsAll(all));
		assertEquals(this.stringValues.size(), all.size());
	}

	public final void testValuesForKey() {
		assertTrue(Arrays.asList("10 - a value", "10 - another value").containsAll(
				this.integerStringListOperator.valuesForKey(Integer.valueOf(10)).get()));
		assertEquals(2, this.integerStringListOperator
				.valuesForKey(Integer.valueOf(10)).get().size());
		
	}

	public final void testValuesForAllKeys() {
		assertEquals(this.stringValues, this.integerStringListOperator
				.valuesForAllKeys().get());
	}

	public final void testMergeValuesStringObjectArray() {
		assertEquals("10 - a value", this.integerStringListOperator.mergeValues("#target[0]").get().get(Integer.valueOf(10)));
	}

	public final void testMergeValuesClassOfXStringObjectArray() {
		assertEquals("10 - a value - modified", this.integerStringListOperator.mergeValues(String.class, "#target[0] + #param[0]", " - modified").get().get(Integer.valueOf(10)));
	}

	public final void testGet() {
		assertTrue(Map.class.isAssignableFrom(
				this.integerStringListOperator.get().getClass()));
		assertEquals(2,
				this.integerStringListOperator.get().get(Integer.valueOf(10)).size());
		assertEquals(1,
				this.integerStringListOperator.get().get(Integer.valueOf(20)).size());
	}

	public final void testGetClassOfXClassOfY() {
		this.integerStringListOperator.get(Integer.class, String.class);
		
		this.integerStringListOperator.get(Object.class, Object.class);	
		
		// as cast is not being done (user list is not being iterated) this get methods can be executed
		this.integerStringListOperator.get(Integer.class, Integer.class);
		this.integerStringListOperator.get(Calendar.class, Object.class);		
	}

	public final void testSize() {
		assertEquals(1, this.integerStringListOperator.size());
	}

	public final void testRaw() {
		assertEquals(TypeSchemes.forName("Map<Integer, List<Calendar>>"), 
				this.integerCalendarListOperator.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"), 
				this.integerCalendarListOperator.raw().getTargetTypeScheme());
	}
	
	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Map<?, List<?>>"), Op.onListMap(null).getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, List<Calendar>>"), 
				this.integerCalendarListOperator.getTargetTypeScheme());	
	}

	public final void testGetTargetObjects() {
		List<Map<Integer, List<String>>> targetObjects = Op.onAll(
				Integer.valueOf(10), "a", 
				Integer.valueOf(10), "b",
				Integer.valueOf(20), "c").buildListMap(Integer.class, String.class)
				.getTargetObjects();
		assertEquals(2, targetObjects.get(0).size());
		assertTrue(Arrays.asList(new String[] {"a", "b"}).containsAll(targetObjects
				.get(0)
				.get(Integer.valueOf(10))));		
	}

	public final void testEachValueCallStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableListMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildListMap(Integer.class, Calendar.class)
				.eachValueCall("get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)}).containsAll(result
				.get()
				.get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, List<?>>"), result.getTargetTypeScheme());
	}

	public final void testEachValueCallClassOfXStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableListMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildListMap(Integer.class, Calendar.class)
				.eachValueCall(Integer.class, "get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)}).containsAll(result
				.get()
				.get(Integer.valueOf(10))));
		assertEquals(TypeSchemes.forName("Map<Integer, List<Integer>>"), result.getTargetTypeScheme());
	}	
	
	public final void testEachValueToStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableListMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildListMap(Integer.class, Calendar.class)
				.eachValueTo(Types.STRING.getName());
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new String[] {cal1.toString(), cal2.toString()}).containsAll(result
				.get()
				.get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, List<?>>"), result.getTargetTypeScheme());
		assertEquals(null, result.getOperatorValueType());
		
	}
	
	public final void testEachValueToClassOfXObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableListMapOperator<Integer, String> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildListMap(Integer.class, Calendar.class)
				.eachValueTo(String.class);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new String[] {cal1.toString(), cal2.toString()}).containsAll(result
				.get().get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, List<String>>"), result.getTargetTypeScheme());
		assertEquals(Types.STRING, result.getOperatorValueType());
		
	}
	
	public final void testEachValueToTypeObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableListMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildListMap(Integer.class, Calendar.class)
				.eachValueTo(Types.STRING);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new String[] {cal1.toString(), cal2.toString()}).containsAll(result
				.get().get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, List<?>>"), result.getTargetTypeScheme());
		assertEquals(null, result.getOperatorValueType());
		
	}
	
	@SuppressWarnings("unchecked")
	public final void testEachValueEvalEvaluatorOfVObject() {
		IEval<Calendar, Object> evaluator = new IEval<Calendar, Object>() {
			public Object evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).toString();
			}			
		};
		Map<Integer, List<Calendar>> originalMap = this.integerCalendarListOperator.get();
		Map resultMap = this.integerCalendarListOperator.eachValueEval(evaluator).get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			List<Calendar> calendarList = originalMap.get(entry.getKey());
			int index = 0;
			for (Object element : (List<Object>) entry.getValue()) {
				assertEquals(element, calendarList.get(index++).toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarListOperator
				.eachValueEval(evaluator).getOperatorKeyType());
		assertEquals(null, this.integerCalendarListOperator
				.eachValueEval(evaluator).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, List<?>>"), this.integerCalendarListOperator
				.eachValueEval(evaluator).getTargetTypeScheme());
		
	}
	
	public final void testEachValueEvalClassOfXEvaluatorOfVX() {
		IEval<Calendar, String> evaluator = new IEval<Calendar, String>() {
			public String evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).toString();
			}			
		};
		Map<Integer, List<Calendar>> originalMap = this.integerCalendarListOperator.get();
		Map resultMap = this.integerCalendarListOperator.eachValueEval(String.class, evaluator).get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			List<Calendar> calendarList = this.integerCalendarListOperator.get().get(entry.getKey());
			int index = 0;
			for (Object element : (List<Object>) entry.getValue()) {
				assertEquals(element, calendarList.get(index++).toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarListOperator
				.eachValueEval(String.class, evaluator).getOperatorKeyType());
		assertEquals(Types.STRING, this.integerCalendarListOperator
				.eachValueEval(String.class, evaluator).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, List<String>>"), this.integerCalendarListOperator
				.eachValueEval(String.class, evaluator).getTargetTypeScheme());
		
	}
	
	public final void testEachValueEvalClassOfXStringObjectArray() {
		Map<Integer, List<Calendar>> originalMap = this.integerCalendarListOperator.get();
		Map<Integer, List<String>> resultMap = this.integerCalendarListOperator.eachValueEval(String.class, "#target.toString()")
			.get();
		for (Map.Entry<Integer,List<String>> entry : (Set<Map.Entry<Integer,List<String>>>) resultMap.entrySet()) {
			List<Calendar> calendarList = originalMap.get(entry.getKey());
			int index = 0;
			for (Object element : (List<String>) entry.getValue()) {
				assertEquals(element, calendarList.get(index++).toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarListOperator
				.eachValueEval(String.class, "#target.toString()").getOperatorKeyType());
		assertEquals(Types.STRING, this.integerCalendarListOperator
				.eachValueEval(String.class, "#target.toString()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, List<String>>"), this.integerCalendarListOperator
				.eachValueEval(String.class, "#target.toString()").getTargetTypeScheme());
		
	}
	
	public final void testEachValueEvalStringObjectArray() {
		Map<Integer, List<Calendar>> originalMap = this.integerCalendarListOperator.get();
		Map resultMap = this.integerCalendarListOperator.eachValueEval("#target.toString()")
			.get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			List<Calendar> calendarList = this.integerCalendarListOperator.get().get(entry.getKey());
			int index = 0;
			for (Object element : (List<Object>) entry.getValue()) {
				assertEquals(element, calendarList.get(index++).toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarListOperator
				.eachValueEval("#target.toString()").getOperatorKeyType());
		assertEquals(null, this.integerCalendarListOperator
				.eachValueEval("#target.toString()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, List<?>>"), this.integerCalendarListOperator
				.eachValueEval("#target.toString()").getTargetTypeScheme());
		
	}
}
