package org.op4j;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.ArrayUtils;
import org.javaruntype.type.Types;
import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.converters.ToBigDecimal;
import org.op4j.functions.converters.ToBigInteger;
import org.op4j.functions.converters.ToFloat;
import org.op4j.functions.converters.ToInteger;
import org.op4j.functions.converters.ToLong;
import org.op4j.functions.converters.ToShort;
import org.op4j.functions.math.MathBigDecimalFuncs;
import org.op4j.functions.math.MathBigIntegerFuncs;
import org.op4j.functions.math.MathDoubleFuncs;
import org.op4j.functions.math.MathFloatFuncs;
import org.op4j.functions.math.MathIntegerFuncs;
import org.op4j.functions.math.MathLongFuncs;
import org.op4j.functions.math.MathShortFuncs;
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
		Double result = Op.on(this.data).exec(MathDoubleFuncs.max()).get();
		assertEquals(result, this.data.get(1));	
		System.out.println("Max: " + result);
		
		// MIN
		result = Op.on(this.data).exec(MathDoubleFuncs.min()).get();
		assertEquals(result, this.data.get(4));	
		System.out.println("Min: " + result);
		
		// SUM
		result = Op.on(this.data).exec(MathDoubleFuncs.sum()).get();
		BigDecimal sum = BigDecimal.valueOf(0);
		for (Double number : this.data) {
			if (number != null) {
				sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
			}
		}	
		assertEquals(result, Double.valueOf(sum.doubleValue()));	
		System.out.println("Sum: " + result);
		
		// AVG
		result = Op.on(this.data).exec(MathDoubleFuncs.avg()).get();
		BigDecimal avg = BigDecimal.valueOf(0);
		int count = 0;
		for (Double number : this.data) {
			if (number != null) {
				avg = avg.add(BigDecimal.valueOf(number.doubleValue()));
				count++;
			}
		}	
		assertEquals(result, Double.valueOf(avg.divide(BigDecimal.valueOf(count)).doubleValue()));	
		System.out.println("Avg: " + result);
		
		MathContext mc = new MathContext(2, RoundingMode.CEILING);
		result = Op.on(this.data).exec(MathDoubleFuncs.avg(mc)).get();
		assertEquals(result, Double.valueOf(avg.divide(BigDecimal.valueOf(count), mc).doubleValue()));	
		System.out.println("Avg: " + result);
		
		// Raise
		List<Double> theResult = Op.onList(this.data).forEach()
			.exec(MathDoubleFuncs.raiseTo(5)).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathDoubleFuncs.divideBy(Double.valueOf(23.3),
				new MathContext(4, RoundingMode.HALF_UP))})); 
		testOperations.add(new TestOperation("exec", new Object[] {MathDoubleFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathDoubleFuncs.subtract(Double.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathDoubleFuncs.abs()}));
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
		List<Long> result = Op.onList(this.data).forEach().exec(ToLong.fromDouble(RoundingMode.CEILING))
			.exec(MathLongFuncs.abs()).get();
		assertEquals(result, Arrays.asList(Long.valueOf(34), Long.valueOf(45), 
				Long.valueOf(24), Long.valueOf(24), Long.valueOf(11)));	
		System.out.println("Abs: " + result);
		
		// Add
		result = Op.onList(this.data).forEach().exec(ToLong.fromDouble(RoundingMode.CEILING))
			.exec(MathLongFuncs.add(Long.valueOf(7))).get();
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
		result = Op.onList(this.data).forEach().exec(ToLong.fromDouble(RoundingMode.CEILING))
			.exec(MathLongFuncs.subtract(Long.valueOf(23))).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathLongFuncs.divideBy(Long.valueOf(23),
				new MathContext(4, RoundingMode.HALF_UP))})); 
		testOperations.add(new TestOperation("exec", new Object[] {MathLongFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathLongFuncs.subtract(Long.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathLongFuncs.abs()}));
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
		List<Integer> result = Op.onList(this.data).forEach().exec(ToInteger.fromDouble(RoundingMode.CEILING))
			.exec(MathIntegerFuncs.divideBy(Integer.valueOf(3), RoundingMode.CEILING)).get();
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
		result = Op.onList(this.data).forEach().exec(ToInteger.fromDouble(RoundingMode.DOWN))
			.exec(MathIntegerFuncs.multiplyBy(Integer.valueOf(3))).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathIntegerFuncs.divideBy(Integer.valueOf(23),
				new MathContext(4, RoundingMode.HALF_UP))})); 
		testOperations.add(new TestOperation("exec", new Object[] {MathIntegerFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathIntegerFuncs.subtract(Integer.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathIntegerFuncs.abs()}));
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
		
	}
	
	@Test
	@SuppressWarnings({ "unchecked" })
	public void testBigDecimal() {
		
		// Module
		List<BigDecimal> result = Op.onList(this.data).forEach().exec(ToBigDecimal.fromNumber())
			.exec(MathBigDecimalFuncs.remainder(BigDecimal.valueOf(3))).get();
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
		result = Op.onList(this.data).forEach().exec(ToBigDecimal.fromNumber())
			.exec(MathBigDecimalFuncs.multiplyBy(BigDecimal.valueOf(7.2))).get();
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
		result = Op.onList(this.data).forEach().exec(ToBigDecimal.fromNumber())
			.exec(MathBigDecimalFuncs.raiseTo(3)).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimalFuncs.divideBy(BigDecimal.valueOf(23.3),
				new MathContext(4, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimalFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimalFuncs.subtract(BigDecimal.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimalFuncs.abs()}));
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
		List<BigInteger> result = Op.onList(this.data).forEach().exec(ToBigInteger.fromNumber())
			.exec(MathBigIntegerFuncs.module(BigInteger.valueOf(3))).get();
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
		result = Op.onList(this.data).forEach().exec(ToBigInteger.fromNumber())
			.exec(MathBigIntegerFuncs.multiplyBy(BigInteger.valueOf(7))).get();
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
		result = Op.onList(this.data).forEach().exec(ToBigInteger.fromNumber())
			.exec(MathBigIntegerFuncs.raiseTo(3)).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathBigIntegerFuncs.divideBy(BigInteger.valueOf(23))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigIntegerFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigIntegerFuncs.subtract(BigInteger.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigIntegerFuncs.abs()}));
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
		List<Float> result = Op.onList(this.data).forEach().exec(ToFloat.fromNumber())
			.exec(MathFloatFuncs.module(3)).get();
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
		result = Op.onList(this.data).forEach().exec(ToFloat.fromNumber())
			.exec(MathFloatFuncs.multiplyBy(Float.valueOf(7))).get();
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
		result = Op.onList(this.data).forEach().exec(ToFloat.fromNumber())
			.exec(MathFloatFuncs.raiseTo(3)).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathFloatFuncs.divideBy(Float.valueOf(23),
				new MathContext(7, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathFloatFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathFloatFuncs.subtract(Float.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathFloatFuncs.abs()}));
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
		List<Short> result = Op.onList(this.data).forEach().exec(ToShort.fromNumber())
			.exec(MathShortFuncs.module(3)).get();
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
		result = Op.onList(this.data).forEach().exec(ToShort.fromNumber())
			.exec(MathShortFuncs.multiplyBy(Short.valueOf("2127"))).get();
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
		result = Op.onList(this.data).forEach().exec(ToShort.fromNumber())
			.exec(MathShortFuncs.raiseTo(3)).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathShortFuncs.divideBy(Short.valueOf("23"),
				new MathContext(7, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathShortFuncs.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathShortFuncs.subtract(Short.valueOf("5"))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathShortFuncs.abs()}));
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
