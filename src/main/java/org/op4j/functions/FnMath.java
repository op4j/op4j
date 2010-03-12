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

    
    private static final FnMathOfBigDecimal OF_BIG_DECIMAL = new FnMathOfBigDecimal();
    private static final FnMathOfBigInteger OF_BIG_INTEGER = new FnMathOfBigInteger();
    private static final FnMathOfDouble OF_DOUBLE = new FnMathOfDouble();
    private static final FnMathOfFloat OF_FLOAT = new FnMathOfFloat();
    private static final FnMathOfInteger OF_INTEGER = new FnMathOfInteger();
    private static final FnMathOfLong OF_LONG = new FnMathOfLong();
    private static final FnMathOfShort OF_SHORT = new FnMathOfShort();
    
    
    
    
    public static FnMathOfBigDecimal ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FnMathOfBigInteger ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FnMathOfDouble ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FnMathOfFloat ofFloat() {
        return OF_FLOAT;
    }
    
    public static FnMathOfInteger ofInteger() {
        return OF_INTEGER;
    }
    
    public static FnMathOfLong ofLong() {
        return OF_LONG;
    }
    
    public static FnMathOfShort ofShort() {
        return OF_SHORT;
    }

    
    private FnMath() {
        super();
    }
    
}
