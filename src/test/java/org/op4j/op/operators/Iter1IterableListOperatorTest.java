package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.commands.IEval;
import org.op4j.op.Op;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.ConverterUtils;

public class Iter1IterableListOperatorTest extends TestCase {

	List<Integer> integerList = new ArrayList<Integer>();
	List<Calendar> calendarList = new ArrayList<Calendar>();
	Iter1IterableListOperator<Integer> integerOperator;
	Iter1IterableListOperator<Calendar> calendarOperator;
	
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
		
		List<List<Integer>> intList = new ArrayList<List<Integer>>();
		intList.add(this.integerList);
		this.integerOperator = Op.onList(intList).each().asList(Integer.class);
		List<List<Calendar>> calList = new ArrayList<List<Calendar>>();
		calList.add(this.calendarList);
		this.calendarOperator = Op.onList(calList).each().asList(Calendar.class);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testRaw() {
		assertEquals(Types.CALENDAR, this.calendarOperator.getOperatorComponentType());
		assertEquals(null, this.calendarOperator.raw().getOperatorComponentType());
	}

	public final void testEachExecClassOfXStringObjectArray() {
		
		List<String> result = this.integerOperator.eachExec(String.class, 
				ConverterUtils.unsafeGetOperationNameForResultType(Types.STRING))
				.uneachList().get().get(0);
		
		int index = 0;
		for (Integer integer : this.integerList) {
			assertEquals(integer.toString(), result.get(index++));
		}		
	}

	public final void testDistinct() {
		this.integerList.add(this.integerList.get(0));
				
		assertEquals(this.integerList.size(), this.integerOperator.getTargets().get(0).get().size());
		assertEquals(this.integerList.size() - 1, this.integerOperator.distinct().getTargets().get(0).get().size());
	}

	public final void testUneachMapClassOfKClassOfVStringStringObjectArray() {
		Map<Long, Integer> result = this.calendarOperator.uneachMap(Long.class, Integer.class, 
				"#target.get(0).getTimeInMillis()", "#target.size()").get();
		
		assertTrue(result.containsKey(this.calendarList.get(0).getTimeInMillis()));
		assertEquals(this.calendarList.size(), result.get(this.calendarList.get(0).getTimeInMillis()).intValue());
		
		assertEquals(Types.LONG, this.calendarOperator.uneachMap(Long.class, Integer.class, 
				"#target.get(0).getTimeInMillis()", "#target.size()").getOperatorKeyType());
		assertEquals(Types.INTEGER, this.calendarOperator.uneachMap(Long.class, Integer.class, 
				"#target.get(0).getTimeInMillis()", "#target.size()").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Long, Integer>"), 
				this.calendarOperator.uneachMap(Long.class, Integer.class, 
				"#target.get(0).getTimeInMillis()", "#target.size()").getTargetTypeScheme());
	}

	public final void testToMapClassOfKClassOfVStringStringObjectArray() {
		Map<Long, Calendar> result = this.calendarOperator.toMap(Long.class, Calendar.class, 
				"#target.getTimeInMillis()", "#target").getTargets().get(0).get();
		
		assertTrue(result.containsKey(this.calendarList.get(0).getTimeInMillis()));
		assertEquals(this.calendarList.get(0), result.get(this.calendarList.get(0).getTimeInMillis()));
		
		assertEquals(Types.LONG, this.calendarOperator.toMap(Long.class, Calendar.class, 
				"#target.getTimeInMillis()", "#target").getOperatorKeyType());
		assertEquals(Types.CALENDAR, this.calendarOperator.toMap(Long.class, Calendar.class, 
				"#target.getTimeInMillis()", "#target").getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<Long, Calendar>"), 
				this.calendarOperator.toMap(Long.class, Calendar.class, 
				"#target.getTimeInMillis()", "#target").getTargets().get(0).getTargetTypeScheme());
	}

	public final void testEachEvalClassOfXEvaluatorOfTX() {
		List<String> result = this.integerOperator.eachEval(String.class, 
				new IEval<Integer, String>() {
					public String evaluate(EvalContext<Integer> ctx) {
						return ctx.getTarget(0).toString();
					}			
		}).uneachList().get().get(0);
		
		int index = 0;
		for (Integer integer : this.integerList) {
			assertEquals(integer.toString(), result.get(index++));
		}		
	}

	public final void testEachToStringObjectArray() {
		List<String> result = this.integerOperator.eachTo(String.class)
				.uneachList().get().get(0);
		
		int index = 0;
		for (Integer integer : this.integerList) {
			assertEquals(integer.toString(), result.get(index++));
		}		
	}

}
