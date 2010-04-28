/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */

package org.op4j;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.commons.lang.time.StopWatch;
import org.javaruntype.type.Types;
import org.junit.Test;
import org.op4j.functions.FnNumber;
import org.op4j.functions.FnString;
import org.op4j.operators.impl.op.array.Level0ArrayOperator;
import org.op4j.operators.impl.op.list.Level0ListOperator;
import org.op4j.operators.impl.op.list.Level1ListElementsOperator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class BenchmarkTest {

	private static int STRUCTURE_SIZE = 1000;
	private static int ITERATIONS = 1000;
	
	
	@Test
	public void test() {
		
		try {
			
			final List<String> strings = new ArrayList<String>();
			for (int i = 0; i < STRUCTURE_SIZE; i++) {
			    strings.add(RandomStringUtils.random(20));
			}
			
			final StopWatch stopWatch1 = new StopWatch();
			final StopWatch stopWatch2 = new StopWatch();
			
			int seed = RandomUtils.nextInt(2);
			boolean op4jFirst = 
				Op.on(seed).exec(FnNumber.toBoolean()).get().booleanValue();
			
			if (op4jFirst) {
				
				stopWatch1.start();
				
                String[] upper1 = null; 
				for (int i = 0; i < ITERATIONS; i++) {
					upper1 = 
						Op.onList(strings).forEach().exec(FnString.toUpperCase()).endFor().toArrayOf(Types.STRING).get();
				}
				
				stopWatch1.stop();
				
				stopWatch2.start();
				
                String[] upper2 = null; 
				for (int i = 0; i < ITERATIONS; i++) {
					List<String> upper2List = new ArrayList<String>();
					for (final String string : strings) {
						upper2List.add(string.toUpperCase());
					}
					upper2 = 
						upper2List.toArray(new String[upper2List.size()]);
				}
				
				stopWatch2.stop();

				System.out.println("With op4j:    " + stopWatch1.toString());

				System.out.println("Without op4j: " + stopWatch2.toString());
				
			} else {
				
				stopWatch1.start();
				
                String[] upper1 = null; 
				for (int i = 0; i < ITERATIONS; i++) {
					List<String> upper1List = new ArrayList<String>();
					for (final String string : strings) {
						upper1List.add(string.toUpperCase());
					}
					upper1 = 
						upper1List.toArray(new String[upper1List.size()]);
				}
				
				stopWatch1.stop();
				
				
				stopWatch2.start();
				
                String[] upper2 = null; 
				for (int i = 0; i < ITERATIONS; i++) {
				    upper2 = 
						Op.onList(strings).forEach().exec(FnString.toUpperCase()).endFor().toArrayOf(Types.STRING).get();
				}
				
				stopWatch2.stop();


				System.out.println("Without op4j: " + stopWatch1.toString());

				System.out.println("With op4j:    " + stopWatch2.toString());
				
			}
			
			
			StopWatch op4jWatch = new StopWatch();
			
			Level0ListOperator<List<String>,String> op1 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op1 = Op.onList(strings);
			}
			op4jWatch.stop();
			
			String time1 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level1ListElementsOperator<List<String>,String> op2 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op2 = op1.forEach();
			}
			op4jWatch.stop();
			
			String time2 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level1ListElementsOperator<List<String>,String> op3 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op3 = op2.exec(FnString.toUpperCase());
			}
			op4jWatch.stop();
			
			String time3 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level0ListOperator<List<String>,String> op4 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op4 = op3.endFor();
			}
			op4jWatch.stop();
			
			String time4 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level0ArrayOperator<List<String>,String> op5 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op5 = op4.toArrayOf(Types.STRING);
			}
			op4jWatch.stop();
			
			String time5 = op4jWatch.toString();
			op4jWatch.reset();
            
            String[] op6 = null;
            op4jWatch.start();
            for (int i = 0; i < ITERATIONS; i++) {
                op6 = op5.get();
            }
            op4jWatch.stop();
            
            String time6 = op4jWatch.toString();
            op4jWatch.reset();

			
			System.out.println("Time 01: " + time1);
			System.out.println("Time 02: " + time2);
			System.out.println("Time 03: " + time3);
			System.out.println("Time 04: " + time4);
			System.out.println("Time 05: " + time5);
			System.out.println("Time 06: " + time6);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    public static void main(String[] args) {
        (new BenchmarkTest()).test();
    }
	
}
