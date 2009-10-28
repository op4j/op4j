package org.op4j.op.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.time.DateUtils;
import org.op4j.Op;
import org.op4j.exceptions.InvalidOperatorCastException;
import org.op4j.executables.IMapBuild;
import org.op4j.type.Types;

public class Iter1GenericMultiTargetOperatorTest extends TestCase {

	List<Integer> integerList = new ArrayList<Integer>();
	List<Calendar> calendarList = new ArrayList<Calendar>();
	Iter1GenericMultiTargetOperator<Integer> integerOperator;
	Iter1GenericMultiTargetOperator<Calendar> calendarOperator;
	
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
		
		this.integerList.add(Integer.valueOf(10));
		this.integerList.add(Integer.valueOf(20));
		this.integerList.add(Integer.valueOf(30));
		
		this.calendarList.add(Calendar.getInstance());
		this.calendarList.add(Calendar.getInstance());
		this.calendarList.add(Calendar.getInstance());
		this.calendarList.add(Calendar.getInstance());
		
		this.integerOperator = Op.onList(this.integerList).each().addObj(Integer.valueOf(100)).as(Integer.class);
		this.calendarOperator = Op.onList(this.calendarList).each().addObj(this.aCalendar200006221300).as(Calendar.class);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testAs() {
		this.calendarOperator.as(Calendar.class);
		
		try {
			this.calendarOperator.as(Integer.class);
			fail("calendarOperator.as(Integer.class) should have failed as it contains two Calendar, Calendar elements");
		} catch (IllegalArgumentException e) {
			// do nothing
		}
		
	}

	public final void testChoose() {
		for (int index = 0; index < this.integerList.size(); index++) {
			assertEquals(this.integerList.get(index),
					this.integerOperator.choose(0).getTargets().get(index).get());
		}		
	}

	public final void testBuildMapClassOfKClassOfV() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(Integer.valueOf(10), Integer.valueOf(100));
		
		assertTrue(map.equals(
				this.integerOperator.buildMap(Integer.class, Integer.class)
				.getTargets().get(0).get()));	
		
		try {
			this.integerOperator.buildMap(Integer.class, String.class);
			fail("integerOperator.buildMap(Integer.class, String.class) should have failed as the map should be Integer, Integer");
		} catch (InvalidOperatorCastException e) {
			// do nothing
		}
	}
	
	public final void testFilterStringObjectArray() {
		assertEquals(0, this.calendarOperator.filter("#param[0].equals(#target[1])" , this.aCalendar200006221300)
			.size());
	}

	public final void testEvalClassOfXStringObjectArray() {
		assertEquals(Integer.valueOf(120), this.integerOperator
			.eval(Integer.class, "#target[0] + #target[1] + #param[0]", Integer.valueOf(10))
			.getTargets().get(0).get());
		assertEquals(Integer.valueOf(130), this.integerOperator
				.eval(Integer.class, "#target[0] + #target[1] + #param[0]", Integer.valueOf(10))
				.getTargets().get(1).get());		
		for(int index = 0; index < this.calendarList.size(); index++) {
			assertEquals(this.aCalendar200006221300, this.calendarOperator
					.eval(Calendar.class, "#target[1]")
					.getTargets().get(index).get());	
		}
	}

	public final void testBuildList() {
		assertTrue(Types.forName("List<Integer>")
				.isAssignableFrom(this.integerOperator.buildList().getTargets()
			.get(0).getTargets().get(0).getIntendedType()));
		
		assertEquals(Arrays.asList(new Integer[] {Integer.valueOf(10),
				Integer.valueOf(100)}),
				this.integerOperator.buildList().getTargets()
				.get(0).get());		
	}

	public final void testBuildArrayClassOfX() {
		
		assertTrue(Types.forName("Integer[]")
				.isAssignableFrom(this.integerOperator.buildArray(Integer.class).getTargets()
			.get(0).getTargets().get(0).getIntendedType()));
		
		assertTrue(ArrayUtils.isEquals(new Integer[] {Integer.valueOf(10),
				Integer.valueOf(100)},
				this.integerOperator.buildArray(Integer.class).getTargets()
				.get(0).get()));		
	}

	@SuppressWarnings("unchecked")
	public final void testBuildMapMapBuilderOfObjectObjectT() {
		final Calendar aux = Calendar.getInstance();
		
		Iter1IterableMapOperator mapOperator = this.integerOperator.buildMap(new IMapBuild<Integer, Object, Object>() {
			public Calendar getKey(Integer target) {
				Calendar clone = (Calendar) aux.clone();
				clone.add(Calendar.MILLISECOND, target.intValue());
				return clone;
			}

			public String getValue(Integer target) {
				return target.toString();
			}
		});
		
		assertEquals(null, mapOperator.getOperatorKeyType());
		assertEquals(null, mapOperator.getOperatorValueType());
		
		Map theMap = ((List<Iter0IterableMapOperator>) mapOperator.getTargets()).get(0).get();
		
		Calendar clone = (Calendar) aux.clone();
		clone.add(Calendar.MILLISECOND, 10);		
		assertEquals("10", theMap.get(clone));
		clone.add(Calendar.MILLISECOND, 90);
		assertEquals("100", theMap.get(clone));
	}
		
	public final void testAddAll() {
		assertEquals(this.calendarOperator.size() + 3, this.calendarOperator.addAll(Calendar.getInstance(), Calendar.getInstance(), null).size());
		Calendar calAux = Calendar.getInstance();
		assertEquals(calAux, this.calendarOperator.addAll(calAux, null).unsafeChoose(2).getTargets().get(0).get());
	}

	public final void testAddObj() {
		assertEquals(this.calendarOperator.size() + 1, this.calendarOperator.add(Calendar.getInstance()).size());
		Calendar aux = Calendar.getInstance();
		assertEquals(aux, this.calendarOperator.add(Calendar.getInstance()).unsafeChoose(2).getTargets().get(0).get());
	}

	public final void testInsAllObjs() {
		assertEquals(this.calendarOperator.size() + 2, this.calendarOperator.insAllObjs(0, Calendar.getInstance(), Integer.valueOf(56)).size());
		Calendar calAux = Calendar.getInstance();
		Integer intAux = Integer.valueOf(12);
		assertEquals(calAux, this.calendarOperator.insAllObjs(1, calAux, intAux).unsafeChoose(1).getTargets().get(0).get());
	}
}
