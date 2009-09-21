package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.exceptions.InvalidTypeSchemeException;
import org.op4j.op.Op;
import org.op4j.op.interfaces.EvalContext;
import org.op4j.op.interfaces.Evaluator;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.operation.ListMapTarget;
import org.op4j.operation.SetMapTarget;
import org.op4j.operations.conversion.exceptions.ConversionException;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;
import org.op4j.util.UniqResultConverterUtils;

public class Iter0GenericMultiTargetOperatorTest extends TestCase {

	private Iter0GenericMultiTargetOperator<Integer> calendarOperator;
	private Iter0GenericMultiTargetOperator<Integer> integerOperator;
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
			Op.onAll(Integer.class, Integer.valueOf(2000), Integer.valueOf(6), Integer.valueOf(22), Integer.valueOf(13), Integer.valueOf(0));
		
		this.integerOperator =
			Op.onAll(Integer.class, Integer.valueOf(10), Integer.valueOf(20), Integer.valueOf(30));
						
	}


	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testAs() {
		assertTrue(Types.INTEGER.isAssignableFrom(
				this.integerOperator.addObj(Integer.valueOf(34))
				.as(Integer.class).getTargets().get(0).getIntendedType()));		
		assertTrue(Types.INTEGER.isAssignableFrom(
				this.integerOperator.addObj(Integer.valueOf(34))
				.as(Integer.class).getTargets().get(3).getIntendedType()));		
		
		assertTrue(TypeSchemes.forSingleType(Types.INTEGER, this.integerOperator.size() + 1).isAssignableFrom(
				this.integerOperator.addObj(Integer.valueOf(34))
				.as(Integer.class).getTargetTypeScheme()));		
		assertFalse(TypeSchemes.forSingleType(Types.INTEGER, this.integerOperator.size()).isAssignableFrom(this.integerOperator.addObj(Integer.valueOf(34))
				.as(Integer.class).getTargetTypeScheme()));		
		try {
			this.calendarOperator.as(Date.class);
			fail("this.calendarOperator.as(Date.class) should have thrown an( exception");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}	

	public final void testChoose() {
		assertEquals(Integer.valueOf(2000),
				this.calendarOperator.choose(0).get());
		assertEquals(Integer.valueOf(22),
				this.calendarOperator.choose(2).get());
	}

	public final void testChooseSome() {
		assertEquals(2,
				this.calendarOperator.chooseSome(3, 4).getTargetObjects().size());
		assertEquals(Integer.valueOf(13),
				this.calendarOperator.chooseSome(3, 4).getTargetObjects().get(0));
		assertEquals(Integer.valueOf(0),
				this.calendarOperator.chooseSome(3, 4).getTargetObjects().get(1));
	}

	public final void testUniq() { 
		Op.onAll(Integer.valueOf(10)).uniq();	
	}

	public final void testExec() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator.exec(
				UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.CALENDAR)).as(Calendar.class)
				.getTargetObjects().get(0));
	}

	public final void testExecUniqStringObjectArray() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator.execUniq(
				UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.CALENDAR)).as(Calendar.class)
				.get());
	}

	public final void testExecUniqClassOfXStringObjectArray() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator.execUniq(
				Calendar.class,
				UniqResultConverterUtils.unsafeGetOperationNameForResultType(Types.CALENDAR))
				.get());
	}

	public final void testToTypeObjectArray() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator.to(Types.CALENDAR).getTargetObjects().get(0));	
	}

	public final void testToStringObjectArray() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator.to("Calendar").getTargetObjects().get(0));	
	}

	public final void testToClassOfXObjectArray() {
		assertEquals(this.aCalendar200006221300, this.calendarOperator.to(Calendar.class).getTargetObjects().get(0));	
	}

	public final void testToByte() {
		// No conversion to Byte available for a MultiTargetOperator
	}

	public final void testToShort() {
		// No conversion to Short available for a MultiTargetOperator
	}

	public final void testToInteger() {
		// No conversion to Integer available for a MultiTargetOperator
	}

	public final void testToLong() {
		// No conversion to Long available for a MultiTargetOperator
	}

	public final void testToFloat() {
		// No conversion to Float available for a MultiTargetOperator
	}

	public final void testToDouble() {
		// No conversion to Double available for a MultiTargetOperator
	}

	public final void testToBigInteger() {
		// No conversion to BigInteger available for a MultiTargetOperator
	}

	public final void testToBigDecimal() {
		// No conversion to BigDecimal available for a MultiTargetOperator
	}

	public final void testToAtomicInteger() {
		// No conversion to AtomicInteger available for a MultiTargetOperator
	}

	public final void testToAtomicLong() {
		// No conversion to AtomicLong available for a MultiTargetOperator
	}

	public final void testToBoolean() {
		// No conversion to Boolean available for a MultiTargetOperator
	}

	public final void testToCalendar() {
		assertEquals(this.aCalendar200006221300,
				this.calendarOperator.toCalendar().get());	
	}

	public final void testToStr() {
		// No conversion to String available for a MultiTargetOperator
	}

	public final void testEvalStringObjectArray() {
		assertEquals(Integer.valueOf(100),
				this.integerOperator.eval("(#target[0] - #target[1] + #target[2]) * #param[0]", Integer.valueOf(5)).get());		
	}

	public final void testEvalClassOfXStringObjectArray() {
		assertEquals(Integer.valueOf(100),
				this.integerOperator.eval(Integer.class, "(#target[0] - #target[1] + #target[2]) * #param[0]", Integer.valueOf(5)).get());		
		assertTrue(Types.INTEGER.isAssignableFrom(
				this.integerOperator.eval(Integer.class, "(#target[0] - #target[1] + #target[2]) * #param[0]", Integer.valueOf(5))
				.getTargets().get(0).getIntendedType()));
		assertTrue(Types.INTEGER.getName().compareTo(
				this.integerOperator.eval(Integer.class, "(#target[0] - #target[1] + #target[2]) * #param[0]", Integer.valueOf(5))
				.getTargetTypeScheme().getName()) == 0);
	}

	public final void testEvalClassOfXEvaluatorOfTX() {
		assertEquals(Integer.valueOf(60),
			this.integerOperator.eval(Integer.class, new Evaluator<Integer, Integer>() {	
				public Integer evaluate(EvalContext<Integer> ctx) {
					int total = 0;
					for (int index = 0; index < ctx.getTargetCount(); index++) {
						total = total + ((Integer) ctx.getTarget(index)).intValue();
					}
					return Integer.valueOf(total);
				}			
			}).get());
		assertEquals(Types.INTEGER.getName(),
				this.integerOperator.eval(Integer.class, new Evaluator<Integer, Integer>() {	
					public Integer evaluate(EvalContext<Integer> ctx) {
						int total = 0;
						for (int index = 0; index < ctx.getTargetCount(); index++) {
							total = total + ((Integer) ctx.getTarget(index)).intValue();
						}
						return Integer.valueOf(total);
					}			
				}).getTargetTypeScheme().getName());
	}

	public final void testBuildList() {
		assertTrue(Types.forName("List<Integer>").isAssignableFrom(
				this.integerOperator.buildList().getTargets().get(0).getIntendedType()));
	}

	public final void testBuildListClassOfX() {
		assertTrue(Types.forName("List<Integer>").isAssignableFrom(
				this.integerOperator.addObj(Integer.valueOf(40))
				.buildList(Integer.class).getTargets().get(0).getIntendedType()));
		assertEquals(Types.forName("List<Integer>").getName(), 
				this.integerOperator.addObj(Integer.valueOf(40))
				.buildList(Integer.class).getTargetTypeScheme().getName());	
		assertEquals(Types.INTEGER.getName(), 
				this.integerOperator.addObj(Integer.valueOf(40))
				.buildList(Integer.class).getOperatorComponentType().getName());	
	}

	public final void testBuildSet() {
		assertTrue(Types.forName("Set<Integer>").isAssignableFrom(
				this.integerOperator.buildSet().getTargets().get(0).getIntendedType()));
		assertFalse(Types.forName("List<Integer>").isAssignableFrom(
				this.integerOperator.buildSet().getTargets().get(0).getIntendedType()));
	}

	public final void testBuildSetClassOfX() {
		assertTrue(Types.forName("Set<Integer>").isAssignableFrom(
				this.integerOperator.addObj(Integer.valueOf(40))
				.buildSet(Integer.class).getTargets().get(0).getIntendedType()));
	}

	public final void testBuildArray() {
		assertTrue(Types.forName("Integer[]").isAssignableFrom(
				this.integerOperator.buildArray().getTargets().get(0).getIntendedType()));
		assertEquals(Types.forName("Integer[]").getName(), 
				this.integerOperator.buildArray().getTargetTypeScheme().getName());
		assertEquals(Types.INTEGER.getName(), 
				this.integerOperator.buildArray().getOperatorComponentType().getName());
	}

	public final void testBuildArrayClassOfX() {
		assertTrue(Types.forName("Integer[]").isAssignableFrom(
				this.integerOperator.addObj(Integer.valueOf(40))
				.buildArray(Integer.class).getTargets().get(0).getIntendedType()));
		assertFalse(Types.forName("String[]").isAssignableFrom(
				this.integerOperator.buildArray().getTargets().get(0).getIntendedType()));
	}

	public final void testBuildMapStringObjectArray() {
		assertEquals(Integer.valueOf(10),
				this.integerOperator.buildMap("#param[0] + #target", Integer.valueOf(10)).get().get(Integer.valueOf(20)));
	}

	public final void testBuildMapClassOfKStringObjectArray() {
		assertEquals(Integer.valueOf(10),
				this.integerOperator.buildMap(Integer.class, "#param[0] + #target", Integer.valueOf(10)).get().get(Integer.valueOf(20)));
		assertTrue(Types.forName("Map<Integer, ?>").isAssignableFrom(
				this.integerOperator.buildMap(Integer.class, "#param[0] + #target", Integer.valueOf(10)).getTargets().get(0).getIntendedType()));
	}

	public final void testBuildMapStringStringObjectArray() {
		assertEquals(Integer.valueOf(100),
				this.integerOperator.buildMap("#param[0] + #target", "#param[0] * #target", Integer.valueOf(10)).get().get(Integer.valueOf(20)));
	}

	public final void testBuildMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<Integer, String>").isAssignableFrom(
				this.integerOperator.buildMap(Integer.class, String.class, 
						"#param[0] + #target", "#target.toString()", 
						Integer.valueOf(10)).getTargets().get(0).getIntendedType()));
	}

	public final void testBuildMapClassOfKClassOfVMapBuilderOfKVT() {
		assertTrue(Types.forName("Map<Integer, String>").isAssignableFrom(
			this.integerOperator.buildMap(Integer.class, String.class, new MapBuilder<Integer, Integer, String>() {
				public Integer getKey(Integer target) {
					return Integer.valueOf((target).intValue() + 10);
				}
	
				public String getValue(Integer target) {
					return "The value is " + target.toString();
				}			
			}).getTargets().get(0).getIntendedType()));
		assertTrue(this.integerOperator.buildMap(Integer.class, String.class, new MapBuilder<Integer, Integer, String>() {
					public Integer getKey(Integer target) {
						return Integer.valueOf((target).intValue() + 10);
					}
		
					public String getValue(Integer target) {
						return "The value is " + target.toString();
					}			
				}).get().containsKey(Integer.valueOf(40)));
	}

	public final void testBuildMap() {
		try {
			this.integerOperator.buildMap();
			fail("As this.integerOperator has an odd number of items, buildMap should have failed");
		} catch (ConversionException e) {
			// do nothing
		}
		assertTrue(Types.forName("Map<?, ?>").isAssignableFrom(
				this.integerOperator.add(Integer.valueOf(40)).buildMap().getTargets().get(0).getIntendedType()));
	}

	public final void testBuildMapClassOfKClassOfV() {
		Op.onAll(Integer.valueOf(10), "Value for key 10", Integer.valueOf(20), "Value for key 20")
			.buildMap(Integer.class, String.class).get();
		assertEquals(Types.forName("Map<Integer, String>").getName(), Op.onAll(Integer.valueOf(10), "Value for key 10", Integer.valueOf(20), "Value for key 20")
			.buildMap(Integer.class, String.class).getTargetTypeScheme().getName());
	}

	public final void testBuildListMapStringObjectArray() {
		assertTrue(Types.forName("Map<?, List<Integer>>").isAssignableFrom(
				this.integerOperator.buildListMap("#target % #param[0]", Integer.valueOf(2)).getTargets().get(0).getIntendedType()));
		assertEquals(3,
				this.integerOperator.buildListMap("#target % #param[0]", Integer.valueOf(2)).get().get(Integer.valueOf(0)).size());
	}

	public final void testBuildListMapClassOfKStringObjectArray() {
		assertTrue(Types.forName("Map<Integer, ?>").isAssignableFrom(
			this.integerOperator
					.buildListMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
					.getTargets().get(0).getIntendedType()));
		assertFalse(Types.forName("Map<String, ?>").isAssignableFrom(
				this.integerOperator
						.buildListMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
						.getTargets().get(0).getIntendedType()));
		assertTrue(this.integerOperator
						.buildListMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
						.get().containsKey(Integer.valueOf(100)));
		assertFalse(this.integerOperator
				.buildListMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
				.get().containsKey(Integer.valueOf(10)));
	}

	public final void testBuildListMapStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>").isAssignableFrom(
				this.integerOperator
				.buildListMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.getTargets().get(0).getIntendedType()));
		assertTrue(this.integerOperator
				.buildListMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(100)));
		assertFalse(this.integerOperator
				.buildListMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(10)));
		assertEquals(2, this.integerOperator
				.add(Integer.valueOf(10))
				.buildListMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().get(Integer.valueOf(100)).size());
	}

	public final void testBuildListMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<Integer, ? extends List<Integer>>").isAssignableFrom(
				this.integerOperator
				.buildListMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.getTargets().get(0).getIntendedType()));
		assertTrue(this.integerOperator
				.buildListMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(100)));
		assertFalse(this.integerOperator
				.buildListMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(10)));
		assertEquals(2, this.integerOperator
				.add(Integer.valueOf(10))
				.buildListMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().get(Integer.valueOf(100)).size());
	}

	public final void testBuildListMapMapBuilderOfTObjectObject() {
		ListMapTarget<?, ?> theTarget = this.integerOperator.buildListMap(new MapBuilder<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return Integer.valueOf((target).intValue() 
						+ 100);
			}

			public Object getValue(Integer target) {
				return "The value is " + (target).toString();
			}						
		}).getTargets().get(0);
		
		assertTrue(theTarget.getObject().containsKey(Integer.valueOf(110)));
		assertTrue(Types.forName("Map<?, List<?>>").isAssignableFrom(
				theTarget.getIntendedType()));
	}

	public final void testBuildListMap() {
		try {
			this.integerOperator.buildListMap();
			fail("buildListMap() should have failed as the number of targets is not even");
		} catch (ConversionException e) {
			// do nothing
		}
		assertTrue(Types.forName("Map<Integer, ? extends List<Integer>>").isAssignableFrom(
				this.integerOperator.add(Integer.valueOf(40)).buildListMap().getTargets().get(0).getIntendedType()));
		assertEquals(2,
				this.integerOperator.add(Integer.valueOf(40)).buildListMap().get().size());
	}

	public final void testBuildListMapClassOfKClassOfV() {
		Iter0GenericMultiTargetOperator<?> operator = Op.onAll(Integer.valueOf(10), Calendar.getInstance(), Integer.valueOf(20), Calendar.getInstance(),
				Integer.valueOf(10), Calendar.getInstance());
		assertEquals(2, operator.buildListMap(Integer.class, Calendar.class).get().get(Integer.valueOf(10)).size());
		assertTrue(Types.forName("Map<?, ? extends List<?>>").isAssignableFrom(
				operator.buildListMap(Integer.class, Calendar.class).getTargets().get(0).getIntendedType()));
		assertTrue(Types.forName("Map<Integer, ? extends List<? extends Calendar>>").isAssignableFrom(
				operator.buildListMap(Integer.class, Calendar.class).getTargets().get(0).getIntendedType()));
		
		try {
			operator.addObj(Integer.valueOf(60)).buildListMap(Integer.class, Calendar.class);
			fail("buildListMap(Integer.class, Calendar.class) should have failed as the number of targets is not even");
		} catch (ConversionException e) {
			// do nothing
		}
	}

	public final void testSize() {
		assertEquals(3, this.integerOperator.size());
	}

	public final void testAdd() {
		Calendar current = Calendar.getInstance();
		assertEquals(current, 
				Op.onAll(Integer.valueOf(current.get(Calendar.YEAR)), Integer.valueOf(current.get(Calendar.MONTH) + 1), Integer.valueOf(current.get(Calendar.DAY_OF_MONTH)), 
						Integer.valueOf(current.get(Calendar.HOUR_OF_DAY)), Integer.valueOf(current.get(Calendar.MINUTE)))
						.as(Integer.class)
						.add(Integer.valueOf(current.get(Calendar.SECOND)))
						.add(Integer.valueOf(current.get(Calendar.MILLISECOND)))
				.toCalendar().get());	
	}

	public final void testAddAll() {
		Calendar current = Calendar.getInstance();
		assertEquals(current, 
				Op.onAll(Integer.valueOf(current.get(Calendar.YEAR)), Integer.valueOf(current.get(Calendar.MONTH) + 1), Integer.valueOf(current.get(Calendar.DAY_OF_MONTH)), 
						Integer.valueOf(current.get(Calendar.HOUR_OF_DAY)), Integer.valueOf(current.get(Calendar.MINUTE)))
						.as(Integer.class)
						.addAll(Integer.valueOf(current.get(Calendar.SECOND)), Integer.valueOf(current.get(Calendar.MILLISECOND)))
				.toCalendar().get());	
	}

	public final void testAddObj() {
		assertEquals(Integer.valueOf(0), 
				this.integerOperator.addObj(Integer.valueOf(0))
				.getTargetObjects().get(3));
		
		assertEquals(Integer.valueOf(20), 
				this.integerOperator.addObj("test")
				.getTargetObjects().get(1));
	}

	public final void testAddAllObjs() {
		assertEquals(5, 
				this.integerOperator.addAllObjs(Integer.valueOf(12), "test")
				.getTargetObjects().size());
		assertEquals(Integer.valueOf(20), 
				this.integerOperator.addAllObjs("test", Integer.valueOf(15))
				.getTargetObjects().get(1));
	}

	public final void testIns() {
		Calendar current = Calendar.getInstance();
		assertEquals(current, 
				Op.onAll(Integer.valueOf(current.get(Calendar.YEAR)), Integer.valueOf(current.get(Calendar.MONTH) + 1), Integer.valueOf(current.get(Calendar.DAY_OF_MONTH)), 
						Integer.valueOf(current.get(Calendar.HOUR_OF_DAY)), Integer.valueOf(current.get(Calendar.MINUTE)))
						.as(Integer.class)
						.ins(5, Integer.valueOf(current.get(Calendar.MILLISECOND)))
						.ins(5, Integer.valueOf(current.get(Calendar.SECOND)))
				.toCalendar().get());		
	}

	public final void testInsAll() {
		Calendar current = Calendar.getInstance();
		assertEquals(current, 
				Op.onAll(Integer.class, Integer.valueOf(current.get(Calendar.YEAR)), Integer.valueOf(current.get(Calendar.MONTH) + 1), Integer.valueOf(current.get(Calendar.DAY_OF_MONTH)), 
						Integer.valueOf(current.get(Calendar.HOUR_OF_DAY)), Integer.valueOf(current.get(Calendar.MINUTE)))
						.insAll(5, Integer.valueOf(current.get(Calendar.SECOND)), Integer.valueOf(current.get(Calendar.MILLISECOND)))
				.toCalendar().get());		
	}

	public final void testInsObj() {
		assertEquals(Integer.valueOf(0), 
				this.integerOperator.insObj(0, Integer.valueOf(0))
				.getTargetObjects().get(0));
		
		assertEquals("test", 
				this.integerOperator.insObj(1, "test")
				.getTargetObjects().get(1));	
		
		assertEquals(Integer.valueOf(20), 
				this.integerOperator.insObj(1, "test")
				.getTargetObjects().get(2));
	}

	public final void testInsAllObjs() {
		assertEquals(5, 
				this.integerOperator.insAllObjs(1, Integer.valueOf(12), "test")
				.getTargetObjects().size());
		assertEquals(Integer.valueOf(15), 
				this.integerOperator.insAllObjs(1, "test", Integer.valueOf(15))
				.getTargetObjects().get(2));
	}
	
	public final void testRaw() {
		assertEquals(TypeSchemes.forSingleType(Types.INTEGER, 5).getName(),
				this.calendarOperator.getTargetTypeScheme().getName());
		assertEquals(TypeSchemes.forSingleType(Types.INTEGER, 5).getName(),
				this.calendarOperator.raw().getTargetTypeScheme().getName());
	}

	public final void testCastString() {
		List<Object> aux = new ArrayList<Object>();
		aux.add(Integer.valueOf(5));
		aux.add(Calendar.getInstance());
		aux.add(Integer.valueOf(15));
		aux.add("test");		
		
		assertEquals(TypeSchemes.forClasses(Integer.class, Calendar.class, Integer.class, String.class).getName(), 
				Op.onAll(aux.get(0), aux.get(1), aux.get(2), aux.get(3))
				.cast(TypeSchemes.forClasses(Integer.class, Calendar.class, Integer.class, String.class).getName()).getTargetTypeScheme().getName());
		
		try {
			Op.onAll(aux.get(0), aux.get(1), aux.get(2), aux.get(3))
				.cast(TypeSchemes.forClasses(Integer.class, Calendar.class).getName());
			fail("Op.onAll(aux.get(0), aux.get(1), aux.get(2), aux.get(3))" +
					".cast(TypeSchemes.forClasses(Integer.class, Calendar.class)) should have failed");
		} catch (InvalidTypeSchemeException e) {
			// do nothing
		}
	}

	public final void testCastTypeScheme() {
		List<Object> aux = new ArrayList<Object>();
		aux.add(Integer.valueOf(5));
		aux.add(Calendar.getInstance());
		aux.add(Integer.valueOf(15));
		aux.add("test");		
		
		assertEquals(TypeSchemes.forClasses(Integer.class, Calendar.class, Integer.class, String.class).getName(), 
				Op.onAll(aux.get(0), aux.get(1), aux.get(2), aux.get(3))
				.cast(TypeSchemes.forClasses(Integer.class, Calendar.class, Integer.class, String.class)).getTargetTypeScheme().getName());
		
		try {
			Op.onAll(aux.get(0), aux.get(1), aux.get(2), aux.get(3))
				.cast(TypeSchemes.forClasses(Integer.class, Calendar.class));
			fail("Op.onAll(aux.get(0), aux.get(1), aux.get(2), aux.get(3))" +
					".cast(TypeSchemes.forClasses(Integer.class, Calendar.class)) should have failed");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	public final void testEvalEvaluatorOfTObject() {
		
		assertEquals("2041", this.calendarOperator.eval(new Evaluator<Integer, Object>() {
			public String evaluate(EvalContext<Integer> ctx) {
				int total = 0;
				for (int index = 0; index < ctx.getTargetCount(); index++) {
					total += ctx.getTarget(index).intValue();
				}
				return String.valueOf(total);
			}
		}).get());		
	}

	public final void testBuildMapMapBuilderOfObjectObjectT() {
		assertTrue(this.calendarOperator.buildMap(new MapBuilder<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return target;
			}
			public Object getValue(Integer target) {
				return target.toString();
			}			
		}).get().get(Integer.valueOf(2000)).equals("2000"));	
		
		assertEquals(Types.forName("Map<?, ?>").getName(), this.calendarOperator.buildMap(new MapBuilder<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return target;
			}
			public Object getValue(Integer target) {
				return target.toString();
			}			
		}).getTargetTypeScheme().getName());
	}

	public final void testBuildListMapClassOfKClassOfVMapBuilderOfTKV() {
		assertTrue(this.calendarOperator.buildListMap(Integer.class, String.class, new MapBuilder<Integer, Integer, String>() {
			public Integer getKey(Integer target) {
				return target;
			}
			public String getValue(Integer target) {
				return target.toString();
			}			
		}).get().get(Integer.valueOf(22)).iterator().next().equals("22"));	
		
		assertEquals(Types.forName("Map<Integer, List<String>>").getName(), this.calendarOperator.buildListMap(Integer.class, String.class, new MapBuilder<Integer, Integer, String>() {
			public Integer getKey(Integer target) {
				return target;
			}
			public String getValue(Integer target) {
				return target.toString();
			}			
		}).getTargetTypeScheme().getName());
	}

	public final void testGetTargetTypeScheme() {
		List<Integer> aux = new ArrayList<Integer>();
		aux.add(Integer.valueOf(5));
		aux.add(Integer.valueOf(10));
		aux.add(Integer.valueOf(15));
		
		assertEquals(TypeSchemes.forSingleType(Types.INTEGER, 3), 
				Op.onAll(aux.get(0), aux.get(1), aux.get(2))
				.getTargetTypeScheme());
	}

	public final void testGetTargetObjects() {
		List<Integer> aux = new ArrayList<Integer>();
		aux.add(Integer.valueOf(5));
		aux.add(Integer.valueOf(10));
		aux.add(Integer.valueOf(15));
		
		assertEquals(aux, Op.onAll(aux.get(0), aux.get(1), aux.get(2))
				.getTargetObjects());
	}
	
	public final void testBuildSetMap() {
		try {
			this.integerOperator.buildSetMap();
			fail("buildSetMap() should have failed as the number of targets is not even");
		} catch (ConversionException e) {
			// do nothing
		}
		assertTrue(Types.forName("Map<Integer, ? extends Set<Integer>>").isAssignableFrom(
				this.integerOperator.add(Integer.valueOf(40)).buildSetMap().getTargets().get(0).getIntendedType()));
		assertEquals(2,
				this.integerOperator.add(Integer.valueOf(40)).buildSetMap().get().size());
	}

	public final void testBuildSetMapClassOfKClassOfV() {
		Iter0GenericMultiTargetOperator<?> operator = Op.onAll(Integer.valueOf(10), Calendar.getInstance(), Integer.valueOf(20), Calendar.getInstance(),
				Integer.valueOf(10), null);
		assertEquals(2, operator.buildSetMap(Integer.class, Calendar.class).get().get(Integer.valueOf(10)).size());
		assertTrue(Types.forName("Map<?, ? extends Set<?>>").isAssignableFrom(
				operator.buildSetMap(Integer.class, Calendar.class).getTargets().get(0).getIntendedType()));
		assertTrue(Types.forName("Map<Integer, ? extends Set<? extends Calendar>>").isAssignableFrom(
				operator.buildSetMap(Integer.class, Calendar.class).getTargets().get(0).getIntendedType()));
		
		try {
			operator.addObj(Integer.valueOf(60)).buildSetMap(Integer.class, Calendar.class);
			fail("buildSetMap(Integer.class, Calendar.class) should have failed as the number of targets is not even");
		} catch (ConversionException e) {
			// do nothing
		}
	}

	public final void testBuildSetMapStringObjectArray() {
		assertTrue(Types.forName("Map<?, Set<Integer>>").isAssignableFrom(
				this.integerOperator.buildSetMap("#target % #param[0]", Integer.valueOf(2)).getTargets().get(0).getIntendedType()));
		assertEquals(3,
				this.integerOperator.buildSetMap("#target % #param[0]", Integer.valueOf(2)).get().get(Integer.valueOf(0)).size());
	}

	public final void testBuildSetMapClassOfKStringObjectArray() {
		assertTrue(Types.forName("Map<Integer, ?>").isAssignableFrom(
				this.integerOperator
						.buildSetMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
						.getTargets().get(0).getIntendedType()));
			assertFalse(Types.forName("Map<String, ?>").isAssignableFrom(
					this.integerOperator
							.buildSetMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
							.getTargets().get(0).getIntendedType()));
			assertTrue(this.integerOperator
							.buildSetMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
							.get().containsKey(Integer.valueOf(100)));
			assertFalse(this.integerOperator
					.buildSetMap(Integer.class, "#target * #param[0]", Integer.valueOf(10))
					.get().containsKey(Integer.valueOf(10)));
	}

	public final void testBuildSetMapStringStringObjectArray() {
		assertTrue(Types.forName("Map<?, ?>").isAssignableFrom(
				this.integerOperator
				.buildSetMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.getTargets().get(0).getIntendedType()));
		assertTrue(this.integerOperator
				.buildSetMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(100)));
		assertFalse(this.integerOperator
				.buildSetMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(10)));
		assertEquals(1, this.integerOperator
				.add(Integer.valueOf(10))
				.buildSetMap("#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().get(Integer.valueOf(100)).size());
	}

	public final void testBuildSetMapClassOfKClassOfVStringStringObjectArray() {
		assertTrue(Types.forName("Map<Integer, ? extends Set<Integer>>").isAssignableFrom(
				this.integerOperator
				.buildSetMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.getTargets().get(0).getIntendedType()));
		assertTrue(this.integerOperator
				.buildSetMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(100)));
		assertFalse(this.integerOperator
				.buildSetMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().containsKey(Integer.valueOf(10)));
		assertEquals(1, this.integerOperator
				.add(Integer.valueOf(10))
				.buildSetMap(Integer.class, Integer.class, "#target * #param[0]", "#target * #param[0] * #param[1]", Integer.valueOf(10), Integer.valueOf(2))
				.get().get(Integer.valueOf(100)).size());
	}

	public final void testBuildSetMapClassOfKClassOfVMapBuilderOfTKV() {
		assertTrue(this.calendarOperator.buildSetMap(Integer.class, String.class, new MapBuilder<Integer, Integer, String>() {
			public Integer getKey(Integer target) {
				return target;
			}
			public String getValue(Integer target) {
				return target.toString();
			}			
		}).get().get(Integer.valueOf(22)).iterator().next().equals("22"));	
		
		assertEquals(Types.forName("Map<Integer, Set<String>>").getName(), this.calendarOperator.buildSetMap(Integer.class, String.class, new MapBuilder<Integer, Integer, String>() {
			public Integer getKey(Integer target) {
				return target;
			}
			public String getValue(Integer target) {
				return target.toString();
			}			
		}).getTargetTypeScheme().getName());
	}

	public final void testBuildSetMapMapBuilderOfTObjectObject() {
		SetMapTarget<?, ?> theTarget = this.integerOperator.buildSetMap(new MapBuilder<Integer, Object, Object>() {
			public Object getKey(Integer target) {
				return Integer.valueOf((target).intValue() 
						+ 100);
			}

			public Object getValue(Integer target) {
				return "The value is " + (target).toString();
			}						
		}).getTargets().get(0);
		
		assertTrue(theTarget.getObject().containsKey(Integer.valueOf(110)));
		assertTrue(Types.forName("Map<?, Set<?>>").isAssignableFrom(
				theTarget.getIntendedType()));
	}
}
