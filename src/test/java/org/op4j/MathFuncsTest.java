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
import org.op4j.functions.MathBigDecimal;
import org.op4j.functions.MathBigInteger;
import org.op4j.functions.MathDouble;
import org.op4j.functions.MathFloat;
import org.op4j.functions.MathInteger;
import org.op4j.functions.MathLong;
import org.op4j.functions.MathShort;
import org.op4j.functions.converters.ToBigDecimal;
import org.op4j.functions.converters.ToBigInteger;
import org.op4j.functions.converters.ToFloat;
import org.op4j.functions.converters.ToInteger;
import org.op4j.functions.converters.ToLong;
import org.op4j.functions.converters.ToShort;
import org.op4j.test.auto.TestOperation;

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

	@Test
	public void testDouble() {
		// MAX
		Double result = Op.on(this.data).exec(MathDouble.max()).get();
		assertEquals(result, this.data.get(1));	
		System.out.println("Max: " + result);
		
		// MIN
		result = Op.on(this.data).exec(MathDouble.min()).get();
		assertEquals(result, this.data.get(4));	
		System.out.println("Min: " + result);
		
		// SUM
		result = Op.on(this.data).exec(MathDouble.sum()).get();
		BigDecimal sum = BigDecimal.valueOf(0);
		for (Double number : this.data) {
			if (number != null) {
				sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
			}
		}	
		assertEquals(result, Double.valueOf(sum.doubleValue()));	
		System.out.println("Sum: " + result);
		
		// AVG
		result = Op.on(this.data).exec(MathDouble.avg()).get();
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
		result = Op.on(this.data).exec(MathDouble.avg(mc)).get();
		assertEquals(result, Double.valueOf(avg.divide(BigDecimal.valueOf(count), mc).doubleValue()));	
		System.out.println("Avg: " + result);
		
		// Raise
		List<Double> theResult = Op.onList(this.data).forEach()
			.exec(MathDouble.raiseTo(5)).get();
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
	}

	@Test
	public void testLong() {
		// Abs
		List<Long> result = Op.onList(this.data).forEach().exec(ToLong.fromDouble(RoundingMode.CEILING))
			.exec(MathLong.abs()).get();
		assertEquals(result, Arrays.asList(Long.valueOf(34), Long.valueOf(45), 
				Long.valueOf(24), Long.valueOf(24), Long.valueOf(11)));	
		System.out.println("Abs: " + result);
		
		// Add
		result = Op.onList(this.data).forEach().exec(ToLong.fromDouble(RoundingMode.CEILING))
			.exec(MathLong.add(Long.valueOf(7))).get();
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
			.exec(MathLong.subtract(Long.valueOf(23))).get();
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
	}
	
	@Test
	public void testInteger() {
		
		// Divide
		List<Integer> result = Op.onList(this.data).forEach().exec(ToInteger.fromDouble(RoundingMode.CEILING))
			.exec(MathInteger.divideBy(Integer.valueOf(3), RoundingMode.CEILING)).get();
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
			.exec(MathInteger.multiplyBy(Integer.valueOf(3))).get();
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
		
	}
	
	@Test
	public void testBigDecimal() {
		
		// Module
		List<BigDecimal> result = Op.onList(this.data).forEach().exec(ToBigDecimal.fromNumber())
			.exec(MathBigDecimal.module(3)).get();
		int index = 0;
		for(BigDecimal aNumber : result) {
			BigDecimal bNumber = null;
			if (this.data.get(index) != null) {
				bNumber = BigDecimal.valueOf(this.data.get(index).doubleValue() % 3);
			}			
			assertEquals(aNumber, bNumber);	
			index++;
		}
		System.out.println("Module: " + result);
		
		// Multiply
		result = Op.onList(this.data).forEach().exec(ToBigDecimal.fromNumber())
			.exec(MathBigDecimal.multiplyBy(BigDecimal.valueOf(7.2))).get();
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
			.exec(MathBigDecimal.raiseTo(3)).get();
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
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimal.divideBy(BigDecimal.valueOf(23.3),
				new MathContext(4, RoundingMode.HALF_UP))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimal.raiseTo(3)}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimal.subtract(BigDecimal.valueOf(5))}));
		testOperations.add(new TestOperation("exec", new Object[] {MathBigDecimal.abs()}));
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
		System.out.println("Result onList: " + result);
		aResult = org.op4j.test.auto.Test.testOnArrayOf(Types.BIG_DECIMAL, bigDecimalList.toArray(new BigDecimal[]{}), 
				testOperations);
		System.out.println("Result onArray: " + ArrayUtils.toString((Object[])aResult));
		aResult = org.op4j.test.auto.Test.testOnSet(new LinkedHashSet<BigDecimal>(bigDecimalList), 
				testOperations);
		System.out.println("Result onSet: " + result);			
	}
	
	@Test
	public void testBigInteger() {
		
		// Module
		List<BigInteger> result = Op.onList(this.data).forEach().exec(ToBigInteger.fromNumber())
			.exec(MathBigInteger.module(BigInteger.valueOf(3))).get();
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
			.exec(MathBigInteger.multiplyBy(BigInteger.valueOf(7))).get();
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
			.exec(MathBigInteger.raiseTo(3)).get();
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
	}
	
	@Test
	public void testFloat() {
		
		// Module
		List<Float> result = Op.onList(this.data).forEach().exec(ToFloat.fromNumber())
			.exec(MathFloat.module(3)).get();
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
			.exec(MathFloat.multiplyBy(Float.valueOf(7))).get();
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
			.exec(MathFloat.raiseTo(3)).get();
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
	}
	
	@Test
	public void testShort() {
		
		// Module
		List<Short> result = Op.onList(this.data).forEach().exec(ToShort.fromNumber())
			.exec(MathShort.module(3)).get();
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
			.exec(MathShort.multiplyBy(Short.valueOf("2127"))).get();
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
			.exec(MathShort.raiseTo(3)).get();
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
	}
	
	@Test
	public void test() {
		
		List<BigInteger> bigIntegerList = Arrays.asList(BigInteger.valueOf(34), null, BigInteger.valueOf(-1256565646), 
				BigInteger.valueOf(389894), BigInteger.valueOf(-676765649), 
				BigInteger.valueOf(34567575), null);
		List<Double> doubleList = Arrays.asList(Double.valueOf(34), null, Double.valueOf(34), Double.valueOf(3.4), Double.valueOf(-34.78), 
				null, Double.valueOf(3434343434.675676465));
		List<Float> floatList = Arrays.asList(Float.valueOf(34), null, Float.valueOf(34), Float.valueOf(34), Float.valueOf(-3478), 
				null, Float.valueOf(343434343));
		List<Integer> integerList = Arrays.asList(34, 76, -12, 0, 67, null);
		List<Long> longList = Arrays.asList(Long.valueOf(34), null, Long.valueOf(34), Long.valueOf(3774), Long.valueOf(-34078), 
				null, Long.valueOf(343434345));
		List<Short> shortList = Arrays.asList(Short.valueOf("34"), null, Short.valueOf("34"), 
				Short.valueOf("304"), Short.valueOf("-3478"), 
				null, Short.valueOf("3434"));
		
		
	}
}
