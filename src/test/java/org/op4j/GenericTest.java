package org.op4j;

import java.util.List;
import java.util.Map;

public class GenericTest<E> {

    
    private final E att;
    
    public GenericTest(E att) {
        this.att = att;
    }
    
    public E get() {
        return this.att;
    }
    
    public Map<Integer,List<?>> getMap() {
        return null;
    }
    
    
    public static void main(String[] args) {
        
        try {
            
            GenericTest<?> t = new GenericTest<String>("Daniel");
            
            String str = (String) t.get();

            Object obj = "hello";
           
            Integer str2 = (Integer) null;
            
            System.out.println(str2);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
