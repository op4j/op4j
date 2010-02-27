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

    
    private static final FnMathBigDecimal OF_BIG_DECIMAL = new FnMathBigDecimal();
    private static final FnMathBigInteger OF_BIG_INTEGER = new FnMathBigInteger();
    private static final FnMathDouble OF_DOUBLE = new FnMathDouble();
    private static final FnMathFloat OF_FLOAT = new FnMathFloat();
    private static final FnMathInteger OF_INTEGER = new FnMathInteger();
    private static final FnMathLong OF_LONG = new FnMathLong();
    private static final FnMathShort OF_SHORT = new FnMathShort();
    
    
    
    
    public static FnMathBigDecimal ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FnMathBigInteger ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FnMathDouble ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FnMathFloat ofFloat() {
        return OF_FLOAT;
    }
    
    public static FnMathInteger ofInteger() {
        return OF_INTEGER;
    }
    
    public static FnMathLong ofLong() {
        return OF_LONG;
    }
    
    public static FnMathShort ofShort() {
        return OF_SHORT;
    }

    
    private FnMath() {
        super();
    }
    
}
