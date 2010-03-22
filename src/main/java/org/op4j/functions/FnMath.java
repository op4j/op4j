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

package org.op4j.functions;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FnMath {

    
    private static final FnBigDecimal OF_BIG_DECIMAL = new FnBigDecimal();
    private static final FnBigInteger OF_BIG_INTEGER = new FnBigInteger();
    private static final FnDouble OF_DOUBLE = new FnDouble();
    private static final FnFloat OF_FLOAT = new FnFloat();
    private static final FnInteger OF_INTEGER = new FnInteger();
    private static final FnLong OF_LONG = new FnLong();
    private static final FnShort OF_SHORT = new FnShort();
    
    
    
    
    public static FnBigDecimal ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FnBigInteger ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FnDouble ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FnFloat ofFloat() {
        return OF_FLOAT;
    }
    
    public static FnInteger ofInteger() {
        return OF_INTEGER;
    }
    
    public static FnLong ofLong() {
        return OF_LONG;
    }
    
    public static FnShort ofShort() {
        return OF_SHORT;
    }

    
    private FnMath() {
        super();
    }
    
}
