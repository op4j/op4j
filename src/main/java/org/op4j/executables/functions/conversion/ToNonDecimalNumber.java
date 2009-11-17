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

package org.op4j.executables.functions.conversion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.LocaleUtils;

/**
 * 
 * @since 1.0
 * 
 * @author Daniel Fern&aacute;ndez
 *
 */
final class ToNonDecimalNumber {

    
    private ToNonDecimalNumber() {
        super();
    }
    
    
    static abstract class FromNumber<X extends Number> extends ToNumber.FromNumber<X> {

        public FromNumber() {
            super();
        }

        @Override
        protected X numberExecute(Number object) throws Exception {
            // This will never be reached
            throw new IllegalStateException("Delegated execution on non decimal number!");
        }
        
    }
    
    static abstract class FromString<X extends Number> extends ToNumber.FromString<X> {

        private static enum ExecType 
                { FROM_STRING_RADIX, FROM_STRING_ROUNDINGMODE, FROM_STRING_ROUNDINGMODE_LOCALE, FROM_STRING_ROUNDINGMODE_DECIMALPOINT } 
            
        private ExecType execType = null;
        private Integer radix = null;
        private RoundingMode roundingMode = null;
        private DecimalFormat decimalFormat = null;
        private DecimalPoint decimalPoint = null;
        
        
        public FromString() {
            super();
        }

        
        public FromString(final DecimalPoint decimalPoint) {
            super(decimalPoint);
        }

        
        public FromString(final Locale locale) {
            super(locale);
        }

        
        public FromString(final String locale) {
            super(locale);
        }

        
        public FromString(final Integer radix) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_RADIX;
            this.radix = radix;
        }

        
        public FromString(final RoundingMode roundingMode) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE;
            this.roundingMode = roundingMode;
        }

        
        public FromString(final RoundingMode roundingMode, final Locale locale) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE_LOCALE;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public FromString(final RoundingMode roundingMode, final String locale) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE_LOCALE;
            this.roundingMode = roundingMode;
            this.decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(LocaleUtils.toLocale(locale));
            this.decimalFormat.setParseBigDecimal(true);
        }

        
        public FromString(final RoundingMode roundingMode, final DecimalPoint decimalPoint) {
            super(ToNumber.Delegated.DELEGATED);
            this.execType = ExecType.FROM_STRING_ROUNDINGMODE_DECIMALPOINT;
            this.roundingMode = roundingMode;
            this.decimalPoint = decimalPoint;
        }



        @Override
        public X numberExecute(final String object) throws Exception {
            switch (this.execType) {
                case FROM_STRING_RADIX:
                    return fromString(object, this.radix.intValue());
                case FROM_STRING_ROUNDINGMODE:
                    return fromString(object, this.roundingMode);
                case FROM_STRING_ROUNDINGMODE_LOCALE:
                    return fromNumber(this.decimalFormat.parse(object), this.roundingMode);
                case FROM_STRING_ROUNDINGMODE_DECIMALPOINT:
                    try {
                        return fromString(rebuildNumberString(object, this.decimalPoint), this.roundingMode);
                    } catch (NumberFormatException e) {
                        // original input could have been modified, so raise the right exception
                        throw new NumberFormatException("For input string: \"" + object + "\"");
                    }
            }
            // This will never be reached
            throw new IllegalStateException("Execution type did not match!");
        }

        
        
        
        protected abstract X fromString(final String string, final int withRadix) throws Exception;
        
        
        
        protected final X fromNumber(
                final Number number, final RoundingMode withRoundingMode) throws Exception {
            BigDecimal bigDecimal = null;
            if (number instanceof BigDecimal) {
                bigDecimal = (BigDecimal) number;
            } else if (number instanceof BigInteger) {
                bigDecimal = new BigDecimal((BigInteger) number);
            } else {
                bigDecimal = new BigDecimal(number.doubleValue());
            }
            bigDecimal = bigDecimal.setScale(0, withRoundingMode); // scale == 0
            return fromNumber(bigDecimal);
        }

        
        protected final X fromString(
                final String string, final RoundingMode withRoundingMode) throws Exception {
            return fromNumber(new BigDecimal(string), withRoundingMode);
        }
        
    }
    
    
    
    
    
    static abstract class FromFloat<X extends Number> extends ToNumber.ToNumberFunction<X, Float> {

        private final RoundingMode roundingMode;
        
        
        public FromFloat(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
        }

        
        public X execute(Float object) throws Exception {
            BigDecimal bigDecimal = 
                new BigDecimal(object.doubleValue());
            bigDecimal = bigDecimal.setScale(0, this.roundingMode);
            return fromNumber(bigDecimal);
        }
        
    }
    
    
    
    
    
    static abstract class FromDouble<X extends Number> extends ToNumber.ToNumberFunction<X, Double> {

        private final RoundingMode roundingMode;
        
        
        public FromDouble(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
        }

        
        public X execute(Double object) throws Exception {
            BigDecimal bigDecimal = 
                new BigDecimal(object.doubleValue());
            bigDecimal = bigDecimal.setScale(0, this.roundingMode);
            return fromNumber(bigDecimal);
        }
        
    }
    
    
    
    
    
    static abstract class FromBigDecimal<X extends Number> extends ToNumber.ToNumberFunction<X, BigDecimal> {

        private final RoundingMode roundingMode;
        
        
        public FromBigDecimal(final RoundingMode roundingMode) {
            super();
            this.roundingMode = roundingMode;
        }


        public X execute(BigDecimal object) throws Exception {
            return fromNumber(object.setScale(0, this.roundingMode));
        }
        
    }
    
}
