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

package org.op4j.functions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Locale;


/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ConvertToBigInteger {

    
    private static FromString FROM_STRING = new FromString();

    
    private ConvertToBigInteger() {
        super();
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
    
    
    
    
    
    
    static final BigInteger internalFromNumber(final Number number) {
        if (number instanceof BigInteger) {
            return new BigInteger(((BigInteger)number).toByteArray());
        } else if (number instanceof BigDecimal) {
            return ((BigDecimal)number).toBigInteger();
        } else if (number instanceof Double) {
            return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
        } else if (number instanceof Float) {
            return BigDecimal.valueOf(number.doubleValue()).toBigInteger();
        }
        return BigInteger.valueOf(number.longValue());
    }
    
    
    static final BigInteger internalFromString(final String string) {
        return new BigInteger(string);
    }
    
    
    static final BigInteger internalFromString(final String string, final int radix) {
        return new BigInteger(string, radix);
    }

    
    
    
    public static final class FromNumber extends ConvertToNonDecimalNumber.FromNumber<BigInteger> {

        public FromNumber() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return ConvertToBigInteger.internalFromNumber(number);
        }

        @Override
        protected BigInteger fromString(final String string) {
            return ConvertToBigInteger.internalFromString(string);
        }
        
    }
  
    
    
    
    public static final class FromBoolean extends ConvertToNumber.FromBoolean<BigInteger> {

        public FromBoolean() {
            super();
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return ConvertToBigInteger.internalFromNumber(number);
        }

        @Override
        protected BigInteger fromString(final String string) {
            return ConvertToBigInteger.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromString extends ConvertToNonDecimalNumber.FromString<BigInteger> {

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
        protected BigInteger fromNumber(final Number number) {
            return ConvertToBigInteger.internalFromNumber(number);
        }

        @Override
        protected BigInteger fromString(final String string) {
            return ConvertToBigInteger.internalFromString(string);
        }

        @Override
        protected BigInteger fromString(final String string, final int withRadix) {
            return ConvertToBigInteger.internalFromString(string, withRadix);
        }
        
    }
    
    
    
    
    public static final class FromFloat extends ConvertToNonDecimalNumber.FromFloat<BigInteger> {

        public FromFloat(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return ConvertToBigInteger.internalFromNumber(number);
        }

        @Override
        protected BigInteger fromString(final String string) {
            return ConvertToBigInteger.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromDouble extends ConvertToNonDecimalNumber.FromDouble<BigInteger> {

        public FromDouble(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return ConvertToBigInteger.internalFromNumber(number);
        }

        @Override
        protected BigInteger fromString(final String string) {
            return ConvertToBigInteger.internalFromString(string);
        }
        
    }
    
    
    
    
    public static final class FromBigDecimal extends ConvertToNonDecimalNumber.FromBigDecimal<BigInteger> {

        public FromBigDecimal(final RoundingMode roundingMode) {
            super(roundingMode);
        }

        @Override
        protected BigInteger fromNumber(final Number number) {
            return ConvertToBigInteger.internalFromNumber(number);
        }

        @Override
        protected BigInteger fromString(final String string) {
            return ConvertToBigInteger.internalFromString(string);
        }
        
    }
    
}
