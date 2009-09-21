package org.op4j.type.testtypes;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class TestType3<Z,Y extends Number,X extends Comparable<? super Integer>&Serializable> 
        implements Map<Integer[],Y>, Serializable {

    private static final long serialVersionUID = -5810998990292352043L;

    public void clear() {
        
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public Set<java.util.Map.Entry<Integer[], Y>> entrySet() {
        return null;
    }

    public Y get(Object key) {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public Set<Integer[]> keySet() {
        return null;
    }

    public Y put(Integer[] key, Y value) {
        return null;
    }

    public void putAll(Map<? extends Integer[], ? extends Y> m) {
        
    }

    public Y remove(Object key) {
        return null;
    }

    public int size() {
        return 0;
    }

    public Collection<Y> values() {
        return null;
    }

    
    
}
