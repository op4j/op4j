package org.op4j.op.operators;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter1IterableMapOperatorTest extends TestCase {

	HashMap<Integer, String> integerStringMap = new HashMap<Integer, String>();
	Iter1IterableMapOperator<Integer, String> integerStringOperator;
	
	HashMap<Integer, Calendar> integerCalendarMap = new HashMap<Integer, Calendar>();
	Iter1IterableMapOperator<Integer, Calendar> integerCalendarOperator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.integerStringMap.put(Integer.valueOf(10), "this");

		this.integerCalendarMap.put(Integer.valueOf(10), Calendar.getInstance());
		
		this.integerStringOperator = Op.onList(Arrays.asList(this.integerStringMap)).each().asMap(Integer.class, String.class);
		this.integerCalendarOperator = Op.onList(Arrays.asList(this.integerCalendarMap)).each().asMap(Integer.class, Calendar.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown(); 
	}

	@SuppressWarnings("unchecked")
	public final void testSortValues() {
		Calendar first = Calendar.getInstance();
		Calendar second = Calendar.getInstance();
		second.add(Calendar.YEAR, 1);
		
		Map<Integer, Calendar> map = new HashMap<Integer, Calendar>();
		map.put(Integer.valueOf(100), second);
		map.put(Integer.valueOf(200), first);
		
		Map<Integer, Calendar> result = Op.onList(Arrays.asList(map)).each().asMap(Integer.class, Calendar.class)
			.sortValues().getTargets().get(0).get();
		 
		assertEquals(first, result.entrySet().iterator().next().getValue());
		
		Iterator<Map.Entry<Integer,Calendar>> iterator = result.entrySet().iterator();
		iterator.next();
		assertEquals(second, iterator.next().getValue());
	}

	public final void testEachEntry() {
		assertEquals(Types.INTEGER, this.integerStringOperator.eachEntry().getOperatorKeyType());
		assertEquals(Types.STRING, this.integerStringOperator.eachEntry().getOperatorValueType());
		
		Iterator<String> originalMapIterator = this.integerStringMap.values().iterator();
		for (Object value : this.integerStringOperator.eachEntry()
				.evalOnValue("#target + #param[0]", " - updated").uneachMap()
					.getTargets().get(0).get().values()) {
			assertEquals(originalMapIterator.next() + " - updated", value);
		}
	}

	public final void testUneachList() {
		assertEquals(TypeSchemes.forName("List<Map<Integer,String>>"),
				this.integerStringOperator.uneachList().getTargetTypeScheme());		
	}

	@SuppressWarnings("boxing")
	public final void testUneachListMapMapBuilderOfObjectObjectMapOfKV() {
		assertEquals(TypeSchemes.forName("Map<?,List<?>>"),
				this.integerStringOperator.uneachListMap(
						new MapBuilder<Map<Integer,String>, Object, Object>() {
							public Object getKey(Map<Integer, String> target) {
								return target.size();
							}
							public Object getValue(Map<Integer, String> target) {
								return Arrays.asList(target.size());
							}							
						}).getTargetTypeScheme());	
		assertEquals(null,
				this.integerStringOperator.uneachListMap(
						new MapBuilder<Map<Integer,String>, Object, Object>() {
							public Object getKey(Map<Integer, String> target) {
								return target.size();
							}
							public Object getValue(Map<Integer, String> target) {
								return Arrays.asList(target.size());
							}							
						}).getOperatorKeyType());	
		assertEquals(null,
				this.integerStringOperator.uneachListMap(
						new MapBuilder<Map<Integer,String>, Object, Object>() {
							public Object getKey(Map<Integer, String> target) {
								return target.size();
							}
							public Object getValue(Map<Integer, String> target) {
								return Arrays.asList(target.size());
							}							
						}).getOperatorValueType());	
		assertTrue(this.integerStringOperator.uneachListMap(
						new MapBuilder<Map<Integer,String>, Object, Object>() {
							public Object getKey(Map<Integer, String> target) {
								return target.size();
							}
							public Object getValue(Map<Integer, String> target) {
								return Arrays.asList(target.size());
							}							
						}).get().containsKey(this.integerStringMap.size()));	
	}

	public final void testEachValueEvalStringObjectArray() {
		for (Map.Entry<Integer, Calendar> entry : this.integerCalendarMap.entrySet()) {
			assertEquals(entry.getValue().get(Calendar.MILLISECOND), 
					this.integerCalendarOperator.eachValueEval("#target.get(#param[0])", Calendar.MILLISECOND)
					.getTargets().get(0).get().get(entry.getKey()));
		}
		
		assertEquals(null, 
				this.integerCalendarOperator.eachValueEval("#target.get(#param[0])", Calendar.MILLISECOND)
				.getOperatorValueType());		
	}

	public final void testEachValueToClassOfXObjectArray() {
		for (Map.Entry<Integer, Calendar> entry : this.integerCalendarMap.entrySet()) {
			assertEquals(entry.getValue().toString(), 
					this.integerCalendarOperator.eachValueTo(String.class)
					.getTargets().get(0).get().get(entry.getKey()));
		}
		
		assertEquals(Types.STRING, 
				this.integerCalendarOperator.eachValueTo(String.class)
				.getOperatorValueType());
	}

}
