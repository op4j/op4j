package org.op4j.op.operators;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.Op;
import org.op4j.commands.IEval;
import org.op4j.commands.IMapBuild;
import org.op4j.exceptions.OperationExecutionException;
import org.op4j.operation.ListMapTarget;
import org.op4j.operation.SetMapTarget;
import org.op4j.operation.Target;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.ConverterUtils;

public class Iter0GenericUniqTargetOperatorTest extends TestCase {

	private Iter0GenericUniqTargetOperator<Integer> integerOperator;
	private Iter0GenericUniqTargetOperator<Object> integerArrayOperator;
	private Iter0GenericUniqTargetOperator<Object> objectListOperator;
	private Iter0GenericUniqTargetOperator<Object> integerListOperator;
	private Iter0GenericUniqTargetOperator<Calendar> calendarOperator;
	private Iter0GenericUniqTargetOperator<Calendar> calendarOperator200006221300;
	private Iter0GenericUniqTargetOperator<?> nullOperator;
	private Iter0GenericUniqTargetOperator<Dummy> dummyOperator;
	private Integer[] anIntegerArray;
	private List<Object> anObjectList;
	private Map<String, Calendar> stringCalendarMap;
	private Map<String, Object> stringObjectMap;
	private Calendar aCalendar200006221300;
	private Date aDate200006221300;
	private String aDate200006221300AsString;
	private String pattern;
	private Dummy aDummy;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		Integer anInteger = Integer.valueOf(100);
		
		this.anIntegerArray = new Integer[4];
		this.anIntegerArray[0] = Integer.valueOf(10);
		this.anIntegerArray[1] = Integer.valueOf(20);
		this.anIntegerArray[2] = Integer.valueOf(30);
		this.anIntegerArray[3] = Integer.valueOf(40);
		
		this.anObjectList = new ArrayList<Object>();
		this.anObjectList.add(Integer.valueOf(45));
		this.anObjectList.add(Calendar.getInstance());
		
		List<Integer> anIntegerList = Arrays.asList(this.anIntegerArray);
		
		Calendar aCalendar = Calendar.getInstance();
		
		this.aCalendar200006221300 = Calendar.getInstance();
		this.aCalendar200006221300.set(Calendar.YEAR, 2000);
		this.aCalendar200006221300.set(Calendar.MONTH, 05);
		this.aCalendar200006221300.set(Calendar.DAY_OF_MONTH, 22);
		this.aCalendar200006221300.set(Calendar.HOUR_OF_DAY, 13);
		this.aCalendar200006221300.set(Calendar.MINUTE, 0);
		this.aCalendar200006221300 = DateUtils.truncate(this.aCalendar200006221300, Calendar.MINUTE);
		
		this.stringObjectMap = new HashMap<String, Object>();
		this.stringObjectMap.put("a", this.aCalendar200006221300);
		this.stringObjectMap.put("b", Integer.valueOf(10));
		
		this.stringCalendarMap = new HashMap<String, Calendar>();
		this.stringCalendarMap.put("a", this.aCalendar200006221300);
		this.stringCalendarMap.put("b", Calendar.getInstance());
				
		this.aDate200006221300 = this.aCalendar200006221300.getTime();
		
		this.aDate200006221300AsString =  "20000622-13:00";
		this.pattern = "yyyyMMdd-HH:mm";
		
		Calendar from = Calendar.getInstance();
		from.setTime(this.aDate200006221300);
		this.aDummy = new Dummy("Class to perform tests",
				from, Calendar.getInstance());
		
		this.integerOperator =
			Op.on(Integer.class, anInteger);
		
		this.integerArrayOperator =
			Op.on(Object.class, this.anIntegerArray);
		
		this.integerListOperator =
			Op.on(Object.class, anIntegerList);
		
		this.objectListOperator =
			Op.on(Object.class, this.anObjectList);
		
		this.calendarOperator =
				Op.on(Calendar.class, aCalendar);
		
		this.calendarOperator200006221300 =
			Op.on(Calendar.class, this.aCalendar200006221300);
		
		this.nullOperator =
			Op.on((Object) null);
		
		this.dummyOperator =
			Op.on(Dummy.class, this.aDummy);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public final void testAs() {				
		assertTrue(Integer.class.equals(
				this.integerOperator.of(Integer.class).get().getClass()));
		
		assertTrue(Integer.class.equals(
				this.integerOperator.of(Object.class).get().getClass()));
		
		assertTrue(Integer.class.equals(
				this.integerOperator.of(Object.class).of(Integer.class)
				.get().getClass()));
		
		try {
			this.integerOperator.of(String.class).get();
			fail("this.integerOperator.as(String.class).get() should have thrown an exception");
		} catch (IllegalArgumentException e) {		
			// do nothing			
		}
		
		try {
			this.calendarOperator.of(Date.class);
			fail("this.calendarOperator.as(Date.class) should have thrown an exception");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
				
		assertTrue(Calendar.class.isAssignableFrom(this.calendarOperator
				.of(Object.class)
				.of(Calendar.class)
				.get().getClass()));
		
		assertTrue(Calendar.class.isAssignableFrom(this.calendarOperator
				.of(Object.class)
				.get().getClass()));
		
		try {
			this.calendarOperator
					.of(String.class);
			fail("this.calendarOperator.as(String.class) should have thrown an exception");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
		
		assertFalse(String.class.equals(this.calendarOperator
				.of(Calendar.class).get().getClass()));	
	}
	
	public final void testCallStringObjectArray() {
		assertFalse(this.dummyOperator
				.call("isAvailable", Calendar.getInstance()).toBoolean().get().booleanValue());		
	}

	public final void testCallClassOfXStringObjectArray() {
		assertEquals(Boolean.class,
				this.dummyOperator
					.call(Boolean.class, "isAvailable", 
						Calendar.getInstance()).get().getClass());		
	}

	public final void testAsArray() {
        assertEquals(Types.forName("Object[]"), this.integerArrayOperator
                .asArray(Object.class).getTargets().get(0).getIntendedType());
        assertEquals(Types.forName("Object[]").getName(), this.integerArrayOperator
                .asArray(Object.class).getTargetTypeScheme().getName());
		assertEquals(Types.forName("Integer[]"), this.integerArrayOperator
				.asArray().getTargets().get(0).getIntendedType());
		assertEquals(Types.forName("Integer[]").getName(), this.integerArrayOperator
				.asArray().getTargetTypeScheme().getName());
		assertEquals(null, this.integerArrayOperator
				.asArray().getOperatorComponentType());
	}

	public final void testAsArrayClassOfX() {		
		assertEquals(Types.forName("Integer[]"), this.integerArrayOperator
				.asArray(Integer.class).getTargets().get(0).getIntendedType());	
		
		assertEquals(Types.forName("Integer[]").getName(), this.integerArrayOperator
				.asArray(Integer.class).getTargetTypeScheme().getName());	
		assertEquals(Types.INTEGER.getName(), this.integerArrayOperator
				.asArray(Integer.class).getOperatorComponentType().getName());	
		
		try {
			this.integerArrayOperator
				.asArray(Long.class);	
			fail("integerArrayOperator.asArray(Long.class) has not failed but it should");
		} catch (IllegalArgumentException e) {
			// do nothing			
		}
	}

	public final void testAsList() {
		assertTrue(Types.LIST.isAssignableFrom(this.objectListOperator
				.asList().getTargets().get(0).getIntendedType()));		
	}

	public final void testAsListClassOfX() {
		assertTrue(Types.forName("List<Integer>").isAssignableFrom(this.integerListOperator
				.asList(Integer.class).getTargets().get(0).getIntendedType()));				
	}

	public final void testAsSet() {
		assertTrue(Types.SET.isAssignableFrom(Op.on((Object) new HashSet<Object>(this.anObjectList))
			.asSet().getTargets().get(0).getIntendedType()));		
	}

	public final void testAsSetClassOfX() {
		assertTrue(Types.forName("Set<Integer>").isAssignableFrom(Op.on((Object) new HashSet<Object>(Arrays.asList(this.anIntegerArray)))
				.asSet(Integer.class).getTargets().get(0).getIntendedType()));	
	}

	public final void testAsMap() {
		assertTrue(Types.MAP.isAssignableFrom(
				Op.on((Object) this.stringObjectMap).asMap().getTargets().get(0).getIntendedType()));
	}

	public final void testAsMapClassOfKClassOfV() {
		assertTrue(Types.forName("Map<String, Calendar>").isAssignableFrom(
				Op.on((Object) this.stringCalendarMap).asMap(String.class, Calendar.class)
				.getTargets().get(0).getIntendedType()));		
	}

	public final void testAsListMap() {
		Map<String, List<Object>> stringObjectListMap = new HashMap<String, List<Object>>();
		stringObjectListMap.put("a", this.anObjectList);
		assertTrue(Types.forName("Map<?,List<?>>").isAssignableFrom(
				Op.on((Object) stringObjectListMap).asListMap().getTargets().get(0).getIntendedType()));
		assertEquals(Types.forName("Map<?,List<?>>").getName(), 
				Op.on((Object) stringObjectListMap).asListMap().getTargetTypeScheme().getName());
	}

	public final void testAsListMapClassOfKClassOfV() {
		Map<String, List<Integer>> stringIntegerListMap = new HashMap<String, List<Integer>>();
		stringIntegerListMap.put("a", Arrays.asList(this.anIntegerArray));
		
		assertTrue(Types.forName("Map<String, List<Integer>>").isAssignableFrom(
				Op.on((Object) stringIntegerListMap).asListMap(String.class, Integer.class)
				.getTargets().get(0).getIntendedType()));
		
	}

	public final void testAsMapEntry() {
		assertTrue(Types.MAP_ENTRY.isAssignableFrom(
				Op.on((Object) this.stringObjectMap.entrySet().iterator().next()).asMapEntry().getTargets().get(0).getIntendedType()));
	}

	public final void testAsMapEntryClassOfKClassOfV() {
		assertTrue(Types.forName("Map$Entry<String, Calendar>").isAssignableFrom(
				Op.on((Object) this.stringCalendarMap.entrySet().iterator().next()).asMapEntry(String.class, Calendar.class).getTargets().get(0).getIntendedType()));
	}

	public final void testGet() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator200006221300.get());
	}

	public final void testExec() {
		assertEquals(this.aDate200006221300AsString, this.calendarOperator200006221300.exec(
				ConverterUtils.unsafeGetOperationNameForResultType(Types.STRING), this.pattern).of(String.class)
				.getTargetObjects().get(0));
	}

	public final void testExecStringObjectArray() {
		assertEquals(this.aDate200006221300AsString, this.calendarOperator200006221300.exec(
				ConverterUtils.unsafeGetOperationNameForResultType(Types.STRING), this.pattern).of(String.class)
				.get());
	}

	public final void testExecClassOfXStringObjectArray() {
		assertEquals(this.aDate200006221300AsString, this.calendarOperator200006221300.exec(String.class,
				ConverterUtils.unsafeGetOperationNameForResultType(Types.STRING), this.pattern)
				.get());
	}

	public final void testToTypeObjectArray() {
		assertEquals(this.aDate200006221300AsString, this.calendarOperator200006221300.to(Types.STRING,
				this.pattern)
				.getTargetObjects().get(0));
	}

	public final void testToStringObjectArray() {
		assertEquals(this.aDate200006221300AsString,
				Op.on(this.aCalendar200006221300).to("String", this.pattern).getTargetObjects().get(0));		
	}

	public final void testToClassOfXObjectArray() {
		assertEquals(this.aDate200006221300AsString,
				Op.on(this.aCalendar200006221300).to(String.class, this.pattern).getTargetObjects().get(0));			
	}

	public final void testToByte() {
		
		assertEquals(Byte.valueOf((byte) 127),  
				Op.on(String.class, "127").convToByte().get());
		
		assertEquals(null,  
				this.nullOperator.of(String.class).convToByte().get());
		
		try {
			Op.on(String.class, "327").convToByte().get();
			fail("Op.on(String.class, \"327\").toByte() should have thrown an exception");
		} catch (OperationExecutionException e) {
			// do nothing
		}
	}

	public final void testToShort() {
		assertEquals(Short.valueOf("4"),  
				Op.on(Double.class, Double.valueOf(3.1)).toShort(RoundingMode.CEILING).get());
		
		assertEquals(Short.valueOf("4"),  
				Op.on(Double.class, Double.valueOf(4.2)).toShort().get());
		
		assertEquals(null,  
				this.nullOperator.of(Double.class).convToShort().get());
	}

	public final void testToInteger() {
		assertEquals(Integer.valueOf(3),  
				Op.on(Double.class, Double.valueOf(3.7)).convToInteger(RoundingMode.FLOOR).get());
		
		assertEquals(Integer.valueOf(4),  
				Op.on(Double.class, Double.valueOf(4.3)).convToInteger().get());
		
		assertEquals(null,  
				this.nullOperator.of(Double.class).convToInteger().get());
	}

	public final void testToLong() {
		assertEquals(Long.valueOf(13),  
				Op.on("13").toLong().get());
		
		assertEquals(Long.valueOf(4520),  
				Op.on("1515").toLong(Integer.valueOf(15)).get());
	}

	public final void testToFloat() {
		assertEquals(Float.valueOf(1300000),  
				Op.on("1300000").toFloat().get());
		
		try {
			NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
			Float aFloat = Float.valueOf(numberFormat.parse("4519999.5").floatValue());
			assertEquals(aFloat,  
					Op.on("4519999.6073").toFloat().get());
		} catch (ParseException e) {
			fail("This message should never be shown as it represents an error " +
					"creating a Doble to be used in the test");
		}
	}

	public final void testToDouble() {
		assertEquals(Double.valueOf(1300000),  
				Op.on("1300000").toDouble().get());
		
		try {
			NumberFormat numberFormat = NumberFormat.getInstance(Locale.ENGLISH);
			Double aDouble = Double.valueOf(numberFormat.parse("4519999.8").doubleValue());
			assertEquals(aDouble,  
					Op.on("4519999,73").toDouble(Integer.valueOf(1), RoundingMode.CEILING, "DECIMAL_IS_COMMA").get());
		} catch (ParseException e) {
			fail("This message should never be shown as it represents an error " +
					"creating a Doble to be used in the test");
		}
	}

	public final void testToBigInteger() {
		BigInteger aBigInteger = new BigInteger("764984793");
		
		assertEquals(aBigInteger,  
				Op.on(Integer.valueOf(764984793)).toBigInteger().get());				
	}

	public final void testToBigDecimal() {
		BigDecimal aBigDecimal = new BigDecimal(345);
		aBigDecimal = aBigDecimal.divide(new BigDecimal(4));
		
		assertEquals(aBigDecimal,  
				Op.on("86.25").toBigDecimal().get());		
	}

	public final void testToBoolean() {
		assertEquals(Boolean.TRUE,  
				Op.on(Integer.valueOf(-11)).toBoolean().get());
		
		assertEquals(Boolean.TRUE,  
				Op.on("yes").toBoolean().get());
		
		assertEquals(Boolean.FALSE,  
				Op.on(Integer.valueOf(0)).toBoolean().get());
	}

	public final void testToCalendar() {		
		assertEquals(0, this.aCalendar200006221300.compareTo( 
				Op.on(String.class, this.aDate200006221300AsString)
						.convToCalendar(this.pattern).get()));
		
		assertEquals(this.aCalendar200006221300,  
				Op.on(Date.class, this.aDate200006221300)
						.convToCalendar().get());
		
		assertEquals(null,  
				this.nullOperator
						.of(Date.class).convToCalendar().get());	
	}

	public final void testToStr() {		
		assertEquals(this.aDate200006221300AsString, 
				this.calendarOperator200006221300
				.convToString(this.pattern).get());
		
		assertEquals(0, this.aCalendar200006221300.compareTo( 
				Op.on(this.calendarOperator200006221300
						.convToString(this.aDate200006221300AsString).get())
						.convToCalendar(this.pattern).get()));
		
		try {
			this.calendarOperator.convToString().get();
		} catch (Exception e) {
			fail("toStrthis.calendarOperator.toStr() has not been executed correctly");
		}
		
		try {
			assertEquals(null, this.nullOperator.convToString().get());
		} catch (Exception e) {
			fail("toStrthis.nullOperator.toStr() has not been executed correctly");
		}
	}

	public final void testEvalStringObjectArray() {
		Calendar aux = Calendar.getInstance();
		aux.setTime(this.aCalendar200006221300.getTime());
		aux.add(Calendar.MILLISECOND, 1);
		assertTrue(this.dummyOperator.eval("#this.isAvailable(#param[0])", aux)
				.of(Boolean.class).get().booleanValue());
	}

	public final void testEvalClassOfXStringObjectArray() {
		Calendar aux = Calendar.getInstance();
		aux.setTime(this.aCalendar200006221300.getTime());
		aux.add(Calendar.MILLISECOND, 1);
		assertTrue(this.dummyOperator.eval(Boolean.class, "#this.isAvailable(#param[0])", aux)
				.getTargetObjects().get(0).booleanValue());
	}

	public final void testEvalClassOfXEvaluatorOfTX() {
		assertEquals(String.valueOf(this.integerOperator.get().intValue() + 10), 
			this.integerOperator.eval(String.class, new IEval<Integer, String>() {
				public String evaluate(EvalContext<Integer> ctx) {
					return String.valueOf(ctx.getTarget(0).intValue() + 10);
				}				
			}).getTargetObjects().get(0));		
	}

	public final void testBuildList() {
		assertTrue(Types.LIST.isAssignableFrom(this.integerOperator.buildList()
				.getTargets().get(0).getIntendedType()));		
		assertTrue(List.class.isAssignableFrom(this.integerOperator.buildList()
				.getTargetObjects().get(0).getClass()));	
	}

	public final void testBuildListClassOfX() {
		assertTrue(Types.forName("List<Integer>").isAssignableFrom(this.integerOperator.buildList(Integer.class)
				.getTargets().get(0).getIntendedType()));			
		assertTrue(Types.forName("List<Integer>").isAssignableFrom(this.nullOperator.buildList(Integer.class)
				.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildSet() {
		assertTrue(Types.SET.isAssignableFrom(this.integerOperator.buildSet()
				.getTargets().get(0).getIntendedType()));		
		assertTrue(Set.class.isAssignableFrom(this.integerOperator.buildSet()
				.getTargetObjects().get(0).getClass()));			
		assertFalse(List.class.isAssignableFrom(this.integerOperator.buildSet()
				.getTargetObjects().get(0).getClass()));	
		assertFalse(Types.forName("List<Object>").isAssignableFrom(this.nullOperator.buildSet()
				.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildSetClassOfX() {
		assertTrue(Types.forName("Set<Integer>").isAssignableFrom(this.integerOperator.buildSet(Integer.class)
				.getTargets().get(0).getIntendedType()));	
		assertTrue(Types.forName("Set<Integer>").isAssignableFrom(this.nullOperator.buildSet(Integer.class)
				.getTargets().get(0).getIntendedType()));			
	}

	public final void testBuildArray() {
		assertTrue(Types.OBJECT_ARRAY.isAssignableFrom(this.objectListOperator.buildArray()
				.getTargets().get(0).getIntendedType()));		
		assertTrue(Types.OBJECT_ARRAY.isAssignableFrom(this.nullOperator.buildArray()
				.getTargets().get(0).getIntendedType()));			
		assertFalse(Types.LIST.isAssignableFrom(this.objectListOperator.buildArray()
				.getTargets().get(0).getIntendedType()));		
	}

	public final void testBuildArrayClassOfX() {
		assertTrue(Types.forName("org.op4j.op.operators.Iter0GenericUniqTargetOperatorTest$Dummy[]").isAssignableFrom(this.dummyOperator.buildArray(Dummy.class)
				.getTargets().get(0).getIntendedType()));	
		assertTrue(Types.forName("Object[]").isAssignableFrom(this.nullOperator.buildArray(Dummy.class)
				.getTargets().get(0).getIntendedType()));				
	}

	public final void testBuildMapStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>")
				.isAssignableFrom(this.integerOperator.buildMap("#this - 5")
						.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildMapClassOfKStringObjectArray() {
		assertTrue(Types.forName("Map<String, ? extends Object>")
				.isAssignableFrom(this.integerOperator.buildMap(String.class, "#this.toString()")
						.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildMapStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>")
				.isAssignableFrom(this.integerOperator.buildMap("#this.toString()", "#this + 10")
						.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<String, Integer>")
				.isAssignableFrom(this.integerOperator.buildMap(
						String.class, Integer.class, "#this.toString()", "#this + 10")
						.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildMapClassOfKClassOfVMapBuilderOfKVT() {
		Target<Map<Integer, String>> theTarget = this.integerOperator.buildMap(Integer.class, String.class, new IMapBuild<Integer, Integer, String>() {

			public Integer getKey(Integer target) {
				return Integer.valueOf(((Integer) target).intValue() 
						+ 100);
			}

			public String getValue(Integer target) {
				return "The value is " + ((Integer) target).toString();
			}			
		}).getTargets().get(0);
		
		assertTrue(theTarget.getObject().containsKey(Integer.valueOf(200)));
	}
	
	public final void testBuildListMapStringObjectArray() {		
		assertTrue(Types.forName("Map<?, List<org.op4j.op.operators.Iter0GenericUniqTargetOperatorTest$Dummy>>")
				.isAssignableFrom(
						this.dummyOperator.buildListMap("#this.title")
							.getTargets().get(0).getIntendedType()));		
	}

	public final void testBuildListMapClassOfKStringObjectArray() {
		assertTrue(Types.forName("Map<String, List<org.op4j.op.operators.Iter0GenericUniqTargetOperatorTest$Dummy>>")
				.isAssignableFrom(
						this.dummyOperator.buildListMap(String.class, "#this.title")
							.getTargets().get(0).getIntendedType()));		
	}

	public final void testBuildListMapStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, List<?>>")
				.isAssignableFrom(
						this.dummyOperator.buildListMap("#this.title", "#this.from")
							.getTargets().get(0).getIntendedType()));		
	}

	public final void testBuildListMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<String, ? extends List<? extends Calendar>>")
				.isAssignableFrom(
					this.dummyOperator.buildListMap(String.class, Calendar.class, "title", "from")
							.getTargets().get(0).getIntendedType()));
	}

	public final void testBuildListMapMapBuilderOfTObjectObject() {
		ListMapTarget<?, ?> theTarget = this.integerOperator.buildListMap(new IMapBuild<Integer, Object, Object>() {

			public Object getKey(Integer target) {
				return Integer.valueOf(((Integer) target).intValue() 
						+ 100);
			}

			public Object getValue(Integer target) {
				return "The value is " + ((Integer) target).toString();
			}			
		}).getTargets().get(0);
		
		assertTrue(theTarget.getObject().containsKey(Integer.valueOf(200)));
		assertTrue(Types.forName("Map<?, List<?>>").isAssignableFrom(
				theTarget.getIntendedType()));
	}

	public final void testSize() {
		assertEquals(1, this.integerOperator.size());		
	}

	public final void testAdd() {
		assertEquals(2, this.integerOperator.add(Integer.valueOf(34)).size());
	}

	public final void testAddAll() {
		assertEquals(5, this.integerOperator
				.add(Integer.valueOf(34))
				.add(Integer.valueOf(44))
				.add(Integer.valueOf(54))
				.add(Integer.valueOf(64))
				.size());
	}

	public final void testAddObj() {
		assertEquals(this.aCalendar200006221300, this.integerOperator.addObj(
				this.aCalendar200006221300).getTargetObjects().get(1));
		assertEquals(Integer.valueOf(20), this.integerOperator.addObj(
				Integer.valueOf(20)).getTargetObjects().get(1));
		assertEquals(Integer.valueOf(100), this.integerOperator.addObj(
				this.aCalendar200006221300).getTargetObjects().get(0));
	}

	public final void testAddAllObjs() {
		assertEquals(Boolean.TRUE, this.integerOperator
				.addObj(this.aCalendar200006221300)
				.addObj(Long.valueOf(34))
				.addObj(Boolean.TRUE)
				.addObj(Calendar.getInstance())
				.getTargetObjects().get(3));
	}

	public final void testIns() {
		
		assertEquals(Integer.valueOf(20), 
				this.integerOperator.ins(0, Integer.valueOf(20))
				.getTargetObjects().get(0));
		
		assertEquals(Integer.valueOf(20), 
				this.integerOperator.ins(1, Integer.valueOf(10))
				.ins(0, Integer.valueOf(20))
				.getTargetObjects().get(0));
		
		assertEquals(Integer.valueOf(10), 
				this.integerOperator.ins(1, Integer.valueOf(10))
				.ins(0, Integer.valueOf(20))
				.getTargetObjects().get(2));
	}

	public final void testInsAll() {
		Iter0GenericMultiTargetOperator<Integer> multiOperator = this.integerOperator.insAll(0, Integer.valueOf(10),
						Integer.valueOf(20), Integer.valueOf(30));
				
		assertEquals(4, 
				multiOperator.size());
		
		assertEquals(Integer.valueOf(100), 
				multiOperator.getTargetObjects().get(3));
		
		assertEquals(Integer.valueOf(20), 
				multiOperator.getTargetObjects().get(1));
	}

	public final void testInsObj() {
		assertEquals(this.aCalendar200006221300, 
				this.integerOperator.insObj(0, this.aCalendar200006221300)
				.getTargetObjects().get(0));
		
		assertEquals(this.aCalendar200006221300, 
				this.calendarOperator200006221300.insObj(1, Integer.valueOf(10))
				.insObj(0, Integer.valueOf(100))
				.getTargetObjects().get(1));		
	}

	public final void testInsAllObjs() {
		assertEquals(3, this.calendarOperator200006221300
			.insAllObjs(1, Integer.valueOf(10), Integer.valueOf(20))
			.size());	
	}
	
	public final void testRaw() {
		assertEquals(Types.CALENDAR, this.calendarOperator.getOperatorType());
		assertEquals(null, this.calendarOperator.raw().getOperatorType());
	}

	public final void testCastString() {
		Calendar calendar = Calendar.getInstance();
		
		assertEquals(TypeSchemes.CALENDAR_TYPESCHEME, Op.on(calendar)
				.cast(TypeSchemes.CALENDAR_TYPESCHEME.getName()).getTargetTypeScheme());
		assertEquals(null, Op.on(calendar)
				.cast(TypeSchemes.CALENDAR_TYPESCHEME.getName()).getOperatorType());
	}

	public final void testCastTypeScheme() {
		Calendar calendar = Calendar.getInstance();
		
		assertEquals(TypeSchemes.CALENDAR_TYPESCHEME, Op.on(calendar)
				.cast(TypeSchemes.CALENDAR_TYPESCHEME).getTargetTypeScheme());
		assertEquals(null, Op.on(calendar)
				.cast(TypeSchemes.CALENDAR_TYPESCHEME).getOperatorType());
	}

	public final void testEvalEvaluatorOfTObject() {
		assertEquals(Long.valueOf(2000),
				Op.on(Calendar.class, this.aCalendar200006221300).eval(new IEval<Calendar, Object>() {
				public Object evaluate(EvalContext<Calendar> ctx) {
					return Long.valueOf(ctx.getTarget(0).get(Calendar.YEAR));
				}			
		}).get());		
		assertEquals(null,
				Op.on(Calendar.class, null).eval(new IEval<Calendar, Object>() {
				public Object evaluate(EvalContext<Calendar> ctx) {
					return ctx.getTarget(0);
				}			
		}).get());		
	}


	public final void testBuildMapMapBuilderOfObjectObjectT() {
		assertEquals(TypeSchemes.forClasses(Map.class), this.integerOperator.buildMap(new IMapBuild<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return target;
			}

			public Object getValue(Integer target) {
				return target.toString() + RandomStringUtils.random(10);
			}			
		}).getTargetTypeScheme());
		
		assertEquals(null, this.integerOperator.buildMap(new IMapBuild<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return target;
			}

			public Object getValue(Integer target) {
				return target.toString() + RandomStringUtils.random(10);
			}			
		}).getOperatorKeyType());
		
		assertEquals(null, this.integerOperator.buildMap(new IMapBuild<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return target;
			}

			public Object getValue(Integer target) {
				return target.toString() + RandomStringUtils.random(10);
			}			
		}).getOperatorValueType());
	}

	public final void testBuildListMapClassOfKClassOfVMapBuilderOfTKV() {
		assertEquals(Types.INTEGER, this.integerOperator.buildListMap(Integer.class, String.class,
				new IMapBuild<Integer, Integer, String>() {
					public Integer getKey(Integer target) {
						return target;
					}
		
					public String getValue(Integer target) {
						return target.toString() + RandomStringUtils.random(10);
					}	
				}).getOperatorKeyType());
		
		assertEquals(Types.STRING, this.integerOperator.buildListMap(Integer.class, String.class,
				new IMapBuild<Integer, Integer, String>() {
					public Integer getKey(Integer target) {
						return target;
					}
		
					public String getValue(Integer target) {
						return target.toString() + RandomStringUtils.random(10);
					}	
				}).getOperatorValueType());
	}

	
	public final void testGetTargetTypeScheme() {
		assertEquals(TypeSchemes.CALENDAR_TYPESCHEME, 
				this.calendarOperator.getTargetTypeScheme());
	}

	public final void testGetTargetObjects() {
		assertEquals(1, Op.on(Calendar.class, this.aCalendar200006221300).getTargetObjects().size());
		assertEquals(this.aCalendar200006221300, 
				Op.on(Calendar.class, this.aCalendar200006221300).getTargetObjects().get(0));
	}
	
	public final void testAsSetMap() {
		Map<String, Set<Object>> stringObjectSetMap = new HashMap<String, Set<Object>>();
		stringObjectSetMap.put("a", new HashSet<Object>(this.anObjectList));
		assertTrue(Types.forName("Map<?,Set<?>>").isAssignableFrom(
				Op.on((Object) stringObjectSetMap).asSetMap().getTargets().get(0).getIntendedType()));
		assertEquals(Types.forName("Map<?,Set<?>>").getName(), 
				Op.on((Object) stringObjectSetMap).asSetMap().getTargetTypeScheme().getName());
	}

	public final void testAsSetMapClassOfKClassOfV() {
		Map<String, Set<Integer>> stringIntegerSetMap = new HashMap<String, Set<Integer>>();
		stringIntegerSetMap.put("a", new HashSet<Integer>(Arrays.asList(this.anIntegerArray)));
		
		assertTrue(Types.forName("Map<String, Set<Integer>>").isAssignableFrom(
				Op.on((Object) stringIntegerSetMap).asSetMap(String.class, Integer.class)
				.getTargets().get(0).getIntendedType()));
	}

	public final void testBuildSetMapStringObjectArray() {
		assertTrue(Types.forName("Map<?, Set<org.op4j.op.operators.Iter0GenericUniqTargetOperatorTest$Dummy>>")
				.isAssignableFrom(
						this.dummyOperator.buildSetMap("#this.title")
							.getTargets().get(0).getIntendedType()));	
	}

	public final void testBuildSetMapClassOfKStringObjectArray() {
		assertTrue(Types.forName("Map<String, Set<org.op4j.op.operators.Iter0GenericUniqTargetOperatorTest$Dummy>>")
				.isAssignableFrom(
						this.dummyOperator.buildSetMap(String.class, "#this.title")
							.getTargets().get(0).getIntendedType()));		
	}

	public final void testBuildSetMapStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, Set<?>>")
				.isAssignableFrom(
						this.dummyOperator.buildSetMap("#this.title", "#this.from")
							.getTargets().get(0).getIntendedType()));		
	}

	public final void testBuildSetMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<String, ? extends Set<? extends Calendar>>")
				.isAssignableFrom(
					this.dummyOperator.buildSetMap(String.class, Calendar.class, "title", "from")
							.getTargets().get(0).getIntendedType()));
	}

	public final void testBuildSetMapClassOfKClassOfVMapBuilderOfTKV() {
		assertEquals(Types.INTEGER, this.integerOperator.buildSetMap(Integer.class, String.class,
				new IMapBuild<Integer, Integer, String>() {
					public Integer getKey(Integer target) {
						return target;
					}
		
					public String getValue(Integer target) {
						return target.toString() + RandomStringUtils.random(10);
					}	
				}).getOperatorKeyType());
		
		assertEquals(Types.STRING, this.integerOperator.buildSetMap(Integer.class, String.class,
				new IMapBuild<Integer, Integer, String>() {
					public Integer getKey(Integer target) {
						return target;
					}
		
					public String getValue(Integer target) {
						return target.toString() + RandomStringUtils.random(10);
					}	
				}).getOperatorValueType());
	}

	public final void testBuildSetMapMapBuilderOfTObjectObject() {
		SetMapTarget<?, ?> theTarget = this.integerOperator.buildSetMap(new IMapBuild<Integer, Object, Object>() {

			public Object getKey(Integer target) {
				return Integer.valueOf(((Integer) target).intValue() 
						+ 100);
			}

			public Object getValue(Integer target) {
				return "The value is " + ((Integer) target).toString();
			}			
		}).getTargets().get(0);
		
		assertTrue(theTarget.getObject().containsKey(Integer.valueOf(200)));
		assertTrue(Types.forName("Map<?, Set<?>>").isAssignableFrom(
				theTarget.getIntendedType()));
	}

	public static class Dummy {
		private String title;
		private Calendar from;
		private Calendar to;
		
		public Dummy(String title, 
				Calendar from, Calendar to) {
			super();
			this.title = title;
			this.from = from;
			this.to = to;
		}
		
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Calendar getFrom() {
			return this.from;
		}
		public void setFrom(Calendar from) {
			this.from = from;
		}
		public Calendar getTo() {
			return this.to;
		}
		public void setTo(Calendar to) {
			this.to = to;
		}	
		
		public boolean isAvailable(Calendar in) {
			if (this.from.before(in) 
					&& this.to.after(in)) {
				return true;
			} 
			return false;			
		}

		@Override
		public String toString() {
			return new ToStringBuilder(this).append("title", this.title).toString();
		}
	}

}
