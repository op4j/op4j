package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.op4j.Op;
import org.op4j.commands.IMapBuild;
import org.op4j.type.Types;
import org.op4j.typescheme.TypeSchemes;

public class Iter1IterableArrayOperatorTest extends TestCase {

	Integer[] integerArray = new Integer[3];
	Calendar[] calendarArray = new Calendar[4];
	Iter1IterableArrayOperator<Integer> integerOperator;
	Iter1IterableArrayOperator<Calendar> calendarOperator;
	
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
		
		this.integerArray[0] = Integer.valueOf(10);
		this.integerArray[1] = Integer.valueOf(20);
		this.integerArray[2] = Integer.valueOf(30);
		
		this.calendarArray[0] = Calendar.getInstance();
		this.calendarArray[1] = this.aCalendar200006221300;
		this.calendarArray[2] = Calendar.getInstance();
		this.calendarArray[3] = this.aCalendar200006221300;
		
		List<Integer[]> intList = new ArrayList<Integer[]>();
		intList.add(this.integerArray);
		this.integerOperator = Op.onList(intList).each().asArray(Integer.class);
		List<Calendar[]> calList = new ArrayList<Calendar[]>();
		calList.add(this.calendarArray);
		this.calendarOperator = Op.onList(calList).each().asArray(Calendar.class);
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testExecStringObjectArray() {
		assertEquals("Dummy operation result: 1",
				this.calendarOperator.eachExec(
						DummyOperationOnOneOrTwoTargets.OPERATION_NAME).getTargets().get(0).get()[1]);		
	}

	public final void testAsArray() {
		this.integerOperator.asArray(Integer.class);
		try {
			this.integerOperator.asArray(Calendar.class);
			fail("integerOperator.asArray(Calendar.class) should have failed as it contains an Integer[] instead of a Calendar[]");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
	}

	public final void testEach() {
		int index = 0;
		for (Calendar calendar : this.calendarArray) {
			assertEquals(calendar.getTimeInMillis(), this.calendarOperator.each().eval("#target.getTimeInMillis()")
					.getTargets().get(0).uneachList().get().get(index++));
		}		
	}

	public final void testUneachSet() {
		assertEquals(Types.forName("Integer[]"), this.integerOperator.uneachSet().getOperatorComponentType());
		assertEquals(TypeSchemes.forName("Set<Integer[]>"), this.integerOperator.uneachSet()
				.getTargetTypeScheme());
		assertEquals(this.integerArray, this.integerOperator
				.uneachSet().get().iterator().next());
		
	}

	public final void testUneachMapMapBuilderOfKV() {
		assertEquals(null, this.integerOperator
				.uneachMap(new IMapBuild<Integer[], Object, Object>() {
					@SuppressWarnings("boxing")
					public Integer getKey(Integer[] target) {
						return target.length;
					}
					public String getValue(Integer[] target) {
						return Arrays.toString(target);
					}					
				}).getOperatorKeyType());
		assertEquals(null, this.integerOperator
				.uneachMap(new IMapBuild<Integer[], Object, Object>() {
					@SuppressWarnings("boxing")
					public Integer getKey(Integer[] target) {
						return target.length;
					}
					public String getValue(Integer[] target) {
						return Arrays.toString(target);
					}					
				}).getOperatorValueType());
		assertEquals(TypeSchemes.forName("Map<?,?>"), this.integerOperator.uneachMap(new IMapBuild<Integer[], Object, Object>() {
			@SuppressWarnings("boxing")
			public Integer getKey(Integer[] target) {
				return target.length;
			}
			public String getValue(Integer[] target) {
				return Arrays.toString(target);
			}					
		}).getTargetTypeScheme());		
	}
}
