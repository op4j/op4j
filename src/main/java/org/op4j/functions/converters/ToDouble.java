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

package org.op4j.functions.converters;

import java.math.RoundingMode;
import java.util.Locale;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
public final class ToDouble {

    
    private static FromNumber FROM_NUMBER = new FromNumber();
    private static FromBoolean FROM_BOOLEAN = new FromBoolean();
    private static FromString FROM_STRING = new FromString();

    
    
    private ToDouble() {
        super();
    }

    
    
    public static final FromNumber fromNumber() {
        return FROM_NUMBER;
    }
    
    public static final FromNumber fromNumber(final int scale, final RoundingMode roundingMode) {
        return new FromNumber(scale, roundingMode);
    }
  
    
    
    
    public static final FromBoolean fromBoolean() {
        return FROM_BOOLEAN;
    }
    
    
    
    
    public static final FromString fromString() {
        return FROM_STRING;
    }
    
    public static final FromString fromString(final Locale locale) {
        return new FromString(locale);
    }
    
    public static final FromString fromString(final String locale) {
        return new FromString(locale);
    }
    
    public static final FromString fromString(final DecimalPoint decimalPoint) {
        return new FromString(decimalPoint);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode) {
        return new FromString(scale, roundingMode);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode, final Locale locale) {
        return new FromString(scale, roundingMode, locale);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode, final String locale) {
        return new FromString(scale, roundingMode, locale);
    }
    
    public static final FromString fromString(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new FromString(scale, roundingMode, decimalPoint);
    }
    
    
    
    
    
    
    static final Double internalFromNumber(final Number number) {
        return Double.valueOf(number.doubleValue());
    }
    
    
    static final Double internalFromString(final String string) {
        return Double.valueOf(string);
    }

    
    
    
    public static final class FromNumber extends ToDecimalNumber.FromNumber<Double> {

        public FromNumber() {
            super();
        }

        public FromNumber(int scale, RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        @Override
        protected Double fromNumber(final Number number) {
            return ToDouble.internalFromNumber(number);
        }

        @Override
        protected Double fromString(final String string) {
            return ToDouble.internalFromString(string);
        }
        
    }
  
    
    
    
    public static final class FromBoolean extends ToNumber.FromBoolean<Double> {

        public FromBoolean() {
            super();
        }

        @Override
        protected Double fromNumber(final Number number) {
            return ToDouble.internalFromNumber(number);
        }

        @Override
        protected Double fromString(final String string) {
            return ToDouble.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromString extends ToDecimalNumber.FromString<Double> {

        public FromString() {
            super();
        }

        public FromString(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public FromString(final Locale locale) {
            super(locale);
        }

        public FromString(final int scale, final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(scale, roundingMode, decimalPoint);
        }

        public FromString(final int scale, final RoundingMode roundingMode, final Locale locale) {
            super(scale, roundingMode, locale);
        }

        public FromString(final int scale, final RoundingMode roundingMode, final String locale) {
            super(scale, roundingMode, locale);
        }

        public FromString(final int scale, final RoundingMode roundingMode) {
            super(scale, roundingMode);
        }

        public FromString(final String locale) {
            super(locale);
        }

        @Override
        protected Double fromNumber(final Number number) {
            return ToDouble.internalFromNumber(number);
        }

        @Override
        protected Double fromString(final String string) {
            return ToDouble.internalFromString(string);
        }
        
    }
    
    
    
}
