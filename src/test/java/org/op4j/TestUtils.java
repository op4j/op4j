package org.op4j;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Ignore;

@SuppressWarnings("unchecked")
@Ignore
class TestUtils {

	
	public List<String> getStringList(int size) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < size; i++) {
			result.add(RandomStringUtils.randomAlphanumeric(5));
		}		
		return result;
	}
    
    public List<List<String>> getStringListOfList(int sizeLevel0, int sizeLevel1) {
        List<List<String>> result = new ArrayList<List<String>>();
        for (int i = 0; i < sizeLevel0; i++) {
            List<String> level1Result = new ArrayList<String>();
            for (int j = 0; j < sizeLevel1; j++) {
                level1Result.add(RandomStringUtils.randomAlphanumeric(5));
            }            
            result.add(level1Result);
        }       
        return result;
    }
	
	public List<Calendar> getCalendarList(int size) {
		List<Calendar> result = new ArrayList<Calendar>();
		for (int i = 0; i < size; i++) {
			result.add(Calendar.getInstance());
		}		
		return result;
	}
	
	public Integer[] getIntegerArray(int size) {
		Integer[] result = new Integer[size];
		for (int i = 0; i < size; i++) {
			result[i] = Integer.valueOf(RandomUtils.nextInt());
		}
		return result;
	}
	
	public Map<Integer, String> getMapOfIntegerString(int size) {
		Map<Integer, String> result =
			new LinkedHashMap<Integer, String>();
		while (result.size() < size) {
			result.put(Integer.valueOf(RandomUtils.nextInt()), RandomStringUtils.randomAlphanumeric(5));
		}
		return result;
	}
	
	public Map<Integer, List<String>> getMapOfIntegerStringList(int size) {
		Map<Integer, List<String>> result =
			new LinkedHashMap<Integer, List<String>>();
		while (result.size() < size) {
			List<String> values = new ArrayList<String>();
			for(int index = 0; index < 5; index++) {
				values.add(RandomStringUtils.randomAlphanumeric(5));
			}
			result.put(Integer.valueOf(RandomUtils.nextInt()), values);
		}
		return result;
	}
	
	public Date[][] getDateArrayOfArray(int sizeA, int sizeB) {
		Date[][] result = new Date[sizeA][sizeB];
		for(int a = 0; a < sizeA; a++) {
			for(int b = 0; b < sizeB; b++) {
				result[a][b] = new Date();
			}	
		}
		return result;
	}
	
	public List<BigDecimal>[] getBigDecimalListArray(int size) {
		List<BigDecimal>[] result = new ArrayList[size];
		for(int a = 0; a < size; a++) {
			List<BigDecimal> values = new ArrayList<BigDecimal>();
			for(int b = 0; b < 8; b++) {
				values.add(new BigDecimal(RandomUtils.nextDouble()));
			}	
			result[a] = values;
		}
		return result;
	}
	
	public Map<Integer, Calendar[]> getMapOfIntegerCalendarArray(int size) {
		Map<Integer, Calendar[]> result =
			new LinkedHashMap<Integer, Calendar[]>();
		while (result.size() < size) {
			Calendar[] values = new Calendar[5];
			for(int index = 0; index < 5; index++) {
				values[index] = Calendar.getInstance();
			}
			result.put(Integer.valueOf(RandomUtils.nextInt()), values);
		}
		return result;
	}
	
	public Map<Integer, Map<Integer, String[]>> getMapOfIntegerMapOfIntegerStringArray(int size) {
		Map<Integer, Map<Integer, String[]>> result =
			new LinkedHashMap<Integer, Map<Integer, String[]>>();
		while (result.size() < size) {
			Map<Integer, String[]> values = new LinkedHashMap<Integer, String[]>();
			for(int index = 0; index < 5; index++) {
				values.put(Integer.valueOf(RandomUtils.nextInt()), new String[] {
					RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(5),
					RandomStringUtils.randomAlphanumeric(5), RandomStringUtils.randomAlphanumeric(5)
				});
			}
			result.put(Integer.valueOf(RandomUtils.nextInt()), values);
		}
		return result;
	}
	
	
	TestUtils() {
	    super();
	}
	
}
