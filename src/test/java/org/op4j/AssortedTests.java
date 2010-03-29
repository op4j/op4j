package org.op4j;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.junit.Before;
import org.junit.Test;
import org.op4j.exceptions.ExecutionException;
import org.op4j.functions.Call;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.Fn;
import org.op4j.functions.FnArray;
import org.op4j.functions.FnBigDecimal;
import org.op4j.functions.FnInteger;
import org.op4j.functions.FnLong;
import org.op4j.functions.FnNumber;
import org.op4j.functions.FnString;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.functions.Ognl;
import org.op4j.test.auto.TestOperation;

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
			public String execute(String input, ExecCtx ctx)
			throws Exception {
				return ctx.getIndex() + " - " + input;
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
		.addAll(data2).removeAllNullOrFalse(new IFunction<String, Boolean>() {

			public Boolean execute(String input, ExecCtx ctx)
			throws Exception {
				return Boolean.valueOf(StringUtils.contains("a", input));
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

//	@Test
//	public void test3() {
//		List<BigDecimal>[] data = this.testUtils.getBigDecimalListArray(10);
//
//		List<BigDecimal>[] result = Op.onArrayOfList(data)
//		.forEach().forEach().exec(Ognl.asBigDecimal("add(#param[0])", BigDecimal.valueOf(56)))
//		.get();
//
//		assertEquals(data.length, result.length);
//		for (int indexA = 0; indexA < data.length; indexA++) {
//			List<BigDecimal> aData = data[indexA];
//			List<BigDecimal> aResult = result[indexA];
//			for (int indexB = 0; indexB < aData.size(); indexB++) {
//				assertEquals(aData.get(indexB).add(BigDecimal.valueOf(56)), 
//						aResult.get(indexB));
//			}
//		}
//	}

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

//	@Test
//	public void test5() {
//		Date[][] data = this.testUtils.getDateArrayOfArray(6, 3);
//
//		List<Calendar> result = Op.onArrayOfArrayOf(Types.DATE, data)
//		.forEach().forEach().exec(Types.CALENDAR, ToCalendar.fromDate())
//		.endFor().endFor().flatten(Types.CALENDAR).toList().get();
//
//		int index = 0;
//		for (int outer = 0; outer < data.length; outer++) {
//			Date[] innerDate = data[outer];
//
//			for (int inner = 0; inner < innerDate.length; inner++) {
//				Calendar aCalendar = Calendar.getInstance();
//				aCalendar.setTime(innerDate[inner]);
//				assertEquals(aCalendar, 
//						result.get(index++));				
//			}
//		}
//	}

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

//	@Test
//	public void test9() {
//		Map<Integer, List<String>> data = this.testUtils.getMapOfIntegerStringList(5);
//		Iterator<Integer> iterator = data.keySet().iterator();
//		Integer firstKey = iterator.next();
//		Integer secondKey = iterator.next();
//		Map<Integer, List<String>> result = Op.onMapOfList(data)
//		.forEachEntry()
//		.ifKeyNotEquals(firstKey, secondKey)
//		.onValue()
//		.add("added with op4j")
//		.get();
//
//		assertEquals(data.size(), result.size());
//		int index = 0;
//		for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {	
//			if (index < 2) {
//				assertEquals(
//						data.get(entry.getKey()), 
//						entry.getValue());
//			} else {
//				assertEquals(
//						Op.onList(data.get(entry.getKey())).add("added with op4j").get(), 
//						entry.getValue());
//			}
//			index++;
//		}		
//	}
//
//	@Test
//	public void test10() {
//		Map<Integer, Calendar[]> data = this.testUtils.getMapOfIntegerCalendarArray(13);
//
//
//		Map<Integer, Calendar[]> result = Op.onMapOfArrayOf(Types.CALENDAR, data)
//		.forEachEntry()
//		.onValue()
//		.forEach()
//		.exec(new IFunction<Calendar, Calendar>() {
//			public Calendar execute(Calendar object, ExecCtx ctx)
//			throws Exception {
//				Calendar calendar = Calendar.getInstance();
//				calendar.setTime(object.getTime());
//				calendar.set(Calendar.YEAR, 2000);
//				return calendar;
//			}
//		})
//		.endFor()
//		.get();
//
//		assertEquals(data.size(), result.size());
//		for (Map.Entry<Integer, Calendar[]> entry : result.entrySet()) {	
//			int index = 0;
//			for (Calendar calendar : entry.getValue()) {
//				Calendar original = Calendar.getInstance();
//				original.setTime(data.get(entry.getKey())[index].getTime());
//				original.set(Calendar.YEAR, 2000);
//				assertEquals(
//						original, 
//						calendar);
//				index++;
//			}				
//		}		
//	}

//	@Test
//	public void test11() {
//		Map<Integer, Map<Integer, String[]>> data = this.testUtils.getMapOfIntegerMapOfIntegerStringArray(11);
//
//		Map<Integer, Map<Integer, String[]>> result = Op.onMapOfMap(data)
//		.forEachEntry()
//		.onValue()
//		.forEachEntry()
//		.ifKeyNotEquals(Integer.valueOf(2), Integer.valueOf(33), Integer.valueOf(17))
//		.onValue()
//		.ifTrue(new IFunction<Boolean, String[]>() {
//			public Boolean execute(String[] object, ExecCtx ctx)
//			throws Exception {
//				return Boolean.valueOf(object.length > 3);					
//			}
//			public Type<? extends Boolean> getResultType(
//					Type<? extends String[]> targetType) {
//				return Types.BOOLEAN;
//			}
//		})
//		.exec(new IFunction<String[], String[]>() {
//			public String[] execute(String[] object, ExecCtx ctx)
//			throws Exception {					
//				return Op.onArrayOf(Types.STRING,object).add("value added with ifunction").get();
//			}
//		})
//		.get();
//
//
//		assertEquals(data.size(), result.size());
//		for (Map.Entry<Integer, Map<Integer, String[]>> entry1 : result.entrySet()) {				
//			for (Map.Entry<Integer, String[]> entry2 : entry1.getValue().entrySet()) {
//				if (ArrayUtils.contains(new Integer[] {Integer.valueOf(2), Integer.valueOf(33), Integer.valueOf(17)}, 
//						entry2.getKey())) {
//					assertEquals(data.get(entry1.getKey()).get(entry2.getKey()), entry2.getValue());
//				} else {
//					if (entry2.getValue().length > 3) {	
//						assertEquals(Arrays.asList(Op.onArrayOf(Types.STRING, data.get(entry1.getKey()).get(entry2.getKey()))
//								.add("value added with ifunction").get()), 
//								Arrays.asList(entry2.getValue()));						
//					} else {
//						assertEquals(Arrays.asList(data.get(entry1.getKey()).get(entry2.getKey())), 
//								Arrays.asList(entry2.getValue()));
//					}
//				}				
//			}				
//		}		
//	}

//	@Test
//	public void test12() {
//		Map<Integer, Map<Integer, String[]>> data = this.testUtils.getMapOfIntegerMapOfIntegerStringArray(11);
//
//		Map<Integer, Map<Integer, String[]>> result = Op.onMapOfMap(data)
//		.ifFalse(new IFunction<Boolean, Map<Integer, Map<Integer, String[]>>>() {
//			public Boolean execute(Map<Integer, Map<Integer, String[]>> object, ExecCtx ctx)
//			throws Exception {
//				return Boolean.valueOf(object.size() > 13);					
//			}
//			public Type<? extends Boolean> getResultType(
//					Type<? extends Map<Integer, Map<Integer, String[]>>> targetType) {
//				return Types.BOOLEAN;
//			}
//		})
//		.forEachEntry()
//		.ifIndexNot(1, 3)
//		.onValue()
//		.ifNotNull()
//		.forEachEntry()
//		.ifKeyNotEquals(Integer.valueOf(2), Integer.valueOf(33))
//		.onValue()
//		.ifTrue(new IFunction<Boolean, String[]>() {
//			public Boolean execute(String[] object, ExecCtx ctx)
//			throws Exception {
//				return Boolean.valueOf(object.length > 3);					
//			}
//			public Type<? extends Boolean> getResultType(
//					Type<? extends String[]> targetType) {
//				return Types.BOOLEAN;
//			}
//		})
//		.exec(new IFunction<String[], String[]>() {
//			public String[] execute(String[] object, ExecCtx ctx)
//			throws Exception {					
//				return Op.onArrayOf(Types.STRING, object).add("value added with ifunction").get();
//			}
//		})
//		.get();
//
//		if (!(data.size() > 13)) {
//			assertEquals(data.size(), result.size());
//			int index = 0;
//			for (Map.Entry<Integer, Map<Integer, String[]>> entry1 : result.entrySet()) {
//				if (index != 1 && index != 3) {
//					if (entry1.getValue() != null) {
//						for (Map.Entry<Integer, String[]> entry2 : entry1.getValue().entrySet()) {
//							if (!ArrayUtils.contains(new Integer[] {Integer.valueOf(2), Integer.valueOf(33)}, 
//									entry2.getKey())) {
//								if (entry2.getValue().length > 3) {	
//									assertEquals(Arrays.asList(Op.onArrayOf(Types.STRING, data.get(entry1.getKey()).get(entry2.getKey()))
//											.add("value added with ifunction").get()), 
//											Arrays.asList(entry2.getValue()));						
//								} else {
//									assertEquals(Arrays.asList(data.get(entry1.getKey()).get(entry2.getKey())), 
//											Arrays.asList(entry2.getValue()));
//								}
//							}
//						}	
//					}
//				}	
//				index++;
//			}	
//		}
//	}
	
	

//    @Test
//    public void test13() {
//        
//        List<String> stringList = this.testUtils.getStringList(10);
//        List<String> newStringList =
//            Op.onList(stringList).
//                forEach().
//                    exec(StringFuncs.toUpperCase()).
//                    ifIndex(2).exec(StringFuncs.toLowerCase()).endIf().
//                    exec(Ognl.asString("#target + '--' + #index")).get();
//
//        for (int i = 0; i < 10; i++) {
//            if (i != 2) {
//                assertEquals(stringList.get(i).toUpperCase() + "--" + i, newStringList.get(i));
//            } else {
//                assertEquals(stringList.get(i).toLowerCase() + "--" + i, newStringList.get(i));
//            }
//        }
//        
//        List<List<String>> stringListOfList = this.testUtils.getStringListOfList(10,50);
//        List<List<String>> newStringListOfList =
//            Op.onListOfList(stringListOfList).
//                forEach().forEach().
//                    exec(StringFuncs.toUpperCase()).
//                    ifIndex(2).exec(StringFuncs.toLowerCase()).endIf().
//                    exec(Ognl.asString("#target + '--' + #indexes[1] + #indexes[2]")).get();
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 50; j++) {
//                if (j != 2) {
//                    assertEquals(stringListOfList.get(i).get(j).toUpperCase() + "--" + i + j, newStringListOfList.get(i).get(j));
//                } else {
//                    assertEquals(stringListOfList.get(i).get(j).toLowerCase() + "--" + i + j, newStringListOfList.get(i).get(j));
//                }
//            }
//        }
//        
//        List<String> strList =
//            Op.onAll("one", "two", "three").ifIndex(2).exec(StringFuncs.toUpperCase()).getAsList();
//        assertEquals("THREE", strList.get(2));
//        
//        List<String> strList2 =
//            Op.onAll("one", "two", "three").exec(Ognl.asString("#target + '--' + #index")).getAsList();
//        assertEquals("three--2", strList2.get(2));
//        
//        List<String> strList3 =
//            Op.onAll("one", "two", "three").exec(Ognl.asString("#target + '--' + #indexes[0]")).getAsList();
//        assertEquals("three--2", strList3.get(2));
//        
//        List<String> strList4 =
//            Op.onAll("one", "two", "three").ifTrue(Ognl.asBoolean("#indexes[0] == 2")).exec(StringFuncs.toUpperCase()).getAsList();
//        assertEquals("THREE", strList4.get(2));
//        
//    }
	
    
    @Test
    public void test14() {

        List<Integer> expectedListInt1 = Arrays.asList(new Integer[] { 234,12,231 });
        List<Integer> expectedListInt2 = Arrays.asList(new Integer[] { 234,10 });
        
        List<Integer> listInt1 = Op.onListFor(234,12,231).get();
        List<Integer> listInt2 = Op.onListFor(234).addAll(10).get();
        
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
    
                            public Serializable[] execute(final Serializable[] input, final ExecCtx ctx) throws Exception {
                                final String[] result = new String[input.length];
                                for (int i = 0; i < input.length; i++) {
                                    result[i] = (String) input[i];
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
            Op.on(serArray).of(Types.SERIALIZABLE).add(Integer.valueOf(3)).get();
        
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
            Op.onList(stringList).map(FnString.toUpperCase()).get();
        
        assertEquals(stringUpperList, result);
        
    }

    
//    @Test
//    @SuppressWarnings("unchecked")
//    public void test22() {
//
//        final List<List<String>> stringListOfList = Arrays.asList(
//                Arrays.asList(new String[] {"one", "two", "three", "four"}),
//                Arrays.asList(new String[] {"un", "dous", "tres", "catro"})
//                );
//        
//        final List<List<String>> stringUpperListOfList = Arrays.asList(
//                Arrays.asList(new String[] {"ONE", "TWO", "THREE", "FOUR"}),
//                Arrays.asList(new String[] {"UN", "DOUS", "TRES", "CATRO"})
//                );
//
//        final List<List<String>> result = 
//            Op.onListOfList(stringListOfList).mapMap(StringFuncs.toUpperCase()).get();
//        
//        assertEquals(stringUpperListOfList, result);
//        
//    }

    
    @Test
    public void test24() {

        final List<String> stringList = Arrays.asList(new String[] {"one", "two", "three", null});
        final List<String> stringUpperList = Arrays.asList(new String[] {"ONE", "TWO", "THREE", null});

        final List<String> result = 
            Op.onList(stringList).forEach().execIfNotNull(FnString.toUpperCase()).get();
        
        assertEquals(stringUpperList, result);
        
    }

    
    @Test
    public void test25() {

        final List<String> stringList = Arrays.asList(new String[] {"one", "two", "three", null});
        final List<String> stringUpperList = Arrays.asList(new String[] {"ONE", "TWO", "THREE", null});

        final List<String> result = 
            Op.onList(stringList).mapIfNotNull(FnString.toUpperCase()).get();
        
        assertEquals(stringUpperList, result);
        
    }

    
    @Test
    public void test26() {

        final String[] stringArr = new String[] {"one", "two", "three", "three", null, null};
        final String[] stringArrDist = new String[] {"one", "two", "three", null, "four"};

        final String[] result = 
            Op.onArrayOf(Types.STRING, stringArr).
                    exec(FnArray.ofString().distinct()).
                    exec(FnArray.ofString().add("four")).
                    get();
        
        assertEquals(String[].class, result.getClass());
        assertEquals(Arrays.asList(stringArrDist), Arrays.asList(result));
        
    }
    
    @SuppressWarnings("unchecked")
	@Test
    public void test27() {

        final List<Integer> integerList = Arrays.asList(new Integer[]{null, 23, 34, null, -34});

        List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {Integer.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("ifNotNull"));
		testOperations.add(new TestOperation("replaceWith", new Object[]{null}));
		testOperations.add(new TestOperation("endIf"));
		testOperations.add(new TestOperation("exec", new Object[]{FnNumber.toStr()}));
		testOperations.add(new TestOperation("get"));
		
		final List<Integer> listResult = (List<Integer>)org.op4j.test.auto.Test.testOnList(integerList, testOperations);
		assertEquals(Arrays.asList(new Integer[]{null, null, null, null, null, null}), listResult);
//		System.out.println("test27. Result testOnList: " + listResult);
		
		final Integer[] arrayResult = (Integer[])org.op4j.test.auto.Test.testOnArrayOf(Types.INTEGER,
				integerList.toArray(new Integer[]{}), testOperations);
		assertEquals(Arrays.asList(new Integer[]{null, null, null, null, null, null}), Arrays.asList(arrayResult));
//		System.out.println("test27. Result testOnArray: " + ArrayUtils.toString(arrayResult));
		
    }
    
    
    @Test
    public void test28() {

        final Integer[] integerArr = new Integer[]{null, 23, 34, null, -34};
        final List<Integer> integerList = Arrays.asList(integerArr);

        final List<Integer> result = Op.on(integerArr).toList().get();
        
        assertEquals(integerList, result);
        
    }
    

    
    
    @Test
    public void test30() throws Exception {

        final List<String> stringList = Arrays.asList(new String[] {"one", "two", "three", null});
        final List<String> stringUpperList = Arrays.asList(new String[] {"ONE", "TWO", "THREE", null});
        
        final Function<List<String>,List<String>> fn =
            Fn.onListOf(Types.STRING).map(FnString.toUpperCase()).get();
        
        final List<String> result = fn.execute(stringList);
        
        assertEquals(stringUpperList, result);
        
        final List<String> result2 = Op.on(stringList).exec(fn).get();
        
        assertEquals(stringUpperList, result2);
        
    }
    
    
    @Test
    public void test31() throws Exception {
        assertEquals(Integer.valueOf(4), Op.on(10).exec(FnInteger.divideBy(3,RoundingMode.CEILING)).get());
    }

    
    @Test
    public void test32() throws Exception {
        assertEquals(Boolean.TRUE, Op.onListFor(10,11).all(Ognl.asBoolean("#target <= 11")).get());
    }

    
    @Test
    public void test33() throws Exception {
        assertEquals(Boolean.TRUE, Op.onListFor(10,11).any(Ognl.asBoolean("#target < 11")).get());
    }
    
    @Test
    public void test34() {

        final List<Integer> integerList = Arrays.asList(new Integer[]{null, 23, 34, null, -34});

        assertEquals(Arrays.asList(null, 27, 38, null, -30), Op.on(integerList).forEach().exec(FnInteger.add(4)).get());
        
    }
    
    @Test
    public void test35() {

        final List<BigDecimal> list = Arrays.asList(new BigDecimal[]{null, BigDecimal.valueOf(23), 
                BigDecimal.valueOf(34), null, BigDecimal.valueOf(-34)});

        assertEquals(Arrays.asList(null, BigDecimal.valueOf(23).add(BigDecimal.valueOf(4)), 
                BigDecimal.valueOf(34).add(BigDecimal.valueOf(4)), null, BigDecimal.valueOf(-34).add(BigDecimal.valueOf(4))), 
                Op.on(list).forEach().exec(FnBigDecimal.add(BigDecimal.valueOf(4))).get());
        
    }
    
    
    
    @Test
    public void test36() throws Exception {

        final List<Long> result = Arrays.asList(new Long[] { 53L, 430L });

        List<Long> values = Arrays.asList(new Long[] { 6641L, 53L, 430L, 1245L });

        {
            values =
                Op.on(values).removeAllTrue(FnLong.greaterThan(500)).get();
                
            assertEquals(result, values);
        }

    }


    
    @Test
    public void test37() throws Exception {

        final Long[] values = new Long[] { 53L, 430L };

        String[] keys = new String[] { "A", "A" };

        {
            Map<String,Long[]> groupedMap =
                Op.on(keys).zipAndGroupValuesFrom(Types.LONG, values).get();
                
            assertEquals(1, groupedMap.size());
            assertEquals(Long[].class, groupedMap.get("A").getClass());
            assertEquals(Arrays.asList(values), Arrays.asList(groupedMap.get("A")));
        }

    }
    
    
    @Test
    public void test38() throws Exception {

        final String str = "Earth";
        Boolean matches = Op.on(str).exec(FnString.matches("a")).get();
        assertEquals(Boolean.FALSE, matches);
        matches = Op.on(str).exec(FnString.matches(".a.*h")).get();
        assertEquals(Boolean.TRUE, matches);
        
    }
    
    
    @Test
    public void test39() throws Exception {

        final String str = "Earth";
        Boolean matches = Op.on(str).exec(FnString.contains("a")).get();
        assertEquals(Boolean.TRUE, matches);
        matches = Op.on(str).exec(FnString.contains("b")).get();
        assertEquals(Boolean.FALSE, matches);
        matches = Op.on(str).exec(FnString.contains(".a.*h")).get();
        assertEquals(Boolean.TRUE, matches);
        
    }
    
    
    @Test
    public void test40() throws Exception {

        final String str = 
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
        	"Fusce a lacus lectus, quis tristique nibh. Aenean sit amet dolor justo. " +
        	"Morbi nibh urna, ornare non congue non, dignissim at nibh. Nulla euismod, " +
        	"dui id consequat tempus, lacus velit sodales metus, non luctus ipsum " +
        	"purus id neque. Ut eleifend vestibulum rutrum. Praesent quis dui urna, " +
        	"quis cursus arcu. Aliquam interdum quam quis erat condimentum ullamcorper. " +
        	"Nam eget massa eu tellus pulvinar blandit sed quis libero. Proin ut quam " +
        	"nunc, id rutrum mi. Vestibulum ante ipsum primis in faucibus orci luctus " +
        	"et ultrices posuere cubilia Curae;";
        

        assertEquals(11, Op.on(str).exec(FnString.extractAll("qu..")).get().size());
        assertEquals("quis", Op.on(str).exec(FnString.extractFirst("qu..")).get());
        assertEquals("quam", Op.on(str).exec(FnString.extractLast("qu..")).get());
        assertEquals("eleif", Op.on(str).exec(FnString.matchAndExtract("(.*?)(ele..)(.*?)", 2)).get());
        assertEquals(Arrays.asList(new String[] {"eleif", "liq"}), Op.on(str).exec(FnString.matchAndExtractAll("(.*?)(ele..)(.*?)(li.)(.*?)", 2, 4)).get());
        
    }

    
    
    @Test
    public void test41() throws Exception {

        String[] arr1 = new String[] { "one", "two", "three" };
        String[] arr2 = new String[] { "one", "two", "three", "four" };
        String[] arr3 = new String[] { "one", "two" };
        String[] arr4 = new String[] { "one" };
        String[] arr5 = new String[] {  };
        
        String[] arr1Res = new String[] { "three", "two", "one" };
        String[] arr2Res = new String[] { "four", "three", "two", "one" };
        String[] arr3Res = new String[] { "two", "one" };
        String[] arr4Res = new String[] { "one" };
        String[] arr5Res = new String[] {  };

        arr1 = Op.on(arr1).reverse().get();
        arr2 = Op.on(arr2).reverse().get();
        arr3 = Op.on(arr3).reverse().get();
        arr4 = Op.on(arr4).reverse().get();
        arr5 = Op.on(arr5).reverse().get();
        
        assertEquals(Arrays.asList(arr1Res), Arrays.asList(arr1));
        assertEquals(Arrays.asList(arr2Res), Arrays.asList(arr2));
        assertEquals(Arrays.asList(arr3Res), Arrays.asList(arr3));
        assertEquals(Arrays.asList(arr4Res), Arrays.asList(arr4));
        assertEquals(Arrays.asList(arr5Res), Arrays.asList(arr5));
        
    }
    
    
    
    @Test
    public void test42() throws Exception {

        List<String> list1 = Arrays.asList(new String[] { "one", "two", "three" });
        List<String> list2 = Arrays.asList(new String[] { "one", "two", "three", "four" });
        List<String> list3 = Arrays.asList(new String[] { "one", "two" });
        List<String> list4 = Arrays.asList(new String[] { "one" });
        List<String> list5 = Arrays.asList(new String[] {  });
        
        List<String> list1Res = Arrays.asList(new String[] { "three", "two", "one" });
        List<String> list2Res = Arrays.asList(new String[] { "four", "three", "two", "one" });
        List<String> list3Res = Arrays.asList(new String[] { "two", "one" });
        List<String> list4Res = Arrays.asList(new String[] { "one" });
        List<String> list5Res = Arrays.asList(new String[] {  });

        list1 = Op.on(list1).reverse().get();
        list2 = Op.on(list2).reverse().get();
        list3 = Op.on(list3).reverse().get();
        list4 = Op.on(list4).reverse().get();
        list5 = Op.on(list5).reverse().get();
        
        assertEquals(list1Res, list1);
        assertEquals(list2Res, list2);
        assertEquals(list3Res, list3);
        assertEquals(list4Res, list4);
        assertEquals(list5Res, list5);
        
    }
    
    
    
    @Test
    public void test43() throws Exception {

        Set<String> set1 = new LinkedHashSet<String>(Arrays.asList(new String[] { "one", "two", "three" }));
        Set<String> set2 = new LinkedHashSet<String>(Arrays.asList(new String[] { "one", "two", "three", "four" }));
        Set<String> set3 = new LinkedHashSet<String>(Arrays.asList(new String[] { "one", "two" }));
        Set<String> set4 = new LinkedHashSet<String>(Arrays.asList(new String[] { "one" }));
        Set<String> set5 = new LinkedHashSet<String>(Arrays.asList(new String[] {  }));
        
        Set<String> set1Res = new LinkedHashSet<String>(Arrays.asList(new String[] { "three", "two", "one" }));
        Set<String> set2Res = new LinkedHashSet<String>(Arrays.asList(new String[] { "four", "three", "two", "one" }));
        Set<String> set3Res = new LinkedHashSet<String>(Arrays.asList(new String[] { "two", "one" }));
        Set<String> set4Res = new LinkedHashSet<String>(Arrays.asList(new String[] { "one" }));
        Set<String> set5Res = new LinkedHashSet<String>(Arrays.asList(new String[] {  }));

        set1 = Op.on(set1).reverse().get();
        set2 = Op.on(set2).reverse().get();
        set3 = Op.on(set3).reverse().get();
        set4 = Op.on(set4).reverse().get();
        set5 = Op.on(set5).reverse().get();
        
        assertEquals(set1Res, set1);
        assertEquals(set2Res, set2);
        assertEquals(set3Res, set3);
        assertEquals(set4Res, set4);
        assertEquals(set5Res, set5);
        
    }

    
    
    
    @Test
    public void test44() throws Exception {

        Map<Integer, String> map0 = new LinkedHashMap<Integer, String>();
        Map<Integer, String> map1 = new LinkedHashMap<Integer, String>(map0);
        map1.put(1, "one");
        Map<Integer, String> map2 = new LinkedHashMap<Integer, String>(map1);
        map2.put(2, "two");
        Map<Integer, String> map3 = new LinkedHashMap<Integer, String>(map2);
        map3.put(3, "three");
        Map<Integer, String> map4 = new LinkedHashMap<Integer, String>(map3);
        map4.put(4, "four");
        
        Map<Integer, String> map0Res = new LinkedHashMap<Integer, String>();
        Map<Integer, String> map1Res = new LinkedHashMap<Integer, String>();
        map1Res.put(1, "one");
        Map<Integer, String> map2Res = new LinkedHashMap<Integer, String>();
        map2Res.put(2, "two");
        map2Res.put(1, "one");
        Map<Integer, String> map3Res = new LinkedHashMap<Integer, String>();
        map3Res.put(3, "three");
        map3Res.put(2, "two");
        map3Res.put(1, "one");
        Map<Integer, String> map4Res = new LinkedHashMap<Integer, String>();
        map4Res.put(4, "four");
        map4Res.put(3, "three");
        map4Res.put(2, "two");
        map4Res.put(1, "one");


        map0 = Op.on(map0).reverse().get();
        map1 = Op.on(map1).reverse().get();
        map2 = Op.on(map2).reverse().get();
        map3 = Op.on(map3).reverse().get();
        map4 = Op.on(map4).reverse().get();
        
        assertEquals(map0Res, map0);
        assertEquals(map1Res, map1);
        assertEquals(map2Res, map2);
        assertEquals(map3Res, map3);
        assertEquals(map4Res, map4);
        
    }

    
    
    @Test
    public void test45() throws Exception {
    
        
        Function<Object,String> keyFn = Ognl.asString("'KEY: ' + #target");
        Function<Object,String> valueFn = Ognl.asString("'VALUE: ' + #target");
        
        String[] valuesArray = new String[] {"one", "two", "three", "one"};
        List<String> valuesList = Arrays.asList(valuesArray);
        Set<String> valuesSet = new LinkedHashSet<String>(valuesList);
        
        Map<String,String> mapArray = Op.on(valuesArray).toMap(keyFn, valueFn).get(); 
        Map<String,String> mapList = Op.on(valuesList).toMap(keyFn, valueFn).get(); 
        Map<String,String> mapSet = Op.on(valuesSet).toMap(keyFn, valueFn).get();
        
        assertEquals(3, mapArray.size());
        assertEquals("KEY: one", mapArray.keySet().iterator().next());
        assertEquals("VALUE: one", mapArray.get("KEY: one"));
        assertEquals("VALUE: two", mapArray.get("KEY: two"));
        assertEquals(mapArray, mapList);
        assertEquals(mapList, mapSet);

        Map<String,String[]> mapGroupArray = Op.on(valuesArray).toGroupMapOf(Types.STRING, keyFn, valueFn).get(); 
        Map<String,List<String>> mapGroupList = Op.on(valuesList).toGroupMap(keyFn, valueFn).get(); 
        Map<String,Set<String>> mapGroupSet = Op.on(valuesSet).toGroupMap(keyFn, valueFn).get();

        assertEquals(3, mapGroupArray.size());
        assertEquals(3, mapGroupList.size());
        assertEquals(3, mapGroupSet.size());
        assertEquals(2, mapGroupArray.get("KEY: one").length);
        assertEquals(2, mapGroupList.get("KEY: one").size());
        assertEquals(1, mapGroupSet.get("KEY: one").size());
        assertEquals(1, mapGroupArray.get("KEY: two").length);
        assertEquals(1, mapGroupList.get("KEY: two").size());
        assertEquals(1, mapGroupSet.get("KEY: two").size());
        assertEquals(String[].class, mapGroupArray.get("KEY: one").getClass());
        assertEquals(ArrayList.class, mapGroupList.get("KEY: one").getClass());
        assertEquals(LinkedHashSet.class, mapGroupSet.get("KEY: one").getClass());
        assertEquals("KEY: one", mapGroupArray.keySet().iterator().next());
        assertEquals("VALUE: one", mapGroupArray.get("KEY: one")[0]);
        assertEquals("VALUE: two", mapGroupArray.get("KEY: two")[0]);
        assertEquals(Arrays.asList(mapGroupArray.get("KEY: one")), mapGroupList.get("KEY: one"));
        assertEquals(Arrays.asList(mapGroupArray.get("KEY: two")), mapGroupList.get("KEY: two"));
        assertEquals(Arrays.asList(mapGroupArray.get("KEY: three")), mapGroupList.get("KEY: three"));
        assertEquals(mapGroupList.get("KEY: two"), new ArrayList<String>(mapGroupSet.get("KEY: two")));
        assertEquals(mapGroupList.get("KEY: three"), new ArrayList<String>(mapGroupSet.get("KEY: three")));
        
    }
    
    
}

