package org.op4j;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.javaruntype.type.Types;
import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.FnMath;
import org.op4j.functions.FnNumber;
import org.op4j.functions.IFunction;
import org.op4j.test.auto.TestOperation;

@SuppressWarnings (value = "cast")
public class MathFuncsTest extends TestCase {

	private List<Double> data;

	@Override
	@Before
	public void setUp() throws Exception {
		this.data = new ArrayList<Double>();
		this.data.add(Double.valueOf(34));
		this.data.add(Double.valueOf(45));
		this.data.add(Double.valueOf(23.55335));
		this.data.add(Double.valueOf(23.233343));
		this.data.add(Double.valueOf(-11.2));
	}

	@SuppressWarnings({ "boxing", "unchecked" })
	@Test
	public void testDouble() {
		// MAX
		Double result = Op.on(this.data).exec(FnMath.ofDouble().max()).get();
		assertEquals(result, this.data.get(1));	
		System.out.println("Max: " + result);
		
		// MIN
		result = Op.on(this.data).exec(FnMath.ofDouble().min()).get();
		assertEquals(result, this.data.get(4));	
		System.out.println("Min: " + result);
		
		// SUM
		result = Op.on(this.data).exec(FnMath.ofDouble().sum()).get();
		BigDecimal sum = BigDecimal.valueOf(0);
		for (Double number : this.data) {
			if (number != null) {
				sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
			}
		}	
		assertEquals(result, Double.valueOf(sum.doubleValue()));	
		System.out.println("Sum: " + result);
		
		// AVG
		result = Op.on(this.data).exec(FnMath.ofDouble().avg()).get();
		BigDecimal avg = BigDecimal.valueOf(0);
		int count = 0;
		for (Double number : this.data) {
			if (number != null) {
				avg = avg.add(BigDecimal.valueOf(number.doubleValue()));
				count++;
			}
		}	
		assertEquals(
		        BigDecimal.valueOf(result).setScale(4, RoundingMode.FLOOR), 
		        avg.divide(BigDecimal.valueOf(count)).setScale(4, RoundingMode.FLOOR));	
		System.out.println("Avg: " + result);
		
		MathContext mc = new MathContext(2, RoundingMode.CEILING);
		result = Op.on(this.data).exec(FnMath.ofDouble().avg(mc)).get();
		assertEquals(
		        BigDecimal.valueOf(result).setScale(4, RoundingMode.FLOOR), 
		        avg.divide(BigDecimal.valueOf(count), mc).setScale(4, RoundingMode.FLOOR));	
		System.out.println("Avg: " + result);
		
		// Raise
		List<Double> theResult = Op.onList(this.data).forEach()
			.exec(FnMath.ofDouble().pow(5)).get();
		int index = 0;
		for(Double aNumber : theResult) {
			Double bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Double.valueOf(BigDecimal.valueOf(this.data.get(index).doubleValue()).pow(5).doubleValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Raise: " + result);
		
		
		
		List<Double> doubleList = Arrays.asList(Double.valueOf(34), null, Double.valueOf(34), Double.valueOf(3.4), Double.valueOf(-34.78), 
				null, Double.valueOf(3434343434.675676465));
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {Double.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofDouble().divideBy(Double.valueOf(23.3),
				new MathContext(4, RoundingMode.HALF_UP))})); 
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofDouble().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofDouble().subtract(Double.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofDouble().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(doubleList, testOperations);
		index = 0;
		for (Double aNumber : ((Iterable<Double>)aResult)) {
			Double bNumber = null;
			if (doubleList.size() == index) {
				bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(23.3),
						new MathContext(4, RoundingMode.HALF_UP)).doubleValue())						
						.pow(3).doubleValue())						
						.subtract(BigDecimal.valueOf(5)).abs().doubleValue();
			} else {
				if (doubleList.get(index) != null) {
					bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(doubleList.get(index)).divide(BigDecimal.valueOf(23.3),
							new MathContext(4, RoundingMode.HALF_UP))
							.doubleValue())
							.pow(3).doubleValue()).subtract(BigDecimal.valueOf(5)).abs().doubleValue();
				}			
			}
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.DOUBLE, doubleList.toArray(new Double[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<Double>(doubleList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);		
				
	}

	@SuppressWarnings({ "boxing", "unchecked" })
	@Test
	public void testLong() {
		// Abs
		List<Long> result = Op.onList(this.data).forEach().exec(FnNumber.toLong(RoundingMode.CEILING))
			.exec(FnMath.ofLong().abs()).get();
		assertEquals(result, Arrays.asList(Long.valueOf(34), Long.valueOf(45), 
				Long.valueOf(24), Long.valueOf(24), Long.valueOf(11)));	
		System.out.println("Abs: " + result);
		
		// Add
		result = Op.onList(this.data).forEach().exec(FnNumber.toLong(RoundingMode.CEILING))
			.exec(FnMath.ofLong().add(Long.valueOf(7))).get();
		int index = 0;
		for(Long aLong : result) {
			Long bLong = Long.valueOf(7);
			if (this.data.get(index) != null) {
				bLong = Long.valueOf(BigDecimal.valueOf(this.data.get(index).doubleValue())
					.setScale(0, RoundingMode.CEILING).longValue() + 7);
			}
			
			assertEquals(aLong, bLong);	
			index++;
		}
		System.out.println("Add: " + result);
		
		
		
		// SUBTRACT
		result = Op.onList(this.data).forEach().exec(FnNumber.toLong(RoundingMode.CEILING))
			.exec(FnMath.ofLong().subtract(Long.valueOf(23))).get();
		index = 0;
		for (Double number : this.data) {
			if (number != null) {
				assertEquals(result.get(index), Long.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(number.doubleValue())
						.setScale(0, RoundingMode.CEILING).longValue())
						.subtract(BigDecimal.valueOf(23)).longValue()));				
			} else {
				assertEquals(result.get(index), number);
			}
			index++;
		}	
		System.out.println("Subtract: " + result);
		
		
		
		List<Long> longList = Arrays.asList(Long.valueOf(34), null, Long.valueOf(34), Long.valueOf(3774), Long.valueOf(-34078), 
				null, Long.valueOf(343434345));
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {Long.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofLong().divideBy(Long.valueOf(23),
				new MathContext(4, RoundingMode.HALF_UP))})); 
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofLong().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofLong().subtract(Long.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofLong().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(longList, testOperations);
		index = 0;
		for (Long aNumber : ((Iterable<Long>)aResult)) {
			Long bNumber = null;
			if (longList.size() == index) {
				bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(23),
						new MathContext(4, RoundingMode.HALF_UP)).longValue())						
						.pow(3).longValue())						
						.subtract(BigDecimal.valueOf(5)).abs().longValue();
			} else {
				if (longList.get(index) != null) {
					bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(longList.get(index)).divide(BigDecimal.valueOf(23),
							new MathContext(4, RoundingMode.HALF_UP))
							.longValue())
							.pow(3).longValue()).subtract(BigDecimal.valueOf(5)).abs().longValue();
				}			
			}
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.LONG, longList.toArray(new Long[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<Long>(longList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);	
		
		
	}
	
	@SuppressWarnings({ "boxing", "unchecked" })
	@Test
	public void testInteger() {
		
		// Divide
		List<Integer> result = Op.onList(this.data).forEach().exec(FnNumber.toInteger(RoundingMode.CEILING))
			.exec(FnMath.ofInteger().divideBy(Integer.valueOf(3), RoundingMode.CEILING)).get();
		int index = 0;
		for(Integer aInt : result) {
			Integer bInt = null;
			if (this.data.get(index) != null) {
				bInt = Integer.valueOf(BigDecimal.valueOf(this.data.get(index).doubleValue())
					.setScale(0, RoundingMode.CEILING)
					.divide(BigDecimal.valueOf(3), RoundingMode.CEILING).intValue());
			}			
			assertEquals(aInt, bInt);	
			index++;
		}
		System.out.println("Divide: " + result);
		
		// Multiply
		result = Op.onList(this.data).forEach().exec(FnNumber.toInteger(RoundingMode.DOWN))
			.exec(FnMath.ofInteger().multiplyBy(Integer.valueOf(3))).get();
		index = 0;
		for(Integer aNumber : result) {
			Integer bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Integer.valueOf(BigDecimal.valueOf(this.data.get(index).doubleValue())
						.setScale(0, RoundingMode.DOWN).multiply(BigDecimal.valueOf(3))
						.intValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Multiply: " + result);
		
		
		
		List<Integer> integerList = Arrays.asList(34, 76, -12, 0, 67, null);
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {Integer.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofInteger().divideBy(Integer.valueOf(23),
				new MathContext(4, RoundingMode.HALF_UP))})); 
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofInteger().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofInteger().subtract(Integer.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofInteger().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(integerList, testOperations);
		index = 0;
		for (Integer aNumber : ((Iterable<Integer>)aResult)) {
			Integer bNumber = null;
			if (integerList.size() == index) {
				bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(23),
						new MathContext(4, RoundingMode.HALF_UP)).intValue())						
						.pow(3).intValue())						
						.subtract(BigDecimal.valueOf(5)).abs().intValue();
			} else {
				if (integerList.get(index) != null) {
					bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(integerList.get(index)).divide(BigDecimal.valueOf(23),
							new MathContext(4, RoundingMode.HALF_UP))
							.intValue())
							.pow(3).intValue()).subtract(BigDecimal.valueOf(5)).abs().intValue();
				}			
			}
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.INTEGER, integerList.toArray(new Integer[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<Integer>(integerList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);	
		
		
		
		
		Map<String, List<Integer>> mapOfIntegerList = Op.onAll("first", Arrays.asList(34, 76, -12, 0, 67, null),
				"second", Arrays.asList(3, 776, -122, 20, 627)).buildMapByAlternateElements().asMapOf(Types.STRING, Types.LIST_OF_INTEGER).get();

//		Op.onMapOfList(mapOfIntegerList)
//			.put("third", Arrays.asList(3, null, 776))
//			.forEachEntry()
//			.onValue()
//			.add(Integer.valueOf(9999))
//			.exec(new IFunction<List<Integer>, List<Integer>>() {
//				public List<Integer> execute(List<Integer> object, ExecCtx ctx)
//						throws Exception {
//					return Op.on(object).forEach()
//						.exec(FMathInteger.raiseTo(5))
//						.exec(FMathInteger.divideBy(Integer.valueOf(5), new MathContext(3, RoundingMode.FLOOR)))
//						.get();					
//				}
//			}).get();
		
		testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("put", new Object[] {"third", Arrays.asList(3, null, 776)}));		
		testOperations.add(new TestOperation("forEachEntry"));
		testOperations.add(new TestOperation("onValue"));
		testOperations.add(new TestOperation("add", new Object[] {Integer.valueOf(9999)})); 
		testOperations.add(new TestOperation("exec", new Object[] {
				new IFunction<List<Integer>, List<Integer>>() {
					public List<Integer> execute(List<Integer> input, ExecCtx ctx)
						throws Exception {
						return Op.on(input).forEach()
							.exec(FnMath.ofInteger().pow(5))
							.exec(FnMath.ofInteger().divideBy(Integer.valueOf(5), new MathContext(3, RoundingMode.FLOOR)))
							.get();					
					}
				}}));
		testOperations.add(new TestOperation("get"));
//		Map<String, List<Integer>> mapResult = (Map<String, List<Integer>>)org.op4j.test.auto.Test.testOnMapOfList(mapOfIntegerList, testOperations);
//		index = 0;
//		for (Map.Entry<String, List<Integer>> entry : mapResult.entrySet()) {
//			List<Integer> aux = new ArrayList<Integer>();
//			if (mapResult.size() - 1 == index) {
//				assertEquals(entry.getKey(), "third");
//				aux = Arrays.asList(3, null, 776, 9999);
//			} else {
//				aux = new ArrayList<Integer>(mapOfIntegerList.get(entry.getKey()));
//				aux.add(Integer.valueOf(9999));
//			}
//			assertEquals(entry.getValue().size(), aux.size());
//			int innerIndex = 0;
//			for (Integer integer : aux) {
//				if (integer != null) { 
//					assertEquals(entry.getValue().get(innerIndex++), Integer.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(integer)
//						.pow(5).intValue()).divide(BigDecimal.valueOf(5), new MathContext(3, RoundingMode.FLOOR))
//						.intValue()));
//				} else {
//					assertEquals(entry.getValue().get(innerIndex++), integer);
//				}
//			}	
//			index++;
//		}
	}
	
	@Test
	@SuppressWarnings({ "unchecked" })
	public void testBigDecimal() {
		
		// Module
		List<BigDecimal> result = Op.onList(this.data).forEach().exec(FnNumber.toBigDecimal())
			.exec(FnMath.ofBigDecimal().remainder(BigDecimal.valueOf(3))).get();
		int index = 0;
		for(BigDecimal aNumber : result) {
			BigDecimal bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigDecimal.valueOf(this.data.get(index).doubleValue()).remainder(BigDecimal.valueOf(3));
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Module: " + result);
		
		// Multiply
		result = Op.onList(this.data).forEach().exec(FnNumber.toBigDecimal())
			.exec(FnMath.ofBigDecimal().multiplyBy(BigDecimal.valueOf(7.2))).get();
		index = 0;
		for(BigDecimal aNumber : result) {
			BigDecimal bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigDecimal.valueOf(this.data.get(index).doubleValue()).multiply(BigDecimal.valueOf(7.2));
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Multiply: " + result);
		
		// Raise
		result = Op.onList(this.data).forEach().exec(FnNumber.toBigDecimal())
			.exec(FnMath.ofBigDecimal().pow(3)).get();
		index = 0;
		for(BigDecimal aNumber : result) {
			BigDecimal bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigDecimal.valueOf(this.data.get(index).doubleValue()).pow(3);
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Raise: " + result);
		
		
		List<BigDecimal> bigDecimalList = Arrays.asList(BigDecimal.valueOf(34), null, BigDecimal.valueOf(-1256565646.84), 
				BigDecimal.valueOf(3.89894), BigDecimal.valueOf(-67.6765646456460089), 
				BigDecimal.valueOf(34.567575), null);
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {BigDecimal.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigDecimal().divideBy(BigDecimal.valueOf(23.3),
				new MathContext(4, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigDecimal().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigDecimal().subtract(BigDecimal.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigDecimal().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(bigDecimalList, testOperations);
		index = 0;
		for (BigDecimal aNumber : ((Iterable<BigDecimal>)aResult)) {
			BigDecimal bNumber = null;
			if (bigDecimalList.size() == index) {
				bNumber = BigDecimal.valueOf(2).divide(BigDecimal.valueOf(23.3),
						new MathContext(4, RoundingMode.HALF_UP)).pow(3).subtract(BigDecimal.valueOf(5)).abs();
			} else {
				if (bigDecimalList.get(index) != null) {
					bNumber = bigDecimalList.get(index).divide(BigDecimal.valueOf(23.3),
							new MathContext(4, RoundingMode.HALF_UP)).pow(3).subtract(BigDecimal.valueOf(5)).abs();
				}			
			}
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.BIG_DECIMAL, bigDecimalList.toArray(new BigDecimal[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<BigDecimal>(bigDecimalList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);			
	}
	
	@Test
	@SuppressWarnings({ "unchecked" })
	public void testBigInteger() {
		
		// Module
		List<BigInteger> result = Op.onList(this.data).forEach().exec(FnNumber.toBigInteger())
			.exec(FnMath.ofBigInteger().module(BigInteger.valueOf(3))).get();
		int index = 0;
		for(BigInteger aNumber : result) {
			BigInteger bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigDecimal.valueOf(this.data.get(index).doubleValue()).toBigInteger().mod(BigInteger.valueOf(3));
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Module: " + result);

		
		// Multiply
		result = Op.onList(this.data).forEach().exec(FnNumber.toBigInteger())
			.exec(FnMath.ofBigInteger().multiplyBy(BigInteger.valueOf(7))).get();
		index = 0;
		for(BigInteger aNumber : result) {
			BigInteger bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigInteger.valueOf(this.data.get(index).longValue()).multiply(BigInteger.valueOf(7));
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Multiply: " + result);
		
		// Raise
		result = Op.onList(this.data).forEach().exec(FnNumber.toBigInteger())
			.exec(FnMath.ofBigInteger().pow(3)).get();
		index = 0;
		for(BigInteger aNumber : result) {
			BigInteger bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigInteger.valueOf(this.data.get(index).longValue()).pow(3);
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Raise: " + result);
		
		
		List<BigInteger> bigIntegerList = Arrays.asList(BigInteger.valueOf(34), null, BigInteger.valueOf(-1256565646), 
				BigInteger.valueOf(389894), BigInteger.valueOf(-676765649), 
				BigInteger.valueOf(34567575), null);
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {BigInteger.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigInteger().divideBy(BigInteger.valueOf(23))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigInteger().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigInteger().subtract(BigInteger.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofBigInteger().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(bigIntegerList, testOperations);
		index = 0;
		for (BigInteger aNumber : ((Iterable<BigInteger>)aResult)) {
			BigInteger bNumber = null;
			if (bigIntegerList.size() == index) {
				bNumber = BigInteger.valueOf(2).divide(BigInteger.valueOf(23))
				.pow(3).subtract(BigInteger.valueOf(5)).abs();
			} else {
				if (bigIntegerList.get(index) != null) {
					bNumber = bigIntegerList.get(index).divide(BigInteger.valueOf(23))
						.pow(3).subtract(BigInteger.valueOf(5)).abs();
				}			
			}
			System.out.println("Comparing: " + aNumber + "  with  " + bNumber);
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.BIG_INTEGER, bigIntegerList.toArray(new BigInteger[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<BigInteger>(bigIntegerList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);		
	}
	
	@SuppressWarnings({ "unchecked", "boxing" })
	@Test
	public void testFloat() {
		
		// Module
		List<Float> result = Op.onList(this.data).forEach().exec(FnNumber.toFloat())
			.exec(FnMath.ofFloat().module(3)).get();
		int index = 0;
		for(Float aNumber : result) {
			Float bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Float.valueOf(this.data.get(index).floatValue() % 3);
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Module: " + result);
		
		// Multiply
		result = Op.onList(this.data).forEach().exec(FnNumber.toFloat())
			.exec(FnMath.ofFloat().multiplyBy(Float.valueOf(7))).get();
		index = 0;
		for(Float aNumber : result) {
			Float bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Float.valueOf(BigDecimal.valueOf(this.data.get(index).floatValue())
						.multiply(BigDecimal.valueOf(7)).floatValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Multiply: " + result);
		
		// Raise
		result = Op.onList(this.data).forEach().exec(FnNumber.toFloat())
			.exec(FnMath.ofFloat().pow(3)).get();
		index = 0;
		for(Float aNumber : result) {
			Float bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Float.valueOf(BigDecimal.valueOf(this.data.get(index).floatValue()).pow(3).floatValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Raise: " + result);
		
		
		
		List<Float> floatList = Arrays.asList(Float.valueOf(34), null, Float.valueOf(34), Float.valueOf(34), Float.valueOf(-3478), 
				null, Float.valueOf(343434343));
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {Float.valueOf(2)}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofFloat().divideBy(Float.valueOf(23),
				new MathContext(7, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofFloat().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofFloat().subtract(Float.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofFloat().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(floatList, testOperations);
		index = 0;
		for (Float aNumber : ((Iterable<Float>)aResult)) {
			Float bNumber = null;
			if (floatList.size() == index) {
				bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(23),
						new MathContext(7, RoundingMode.HALF_UP))
						.floatValue())
						.pow(3).floatValue()).subtract(BigDecimal.valueOf(5)).abs().floatValue();
			} else {
				if (floatList.get(index) != null) {
					bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(floatList.get(index)).divide(BigDecimal.valueOf(23),
							new MathContext(7, RoundingMode.HALF_UP)).floatValue())
						.pow(3).floatValue()).subtract(BigDecimal.valueOf(5)).abs().floatValue();
				}			
			}
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.FLOAT, floatList.toArray(new Float[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<Float>(floatList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);
	}
	
	@SuppressWarnings({ "boxing", "unchecked" })
	@Test
	public void testShort() {
		
		// Module
		List<Short> result = Op.onList(this.data).forEach().exec(FnNumber.toShort())
			.exec(FnMath.ofShort().module(3)).get();
		int index = 0;
		for(Short aNumber : result) {
			Short bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Short.valueOf(Integer.valueOf(this.data.get(index).shortValue() % 3).shortValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Module: " + result);
		
		// Multiply
		result = Op.onList(this.data).forEach().exec(FnNumber.toShort())
			.exec(FnMath.ofShort().multiplyBy(Short.valueOf("2127"))).get();
		index = 0;
		for(Short aNumber : result) {
			Short bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Short.valueOf(BigDecimal.valueOf(this.data.get(index).shortValue())
						.multiply(BigDecimal.valueOf(2127)).shortValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Multiply: " + result);
		
		// Raise
		result = Op.onList(this.data).forEach().exec(FnNumber.toShort())
			.exec(FnMath.ofShort().pow(3)).get();
		index = 0;
		for(Short aNumber : result) {
			Short bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = Short.valueOf(BigDecimal.valueOf(this.data.get(index).shortValue()).pow(3).shortValue());
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Raise: " + result);
		
		
		
		List<Short> shortList = Arrays.asList(Short.valueOf("34"), null, Short.valueOf("34"), 
				Short.valueOf("304"), Short.valueOf("-3478"), 
				null, Short.valueOf("3434"));
		
		List<TestOperation> testOperations = new ArrayList<TestOperation>();
		testOperations.add(new TestOperation("add", new Object[] {Short.valueOf("2")}));		
		testOperations.add(new TestOperation("forEach"));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofShort().divideBy(Short.valueOf("23"),
				new MathContext(7, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofShort().pow(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofShort().subtract(Short.valueOf("5"))}));
		testOperations.add(new TestOperation("exec", new Object[] {FnMath.ofShort().abs()}));
		testOperations.add(new TestOperation("endFor"));
		testOperations.add(new TestOperation("get"));
		Object aResult = org.op4j.test.auto.Test.testOnList(shortList, testOperations);
		index = 0;
		for (Short aNumber : ((Iterable<Short>)aResult)) {
			Short bNumber = null;
			if (shortList.size() == index) {
				bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(2).divide(BigDecimal.valueOf(23),
						new MathContext(7, RoundingMode.HALF_UP))
						.shortValue())
						.pow(3).shortValue()).subtract(BigDecimal.valueOf(5)).abs().shortValue();
			} else {
				if (shortList.get(index) != null) {
					bNumber = BigDecimal.valueOf(BigDecimal.valueOf(BigDecimal.valueOf(shortList.get(index)).divide(BigDecimal.valueOf(23),
							new MathContext(7, RoundingMode.HALF_UP)).shortValue())
						.pow(3).shortValue()).subtract(BigDecimal.valueOf(5)).abs().shortValue();
				}			
			}
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Result onList: " + aResult);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.SHORT, shortList.toArray(new Short[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<Short>(shortList), 
				testOperations);
		System.out.println("Result onSet: " + aResult);
				
	}
	
}
