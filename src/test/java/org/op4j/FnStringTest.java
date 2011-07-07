package org.op4j;


import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.FnString;

@SuppressWarnings (value = "cast")
public class FnStringTest extends TestCase {
	
	@Override
	@Before
	public void setUp() throws Exception {
		
	}

	@SuppressWarnings({ "boxing" })
	@Test
	public void testDouble() {
		List<Double> resultD = Op.on(new String[] { "-180.0" }).toList().map(FnString.toDouble()).get();
		assertTrue(resultD.containsAll(Op.onListFor(Double.valueOf(-180)).get()));
		assertTrue(Op.onListFor(Double.valueOf(-180)).get().containsAll(resultD));
		
		resultD = Op.onListFor("-10.2").forEach().exec(FnString.toDouble()).get();
		assertTrue(resultD.containsAll(Op.onListFor(Double.valueOf(-10.2)).get()));
		assertTrue(Op.onListFor(Double.valueOf(-10.2)).get().containsAll(resultD));
				
	}
	
	@SuppressWarnings({ "boxing" })
	@Test
	public void testFloat() {
		
		List<Float> resultF = Op.on(new String[] { "-180" }).toList().map(FnString.toFloat()).get();
		assertTrue(resultF.containsAll(Op.onListFor(Float.valueOf(-180)).get()));
		assertTrue(Op.onListFor(Float.valueOf(-180)).get().containsAll(resultF));
		
		
		resultF = Op.onListFor("-10").forEach().exec(FnString.toFloat()).get();
		assertTrue(resultF.containsAll(Op.onListFor(Float.valueOf(-10)).get()));
		assertTrue(Op.onListFor(Float.valueOf(-10)).get().containsAll(resultF));
		
		
		resultF = Op.onListFor("-10.45").forEach().exec(FnString.toFloat()).get();
		assertTrue(resultF.containsAll(Op.onListFor(Float.valueOf("-10.45")).get()));
		assertTrue(Op.onListFor(Float.valueOf("-10.45")).get().containsAll(resultF));
				
	}
}
