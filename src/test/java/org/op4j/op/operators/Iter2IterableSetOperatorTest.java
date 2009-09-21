package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import junit.framework.TestCase;

import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.op.Op;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;

public class Iter2IterableSetOperatorTest extends TestCase {

	Iter2IterableSetOperator<Calendar> calendarOperator;
	Iter2IterableSetOperator<Integer> integerOperator;
	Set<Calendar> calendarSet = new HashSet<Calendar>();
	Set<Integer> integerSet = new HashSet<Integer>();
	
	protected void setUp() throws Exception {
		super.setUp();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");		
		Calendar calendar20081010 = Calendar.getInstance();
		calendar20081010.setTime(sdf.parse("20081010"));
		calendar20081010.add(Calendar.MILLISECOND, 10);
		Calendar calendar20080101 = Calendar.getInstance();
		calendar20080101.setTime(sdf.parse("20080101"));
		calendar20080101.add(Calendar.MILLISECOND, 30);		
		Calendar calendar20080301 = Calendar.getInstance();
		calendar20080301.setTime(sdf.parse("20080301"));
		calendar20080301.add(Calendar.MILLISECOND, 40);		
		Calendar calendar20080421 = Calendar.getInstance();
		calendar20080421.setTime(sdf.parse("20080421"));
		calendar20080421.add(Calendar.MILLISECOND, 43);		
		this.calendarSet.add(calendar20081010);
		this.calendarSet.add(calendar20080101);
		this.calendarSet.add(calendar20080301);
		this.calendarSet.add(calendar20080421);
		this.calendarOperator = Op.onSet(Calendar.class, this.calendarSet).generic().buildList().each().buildList().each()
			.asSet(Calendar.class);
		
		this.integerSet.add(Integer.valueOf(10));
		this.integerSet.add(Integer.valueOf(0));
		this.integerSet.add(Integer.valueOf(20));
		this.integerOperator = Op.onSet(Integer.class, this.integerSet).generic().buildList().each().buildList().each()
			.asSet(Integer.class);
		
	}

	public final void testEachExecUniqClassOfXStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.integerOperator.eachExecUniq(String.class, 
						DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargets().get(0).getTargets().get(0).get().iterator().next());
		
		try {
			assertEquals("Dummy operation result: 1",
					this.calendarOperator.eachExecUniq(Calendar.class, 
							DummyOperationOnOneOrTwoTargets.OPERATION_NAME));
			fail("this.calendarOperator.execUniq(Calendar.class, ToJson.OPERATION_NAME) should have failed as it does " +
					"not return a Calendar but a String");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}

	public final void testEachFilterFilterOfT() {
		Filter<Calendar> theFilter = new Filter<Calendar>() {
			public boolean eval(FilterContext<Calendar> ctx) {
				return false;
			}			
		};		
		assertEquals(this.calendarSet, this.calendarOperator.eachFilter(theFilter)
				.getTargets().get(0).getTargets().get(0).get());	
	}

	public final void testEachCallStringObjectArray() {
		assertEquals(new HashSet<String>(Arrays.asList(new String[] {"10", "20", "30", "40"})), 
				Op.onSet(Integer.class, new HashSet<Integer>(Arrays.asList(new Integer[] {10, 20, 30, 40}))).generic().buildList()
					.each().buildList().each().asSet(Integer.class)
					.eachCall("toString").getTargets().get(0).getTargets().get(0).get());		
	}

}
