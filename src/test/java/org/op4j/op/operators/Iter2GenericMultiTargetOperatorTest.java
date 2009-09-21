package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.op.Op;
import org.op4j.operation.Operations;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter2GenericMultiTargetOperatorTest extends TestCase {

	List<Integer> integerList = new ArrayList<Integer>();
	List<Calendar> calendarList = new ArrayList<Calendar>();
	Iter2GenericMultiTargetOperator<Integer> integerOperator;
	Iter2GenericMultiTargetOperator<Calendar> calendarOperator;
	
	private Calendar aCalendar200006221300;
	
	protected void setUp() throws Exception {
		super.setUp();
			
		Operations.addOperationImplementation(DummyOperationOnOneOrTwoTargets.class);
		
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
		
		this.integerOperator = Op.onList(this.integerList).each().buildList().each().addObj(Integer.valueOf(100)).as(Integer.class);
		this.calendarOperator = Op.onList(this.calendarList).each().buildList().each().addObj(this.aCalendar200006221300).as(Calendar.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		
	}

	public final void testCastTypeScheme() {
		
		assertEquals(TypeSchemes.forClasses(GregorianCalendar.class, Object.class), Op.onList(this.calendarList).each().buildList().each().addObj(this.aCalendar200006221300)
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		
		assertEquals(TypeSchemes.forSingleClass(Calendar.class, 2), Op.onList(this.calendarList).each().buildList().each().addObj(this.aCalendar200006221300)
			.cast(TypeSchemes.forSingleType(Types.CALENDAR, 2)).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());		
		
		// Cast is valid...as would not
		Op.onList(this.calendarList).each().buildList().each().addObj(this.aCalendar200006221300)
				.cast(TypeSchemes.forSingleType(Types.CALENDAR, 2)).getTargets().get(0).getTargets().get(0).getTargetTypeScheme();		
	}

	public final void testChoose() {
		assertEquals(1, this.calendarOperator.choose(0).getTargets().get(0).size());
		assertEquals(this.aCalendar200006221300, this.calendarOperator.choose(1).getTargets().get(0).getTargets().get(0).get());		
	}

	public final void testUniq() {
		try {
			this.calendarOperator.uniq();
			fail("this.calendarOperator.uniq() should have failed as it contains more than one target");
		} catch (NonUniqueTargetException e) {
			// do nothing
		}
		
		this.calendarOperator.exec(DummyOperationOnOneOrTwoTargets.OPERATION_NAME, new Object[]{})
			.uniq();
	}

	public final void testAddObj() {
		assertEquals(Integer.valueOf(333), 
				this.integerOperator.addObj(Integer.valueOf(333))
				.getTargets().get(2).getTargets().get(0).getTargetObjects()
				.get(2));
	}

	public final void testInsAllObjs() {
		assertEquals(Integer.valueOf(333), 
				this.integerOperator.insAllObjs(0, Integer.valueOf(333))
				.getTargets().get(2).getTargets().get(0).getTargetObjects()
				.get(0));
		assertEquals(3, 
				this.integerOperator.insAllObjs(0, Integer.valueOf(333))
				.getTargets().get(2).getTargets().get(0).getTargetObjects()
				.size());
	}

	    
}
