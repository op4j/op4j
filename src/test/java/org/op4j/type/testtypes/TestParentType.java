package org.op4j.type.testtypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestParentType <X> implements TestTypeInt<X,X>, Serializable {
    
    private static final long serialVersionUID = -4818307702211559165L;
    
    private List<X> list = new ArrayList<X>();
    private Map<X,X> map = new HashMap<X,X>();
    
    public TestParentType() {
        super();
    }
    
    public void add(X element) {
        this.list.add(element);
    }

    public Iterator<X> iterator() {
        return this.list.iterator();
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object key) {
        return this.map.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return this.map.containsValue(value);
    }

    public Set<java.util.Map.Entry<X, X>> entrySet() {
        return this.map.entrySet();
    }

    public X get(Object key) {
        return this.map.get(key);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    public Set<X> keySet() {
        return this.map.keySet();
    }

    public X put(X key, X value) {
        return this.map.put(key, value);
    }

    public void putAll(Map<? extends X, ? extends X> m) {
        this.map.putAll(m);
    }

    public X remove(Object key) {
        return this.map.remove(key);
    }

    public int size() {
        return this.map.size();
    }

    public Collection<X> values() {
        return this.map.values();
    }
    
}
