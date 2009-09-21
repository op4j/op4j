package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.exceptions.NullTargetException;
import org.op4j.op.Op;

public class Iter2IterableListOperatorTest extends TestCase {

	List<Integer> integerList = new ArrayList<Integer>();
	List<Calendar> calendarList = new ArrayList<Calendar>();
	Iter2IterableListOperator<Integer> integerOperator;
	Iter2IterableListOperator<Calendar> calendarOperator;
	
	Calendar aCalendar200006221300;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.aCalendar200006221300 = Calendar.getInstance();
		this.aCalendar200006221300.set(Calendar.YEAR, 2000);
		this.aCalendar200006221300.set(Calendar.MONTH, 05);
		this.aCalendar200006221300.set(Calendar.DAY_OF_MONTH, 22);
		this.aCalendar200006221300.set(Calendar.HOUR_OF_DAY, 13);
		this.aCalendar200006221300.set(Calendar.MINUTE, 0);
		this.aCalendar200006221300 = DateUtils.truncate(this.aCalendar200006221300, Calendar.MINUTE);
		
		this.integerList.add(Integer.valueOf(10));
		this.integerList.add(Integer.valueOf(20));
		this.integerList.add(Integer.valueOf(30));
		
		this.calendarList.add(Calendar.getInstance());
		this.calendarList.add(this.aCalendar200006221300);
		this.calendarList.add(Calendar.getInstance());
		Calendar aux = Calendar.getInstance();
		aux.setTime(this.aCalendar200006221300.getTime());
		this.calendarList.add(aux);
		
		List<List<Integer>> intList = new ArrayList<List<Integer>>();
		intList.add(this.integerList);
		this.integerOperator = Op.onList(intList).each().buildList().each().asList(Integer.class);
		List<List<Calendar>> calList = new ArrayList<List<Calendar>>();
		calList.add(this.calendarList);
		this.calendarOperator = Op.onList(calList).each().buildList().each().asList(Calendar.class);
	}

	public final void testDistinct() {
		assertEquals(new ArrayList<Calendar>(new LinkedHashSet<Calendar>(this.calendarList)), this.calendarOperator.distinct().getTargets().get(0).getTargets().get(0).get());
		
	}

	public final void testEach() {
		List<Calendar> updated = new ArrayList<Calendar>();
		for (Calendar calendar : this.calendarList) {
			Calendar aux = Calendar.getInstance();
			aux.setTime(calendar.getTime());
			aux.add(Calendar.YEAR, 1);		
			updated.add(aux);				
		}
				
		assertEquals(updated, this.calendarOperator
				.each()
				.eval("add(#param[0], #param[1]), #target", Calendar.YEAR, 1).uneachList()
				.getTargets().get(0).getTargets().get(0).get());				
	}

	public final void testToArray() {
		Calendar[] result1 = (Calendar[]) this.calendarOperator.toArray().getTargets().get(0).getTargets().get(0).get();
		Calendar[] result2 = this.calendarList.toArray(new Calendar[]{});
		
		assertEquals(result1.length, result2.length);
		for(int index = 0; index < result1.length; index++) {
			assertTrue(result1[index].compareTo(result2[index]) == 0);
		}	
	}

	public final void testEachEvalClassOfXStringObjectArray() {
		List<String> result = this.integerOperator.eachEval(String.class, 
				"#target.toString()").getTargets().get(0).getTargets().get(0).get();
		
		int index = 0;
		for (Integer integer : this.integerList) {
			assertEquals(integer.toString(), result.get(index++));
		}	
	}

	public final void testEachCallClassOfXStringObjectArray() {
		assertEquals(Arrays.asList(new String[] {"10"}), 
				Op.onList(Integer.class, Arrays.asList(new Integer[] {10, 20, 30, 40}))
			.each().buildList().each().buildList().asList(Integer.class)
			.eachCall(String.class, "toString").getTargets().get(0).getTargets().get(0).get());
		
		try {
			Op.onList(Integer.class, null)
				.eachCall(String.class, "toString");
			fail("Call to Op.onArray(Integer.class, null).eachCall(String.class, \"toString\")" +
					" should have failed as it contains a null target");
		} catch (NullTargetException e) {
			// do nothing
		}
	}

}
