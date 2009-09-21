package org.op4j.typescheme;

import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;

import junit.framework.TestCase;

public class TypeSchemesTest extends TestCase {
    
    public void testA() throws Exception {
        
    }

    
    public void atestNullAssignability() throws Exception {

        TypeScheme ts2 = TypeSchemes.forName("(String)");
        TypeScheme ts5 = TypeSchemes.forName("(Number)");
        TypeScheme ts6 = TypeSchemes.forName("(Integer)");
        TypeScheme ts7 = TypeSchemes.forName("(Number,String)");
        TypeScheme ts8 = TypeSchemes.forName("(Integer,String)");
        
        assertTrue(ts2.isAssignableFrom(ts2));
        assertTrue(!ts2.isAssignableFrom(ts5));
        assertTrue(!ts2.isAssignableFrom(ts6));
        assertTrue(!ts2.isAssignableFrom(ts7));
        assertTrue(!ts2.isAssignableFrom(ts8));
        
        assertTrue(!ts5.isAssignableFrom(ts2));
        assertTrue(ts5.isAssignableFrom(ts5));
        assertTrue(ts5.isAssignableFrom(ts6));
        assertTrue(!ts5.isAssignableFrom(ts7));
        assertTrue(!ts5.isAssignableFrom(ts8));
        
        assertTrue(!ts6.isAssignableFrom(ts2));
        assertTrue(!ts6.isAssignableFrom(ts5));
        assertTrue(ts6.isAssignableFrom(ts6));
        assertTrue(!ts6.isAssignableFrom(ts7));
        assertTrue(!ts6.isAssignableFrom(ts8));
        
        assertTrue(!ts7.isAssignableFrom(ts2));
        assertTrue(!ts7.isAssignableFrom(ts5));
        assertTrue(!ts7.isAssignableFrom(ts6));
        assertTrue(ts7.isAssignableFrom(ts7));
        assertTrue(ts7.isAssignableFrom(ts8));
        
        assertTrue(!ts8.isAssignableFrom(ts2));
        assertTrue(!ts8.isAssignableFrom(ts5));
        assertTrue(!ts8.isAssignableFrom(ts6));
        assertTrue(!ts8.isAssignableFrom(ts7));
        assertTrue(ts8.isAssignableFrom(ts8));
        
        TypeScheme strIntTs1 = TypeSchemes.forName("(String,Integer,Map<Calendar[],Object>)");
        TypeScheme strIntTs2 = TypeSchemes.forName("(String,Integer,HashMap<Calendar[],Object>)");
        assertTrue(strIntTs1.isAssignableFrom(strIntTs2));
        assertTrue(!strIntTs2.isAssignableFrom(strIntTs1));
        
        
    }
    
}
