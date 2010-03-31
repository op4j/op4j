/*
 * =============================================================================
 * 
 *   Copyright (c) 2010, The OP4J team (http://www.op4j.org)
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

package org.op4j.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public class OgnlExpressionMap implements Serializable {

    private static final long serialVersionUID = -8731592690564020322L;
    

    public static final int SIZE = 20;

    private final LinkedHashMap<String, Object> map;

    
    
    public OgnlExpressionMap() {
        
        this.map = new LinkedHashMap<String,Object>(SIZE + 2, 1.0f, true) {

            private static final long serialVersionUID = 5321581238L;

            @Override
            protected boolean removeEldestEntry(final Map.Entry<String,Object> eldest) {
                return size() > OgnlExpressionMap.SIZE;
            }
            
        };
        
    }

    
    public synchronized Object get(final String key) {
        return this.map.get(key);
    }

    public synchronized void put(final String key, final Object value) {
        this.map.put(key, value);
    }
    

}
