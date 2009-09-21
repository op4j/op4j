package org.op4j.op.operators;

import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.exceptions.NonUniqueTargetException;
import org.op4j.op.Op;
import org.op4j.op.interfaces.Filter;
import org.op4j.op.interfaces.FilterContext;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.UniqResultConverterUtils;

public class Iter3GenericMultiTargetOperatorTest extends TestCase {

	private Iter3GenericMultiTargetOperator<Calendar> calendarOperator;
	private Iter3GenericMultiTargetOperator<Integer> integerOperator;
	private Calendar aCalendar200006221300;
	private String pattern;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.aCalendar200006221300 = Calendar.getInstance();
		this.aCalendar200006221300.set(Calendar.YEAR, 2000);
		this.aCalendar200006221300.set(Calendar.MONTH, 05);
		this.aCalendar200006221300.set(Calendar.DAY_OF_MONTH, 22);
		this.aCalendar200006221300.set(Calendar.HOUR_OF_DAY, 13);
		this.aCalendar200006221300.set(Calendar.MINUTE, 0);
		this.aCalendar200006221300 = DateUtils.truncate(this.aCalendar200006221300, Calendar.MINUTE);		
		
		this.pattern = "yyyyMMdd-HH:mm";
		
		this.calendarOperator =
			Op.onAll(Calendar.class, this.aCalendar200006221300, Calendar.getInstance())
				.buildList().each().buildList().each().buildList().each().add(null);
		
		this.integerOperator =
			Op.onAll(Integer.class, Integer.valueOf(10), Integer.valueOf(20), Integer.valueOf(30))
				.buildList().each().buildList().each().buildList().each().add(null);
		
	}

	public final void testChooseSome() {
		assertEquals(1,
				this.calendarOperator.chooseSome(0).size());
		assertEquals(2,
				this.calendarOperator.chooseSome(0, 1).size());
		assertEquals(null,
				this.calendarOperator.chooseSome(1).getTargets().get(0).getTargets().get(0).getTargets().get(0).uniq().get());
		
	}

	public final void testUniq() {
		try {
			this.calendarOperator.uniq();
			fail("uniq should have failed as the operator contains more than one target");
		} catch (NonUniqueTargetException e) {
			// do nothing
		}
		
		this.calendarOperator.filter(new Filter<Calendar>() {
			public boolean eval(FilterContext<Calendar> ctx) {
				return true;
			}			
		}).uniq();
		
		final AtomicBoolean ab = new AtomicBoolean(true);
		this.calendarOperator.filter(new Filter<Calendar>() {
			public boolean eval(FilterContext<Calendar> ctx) {
				return ab.getAndSet(false);
			}			
		}).uniq();
	}

	public final void testFilterStringObjectArray() {
		assertEquals(0, this.calendarOperator.filter("true").size());

		assertEquals(2, this.calendarOperator.filter("#param[0]", Boolean.FALSE).size());
		
	}

	public final void testExecUniqStringObjectArray() {
		Iter3GenericMultiTargetOperator<Integer> calendarAsStringOperator = 
			Op.onAll(Integer.class, Integer.valueOf(2000), Integer.valueOf(6), Integer.valueOf(22), Integer.valueOf(13), Integer.valueOf(0))
				.buildList().each().buildList().each().buildList().each()
				.addAll(Integer.valueOf(6), Integer.valueOf(22), Integer.valueOf(13), Integer.valueOf(0));
		
		assertEquals(this.aCalendar200006221300, calendarAsStringOperator.execUniq(
				UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.CALENDAR)).as(Calendar.class)
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).get());
		
		assertEquals(TypeSchemes.CALENDAR_TYPESCHEME, calendarAsStringOperator.execUniq(
				UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.CALENDAR)).as(Calendar.class)
				.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
	}

}
