package org.op4j;


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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

import org.apache.commons.lang.LocaleUtils;
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
import org.op4j.functions.FnBigInteger;
import org.op4j.functions.FnBoolean;
import org.op4j.functions.FnDouble;
import org.op4j.functions.FnFloat;
import org.op4j.functions.FnInteger;
import org.op4j.functions.FnLong;
import org.op4j.functions.FnNumber;
import org.op4j.functions.FnShort;
import org.op4j.functions.FnString;
import org.op4j.functions.Function;
import org.op4j.functions.IFunction;
import org.op4j.functions.FnString.AsciifyMode;
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
            Op.onList(stringList).forEach().exec(Call.methodForInteger("toUpperCase")).endFor().toArrayOf(Types.INTEGER).get();
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
        List<Boolean> result = Op.onListFor(BigDecimal.valueOf(34), Double.valueOf(34), BigDecimal.valueOf(34).setScale(4))
            .forEach().exec(FnNumber.eqValue(BigDecimal.valueOf(34))).get();
        
        assertTrue("BigDecimal.valueOf(34) equals to BigDecimal.valueOf(34)", result.get(0));
        assertTrue("Double.valueOf(34) equals to BigDecimal.valueOf(34)", result.get(1));
        assertTrue("BigDecimal.valueOf(34).setScale(4) equals to BigDecimal.valueOf(34)", result.get(2));       
        
    }
    
    @Test
    public void test46() throws Exception {
        List<Boolean> result = Op.onListFor(BigDecimal.valueOf(34), Double.valueOf(34), BigDecimal.valueOf(34).setScale(4))
            .forEach().exec(FnNumber.notEqValue(BigDecimal.valueOf(34))).get();
        
        assertFalse("BigDecimal.valueOf(34) notequals to BigDecimal.valueOf(34)", result.get(0));
        assertFalse("Double.valueOf(34) notequals to BigDecimal.valueOf(34)", result.get(1));
        assertFalse("BigDecimal.valueOf(34).setScale(4) notequals to BigDecimal.valueOf(34)", result.get(2)); 
        
    }
    
    @Test
    public void test47() throws Exception {
        Boolean result = Op.on(Types.BIG_DECIMAL, null)
            .exec(FnNumber.notEq(null)).get();
        assertFalse("null notequals to null", result);
        
        result = Op.on(Types.BIG_DECIMAL, null)
            .exec(FnNumber.eq(null)).get();
        assertTrue("null equals to null", result);
    
    }
  
    @Test
    public void test48() throws Exception {
        Boolean result = Op.on(Types.BIG_DECIMAL, null)
            .exec(FnBigDecimal.notEq(null)).get();
        assertFalse("null notequals to null", result);
        
        result = Op.on(Types.BIG_DECIMAL, null)
            .exec(FnBigDecimal.eq(null)).get();
        assertTrue("null equals to null", result);
    
    }
  
    @Test
    public void test49() throws Exception {
        List<Boolean> result = Op.onListFor(BigDecimal.valueOf(34), BigDecimal.valueOf(34).setScale(10), BigDecimal.valueOf(34).setScale(4))
            .forEach().exec(FnBigDecimal.eqValue(BigDecimal.valueOf(34))).get();
        
        assertTrue("BigDecimal.valueOf(34) equals to BigDecimal.valueOf(34)", result.get(0));
        assertTrue("BigDecimal.valueOf(34).setScale(10) equals to BigDecimal.valueOf(34)", result.get(1));
        assertTrue("BigDecimal.valueOf(34).setScale(4) equals to BigDecimal.valueOf(34)", result.get(2));       
        
    }
    
    @Test
    public void test50() throws Exception {
        List<Boolean> result = Op.onListFor(BigDecimal.valueOf(34), BigDecimal.valueOf(34).setScale(10), BigDecimal.valueOf(34).setScale(4))
            .forEach().exec(FnBigDecimal.notEqValue(BigDecimal.valueOf(34))).get();
        
        assertFalse("BigDecimal.valueOf(34) notequals to BigDecimal.valueOf(34)", result.get(0));
        assertFalse("BigDecimal.valueOf(34).setScale(10) notequals to BigDecimal.valueOf(34)", result.get(1));
        assertFalse("BigDecimal.valueOf(34).setScale(4) notequals to BigDecimal.valueOf(34)", result.get(2)); 
        
    }
    
    @Test
    public void test51() throws Exception {
        Boolean result = Op.on(Types.DOUBLE, null)
            .exec(FnDouble.notEq(null)).get();
        assertFalse("null notequals to null", result);
        
        result = Op.on(Types.DOUBLE, null)
            .exec(FnDouble.eq(null)).get();
        assertTrue("null equals to null", result);
    
    }
    
    @Test
    public void test52() throws Exception {
        List<Boolean> result = Op.onListFor(Double.valueOf(34), 
                null)
            .forEach().exec(FnDouble.notEq(Double.valueOf(34))).get();
        
        assertFalse("Double.valueOf(34) notequals to Double.valueOf(34)", result.get(0));
        assertTrue("null notequals to Double.valueOf(34)", result.get(1)); 
        
        
        Function<Double,Boolean> fn = FnBoolean.or(FnNumber.isNull(), FnDouble.isNull());
        Op.on(13434d).exec(fn).get();
        Op.on(13434d).exec(FnBoolean.or(FnNumber.isNull(), FnDouble.isNull())).get();
        

        Function<Double,Boolean> fn1 = FnBoolean.or(FnDouble.isNull(), FnNumber.isNull());
        Op.on(13434d).exec(fn1).get();
        Op.on(13434d).exec(FnBoolean.or(FnDouble.isNull(), FnNumber.isNull())).get();
        
    }
    
    @Test
    public void test53() throws Exception {
        
        assertTrue("Op.on(Double.valueOf(4)).exec(FnNumber.eqValue(4))", Op.on(Double.valueOf(4))
                .exec(FnNumber.eqValue(4)).get());
        assertTrue("Op.on(Double.valueOf(4)).exec(FnNumber.notEq(null))", Op.on(Double.valueOf(4))
                .exec(FnNumber.notEq(null)).get());
        assertTrue("Op.on(Double.valueOf(4)).exec(FnNumber.eqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Double.valueOf(4)).exec(FnNumber.eqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertFalse("Op.on(Double.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Double.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertFalse("Op.on(BigDecimal.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(BigDecimal.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertFalse("Op.on(Integer.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Integer.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertTrue("Op.on(Integer.valueOf(4)).exec(FnNumber.eqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Integer.valueOf(4)).exec(FnNumber.eqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertTrue("Op.on(Integer.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Double.valueOf(4.1)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertTrue("Op.on(Integer.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4.1).setScale(6)))", 
                Op.on(Double.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4.1).setScale(6))).get());
        assertTrue("Op.on(Short.valueOf((short)4)).exec(FnNumber.eqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Short.valueOf((short)4)).exec(FnNumber.eqValue(BigDecimal.valueOf(4).setScale(6))).get());
        assertFalse("Op.on(Long.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(Long.valueOf(4)).exec(FnNumber.notEqValue(BigDecimal.valueOf(4).setScale(6))).get());
        
        
        assertTrue("Op.on(Double.valueOf(4)).exec(FnNumber.eq(4))", Op.on(Double.valueOf(4))
                .exec(FnNumber.eq((double)4)).get());
        assertFalse("Op.on(Double.valueOf(4)).exec(FnNumber.eq(Integer.valueOf(4)))", Op.on(Double.valueOf(4))
                .exec(FnNumber.eq(Integer.valueOf(4))).get());
        assertFalse("Op.on(Double.valueOf(4)).exec(FnNumber.eq(BigDecimal.valueOf(4).setScale(6)))", Op.on(Double.valueOf(4))
                .exec(FnNumber.eq(BigDecimal.valueOf(4).setScale(6))).get());
        assertTrue("Op.on(BigDecimal.valueOf(4)).exec(FnNumber.notEq(BigDecimal.valueOf(4).setScale(6)))", 
                Op.on(BigDecimal.valueOf(4)).exec(FnNumber.notEq(BigDecimal.valueOf(4).setScale(6))).get());
        
    }
    
    @Test
    public void test54() throws Exception {
        assertEquals(
                Op.on(new Object[] {4.5, "hello", BigDecimal.valueOf(45.78)})
                    .exec(FnString.joinArray(",")).get(),
                    "4.5,hello,45.78");
        assertEquals(
                Op.on(new Object[] {4.5, "hello", BigDecimal.valueOf(45.78)})
                    .exec(FnString.joinArray("*")).get(),
                    "4.5*hello*45.78");
        
        assertEquals(Op.on("Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday")
                    .exec(FnString.split(",")).castToListOf(Types.STRING).forEach().exec(FnString.trim()).get(),
                    Op.onListFor("Sunday", "Monday", "Tuesday", "Wednesday", 
                            "Thursday", "Friday", "Saturday", "Sunday").get());
    }
   
    @Test
    public void test55() throws Exception {
        Calendar cal1 = Calendar.getInstance();
        assertEquals(
                Op.on(new Object[] {4.5, "hello", cal1})
                    .exec(FnString.joinArray(",")).get(),
                    "4.5,hello," + cal1.toString());
        
        assertEquals(
                Op.on(new Object[] {4.5, "hello", cal1})
                    .exec(FnString.joinArray()).get(),
                    "4.5hello" + cal1.toString());
        
        assertEquals(
                Op.on("hello*goodbye")
                    .exec(FnString.splitAsArray("*")).castToArrayOf(Types.STRING).toList().get(),
                    Op.onArrayFor("hello", "goodbye").toList().get());
        
        assertNull(
                Op.on(Types.ARRAY_OF_STRING, null)
                    .exec(FnString.joinArray(",")).get());
        
        assertNull(
                Op.on(Types.STRING, null)
                    .exec(FnString.split()).get());
        
    }
    
    
    @Test
    public void test56() throws Exception {
        
        final String testStr1 = "\u00DF\u00DF \u00DF\u00DF a \u00DF\u00DF nu\u00DF NU\u00DF nu\u00DF\u00DF NU\u00DF\u00DF \u00DF\u00DF";
        final String testStr2 = "\u00DF\u00DF";
        final String testStr3 = "LO E \u00C7\u00C0 I\u00D1\u00C6 N\u00DC\u00DF \u00DEOR! a\u00F1e\u00E7\u00E1\u00ED\u00E9\u00F3\u00FA \u00E4\u00EB\u00EF\u00F6\u00FC\u00C4\u00CB\u00CF\u00D6\u00DC";
        final String testStr4 = "LO E \u00C7\u00C0 I\u00D1\u00C6 N\u00DC\u00DF\u00DF";
        final String testStr5 = "LO E \u00C7\u00C0 I\u00D1\u00C6 N\u00DC\u00DF\u00DF ";
        final String testStr6 = "LO E \u00C7\u00C0 I\u00D1\u00C6 N\u00DC\u00DF\u00DF \u00DF";
        final String testStr7 = "LO E \u00C7\u00C0 I\u00D1\u00C6 Nu\u00DF\u00DF \u00DF";
        final String testStr8 = "LO E \u00C7\u00C0 I\u00D1\u00C6 N\u00DC\u00DF\u00DF a";
        final String testStr9 = "M\u00DCNCHEN";
        final String testStr10 = "M\u00DCNCHEN \u00E4\u00EB\u00EF\u00F6\u00FC\u00C4\u00CB\u00CF\u00D6\u00DC";

        assertEquals("SSSS SSSS a ssss nuss NUSS nussss NUSSSS SSSS", Op.on(testStr1).exec(FnString.asciify()).get());
        assertEquals("SSSS", Op.on(testStr2).exec(FnString.asciify()).get());
        assertEquals("LO E CA INAE NUSS THOR! anecaieou aeiouAEIOU", Op.on(testStr3).exec(FnString.asciify()).get());
        assertEquals("LO E CA INAE NUSSSS", Op.on(testStr4).exec(FnString.asciify()).get());
        assertEquals("LO E CA INAE NUSSSS ", Op.on(testStr5).exec(FnString.asciify()).get());
        assertEquals("LO E CA INAE NUSSSS SS", Op.on(testStr6).exec(FnString.asciify()).get());
        assertEquals("LO E CA INAE Nussss ss", Op.on(testStr7).exec(FnString.asciify()).get());
        assertEquals("LO E CA INAE NUSSSS a", Op.on(testStr8).exec(FnString.asciify()).get());
        assertEquals("MUENCHEN", Op.on(testStr9).exec(FnString.asciify(AsciifyMode.UMLAUT_E)).get());
        assertEquals("MUENCHEN aeeioeueAEEIOEUE", Op.on(testStr10).exec(FnString.asciify(AsciifyMode.UMLAUT_E)).get());
        
    }
    
    @Test
    public void test57() throws Exception {
        Short b = Short.valueOf((short)10);
        Short c = Short.valueOf((short)-3);
        
        assertEquals(Op.on(c).exec(FnShort.module(b.intValue())).get(),
                Short.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).shortValue()));
        assertEquals(Op.on(c).exec(FnShort.remainder(b.intValue())).get(),
                Short.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(b.longValue())).shortValue()));
        assertNotSame(Op.on(c).exec(FnShort.remainder(b.intValue())).get(),
                Short.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).shortValue()));       
    }
    
    @Test
    public void test58() throws Exception {
        Long b = Long.valueOf(56756710);
        Long c = Long.valueOf(-38799);
        
        assertEquals(Op.on(c).exec(FnLong.module(b.intValue())).get(),
                Long.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).longValue()));
        assertEquals(Op.on(c).exec(FnLong.remainder(b.intValue())).get(),
                Long.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(b.longValue())).longValue()));
        assertNotSame(Op.on(c).exec(FnLong.remainder(b.intValue())).get(),
                Long.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).longValue()));
        assertEquals(Op.on(c).exec(FnLong.remainder(Double.valueOf(4.5))).get(),
                Long.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(Double.valueOf(4.5).longValue())).longValue()));
        assertEquals(Op.on(c).exec(FnLong.remainder((short)56)).get(),
                Long.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(56)).longValue()));
    }
    
    @Test
    public void test59() throws Exception {
        Integer b = Integer.valueOf(56756710);
        Integer c = Integer.valueOf(-38799);
        
        assertEquals(Op.on(c).exec(FnInteger.module(b.intValue())).get(),
                Integer.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).intValue()));
        assertEquals(Op.on(c).exec(FnInteger.remainder(b.intValue())).get(),
                Integer.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(b.longValue())).intValue()));
        assertNotSame(Op.on(c).exec(FnInteger.remainder(b.intValue())).get(),
                Integer.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).intValue()));
        assertEquals(Op.on(c).exec(FnInteger.remainder(Long.valueOf(33))).get(),
                Integer.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(33)).intValue()));
        
    }
    
    @Test
    public void test60() throws Exception {
        Float b = Float.valueOf(56756710);
        Float c = Float.valueOf(-3856799);
        
        assertEquals(Op.on(c).exec(FnFloat.module(b.intValue())).get(),
                Float.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).floatValue()));
        assertEquals(Op.on(c).exec(FnFloat.remainder(b.intValue())).get(),
                Float.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(b.longValue())).floatValue()));
        assertEquals(Op.on(c).exec(FnFloat.remainder(b)).get(),
                Float.valueOf(BigInteger.valueOf(c.longValue())
                        .remainder(BigInteger.valueOf(b.longValue())).floatValue()));
        assertNotSame(Op.on(c).exec(FnFloat.remainder(b.intValue())).get(),
                Float.valueOf(BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())).floatValue()));        
    }
    
    @Test
    public void test61() throws Exception {
        Double b = Double.valueOf(56756.710);
        Double c = Double.valueOf(-3856.9799);
        
        assertEquals(Op.on(c).exec(FnDouble.remainder(b.doubleValue())).get(),
                Double.valueOf(BigDecimal.valueOf(c.doubleValue())
                        .remainder(BigDecimal.valueOf(b.doubleValue())).doubleValue()));        
    }
    
    @Test
    public void test62() throws Exception {
        BigInteger b = BigInteger.valueOf(56756710);
        BigInteger c = BigInteger.valueOf(-3856799);
        
        assertEquals(Op.on(c).exec(FnBigInteger.module(b)).get(),
                BigInteger.valueOf(c.longValue())
                        .mod(BigInteger.valueOf(b.longValue())));
        assertEquals(Op.on(c).exec(FnBigInteger.remainder(b.intValue())).get(),
                c.remainder(b));
        assertNotSame(Op.on(c).exec(FnBigInteger.remainder(b.intValue())).get(),
                c.mod(b));
    }
    
    @Test
    public void test63() throws Exception {
        assertFalse(Op.on("67e").exec(FnString.isBigDecimal()).get().booleanValue());        
        assertTrue(Op.on("67.5").exec(FnString.isBigDecimal()).get().booleanValue());  
        assertTrue(Op.on("6997.89").exec(FnString.isBigDecimal()).get().booleanValue());
        assertTrue(Op.on("6,8989898989898989898989898989898989898989898").exec(FnString
                .isBigDecimal(LocaleUtils.toLocale("es"))).get().booleanValue());
        
        
        System.out.println(Op.on("6,9.9.7.89fgfd").exec(FnString
                .toBigDecimal(LocaleUtils.toLocale("es"))).get());
        System.out.println(Op.on("6.9.97,89").exec(FnString
                .toBigDecimal(LocaleUtils.toLocale("es"))).get());
        
        assertFalse(Op.on("6,997.89").exec(FnString
                .isBigDecimal(LocaleUtils.toLocale("es"))).get().booleanValue());
        assertTrue(Op.on("6.997,89").exec(FnString
                .isBigDecimal(LocaleUtils.toLocale("es"))).get().booleanValue());
        assertTrue(Op.on("6.9.9.7,89").exec(FnString
                .isBigDecimal(LocaleUtils.toLocale("es"))).get().booleanValue());        
    }
}

