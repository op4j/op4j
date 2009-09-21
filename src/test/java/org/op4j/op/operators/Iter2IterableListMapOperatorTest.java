package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter2IterableListMapOperatorTest extends TestCase {

	HashMap<Integer, ArrayList<String>> integerListStringMap = new HashMap<Integer, ArrayList<String>>();
	Iter2IterableListMapOperator<Integer, String> integerStringOperator;
	
	HashMap<Integer, ArrayList<Calendar>> integerListCalendarMap = new HashMap<Integer, ArrayList<Calendar>>();
	Iter2IterableListMapOperator<Integer, Calendar> integerCalendarOperator;
	
	ArrayList<String> stringList;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.stringList = new ArrayList<String>();
		this.stringList.add("this");
		this.stringList.add("is");
		this.stringList.add("a");
		this.stringList.add("test");
		this.integerListStringMap.put(Integer.valueOf(10), this.stringList);

		ArrayList<Calendar> aux2 = new ArrayList<Calendar>();
		aux2.add(Calendar.getInstance());
		this.integerListCalendarMap.put(Integer.valueOf(10), aux2);
		
		this.integerStringOperator = Op.onList(Arrays.asList(this.integerListStringMap)).each().buildList().each().asListMap(Integer.class, String.class);
		this.integerCalendarOperator = Op.onList(Arrays.asList(this.integerListCalendarMap)).each().buildList().each().asListMap(Integer.class, Calendar.class);
	}

	public final void testEachListEntry() {
		Map<Integer, Integer> all = new HashMap<Integer, Integer>();
		all.put(Integer.valueOf(10), Integer.valueOf(4));
				
		assertEquals(all, 
				this.integerStringOperator.eachListEntry().callOnValue("size")
				.uneachMap().getTargets().get(0).getTargets().get(0).get());		
	}

	public final void testEachFilterEntryFilterOfEntryOfKV() {
		Map<Integer, List<String>> results = new HashMap<Integer, List<String>>();

		Filter<Map.Entry<Integer, String>> theFilter = new Filter<Map.Entry<Integer, String>>() {
			public boolean eval(
					FilterContext<Map.Entry<Integer, String>> ctx) {
				return true;
			}			
		};

		assertEquals(results, this.integerStringOperator.eachFilterEntry(theFilter).getTargets().get(0).getTargets().get(0).get());	
		
		assertEquals(TypeSchemes.forName("Map<Integer, List<String>>"), this.integerStringOperator.eachFilterEntry(theFilter).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());	
		assertEquals(Types.INTEGER, this.integerStringOperator.eachFilterEntry(theFilter).getTargets().get(0).getTargets().get(0).getOperatorKeyType());	
		assertEquals(Types.STRING, this.integerStringOperator.eachFilterEntry(theFilter).getTargets().get(0).getTargets().get(0).getOperatorValueType());	
	}

	public final void testMergeValuesClassOfXStringObjectArray() {
		assertEquals("this - modified", this.integerStringOperator
				.mergeValues(String.class, "#target[0] + #param[0]", " - modified")
				.getTargets().get(0).getTargets().get(0).get().get(Integer.valueOf(10)));
		assertEquals(TypeSchemes.forName("Map<Integer, String>"), this.integerStringOperator
				.mergeValues(String.class, "#target[0] + #param[0]", " - modified")
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(Types.INTEGER, this.integerStringOperator
				.mergeValues(String.class, "#target[0] + #param[0]", " - modified")
				.getTargets().get(0).getTargets().get(0).getOperatorKeyType());
		assertEquals(Types.STRING, this.integerStringOperator
				.mergeValues(String.class, "#target[0] + #param[0]", " - modified")
				.getTargets().get(0).getTargets().get(0).getOperatorValueType());
	}

	public final void testEachCallValueClassOfXStringObjectArray() {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		Calendar cal3 = Calendar.getInstance();
		
		Iter2IterableListMapOperator<Integer, ?> result = Op.onAll(
				Integer.valueOf(10), cal1, 
				Integer.valueOf(10), cal2,
				Integer.valueOf(20), cal3).buildListMap(Integer.class, Calendar.class)
				.generic().buildList().each().buildList().each().asListMap(Integer.class, Calendar.class)
				.eachCallValue(Integer.class, "get", Calendar.MILLISECOND);
		assertEquals(2, result.getTargets().get(0).getTargets().get(0).get().size());
		assertTrue(Arrays.asList(new Integer[] {cal1.get(Calendar.MILLISECOND), cal2.get(Calendar.MILLISECOND)}).containsAll(result
				.getTargets().get(0).getTargets().get(0).get()
				.get(Integer.valueOf(10))));
		assertEquals(Types.INTEGER, result.getOperatorKeyType());
		assertEquals(Types.INTEGER, result.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, List<Integer>>"), result.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
	}

}
