package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.op4j.commands.IEval;
import org.op4j.op.Op;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableSetMapOperatorTest extends TestCase {

	Iter0IterableSetMapOperator<Integer, String> integerStringSetOperator;
	List<String> stringValues = new ArrayList<String>();
	List<Integer> keys = new ArrayList<Integer>();
	
	List<Calendar> calendarValues = new ArrayList<Calendar>();
	Iter0IterableSetMapOperator<Integer, Calendar> integerCalendarSetOperator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		Operations.addOperationImplementation(DummyOperationOnOneOrTwoTargets.class);
		
		this.keys.add(Integer.valueOf(10));
		this.keys.add(Integer.valueOf(20));
		
		this.stringValues.add("10 - a value");
		this.stringValues.add("10 - another value");
		this.stringValues.add("20 - a value");
		this.integerStringSetOperator = Op.onAll(
				Integer.valueOf(10), "10 - a value", 
				Integer.valueOf(10), "10 - another value",
				Integer.valueOf(20), "20 - a value").buildSetMap(Integer.class, String.class);
		
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.integerCalendarSetOperator = Op.onAll(
				Integer.valueOf(10), this.calendarValues.get(0), 
				Integer.valueOf(10), this.calendarValues.get(1),
				Integer.valueOf(20), this.calendarValues.get(2)).buildSetMap(Integer.class, Calendar.class);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testRaw() {
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Calendar>>"), 
				this.integerCalendarSetOperator.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"), 
				this.integerCalendarSetOperator.raw().getTargetTypeScheme());
	}

	public final void testEachValueExecStringObjectArray() {
		assertEquals(Types.INTEGER,
				this.integerCalendarSetOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorKeyType());
		assertEquals(null,
				this.integerCalendarSetOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<?>>"),
				this.integerCalendarSetOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargetTypeScheme());
		assertEquals("Dummy operation result: 1",
				this.integerCalendarSetOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(this.keys.get(0)).iterator().next());
	}

	public final void testEachValueExecClassOfXStringObjectArray() {
		assertEquals(Types.INTEGER,
				this.integerCalendarSetOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorKeyType());
		assertEquals(Types.STRING,
				this.integerCalendarSetOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<String>>"),
				this.integerCalendarSetOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargetTypeScheme());
		assertEquals("Dummy operation result: 1",
				this.integerCalendarSetOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(this.keys.get(0)).iterator().next());
	}

	public final void testSortKeys() {
		Iter0IterableSetMapOperator<Integer, String> operator = Op.onAll(Integer.valueOf(30), "Key is 30",
				Integer.valueOf(40), "Key is 40",
				Integer.valueOf(10), "Key is 10",
				Integer.valueOf(35), "Key is 35").buildSetMap(Integer.class, String.class);
		Set<Integer> keysUnsorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(30), Integer.valueOf(40), Integer.valueOf(10),Integer.valueOf(35)));
		Set<Integer> keysSorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(35), Integer.valueOf(40)));
		
		assertEquals(keysUnsorted, operator.get().keySet());
		assertEquals(keysSorted, operator.sortKeys().get().keySet());
	}

	public final void testSortKeysComparatorOfQsuperK() {
		Iter0IterableSetMapOperator<String, Integer> operator = Op.onAll(
				"a", Integer.valueOf(1),
				"c", Integer.valueOf(3),
				"d", Integer.valueOf(4),
				"b", Integer.valueOf(2)).buildSetMap(String.class, Integer.class);
		
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

	public final void testSortValueSets() {
		Set<Integer> valuesSorted = new HashSet<Integer>(Arrays.asList(
				Integer.valueOf(1), Integer.valueOf(2), 
				Integer.valueOf(3), Integer.valueOf(4)));
		assertEquals(valuesSorted, 
			Op.onAll("a", Integer.valueOf(2),
					"a", Integer.valueOf(3), 
					"a", Integer.valueOf(4), 
					"b", Integer.valueOf(1),
					"a", Integer.valueOf(1)).buildSetMap(String.class, Integer.class).sortValueSets().get().get("a"));
	}

	public final void testSortValueSetsComparatorOfQsuperV() {
		Set<Integer> valuesSorted = new HashSet<Integer>(Arrays.asList(
				Integer.valueOf(4), Integer.valueOf(3),
				Integer.valueOf(2), Integer.valueOf(1), null));
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
					"a", Integer.valueOf(1)).buildSetMap(String.class, Integer.class).sortValueSets(comparator).get().get("a"));
	}

	public final void testEachValue() {
		assertEquals(Arrays.asList("10 - a value - modified", "10 - another value - modified", "20 - a value - modified"),
				this.integerStringSetOperator.eachValue()
			.eval("#target + #param[0]", " - modified")
			.uneachList(String.class).get());
	}

	public final void testEachKey() {
		assertEquals(Arrays.asList(Integer.valueOf(110), Integer.valueOf(120)),
				this.integerStringSetOperator.eachKey()
			.eval("#target + #param[0]", Integer.valueOf(100))
			.uneachList(Integer.class).get());
	}

	public final void testEachEntry() {
		assertEquals(Arrays.asList("The key has the value: 10 - a value", "The key has the value: 10 - another value"),
				this.integerStringSetOperator.eachEntry()
			.evalOnValue("#param[0] + #target", "The key has the value: ")
			.uneachListMap().get().get(Integer.valueOf(10)));
	}

	public final void testEachSetValue() {
		
		List<String> all = new ArrayList<String>();
		all.add("Dummy operation result: 1");
		all.add("Dummy operation result: 1");
		
		assertEquals(all, 
				this.integerStringSetOperator.eachSetValue()
				.exec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
			.uneachList().get());		
	}

	public final void testEachSetEntry() {
		Map<Integer, Integer> all = new HashMap<Integer, Integer>();
		all.put(Integer.valueOf(10), Integer.valueOf(2));
		all.put(Integer.valueOf(20), Integer.valueOf(1));
				
		assertEquals(all, 
				this.integerStringSetOperator.eachSetEntry().callOnValue("size")
				.uneachMap().get());
	}

	public final void testAsSetMap() {
		assertEquals(this.integerStringSetOperator.get(),
				this.integerStringSetOperator.asSetMap(Integer.class, String.class)
				.get());
		assertTrue(Types.forName("Map<Integer, Set<String>>").isAssignableFrom(
				this.integerStringSetOperator.asSetMap(Integer.class, String.class)
				.getTargets().get(0).getIntendedType()));
	}

	public final void testGeneric() {
		assertEquals(this.integerStringSetOperator
				.get(), this.integerStringSetOperator
				.generic().getTargetObjects().get(0));
	}

	public final void testEachFilterEntryStringObjectArray() {
		
		Map<Integer, HashSet<String>> results = new HashMap<Integer, HashSet<String>>();
		results.put(Integer.valueOf(10), new HashSet<String>(Arrays.asList(new String[] {"10 - another value"})));

		assertEquals(results, this.integerStringSetOperator.eachFilterEntry("getKey().toString().length() + getValue().length() == 14")
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

		assertEquals(results, this.integerStringSetOperator.eachFilterEntry(theFilter).get());	
	}

	public final void testKeySet() {
		assertTrue(this.keys.containsAll(this.integerStringSetOperator.keySet().get()));
		assertEquals(this.keys.size(), this.integerStringSetOperator.keySet().get().size());
	}

	public final void testValues() {
		Set<String> all = new HashSet<String>();
		for (Set<String> aSet : this.integerStringSetOperator.values().get()) {
			all.addAll(aSet);
		}
		assertTrue(this.stringValues.containsAll(all));
		assertEquals(this.stringValues.size(), all.size());
	}

	public final void testValuesForKey() {
		assertTrue(Arrays.asList("10 - a value", "10 - another value").containsAll(
				this.integerStringSetOperator.valuesForKey(Integer.valueOf(10)).get()));
		assertEquals(2, this.integerStringSetOperator
				.valuesForKey(Integer.valueOf(10)).get().size());
		
	}

	public final void testValuesForAllKeys() {
		assertEquals(new  HashSet<String>(this.stringValues), this.integerStringSetOperator
				.valuesForAllKeys().get());
	}

	public final void testMergeValuesStringObjectArray() {
		assertEquals("10 - a value", this.integerStringSetOperator.mergeValues("#target.iterator().next()").get().get(Integer.valueOf(10)));
	}

	public final void testMergeValuesClassOfXStringObjectArray() {
		assertEquals("10 - a value - modified", this.integerStringSetOperator.mergeValues(String.class, "#target.iterator().next() + #param[0]", " - modified").get().get(Integer.valueOf(10)));
	}

	@SuppressWarnings("unchecked")
	public final void testEachValueEvalStringObjectArray() {
		Map<Integer, Set<Calendar>> originalMap = this.integerCalendarSetOperator.get();
		Map resultMap = this.integerCalendarSetOperator.eachValueEval("#target.toString()")
			.get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Set<Calendar> calendarSet = this.integerCalendarSetOperator.get().get(entry.getKey());
			Iterator iterator = calendarSet.iterator();
			for (Object element : (Set<Object>) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarSetOperator
				.eachValueEval("#target.toString()").getOperatorKeyType());
		assertEquals(null, this.integerCalendarSetOperator
				.eachValueEval("#target.toString()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<?>>"), this.integerCalendarSetOperator
				.eachValueEval("#target.toString()").getTargetTypeScheme());
	}

	public final void testEachValueEvalClassOfXStringObjectArray() {
		Map<Integer, Set<Calendar>> originalMap = this.integerCalendarSetOperator.get();
		Map resultMap = this.integerCalendarSetOperator.eachValueEval(String.class, "#target.toString()")
			.get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Set<Calendar> calendarSet = this.integerCalendarSetOperator.get().get(entry.getKey());
			Iterator iterator = calendarSet.iterator();
			for (Object element : (Set<Object>) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarSetOperator
				.eachValueEval(String.class, "#target.toString()").getOperatorKeyType());
		assertEquals(Types.STRING, this.integerCalendarSetOperator
				.eachValueEval(String.class, "#target.toString()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<String>>"), this.integerCalendarSetOperator
				.eachValueEval(String.class, "#target.toString()").getTargetTypeScheme());
	}

	public final void testEachValueEvalClassOfXEvaluatorOfVX() {
		IEval<Calendar, String> evaluator = new IEval<Calendar, String>() {
			public String evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).toString();
			}			
		};
		Map<Integer, Set<Calendar>> originalMap = this.integerCalendarSetOperator.get();
		Map resultMap = this.integerCalendarSetOperator.eachValueEval(String.class, evaluator).get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Set<Calendar> calendarSet = this.integerCalendarSetOperator.get().get(entry.getKey());
			Iterator iterator = calendarSet.iterator();
			for (Object element : (Set<Object>) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarSetOperator
				.eachValueEval(String.class, evaluator).getOperatorKeyType());
		assertEquals(Types.STRING, this.integerCalendarSetOperator
				.eachValueEval(String.class, evaluator).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<String>>"), this.integerCalendarSetOperator
				.eachValueEval(String.class, evaluator).getTargetTypeScheme());
		
	}

	@SuppressWarnings("unchecked")
	public final void testEachValueEvalEvaluatorOfVObject() {
		IEval<Calendar, Object> evaluator = new IEval<Calendar, Object>() {
			public Object evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).toString();
			}			
		};
		Map<Integer, Set<Calendar>> originalMap = this.integerCalendarSetOperator.get();
		Map resultMap = this.integerCalendarSetOperator.eachValueEval(evaluator).get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Set<Calendar> calendarSet = originalMap.get(entry.getKey());
			Iterator iterator = calendarSet.iterator();
			for (Object element : (Set<Object>) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarSetOperator
				.eachValueEval(evaluator).getOperatorKeyType());
		assertEquals(null, this.integerCalendarSetOperator
				.eachValueEval(evaluator).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<?>>"), this.integerCalendarSetOperator
				.eachValueEval(evaluator).getTargetTypeScheme());
		
	}

	public final void testEachValueCallStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableSetMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildSetMap(Integer.class, Calendar.class)
				.eachValueCall("get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertTrue(new HashSet<Integer>(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)})).containsAll(result
				.get()
				.get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Set<?>>"), result.getTargetTypeScheme());
	}

	public final void testEachValueCallClassOfXStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableSetMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildSetMap(Integer.class, Calendar.class)
				.eachValueCall(Integer.class, "get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertTrue(new HashSet<Integer>(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)})).containsAll(result
				.get()
				.get(Integer.valueOf(10))));
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Integer>>"), result.getTargetTypeScheme());
	}

	public final void testEachValueToTypeObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableSetMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildSetMap(Integer.class, Calendar.class)
				.eachValueTo(Types.STRING);
		assertEquals(2, result.get().size());
		assertTrue(new HashSet<String>(Arrays.asList(new String[] {cal1.toString(), cal2.toString()})).containsAll(result
				.get().get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Set<?>>"), result.getTargetTypeScheme());
		assertEquals(null, result.getOperatorValueType());
		
	}

	@SuppressWarnings("unchecked")
	public final void testEachValueToStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableSetMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildSetMap(Integer.class, Calendar.class)
				.eachValueTo(Types.STRING.getName());
		assertEquals(2, result.get().size());
		assertTrue(new HashSet(Arrays.asList(new String[] {cal1.toString(), cal2.toString()})).containsAll(result
				.get().get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Set<?>>"), result.getTargetTypeScheme());
		assertEquals(null, result.getOperatorValueType());
		
	}

	public final void testEachValueToClassOfXObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableSetMapOperator<Integer, String> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildSetMap(Integer.class, Calendar.class)
				.eachValueTo(String.class);
		assertEquals(2, result.get().size());
		assertTrue(new HashSet<String>(Arrays.asList(new String[] {cal1.toString(), cal2.toString()})).containsAll(result
				.get().get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Set<String>>"), result.getTargetTypeScheme());
		assertEquals(Types.STRING, result.getOperatorValueType());
		
	}

	public final void testGet() {
		assertTrue(Map.class.isAssignableFrom(
				this.integerStringSetOperator.get().getClass()));
		assertEquals(2,
				this.integerStringSetOperator.get().get(Integer.valueOf(10)).size());
		assertEquals(1,
				this.integerStringSetOperator.get().get(Integer.valueOf(20)).size());
	}

	public final void testGetClassOfXClassOfY() {
		this.integerStringSetOperator.get(Integer.class, String.class);
		
		this.integerStringSetOperator.get(Object.class, Object.class);	
		
		// as cast is not being done (user list is not being iterated) this get methods can be executed
		this.integerStringSetOperator.get(Integer.class, Integer.class);
		this.integerStringSetOperator.get(Calendar.class, Object.class);	
	}

	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Map<?, Set<?>>"), Op.onSetMap(null).getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Set<Calendar>>"), 
				this.integerCalendarSetOperator.getTargetTypeScheme());
	}

	public final void testGetTargetObjects() {
		List<Map<Integer, Set<String>>> targetObjects = Op.onAll(
				Integer.valueOf(10), "a", 
				Integer.valueOf(10), "b",
				Integer.valueOf(20), "c").buildSetMap(Integer.class, String.class)
				.getTargetObjects();
		assertEquals(2, targetObjects.get(0).size());
		assertTrue(new HashSet<String>(Arrays.asList(new String[] {"a", "b"})).containsAll(targetObjects
				.get(0)
				.get(Integer.valueOf(10))));		
	}

	public final void testSize() {
		assertEquals(1, this.integerStringSetOperator.size());
	}

}
