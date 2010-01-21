package org.op4j;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.lang.StringUtils;
import org.javaruntype.type.Type;
import org.javaruntype.type.Types;
import org.junit.Before;
import org.junit.Test;
import org.op4j.functions.ExecCtx;
import org.op4j.functions.converters.ToCalendar;
import org.op4j.functions.evaluators.IEvaluator;
import org.op4j.functions.evaluators.Ognl;

public class Tester extends TestCase {

	private TestUtils testUtils;
	
	@Override
	@Before
	public void setUp() throws Exception {
		this.testUtils = new TestUtils();
	}

	@Test
	public void test1() {
		List<String> data = this.testUtils.getStringList(8);
		List<String> result = Op.onList(data)
			.forEach().eval(new IEvaluator<String, String>() {
				public String execute(String object, ExecCtx ctx)
						throws Exception {
					return ctx.getCurrentIndex() + " - " + object;
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
			.addAll(data2).removeAllNullOrFalse(new IEvaluator<Boolean, String>() {

				public Boolean execute(String object, ExecCtx ctx)
						throws Exception {
					return Boolean.valueOf(StringUtils.contains("a", object));
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
	public void test3() {
		List<BigDecimal>[] data = this.testUtils.getBigDecimalListArray(10);
		
		List<BigDecimal>[] result = Op.onArrayOfList(data)
			.forEach().forEach().eval(Ognl.forBigDecimal("add(#param[0])", BigDecimal.valueOf(56)))
			.get();
						
		assertEquals(data.length, result.length);
		for (int indexA = 0; indexA < data.length; indexA++) {
			List<BigDecimal> aData = data[indexA];
			List<BigDecimal> aResult = result[indexA];
			for (int indexB = 0; indexB < aData.size(); indexB++) {
				assertEquals(aData.get(indexB).add(BigDecimal.valueOf(56)), 
						aResult.get(indexB));
			}
		}
	}
	
	@Test
	public void test4() {
		List<Calendar> data = this.testUtils.getCalendarList(13);
		
		List<Long> result = Op.onList(data)
			.forEach().eval(Ognl.forLong("getTimeInMillis()")).get();
						
		assertEquals(data.size(), result.size());
		for (int index = 0; index < data.size(); index++) {
			assertEquals(data.get(index).getTimeInMillis(), 
					result.get(index).longValue());
		}
	}
	
	@Test
	public void test5() {
		Date[][] data = this.testUtils.getDateArrayOfArray(6, 3);
		
		List<Calendar> result = Op.onArrayOfArray(data)
			.forEach(Types.ARRAY_OF_DATE).forEach(Types.DATE).convert(ToCalendar.fromDate())
			.endFor().endFor().flatten(Types.CALENDAR).toList().get();
		
		int index = 0;
		for (int outer = 0; outer < data.length; outer++) {
			Date[] innerDate = data[outer];
			
			for (int inner = 0; inner < innerDate.length; inner++) {
				Calendar aCalendar = Calendar.getInstance();
				aCalendar.setTime(innerDate[inner]);
				assertEquals(aCalendar, 
						result.get(index++));				
			}
		}
	}
}
