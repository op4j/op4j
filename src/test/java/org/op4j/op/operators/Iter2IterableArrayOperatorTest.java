package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.exceptions.DuplicateMapKeyException;
import org.op4j.op.Op;
import org.op4j.op.interfaces.MapBuilder;
import org.op4j.type.Types;

public class Iter2IterableArrayOperatorTest extends TestCase {

	List<Integer[]> integerArrayList = new ArrayList<Integer[]>();
	List<Calendar[]> calendarArrayList = new ArrayList<Calendar[]>();
	Iter2IterableArrayOperator<Integer> integerOperator;
	Iter2IterableArrayOperator<Calendar> calendarOperator;
	
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
		
		this.integerArrayList.add(new Integer[] {Integer.valueOf(10)});
		this.integerArrayList.add(new Integer[] {Integer.valueOf(20)});
		this.integerArrayList.add(new Integer[] {Integer.valueOf(30)});
		
		this.calendarArrayList.add(new Calendar[] {Calendar.getInstance()});
		this.calendarArrayList.add(new Calendar[] {Calendar.getInstance()});
		this.calendarArrayList.add(new Calendar[] {Calendar.getInstance()});
		this.calendarArrayList.add(new Calendar[] {Calendar.getInstance()});
		
		this.integerOperator = Op.onList(this.integerArrayList).each().buildList().each().asArray(Integer.class);
		this.calendarOperator = Op.onList(this.calendarArrayList).each().buildList().each().asArray(Calendar.class);
	}

	public final void testUneachSetMapMapBuilderOfTObjectObject() {
		Iter1IterableSetMapOperator<?, ?> result = this.calendarOperator.uneachSetMap(new MapBuilder<Calendar[], Object, Object>() {
			public Object getKey(Calendar[] target) {
				return target[0];
			}
			public Object getValue(Calendar[] target) {
				return target;
			}			
		});
		
		assertEquals(null, result.getOperatorKeyType());
		assertEquals(null, result.getOperatorValueType());
		assertEquals(this.calendarArrayList.get(0), 
				result.getTargets().get(0).get().entrySet().iterator()
				.next().getValue().iterator().next());
	}

	public final void testToMapStringStringObjectArray() {
		Iter2IterableMapOperator<?, ?> result = this.calendarOperator.toMap("#target", "#target.toString()");
		
		assertEquals(null, result.getOperatorKeyType());
		assertEquals(null, result.getOperatorValueType());
		assertEquals(this.calendarArrayList.get(0)[0].toString(), 
				result.getTargets().get(0).getTargets().get(0).get().entrySet().iterator().next().getValue());
		
		try {
			this.integerArrayList.add(new Integer[] {10, 20, 30});
			Op.onList(this.integerArrayList).each().buildList().each().asArray(Integer.class).toMap("100", "#param[0].random(10)",
					new RandomStringUtils()).getTargets().get(0).getTargets().get(0).get();
			fail("toMap should have failed as it would contain duplicate key entries with a different value");
		} catch (DuplicateMapKeyException e) {
			// do nothing
		}		
	}

	public final void testEachToStringObjectArray() {		
		assertEquals(Types.CALENDAR, this.calendarOperator.getOperatorComponentType());		
		assertEquals(null, this.calendarOperator.eachTo(Types.STRING.getName()).getOperatorComponentType());
		
		assertEquals(this.calendarArrayList.get(0)[0].toString(), this.calendarOperator.eachTo(Types.STRING.getName()).getTargets().get(0).getTargets().get(0).get()[0]);
	}

	public final void testEachToClassOfXObjectArray() {		
		assertEquals(Types.CALENDAR, this.calendarOperator.getOperatorComponentType());		
		assertEquals(Types.STRING, this.calendarOperator.eachTo(String.class).getOperatorComponentType());		
	}

	public final void testSize() {
		assertEquals(1, this.calendarOperator.size());
	}

}
