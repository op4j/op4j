package org.op4j.op.operators;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.op4j.Op;
import org.op4j.executables.IEval;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.ConverterUtils;

public class Iter0MapEntryOperatorTest extends TestCase {

	String pattern = "yyyyMMdd-HH:mm";
	
	Iter0MapEntryOperator<Integer, Calendar> integerCalendarOperator;
	Iter0MapEntryOperator<Integer, String> integerIntegerAsStringOperator;
	
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
		
		this.integerIntegerAsStringOperator = Op.onMapEntry(Integer.class, String.class, this.integerIntegerAsStringMapEntry);
		this.integerCalendarOperator = Op.onMapEntry(Integer.class, Calendar.class, this.integerCalendarMapEntry);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testGeneric() {
		assertEquals(this.integerCalendarMapEntry, 
				this.integerCalendarOperator.generic().get());
	}

	public final void testExecStringObjectArray() {				
		assertEquals(Integer.valueOf(333), this.integerIntegerAsStringOperator
				.execOnValue(ConverterUtils.unsafeGetOperationNameForResultType(Types.INTEGER))
				.getTargetObjects().get(0).getValue());
	}

	public final void testExecClassOfXStringObjectArray() {
		assertEquals(Integer.valueOf(333), this.integerIntegerAsStringOperator
				.execOnValue(Integer.class, ConverterUtils.unsafeGetOperationNameForResultType(Types.INTEGER))
				.getTargetObjects().get(0).getValue());
		assertTrue(Types.forName("Map$Entry<?, Integer>")
				.isAssignableFrom(this.integerIntegerAsStringOperator
				.execOnValue(Integer.class, ConverterUtils.unsafeGetOperationNameForResultType(Types.INTEGER))
				.getTargets().get(0).getIntendedType()));
	}

	public final void testToTypeObjectArray() {
		assertEquals(Integer.valueOf(333),
				this.integerIntegerAsStringOperator.toOnValue(Types.INTEGER)
				.getTargetObjects().get(0).getValue());
		assertTrue(Types.forName("Map$Entry<Integer, ?>")
				.isAssignableFrom(this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER)
				.getTargets().get(0).getIntendedType()));
		
		assertEquals(Types.forName("Map$Entry<Integer, ?>").getName(),
				this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER)
				.getTargetTypeScheme().getName());
		assertTrue(Types.forName("Map$Entry<Integer, String>").getName().compareTo(
				this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER)
				.getTargetTypeScheme().getName()) != 0);
		
	}

	public final void testToStringObjectArray() {
				
		assertEquals(Integer.valueOf(333),
				this.integerIntegerAsStringOperator.toOnValue(Types.INTEGER.getName())
				.getTargetObjects().get(0).getValue());
		assertTrue(Types.forName("Map$Entry<Integer, ?>")
				.isAssignableFrom(this.integerIntegerAsStringOperator
				.toOnValue(Types.INTEGER.getName())
				.getTargets().get(0).getIntendedType()));
	}

	public final void testToClassOfXObjectArray() {
		assertEquals(Integer.valueOf(333),
				this.integerIntegerAsStringOperator.toOnValue(Integer.class)
				.getTargetObjects().get(0).getValue());
		assertTrue(Types.forName("Map$Entry<?, Integer>")
				.isAssignableFrom(this.integerIntegerAsStringOperator
				.toOnValue(Integer.class)
				.getTargets().get(0).getIntendedType()));
	}

	public final void testToByte() {
		// No conversion to Byte available for Iter0MapEntryOperator
	}

	public final void testToShort() {
		// No conversion to Short available for Iter0MapEntryOperator
	}

	public final void testToInteger() {
		// No conversion to Integer available for Iter0MapEntryOperator
	}

	public final void testToLong() {
		// No conversion to Long available for Iter0MapEntryOperator
	}

	public final void testToFloat() {
		// No conversion to Float available for Iter0MapEntryOperator
	}

	public final void testToDouble() {
		// No conversion to Double available for Iter0MapEntryOperator
	}

	public final void testToBigInteger() {
		// No conversion to BigInteger available for Iter0MapEntryOperator
	}

	public final void testToBigDecimal() {
		// No conversion to BigDecimal available for Iter0MapEntryOperator
	}

	public final void testToAtomicInteger() {
		// No conversion to AtomicInteger available for Iter0MapEntryOperator
	}

	public final void testToAtomicLong() {
		// No conversion to AtomicLong available for Iter0MapEntryOperator
	}

	public final void testToBoolean() {
		// No conversion to Boolean available for Iter0MapEntryOperator
	}

	public final void testToCalendar() {
		// No conversion to Calendar available for Iter0MapEntryOperator
	}

	public final void testToStr() {
		assertEquals(this.integerCalendarMapEntry.getValue().toString(),
				this.integerCalendarOperator.toStrOnValue()
				.getTargetObjects().get(0).getValue());		
	}

		
	@SuppressWarnings("boxing")
	public final void testEvalStringObjectArray() {
		assertEquals(this.calendar200810101400Value
				.get(Calendar.MILLISECOND), 
				this.integerCalendarOperator.evalOnValue("get(#param[0])", Calendar.MILLISECOND)
			.get().getValue());		
	}

	public final void testEvalClassOfXStringObjectArray() {
		assertEquals(Integer.valueOf(this.calendar200810101400Value
				.get(Calendar.MILLISECOND)), 
				this.integerCalendarOperator.evalOnValue(Integer.class,
						"get(#param[0])", Calendar.MILLISECOND)
			.get().getValue());	
	}

	public final void testEvalEvaluatorOfVObject() {
		
		assertEquals(this.calendar200810101400Value.getTimeInMillis(),
				this.integerCalendarOperator.evalOnValue(new IEval<Calendar, Object>() {
			public Long evaluate(EvalContext<Calendar> ctx) {
				return Long.valueOf(ctx.getTarget(0).getTimeInMillis());
			}			
		}).asMapEntry(Integer.class, Long.class).get().getValue().longValue());
	}

	@SuppressWarnings("boxing")
	public final void testCallStringObjectArray() {
		assertEquals(this.calendar200810101400Value.get(Calendar.MONTH),
				this.integerCalendarOperator.callOnValue("get", Calendar.MONTH)
			.get().getValue());
	}

	public final void testCallClassOfXStringObjectArray() {
		assertEquals(this.calendar200810101400Value.get(Calendar.MONTH),
				this.integerCalendarOperator.callOnValue(Integer.class,
						"get", Calendar.MONTH)
			.get().getValue().intValue());
		assertTrue(Types.forName("Map$Entry<?, Integer>")
				.isAssignableFrom(
						this.integerCalendarOperator.callOnValue(Integer.class,
								"get", Calendar.MONTH)
						.getTargets().get(0).getIntendedType()));
	}

	public final void testGet() {
		assertEquals(this.integerIntegerAsStringMapEntry, this.integerIntegerAsStringOperator
				.get());
	}

	public final void testSize() {
		assertEquals(1, this.integerCalendarOperator.size());
	}

	public final void testRaw() {
		assertEquals(Types.INTEGER, this.integerCalendarOperator.getOperatorKeyType());
		assertEquals(Types.CALENDAR, this.integerCalendarOperator.getOperatorValueType());
				
		assertEquals(null, this.integerCalendarOperator.raw().getOperatorKeyType());
		assertEquals(null, this.integerCalendarOperator.raw().getOperatorValueType());
	}

	public final void testAsMapEntry() {		
		assertEquals(Types.INTEGER, this.integerCalendarOperator
				.asMapEntry(Integer.class, Calendar.class).getOperatorKeyType());
		assertEquals(Types.CALENDAR, this.integerCalendarOperator
				.asMapEntry(Integer.class, Calendar.class).getOperatorValueType());
		
		try {
			this.integerCalendarOperator.asMapEntry(Object.class, Integer.class);
			fail("integerCalendarOperator.asMapEntry(Object.class, Integer.class) should have failed due to wrong types");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
		
		assertEquals(Types.INTEGER, Op.onMapEntry(this.integerCalendarMapEntry)
				.asMapEntry(Integer.class, Calendar.class).getOperatorKeyType());
		assertEquals(null, Op.onMapEntry(this.integerCalendarMapEntry)
				.getOperatorKeyType());
	}

	public final void testCastMapEntryStringString() {
		assertEquals(null, Op.onMapEntry(this.integerCalendarMapEntry)
				.castMapEntry(Types.INTEGER.getName(), Types.CALENDAR.getName()).getOperatorKeyType());
		assertEquals(null, Op.onMapEntry(this.integerCalendarMapEntry)
				.castMapEntry(Types.INTEGER.getName(), Types.CALENDAR.getName()).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,GregorianCalendar>"), Op.onMapEntry(this.integerCalendarMapEntry)
				.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Calendar>"), Op.onMapEntry(this.integerCalendarMapEntry)
				.castMapEntry(Types.INTEGER.getName(), Types.CALENDAR.getName()).getTargetTypeScheme());
		
		try {
			Op.onMapEntry(this.integerCalendarMapEntry).castMapEntry(Types.OBJECT.getName(), Types.INTEGER.getName());
			fail("Op.onMapEntry(this.integerCalendarMapEntry).castMapEntry(Types.OBJECT.getName(), Types.INTEGER.getName()) should have failed due to wrong types");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	public final void testCastMapEntryTypeType() {
		assertEquals(null, Op.onMapEntry(this.integerCalendarMapEntry)
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getOperatorKeyType());
		assertEquals(null, Op.onMapEntry(this.integerCalendarMapEntry)
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,GregorianCalendar>"), Op.onMapEntry(this.integerCalendarMapEntry)
				.getTargetTypeScheme());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Calendar>"), Op.onMapEntry(this.integerCalendarMapEntry)
				.castMapEntry(Types.INTEGER, Types.CALENDAR).getTargetTypeScheme());
		
		try {
			Op.onMapEntry(this.integerCalendarMapEntry).castMapEntry(Types.OBJECT, Types.INTEGER);
			fail("Op.onMapEntry(this.integerCalendarMapEntry).castMapEntry(Types.OBJECT, Types.INTEGER) should have failed due to wrong types");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}	

	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Calendar>"), 
				this.integerCalendarOperator.getTargetTypeScheme());
	}

	public final void testGetTargetObjects() {
		assertEquals(1, this.integerCalendarOperator.getTargetObjects().size());
		assertEquals(this.integerCalendarMapEntry, 
				this.integerCalendarOperator.getTargetObjects().get(0));
	}

	@SuppressWarnings("boxing")
	public final void testEvalOnValueStringObjectArray() {
		assertEquals(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND), this.integerCalendarOperator.evalOnValue("get(#param[0])", Calendar.MILLISECOND)
			.get().getValue());
		assertEquals(null,
				this.integerCalendarOperator.evalOnValue("get(#param[0])", Calendar.MILLISECOND)
				.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,?>"),
				this.integerCalendarOperator.evalOnValue("get(#param[0])", Calendar.MILLISECOND)
				.getTargetTypeScheme());
	}

	@SuppressWarnings("boxing")
	public final void testEvalOnValueClassOfXStringObjectArray() {
		assertEquals(Integer.valueOf(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND)), 
				this.integerCalendarOperator.evalOnValue(Integer.class, "get(#param[0])", Calendar.MILLISECOND)
				.get().getValue());
		assertEquals(Types.INTEGER,
				this.integerCalendarOperator.evalOnValue(Integer.class, "get(#param[0])", Calendar.MILLISECOND)
				.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Integer>"),
				this.integerCalendarOperator.evalOnValue(Integer.class, "get(#param[0])", Calendar.MILLISECOND)
				.getTargetTypeScheme());
	}

	public final void testEvalOnValueClassOfXEvaluatorOfVX() {
		assertEquals(Integer.valueOf(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND)), 
				this.integerCalendarOperator.evalOnValue(Integer.class, new IEval<Calendar, Integer>() {
					@SuppressWarnings("boxing")
					public Integer evaluate(EvalContext<Calendar> ctx) {
						return ctx.getTarget(0).get(Calendar.MILLISECOND);
					}				
				}).get().getValue());
		assertEquals(Types.INTEGER,
				this.integerCalendarOperator.evalOnValue(Integer.class, new IEval<Calendar, Integer>() {
					@SuppressWarnings("boxing")
					public Integer evaluate(EvalContext<Calendar> ctx) {
						return ctx.getTarget(0).get(Calendar.MILLISECOND);
					}
				}).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Integer>"),
				this.integerCalendarOperator.evalOnValue(Integer.class, new IEval<Calendar, Integer>() {
					@SuppressWarnings("boxing")
					public Integer evaluate(EvalContext<Calendar> ctx) {
						return ctx.getTarget(0).get(Calendar.MILLISECOND);
					}
				}).getTargetTypeScheme());
	}

	public final void testEvalOnValueEvaluatorOfVObject() {
		assertEquals(Integer.valueOf(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND)), 
				this.integerCalendarOperator.evalOnValue(new IEval<Calendar, Object>() {
					@SuppressWarnings("boxing")
					public Integer evaluate(EvalContext<Calendar> ctx) {
						return ctx.getTarget(0).get(Calendar.MILLISECOND);
					}				
				}).get().getValue());
		assertEquals(null,
				this.integerCalendarOperator.evalOnValue(new IEval<Calendar, Object>() {
					@SuppressWarnings("boxing")
					public Integer evaluate(EvalContext<Calendar> ctx) {
						return ctx.getTarget(0).get(Calendar.MILLISECOND);
					}
				}).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,?>"),
				this.integerCalendarOperator.evalOnValue(new IEval<Calendar, Object>() {
					@SuppressWarnings("boxing")
					public Integer evaluate(EvalContext<Calendar> ctx) {
						return ctx.getTarget(0).get(Calendar.MILLISECOND);
					}
				}).getTargetTypeScheme());
	}

	public final void testCallOnValueStringObjectArray() {
		assertEquals(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND), 
				this.integerCalendarOperator.callOnValue("get", Calendar.MILLISECOND)
				.get().getValue());
		assertEquals(null,
				this.integerCalendarOperator.callOnValue("get", Calendar.MILLISECOND)
				.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,?>"),
				this.integerCalendarOperator.callOnValue("get", Calendar.MILLISECOND)
				.getTargetTypeScheme());
	}

	public final void testCallOnValueClassOfXStringObjectArray() {
		assertEquals(Integer.valueOf(this.integerCalendarMapEntry.getValue().get(Calendar.MILLISECOND)), 
				this.integerCalendarOperator.callOnValue(Integer.class, "get", Calendar.MILLISECOND)
				.get().getValue());
		assertEquals(Types.INTEGER,
				this.integerCalendarOperator.callOnValue(Integer.class, "get", Calendar.MILLISECOND)
				.getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map$Entry<Integer,Integer>"),
				this.integerCalendarOperator.callOnValue(Integer.class, "get", Calendar.MILLISECOND)
				.getTargetTypeScheme());
	}
}
