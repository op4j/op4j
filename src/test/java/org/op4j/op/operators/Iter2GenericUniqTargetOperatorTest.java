package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.op.Op;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter2GenericUniqTargetOperatorTest extends TestCase {

	List<Integer> integerList = new ArrayList<Integer>();
	List<Calendar> calendarList = new ArrayList<Calendar>();
	Iter2GenericUniqTargetOperator<Integer> integerOperator;
	Iter2GenericUniqTargetOperator<Calendar> calendarOperator;
	
	private Calendar aCalendar200006221300;
		
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
		this.calendarList.add(Calendar.getInstance());
		this.calendarList.add(Calendar.getInstance());
		this.calendarList.add(Calendar.getInstance());
		
		this.integerOperator = Op.onList(this.integerList).each().buildList().each().as(Integer.class);
		this.calendarOperator = Op.onList(this.calendarList).each().buildList().each().as(Calendar.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testCastString() {
		assertEquals(TypeSchemes.forClasses(GregorianCalendar.class), Op.onList(this.calendarList).each().buildList().each()
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		
		assertEquals(TypeSchemes.forSingleClass(Calendar.class), Op.onList(this.calendarList).each().buildList().each()
			.cast(TypeSchemes.forSingleClass(Calendar.class).getName()).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());		
		
		// Cast is valid...as would not
		Op.onList(this.calendarList).each().buildList().each()
				.cast(TypeSchemes.forSingleClass(Calendar.class).getName()).getTargets().get(0).getTargets().get(0).getTargetTypeScheme();		
	}

	public final void testCallStringObjectArray() {
		assertEquals(this.calendarList.get(0).get(Calendar.MILLISECOND), this.calendarOperator.call("get", Calendar.MILLISECOND).getTargets().get(0).getTargets().get(0).get());
		assertEquals(TypeSchemes.INTEGER_TYPESCHEME, this.calendarOperator.call("get", Calendar.MILLISECOND).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(null, this.calendarOperator.call("get", Calendar.MILLISECOND).uneachList().getOperatorComponentType());
	}

	public final void testAsMapClassOfKClassOfV() {
		List<HashMap<Integer,Integer>> integerIntegerMapList = new ArrayList<HashMap<Integer,Integer>>();
		Op.onList(integerIntegerMapList)
			.each().buildList().each().as(Object.class).asMap(Integer.class, Integer.class);
		
		assertEquals(Types.INTEGER, Op.onList(integerIntegerMapList)
				.each().buildList().each().as(Object.class).asMap(Integer.class, Integer.class)
				.getOperatorKeyType());
		assertEquals(Types.INTEGER, Op.onList(integerIntegerMapList)
				.each().buildList().each().as(Object.class).asMap(Integer.class, Integer.class)
				.getOperatorValueType());
	}

	public final void testUneachMapClassOfKClassOfVStringStringObjectArray() {
		assertEquals(Types.INTEGER, this.calendarOperator.uneachMap(Integer.class, Calendar.class, "#target.get(#param[0])",
				"#target", Calendar.MILLISECOND).getOperatorKeyType());
		assertEquals(Types.CALENDAR, this.calendarOperator.uneachMap(Integer.class, Calendar.class, "#target.get(#param[0])",
				"#target", Calendar.MILLISECOND).getOperatorValueType());
		assertEquals(this.calendarList.get(0), 
				this.calendarOperator.uneachMap(Integer.class, Calendar.class, "#target.get(#param[0])",
				"#target", Calendar.MILLISECOND).uneachList().get()
				.get(0).get(this.calendarList.get(0).get(Calendar.MILLISECOND)));
	}

	public final void testInsObj() {
		assertEquals(Integer.valueOf(333), 
				this.integerOperator.insObj(0, Integer.valueOf(333))
				.getTargets().get(1).getTargets().get(0).getTargetObjects()
				.get(0));
		assertEquals(2, 
				this.integerOperator.insObj(0, Integer.valueOf(333))
				.getTargets().get(1).getTargets().get(0).getTargetObjects()
				.size());
	}

}
