package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter2MapEntryOperatorTest extends TestCase {

	String pattern = "yyyyMMdd-HH:mm";
	
	Iter2MapEntryOperator<Integer, Calendar> integerCalendarOperator;
	Iter2MapEntryOperator<Integer, String> integerIntegerAsStringOperator;
	
	Integer integerKey;
	String integerAsStringValue;
	Calendar calendar200810101400Value;
	Map.Entry<Integer, Calendar> integerCalendarMapEntry;
	Map.Entry<Integer, String> integerIntegerAsStringMapEntry;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		this.integerKey = Integer.valueOf(10);
		this.integerAsStringValue = "333";		
		SimpleDateFormat sdf = new SimpleDateFormat(this.pattern);
		this.calendar200810101400Value = Calendar.getInstance();
		this.calendar200810101400Value.setTime(sdf.parse("20081010-14:00"));
		
		Map<Integer, Calendar> integerCalendarMap = new HashMap<Integer, Calendar>();
		integerCalendarMap.put(this.integerKey, this.calendar200810101400Value);
		this.integerCalendarMapEntry = integerCalendarMap.entrySet().iterator().next();
		
		Map<Integer, String> integerStringMap = new HashMap<Integer, String>();
		integerStringMap.put(this.integerKey, this.integerAsStringValue);
		this.integerIntegerAsStringMapEntry = integerStringMap.entrySet().iterator().next();
		
		this.integerIntegerAsStringOperator = Op.onMapEntry(Integer.class, String.class, this.integerIntegerAsStringMapEntry)
			.generic().buildList().each().buildList().each().asMapEntry(Integer.class, String.class);
		this.integerCalendarOperator = Op.onMapEntry(Integer.class, Calendar.class, this.integerCalendarMapEntry)
			.generic().buildList().each().buildList().each().asMapEntry(Integer.class, Calendar.class);
	}

	public final void testToOnValueTypeObjectArray() {
		assertEquals(Integer.valueOf(333),
				this.integerIntegerAsStringOperator.toOnValue(Types.INTEGER)
				.getTargets().get(0).getTargets().get(0).getTargetObjects().get(0).getValue());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, ?>"),
				this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER)
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, ?>").getName(),
				this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER)
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme().getName());
		assertTrue(TypeSchemes.forName("Map$Entry<Integer, String>").getName().compareTo(
				this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER)
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme().getName()) != 0);
	}

	public final void testToStrOnValue() {
		assertEquals(this.integerCalendarMapEntry.getValue().toString(),
				this.integerCalendarOperator.toStrOnValue()
				.getTargets().get(0).getTargets().get(0).getTargetObjects().get(0).getValue());	
	}

	public final void testCastMapEntryTypeType() {
		assertEquals(Types.INTEGER, Op.onMapEntry(this.integerCalendarMapEntry).generic().buildList().each().buildList().each().asMapEntry(Integer.class, Calendar.class)
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getOperatorKeyType());
		assertEquals(Types.CALENDAR, Op.onMapEntry(this.integerCalendarMapEntry).generic().buildList().each().buildList().each().asMapEntry(Integer.class, Calendar.class)
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Calendar>"), Op.onMapEntry(this.integerCalendarMapEntry).generic().buildList().each().buildList().each().asMapEntry(Integer.class, Calendar.class)
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Calendar>"), Op.onMapEntry(this.integerCalendarMapEntry).generic().buildList().each().buildList().each().asMapEntry(Integer.class, Calendar.class)
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
		
		try {
			Op.onMapEntry(this.integerCalendarMapEntry).castMapEntry(Types.OBJECT, Types.INTEGER);
			fail("Op.onMapEntry(this.integerCalendarMapEntry).castMapEntry(Types.OBJECT, Types.INTEGER) should have failed due to wrong types");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	public final void testCallOnValueStringObjectArray() {
		assertEquals(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND), 
				this.integerCalendarOperator.callOnValue("get", Calendar.MILLISECOND)
				.getTargets().get(0).getTargets().get(0).get().getValue());
		assertEquals(null,
				this.integerCalendarOperator.callOnValue("get", Calendar.MILLISECOND)
				.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,?>"),
				this.integerCalendarOperator.callOnValue("get", Calendar.MILLISECOND)
				.getTargets().get(0).getTargets().get(0).getTargetTypeScheme());
	}

}
