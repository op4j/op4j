package org.op4j;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.MathFuncs;

public class MathFuncsTest extends TestCase {

	private List<Double> data;

	@Override
	@Before
	public void setUp() throws Exception {
		this.data = new ArrayList<Double>();
		this.data.add(Double.valueOf(34));
		this.data.add(Double.valueOf(45));
		this.data.add(Double.valueOf(23.45335));
		this.data.add(Double.valueOf(23.233343));
	}

	@Test
	public void test1() {
		// MAX
		Double result = Op.on(this.data).exec(MathFuncs.maxDouble()).get();
		assertEquals(result, this.data.get(1));	
		System.out.println("Max: " + result);
		
		// MIN
		result = Op.on(this.data).exec(MathFuncs.minDouble()).get();
		assertEquals(result, this.data.get(3));	
		System.out.println("Min: " + result);
		
		// SUM
		result = Op.on(this.data).exec(MathFuncs.sumDouble()).get();
		BigDecimal sum = BigDecimal.valueOf(0);
		for (Double number : this.data) {
			if (number != null) {
				sum = sum.add(BigDecimal.valueOf(number.doubleValue()));
			}
		}	
		assertEquals(result, Double.valueOf(sum.doubleValue()));	
		System.out.println("Sum: " + result);
	}

	
}
