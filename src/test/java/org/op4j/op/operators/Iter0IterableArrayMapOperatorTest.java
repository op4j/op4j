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

import org.op4j.op.Op;
import org.op4j.op.interfaces.EvalContext;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter0IterableArrayMapOperatorTest extends TestCase {

	Iter0IterableArrayMapOperator<Integer, String> integerStringArrayOperator;
	List<String> stringValues = new ArrayList<String>();
	List<Integer> keys = new ArrayList<Integer>();
	
	List<Calendar> calendarValues = new ArrayList<Calendar>();
	Iter0IterableArrayMapOperator<Integer, Calendar> integerCalendarArrayOperator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		Operations.addOperationImplementation(DummyOperationOnOneOrTwoTargets.class);
		
		this.keys.add(Integer.valueOf(10));
		this.keys.add(Integer.valueOf(20));
		
		this.stringValues.add("10 - a value");
		this.stringValues.add("10 - another value");
		this.stringValues.add("20 - a value");
		this.integerStringArrayOperator = Op.onAll(
				Integer.valueOf(10), "10 - a value", 
				Integer.valueOf(10), "10 - another value",
				Integer.valueOf(20), "20 - a value").buildArrayMap(Integer.class, String.class);
		
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.integerCalendarArrayOperator = Op.onAll(
				Integer.valueOf(10), this.calendarValues.get(0), 
				Integer.valueOf(10), this.calendarValues.get(1),
				Integer.valueOf(20), this.calendarValues.get(2)).buildArrayMap(Integer.class, Calendar.class);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testRaw() {
		assertEquals(TypeSchemes.forName("Map<Integer, Calendar[]>"), 
				this.integerCalendarArrayOperator.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<?, Object[]>"), 
				this.integerCalendarArrayOperator.raw().getTargetTypeScheme());
	}

	public final void testEachValueExecStringObjectArray() {
		assertEquals(Types.INTEGER,
				this.integerCalendarArrayOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorKeyType());
		assertEquals(null,
				this.integerCalendarArrayOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Object[]>"),
				this.integerCalendarArrayOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargetTypeScheme());
		assertEquals("Dummy operation result: 1",
				this.integerCalendarArrayOperator.eachValueExec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(this.keys.get(0))[0]);
	}

	public final void testEachValueExecClassOfXStringObjectArray() {
		assertEquals(Types.INTEGER,
				this.integerCalendarArrayOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorKeyType());
		assertEquals(Types.STRING,
				this.integerCalendarArrayOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, String[]>"),
				this.integerCalendarArrayOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargetTypeScheme());
		assertEquals("Dummy operation result: 1",
				this.integerCalendarArrayOperator.eachValueExec(String.class, DummyOperationOnOneOrTwoTargets.OPERATION_NAME).get().get(this.keys.get(0))[0]);
	}

	public final void testSortKeys() {
		Iter0IterableArrayMapOperator<Integer, String> operator = Op.onAll(Integer.valueOf(30), "Key is 30",
				Integer.valueOf(40), "Key is 40",
				Integer.valueOf(10), "Key is 10",
				Integer.valueOf(35), "Key is 35").buildArrayMap(Integer.class, String.class);
		Set<Integer> keysUnsorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(30), Integer.valueOf(40), Integer.valueOf(10),Integer.valueOf(35)));
		Set<Integer> keysSorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(35), Integer.valueOf(40)));
		
		assertEquals(keysUnsorted, operator.get().keySet());
		assertEquals(keysSorted, operator.sortKeys().get().keySet());
	}

	public final void testSortKeysComparatorOfQsuperK() {
		Iter0IterableArrayMapOperator<String, Integer> operator = Op.onAll(
				"a", Integer.valueOf(1),
				"c", Integer.valueOf(3),
				"d", Integer.valueOf(4),
				"b", Integer.valueOf(2)).buildArrayMap(String.class, Integer.class);
		
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
		Integer[] valuesSorted = new Integer[] {
				Integer.valueOf(1), Integer.valueOf(2), 
				Integer.valueOf(3), Integer.valueOf(4)};
		assertEquals(Arrays.asList(valuesSorted), 
			Arrays.asList(Op.onAll("a", Integer.valueOf(2),
					"a", Integer.valueOf(3), 
					"a", Integer.valueOf(4), 
					"b", Integer.valueOf(1),
					"a", Integer.valueOf(1)).buildArrayMap(String.class, Integer.class).sortValueArrays().get().get("a")));
	}

	public final void testSortValueSetsComparatorOfQsuperV() {
		Integer[] valuesSorted = new Integer[] {
				Integer.valueOf(4), Integer.valueOf(3),
				Integer.valueOf(2), Integer.valueOf(1), null, null};
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
		assertEquals(Arrays.asList(valuesSorted), 
			Arrays.asList(Op.onAll("a", Integer.valueOf(2),
					"a", Integer.valueOf(3), 
					"a", Integer.valueOf(4), 
					"a", null,
					"b", Integer.valueOf(1),
					"a", null,
					"a", Integer.valueOf(1)).buildArrayMap(String.class, Integer.class).sortValueArrays(comparator).get().get("a")));
	}

	public final void testEachValue() {
		assertEquals(Arrays.asList("10 - a value - modified", "10 - another value - modified", "20 - a value - modified"),
				this.integerStringArrayOperator.eachValue()
			.eval("#target + #param[0]", " - modified")
			.uneachList(String.class).get());
	}

	public final void testEachKey() {
		assertEquals(Arrays.asList(Integer.valueOf(110), Integer.valueOf(120)),
				this.integerStringArrayOperator.eachKey()
			.eval("#target + #param[0]", Integer.valueOf(100))
			.uneachList(Integer.class).get());
	}

	public final void testEachEntry() {
		assertEquals(Arrays.asList(new String[] {"The key has the value: 10 - a value", "The key has the value: 10 - another value"}),
				Arrays.asList(this.integerStringArrayOperator.eachEntry()
    			.evalOnValue("#param[0] + #target", "The key has the value: ")
    			.uneachArrayMap().get().get(Integer.valueOf(10))));
	}

	public final void testEachArrayValue() {
		
		List<String> all = new ArrayList<String>();
		all.add("Dummy operation result: 1");
		all.add("Dummy operation result: 1");
		
		assertEquals(all, 
				this.integerStringArrayOperator.eachArrayValue()
				.exec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
			.uneachList().get());		
	}

	public final void testEachArrayEntry() {
		Map<Integer, Integer> all = new HashMap<Integer, Integer>();
		all.put(Integer.valueOf(10), Integer.valueOf(2));
		all.put(Integer.valueOf(20), Integer.valueOf(1));
				
		assertEquals(all, 
				this.integerStringArrayOperator.eachArrayEntry().evalOnValue("length")
				.uneachMap().get());
	}

	public final void testAsArrayMap() {
		assertEquals(this.integerStringArrayOperator.get(),
				this.integerStringArrayOperator.asArrayMap(Integer.class, String.class)
				.get());
		assertTrue(Types.forName("Map<Integer, String[]>").isAssignableFrom(
				this.integerStringArrayOperator.asArrayMap(Integer.class, String.class)
				.getTargets().get(0).getIntendedType()));
	}

	public final void testGeneric() {
		assertEquals(this.integerStringArrayOperator
				.get(), this.integerStringArrayOperator
				.generic().getTargetObjects().get(0));
	}

	public final void testEachFilterEntryStringObjectArray() {
		
		Map<Integer, String[]> results = new HashMap<Integer, String[]>();
		results.put(Integer.valueOf(10), new String[] {"10 - another value"});

		assertEquals(Arrays.asList(results.get(Integer.valueOf(10))), 
		       Arrays.asList(this.integerStringArrayOperator.eachFilterEntry("getKey().toString().length() + getValue().length() == 14").get().get(Integer.valueOf(10))));
	}

	public final void testEachFilterEntryFilterOfEntryOfKV() {
		Map<Integer, String[]> results = new HashMap<Integer, String[]>();

		Filter<Map.Entry<Integer, String>> theFilter = new Filter<Map.Entry<Integer, String>>() {
			public boolean eval(
					FilterContext<Map.Entry<Integer, String>> ctx) {
				return true;
			}			
		};

		assertEquals(results, this.integerStringArrayOperator.eachFilterEntry(theFilter).get());	
	}

	public final void testKeySet() {
		assertTrue(this.keys.containsAll(this.integerStringArrayOperator.keySet().get()));
		assertEquals(this.keys.size(), this.integerStringArrayOperator.keySet().get().size());
	}

	public final void testValues() {
		Set<String> all = new HashSet<String>();
		for (String[] anArray : this.integerStringArrayOperator.values().get()) {
			all.addAll(Arrays.asList(anArray));
		}
		assertTrue(this.stringValues.containsAll(all));
		assertEquals(this.stringValues.size(), all.size());
	}

	public final void testValuesForKey() {
		assertTrue(Arrays.asList("10 - a value", "10 - another value").containsAll(
				Arrays.asList(this.integerStringArrayOperator.valuesForKey(Integer.valueOf(10)).get())));
		assertEquals(2, this.integerStringArrayOperator
				.valuesForKey(Integer.valueOf(10)).get().length);
		
	}

	public final void testValuesForAllKeys() {
		assertEquals(this.stringValues, Arrays.asList(this.integerStringArrayOperator.valuesForAllKeys().get()));
	}

	public final void testMergeValuesStringObjectArray() {
		assertEquals("10 - a value", this.integerStringArrayOperator.mergeValues("#target[0]").get().get(Integer.valueOf(10)));
	}

	public final void testMergeValuesClassOfXStringObjectArray() {
		assertEquals("10 - a value - modified", this.integerStringArrayOperator.mergeValues(String.class, "#target[0] + #param[0]", " - modified").get().get(Integer.valueOf(10)));
	}

	@SuppressWarnings("unchecked")
	public final void testEachValueEvalStringObjectArray() {
		Map<Integer, Calendar[]> originalMap = this.integerCalendarArrayOperator.get();
		Map resultMap = this.integerCalendarArrayOperator.eachValueEval("#target.toString()")
			.get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Calendar[] calendarArray = this.integerCalendarArrayOperator.get().get(entry.getKey());
			Iterator iterator = Arrays.asList(calendarArray).iterator();
			for (Object element : (Object[]) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarArrayOperator
				.eachValueEval("#target.toString()").getOperatorKeyType());
		assertEquals(null, this.integerCalendarArrayOperator
				.eachValueEval("#target.toString()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Object[]>"), this.integerCalendarArrayOperator
				.eachValueEval("#target.toString()").getTargetTypeScheme());
	}

	public final void testEachValueEvalClassOfXStringObjectArray() {
		Map<Integer, Calendar[]> originalMap = this.integerCalendarArrayOperator.get();
		Map resultMap = this.integerCalendarArrayOperator.eachValueEval(String.class, "#target.toString()").get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Calendar[] calendarArray = this.integerCalendarArrayOperator.get().get(entry.getKey());
			Iterator iterator = Arrays.asList(calendarArray).iterator();
			for (Object element : (Object[]) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarArrayOperator
				.eachValueEval(String.class, "#target.toString()").getOperatorKeyType());
		assertEquals(Types.STRING, this.integerCalendarArrayOperator
				.eachValueEval(String.class, "#target.toString()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, String[]>"), this.integerCalendarArrayOperator
				.eachValueEval(String.class, "#target.toString()").getTargetTypeScheme());
	}

	public final void testEachValueEvalClassOfXEvaluatorOfVX() {
		Evaluator<Calendar, String> evaluator = new Evaluator<Calendar, String>() {
			public String evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).toString();
			}			
		};
		Map<Integer, Calendar[]> originalMap = this.integerCalendarArrayOperator.get();
		Map resultMap = this.integerCalendarArrayOperator.eachValueEval(String.class, evaluator).get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Calendar[] calendarArray = this.integerCalendarArrayOperator.get().get(entry.getKey());
			Iterator iterator = Arrays.asList(calendarArray).iterator();
			for (Object element : (Object[]) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarArrayOperator
				.eachValueEval(String.class, evaluator).getOperatorKeyType());
		assertEquals(Types.STRING, this.integerCalendarArrayOperator
				.eachValueEval(String.class, evaluator).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, String[]>"), this.integerCalendarArrayOperator
				.eachValueEval(String.class, evaluator).getTargetTypeScheme());
		
	}

	@SuppressWarnings("unchecked")
	public final void testEachValueEvalEvaluatorOfVObject() {
		Evaluator<Calendar, Object> evaluator = new Evaluator<Calendar, Object>() {
			public Object evaluate(EvalContext<Calendar> ctx) {
				return ctx.getTarget(0).toString();
			}			
		};
		Map<Integer, Calendar[]> originalMap = this.integerCalendarArrayOperator.get();
		Map resultMap = this.integerCalendarArrayOperator.eachValueEval(evaluator).get();
		for (Map.Entry entry : (Set<Map.Entry>) resultMap.entrySet()) {
			Calendar[] calendarArray = originalMap.get(entry.getKey());
			Iterator iterator = Arrays.asList(calendarArray).iterator();
			for (Object element : (Object[]) entry.getValue()) {
				assertEquals(element, iterator.next().toString());
			}
		}
		
		assertEquals(Types.INTEGER, this.integerCalendarArrayOperator
				.eachValueEval(evaluator).getOperatorKeyType());
		assertEquals(null, this.integerCalendarArrayOperator
				.eachValueEval(evaluator).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Object[]>"), this.integerCalendarArrayOperator
				.eachValueEval(evaluator).getTargetTypeScheme());
		
	}

	public final void testEachValueCallStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableArrayMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildArrayMap(Integer.class, Calendar.class)
				.eachValueCall("get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)}).containsAll(
		        Arrays.asList(result.get().get(Integer.valueOf(10)))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Object[]>"), result.getTargetTypeScheme());
	}

	public final void testEachValueCallClassOfXStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableArrayMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildArrayMap(Integer.class, Calendar.class)
				.eachValueCall(Integer.class, "get", Calendar.MILLISECOND);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)}).containsAll(
		        Arrays.asList(result.get().get(Integer.valueOf(10)))));
		assertEquals(TypeSchemes.forName("Map<Integer, Integer[]>"), result.getTargetTypeScheme());
	}

	public final void testEachValueToTypeObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableArrayMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildArrayMap(Integer.class, Calendar.class)
				.eachValueTo(Types.STRING);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new String[] {cal1.toString(), cal2.toString()}).containsAll(
		        Arrays.asList(result.get().get(Integer.valueOf(10)))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Object[]>"), result.getTargetTypeScheme());
		assertEquals(null, result.getOperatorValueType());
		
	}

	@SuppressWarnings("unchecked")
	public final void testEachValueToStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableArrayMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildArrayMap(Integer.class, Calendar.class)
				.eachValueTo(Types.STRING.getName());
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new String[] {cal1.toString(), cal2.toString()}).containsAll(
		        Arrays.asList(result.get().get(Integer.valueOf(10)))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Object[]>"), result.getTargetTypeScheme());
		assertEquals(null, result.getOperatorValueType());
		
	}

	public final void testEachValueToClassOfXObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter0IterableArrayMapOperator<Integer, String> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildArrayMap(Integer.class, Calendar.class)
				.eachValueTo(String.class);
		assertEquals(2, result.get().size());
		assertTrue(Arrays.asList(new String[] {cal1.toString(), cal2.toString()}).containsAll(
		        Arrays.asList(result.get().get(Integer.valueOf(10)))));	
		assertEquals(TypeSchemes.forName("Map<Integer, String[]>"), result.getTargetTypeScheme());
		assertEquals(Types.STRING, result.getOperatorValueType());
		
	}

	public final void testGet() {
		assertTrue(Map.class.isAssignableFrom(
				this.integerStringArrayOperator.get().getClass()));
		assertEquals(2,
				this.integerStringArrayOperator.get().get(Integer.valueOf(10)).length);
		assertEquals(1,
				this.integerStringArrayOperator.get().get(Integer.valueOf(20)).length);
	}

	public final void testGetClassOfXClassOfY() {
		this.integerStringArrayOperator.get(Integer.class, String.class);
		
		this.integerStringArrayOperator.get(Object.class, Object.class);	
		
		// as cast is not being done (user list is not being iterated) this get methods can be executed
		this.integerStringArrayOperator.get(Integer.class, Integer.class);
		this.integerStringArrayOperator.get(Calendar.class, Object.class);	
	}

	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Map<?, Object[]>"), Op.onArrayMap(null).getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map<Integer, Calendar[]>"), 
				this.integerCalendarArrayOperator.getTargetTypeScheme());
	}

	public final void testGetTargetObjects() {
		List<Map<Integer, String[]>> targetObjects = Op.onAll(
				Integer.valueOf(10), "a", 
				Integer.valueOf(10), "b",
				Integer.valueOf(20), "c").buildArrayMap(Integer.class, String.class)
				.getTargetObjects();
		assertEquals(2, targetObjects.get(0).size());
		assertTrue(Arrays.asList(new String[] {"a", "b"}).containsAll(
		        Arrays.asList(targetObjects.get(0).get(Integer.valueOf(10)))));		
	}

	public final void testSize() {
		assertEquals(1, this.integerStringArrayOperator.size());
	}

}
