package org.op4j;


import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.MathDouble;
import org.op4j.functions.MathInteger;
import org.op4j.functions.MathLong;
import org.op4j.functions.converters.ToInteger;
import org.op4j.functions.converters.ToLong;

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
		
		
		
	}
}
