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
public class ToLong {

    
    private static FromNumber FROM_NUMBER = new FromNumber();
    private static FromBoolean FROM_BOOLEAN = new FromBoolean();
    private static FromString FROM_STRING = new FromString();

    
    private ToLong() {
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
    
    
    
    
    
    
    static final Long internalFromNumber(final Number number) {
        return Long.valueOf(number.longValue());
    }
    
    
    static final Long internalFromString(final String string) {
        return Long.valueOf(string);
    }
    
    
    static final Long internalFromString(final String string, final int radix) {
        return Long.valueOf(string, radix);
    }

    
    
    
    public static final class FromNumber extends ToNonDecimalNumber.FromNumber<Long> {

        public FromNumber() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return ToLong.internalFromNumber(number);
        }

        @Override
        protected Long fromString(final String string) {
            return ToLong.internalFromString(string);
        }
        
    }
  
    
    
    
    public static final class FromBoolean extends ToNumber.FromBoolean<Long> {

        public FromBoolean() {
            super();
        }

        @Override
        protected Long fromNumber(final Number number) {
            return ToLong.internalFromNumber(number);
        }

        @Override
        protected Long fromString(final String string) {
            return ToLong.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromString extends ToNonDecimalNumber.FromString<Long> {

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
        protected Long fromNumber(final Number number) {
            return ToLong.internalFromNumber(number);
        }

        @Override
        protected Long fromString(final String string) {
            return ToLong.internalFromString(string);
        }

        @Override
        protected Long fromString(final String string, final int withRadix) throws Exception {
            return ToLong.internalFromString(string, withRadix);
        }
        
    }
    
    
    
    
    public static final class FromFloat extends ToNonDecimalNumber.FromFloat<Long> {

        public FromFloat(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected Long fromNumber(final Number number) {
            return ToLong.internalFromNumber(number);
        }

        @Override
        protected Long fromString(final String string) {
            return ToLong.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromDouble extends ToNonDecimalNumber.FromDouble<Long> {

        public FromDouble(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected Long fromNumber(final Number number) {
            return ToLong.internalFromNumber(number);
        }

        @Override
        protected Long fromString(final String string) {
            return ToLong.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromBigDecimal extends ToNonDecimalNumber.FromBigDecimal<Long> {

        public FromBigDecimal(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected Long fromNumber(final Number number) {
            return ToLong.internalFromNumber(number);
        }

        @Override
        protected Long fromString(final String string) {
            return ToLong.internalFromString(string);
        }
        
    }
    
}
