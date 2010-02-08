package org.op4j;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.IFunction;
import org.op4j.functions.StringFuncs;
import org.op4j.functions.converters.ToCalendar;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.evaluators.Ognl;

public class Tester extends TestCase {

	private TestUtils testUtils;

	@Override
	@Before
	public void setUp() throws Exception {
		this.testUtils = new TestUtils();
	}

	@Test
	public void test1() {
		List<String> data = this.testUtils.getStringList(8);
		List<String> result = Op.onList(data)
		.forEach().eval(new IEvaluator<String, String>() {
			public String execute(String object, ExecCtx ctx)
			throws Exception {
				return ctx.getCurrentIndex() + " - " + object;
			}
			public Type<? extends String> getResultType(
					Type<? extends String> targetType) {
				return Types.STRING;
			}
		}).get();

		assertEquals(data.size(), result.size());
		for (int index = 0; index < data.size(); index++) {
			assertEquals(index + " - " + data.get(index), 
					result.get(index));
		}
	}

	@Test
	public void test2() {
		List<String> data1 = this.testUtils.getStringList(8);
		List<String> data2 = this.testUtils.getStringList(10);

		List<String> result = Op.onList(data1)
		.addAll(data2).removeAllNullOrFalse(new IEvaluator<Boolean, String>() {

			public Boolean execute(String object, ExecCtx ctx)
			throws Exception {
				return Boolean.valueOf(StringUtils.contains("a", object));
			}

			public Type<? extends Boolean> getResultType(
					Type<? extends String> targetType) {
				return Types.BOOLEAN;
			}
		}).get();

		List<String> aResult = new ArrayList<String>();
		data1.addAll(data2);
		for (String string : data1) {
			if (!StringUtils.contains("a", string)) {
				aResult.add(string);
			}
		}		

		assertEquals(aResult.size(), result.size());
		for (int index = 0; index < aResult.size(); index++) {
			assertEquals(aResult.get(index), 
					result.get(index));
		}
	}

	@Test
	public void test3() {
		List<BigDecimal>[] data = this.testUtils.getBigDecimalListArray(10);

		List<BigDecimal>[] result = Op.onArrayOfList(data)
		.forEach().forEach().eval(Ognl.forBigDecimal("add(#param[0])", BigDecimal.valueOf(56)))
		.get();

		assertEquals(data.length, result.length);
		for (int indexA = 0; indexA < data.length; indexA++) {
			List<BigDecimal> aData = data[indexA];
			List<BigDecimal> aResult = result[indexA];
			for (int indexB = 0; indexB < aData.size(); indexB++) {
				assertEquals(aData.get(indexB).add(BigDecimal.valueOf(56)), 
						aResult.get(indexB));
			}
		}
	}

	@Test
	public void test4() {
		List<Calendar> data = this.testUtils.getCalendarList(13);

		List<Long> result = Op.onList(data)
		.forEach().eval(Ognl.forLong("getTimeInMillis()")).get();

		assertEquals(data.size(), result.size());
		for (int index = 0; index < data.size(); index++) {
			assertEquals(data.get(index).getTimeInMillis(), 
					result.get(index).longValue());
		}
	}

	@Test
	public void test5() {
		Date[][] data = this.testUtils.getDateArrayOfArray(6, 3);

		List<Calendar> result = Op.onArrayOfArray(data)
		.forEach(Types.ARRAY_OF_DATE).forEach(Types.DATE).convert(ToCalendar.fromDate())
		.endFor().endFor().flatten(Types.CALENDAR).toList().get();

		int index = 0;
		for (int outer = 0; outer < data.length; outer++) {
			Date[] innerDate = data[outer];

			for (int inner = 0; inner < innerDate.length; inner++) {
				Calendar aCalendar = Calendar.getInstance();
				aCalendar.setTime(innerDate[inner]);
				assertEquals(aCalendar, 
						result.get(index++));				
			}
		}
	}

	@Test
	public void test6() {
		Integer[] data = this.testUtils.getIntegerArray(16);

		String[] result = Op.onArray(data)
		.forEach(Types.INTEGER)
		.eval(Ognl.forString("\"Value is \" + #target"))
		.get();

		for (int index = 0; index < data.length; index++) {						
			assertEquals("Value is " + data[index], 
					result[index]);
		}
	}

	@Test
	public void test7() {
		Integer[] data = this.testUtils.getIntegerArray(16);

		Integer[] result = Op.onArray(data)
		.forEach(Types.INTEGER)
		.ifIndex(2, 4, 6, 10, 15)
		.eval(Ognl.forInteger("#target + 10"))
		.endIf()
		.endFor()
		.get();

		for (int index = 0; index < data.length; index++) {	
			assertEquals(
					ArrayUtils.contains((new int[] {2, 4, 6, 10, 15}), index) 
					? Integer.valueOf(data[index].intValue() + 10) : data[index], 
							result[index]);
		}		
	}

	@Test
	public void test8() {
		Map<Integer, String> data = this.testUtils.getMapOfIntegerString(5);

		Map<Integer, String> result = Op.onMap(data)
		.forEachEntry()
		.onValue()
		.replaceWith("abc")
		.get();

		assertEquals(data.size(), result.size());
		for (Map.Entry<Integer, String> entry : result.entrySet()) {	
			assertEquals(
					"abc", 
					entry.getValue());
		}		
	}

	@Test
	public void test9() {
		Map<Integer, List<String>> data = this.testUtils.getMapOfIntegerStringList(5);
		Iterator<Integer> iterator = data.keySet().iterator();
		Integer firstKey = iterator.next();
		Integer secondKey = iterator.next();
		Map<Integer, List<String>> result = Op.onMapOfList(data)
		.forEachEntry()
		.ifKeyNotEquals(firstKey, secondKey)
		.onValue()
		.add("added with op4j")
		.get();

		assertEquals(data.size(), result.size());
		int index = 0;
		for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {	
			if (index < 2) {
				assertEquals(
						data.get(entry.getKey()), 
						entry.getValue());
			} else {
				assertEquals(
						Op.onList(data.get(entry.getKey())).add("added with op4j").get(), 
						entry.getValue());
			}
			index++;
		}		
	}

	@Test
	public void test10() {
		Map<Integer, Calendar[]> data = this.testUtils.getMapOfIntegerCalendarArray(13);


		Map<Integer, Calendar[]> result = Op.onMapOfArray(data)
		.forEachEntry()
		.onValue()
		.forEach(Types.CALENDAR)
		.exec(new IFunction<Calendar, Calendar>() {
			public Calendar execute(Calendar object, ExecCtx ctx)
			throws Exception {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(object.getTime());
				calendar.set(Calendar.YEAR, 2000);
				return calendar;
			}
			public Type<? extends Calendar> getResultType(
					Type<? extends Calendar> targetType) {
				return Types.CALENDAR;
			}
		})
		.endFor()
		.get();

		assertEquals(data.size(), result.size());
		for (Map.Entry<Integer, Calendar[]> entry : result.entrySet()) {	
			int index = 0;
			for (Calendar calendar : entry.getValue()) {
				Calendar original = Calendar.getInstance();
				original.setTime(data.get(entry.getKey())[index].getTime());
				original.set(Calendar.YEAR, 2000);
				assertEquals(
						original, 
						calendar);
				index++;
			}				
		}		
	}

	@Test
	public void test11() {
		Map<Integer, Map<Integer, String[]>> data = this.testUtils.getMapOfIntegerMapOfIntegerStringArray(11);

		Map<Integer, Map<Integer, String[]>> result = Op.onMapOfMap(data)
		.forEachEntry()
		.onValue()
		.forEachEntry()
		.ifKeyNotEquals(Integer.valueOf(2), Integer.valueOf(33), Integer.valueOf(17))
		.onValue()
		.ifTrue(new IEvaluator<Boolean, String[]>() {
			public Boolean execute(String[] object, ExecCtx ctx)
			throws Exception {
				return Boolean.valueOf(object.length > 3);					
			}
			public Type<? extends Boolean> getResultType(
					Type<? extends String[]> targetType) {
				return Types.BOOLEAN;
			}
		})
		.exec(new IFunction<String[], String[]>() {
			public String[] execute(String[] object, ExecCtx ctx)
			throws Exception {					
				return Op.onArray(object).add("value added with ifunction").get();
			}
			public Type<? extends String[]> getResultType(
					Type<? extends String[]> targetType) {
				return Types.ARRAY_OF_STRING;
			}
		})
		.get();


		assertEquals(data.size(), result.size());
		for (Map.Entry<Integer, Map<Integer, String[]>> entry1 : result.entrySet()) {				
			for (Map.Entry<Integer, String[]> entry2 : entry1.getValue().entrySet()) {
				if (ArrayUtils.contains(new Integer[] {Integer.valueOf(2), Integer.valueOf(33), Integer.valueOf(17)}, 
						entry2.getKey())) {
					assertEquals(data.get(entry1.getKey()).get(entry2.getKey()), entry2.getValue());
				} else {
					if (entry2.getValue().length > 3) {	
						assertEquals(Arrays.asList(Op.onArray(data.get(entry1.getKey()).get(entry2.getKey()))
								.add("value added with ifunction").get()), 
								Arrays.asList(entry2.getValue()));						
					} else {
						assertEquals(Arrays.asList(data.get(entry1.getKey()).get(entry2.getKey())), 
								Arrays.asList(entry2.getValue()));
					}
				}				
			}				
		}		
	}

	@Test
	public void test12() {
		Map<Integer, Map<Integer, String[]>> data = this.testUtils.getMapOfIntegerMapOfIntegerStringArray(11);

		Map<Integer, Map<Integer, String[]>> result = Op.onMapOfMap(data)
		.ifFalse(new IEvaluator<Boolean, Map<Integer, Map<Integer, String[]>>>() {
			public Boolean execute(Map<Integer, Map<Integer, String[]>> object, ExecCtx ctx)
			throws Exception {
				return Boolean.valueOf(object.size() > 13);					
			}
			public Type<? extends Boolean> getResultType(
					Type<? extends Map<Integer, Map<Integer, String[]>>> targetType) {
				return Types.BOOLEAN;
			}
		})
		.forEachEntry()
		.ifIndexNot(1, 3)
		.onValue()
		.ifNotNull()
		.forEachEntry()
		.ifKeyNotEquals(Integer.valueOf(2), Integer.valueOf(33))
		.onValue()
		.ifTrue(new IEvaluator<Boolean, String[]>() {
			public Boolean execute(String[] object, ExecCtx ctx)
			throws Exception {
				return Boolean.valueOf(object.length > 3);					
			}
			public Type<? extends Boolean> getResultType(
					Type<? extends String[]> targetType) {
				return Types.BOOLEAN;
			}
		})
		.exec(new IFunction<String[], String[]>() {
			public String[] execute(String[] object, ExecCtx ctx)
			throws Exception {					
				return Op.onArray(object).add("value added with ifunction").get();
			}
			public Type<? extends String[]> getResultType(
					Type<? extends String[]> targetType) {
				return Types.ARRAY_OF_STRING;
			}
		})
		.get();

		if (!(data.size() > 13)) {
			assertEquals(data.size(), result.size());
			int index = 0;
			for (Map.Entry<Integer, Map<Integer, String[]>> entry1 : result.entrySet()) {
				if (index != 1 && index != 3) {
					if (entry1.getValue() != null) {
						for (Map.Entry<Integer, String[]> entry2 : entry1.getValue().entrySet()) {
							if (!ArrayUtils.contains(new Integer[] {Integer.valueOf(2), Integer.valueOf(33)}, 
									entry2.getKey())) {
								if (entry2.getValue().length > 3) {	
									assertEquals(Arrays.asList(Op.onArray(data.get(entry1.getKey()).get(entry2.getKey()))
											.add("value added with ifunction").get()), 
											Arrays.asList(entry2.getValue()));						
								} else {
									assertEquals(Arrays.asList(data.get(entry1.getKey()).get(entry2.getKey())), 
											Arrays.asList(entry2.getValue()));
								}
							}
						}	
					}
				}	
				index++;
			}	
		}
	}
	
	

    @Test
    public void test13() {
        
        List<String> stringList = this.testUtils.getStringList(10);
        List<String> newStringList =
            Op.onList(stringList).
                forEach().
                    exec(StringFuncs.toUpperCase()).
                    ifIndex(2).exec(StringFuncs.toLowerCase()).endIf().
                    eval(Ognl.forString("#target + '--' + #index")).get();

        for (int i = 0; i < 10; i++) {
            if (i != 2) {
                assertEquals(stringList.get(i).toUpperCase() + "--" + i, newStringList.get(i));
            } else {
                assertEquals(stringList.get(i).toLowerCase() + "--" + i, newStringList.get(i));
            }
        }
        
        List<List<String>> stringListOfList = this.testUtils.getStringListOfList(10,50);
        List<List<String>> newStringListOfList =
            Op.onListOfList(stringListOfList).
                forEach().forEach().
                    exec(StringFuncs.toUpperCase()).
                    ifIndex(2).exec(StringFuncs.toLowerCase()).endIf().
                    eval(Ognl.forString("#target + '--' + #indexes[1] + #indexes[2]")).get();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50; j++) {
                if (j != 2) {
                    assertEquals(stringListOfList.get(i).get(j).toUpperCase() + "--" + i + j, newStringListOfList.get(i).get(j));
                } else {
                    assertEquals(stringListOfList.get(i).get(j).toLowerCase() + "--" + i + j, newStringListOfList.get(i).get(j));
                }
            }
        }
        
        List<String> strList =
            Op.onAll("one", "two", "three").ifIndex(2).exec(StringFuncs.toUpperCase()).getAsList();
        assertEquals("THREE", strList.get(2));
        
        List<String> strList2 =
            Op.onAll("one", "two", "three").eval(Ognl.forString("#target + '--' + #index")).getAsList();
        assertEquals("three--2", strList2.get(2));
        
        List<String> strList3 =
            Op.onAll("one", "two", "three").eval(Ognl.forString("#target + '--' + #indexes[0]")).getAsList();
        assertEquals("three--2", strList3.get(2));
        
        List<String> strList4 =
            Op.onAll("one", "two", "three").ifTrue(Ognl.forBoolean("#indexes[0] == 2")).exec(StringFuncs.toUpperCase()).getAsList();
        assertEquals("THREE", strList4.get(2));
        
    }
	
}
