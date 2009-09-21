package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.UniqResultConverterUtils;

public class Iter3GenericUniqTargetOperatorTest extends TestCase {

	private Iter3GenericUniqTargetOperator<Calendar> calendarOperator;
	private String pattern;
	Calendar aCalendar;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.aCalendar = Calendar.getInstance();
		this.pattern = "yyyyMMdd-HH:mm";
		
		this.calendarOperator =
			Op.on(Calendar.class, this.aCalendar).buildList().each().buildList().each().buildList().each();
	
	}

	public final void testExec() {
		assertEquals(new SimpleDateFormat(this.pattern).format(this.aCalendar.getTime()),
				this.calendarOperator.exec(UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.STRING), this.pattern)
			.getTargets().get(0).getTargets().get(0).getTargets().get(0).uniq().get());
		assertEquals(TypeSchemes.STRING_TYPESCHEME,
				this.calendarOperator.exec(UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.STRING), this.pattern)
			.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
	}

	public final void testToTypeObjectArray() {
		assertEquals(new SimpleDateFormat(this.pattern).format(this.aCalendar.getTime()),
				this.calendarOperator.to(Types.STRING, this.pattern)
			.getTargets().get(0).getTargets().get(0).getTargets().get(0).get());
		assertEquals(TypeSchemes.STRING_TYPESCHEME,
				this.calendarOperator.to(Types.STRING, this.pattern)
			.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
	}

	public final void testEvalClassOfXStringObjectArray() {
		assertEquals(this.aCalendar.toString(),
				this.calendarOperator.eval(String.class, "toString()")
			.getTargets().get(0).getTargets().get(0).getTargets().get(0).get());
		assertEquals(TypeSchemes.STRING_TYPESCHEME,
				this.calendarOperator.eval(String.class, "toString()")
			.getTargets().get(0).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
	}

}
