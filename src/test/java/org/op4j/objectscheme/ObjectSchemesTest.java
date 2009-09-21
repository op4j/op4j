package org.op4j.objectscheme;

import java.util.HashMap;

import junit.framework.TestCase;

import org.op4j.objectscheme.ObjectScheme;
import org.op4j.objectscheme.ObjectSchemes;
import org.op4j.typescheme.TypeScheme;
import org.op4j.typescheme.TypeSchemes;

public class ObjectSchemesTest extends TestCase {
    
    public void testA() throws Exception {
        
    }

    
    public void atestNullAssignability() throws Exception {

        ObjectScheme os1 = 
            ObjectSchemes.forParameters(new Object[] { null });
        ObjectScheme os3 = 
            ObjectSchemes.forParameters(new Object[] { Integer.valueOf(23)});
        ObjectScheme os4 = 
            ObjectSchemes.forParameters(new Object[] { null, null });
        ObjectScheme os6 = 
            ObjectSchemes.forParameters(new Object[] { Integer.valueOf(23), Float.valueOf(23.3f)});
        ObjectScheme os7 = 
            ObjectSchemes.forParameters(new Object[] { Integer.valueOf(23), Float.valueOf(23.3f), new HashMap<String,String>()});
        
        TypeScheme ts1 = TypeSchemes.forName("(String)");
        TypeScheme ts2 = TypeSchemes.forName("(Number)");
        TypeScheme ts3 = TypeSchemes.forName("(Integer)");
        TypeScheme ts4 = TypeSchemes.forName("(String,String)");
        TypeScheme ts5 = TypeSchemes.forName("(Number,String)");
        TypeScheme ts6 = TypeSchemes.forName("(Integer,String)");
        TypeScheme ts7 = TypeSchemes.forName("(Number,Number)");
        TypeScheme ts8 = TypeSchemes.forName("(Number,Float)");
        TypeScheme ts9 = TypeSchemes.forName("(Number,Float,Map<?,?>)");
        TypeScheme ts10 = TypeSchemes.forName("(Number,Float,Map<Object,Object>)");
        TypeScheme ts11 = TypeSchemes.forName("(Number,Float,Map<? extends Object,? extends Object>)");
        TypeScheme ts12 = TypeSchemes.forName("(Number,Float,Map<String,String>)");
        
        assertTrue(ts1.isAssignableFrom(os1));
        assertTrue(!ts1.isAssignableFrom(os3));
        assertTrue(!ts1.isAssignableFrom(os4));
        assertTrue(!ts1.isAssignableFrom(os6));
        
        assertTrue(ts2.isAssignableFrom(os1));
        assertTrue(ts2.isAssignableFrom(os3));
        assertTrue(!ts2.isAssignableFrom(os4));
        assertTrue(!ts2.isAssignableFrom(os6));
        
        assertTrue(ts3.isAssignableFrom(os1));
        assertTrue(ts3.isAssignableFrom(os3));
        assertTrue(!ts3.isAssignableFrom(os4));
        assertTrue(!ts3.isAssignableFrom(os6));
        
        assertTrue(!ts4.isAssignableFrom(os1));
        assertTrue(!ts4.isAssignableFrom(os3));
        assertTrue(ts4.isAssignableFrom(os4));
        assertTrue(!ts4.isAssignableFrom(os6));
        
        assertTrue(!ts5.isAssignableFrom(os1));
        assertTrue(!ts5.isAssignableFrom(os3));
        assertTrue(ts5.isAssignableFrom(os4));
        assertTrue(!ts5.isAssignableFrom(os6));
        
        assertTrue(!ts6.isAssignableFrom(os1));
        assertTrue(!ts6.isAssignableFrom(os3));
        assertTrue(ts6.isAssignableFrom(os4));
        assertTrue(!ts6.isAssignableFrom(os6));
        
        assertTrue(!ts7.isAssignableFrom(os1));
        assertTrue(!ts7.isAssignableFrom(os3));
        assertTrue(ts7.isAssignableFrom(os4));
        assertTrue(ts7.isAssignableFrom(os6));
        
        assertTrue(!ts8.isAssignableFrom(os1));
        assertTrue(!ts8.isAssignableFrom(os3));
        assertTrue(ts8.isAssignableFrom(os4));
        assertTrue(ts8.isAssignableFrom(os6));
        
        assertTrue(ts9.isAssignableFrom(os7));
        
        assertTrue(!ts10.isAssignableFrom(os7));
        
        assertTrue(!ts11.isAssignableFrom(os7));
        
        assertTrue(!ts12.isAssignableFrom(os7));
        
    }
    
}
