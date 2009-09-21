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

import org.op4j.op.Op;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.UniqResultConverterUtils;

public class Iter1IterableListMapOperatorTest extends TestCase {

	HashMap<Integer, ArrayList<String>> integerListStringMap = new HashMap<Integer, ArrayList<String>>();
	Iter1IterableListMapOperator<Integer, String> integerStringOperator;
	
	HashMap<Integer, ArrayList<Calendar>> integerListCalendarMap = new HashMap<Integer, ArrayList<Calendar>>();
	Iter1IterableListMapOperator<Integer, Calendar> integerCalendarOperator;
	
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
		
		this.integerStringOperator = Op.onList(Arrays.asList(this.integerListStringMap)).each().asListMap(Integer.class, String.class);
		this.integerCalendarOperator = Op.onList(Arrays.asList(this.integerListCalendarMap)).each().asListMap(Integer.class, Calendar.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testExecUniqClassOfXStringObjectArray() {
		Map<Integer, List<String>> result = this.integerCalendarOperator.eachExecUniqValue(String.class, UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.STRING))
			.getTargets().get(0).get();
		
		for (Map.Entry<Integer, ArrayList<Calendar>> entry : this.integerListCalendarMap.entrySet()) {
			assertEquals(entry.getValue().toString(), result.get(entry.getKey()).toString());			
		}		
	}

	public final void testSortKeysComparatorOfQsuperK() {
		Set<Integer> operatorMapKeys = this.integerCalendarOperator.sortKeys(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}			
		}).getTargets().get(0).get().keySet();
		Collections.sort(new ArrayList<Integer>(this.integerListCalendarMap.keySet()), new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		Iterator<Integer> operatorMapKeysIterator = operatorMapKeys.iterator();
		for (Integer mapKey : this.integerListCalendarMap.keySet()) {
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
		List<Integer> results = this.integerCalendarOperator.eachListValue()
			.eval("#target.get(0).get(#param[0])", Calendar.MILLISECOND)
			.uneachList(Integer.class).getTargets().get(0).get();
		
		int index = 0;
		for (List<Calendar> mapCalendarList : this.integerListCalendarMap.values()) {
			assertEquals(Integer.valueOf(mapCalendarList.get(0).get(Calendar.MILLISECOND)), 
					results.get(index++));
		}		
	}

	public final void testUneachMapClassOfXClassOfYStringStringObjectArray() {
		Iter0IterableMapOperator<Integer, Integer> result = this.integerStringOperator.uneachMap(Integer.class, 
				Integer.class, "#target.entrySet().iterator().next().getKey()", "#target.size()");
				
		assertEquals(result.get().get(this.integerListStringMap.keySet().iterator().next()),
				Integer.valueOf(this.integerListStringMap.size()));
		
		assertEquals(Types.INTEGER, result.getOperatorKeyType());
		assertEquals(Types.INTEGER, result.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, Integer>"),
				result.getTargetTypeScheme());		
	}

	public final void testEachFilterEntryFilterOfEntryOfKV() {
		Iter1IterableListMapOperator<Integer, String> result = this.integerStringOperator.eachFilterEntry(new Filter<Map.Entry<Integer, String>>() {
			public boolean eval(FilterContext<Entry<Integer, String>> ctx) {
				return true;
			}			
		});
		
		for (Entry<Integer, List<String>> entry : result.getTargets().get(0).get().entrySet()) {
			assertEquals(0, entry.getValue().size());
		}	
		
		assertEquals(Types.INTEGER, result.getOperatorKeyType());
		assertEquals(Types.STRING, result.getOperatorValueType());
	}

	public final void testMergeValuesStringObjectArray() {
		Iter1IterableMapOperator<Integer, ?> result =
			this.integerCalendarOperator.mergeValues("#target.size() + #param[0]", Integer.valueOf(10));
		
		assertEquals(Integer.valueOf(this.integerListCalendarMap.values().iterator().next().size() + 10),
				result.getTargets().get(0).get().get(this.integerListCalendarMap.keySet().iterator().next()));
	}	
}
