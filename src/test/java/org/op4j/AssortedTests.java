package org.op4j;


import java.io.Serializable;
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
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.IFunction;
import org.op4j.functions.StringFuncs;
import org.op4j.functions.converters.ToCalendar;
import org.op4j.functions.evaluators.Call;
import org.op4j.functions.evaluators.Ognl;

public class AssortedTests extends TestCase {

	private AssortedTestsData testUtils;

	@Override
	@Before
	public void setUp() throws Exception {
		this.testUtils = new AssortedTestsData();
	}

	@Test
	public void test1() {
		List<String> data = this.testUtils.getStringList(8);
		List<String> result = Op.onList(data)
		.forEach().exec(new IFunction<String, String>() {
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
		.addAll(data2).removeAllNullOrFalse(new IFunction<Boolean, String>() {

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
		.forEach().forEach().exec(Ognl.asBigDecimal("add(#param[0])", BigDecimal.valueOf(56)))
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
		.forEach().exec(Ognl.asLong("getTimeInMillis()")).get();

		assertEquals(data.size(), result.size());
		for (int index = 0; index < data.size(); index++) {
			assertEquals(data.get(index).getTimeInMillis(), 
					result.get(index).longValue());
		}
	}

	@Test
	public void test5() {
		Date[][] data = this.testUtils.getDateArrayOfArray(6, 3);

		List<Calendar> result = Op.onArrayOfArrayOf(Types.DATE, data)
		.forEach().forEach().exec(Types.CALENDAR, ToCalendar.fromDate())
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

		String[] result = Op.onArrayOf(Types.INTEGER, data)
		.forEach()
		.exec(Types.STRING, Ognl.asString("\"Value is \" + #target"))
		.get();

		for (int index = 0; index < data.length; index++) {						
			assertEquals("Value is " + data[index], 
					result[index]);
		}
	}

	@Test
	public void test7() {
		Integer[] data = this.testUtils.getIntegerArray(16);

		Integer[] result = Op.onArrayOf(Types.INTEGER, data)
		.forEach()
		.ifIndex(2, 4, 6, 10, 15)
		.exec(Ognl.asInteger("#target + 10"))
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


		Map<Integer, Calendar[]> result = Op.onMapOfArrayOf(Types.CALENDAR, data)
		.forEachEntry()
		.onValue()
		.forEach()
		.exec(new IFunction<Calendar, Calendar>() {
			public Calendar execute(Calendar object, ExecCtx ctx)
			throws Exception {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(object.getTime());
				calendar.set(Calendar.YEAR, 2000);
				return calendar;
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
		.ifTrue(new IFunction<Boolean, String[]>() {
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
				return Op.onArrayOf(Types.STRING,object).add("value added with ifunction").get();
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
						assertEquals(Arrays.asList(Op.onArrayOf(Types.STRING, data.get(entry1.getKey()).get(entry2.getKey()))
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
		.ifFalse(new IFunction<Boolean, Map<Integer, Map<Integer, String[]>>>() {
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
		.ifTrue(new IFunction<Boolean, String[]>() {
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
				return Op.onArrayOf(Types.STRING, object).add("value added with ifunction").get();
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
									assertEquals(Arrays.asList(Op.onArrayOf(Types.STRING, data.get(entry1.getKey()).get(entry2.getKey()))
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
                    exec(Ognl.asString("#target + '--' + #index")).get();

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
                    exec(Ognl.asString("#target + '--' + #indexes[1] + #indexes[2]")).get();

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
            Op.onAll("one", "two", "three").exec(Ognl.asString("#target + '--' + #index")).getAsList();
        assertEquals("three--2", strList2.get(2));
        
        List<String> strList3 =
            Op.onAll("one", "two", "three").exec(Ognl.asString("#target + '--' + #indexes[0]")).getAsList();
        assertEquals("three--2", strList3.get(2));
        
        List<String> strList4 =
            Op.onAll("one", "two", "three").ifTrue(Ognl.asBoolean("#indexes[0] == 2")).exec(StringFuncs.toUpperCase()).getAsList();
        assertEquals("THREE", strList4.get(2));
        
    }
	
    
    @Test
    public void test14() {

        List<Integer> expectedListInt1 = Arrays.asList(new Integer[] { 234,12,231 });
        List<Integer> expectedListInt2 = Arrays.asList(new Integer[] { 234,10 });
        
        List<Integer> listInt1 = Op.onAll(234,12,231).getAsList();
        List<Integer> listInt2 = Op.on(234).addAll(10).getAsList();
        
        assertEquals(expectedListInt1, listInt1);
        assertEquals(expectedListInt2, listInt2);
        
    }
        
    
    
    @Test
    public void test16() {
        
        final Serializable[] expSerArray = new Serializable[] {"one", "two", "three", Integer.valueOf(3) };
        final Serializable[] serArray = new String[] {"one", "two", "three" };
        
        Serializable[] newArray = Op.onArrayOf(Types.SERIALIZABLE, serArray).add(Integer.valueOf(3)).get();

        assertEquals(Serializable[].class, newArray.getClass());
        assertEquals(Arrays.asList(expSerArray), Arrays.asList(newArray));
        
    }

    
    
    
    @Test
    public void test17() {

        final Serializable[] expSerArray = new Serializable[] {"one", "two", "three", Integer.valueOf(3) };
        
        final Serializable[] serArray = new String[] {"one", "two", "three" };
        
        Serializable[] newArray =
            Op.onArrayOf(Types.SERIALIZABLE, serArray).ifNotNull().
                execAsArray(
                        new IFunction<Serializable[],Serializable[]>() {
    
                            public Type<? extends Serializable[]> getResultType(Type<? extends Serializable[]> targetType) {
                                return targetType;
                            }
    
                            public Serializable[] execute(final Serializable[] object, final ExecCtx ctx) throws Exception {
                                final String[] result = new String[object.length];
                                for (int i = 0; i < object.length; i++) {
                                    result[i] = (String) object[i];
                                }
                                return result;
                            }
                        
                        }).endIf().add(Integer.valueOf(3)).get();
        
        assertEquals(Serializable[].class, newArray.getClass());
        assertEquals(Arrays.asList(expSerArray), Arrays.asList(newArray));
        
    }

    
    @Test
    public void test18() {

        final Serializable[] expSerArray = new Serializable[] {"one", "two", "three", Integer.valueOf(3) };
        
        final Serializable[] serArray = new String[] {"one", "two", "three" };
        
        Serializable[] newArray =
            Op.onArrayOf(Types.SERIALIZABLE, serArray).replaceWith(serArray).add(Integer.valueOf(3)).get();
        
        assertEquals(Serializable[].class, newArray.getClass());
        assertEquals(Arrays.asList(expSerArray), Arrays.asList(newArray));
        
    }

    
    @Test
    public void test19 () {

        final Serializable[] expSerArray = new Serializable[] {"one", "two", "three", Integer.valueOf(3) };
        
        final Serializable[] serArray = new String[] {"one", "two", "three" };
        
        Serializable[] newArray =
            Op.on(serArray).asArrayOf(Types.SERIALIZABLE).add(Integer.valueOf(3)).get();
        
        assertEquals(Serializable[].class, newArray.getClass());
        assertEquals(Arrays.asList(expSerArray), Arrays.asList(newArray));
        
    }


    
    @Test
    public void test20() {

        final List<String> stringList = this.testUtils.getStringList(10);
        
        try {
            Op.onList(stringList).forEach().exec(Call.asInteger("toUpperCase")).endFor().toArrayOf(Types.INTEGER).get();
        } catch (ExecutionException e) {
            assertTrue(e.getCause().getMessage().startsWith("Result of calling method"));
        }
        
    }

    
    @Test
    public void test21() {

        final List<String> stringList = Arrays.asList(new String[] {"one", "two", "three"});
        final List<String> stringUpperList = Arrays.asList(new String[] {"ONE", "TWO", "THREE"});

        final List<String> result = 
            Op.onList(stringList).map(StringFuncs.toUpperCase()).get();
        
        assertEquals(stringUpperList, result);
        
    }

    
    @Test
    @SuppressWarnings("unchecked")
    public void test22() {

        final List<List<String>> stringListOfList = Arrays.asList(
                Arrays.asList(new String[] {"one", "two", "three", "four"}),
                Arrays.asList(new String[] {"un", "dous", "tres", "catro"})
                );
        
        final List<List<String>> stringUpperListOfList = Arrays.asList(
                Arrays.asList(new String[] {"ONE", "TWO", "THREE", "FOUR"}),
                Arrays.asList(new String[] {"UN", "DOUS", "TRES", "CATRO"})
                );

        final List<List<String>> result = 
            Op.onListOfList(stringListOfList).mapMap(StringFuncs.toUpperCase()).get();
        
        assertEquals(stringUpperListOfList, result);
        
    }

    
    @Test
    public void test24() {

        final List<String> stringList = Arrays.asList(new String[] {"one", "two", "three", null});
        final List<String> stringUpperList = Arrays.asList(new String[] {"ONE", "TWO", "THREE", null});

        final List<String> result = 
            Op.onList(stringList).forEach().execIfNotNull(StringFuncs.toUpperCase()).get();
        
        assertEquals(stringUpperList, result);
        
    }
    
}
