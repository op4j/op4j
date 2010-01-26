/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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
import org.op4j.functions.StringFuncs;
import org.op4j.functions.converters.ToBoolean;
import org.op4j.functions.evaluators.MethodCall;
import org.op4j.operators.intf.array.Level0ArrayOperator;
import org.op4j.operators.intf.list.Level0ListOperator;
import org.op4j.operators.intf.list.Level1ListElementsOperator;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class BenchmarkTest {

	private static int STRUCTURE_SIZE = 10000;
	private static int ITERATIONS = 10;
	
	
	public static void main(String[] args) {
		
		try {
			
			final List<User> users = new ArrayList<User>();
			for (int i = 0; i < STRUCTURE_SIZE; i++) {
				users.add(new User());
			}
			
			final StopWatch stopWatch1 = new StopWatch();
			final StopWatch stopWatch2 = new StopWatch();
			
			boolean op4jFirst = 
				Op.on(RandomUtils.nextInt(2)).convert(ToBoolean.fromNumber()).get().booleanValue();
			
			if (op4jFirst) {
				
				stopWatch1.start();
				
				for (int i = 0; i < ITERATIONS; i++) {
					String[] upperNames1 = 
						Op.onList(users).forEach().eval(MethodCall.forString("getName")).exec(StringFuncs.toUpperCase()).endFor().toArrayOf(Types.STRING).get();
				}
				
				stopWatch1.stop();

				
				stopWatch2.start();
				
				for (int i = 0; i < ITERATIONS; i++) {
					List<String> upperNames2List = new ArrayList<String>();
					for (final User user : users) {
						upperNames2List.add(user.getName().toUpperCase());
					}
					String[] upperNames2 = 
						upperNames2List.toArray(new String[upperNames2List.size()]);
				}
				
				stopWatch2.stop();

				System.out.println("With op4j: " + stopWatch1.toString());

				System.out.println("Without op4j: " + stopWatch2.toString());
				
			} else {
				
				stopWatch1.start();
				
				for (int i = 0; i < ITERATIONS; i++) {
					List<String> upperNames1List = new ArrayList<String>();
					for (final User user : users) {
						upperNames1List.add(user.getName().toUpperCase());
					}
					String[] upperNames1 = 
						upperNames1List.toArray(new String[upperNames1List.size()]);
				}
				
				stopWatch1.stop();
				
				
				stopWatch2.start();
				
				for (int i = 0; i < ITERATIONS; i++) {
					String[] upperNames2 = 
						Op.onList(users).forEach().eval(MethodCall.forString("getName")).exec(StringFuncs.toUpperCase()).endFor().toArrayOf(Types.STRING).get();
				}
				
				stopWatch2.stop();


				System.out.println("Without op4j: " + stopWatch1.toString());

				System.out.println("With op4j: " + stopWatch2.toString());
				
			}
			
			
			StopWatch op4jWatch = new StopWatch();
			
			Level0ListOperator<User> op1 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op1 = Op.onList(users);
			}
			op4jWatch.stop();
			
			String time1 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level1ListElementsOperator<User> op2 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op2 = op1.forEach();
			}
			op4jWatch.stop();
			
			String time2 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level1ListElementsOperator<String> op3 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op3 = op2.eval(MethodCall.forString("getName"));
			}
			op4jWatch.stop();
			
			String time3 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level1ListElementsOperator<String> op4 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op4 = op3.exec(StringFuncs.toUpperCase());
			}
			op4jWatch.stop();
			
			String time4 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level0ListOperator<String> op5 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op5 = op4.endFor();
			}
			op4jWatch.stop();
			
			String time5 = op4jWatch.toString();
			op4jWatch.reset();
			
			Level0ArrayOperator<String> op6 = null;
			op4jWatch.start();
			for (int i = 0; i < ITERATIONS; i++) {
				op6 = op5.toArrayOf(Types.STRING);
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
	
	
	public static class User {
		
		private final String name;
		
		public User() {
			super();
			this.name = RandomStringUtils.randomAlphanumeric(25);
		}

		public String getName() {
			return this.name;
		}
		
	}
	
	
}
