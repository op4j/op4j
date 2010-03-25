package org.op4j;


import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.op4j.functions.FnString;

public class RecipesTests extends TestCase {

	
	
	@Test
	public void testOP4J_001() throws Exception {
	    
	    List<String> result = Arrays.asList(new String[] {"hello", "hola", "ola", "olá"});
	    
	    List<String> stringList = 
	        Op.onListFor("hello", "hola", "ola", "olá").get();
	    
	    assertEquals(result, stringList);
	    
	}
	
	
    
    @Test
    public void testOP4J_002() throws Exception {

        final User user1 = new User();
        final User user2 = new User();
        final User user3 = new User();
        
        Set<User> result = new LinkedHashSet<User>(Arrays.asList(new User[] {user1, user2, user3}));
        
        Set<User> users = 
            Op.onSetFor(user1, user2, user3).get();
        
        assertEquals(result, users);
        
    }
	
    
    
    
    @Test
    @SuppressWarnings("boxing")
    public void testOP4J_003() throws Exception {

        Map<String,Integer> result = new LinkedHashMap<String,Integer>();
        result.put("John", Integer.valueOf(27));
        result.put("Mary", Integer.valueOf(49));
        result.put("Derek", Integer.valueOf(19));
        
        
        {
            Map<String,Integer> agesByName =
                Op.onListFor("John", "Mary", "Derek").zipValues(27, 49, 19).get();
            
            assertEquals(result, agesByName);
        }

        
        {
            Map<String,Integer> agesByName =
                Op.onListFor(27, 49, 19).zipKeys("John", "Mary", "Derek").get();        
            
            assertEquals(result, agesByName);
        }
        
    }
    
    
    
    
    @Test
    public void testOP4J_004() throws Exception {

        Map<String,String> result = new LinkedHashMap<String,String>();
        result.put("Spain", "Madrid");
        result.put("United Kingdom", "London");
        result.put("France", "Paris");
        
        
        Map<String,String> capitals =
            Op.onListFor("Spain", "Madrid", "United Kingdom", "London", "France", "Paris").couple().get();
                
        
        assertEquals(result, capitals);
        
    }


    
    
    
    @Test
    public void testOP4J_005() throws Exception {

        Calendar result = Calendar.getInstance();
        result = DateUtils.truncate(result, Calendar.YEAR);
        result.set(Calendar.YEAR, 1978);
        result.set(Calendar.MONTH, 11);
        result.set(Calendar.DAY_OF_MONTH, 6);

        
        String date = "06/12/1978";        
        
        Calendar cal =
            Op.on(date).exec(FnString.toCalendar("dd/MM/yyyy")).get();
        
        assertEquals(result.getTimeInMillis(), cal.getTimeInMillis());
        
    }
    

    
    
    @Test
    public void testOP4J_006() throws Exception {

        Calendar resCal1 = Calendar.getInstance();
        resCal1 = DateUtils.truncate(resCal1, Calendar.YEAR);
        resCal1.set(Calendar.YEAR, 1492);
        resCal1.set(Calendar.MONTH, 9);
        resCal1.set(Calendar.DAY_OF_MONTH, 12);

        Calendar resCal2 = Calendar.getInstance();
        resCal2 = DateUtils.truncate(resCal2, Calendar.YEAR);
        resCal2.set(Calendar.YEAR, 1978);
        resCal2.set(Calendar.MONTH, 11);
        resCal2.set(Calendar.DAY_OF_MONTH, 6);

        List<Calendar> result = Arrays.asList(new Calendar[] { resCal1, resCal2 });
        
        
        List<String> dates = 
            Arrays.asList(new String[] { "12 de octubre, 1492", "06 de diciembre, 1978" });

        {
            List<Calendar> cals =
                Op.on(dates).map(FnString.toCalendar("dd 'de' MMMM, yyyy", "es")).get();
            
            for (int i = 0; i < cals.size(); i++) {
                assertEquals(result.get(i).getTimeInMillis(), cals.get(i).getTimeInMillis());
            }
        }

        {
            List<Calendar> cals =
                Op.on(dates).forEach().exec(FnString.toCalendar("dd 'de' MMMM, yyyy", "es")).get();
            
            for (int i = 0; i < cals.size(); i++) {
                assertEquals(result.get(i).getTimeInMillis(), cals.get(i).getTimeInMillis());
            }
        }
        
    }
    
    
    
    @Test
    @SuppressWarnings("boxing")
    public void testOP4J_007() throws Exception {

        final Integer[] result = new Integer[] {12, 43, 92, 34 };
        

        final Integer[] values = new Integer[] {null, 12, 43, 92, null, 34 };
        
        Integer[] filteredValues =
            Op.on(values).removeAllNull().get();
            
        assertEquals(Arrays.asList(result), Arrays.asList(filteredValues));
        

    }
    
    
    
    
    @Test
    public void testOP4J_008() throws Exception {

        final Double result = Double.valueOf(34.59);

        final String strValue = "34,59";
        
        Double value =
            Op.on(strValue).exec(FnString.toDouble("fr")).get();
            
        assertEquals(result, value);
        

    }
    

    
    
    
    
    /*
     * 
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++
     *   AUXILIARY CLASSES
     * ++++++++++++++++++++++++++++++++++++++++++++++++++++
     * 
     */
    
    protected static class User {
        
        // empty
        
    }
    
}

