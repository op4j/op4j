package org.op4j.typedef;


import org.op4j.type.testtypes.TestType3;
import org.op4j.typedef.TypeDefs;

import junit.framework.TestCase;

public class TypeDefsTest extends TestCase {
    
    public void testA() throws Exception {
        
    }

    
    public void atestForClass() throws Exception {
        
        System.out.println(TypeDefs.forClass(String.class));
        System.out.println(TypeDefs.forClass(TestType3.class));
        
    }
    
}
