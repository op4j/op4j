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
public final class ToInteger {

    
    private static FromNumber FROM_NUMBER = new FromNumber();
    private static FromBoolean FROM_BOOLEAN = new FromBoolean();
    private static FromString FROM_STRING = new FromString();

    
    
    private ToInteger() {
        super();
    }

    
    
    public static final FromNumber fromNumber() {
        return FROM_NUMBER;
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
    
    public static final FromString frtomString(final String locale) {
        return new FromString(locale);
    }
    
    public static final FromString fromString(final Integer radix) {
        return new FromString(radix);
    }
    
    public static final FromString fromString(final DecimalPoint decimalPoint) {
        return new FromString(decimalPoint);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode) {
        return new FromString(roundingMode);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode, final Locale locale) {
        return new FromString(roundingMode, locale);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode, final String locale) {
        return new FromString(roundingMode, locale);
    }
    
    public static final FromString fromString(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
        return new FromString(roundingMode, decimalPoint);
    }
    
    
    
    
    public static final FromFloat fromFloat(final RoundingMode roundingMode) {
        return new FromFloat(roundingMode);
    }
    
    
    
    
    public static final FromDouble fromDouble(final RoundingMode roundingMode) {
        return new FromDouble(roundingMode);
    }
    
    
    public static final FromBigDecimal fromBigDecimal(final RoundingMode roundingMode) {
        return new FromBigDecimal(roundingMode);
    }
    
    
    
    
    
    
    static final Integer internalFromNumber(final Number number) {
        return Integer.valueOf(number.intValue());
    }
    
    
    static final Integer internalFromString(final String string) {
        return Integer.valueOf(string);
    }
    
    
    static final Integer internalFromString(final String string, final int radix) {
        return Integer.valueOf(string, radix);
    }

    
    
    
    public static final class FromNumber extends ToNonDecimalNumber.FromNumber<Integer> {

        public FromNumber() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return ToInteger.internalFromNumber(number);
        }

        @Override
        protected Integer fromString(final String string) {
            return ToInteger.internalFromString(string);
        }
        
    }
  
    
    
    
    public static final class FromBoolean extends ToNumber.FromBoolean<Integer> {

        public FromBoolean() {
            super();
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return ToInteger.internalFromNumber(number);
        }

        @Override
        protected Integer fromString(final String string) {
            return ToInteger.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromString extends ToNonDecimalNumber.FromString<Integer> {

        public FromString() {
            super();
        }

        public FromString(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        public FromString(final Integer radix) {
            super(radix);
        }

        public FromString(final Locale locale) {
            super(locale);
        }

        public FromString(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(roundingMode, decimalPoint);
        }

        public FromString(final RoundingMode roundingMode, final Locale locale) {
            super(roundingMode, locale);
        }

        public FromString(final RoundingMode roundingMode, final String locale) {
            super(roundingMode, locale);
        }

        public FromString(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        public FromString(final String locale) {
            super(locale);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return ToInteger.internalFromNumber(number);
        }

        @Override
        protected Integer fromString(final String string) {
            return ToInteger.internalFromString(string);
        }

        @Override
        protected Integer fromString(final String string, final int withRadix) {
            return ToInteger.internalFromString(string, withRadix);
        }
        
    }
    
    
    
    
    public static final class FromFloat extends ToNonDecimalNumber.FromFloat<Integer> {

        public FromFloat(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return ToInteger.internalFromNumber(number);
        }

        @Override
        protected Integer fromString(final String string) {
            return ToInteger.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromDouble extends ToNonDecimalNumber.FromDouble<Integer> {

        public FromDouble(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return ToInteger.internalFromNumber(number);
        }

        @Override
        protected Integer fromString(final String string) {
            return ToInteger.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromBigDecimal extends ToNonDecimalNumber.FromBigDecimal<Integer> {

        public FromBigDecimal(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected Integer fromNumber(final Number number) {
            return ToInteger.internalFromNumber(number);
        }

        @Override
        protected Integer fromString(final String string) {
            return ToInteger.internalFromString(string);
        }
        
    }
    
}
