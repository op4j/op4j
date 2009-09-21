package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter2IterableSetMapOperatorTest extends TestCase {

	Iter2IterableSetMapOperator<Integer, String> integerStringSetOperator;
	List<String> stringValues = new ArrayList<String>();
	List<Integer> keys = new ArrayList<Integer>();
	
	List<Calendar> calendarValues = new ArrayList<Calendar>();
	Iter2IterableSetMapOperator<Integer, Calendar> integerCalendarSetOperator;

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
				Integer.valueOf(20), "20 - a value").buildSetMap(Integer.class, String.class).generic()
				.buildList().each().buildList().each().asSetMap(Integer.class, String.class);
		
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.calendarValues.add(Calendar.getInstance());
		this.integerCalendarSetOperator = Op.onAll(
				Integer.valueOf(10), this.calendarValues.get(0), 
				Integer.valueOf(10), this.calendarValues.get(1),
				Integer.valueOf(20), this.calendarValues.get(2)).buildSetMap(Integer.class, Calendar.class).generic()
				.buildList().each().buildList().each().asSetMap(Integer.class, Calendar.class);
		
	}

	public final void testSortKeys() {
		Iter2IterableSetMapOperator<Integer, String> operator = Op.onAll(Integer.valueOf(30), "Key is 30",
				Integer.valueOf(40), "Key is 40",
				Integer.valueOf(10), "Key is 10",
				Integer.valueOf(35), "Key is 35").buildSetMap(Integer.class, String.class).generic()
				.buildList().each().buildList().each().asSetMap(Integer.class, String.class);
		Set<Integer> keysUnsorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(30), Integer.valueOf(40), Integer.valueOf(10),Integer.valueOf(35)));
		Set<Integer> keysSorted = new LinkedHashSet<Integer>(Arrays.asList(Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(35), Integer.valueOf(40)));
		
		assertEquals(keysUnsorted, operator.getTargets().get(0).getTargets().get(0).get().keySet());
		assertEquals(keysSorted, operator.sortKeys().getTargets().get(0).getTargets().get(0).get().keySet());
	}

	public final void testEachSetEntry() {
		Map<Integer, Integer> all = new HashMap<Integer, Integer>();
		all.put(Integer.valueOf(10), Integer.valueOf(2));
		all.put(Integer.valueOf(20), Integer.valueOf(1));
				
		assertEquals(all, 
				this.integerStringSetOperator.eachSetEntry().callOnValue("size")
				.uneachMap().getTargets().get(0).getTargets().get(0).get());
	}

	public final void testUneachList() {
		assertEquals(1, this.integerCalendarSetOperator.uneachList().size());
		assertEquals(this.integerCalendarSetOperator.getTargets().get(0).getTargets().get(0).get(), 
				this.integerCalendarSetOperator.uneachList().getTargets().get(0).get().get(0));
	}

	public final void testMergeValuesClassOfXStringObjectArray() {
		assertEquals("10 - a value - modified", this.integerStringSetOperator.mergeValues(String.class, 
				"#target.iterator().next() + #param[0]", " - modified").getTargets().get(0).getTargets().get(0).get().get(Integer.valueOf(10)));
	}

	public final void testEachToValueClassOfXObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter2IterableSetMapOperator<Integer, String> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildSetMap(Integer.class, Calendar.class).generic().buildList()
				.each().buildList().each().asSetMap(Integer.class, Calendar.class)
				.eachToValue(String.class);
		assertEquals(2, result.getTargets().get(0).getTargets().get(0).get().size());
		assertTrue(new HashSet<String>(Arrays.asList(new String[] {cal1.toString(), cal2.toString()})).containsAll(result
				.getTargets().get(0).getTargets().get(0).get().get(Integer.valueOf(10))));	
		assertEquals(TypeSchemes.forName("Map<Integer, Set<String>>"), result.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(Types.STRING, result.getOperatorValueType());
	}

}
