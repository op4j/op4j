package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter2IterableMapOperatorTest extends TestCase {

	Iter2IterableMapOperator<Integer, Calendar> integerCalendarOperator;
	Iter2IterableMapOperator<Integer, String> integerStringOperator;
	final List<Integer> keys = new ArrayList<Integer>();
	final List<Calendar> calendarValues = new ArrayList<Calendar>();
	final List<String> stringValues = new ArrayList<String>();
	Map<Integer, Calendar> integerCalendarMap = new HashMap<Integer, Calendar>();
	Map<Integer, String> integerStringMap = new HashMap<Integer, String>();
	
	protected void setUp() throws Exception {
		super.setUp();
		
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
		
		this.integerStringOperator = Op.onMap(Integer.class, String.class, this.integerStringMap).generic().buildList()
			.each().buildList().each().asMap(Integer.class, String.class);
		this.integerCalendarOperator = Op.onMap(Integer.class, Calendar.class, this.integerCalendarMap).generic().buildList()
			.each().buildList().each().asMap(Integer.class, Calendar.class);
		
	}

	public final void testSortValues() {
		List<Calendar> aux = new ArrayList<Calendar>(this.calendarValues);		
		Collections.sort(aux);
		
		assertEquals(aux.size(), this.integerCalendarOperator.sortValues().getTargets().get(0).getTargets().get(0).get().values().size());
		int index = 0;
		for (Map.Entry<Integer, Calendar> entry : this.integerCalendarOperator.sortValues().getTargets().get(0).getTargets().get(0).get().entrySet()) {
			assertTrue(entry.getValue().compareTo(aux.get(index)) == 0);
			index++;
		}		
	}

	public final void testEachKey() {
		List<String> list = new ArrayList<String>();
		for (Integer integer : this.keys) {
			list.add(integer.toString());
		}
		assertTrue(list.containsAll( 
				this.integerCalendarOperator.eachKey()
				.eval("toString()")
				.uneachList(String.class).getTargets().get(0).getTargets().get(0).get()));
		assertTrue(this.integerCalendarOperator.eachKey()
				.eval("toString()")
				.uneachList(String.class).getTargets().get(0).getTargets().get(0).get()
				.containsAll(list));
		assertEquals(list.size(), this.integerCalendarOperator.eachKey()
				.eval("toString()")
				.uneachList(String.class).getTargets().get(0).getTargets().get(0).get().size());
	}

	public final void testEachEntry() {
		List<Integer> result = new ArrayList<Integer>();
		for (String string : this.stringValues) {
			result.add(Integer.valueOf(string.length()));
		}
		
		assertEquals(result.size(),
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargets().get(0).getTargets().get(0).get().values().size());
		assertTrue(result.containsAll(
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargets().get(0).getTargets().get(0).get().values()));
		assertTrue(this.integerStringOperator.eachEntry().evalOnValue("length()")
				.uneachMap().getTargets().get(0).getTargets().get(0).get().values()
				.containsAll(result));
		
		assertEquals(Types.INTEGER,
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargets().get(0).getTargets().get(0).getOperatorKeyType());
		assertEquals(null,
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargets().get(0).getTargets().get(0).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Integer, ?>"),
				this.integerStringOperator.eachEntry().evalOnValue("length()")
			.uneachMap().getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		
	}

}
