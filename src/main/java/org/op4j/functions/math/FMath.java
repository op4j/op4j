/*
 * =============================================================================
 * 
 *   Copyright (c) 2008, The OP4J team (http://www.op4j.org)
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

package org.op4j.functions.math;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 */
public final class FMath {

    
    private static final FMathBigDecimal OF_BIG_DECIMAL = new FMathBigDecimal();
    private static final FMathBigInteger OF_BIG_INTEGER = new FMathBigInteger();
    private static final FMathDouble OF_DOUBLE = new FMathDouble();
    private static final FMathFloat OF_FLOAT = new FMathFloat();
    private static final FMathInteger OF_INTEGER = new FMathInteger();
    private static final FMathLong OF_LONG = new FMathLong();
    private static final FMathShort OF_SHORT = new FMathShort();
    
    
    
    
    public static FMathBigDecimal ofBigDecimal() {
        return OF_BIG_DECIMAL;
    }
    
    public static FMathBigInteger ofBigInteger() {
        return OF_BIG_INTEGER;
    }
    
    public static FMathDouble ofDouble() {
        return OF_DOUBLE;
    }
    
    public static FMathFloat ofFloat() {
        return OF_FLOAT;
    }
    
    public static FMathInteger ofInteger() {
        return OF_INTEGER;
    }
    
    public static FMathLong ofLong() {
        return OF_LONG;
    }
    
    public static FMathShort ofShort() {
        return OF_SHORT;
    }

    
    private FMath() {
        super();
    }
    
}
