package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.op.Op;
import org.op4j.op.commands.IEval;
import org.op4j.op.intf.parameters.ISelect;
import org.op4j.type.Types;

public class Iter1GenericUniqTargetOperatorTest extends TestCase {

	List<Integer> integerList = new ArrayList<Integer>();
	List<Calendar> calendarList = new ArrayList<Calendar>();
	Iter1GenericUniqTargetOperator<Integer> integerOperator;
	Iter1GenericUniqTargetOperator<Calendar> calendarOperator;
	
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
		this.calendarList.add(this.aCalendar200006221300);
		
		this.integerOperator = Op.onList(Integer.class, this.integerList).each();
		this.calendarOperator = Op.onList(Calendar.class, this.calendarList).each();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testAsClassOfX() {
		try {
			this.integerOperator.as(String.class);
			fail("call to integerOperator.as(String.class) should have failed as it contains Integer elements instead of String ones");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
		
		this.integerOperator.as(Integer.class);		
	}

	@SuppressWarnings("boxing")
	public final void testCallClassOfXStringObjectArray() {
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals(Integer.valueOf(calendar.get(Calendar.MILLISECOND)),
					this.calendarOperator.call("get", Calendar.MILLISECOND)
					.getTargets().get(index++).get());
		}		
	}

	public final void testAsListClassOfX() {
		List<List<Calendar>> listOfCalendarList = new ArrayList<List<Calendar>>();
		listOfCalendarList.add(this.calendarList);
		listOfCalendarList.add(null);
		
		int index = 0;
		for (List<Calendar> list : listOfCalendarList) {
			assertEquals(list,
					Op.onList(listOfCalendarList).each().asList(Calendar.class)
					.getTargets().get(index++).get());	
		}
		
		// As list is not being iterated, the following is correct
		Op.onList(listOfCalendarList).each().asList(Integer.class);			
	}

	public final void testFilterItersFilterOfQsuperT() {
		assertEquals(4, this.calendarOperator.getTargets().size());
		assertEquals(2, this.calendarOperator.filter(new ISelect<Calendar>() {
			public boolean eval(SelectorContext<Calendar> ctx) {
				return Iter1GenericUniqTargetOperatorTest
				.this.aCalendar200006221300.equals(ctx.getTarget(0));
			}			
		}).getTargets().size());
	}

	public final void testUneachArray() {
		int index = 0;
		for (Integer integer : this.integerList) {
			assertEquals(integer, this.integerOperator.uneachArray()
					.get()[index++]);
		}
		assertTrue(Types.forName("Integer[]")
				.isAssignableFrom(this.integerOperator.uneachArray()
				.getTargets().get(0).getIntendedType()));
	}

	@SuppressWarnings("boxing")
	public final void testUneachListMapClassOfKStringObjectArray() {
		assertTrue(Types.forName("Map<Long, List<Calendar>>").isAssignableFrom(
				this.calendarOperator.uneachListMap(Long.class, "#target.getTimeInMillis()")
				.getTargets().get(0).getIntendedType()));
		assertEquals(2, this.calendarOperator.uneachListMap(Long.class, "#target.getTimeInMillis()")
			.getTargetObjects().get(0).get(this.aCalendar200006221300.getTimeInMillis()).size());
		
		assertTrue(Types.forName("Map<Long, List<Calendar>>").isAssignableFrom(
				this.calendarOperator.uneachListMap(Long.class, "#target.getTimeInMillis()")
				.getTargetTypeScheme().getType(0)));
	}

	public final void testExecStringObjectArray() {
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals("Dummy operation result: 1",
				this.calendarOperator.exec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME)
						.getTargets().get(index).get());
			index++;
		}	
	}

	public final void testToClassOfXObjectArray() {
		int index = 0;
		for (Integer integer : this.integerList) {
			assertEquals(integer.toString(), this.integerOperator.to(String.class).getTargets()
					.get(index++).get());
		}		
	}

	public final void testEvalClassOfXEvaluatorOfTX() {
		Iter1GenericUniqTargetOperator<Long> operator = this.calendarOperator.eval(Long.class, new IEval<Calendar, Long>() {
			public Long evaluate(EvalContext<Calendar> ctx) {
				return Long.valueOf(ctx.getTarget(0).getTimeInMillis());
			}			
		});
		int index = 0;
		for (Calendar calendar : this.calendarList) {
			assertEquals(calendar.getTimeInMillis(), operator.getTargets().get(index++).get().longValue());
		}		
	}

}
