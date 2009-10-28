package org.op4j.op.operators;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.Op;
import org.op4j.executables.ISelect;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.ConverterUtils;

public class Iter1IterableSetOperatorTest extends TestCase {

	HashSet<Integer> integerSet = new HashSet<Integer>();
	HashSet<Calendar> calendarSet = new HashSet<Calendar>();
	Iter1IterableSetOperator<Integer> integerOperator;
	Iter1IterableSetOperator<Calendar> calendarOperator;
	
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
		
		this.integerSet.add(Integer.valueOf(10));
		this.integerSet.add(Integer.valueOf(20));
		this.integerSet.add(Integer.valueOf(30));
		
		this.calendarSet.add(Calendar.getInstance());
		this.calendarSet.add(this.aCalendar200006221300);
		this.calendarSet.add(Calendar.getInstance());
		this.calendarSet.add(this.aCalendar200006221300);
		
		Set<HashSet<Integer>> intSet = new HashSet<HashSet<Integer>>();
		intSet.add(this.integerSet);
		this.integerOperator = Op.onSet(intSet).each().asSet(Integer.class);
		Set<HashSet<Calendar>> calSet = new HashSet<HashSet<Calendar>>();
		calSet.add(this.calendarSet);
		this.calendarOperator = Op.onSet(calSet).each().asSet(Calendar.class);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testEachExecClassOfXStringObjectArray() {
		Set<String> result = this.integerOperator.eachExec(String.class, 
				ConverterUtils.unsafeGetOperationNameForResultType(Types.STRING))
				.uneachList().get().get(0);
		
		Iterator<String> iterator = result.iterator();
		for (Integer integer : this.integerSet) {
			assertEquals(integer.toString(), iterator.next());
		}		
	}

	public final void testGeneric() {
		assertEquals(Types.forName("Integer"),
				this.integerOperator.getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<Integer>"),
				this.integerOperator.generic().getTargets().get(0).getTargetTypeScheme());		
	}

	public final void testUneachArray() {
		Set<Calendar>[] result = this.calendarOperator.uneachArray().get();
		
		assertTrue(ArrayUtils.contains(result, this.calendarSet));
		
		assertEquals(Types.forName("Set<Calendar>"), this.calendarOperator.uneachArray().getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<Calendar>[]"), 
				this.calendarOperator.uneachArray().getTargetTypeScheme());
	}

	public final void testEachFilterFilterOfT() {
		assertEquals(0, this.integerOperator.eachFilter(new ISelect<Integer>() {
			public boolean eval(SelectorContext<Integer> ctx) {
				return true;
			}			
		}).getTargets().get(0).get().size());
		assertEquals(this.integerSet.size(), this.integerOperator.eachFilter(new ISelect<Integer>() {
			public boolean eval(SelectorContext<Integer> ctx) {
				return false;
			}			
		}).getTargets().get(0).get().size());
	}

	@SuppressWarnings("unchecked")
	public final void testEachEvalStringObjectArray() {
		Set result = this.integerOperator.eachEval("#target.toString()")
			.uneachList().get().get(0);
		
		Iterator iterator = result.iterator();
		for (Integer integer : this.integerSet) {
			assertEquals(integer.toString(), iterator.next());
		}	
		
		assertEquals(Types.CALENDAR, this.calendarOperator.getOperatorComponentType());
		assertEquals(null, this.calendarOperator
				.eachEval("#param[0]", new StringBuffer("test")).getOperatorComponentType());
	}

	public final void testEachToClassOfXObjectArray() {
		Set<String> result = this.integerOperator.eachTo(String.class)
			.uneachList().get().get(0);

		Iterator<String> iterator = result.iterator();
		for (Integer integer : this.integerSet) {
			assertEquals(integer.toString(), iterator.next());
		}	
		
		assertEquals(Types.CALENDAR, this.calendarOperator.getOperatorComponentType());
		assertEquals(Types.STRING, this.calendarOperator.eachTo(String.class).getOperatorComponentType());
	}
}
