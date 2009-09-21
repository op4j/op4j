package org.op4j.op.operators;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.op.Op;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter1MapEntryOperatorTest extends TestCase {

	Map.Entry<Integer, String> integerStringMapEntry;
	Iter1MapEntryOperator<Integer, String> integerStringOperator;
	
	Map.Entry<Integer, Calendar> integerCalendarMapEntry;
	Iter1MapEntryOperator<Integer, Calendar> integerCalendarOperator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		HashMap<Integer, String> integerStringMap = new HashMap<Integer, String>();
		HashMap<Integer, Calendar> integerCalendarMap = new HashMap<Integer, Calendar>();
		
		integerStringMap.put(Integer.valueOf(10), "this");
		this.integerStringMapEntry = integerStringMap.entrySet().iterator().next();
		
		integerCalendarMap.put(Integer.valueOf(10), Calendar.getInstance());
		this.integerCalendarMapEntry = integerCalendarMap.entrySet().iterator().next();
		
		this.integerStringOperator = Op.onMap(Integer.class, String.class, integerStringMap).eachEntry();
		this.integerCalendarOperator = Op.onMap(Integer.class, Calendar.class, integerCalendarMap).eachEntry();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testRaw() {
		
		assertEquals(Types.INTEGER, this.integerCalendarOperator.getOperatorKeyType());
		assertEquals(Types.CALENDAR, this.integerCalendarOperator.getOperatorValueType());
		
		assertEquals(null, this.integerCalendarOperator.raw().getOperatorKeyType());
		assertEquals(null, this.integerCalendarOperator.raw().getOperatorValueType());
		
	}

	public final void testToStrOnValue() {
		assertEquals(Types.STRING, this.integerCalendarOperator.toStrOnValue().getOperatorValueType());
		assertEquals(this.integerCalendarMapEntry.getValue().toString(), this.integerCalendarOperator.toStrOnValue().getTargets()
				.get(0).get().getValue());
	}

	public final void testCastMapEntryTypeType() {
		// It only changes intendedType
		
		assertEquals(Types.INTEGER, 
				this.integerStringOperator.castMapEntry(Types.INTEGER, Types.STRING).getOperatorKeyType());
		
		assertEquals(Types.STRING, 
				this.integerStringOperator.castMapEntry(Types.INTEGER, Types.STRING).getOperatorValueType());
		
		Map<Integer, Calendar> map = new HashMap<Integer, Calendar>();
		map.put(this.integerCalendarMapEntry.getKey(), this.integerCalendarMapEntry.getValue());
		
		assertEquals(null, Op.onMap(map).eachEntry().getOperatorKeyType());
		assertEquals(null, Op.onMap(map).eachEntry().getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, GregorianCalendar>"), Op.onMap(map).eachEntry()
				.getTargets().get(0).getTargetTypeScheme());
	
		assertEquals(null, Op.onMap(map).eachEntry()
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getOperatorKeyType());
		assertEquals(null, Op.onMap(map).eachEntry()
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getOperatorValueType());
		assertEquals(null, Op.onMap(map).eachEntry()
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getTargets().get(0).getOperatorKeyType());
		assertEquals(null, Op.onMap(map).eachEntry()
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getTargets().get(0).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer, Calendar>"), Op.onMap(map).eachEntry()
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getTargets().get(0).getTargetTypeScheme());		
	}

	public final void testCallOnValueClassOfXStringObjectArray() {
		
		assertEquals(Integer.valueOf(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND)),
				this.integerCalendarOperator.callOnValue(Integer.class, "get", Calendar.MILLISECOND)
				.getTargets().get(0).get().getValue());
		assertEquals(Types.INTEGER,
				this.integerCalendarOperator.callOnValue(Integer.class, "get", Calendar.MILLISECOND)
				.getOperatorValueType());
		assertEquals(Types.INTEGER,
				this.integerCalendarOperator.callOnValue(Integer.class, "get", Calendar.MILLISECOND)
				.getTargets().get(0).getOperatorValueType());		
	}
}
