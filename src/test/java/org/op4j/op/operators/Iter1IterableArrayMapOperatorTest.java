package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import junit.framework.TestCase;

import org.op4j.Op;
import org.op4j.commands.ISelect;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.ConverterUtils;

public class Iter1IterableArrayMapOperatorTest extends TestCase {

	HashMap<Integer, String[]> integerArrayStringMap = new HashMap<Integer, String[]>();
	Iter1IterableArrayMapOperator<Integer, String> integerStringOperator;
	
	HashMap<Integer, Calendar[]> integerArrayCalendarMap = new HashMap<Integer, Calendar[]>();
	Iter1IterableArrayMapOperator<Integer, Calendar> integerCalendarOperator;
	
	ArrayList<String> stringList;
	
	protected void setUp() throws Exception {
		super.setUp();
				
		this.stringList = new ArrayList<String>();
		this.stringList.add("this");
		this.stringList.add("is");
		this.stringList.add("a");
		this.stringList.add("test");
		this.integerArrayStringMap.put(Integer.valueOf(10), this.stringList.toArray(new String[0]));

		ArrayList<Calendar> aux2 = new ArrayList<Calendar>();
		aux2.add(Calendar.getInstance());
		this.integerArrayCalendarMap.put(Integer.valueOf(10), aux2.toArray(new Calendar[0]));
		
		this.integerStringOperator = Op.onList(Arrays.asList(this.integerArrayStringMap)).each().asArrayMap(Integer.class, String.class);
		this.integerCalendarOperator = Op.onList(Arrays.asList(this.integerArrayCalendarMap)).each().asArrayMap(Integer.class, Calendar.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testSortKeysComparatorOfQsuperK() {
		Set<Integer> operatorMapKeys = this.integerCalendarOperator.sortKeys(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}			
		}).getTargets().get(0).get().keySet();
		Collections.sort(new ArrayList<Integer>(this.integerArrayCalendarMap.keySet()), new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Iterator<Integer> operatorMapKeysIterator = operatorMapKeys.iterator();
		for (Integer mapKey : this.integerArrayCalendarMap.keySet()) {
			assertEquals(mapKey, operatorMapKeysIterator.next());
		}		
	}

	public final void testEachValue() {
		List<String> results = this.integerStringOperator.eachValue().eval("#target + #param[0]", " - updated")
			.unsafeUneachList(String.class).getTargets().get(0).get();
		
		int index = 0;
		for (String string : this.stringList) {
			assertEquals(results.get(index++), string + " - updated");
		}
		
		assertEquals(null, this.integerStringOperator.eachValue().eval("#target + #param[0]", " - updated")
			.getOperatorType());
	}

	@SuppressWarnings("boxing")
	public final void testEachListValue() {
		List<Integer> results = this.integerCalendarOperator.eachArrayValue()
			.eval("#target[0].get(#param[0])", Calendar.MILLISECOND)
			.uneachList(Integer.class).getTargets().get(0).get();
		
		int index = 0;
		for (Calendar[] mapCalendarList : this.integerArrayCalendarMap.values()) {
			assertEquals(Integer.valueOf(mapCalendarList[0].get(Calendar.MILLISECOND)), 
					results.get(index++));
		}		
	}

	public final void testUneachMapClassOfXClassOfYStringStringObjectArray() {
		Iter0IterableMapOperator<Integer, Integer> result = this.integerStringOperator.uneachMap(Integer.class, 
				Integer.class, "#target.entrySet().iterator().next().getKey()", "#target.size()");
				
		assertEquals(result.get().get(this.integerArrayStringMap.keySet().iterator().next()),
				Integer.valueOf(this.integerArrayStringMap.size()));
		
		assertEquals(Types.INTEGER, result.getOperatorKeyType());
		assertEquals(Types.INTEGER, result.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Integer>"),
				result.getTargetTypeScheme());		
	}

	public final void testEachFilterEntryFilterOfEntryOfKV() {
		Iter1IterableArrayMapOperator<Integer, String> result = this.integerStringOperator.eachFilterEntry(new ISelect<Map.Entry<Integer, String>>() {
			public boolean eval(SelectorContext<Entry<Integer, String>> ctx) {
				return true;
			}			
		});
		
		for (Entry<Integer, String[]> entry : result.getTargets().get(0).get().entrySet()) {
			assertEquals(0, entry.getValue().length);
		}	
		
		assertEquals(Types.INTEGER, result.getOperatorKeyType());
		assertEquals(Types.STRING, result.getOperatorValueType());
	}

	public final void testMergeValuesStringObjectArray() {
		Iter1IterableMapOperator<Integer, ?> result =
			this.integerCalendarOperator.mergeValues("#target.length + #param[0]", Integer.valueOf(10));
		
		assertEquals(Integer.valueOf(this.integerArrayCalendarMap.values().iterator().next().length + 10),
				result.getTargets().get(0).get().get(this.integerArrayCalendarMap.keySet().iterator().next()));
	}
	
}
